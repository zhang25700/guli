package com.guli.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.eduservice.entity.Teacher;
import com.guli.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author zzy
 * @since 2023-10-20
 */

public interface TeacherService extends IService<Teacher> {
    Page<Teacher> page(int curr, int size, TeacherQuery teacherQuery);

}
