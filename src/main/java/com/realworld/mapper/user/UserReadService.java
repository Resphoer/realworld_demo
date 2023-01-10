package com.realworld.mapper.user;

import com.realworld.dto.data.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserReadService {
    UserData findByUsername(@Param("username") String username);

    UserData findById(@Param("id") String id);
}
