package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /*
    * 分页查询员工
    */
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,           //设置默认值
                       @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询，参数: {},{}",page,pageSize);
        //调用service
        PageBean pageBean = empService.page(page,pageSize);
        return Result.success(pageBean);
    }

    /*
    * 批量删除员工
    */
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作 ids: {}",ids);
        empService.delete(ids);
        return  Result.success();
    }

    /*
    * 添加员工
    */
    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp){
        log.info("新增员工, emp: {}",emp);
        empService.save(emp);
        return  Result.success();
    }

    /*
    *   返回员工id
    */
    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /*
    * 更新员工
    */
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息 : {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
