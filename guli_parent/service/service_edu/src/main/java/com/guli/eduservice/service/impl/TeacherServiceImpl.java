package com.guli.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.eduservice.entity.Teacher;
import com.guli.eduservice.entity.vo.TeacherQuery;
import com.guli.eduservice.mapper.TeacherMapper;
import com.guli.eduservice.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author zzy
 * @since 2023-10-20
 */
@Service
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Page<Teacher> page(int curr, int size, TeacherQuery teacherQuery) {
        Page<Teacher> page = new Page<>(curr, size);
        LambdaQueryWrapper<Teacher> lqw = new LambdaQueryWrapper<>();
        lqw.like(!StringUtils.isEmpty(teacherQuery.getName()), Teacher::getName, teacherQuery.getName());
        lqw.eq(!StringUtils.isEmpty(teacherQuery.getLevel()), Teacher::getLevel, teacherQuery.getLevel());
        lqw.ge(!StringUtils.isEmpty(teacherQuery.getBegin()), Teacher::getGmtCreate, teacherQuery.getBegin());
        lqw.le(!StringUtils.isEmpty(teacherQuery.getEnd()), Teacher::getGmtCreate, teacherQuery.getEnd());
        this.page(page, lqw);
        return page;
    }
}
