package com.luowei.service_sso.mapper;

import com.luowei.service_sso.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author luowei
 * @since 2020-09-03
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {
    @Select("SELECT COUNT(*) FROM ucenter_member uc\n" +
            "         WHERE DATE(uc.gmt_create)=#{day}")
    Integer countRegisterDay(String day);
}
