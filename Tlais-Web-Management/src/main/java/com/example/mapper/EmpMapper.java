package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /*查询总记录数*/
    @Select("select count(*) from emp")
    Long count();

    /*分页查询 获取结果列表*/
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> page(Integer start,Integer pageSize);

    /*批量删除员工*/
    void delete(List<Integer> ids);

    /*添加员工*/
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    /*根据ID查询员工*/
    @Select("select * from emp where  id = #{id}")
    Emp getById(Integer id);

    /* 更新员工*/
    void update(Emp emp);

    /*根据用户名和密码查询员工 登录功能*/
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    /*根据部门id删除部门员工*/
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
