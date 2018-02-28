<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>登录</title>
</head>
<body>
<#include "common/header.ftl">
<div id="wp" class="wp">
    <div id="ct" class="ptm wp w cl">
        <div class="mn" id="main_message">
            <div class="bm">
                <div class="bm_h bbs">
                    <span class="y">
                        <a href="${base}/toRegister" class="xi2">没有帐号？</a>
                        <a href="${base}/toRegister">注册[Register] </a>
                    </span>
                    <h3 class="xs2">登录</h3>
                </div>
                <div>
                    <div>
                        <div>
                            <form method="post" autocomplete="off" name="login" class="cl" action="${base}/login">
                                <input type="hidden" name="referer" value="${referer}">
                                <div class="c cl">
                                    <div class="rfm">
                                        <table>
                                            <tbody>
                                            <tr>
                                                <th>
                                                    <label for="username_Ldm0V">帐号:</label></th>
                                                <td><input type="text" name="loginName" id="username_Ldm0V" class="px p_fre" tabindex="1" value=""></td>
                                                <td class="tipcol">
                                                    <a href="${base}/toRegister">注册[Register] </a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="rfm">
                                        <table>
                                            <tbody>
                                            <tr>
                                                <th><label for="password3_Ldm0V">密码:</label></th>
                                                <td><input type="password" id="password3_Ldm0V" name="password"></td>
                                                <td class="tipcol">
                                                    <a href="javascript:;" title="找回密码">找回密码</a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="rfm ">
                                        <table>
                                            <tbody>
                                            <tr>
                                                <th></th>
                                                <td><label for="cookietime_Ldm0V"><input type="checkbox" class="pc" name="cookietime" id="cookietime_Ldm0V"  value="2592000">自动登录</label></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="rfm mbw bw0">
                                        <table width="100%">
                                            <tbody>
                                            <tr>
                                                <th>&nbsp;</th>
                                                <td>
                                                    <button class="pn pnc" type="submit" name="loginsubmit" value="true">
                                                        <strong>登录</strong>
                                                    </button>
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
        </div>
    </div>
</div>
<#include "common/footer.ftl">
<</body>
</html>