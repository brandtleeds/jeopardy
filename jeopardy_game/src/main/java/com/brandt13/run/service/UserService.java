package com.brandt13.run.service;

import com.brandt13.run.model.User;


public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
