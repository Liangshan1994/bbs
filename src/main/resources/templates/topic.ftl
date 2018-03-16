<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>${topic.title} -皮卡丘</title>
    <script>
        $(function(){
            var url = window.location.href;
            $("#referer").val(url);
        })
    </script>
</head>
<body>
<#include "common/header.ftl">
<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="${base}" class="nvhm" title="首页"></a><em>»</em>
            <a rel="/" href="${base}">网站</a> <em>›</em>
            <#if board.parentBoard?exists>
                <a href="${base}/board-${board.parentBoardId}-1.html">${board.parentBoard.boardName}</a> <em>›</em>
            </#if>
            <a href="${base}/board-${board.id}-1.html">${board.boardName}</a> <em>›</em>
            <a href="${base}/topic-${topic.id}-1.html">${topic.title}</a>
        </div>
    </div>
    <div id="ct" class="wp cl">
        <div id="pgt" class="pgs mbm cl ">
            <div class="pgt">
                <div class="pg">
                <#if pageInfo.hasPreviousPage>
                    <a href="${base}/topic-${topic.id}-${pageInfo.prePage}.html" class="nxt">上一页</a>
                <#else >
                    <strong>上一页</strong>
                </#if>
                    <#if replyList?size gt 0>
                        <#list 1..pageInfo.pages as page>
                            <#if page=pageInfo.pageNum>
                                <strong>${page}</strong>
                            <#else >
                                <a href="${base}/topic-${topic.id}-${page}.html" class="nxt">${page}</a>
                            </#if>
                        </#list>
                        <#else >
                            <strong>1</strong>
                    </#if>
                    <label>
                        <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/topic-${topic.id}-'+this.value+'.html';}">
                        <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
                    </label>
                <#if pageInfo.hasNextPage>
                    <a href="${base}/topic-${topic.id}-${pageInfo.nextPage}.html" class="nxt">下一页</a>
                <#else >
                    <strong>下一页</strong>
                </#if>
                </div>
            </div>
            <span class="y pgb">
                <a href="${base}/board-${board.id}-1.html">返回列表</a>
            </span>
            <a id="newspecial"  href="${base}/newTopic-${board.id}.html" title="发新帖">
                <img src="${base}/static/img/pn_post.png" alt="发新帖"></a>
            <a id="post_reply" href="#f_pst" title="回复">
                <img src="${base}/static/img/pn_reply.png" alt="回复">
            </a>
        </div>
        <div id="postlist" class="pl bm">
            <table cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td class="pls ptn pbn">
                        <div class="hm ptn">
                            <span class="xg1">查看:</span>
                            <span class="xi1">${topic.view}</span>
                            <span class="pipe">|</span>
                            <span class="xg1">回复:</span>
                            <span class="xi1">${replyNum}</span>
                        </div>
                    </td>
                    <td class="plc ptm pbn vwthd">
                        <h1 class="ts">
                            <span>${topic.title}</span>
                        </h1>
                        <span class="xg1">
                            <a href="${base}/topic-${topic.id}-1.html">[复制链接]</a>
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
                    <#if topic.isTop==1>
                        <img src="${base}/static/img/stamp/005.gif" title="置顶">
                    <#elseif topic.isElite==1>
                        <img src="${base}/static/img/stamp/001.gif" title="置顶">
                    </#if>
                </div>
                <table class="plhin" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td class="pls" rowspan="2">
                            <div class="pls favatar" style="top: 33px;">
                                <div class="pi">
                                    <div class="authi">
                                        <a target="_blank" class="xw1" style="color: #FF0000">${topic.userInfo.userName?if_exists}</a>
                                        <a target="_blank">
                                            <img src="${base}/static/img/verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                        </a>
                                    </div>
                                </div>
                                <div>
                                    <div class="avatar">
                                        <a href="${base}/home-${topic.userInfo.userId?if_exists}.html" class="avtm" target="_blank">
                                            <img src="${base}${topic.userInfo.userHeadImg?if_exists}">
                                        </a>
                                    </div>
                                </div>
                                <div class="tns xg2">
                                    <table cellspacing="0" cellpadding="0">
                                        <tbody>
                                        <tr>
                                            <th><p><a href="javascript:void(0)" class="xi2">${topic.userInfo.userTopicNum?if_exists}</a></p>主题</th>
                                            <th><p><a href="javascript:void(0)" class="xi2">${topic.userInfo.userReplyNum?if_exists}</a></p>帖子</th>
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
                                        <img src="${base}/static/img/fj_btn.png" alt="跳转到指定楼层" class="vm">
                                    </a>
                                </div>
                                <strong>
                                    <a href="${base}/topic-${topic.id}-1.html">
                                        <font color="red"><b>楼主</b></font>
                                    </a>
                                </strong>
                                <div class="pti">
                                    <div class="pdbt">
                                    </div>
                                    <div class="authi">
                                        <img class="authicn vm" src="${base}/static/img/fanyinwen.gif">
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
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="收藏本帖"><i><img src="${base}/static/img/fav.gif" alt="收藏">收藏<span>3</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="评分表立场"><i><img src="${base}/static/img/agree.gif" alt="免费评分">免费评分</i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="淘好帖进专辑"><i><img src="${base}/static/img/collection.png" alt="分享">淘帖<span>0</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="顶一下"><i><img src="${base}/static/img/rec_add.gif" alt="送鲜花">送鲜花<span>1</span></i></a>
                                <a href="javascript:alert('等待开发')" rel="nofollow" title="踩一下"><i><img src="${base}/static/img/rec_subtract.gif" alt="扔鸡蛋">扔鸡蛋<span>0</span></i></a>
                                <a class="followp" href=""><i><img src="${base}/static/img/wx.png">分享到朋友圈</i></a>
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
                    <div id="post_${reply.id}">
                        <table id="pid${reply.id}" class="plhin" cellspacing="0" cellpadding="0">
                            <tbody>
                                <tr>
                                    <td class="pls" rowspan="2">
                                        <div class="pls favatar">
                                            <div class="pi">
                                                <div class="authi"><a href="" target="_blank" class="xw1">${reply.userName}</a></div>
                                            </div>
                                            <div>
                                                <div class="avatar">
                                                    <a href="${base}/home-${reply.userId}.html" class="avtm" target="_blank">
                                                        <img src="${base}${reply.userImg}">
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
                                                    <img class="authicn vm" src="${base}/static/img/online_member.gif">
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
            <#if pageInfo.hasNextPage>
                <a class="bm_h" href="${base}/topic-${topic.id}-${pageInfo.nextPage}.html" id="autopbn" >下一页 »</a>
            </#if>
        </div>
        <div class="pgs mtm mbm cl">
            <div class="pg">
                <#if pageInfo.hasPreviousPage>
                    <a href="${base}/topic-${topic.id}-${pageInfo.prePage}.html" class="nxt">上一页</a>
                <#else >
                    <strong>上一页</strong>
                </#if>
                <#list 1..pageInfo.pages as page>
                    <#if page=pageInfo.pageNum>
                        <strong>${page}</strong>
                    <#else >
                        <a href="${base}/topic-${topic.id}-${page}.html" class="nxt">${page}</a>
                    </#if>
                </#list>
                    <label>
                        <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/topic-${topic.id}-'+this.value+'.html';}">
                        <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
                    </label>
                <#if pageInfo.hasNextPage>
                    <a href="${base}/topic-${topic.id}-${pageInfo.nextPage}.html" class="nxt">下一页</a>
                <#else >
                    <strong>下一页</strong>
                </#if>
            </div>
            <span class="pgb y" id="visitedforumstmp" >
                <a href="${base}/board-${board.id}-1.html">返回列表</a>
            </span>
            <a id="newspecialtmp" href="${base}/newTopic-${board.id}.html" title="发新帖">
                <img src="${base}/static/img/pn_post.png" alt="发新帖">
            </a>
            <a id="post_replytmp"  href="#f_pst" title="回复">
                <img src="${base}/static/img/pn_reply.png" alt="回复">
            </a>
        </div>
        <div id="diyfastposttop" class="area"></div>
        <div id="f_pst" class="pl bm bmw">
            <form method="post" action="${base}/saveReply">
                <input type="hidden" name="boardId" value="${board.id}">
                <input type="hidden" name="topicId" value="${topic.id}">
                <input type="hidden" name="referer" id="referer">
                <table cellspacing="0" cellpadding="0">
                    <tbody>
                        <tr>
                            <td class="pls">
                                <div class="avatar avtm">
                                    <#if loginUser?exists>
                                        <img src="${base}${loginUser.userHeadImg}">
                                    <#else >
                                        <img src="${base}/static/img/defaultImg.jpg">
                                    </#if>
                                </div>
                            </td>
                            <td class="plc">
                                <script id="editor" name="content" style="width:800px;height:200px">

                                </script>
                                <script>
                                    var ue = UE.getEditor('editor',{
                                        imageUrlPrefix:"${base}",
                                        toolbars: [
                                            ['bold','forecolor', 'link', 'blockquote','insertcode','emotion']
                                        ]});
                                </script>
                                </div>
                                <p class="ptm pnpost">
                                    <button type="submit" name="replysubmit" class="pn pnc vm">
                                        <strong>发表回复</strong>
                                    </button>
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