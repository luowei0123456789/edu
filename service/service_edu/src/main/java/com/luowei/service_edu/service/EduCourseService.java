package com.luowei.service_edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luowei.service_edu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luowei.service_edu.entity.frontvo.CourseFrontVo;
import com.luowei.service_edu.entity.frontvo.CourseWebVo;
import com.luowei.service_edu.entity.vo.CourseInfoVo;
import com.luowei.service_edu.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author luowei
 * @since 2020-08-20
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
