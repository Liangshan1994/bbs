<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>${homeUser.userName}的个人资料 - 皮卡丘</title>
</head>
<body>
<#include "common/header.ftl">

<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="/" class="nvhm" title="首页"></a> <em>›</em>
            <a href="home-${homeUser.userId}.html">${homeUser.userName}</a> <em>›</em>
            个人资料
        </div>
    </div>
    <div id="uhd">
        <div class="mn">
            <ul>
                <li class="addflw">
                    <a href="javascript:alert('等待开发')">收听TA</a>
                </li>
                <li class="addf">
                    <a href="javascript:alert('等待开发')" class="xi2">加为好友</a>
                </li>
                <li class="pm2">
                    <a href="javascript:alert('等待开发')">发送消息</a>
                </li>
            </ul>
        </div>
        <div class="h cl">
            <div class="icn avt">
                <a href="home-${homeUser.userId}.html">
                    <img src="${homeUser.userHeadImg}">
                </a></div>
            <h2 class="mt">${homeUser.userName}</h2>
            <p><a href="/" class="xg1">https://www.pikaqiu.com/?${homeUser.userId}</a></p>
        </div>
    <ul class="tb cl" style="padding-left: 75px;">
        <li><a href="javascript:alert('等待开发');">广播</a></li>
        <li><a href="javascript:alert('等待开发');">主题</a></li>
        <li><a href="javascript:alert('等待开发');">日志</a></li>
        <li><a href="javascript:alert('等待开发');">相册</a></li>
        <li><a href="javascript:alert('等待开发');">留言板</a></li>
        <li class="a"><a href="${base}/home-${homeUser.userId}.html">个人资料</a></li>
    </ul>
</div>
    <div id="ct" class="ct1 wp cl">
        <div class="mn">
            <div id="diycontenttop" class="area"></div>
            <div class="bm bw0">
                <div class="bm_c">
                    <div class="bm_c u_profile">
                        <div class="pbm mbm bbda cl">
                            <h2 class="mbn">
                                ${homeUser.userName}<img src="${base}/static/img/ol.gif" alt="online" title="在线" class="vm">&nbsp;
                                <span class="xw0">(UID: ${homeUser.userId})</span>
                            </h2>
                            <ul class="pf_l cl pbm mbm">
                                <li><em>邮箱状态</em>已验证</li>
                                <li><em>视频认证</em>未认证</li>
                            </ul>
                            <ul>
                            </ul>
                            <ul class="cl bbda pbm mbm">
                                <li>
                                    <em class="xg2">统计信息</em>
                                    <a href="javascript:alert('等待开发')" target="_blank">好友数 0</a>
                                    <span class="pipe">|</span>
                                    <a href="javascript:alert('等待开发')" target="_blank">日志数 0</a>
                                    <span class="pipe">|</span>
                                    <a href="javascript:alert('等待开发')" target="_blank">相册数 0</a>
                                    <span class="pipe">|</span>
                                    <a href="javascript:alert('等待开发')" target="_blank">回帖数 ${homeUser.userReplyNum}</a>
                                    <span class="pipe">|</span>
                                    <a href="javascript:alert('等待开发')" target="_blank">主题数 ${homeUser.userTopicNum}</a>
                                </li>
                            </ul>
                            <ul class="pf_l cl"><li><em>真实姓名</em>${homeUser.userName}</li>
                                <li><em>性别</em><#if homeUser.userSex==1>男<#else >女</#if></li>
                                <li><em>生日</em>${homeUser.userBirthDate?string("yyyy 年 MM 月 dd 日")}</li>
                                <li><em>出生地</em>湖北省 孝感市 孝南区 书院街道</li>
                                <li><em>居住地</em>湖北省 孝感市 孝南区 书院街道</li>
                                <li><em>毕业学校</em>湖北工程学院</li>
                                <li><em>学历</em>本科</li>
                            </ul>
                        </div>
                        <div class="pbm mbm bbda cl">
                            <h2 class="mbn">用户认证</h2></div><div class="pbm mbm bbda cl">
                        <h2 class="mbn">活跃概况</h2>
                        <ul>
                            <li>
                                <em class="xg1">用户组&nbsp;&nbsp;</em>
                                <span style="color:" class="xi2">
                                    <a href="javascript:alert('等待开发')" target="_blank">锋芒初露</a>
                                </span>
                            </li>
                        </ul>
                        <ul id="pbbs" class="pf_l">
                            <li><em>在线时间</em>18 小时</li>
                            <li><em>注册时间</em>2014-3-30 12:16</li>
                            <li><em>最后访问</em>2018-2-2 10:58</li>
                            <li><em>注册 IP</em>111.178.26.0(中国湖北孝感)</li>
                            <li><em>上次访问 IP</em>119.96.178.221:45978(中国湖北武汉)</li>
                            <li><em>上次活动时间</em>2018-2-2 09:34</li>
                            <li><em>上次发表时间</em>2016-2-22 13:19</li>
                            <li><em>所在时区</em>使用系统默认</li>
                        </ul>
                    </div>
                        <div id="psts" class="cl">
                            <h2 class="mbn">统计信息</h2>
                            <ul class="pf_l">
                                <li><em>已用空间</em>   0 B </li>
                                <li><em>积分</em>4</li>
                                <li><em>威望</em>0 点</li>
                                <li><em>金币</em>99 PB</li>
                                <li><em>贡献值</em>0 点</li>
                                <li><em>悬赏值</em>0 点</li>
                                <li><em>热心值</em>0 点</li>
                                <li><em>违规</em>0 次</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">
</body>
</html>