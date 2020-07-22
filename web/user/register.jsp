<%--
  Created by IntelliJ IDEA.
  User: Yif
  Date: 2020/6/19
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <%@ include file="/common/auth_header.jsp"%>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            $("#username").blur(function () {
                let name = this.value;
                $.getJSON("${basePath}userServlet","action=existUsername&username=" + name,function (data) {
                    if(data.existUsername){
                        $("span.errorMsg").text("用户名已存在！");
                    } else{
                        $("span.errorMsg").text("");
                    }
                });
            });
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeText = $("#code").val();

                //去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });

    </script>
</head>
<body>
<h2>用户注册</h2>
<div class="login-page">
    <div class="form">
        <form method='post' action="userServlet">
            <br/>
            <span class="errorMsg">${requestScope.errMsg}</span>

            <input type="hidden" name="action" value="register">
            <input type="text" placeholder="用户名" id="username" name='username' maxlength="9"
                   value="${requestScope.username}"
                   required />
            <input type="password" placeholder="密码" id="password" name='password' required/>
            <input type="password" placeholder="密码确认" id="repwd" name='repwd' required/>
            <input type="text" placeholder="邮箱" id="email" name='email'
                   value="${requestScope.email}"
                   required />
            <input type="text" placeholder="验证码" style="width: 120px;margin-right: 20px" name="code" id="code" />
            <img id="code_img" alt="" src="kaptcha.jpg" style="float: right;  width: 120px; height: 40px;">
            <button type="submit" id="sub_btn">注  册</button>
        </form>
    </div>
</div>
</body>
</html>
