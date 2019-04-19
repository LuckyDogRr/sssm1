<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
</head>

<body class="navbar-top">
<div>
    <div>
        <div>
            <div>
                <i class="icon-reorder"></i> 修改学生信息 <i class="icon-reply pull-right" onclick="history.go(-1);"></i>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/updateStudentById" method="post">

                    <div class="form-group field-contacts-name required">
                        <label class="control-label col-sm-2" for="contacts-name">姓名</label>
                        <div class="col-sm-8">
                            <input type="text" id="contacts-name" class="form-control" name="sname" value="${student.sname}"
                                   maxlength="20"
                                   placeholder="姓名">
                        </div>
                    </div>

                    <div>
                        <label class="control-label col-sm-2">年龄</label>
                        <div class="col-sm-8">
                            <input type="text" id="stuAge" name="age" maxlength="20" placeholder="年龄" value="${student.age}">
                        </div>
                    </div>

                    <div>
                        <label class="control-label col-sm-2">性别</label>
                        <div class="col-sm-8">
                            <div>
                                <input type="hidden" id="Student_id" name="Student_id"
                                       value='${student.id}'>
                                <input type="hidden" id="Student_gender" name="Student_gender"
                                       value='${student.gender}'>
                                <label class="label-radio inline">
                                    <input type="radio" name="gender" value="${student.gender}" checked> <span
                                        class="custom-radio"></span>男</label>
                                <label class="label-radio inline">
                                    <input type="radio" name="gender" value="${student.gender}"><span
                                        class="custom-radio"></span>女</label>
                            </div>
                        </div>
                    </div>

                    <div>
                        <label class="control-label col-sm-2">地址</label>
                        <div class="col-sm-8">
                            <input type="text" id="StuAddress" name="address" maxlength="20" placeholder="地址" value="${student.address}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-lg-10">
                            <button type="submit">修改</button>
                            <button type="button" onClick="history.go(-1);">返回
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
