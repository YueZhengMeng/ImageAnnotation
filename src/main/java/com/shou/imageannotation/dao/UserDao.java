package com.shou.imageannotation.dao;

import com.shou.imageannotation.po.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> selectAllUser();

    @Select("select * from user where userID=#{userID}")
    User selectUserByID(int userID);

    @Select("select * from user where username=#{username}")
    User selectUserByName(String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int addUser(User user);

    @Update("update user set username = #{username} where userID = #{userID}")
    int updateUserName(User user);

    @Update("update user set password = #{password} where userID = #{userID}")
    int updateUserPassword(User user);

    @Update("update user set role = #{role} where userID = #{userID}")
    int updateUserRole(User user);

    @Update("update user set role = 'banned' where userID = #{userID}")
    int banUser(int userID);

    @Update("update user set role = 'user' where userID = #{userID}")
    int unbanUser(int userID);

    @Delete("delete from user where userID = #{userID}")
    int deleteUser(int userID);
}
