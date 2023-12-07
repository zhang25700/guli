package com.guli.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.commonutils.R;
import com.guli.eduservice.entity.Teacher;
import com.guli.eduservice.entity.vo.TeacherQuery;
import com.guli.eduservice.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zzy
 * @since 2023-10-20
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "讲师管理")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    @ApiOperation("获取全部教师信息")
    public R getAll(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除教师信息")
    public R remove(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable Long id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/page/{curr}/{size}")
    @ApiOperation("分页查询教师信息")
    public R page(@ApiParam("当前页数") @PathVariable Long curr,
                                 @ApiParam("每页大小") @PathVariable Long size){
        Page<Teacher> page = new Page(curr, size);
        teacherService.page(page);
        List<Teacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @PostMapping("pageTeacherCondition/{curr}/{size}")
    @ApiOperation("带条件分页查询")
    public R pageCondition(@PathVariable int curr, @PathVariable int size,
                           @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<Teacher> page = teacherService.page(curr, size, teacherQuery);
        List<Teacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @PostMapping("/addTeacher")
    @ApiOperation("添加讲师接口")
    public R addTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @GetMapping("/getOneTeacher/{id}")
    @ApiOperation("通过教师id查询教师")
    public R getOneTeacher(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null){
            return R.ok().data("teacher", teacher);
        }else{
            return R.error();
        }
    }

    @PutMapping("/updateTeacher")
    @ApiOperation("修改讲师接口")
    public R updateTeacher(@RequestBody Teacher teacher){
        boolean flag = false;
        if(teacher != null && teacherService.getById(teacher.getId()) != null){
            flag = teacherService.updateById(teacher);
        }
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }
}

