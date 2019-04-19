package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/18.
 */
@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public boolean delStudentById(Integer id) {
       return studentMapper.delStudentById(id);
    }

    @Override
    public boolean updateStudentById(Student student) {
       return studentMapper.updateStudentById(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStu() {
        return studentMapper.getStu();
    }

    @Override
    public PageInfo<Student> getStudents(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Student> stu = studentMapper.getStu();
        PageInfo<Student> pageInfo= new PageInfo<Student>(stu);
        return pageInfo;
    }




}
