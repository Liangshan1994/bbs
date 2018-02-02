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
        <div class="mn" id="main_message">
            <div class="bm">
                <div class="bm_h bbs">
							<span class="y">
								<a href="/toRegister" class="xi2">没有帐号？</a><a href="/toRegister">注册[Register] </a>
							</span>
                    <h3 class="xs2">登录</h3>
                </div>
                <div>
                    <div id="main_messaqge_Ldm0V">
                        <div id="layer_login_Ldm0V">
                            <form method="post" autocomplete="off" name="login" id="loginform_Ldm0V" class="cl" onsubmit="pwdclear = 1;ajaxpost('loginform_Ldm0V', 'returnmessage_Ldm0V', 'returnmessage_Ldm0V', 'onerror');return false;" action="member.php?mod=logging&amp;action=login&amp;loginsubmit=yes&amp;loginhash=Ldm0V">
                                <div class="c cl">
                                    <input type="hidden" name="formhash" value="0054fd99">
                                    <input type="hidden" name="referer" value="https://www.52pojie.cn/forum.php?mod=post&amp;action=newthread&amp;fid=2">
                                    <div class="rfm">
                                        <table>
                                            <tbody>
                                            <tr>
                                                <th>
                                                    <label for="username_Ldm0V">帐号:</label></th>
                                                <td><input type="text" name="username" id="username_Ldm0V" autocomplete="off" size="30" class="px p_fre" tabindex="1" value=""></td>
                                                <td class="tipcol">
                                                    <a href="member.php?mod=LCG_Register">注册[Register] </a>
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
                                                <td><input type="password" id="password3_Ldm0V" name="password" onfocus="clearpwd()" size="30" class="px p_fre" tabindex="1"></td>
                                                <td class="tipcol">
                                                    <a href="javascript:;" onclick="display('layer_login_Ldm0V');display('layer_lostpw_Ldm0V');" title="找回密码">找回密码</a>
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
                                                <td><label for="cookietime_Ldm0V"><input type="checkbox" class="pc" name="cookietime" id="cookietime_Ldm0V" tabindex="1" value="2592000">自动登录</label></td>
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
                                                    <button class="pn pnc" type="submit" name="loginsubmit" value="true" tabindex="1"><strong>登录</strong></button>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" onclick="ajaxget('member.php?mod=clearcookies&amp;formhash=0054fd99', 'returnmessage_Ldm0V', 'returnmessage_Ldm0V');return false;" title="清除痕迹" class="y">清除痕迹</a>
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