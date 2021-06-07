package com.leeseokjun.springboot.web;

import com.leeseokjun.springboot.config.auth.LoginUser;
import com.leeseokjun.springboot.config.auth.dto.SessionUser;
import com.leeseokjun.springboot.domain.user.User;
import com.leeseokjun.springboot.service.PostsService;
import com.leeseokjun.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        //전체조회 추가
        model.addAttribute("posts",postsService.findAllDesc());
        System.out.println("LoginUser : "+user.toString());
        System.out.println("session을 가져오자 : " + httpSession.getAttribute("user"));
        if(user!=null){
            model.addAttribute("testUser",user.getName());
            SessionUser sessionu=(SessionUser) httpSession.getAttribute("user");
            if(sessionu!=null)
                model.addAttribute("testUser",sessionu.getName());
        }

        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    //업데이트
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
