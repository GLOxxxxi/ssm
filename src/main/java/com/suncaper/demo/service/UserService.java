package com.suncaper.demo.service;

import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.User;

public interface UserService  {
    User login(User user);

    void insert(User u);

    boolean conformKnrd(Knrd knrd);
}
