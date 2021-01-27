package com.suncaper.demo.service;

import com.suncaper.demo.entity.Teacher;
import com.suncaper.demo.entity.TeacherExample;

import java.util.List;

public interface TeacherService {
    List<Teacher> selectByExample(TeacherExample example);
}
