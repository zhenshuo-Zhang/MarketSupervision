/**
 * DateTime: 2025/2/19 20:21
 * Author: LMC
 * Comments:
 **/
package com.group.marketsupervision.mapper;

import com.group.marketsupervision.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user(username, password, company_name, region, created_time) " +
            "values(#{username}, #{password}, #{companyName}, #{region}, #{createdTime})")
    void insert(User user);
}