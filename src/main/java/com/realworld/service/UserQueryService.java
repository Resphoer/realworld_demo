package com.realworld.service;

import com.realworld.dto.data.UserData;
import com.realworld.mapper.user.UserReadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserQueryService {
    private UserReadService userReadService;

    public Optional<UserData> findById(String id){
        return Optional.ofNullable(userReadService.findById(id));
    }
}
