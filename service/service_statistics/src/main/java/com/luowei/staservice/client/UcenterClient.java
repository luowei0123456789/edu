package com.luowei.staservice.client;

import com.luowei.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-sso")
public interface UcenterClient {

    //查询某一天注册人数
    @GetMapping("/edusso/ucentermember/countRegister/{day}")
    public R countRegister(@PathVariable("day") String day);
}
