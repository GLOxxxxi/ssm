package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Teacher;
import com.suncaper.demo.entity.TeacherExample;
import com.suncaper.demo.mapper.TeacherMapper;
import com.suncaper.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> selectByExample(TeacherExample example) {
        return teacherMapper.selectByExample(example);
    }
}
