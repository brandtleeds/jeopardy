package com.brandt13.run.mappers;

import com.brandt13.run.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

        String UPDATE_USER = "UPDATE `jeopardyGame`.`user` SET high_score = #{high_score} WHERE user_id = #{user_id}";

        @Update(UPDATE_USER)
        public int updateUser (User user);

}
