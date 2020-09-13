package com.luowei.service_sso.service;

import com.luowei.service_sso.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luowei.service_sso.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author luowei
 * @since 2020-09-03
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember member);

    void register(RegisterVo registerVo);

    Integer countRegisterDay(String day);
}
