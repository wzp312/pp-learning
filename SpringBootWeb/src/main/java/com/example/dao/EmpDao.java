package com.example.dao;

import com.example.pojo.Emp;
import java.util.List;

//dao层用于数据操作

public interface EmpDao {
    //获取员工列表数据
    public List<Emp> listEmp();
}