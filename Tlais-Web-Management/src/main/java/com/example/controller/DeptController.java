package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j                        /*日志输出*/
@RequestMapping("/depts")  //抽取公共路径，注解直接放在类上
@RestController
public class DeptController {

    //private static Logger log1 = LoggerFactory.getLogger(DeptController.class);      /*日志输出*/
    @Autowired
    private DeptService deptService;

    /*
    * 查询全部部门
    */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)     /*设定请求方式为get*/

    @GetMapping        //抽取完公共路径
    public Result list(){
        log.info("查询部门全部数据");         /*日志输出*/
        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /*
    *  根据id删除部门
    */
    @DeleteMapping("/{id}")   //抽取完公共路径
    public Result delete(@PathVariable Integer id) throws Exception {  /*标识路径中的id，并绑定给它    接收前端传来的参数*/
        log.info("根据id删除部门:{}",id);
        //调用service
        deptService.delete(id);
        return Result.success();
    }

    /*
    *  新增部门
    */
    @PostMapping        //抽取完公共路径
    public Result add(@RequestBody Dept dept){   /*将请求的JSON格式的数据封装到实体类中*/
        log.info("新增部门: {}",dept);
        //调用service
        deptService.add(dept);
        return Result.success();
    }

    /*
     * 返回部门id
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("返回部门id:{}",id);
        //调用service
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    /*
    *  修改部门
    */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门: {}",dept);
        //调用service
        deptService.update(dept);
        return Result.success();
    }
}
