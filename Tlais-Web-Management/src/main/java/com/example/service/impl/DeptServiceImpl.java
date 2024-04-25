package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.DeptLog;
import com.example.service.DeptLogService;
import com.example.service.DeptService;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override  /*查询全部部门数据*/
    public List<Dept> list() {
        return deptMapper.list();
    }

    /*事物管理 执行前开启事物，执行后提交事物，，出现异常则进行回滚*/
    @Transactional(rollbackFor = Exception.class)/*设置所有类型的异常都会回滚  默认情况下 只有RunTimeExcetion‘运行时异常’才回滚*/
    @Override /*根据id删除部门*/
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id); //根据ID删除部门数据

            int i = 1/0;
            //if(true){throw new Exception("出错啦...");}

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override  /*新增部门*/
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override /*返回部门id*/
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override /*修改部门*/
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
