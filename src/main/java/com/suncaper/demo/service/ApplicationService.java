package com.suncaper.demo.service;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Application;
import com.suncaper.demo.entity.ApplicationExample;
import com.suncaper.demo.entity.AuditHistory;
import com.suncaper.demo.entity.dto.ApplicationDTO;
import com.suncaper.demo.entity.vo.StatisticsVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ApplicationService {
    void insert(Application application);

    Boolean getCurApp();

    PageInfo<Application>listBySn(ApplicationDTO applicationDTO);

    PageInfo<Application> waitAudit(ApplicationDTO applicationDTO);

    void audit(AuditHistory auditHistory);

    PageInfo<Application> listMachine(List<Application> applications, ApplicationDTO applicationDTO, ApplicationExample example);

    StatisticsVO statistics(Application application);

    List<Application> collegeStatistics();

    JsonResult details(Long id);

    void update(Application application);

    void export(HttpServletResponse response);

    List<Application> listBySnY();
}
