package com.realworld.service;

import com.realworld.dto.data.ProfileData;
import com.realworld.dto.data.UserData;
import com.realworld.entity.user.User;
import com.realworld.mapper.user.UserReadService;
import com.realworld.mapper.user.UserRelationshipQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileQueryService {
    private UserReadService userReadService;
    private UserRelationshipQueryService userRelationshipQueryService;

    public Optional<ProfileData> findByUsername(String username, User currentUser){
        UserData userData = userReadService.findByUsername(username);
        if(userData == null){
            return Optional.empty();
        }else{
            ProfileData profileData =
                    new ProfileData(
                            userData.getId(),
                            userData.getUsername(),
                            userData.getBio(),
                            userData.getImage(),
                            currentUser != null
                            && userRelationshipQueryService.isUserFollowing(
                                    currentUser.getId(),userData.getId()
                            )
                    );
            return Optional.of(profileData);
        }
    }
}
