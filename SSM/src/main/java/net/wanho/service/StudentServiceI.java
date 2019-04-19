package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/4/18.
 */
public interface StudentServiceI {


    void addStudent(Student student);

    boolean delStudentById(Integer id);

    boolean updateStudentById(Student student);

    Student getStudentById(Integer id);

    PageInfo<Student> getStudents(Integer pageNum);

    List<Student> getStu();

}
