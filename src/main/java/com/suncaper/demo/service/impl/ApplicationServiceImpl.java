package com.suncaper.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.Constant;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.common.SecurityUtils;
import com.suncaper.demo.common.utls.ExcelUtil;
import com.suncaper.demo.common.utls.FormatUtils;
import com.suncaper.demo.entity.*;
import com.suncaper.demo.entity.dto.ApplicationDTO;
import com.suncaper.demo.entity.vo.StatisticsVO;
import com.suncaper.demo.mapper.ApplicationMapper;
import com.suncaper.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private KnrdService knrdService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private FlowSettingService flowSettingService;
    @Autowired
    private AuditHistoryService auditHistoryService;
    @Override
    public void insert(Application application) {
        //application只有一个字段
        //获取当前用户的sn
        User curUser = SecurityUtils.getCurUser();
        String sn = curUser.getSn();
        //根据user获取困难认定
        Knrd knrd = knrdService.selectByUsert(curUser);
        //根据user【session】中获取基本数据
        Student student = studentService.selectByUser(curUser);
        //获取当前批次id
        Batch curBatch = batchService.getCurBatch();
        application.setBatchId(curBatch.getId())
                .setSn(student.getSn())
                .setName(student.getName())
                .setGender(Constant.GENDER_MALE.equals(student.getGender())?"M":"F")
                .setApplyDate(new Date())
                .setCollegeSn(student.getCollegeCode())
                .setCollegeName(student.getCollege())
                .setMajorName(student.getMajor())
                .setMajorSn(student.getMajorCode())
                .setClassName(student.getClazz())
                .setClassSn(student.getClassCode())
                .setDifficultyLevel(FormatUtils.difficultyUtils(knrd.getPovertyLevel()))
                .setCurrentNodeCode(Constant.ROLE_NODE_1)
                .setStatus(Constant.STATUS_DSH);
        applicationMapper.insertSelective(application);

    }

    @Override
    public Boolean getCurApp() {
        //获取当前用户的sn
        User curUser = SecurityUtils.getCurUser();
        //获取当前批次id
        Batch curBatch = batchService.getCurBatch();
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andSnEqualTo(curUser.getSn()).andBatchIdEqualTo(curBatch.getId());
        List<Application> applications = applicationMapper.selectByExample(example);
        return applications.size()!=0;
    }

    /**
     * 申请详情
     * @param applicationDTO
     * @return
     */
    @Override
    public PageInfo<Application> listBySn(ApplicationDTO applicationDTO) {
        //获取当前用户的sn
        User curUser = SecurityUtils.getCurUser();
        List<Application> applications = new ArrayList<>();
        //xuesheng 查 个人
        if(Constant.ROLE_ID_SUTDENT.equals(curUser.getRoleId())){
            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andSnEqualTo(curUser.getSn());
            applicationExample.setOrderByClause("id desc");
            //处理数据字典数据--汉化
            return this.listMachine(applications,applicationDTO,applicationExample);
        }
        //学院用户
        if(Constant.ROLE_ID_COLLEGE.equals(curUser.getRoleId())){
            TeacherExample example = new TeacherExample();
            example.createCriteria().andUsersnEqualTo(curUser.getSn()).andRoleidEqualTo(Constant.ROLE_ID_COLLEGE);
            List<Teacher> teachers = teacherService.selectByExample(example);
            List<String> orgSns = teachers.stream().map(x -> x.getOrganizationsn()).collect(Collectors.toList());
            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andCollegeSnIn(orgSns);
            applicationExample.setOrderByClause("id desc");
            return this.listMachine(applications,applicationDTO,applicationExample);
        }
        //学校查询所有
        if(Constant.ROLE_ID_SCHOOL.equals(curUser.getRoleId())){
            return this.listMachine(applications,applicationDTO,null);
        }
        return null;
    }
    @Override
    public PageInfo<Application> listMachine(List<Application> applications,ApplicationDTO applicationDTO,ApplicationExample example) {
        //分页器
        PageHelper.startPage(applicationDTO.getPageNum(),applicationDTO.getPageSize());
        applications=applicationMapper.selectByExample(example);
        //pageinfo 在没有查询操作的时候默认 返回所有的 集合
        PageInfo<Application> pageInfo = new PageInfo<>(applications);
        //处理数据字典数据--汉化
        applications.stream().forEach(x->{
            x.setBatch(batchService.selectByPrimaryKey(x.getBatchId()));
            x.setDifValue(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE,x.getDifficultyLevel()));
            x.setStatusValue(dictionaryService.getNameByTypeAndValue(Constant.STATUS_TYPE,x.getStatus()));
        });
        return pageInfo;
    }

    @Override
    public StatisticsVO statistics(Application application) {
        if(application.getCollegeName()!=null&&!"".equals(application.getCollegeName())){
            return applicationMapper.statistics(application.getCollegeName());
        }
        return applicationMapper.statisticsAll();
    }

    @Override
    public List<Application> collegeStatistics() {
        return applicationMapper.selectCollegeName();
    }

    @Override
    public JsonResult details(Long id) {
        Application application = applicationMapper.selectByPrimaryKey(id);

        return   JsonResult.ok(application);
    }

    @Override
    public void update(Application application) {
        //获取当前用户的当前申请记录
        User curUser = SecurityUtils.getCurUser();
        Batch curBatch = batchService.getCurBatch();
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andBatchIdEqualTo(curBatch.getId()).andSnEqualTo(curUser.getSn());
        List<Application> applications = applicationMapper.selectByExample(example);
        Application curApp = applications.size()>0?applications.get(0):null;
        application.setId(curApp.getId());
        //3个值  id,skuId productId
        applicationMapper.updateByPrimaryKeySelective(application);
    }

    @Override
    public void export(HttpServletResponse response) {
        //设置Content-Type
        response.setContentType("application/vnd.ms-excel");
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment; filename=okk.xls");
        //获取所有申请
        List<Application> applications = listBySnY();
        //将文件的流放进response
        try {
            ExcelUtil.exportApplication(response,applications);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Application> listBySnY() {
        //获取当前用户sn
        User curUser = SecurityUtils.getCurUser();
        List<Application> applications = new ArrayList<>();
        if(Constant.ROLE_ID_SUTDENT.equals(curUser.getRoleId())){
            //学生查询个人
            ApplicationExample example = new ApplicationExample();
            example.createCriteria().andSnEqualTo(curUser.getSn());
            applications = applicationMapper.selectByExample(example);
        }
        if (Constant.ROLE_ID_COLLEGE.equals(curUser.getRoleId())){
            //学院查询所属
            TeacherExample teacherExample = new TeacherExample();
            //在教师表通过教师sn和roleId为4(4表示辅导员)的所有组织
            teacherExample.createCriteria().andUsersnEqualTo(curUser.getSn()).andRoleidEqualTo(Constant.ROLE_ID_COLLEGE);
            List<Teacher> teachers= teacherService.selectByExample(teacherExample);
            List<String> orgSns = teachers.stream().map(x -> x.getOrganizationsn()).collect(Collectors.toList());
            ApplicationExample example = new ApplicationExample();
            example.createCriteria().andCollegeSnIn(orgSns);
            applications = applicationMapper.selectByExample(example);
        }
        if(Constant.ROLE_ID_SCHOOL.equals(curUser.getRoleId())){
            //学校查询所有
            applications = applicationMapper.selectByExample(null);
        }
        applications.stream().forEach(x->{
            x.setBatch(batchService.selectByPrimaryKey(x.getBatchId()));
            x.setDifValue(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE,x.getDifficultyLevel()));
            x.setStatusValue(dictionaryService.getNameByTypeAndValue(Constant.STATUS_TYPE,x.getStatus()));
        });
        return applications;
    }
    @Override
    public PageInfo<Application> waitAudit(ApplicationDTO applicationDTO) {

        //获取当前用户的sn
        User curUser = SecurityUtils.getCurUser();
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        TeacherExample example = new TeacherExample();
        if(Constant.ROLE_ID_TEACHER.equals(curUser.getRoleId())){
            //获取辅导员的所zaide 班级
            //在教师表通过教师sn和role id为4的所有组织
            example.createCriteria().andUsersnEqualTo(curUser.getSn()).andRoleidEqualTo(Constant.ROLE_ID_TEACHER);
            List<Teacher> teachers = teacherService.selectByExample(example);
            //将组织遍历，创建组织集合
            List<String> orgSns = teachers.stream().map(x -> x.getOrganizationsn()).collect(Collectors.toList());
            //辅导员带我审核--节点为1且是待审核j   将带班级sn的辅导员传入查询条件
            criteria.andCurrentNodeCodeEqualTo(Constant.ROLE_NODE_1).andMajorSnIn(orgSns);
        }
        if(Constant.ROLE_ID_COLLEGE.equals(curUser.getRoleId())){
            //获取辅导员的所zaide 班级
            //在教师表通过教师sn和role id为4的所有组织
            example.createCriteria().andUsersnEqualTo(curUser.getSn()).andRoleidEqualTo(Constant.ROLE_ID_COLLEGE);
            List<Teacher> teachers = teacherService.selectByExample(example);
            List<String> orgSns = teachers.stream().map(x -> x.getOrganizationsn()).collect(Collectors.toList());
            //学院带我审核--节点为1且是待审核
            criteria.andCurrentNodeCodeEqualTo(Constant.ROLE_NODE_2).andCollegeSnIn(orgSns);
        }else if(Constant.ROLE_ID_SCHOOL.equals(curUser.getRoleId())){
            //学校用户
            criteria.andCurrentNodeCodeEqualTo(Constant.ROLE_NODE_3);
        }
        //节点是待审核
        criteria.andStatusEqualTo(Constant.STATUS_DSH);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        //处理数据字典数据--汉化
        applications.stream().forEach(x->{
            x.setBatch(batchService.selectByPrimaryKey(x.getBatchId()));
            x.setDifValue(dictionaryService.getNameByTypeAndValue(Constant.DIFFICULTY_TYPE,x.getDifficultyLevel()));
            x.setStatusValue(dictionaryService.getNameByTypeAndValue(Constant.STATUS_TYPE,x.getStatus()));
        });
        //分页器
        PageHelper.startPage(applicationDTO.getPageNum(),applicationDTO.getPageSize());
        PageInfo<Application> pageInfo = new PageInfo<>(applications);
        return pageInfo;
    }

    @Override
    public void audit(AuditHistory auditHistory) {

        User curUser = SecurityUtils.getCurUser();
        auditHistory.setAuditBy(curUser.getSn());
        auditHistory.setAuditorName(curUser.getName());
        //获取审核的申请
        Application application = applicationMapper.selectByPrimaryKey(auditHistory.getApplicationId());
        auditHistory.setAuditNodeCode(application.getCurrentNodeCode());
        //获取节点名字
        String codeName = flowSettingService.getNameByCode(application.getCurrentNodeCode());
        auditHistory.setAuditNodeName(codeName);
        auditHistoryService.insert(auditHistory);
        //当前审核对当前申请有什么影响 和 对下一个节点有什么影响
        //审核结果对申请的影响
        if(Constant.STATUS_TG.equals(auditHistory.getStatus())){
            //通过 --进入下一个节点 申请状态不变
            //可以查询表的下一个节点 可以动态分配=
            //先获取下一个节点
            FlowSetting nextNode = flowSettingService.getNextNode(application.getCurrentNodeCode());
            //如果下一个节点存在 继续
            if(nextNode!=null){
                application.setCurrentNodeCode(nextNode.getNodeCode());
                if(nextNode.getNodeCode() == Constant.ROLE_NODE_4){
                    //表示当前节点为3且通过 审核通过了
                    application.setStatus(Constant.STATUS_TG);
                    application.setAuditComment(auditHistory.getAuditComment());
                }
             }
//            else{
//                //没有下一节点直接返回结果
//                application.setStatus(Constant.STATUS_TG);
//            }

        }else{
            //当前节点不变 状态便
            application.setStatus(Constant.STATUS_BTG);
            //返回意见
            application.setAuditComment(auditHistory.getAuditComment());
        }
        applicationMapper.updateByPrimaryKey(application);
    }




}
