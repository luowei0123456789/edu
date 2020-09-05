package com.luowei.service_edu.service;

import com.luowei.service_edu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luowei.service_edu.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author luowei
 * @since 2020-08-19
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    List<OneSubject> getAllOneTwoSubject();
}
