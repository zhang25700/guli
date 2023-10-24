package com.guli.eduservice.controller;


import com.guli.eduservice.entity.Teacher;
import com.guli.eduservice.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

//    @GetMapping()
//    public List<Teacher> getAll(){
//        List<Teacher> list = teacherService.list();
//        return list;
//    }
//    @GetMapping("/{id}")
//    public boolean remove(@PathVariable Long id){
//        boolean b = teacherService.removeById(id);
//        return b;
//    }

}

