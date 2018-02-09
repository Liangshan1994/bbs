<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>注册</title>
<script>
    $(function(){

    })
    //防止重复提交
    var registerFlag = true;
    function checksubmit(){
        var loginName = $("#loginName").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var userEmail = $("#userEmail").val();
        if(loginName==null){
            alert("请输入用户名");
            return false;
        }if(password==null){
            alert("请输入密码");
            return false;
        }if(password2==null){
            alert("请重复密码");
            return false;
        }if(userEmail==null){
            alert("请输入邮箱");
            return false;
        }
        if(password!=password2){
            alert("两次密码不一致，请重新输入");
            return false;
        }
        if(registerFlag){
            registerFlag = false;
            $("#registerform").submit();
        }
    }
</script>
</head>
<body>
<#include "common/header.ftl">
<div id="wp" class="wp">
    <div id="ct" class="ptm wp cl">
        <div class="nfl" id="main_succeed" style="display: none">
            <div class="f_c altw">
                <div class="alert_right">
                    <p id="succeedmessage"></p>
                    <p id="succeedlocation" class="alert_btnleft"></p>
                    <p class="alert_btnleft">
                        <a id="succeedmessage_href">如果您的浏览器没有自动跳转，请点击此链接</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="mn">
            <div class="bm">
                <div class="bm_h bbs">
                    <span class="y">
                        <a href="${base}/toLogin" class="xi2">已有帐号？现在登录</a>
                    </span>
                    <h3 class="xs2">注册[Register] </h3>
                </div>
                <form method="post" autocomplete="off" id="registerform" enctype="multipart/form-data"  action="${base}/register">
                    <div class="bm_c">
                        <input type="hidden" name="referer" value="${referer}">
                        <div class="mtw">
                            <div id="reginfo_a">
                                <div class="rfm">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <th><span class="rq">*</span><label for="PJ52username">用户名:</label></th>
                                            <td><input type="text" id="loginName" name="loginName" class="px er"  required=""></td>
                                            <td class="tipcol">
                                                <i class="p_tip" style="display: none;">用户名由 3 到 15 个字符组成，禁止使用QQ或者邮箱等联系方式作为用户名！</i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="rfm">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <th><span class="rq">*</span><label for="PJ52password">密码:</label></th>
                                            <td><input type="password" id="password" name="password" class="px" required=""></td>
                                            <td class="tipcol">
                                                <i class="p_tip" style="display: none;">请填写密码, 最小长度为 9 个字符</i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="rfm">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <th><span class="rq">*</span><label for="password2">确认密码:</label></th>
                                            <td><input type="password" id="password2" name="password2" class="px"  required=""></td>
                                            <td class="tipcol">
                                                <i class="p_tip" style="display: none;">请再次输入密码</i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="rfm">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <th><span class="rq">*</span><label for="userEmail">Email:</label></th>
                                            <td><input type="text" id="userEmail" name="userEmail" autocomplete="off" size="25" tabindex="1" class="px" value="" required=""><br><em id="emailmore">&nbsp;</em></td>
                                            <td class="tipcol">
                                                <i class="p_tip" style="display: none;"><b><font color="blue">请输入正确的邮箱地址并仔细检查，注册后邮箱地址无法更改，需要邮件激活账号！</font></b></i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="layer_reginfo_b">
                        <div class="rfm mbw bw0">
                            <table width="100%">
                                <tbody>
                                <tr>
                                    <th>&nbsp;</th>
                                    <td>
                                        <span id="reginfo_a_btn">
                                            <em>&nbsp;</em><button class="pn pnc" id="registerformsubmit" type="submit" name="regsubmit" value="true" tabindex="1"><strong>提交</strong></button>
                                            <input type="checkbox" class="pc" name="agreebbrule" value="2000ff90" id="agreebbrule" checked="checked"> <label for="agreebbrule">同意<a href="javascript:;" onclick="showBBRule()">网站服务条款</a></label>
                                        </span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<#include "common/footer.ftl">
</body>
</html>