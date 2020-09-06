package com.luowei.service_edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luowei.service_edu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author luowei
 * @since 2020-08-15
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
