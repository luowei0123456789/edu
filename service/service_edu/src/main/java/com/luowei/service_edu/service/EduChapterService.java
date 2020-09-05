package com.luowei.service_edu.service;

import com.luowei.service_edu.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luowei.service_edu.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author luowei
 * @since 2020-08-20
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
