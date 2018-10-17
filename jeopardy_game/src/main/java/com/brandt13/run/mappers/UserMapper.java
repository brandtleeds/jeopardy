package com.brandt13.run.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

        String CREATE_USER = "INSERT INTO `jeopardyGame`.`user` (`email`,`password`,`current_score`, `high_score`) " +
                "VALUES (#{email}, #{password}, #{current_score}, #{high_score});";

        String UPDATE_HIGH_SCORE =

//        @Create(CREATE_USER)
//        User createUser(User user);



}
