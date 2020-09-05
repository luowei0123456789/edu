package com.luowei.service_edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luowei.R;
import com.luowei.handle.MyException;
import com.luowei.service_edu.EduService;
import com.luowei.service_edu.entity.EduTeacher;
import com.luowei.service_edu.entity.vo.TeacherQuery;
import com.luowei.service_edu.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-02-24
 */

@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    public R findAll(){
        List<EduTeacher> list = this.eduTeacherService.list(null);
        return R.ok().data("items",list);
    }

    @DeleteMapping("{cid}")
    public R delete(@PathVariable String cid){
        boolean flag = this.eduTeacherService.removeById(cid);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable Long current,
                         @PathVariable Long limit){
        Page<EduTeacher> page1 = new Page<>(current,limit);
        eduTeacherService.page(page1,null);
        long total = page1.getTotal();
        List<EduTeacher> records = page1.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",records);
        return R.ok().data(map);
    }

    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,@PathVariable long limit,
                                  @RequestBody(required = false)  TeacherQuery teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }

        //排序
        wrapper.orderByDesc("gmt_create");

        //调用方法实现条件查询分页
        eduTeacherService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return R.ok().data("total",total).data("rows",records);
    }

    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody(required = false) EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else
            return R.error();
    }

    @ApiOperation("根据Id查询教师信息")
    @GetMapping("findTeacherById/{id}")
    public R findTeacherById(@PathVariable String id){
        EduTeacher byId = eduTeacherService.getById(id);
        if (!StringUtils.isEmpty(byId)){
            return R.ok().data("teacher",byId);
        }else return R.error();
    }

    @ApiOperation("修改教师信息")
    @PostMapping("updateTeacher")
    public R modifyTeacher(@RequestBody(required = true) EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b){
            return R.ok();
        }else {
          return   R.error();
        }
    }
}

