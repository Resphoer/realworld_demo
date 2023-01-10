package com.realworld.dto.user;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("user")
@Builder
public class UpdateUserParam {
    @Builder.Default
    @Email(message = "should be an email")
    private String email = "";

    @Builder.Default private String password = "";
    @Builder.Default private String username = "";
    @Builder.Default private String bio = "";
    @Builder.Default private String image = "";
}
