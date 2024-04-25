package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /*查询全部部门*/
    List<Dept> list();

    /*根据id删除部门*/
    void delete(Integer id) throws Exception;

    /*新增部门*/
    void add(Dept dept);

    /*返回部门id*/
    Dept selectById(Integer id);

    /*修改部门*/
    void update(Dept dept);


}
