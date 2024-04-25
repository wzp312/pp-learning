package com.example.service;

import com.example.pojo.Emp;
import java.util.List;

//Servic层用于逻辑实现

public interface EmpService {
    //获取员工列表
    public List<Emp> listEmp();
}
