package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override //分页查询员工
    public PageBean page(Integer page, Integer pageSize) {
        //1.获取总记录数
        Long count = empMapper.count();
        //2.获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start,pageSize);
        //3.封装pageBean对象
        PageBean pageBean = new PageBean(count,empList);
        return pageBean;
    }

    @Override //批量删除员工
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override//添加员工
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }

    @Override//返回员工id
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override//更新员工
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Override//登录功能
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
