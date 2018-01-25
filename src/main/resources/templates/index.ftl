<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
</head>
<body>
<#if user??>
<h4>${user.loginName}</h4>
</#if>
<a href="/user/userInfo?userId=1">个人中心</a>
<a href="/toLogin">登录</a>
</body>
</html>
