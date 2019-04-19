package net.wanho.mapper;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface StudentMapper {

    void addStudent(Student student);

    boolean delStudentById(Integer id);

    boolean updateStudentById(Student student);

    Student getStudentById(Integer id);

    PageInfo<Student> getStudents(Integer pageNum);

    List<Student> getStu();


}
