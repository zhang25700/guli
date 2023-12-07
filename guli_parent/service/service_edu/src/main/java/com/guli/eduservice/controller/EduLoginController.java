package com.guli.eduservice.controller;

import com.guli.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author zzy
 * @description: 前端页面登录响应数据
 * @date 2023/11/28 19:47
 */

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {
    @PostMapping("/login")
    public R login() {
        return R.ok().data("token", "admin-token");
    }

    @GetMapping("/info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "zzy").data("introduction", "I am Iron Man")
                .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
