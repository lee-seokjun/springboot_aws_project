package com.leeseokjun.springboot.config.auth.dto;

import com.leeseokjun.springboot.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        if(user!=null){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();}
    }
}
