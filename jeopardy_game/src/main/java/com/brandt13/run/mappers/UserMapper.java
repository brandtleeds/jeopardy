package com.brandt13.run.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

        String CREATE_USER = "INSERT INTO `jeopardyGame`.`temperatures` (`temperature`,`latitude`,`longitude`) " +
                "VALUES (#{temperature}, #{latitude}, #{longitude});";

//        @Insert(INPUT_TEMP)
//        int inputTemp(DBtempLatLong db);

}
