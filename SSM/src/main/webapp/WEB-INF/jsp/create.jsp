<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body>
<div>
    添加学生<i class="icon-reply pull-right" onclick="history.go(-1);"></i>
</div>
<div>
    <form action="${pageContext.request.contextPath}/addStudent" method="post">
        <div>
            <label class="control-label col-sm-2">姓名</label>
            <div class="col-sm-8">
                <input type="text" id="stuName" name="sname" maxlength="20" placeholder="姓名">
            </div>
        </div>

        <div>
            <label class="control-label col-sm-2">年龄</label>
            <div class="col-sm-8">
                <input type="text" id="stuAge" name="age" maxlength="20" placeholder="年龄">
            </div>
        </div>


        <div>
            <label class="control-label col-sm-2">性别</label>
            <div class="col-sm-8">
                <div>
                    <label class="label-radio inline">
                        <input type="radio" name="gender" value="男" checked> <span class="custom-radio"></span>男</label>
                    <label class="label-radio inline">
                        <input type="radio" name="gender" value="女"><span class="custom-radio"></span>女</label>
                </div>
            </div>
        </div>

        <div>
            <label class="control-label col-sm-2">地址</label>
            <div class="col-sm-8">
                <input type="text" id="StuAddress" name="address" maxlength="20" placeholder="地址">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label"></label>
            <div class="col-lg-10">
                <button type="submit" class="btn btn-primary">添加</button>
                <button type="button" class="btn btn-default" onClick="history.go(-1);">返回</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
