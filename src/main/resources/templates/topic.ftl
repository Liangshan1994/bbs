<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>${topic.title} -皮卡丘</title>
</head>
<body>
<#include "common/header.ftl">
<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="./" class="nvhm" title="首页"></a><em>»</em>
            <a rel="/" href="/">网站</a> <em>›</em>
            <#if board.parentBoard?exists>
                <a href="/board-${board.parentBoard.id}">【${board.parentBoard.boardName}】</a> <em>›</em>
            </#if>
            <a href="/board-${board.id}.html">『${board.boardName}』</a> <em>›</em>
            <a href="/topic-${topic.id}-1.html">${topic.title}</a>
        </div>
    </div>
    <div id="ct" class="wp cl">
        <div id="pgt" class="pgs mbm cl ">
            <div class="pgt">
                <div class="pg"><strong>1</strong>
                    <a href="/topic-${topic.id}-1.html">2</a>
                    <a href="/topic-${topic.id}-1.html">3</a>
                    <a href="/topic-${topic.id}-1.html">4</a>
                    <a href="/topic-${topic.id}-1.html">5</a>
                    <a href="/topic-${topic.id}-1.html">6</a>
                    <a href="/topic-${topic.id}-1.html">7</a>
                    <a href="/topic-${topic.id}-1.html">8</a>
                    <a href="/topic-${topic.id}-1.html">9</a>
                    <a href="/topic-${topic.id}-1.html">10</a>
                    <a href="/topic-${topic.id}-1.html" class="last">... 35</a><label><input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="1" ><span title="共 35 页"> / 35 页</span></label>
                    <a href="/topic-${topic.id}-1.html" class="nxt">下一页</a>
                </div>
            </div>
            <span class="y pgb" id="visitedforums" onmouseover="$('visitedforums').id = 'visitedforumstmp';this.id = 'visitedforums';showMenu({'ctrlid':this.id,'pos':'34'})" initialized="true"><a href="forum-13-1.html">返回列表</a></span>
            <a id="newspecial" onmouseover="$('newspecial').id = 'newspecialtmp';this.id = 'newspecial';showMenu({'ctrlid':this.id})" onclick="showWindow('newthread', 'forum.php?mod=post&amp;action=newthread&amp;fid=13')" href="javascript:;" title="发新帖"><img src="https://static.52pojie.cn/static/image/common/pn_post.png" alt="发新帖"></a>
            <a id="post_reply" onclick="showWindow('reply', 'forum.php?mod=post&amp;action=reply&amp;fid=13&amp;tid=688978')" href="javascript:;" title="回复"><img src="https://static.52pojie.cn/static/image/common/pn_reply.png" alt="回复"></a>
        </div>
        <div id="postlist" class="pl bm">
            <table cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="pls ptn pbn">
                        <div class="hm ptn">
                            <span class="xg1">查看:</span> <span class="xi1">4049</span><span class="pipe">|</span><span class="xg1">回复:</span> <span class="xi1">344</span>
                        </div>
                    </td>
                    <td class="plc ptm pbn vwthd">
                        <h1 class="ts">
                            <span>${topic.title}</span>
                        </h1>
                        <span class="xg1">
                            <a href="/topic-${topic.id}-1.html">[复制链接]</a>
                        </span>
                    </td>
                </tr>
                </tbody>
            </table>

            <table cellspacing="0" cellpadding="0" class="ad">
                <tbody>
                <tr>
                    <td class="pls">
                    </td>
                    <td class="plc">
                    </td>
                </tr>
                </tbody>
            </table>
            <div>
                <div id="threadstamp">
                    <img src="/static/img/stamp/005.gif" title="置顶">
                </div>
                <table class="plhin" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="pls" rowspan="2">
                            <div class="pls favatar" style="top: 33px;">
                                <div class="pi">
                                    <div class="authi">
                                        <a target="_blank" class="xw1" style="color: #FF0000">${topic.userInfo.userName}</a>
                                        <a target="_blank">
                                            <img src="/static/img/verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                        </a>
                                    </div>
                                </div>
                                <div>
                                    <div class="avatar">
                                        <a href="/home-${topic.userInfo.userId}.html" class="avtm" target="_blank">
                                            <img src="${topic.userInfo.userHeadImg}">
                                        </a>
                                    </div>
                                </div>
                                <div class="tns xg2">
                                    <table cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <tr>
                                            <th><p><a href="javascript:void(0)" class="xi2">${topic.userInfo.userTopicNum}</a></p>主题</th>
                                            <th><p><a href="javascript:void(0)" class="xi2">${topic.userInfo.userReplyNum}</a></p>帖子</th>
                                            <td><p><a href="javascript:void(0)" class="xi2">5078</a></p>积分</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <ul class="xl xl2 o cl">
                                    <li class="addflw">
                                        <a href="javascript:alert('等待开发')"  title="收听TA" class="xi2">收听TA</a>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        <td class="plc">
                            <div class="pi">
                                <div id="fj" class="y">
                                    <label class="z">电梯直达</label>
                                    <input type="text" class="px p_fre z" size="2" title="跳转到指定楼层">
                                    <a href="javascript:alert('等待开发')" id="fj_btn" class="z" title="跳转到指定楼层">
                                        <img src="/static/img/fj_btn.png" alt="跳转到指定楼层" class="vm">
                                    </a>
                                </div>
                                <strong>
                                    <a href="/topic-${topic.id}-1.html">
                                        <font color="red"><b>楼主</b></font>
                                    </a>
                                </strong>
                                <div class="pti">
                                    <div class="pdbt">
                                    </div>
                                    <div class="authi">
                                        <img class="authicn vm" src="/static/img/fanyinwen.gif">
                                        <em>发表于 ${topic.createDate?datetime}</em>
                                        <span class="pipe">|</span>
                                        <a href="javascript:alert('等待开发')" rel="nofollow">只看该作者</a>
                                        <span class="pipe show">|</span>
                                        <a href="javascript:alert('等待开发')" rel="nofollow" class="show">倒序浏览</a>
                                    </div>
                                </div>
                            </div>
                            <div class="pct">
                                <style type="text/css">
                                    .pcb {
                                        margin-right: 0
                                    }
                                </style>
                                <div class="bdsharebuttonbox bdshare-button-style1-16">
                                    <a href="javascript:alert('等待开发')" class="bds_more" data-cmd="more">分享到：</a>
                                    <a href="javascript:alert('等待开发')" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友">QQ好友</a>
                                    <a href="javascript:alert('等待开发')" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间">QQ空间</a>
                                    <a href="javascript:alert('等待开发')" class="bds_weixin" data-cmd="weixin" title="分享到微信">微信</a>
                                    <a href="javascript:alert('等待开发')" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博">新浪微博</a>
                                    <a href="javascript:alert('等待开发')" class="bds_douban" data-cmd="douban" title="分享到豆瓣网">豆瓣网</a>
                                    <a href="javascript:alert('等待开发')" class="bds_mail" data-cmd="mail" title="分享到邮件分享">邮件分享</a>
                                </div>
                                <div class="pcb">
                                    <div class="cm">
                                        ${topic.content}
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="plc plm">
                            <div id="p_btn" class="mtw mbm hm cl">
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="收藏本帖"><i><img src="/static/img/fav.gif" alt="收藏">收藏<span>3</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="评分表立场"><i><img src="/static/img/agree.gif" alt="免费评分">免费评分</i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="淘好帖进专辑"><i><img src="/static/img/collection.png" alt="分享">淘帖<span>0</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="顶一下"><i><img src="/static/img/rec_add.gif" alt="送鲜花">送鲜花<span>1</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="踩一下"><i><img src="/static/img/rec_subtract.gif" alt="扔鸡蛋">扔鸡蛋<span>0</span></i></a>
                                <a class="followp" href=""><i><img src="/static/img/wx.png">分享到朋友圈</i></a>
                            </div>
                            <div class="sign">${topic.userInfo.userSign}</div>
                        </td>
                    </tr>
                    <tr class="ad"><td class="pls"></td><td class="plc"></td></tr>
                    </tbody>
                </table>
            </div>
            <#if replyList?exists>
                <#list  replyList as reply>
                    <div>
                        <table class="plhin" cellspacing="0" cellpadding="0">
                            <tbody>
                                <tr>
                                    <td class="pls" rowspan="2">
                                        <div class="pls favatar">
                                            <div class="pi">
                                                <div class="authi"><a href="" target="_blank" class="xw1">${reply.userName}</a></div>
                                            </div>
                                            <div>
                                                <div class="avatar">
                                                    <a href="/home-${reply.userId}.html" class="avtm" target="_blank">
                                                        <img src="${reply.userImg}">
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="tns xg2">
                                                <table cellspacing="0" cellpadding="0">
                                                    <tbody>
                                                        <tr>
                                                            <th><p><a class="xi2">${reply.userTopicNum}</a></p>主题</th>
                                                            <th><p><a class="xi2">${reply.userReplyNum}</a></p>帖子</th>
                                                            <td><p><a class="xi2">404</a></p>积分</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <ul class="xl xl2 o cl">
                                                <li class="addflw">
                                                    <a title="收听TA" class="xi2">收听TA</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                    <td class="plc">
                                        <div class="pi">
                                            <strong><a>
                                                <#if reply.replySort==1>
                                                    沙发
                                                <#elseif reply.replySort==2>
                                                    板凳
                                                <#elseif reply.replySort==3>
                                                    地板
                                                <#else>
                                                    <em>${reply.replySort}</em><sup>#</sup>
                                                </#if>
                                            </a></strong>
                                            <div class="pti">
                                                <div class="authi">
                                                    <img class="authicn vm" src="/static/img/online_member.gif">
                                                    <em>发表于 ${reply.createDate?datetime}</em>
                                                    <span class="pipe">|</span>
                                                    <a rel="nofollow">只看该作者</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="pct">
                                            <div class="pcb">
                                                <div class="t_fsz">
                                                    <table cellspacing="0" cellpadding="0">
                                                        <tbody>
                                                            <tr>
                                                                <td class="t_f">
                                                                    ${reply.content}
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="plc plm">
                                        <div class="sign">${reply.userSign}</div>
                                    </td>
                                </tr>
                                <tr class="ad"><td class="pls"></td><td class="plc"></td></tr>
                            </tbody>
                        </table>
                    </div>
                </#list>
            </#if>
        </div>
        <div class="pgbtn">
            <a href="/topic-${topic.id}-1.html" hidefocus="true" class="bm_h">下一页 »</a>
        </div>
        <div class="pgs mtm mbm cl">
            <div class="pg"><strong>1</strong>
                <a href="/topic-${topic.id}-1.html">2</a>
                <a href="/topic-${topic.id}-1.html">3</a>
                <a href="/topic-${topic.id}-1.html">4</a>
                <a href="/topic-${topic.id}-1.html">5</a>
                <a href="/topic-${topic.id}-1.html">6</a>
                <a href="/topic-${topic.id}-1.html">7</a>
                <a href="/topic-${topic.id}-1.html">8</a>
                <a href="/topic-${topic.id}-1.html">9</a>
                <a href="/topic-${topic.id}-1.html">10</a>
                <a href="/topic-${topic.id}-1.html" class="last">... 35</a>
                <label>
                    <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="1" onkeydown="if(event.keyCode==13) {window.location='forum.php?mod=viewthread&amp;tid=688978&amp;extra=page%3D1&amp;page='+this.value;; doane(event);}">
                    <span title="共 35 页"> / 35 页</span>
                </label>
                <a href="/topic-${topic.id}-1.html" class="nxt">下一页</a>
            </div><span class="pgb y" id="visitedforumstmp" onmouseover="$('visitedforums').id = 'visitedforumstmp';this.id = 'visitedforums';showMenu({'ctrlid':this.id,'pos':'21'})"><a href="forum-13-1.html">返回列表</a></span>
            <a id="newspecialtmp" onmouseover="$('newspecial').id = 'newspecialtmp';this.id = 'newspecial';showMenu({'ctrlid':this.id})" onclick="showWindow('newthread', 'forum.php?mod=post&amp;action=newthread&amp;fid=13')" href="javascript:;" title="发新帖"><img src="https://static.52pojie.cn/static/image/common/pn_post.png" alt="发新帖"></a>
            <a id="post_replytmp" onclick="showWindow('reply', 'forum.php?mod=post&amp;action=reply&amp;fid=13&amp;tid=688978')" href="javascript:;" title="回复"><img src="https://static.52pojie.cn/static/image/common/pn_reply.png" alt="回复"></a>
        </div>
        <div id="diyfastposttop" class="area"></div>
        <div id="f_pst" class="pl bm bmw">
            <form method="post" autocomplete="off" id="fastpostform" action="forum.php?mod=post&amp;action=reply&amp;fid=13&amp;tid=688978&amp;extra=page%3D1&amp;replysubmit=yes&amp;infloat=yes&amp;handlekey=fastpost" onsubmit="return fastpostvalidate(this)">
                <table cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="pls">
                            <div class="avatar avtm">
                                <img src="/static/img/defaultImg.jpg">
                            </div>
                        </td>
                        <td class="plc">
                            <span id="fastpostreturn"></span>
                            <div class="cl">
                                <div id="fastposteditor">
                                    <div class="tedt mtn">
                                    </div>
                                </div>
                            </div>
                            <p class="ptm pnpost">
                                <a href="home.php?mod=spacecp&amp;ac=credit&amp;op=rule&amp;fid=13" class="y" target="_blank">本版积分规则</a>
                                <button type="submit" name="replysubmit" id="fastpostsubmit" class="pn pnc vm" value="replysubmit" tabindex="5"><strong>发表回复</strong></button>
                            </p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<#include "common/footer.ftl">
</body>
</html>