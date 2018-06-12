<script>
	$(function(){
        getAllNav();
        var pathName=window.document.location.pathname;
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        $("#headRreferer").val(pathName.replace(projectName,''));
	});
    //获取所有nav
    function getAllNav(){
        $.ajax({
            url:'${base}/getAllNav',
            asynx:false,
            success:function(result){
                var html = '';
                html += '<ul>';
                $.each(result,function(key,value){
                    html += '<li><a href="${base}'+value.url+'" title="'+value.title+'">'+value.title+'</a></li>';
                });
                html += '</ul>';
                $("#headNav").html(html);
            }
        })
    }
</script>
<header>
<div class="head">
	<div class="wp">
		<div class="head_top cl">
			<h2>
				<a href="${base}">
					<img src="${base}/static/img/logo.png"/>
				</a>
			</h2>
			<#if loginUser?exists>
				<div id="um">
					<div class="avt y">
						<a href="${base}/home-${loginUser.userId}.html">
							<img src="${base}${loginUser.userHeadImg}">
						</a>
					</div>
					<p>
						<strong class="vwmy qq"><a href="${base}/home-${loginUser.userId}.html" target="_blank" title="访问我的空间">${loginUser.userName}</a></strong>
						<span class="pipe">|</span><a href="javascript:alert('等待开发')" class="showmenu">我的</a>
						<span class="pipe">|</span><a href="javascript:alert('等待开发')">设置</a>
						<span class="pipe">|</span><a href="javascript:alert('等待开发')">消息</a>
						<span class="pipe">|</span><a href="javascript:alert('等待开发')" class="a showmenu">提醒</a>
						<span class="pipe">|</span><a href="${base}/logout">退出</a>
					</p>
					<p>
						<span class="pipe">|</span>
						<a href="home.php?mod=spacecp&amp;ac=credit&amp;showcredit=1"  class="showmenu">积分: 4</a>
						<span class="pipe">|</span>
						<a href="home.php?mod=spacecp&amp;ac=usergroup" class="showmenu">用户组: 锋芒初露</a>
					</p>
				</div>
			<#else>
				<form method="post" id="loginForm" action="${base}/login">
					<input type="hidden" id="headRreferer" name="headRreferer">
					<div class="fastlg cl">
						<div class="y pns">
							<table cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<td>
											<label for="ls_loginName">帐号</label>
										</td>
										<td>
											<input type="text" name="loginName" id="ls_loginName" class="px vm" placeholder="用户名/Email">
										</td>
										<td class="fastlg_l">
											<label for="ls_cookietime">
												<input type="checkbox" name="cookietime" id="ls_cookietime" class="pc" value="2592000">自动登录
											</label>
										</td>
										<td>&nbsp;
											<a href="javascript:alert('等待开发')" >找回密码</a>
										</td>
									</tr>
									<tr>
										<td>
											<label for="ls_password">密码</label>
										</td>
										<td>
											<input type="password" name="password" id="ls_password" class="px vm">
											<input type="hidden" name="referer" id="headReferer" class="px vm">
										</td>
										<td class="fastlg_l">
											<button type="submit" class="pn vm" style="width: 75px;"><em>登录</em></button>
										</td>
										<td>&nbsp;
											<a href="${base}/toRegister" class="xi2 xw1">注册[Register] </a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</form>
			</#if>
		</div>
		<div class="head_nav" id="headNav">

		</div>
		<div class="comiis_nav" id="recommendBoard" style="display: none">

		</div>
		<div id="scbar" class="scbar_narrow cl">
			<form id="scbar_form" method="post" autocomplete="off" onsubmit="searchFocus($('scbar_txt'))" action="/${base}/search" target="_blank">
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
								<a href="javascript:" id="scbar_type" class="xg1" >搜索</a>
							</td>
							<td class="scbar_btn_td">
								<button type="button" name="searchsubmit" id="scbar_btn" sc="1" class="pn pnc" value="true">
									<strong class="xi2">搜索</strong>
								</button>
							</td>
							<td class="scbar_hot_td">
								<div id="scbar_hot">
									<strong class="xw1">热搜: </strong>
									<a href="javascript:" target="_blank" class="xi2" sc="1">热搜词汇</a>
									<a href="javascript:" target="_blank" class="xi2" sc="1">热搜词汇</a>
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
