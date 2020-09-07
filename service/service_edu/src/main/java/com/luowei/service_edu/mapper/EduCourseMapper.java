package com.luowei.service_edu.mapper;

import com.luowei.service_edu.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luowei.service_edu.entity.frontvo.CourseWebVo;
import com.luowei.service_edu.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author luowei
 * @since 2020-08-20
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    @Select(" SELECT ec.id,ec.title,ec.price,ec.lesson_num AS lessonNum,ec.cover,\n" +
            "               et.name AS teacherName,\n" +
            "               es1.title AS subjectLevelOne,\n" +
            "               es2.title AS subjectLevelTwo\n" +
            "        FROM edu_course ec LEFT OUTER JOIN edu_course_description ecd ON ec.id=ecd.id\n" +
            "                           LEFT OUTER JOIN edu_teacher et ON ec.teacher_id=et.id\n" +
            "                           LEFT OUTER JOIN edu_subject es1 ON ec.subject_parent_id=es1.id\n" +
            "                   LEFT OUTER JOIN edu_subject es2 ON ec.subject_id=es2.id\n" +
            "        WHERE ec.id=#{courseId}")
    public CoursePublishVo getPublishCourseInfo(String courseId);


    @Select(" SELECT ec.id,ec.title,ec.price,ec.lesson_num AS lessonNum,ec.cover,\n" +
            "               ec.buy_count AS buyCount,ec.view_count AS viewCount,\n" +
            "               ecd.description,\n" +
            "               et.id AS teacherId,et.name AS teacherName,et.intro,et.avatar,\n" +
            "               es1.id AS subjectLevelOneId,es1.title AS subjectLevelOne,\n" +
            "               es2.id AS subjectLevelTwoId,es2.title AS subjectLevelTwo\n" +
            "      FROM edu_course ec LEFT OUTER JOIN edu_course_description ecd ON ec.id=ecd.id\n" +
            "                    LEFT OUTER JOIN edu_teacher et ON ec.teacher_id=et.id\n" +
            "                    LEFT OUTER JOIN edu_subject es1 ON ec.subject_parent_id=es1.id\n" +
            "            LEFT OUTER JOIN edu_subject es2 ON ec.subject_id=es2.id\n" +
            "        WHERE ec.id=#{courseId}")
    CourseWebVo getBaseCourseInfo(String courseId);
}
