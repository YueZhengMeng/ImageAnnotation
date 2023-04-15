package com.shou.imageannotation.service;

import com.shou.imageannotation.dao.UserDao;
import com.shou.imageannotation.po.User;
import com.shou.imageannotation.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public User getUserByID(int userID) {
        return userDao.selectUserByID(userID);
    }

    public User getUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    public int resetUsername(User user) {
        return userDao.updateUserName(user);
    }

    public int resetPassword(User user) {
        return userDao.updateUserPassword(user);
    }

    public int resetRole(User user) {
        return userDao.updateUserRole(user);
    }

    public int banUser(int userID) {
        return userDao.banUser(userID);
    }

    public int unbanUser(int userID) {
        return userDao.unbanUser(userID);
    }

    public int registerUser(User user) {
        User temp = userDao.selectUserByName(user.getUsername());
        if (temp != null) {
            return 0;
        }
        return userDao.addUser(user);
    }

    public int deleteUser(int userID) {
        return userDao.deleteUser(userID);
    }

    public User getLoginUser() {
        int userID = jwtUserDetailsService.getLoginUserId();
        return userDao.selectUserByID(userID);
    }
}
