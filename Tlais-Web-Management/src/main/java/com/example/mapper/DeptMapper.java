package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    /*查询全部部门数据*/
    @Select("select * from dept")
    List<Dept> list();

    /*根据id删除部门*/
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /*新增部门*/
    @Insert("Insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /*返回部门id*/
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    /*修改部门*/
    @Update("Update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);



}
