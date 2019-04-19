//package net.wanho.controller;
//
//
//import net.wanho.mapper.StudentMapper;
//import net.wanho.pojo.Student;
//import net.wanho.service.StudentServiceI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.List;
//
///**
// * @author Administrator
// */
//@WebServlet("/StudentController")
//@Controller
//public class StudentController extends HttpServlet {
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        String methodName = request.getParameter("method");
//        try {
//            Method method = getClass().getDeclaredMethod(methodName,
//                    HttpServletRequest.class, HttpServletResponse.class);
//            method.setAccessible(true);
//            method.invoke(this, request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    public void init() throws ServletException {
////        在web容器中获取IOC容器
//        ServletContext servletContext = getServletContext();
////        ioc容器
//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//
//        studentMapper = ctx.getBean(StudentMapper.class);
//
//    }
//
//
//    //查询列表数据
////查看所有信息
//    protected void queryAllStudent(HttpServletRequest request, HttpServletResponse response) {
//
//        try {
//            List<Student> students = studentMapper.getStudents();
//            request.setAttribute("students", students);
//            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //查看单个信息
//    public void selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        try {
//            String id = request.getParameter("type");
//            if (!"1".equals(id) && id != "1") {
//                Integer OneId = Integer.parseInt(request.getParameter("OneId"));
//                Student UpStu = studentMapper.getStudentById(OneId);
//                request.setAttribute("UpStu", UpStu);
//                request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request,
//                        response);
//                return;
//            } else {
//                Integer PrimaryKey = Integer.parseInt(request.getParameter("PrimaryKey"));
//                Student AStu = studentMapper.getStudentById(PrimaryKey);
//                request.setAttribute("AStu", AStu);
//                request.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(request,
//                        response);
//            }
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //修改
//    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Student student = new Student();
//        try {
//            String sname = request.getParameter("sname");
//            String age = request.getParameter("age");
//            String gender = request.getParameter("Student_gender");
//            String address = request.getParameter("address");
//            String id = request.getParameter("Student_id");
//            student.setSname(sname);
//            student.setAge(Integer.parseInt(age));
//            student.setGender(gender);
//            student.setAddress(address);
//            student.setId(Integer.parseInt(id));
//
//            studentMapper.updateStudentById(student);
//            response.sendRedirect(request.getContextPath() + "/StudentController?method=queryAllStudent");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //删除
//    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        try {
//            String delId = request.getParameter("delId");
//            if (delId != null && !delId.equals("")) {
//                int id = Integer.valueOf(delId);
//                studentMapper.delStudentById(id);
//            }
//            response.sendRedirect(request.getContextPath() + "/StudentController?method=queryAllStudent");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 添加学生
//    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Student student = new Student();
//        try {
//            String sname = request.getParameter("sname");
//            String age = request.getParameter("age");
//            String gender = request.getParameter("gender");
//            String address = request.getParameter("address");
//
//            student.setAge(Integer.parseInt(age));
//            student.setSname(sname);
//            student.setGender(gender);
//            student.setAddress(address);
//
//            studentMapper.addStudent(student);
//            response.sendRedirect(request.getContextPath() + "/StudentController?method=queryAllStudent");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void ToCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(request, response);
//    }
//
//}
package net.wanho.controller;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class StudentController {

    @Autowired
    private StudentServiceI studentServiceI;
//
//    @RequestMapping("getStudents")
//    @ResponseBody
//    public JsonResult getStudents(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
//        PageInfo<Student> pageInfo = studentServiceI.getStudents(pageNum);
//        JsonResult result = new JsonResult();
//        result.setStatus(200);
//        result.setMsg("查询成功");
//        result.setData(pageInfo);
//        return result;
//    }

//增
//跳转到添加界面

    @RequestMapping("/toAdd")
    public String toAddUser() {
        return "/create";
    }

// 添加并重定向

    @RequestMapping("/addStudent")
    public String addStudent(Student student) {
        studentServiceI.addStudent(student);
        return "redirect:/getStudents";
    }


//删除

    @RequestMapping("/delStudentById")
    public void delStudentById(@RequestParam(value="id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        String result = "{\"result\":\"error\"}";
        if (studentServiceI.delStudentById(id)) {
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编辑

    @RequestMapping("/updateStudentById")
    public String updateStudentById(Student student, HttpServletRequest request, Model model) {
        if (studentServiceI.updateStudentById(student)) {
            student = studentServiceI.getStudentById(student.getId());
            request.setAttribute("student", student);
            model.addAttribute("student", student);
            return "redirect:/getStudents";
        } else {
            return "/error";
        }
    }

    /*根据id查询单个*/
    @RequestMapping("/getStudentById")
    public String getStudentById(@RequestParam(value="id") Integer id, HttpServletRequest request, Model model) {
        Student one = studentServiceI.getStudentById(id);
        request.setAttribute("one", one);
        model.addAttribute("one", one);
        return "/view";
    }

    //获取所有列表
    @RequestMapping("/getStudents")
    public String getStudents(@RequestParam(value="pageNum") Integer pageNum,HttpServletRequest request,Model model){
       // List<Student> students=studentServiceI.getStu();
        PageInfo<Student> students = studentServiceI.getStudents(pageNum);
        model.addAttribute("students", students);
        request.setAttribute("students", students);
        return "/index";
    }
}