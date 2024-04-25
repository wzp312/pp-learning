package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;

import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    //分页查询员工
    PageBean page(Integer page, Integer pageSize);

    //批量删除员工
    void delete(List<Integer> ids);

    //添加员工
    void save(Emp emp);

    //返回员工id
    Emp getById(Integer id);

    //更新员工
    void update(Emp emp);

    //员工登录
    Emp login(Emp emp);
}
