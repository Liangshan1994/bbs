<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<#include "head.ftl">
	</head>
	<body>
		<header>
		<div class="head">
			<div class="wp">
				<div class="head_top cl">
					<h2>
						<a href="javascript:;">
							<img src="img/logo.png" />
						</a>
					</h2>
					<form method="post" id="loginForm" action="">
						<div class="fastlg cl">
							<div class="y pns">
								<table cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td><label for="ls_username">帐号</label></td>
											<td><input type="text" name="username" id="ls_username" class="px vm xg1" value="用户名/Email" onfocus="if(this.value == '用户名/Email'){this.value = '';this.className = 'px vm';}" onblur="if(this.value == ''){this.value = '用户名/Email';this.className = 'px vm xg1';}" tabindex="901"></td>
											<td class="fastlg_l"><label for="ls_cookietime"><input type="checkbox" name="cookietime" id="ls_cookietime" class="pc" value="2592000" tabindex="903">自动登录</label></td>
											<td>&nbsp;
												<a href="javascript:;" onclick="showWindow('login', 'member.php?mod=logging&amp;action=login&amp;viewlostpw=1')">找回密码</a>
											</td>
										</tr>
										<tr>
											<td><label for="ls_password">密码</label></td>
											<td><input type="password" name="password" id="ls_password" class="px vm" autocomplete="off" tabindex="902"></td>
											<td class="fastlg_l"><button type="submit" class="pn vm" tabindex="904" style="width: 75px;"><em>登录</em></button></td>
											<td>&nbsp;
												<a href="member.php?mod=LCG_Register" class="xi2 xw1">注册[Register] </a>
											</td>
										</tr>
									</tbody>
								</table>
								<input type="hidden" name="quickforward" value="yes">
								<input type="hidden" name="handlekey" value="ls">
							</div>
						</div>
					</form>
				</div>
				<div class="head_nav">
					<ul>
						<li id="mn_portal">
							<a href="portal.php" title="Portal">门户</a>
						</li>
						<li class="a" id="mn_forum">
							<a href="forum.php" title="www">网站</a>
						</li>
						<li id="mn_portal">
							<a href="portal.php" title="Portal">门户</a>
						</li>
						<li class="a" id="mn_forum">
							<a href="forum.php" title="www">网站</a>
						</li>
						<li id="mn_portal">
							<a href="portal.php" title="Portal">门户</a>
						</li>
						<li class="a" id="mn_forum">
							<a href="forum.php" title="www">网站</a>
						</li>
					</ul>				
				</div>
				<div class="comiis_nav">
					<ul class="nav_ico02">
						<li><a href="javascript:;" target="_blank" title=""><font color="green">原创发布区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">精品软件区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">逆向资源区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">水漫金山区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">影视推荐区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">福利经验区</a></li>
				   	</ul>
				   	<ul class="nav_ico02">
						<li><a href="javascript:;" target="_blank" title=""><font color="green">原创发布区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">精品软件区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">逆向资源区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">水漫金山区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">影视推荐区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">福利经验区</a></li>
				   	</ul>
				   	<ul class="nav_ico02">
						<li><a href="javascript:;" target="_blank" title=""><font color="green">原创发布区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">精品软件区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">逆向资源区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">水漫金山区</a></li>
						<li><a href="javascript:;" target="_blank" title=""><font color="green">影视推荐区</font></a></li>
						<li><a href="javascript:;" target="_blank" title="">福利经验区</a></li>
				   	</ul>
				</div>
				<div id="scbar" class="scbar_narrow cl">
					<form id="scbar_form" method="post" autocomplete="off" onsubmit="searchFocus($('scbar_txt'))" action="search.php?searchsubmit=yes" target="_blank">
						<input type="hidden" name="mod" id="scbar_mod" value="search">
						<input type="hidden" name="srchtype" value="title">
						<input type="hidden" name="srhfid" value="">
						<input type="hidden" name="srhlocality" value="forum::index">
						<table cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td class="scbar_icon_td"></td>
									<td class="scbar_txt_td">
										<input type="text" name="srchtxt" id="scbar_txt" value="请输入搜索内容" class=" xg1" placeholder="请输入搜索内容">
									</td>
									<td class="scbar_type_td">
										<a href="javascript:;" id="scbar_type" class="xg1" >搜索</a>
									</td>
									<td class="scbar_btn_td">
										<button type="submit" name="searchsubmit" id="scbar_btn" sc="1" class="pn pnc" value="true">
											<strong class="xi2">搜索</strong>
										</button>
									</td>
									<td class="scbar_hot_td">
										<div id="scbar_hot">
											<strong class="xw1">热搜: </strong>
											<a href="javascript:;" target="_blank" class="xi2" sc="1">新手</a>
											<a href="javascript:;" target="_blank" class="xi2" sc="1">破解教程</a>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		</header>
	</body>
</html>
