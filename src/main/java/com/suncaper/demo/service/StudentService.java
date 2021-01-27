package com.suncaper.demo.service;

import com.suncaper.demo.entity.Student;
import com.suncaper.demo.entity.User;

public interface StudentService {
    Student selectByUser(User user);
}
