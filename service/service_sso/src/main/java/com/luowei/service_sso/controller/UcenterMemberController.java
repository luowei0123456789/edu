package com.luowei.service_sso.controller;


import com.luowei.R;
import com.luowei.service_sso.entity.UcenterMember;
import com.luowei.service_sso.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author luowei
 * @since 2020-09-03
 */
@RestController
@RequestMapping("/servicesso/ucentermember")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;

    //登录
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token",token);
    }
}

