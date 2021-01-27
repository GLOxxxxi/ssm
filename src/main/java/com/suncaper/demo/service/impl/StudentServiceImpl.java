package com.suncaper.demo.service.impl;

import com.suncaper.demo.entity.Student;
import com.suncaper.demo.entity.StudentExample;
import com.suncaper.demo.entity.User;
import com.suncaper.demo.mapper.StudentMapper;
import com.suncaper.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student selectByUser(User user) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSnEqualTo(user.getSn());
        List<Student> students = studentMapper.selectByExample(studentExample);

        return students.size()>0?students.get(0):null;
    }
}
