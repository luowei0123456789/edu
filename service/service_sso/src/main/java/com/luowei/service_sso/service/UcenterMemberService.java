package com.luowei.service_sso.service;

import com.luowei.service_sso.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
