<#setting datetime_format="yyyy-MM-dd HH:mm">
<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>${board.boardName} - 皮卡丘</title>
</head>
<body>
<#include "common/header.ftl">

<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="/" class="nvhm" title="首页"></a><em>»</em>
            <#if board.parentBoard?exists>
                <a href="${base}/board-${board.parentBoard.id}-1.html">${board.parentBoard.boardName}</a><em>›</em>
            </#if>
            <a href="${base}/board-${board.id}-1.html">${board.boardName}</a>
        </div>
    </div>
    <div class="boardnav">
        <div id="ct" class="wp cl">
            <div class="mn">
                <div class="bm bml pbn">
                    <div class="bm_h cl">
                        <span class="o">
                            <img src="${base}/static/img/collapsed_no.gif" title="收起/展开" alt="收起/展开">
                        </span>
                        <span class="y">
							<a href="javascript:void(0)" class="fa_fav">收藏本版
							</a>
							</span>
                        <h1 class="xs2">
                            <a href="${base}/board-${board.id}-1.html">${board.boardName}</a>
                            <span class="xs1 xw0 i">
                                今日: <strong class="xi1">${toDayTopicNum}</strong>
                                <span class="pipe">|</span>
                                主题: <strong class="xi1">${pageInfo.total}</strong>
                               <#-- <span class="pipe">|</span>
                                排名: <strong class="xi1" title="上次排名:45">45</strong>-->
                            </span>
                        </h1>
                    </div>
                    <div class="bm_c cl pbn">
                        <div>版主:
                            <span class="xi2">
                                <a href="${base}/home-${board.adminUserInfo.userId}.html" class="notabs" c="1">${board.adminUserInfo.userName}</a>,
                            </span>
                        </div>
                        <div id="forum_rules_29" style=";">
                            <div class="ptn xg2">
                                <font face="微软雅黑">
                                    <font color="Blue">
                                        这里是论坛版规等
                                    </font>
                                </font>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="pgt" class="bm bw0 pgs cl">
                    <span id="fd_page_top">
                        <div class="pg">
                            <#if pageInfo.hasPreviousPage>
                                <a href="${base}/board-${board.id}-${pageInfo.prePage}.html" class="nxt">上一页</a>
                            <#else >
                                <strong>上一页</strong>
                            </#if>
                            <#list 1..pageInfo.pages as page>
                            <#if page=pageInfo.pageNum>
                                <strong>${page}</strong>
                            <#else >
                                <a href="${base}/board-${board.id}-${page}.html" class="nxt">${page}</a>
                            </#if>
                            </#list>
                            <label>
                                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/board-${board.id}-'+this.value+'.html';}">
                                <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
                            </label>
                            <#if pageInfo.hasNextPage>
                                <a href="${base}/board-${board.id}-${pageInfo.nextPage}.html" class="nxt">下一页</a>
                                <#else >
                                <strong>下一页</strong>
                            </#if>
                        </div>
                    </span>
                    <span class="pgb y" id="visitedforums">
							<a rel="index" href="javascript:history.go(-1)">返&nbsp;回</a>
						</span>
                    <a href="${base}/newTopic-${board.id}.html" title="发新帖">
                        <img src="${base}/static/img/pn_post.png" alt="发新帖">
                    </a>
                </div>
                <ul id="thread_types" class="ttp bm cl">
                    <li id="ttp_all" class="xw1 a">
                        <a href="javascript:alert('等待开发')">全部</a>
                    </li>
                    <li>
                        <a href="javascript:alert('等待开发')">公告<span class="xg1 num">5</span></a>
                    </li>
                    <li>
                        <a href="javascript:alert('等待开发')">待考核<span class="xg1 num">2</span></a>
                    </li>
                    <li>
                        <a href="javascript:alert('等待开发')">考核中</a>
                    </li>
                </ul>
                <div id="threadlist" class="tl bm bmw" style="position: relative;">
                    <div class="th">
                        <table cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <th colspan="2">
                                    <div class="tf">
                                        <span id="atarget"  class="y atarget_1" title="在新窗口中打开帖子">新窗</span>
                                        <a href="javascript:alert('等待开发')" class="showmenu xi2">全部主题</a>&nbsp;
                                        <a href="javascript:alert('等待开发')" class="xi2">最新</a>&nbsp;
                                        <a href="javascript:alert('等待开发')" class="xi2">热门</a>&nbsp;
                                        <a href="javascript:alert('等待开发')" class="xi2">热帖</a>&nbsp;
                                        <a href="javascript:alert('等待开发')" class="xi2">精华</a>&nbsp;
                                        <a id="filter_dateline" href="javascript:;" class="showmenu xi2">更多</a>&nbsp;
                                        <span id="clearstickthread" style="display: none;">
											<span class="pipe">|</span>
											<a href="javascript:alert('等待开发')" class="xi2" title="显示置顶">显示置顶</a>
											</span>
                                    </div>
                                </th>
                                <td class="by">作者</td>
                                <td class="num">回复/查看</td>
                                <td class="by">最后发表</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="bm_c">
                        <table  cellspacing="0" cellpadding="0">
                            <#if topTopics?exists>
                                <#list topTopics as topTopic>
                                    <tbody>
                                    <tr>
                                        <td class="icn">
                                            <a href="${base}/topic-${topTopic.id}-1.html" title="全局置顶主题 - 新窗口打开" target="_blank">
                                                <img src="${base}/static/img/pin_${topTopic_index + 1}.gif" alt="全局置顶">
                                            </a>
                                        </td>
                                        <th class="common">
                                            <a href="${base}/topic-${topTopic.id}-1.html" style="font-weight: bold;color: #2B65B7;" class="s xst">【权威发布】${topTopic.title}</a>
                                        </th>
                                        <td class="by">
                                            <cite>
                                                <a href="/home-${topTopic.userId}.html" style="color: #FF0000;">${topTopic.userInfo.userName}</a>
                                                <a href="/home-${topTopic.userId}.html" target="_blank">
                                                    <img src="${base}/static/img/verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                                </a>
                                            </cite>
                                            <em><span>${topTopic.createDate?datetime}</span></em>
                                        </td>
                                        <td class="num">
                                            <a href="${base}/topic-${topTopic.id}-1.html" class="xi2">${topTopic.replyNum}</a><em>${topTopic.view}</em></td>
                                        <td class="by">
                                            <cite><a href="${base}/home-${topTopic.userId}.html">${topTopic.userInfo.userName}</a></cite>
                                            <em><a href="${base}/home-${topTopic.userId}.html">${topTopic.createDate?datetime}</a></em>
                                        </td>
                                    </tr>
                                    </tbody>
                                </#list>
                                <#if topTopics?size gt 0>
                                    <tbody id="separatorline">
                                    <tr class="ts" style="display: table-row;">
                                        <td>&nbsp;</td>
                                        <th>
                                            <a href="javascript:void(0)" title="查看更新" class="forumrefresh">版块主题</a>
                                        </th>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    </tbody>
                                </#if>
                            </#if>
                            <#if topicByBoardId?exists>
                                <#list topicByBoardId as topic>
                                    <tbody>
                                    <tr>
                                        <td class="icn">
                                            <a href="${base}/topic-${topic.id}-1.html" title="新窗口打开" target="_blank">
                                                <img src="${base}/static/img/folder_new.gif">
                                            </a>
                                        </td>
                                        <th class="new">
                                            <em>[<a>测试帖子</a>]</em>
                                            <a href="${base}/topic-${topic.id}-1.html" class="s xst">${topic.title}</a>
                                        </th>
                                        <td class="by">
                                            <cite>
                                                <a href="${base}/home-${topic.userId}.html">${topic.userInfo.userName}</a>
                                                <a href="${base}/home-${topic.userId}.html" target="_blank">
                                                    <img src="${base}/static/img/verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                                </a>
                                            </cite>
                                            <em><span>${topic.createDate?datetime}</span></em>
                                        </td>
                                        <td class="num">
                                            <a href="${base}/topic-${topic.id}-1.html" class="xi2">${topic.replyNum}</a><em>${topic.view}</em></td>
                                        <td class="by">
                                            <cite><a href="${base}/home-${topic.userId}.html">${topic.userInfo.userName}</a></cite>
                                            <em><a>${topic.createDate?datetime}</a></em>
                                        </td>
                                    </tr>
                                    </tbody>
                                </#list>
                            </#if>
                        </table>
                    </div>
                </div>
            <#if pageInfo.hasNextPage>
                <a class="bm_h" href="${base}/board-${board.id}-${pageInfo.nextPage}.html" id="autopbn" >下一页 »</a>
            </#if>
                <div class="bm bw0 pgs cl">
					<span id="fd_page_bottom">
						<div class="pg">
							<#if pageInfo.hasPreviousPage>
                                <a href="${base}/board-${board.id}-${pageInfo.prePage}.html" class="nxt">上一页</a>
                            <#else >
                                <strong>上一页</strong>
                            </#if>
                            <#list 1..pageInfo.pages as page>
                                <#if page=pageInfo.pageNum>
                                    <strong>${page}</strong>
                                <#else >
                                    <a href="${base}/board-${board.id}-${page}.html" class="nxt">${page}</a>
                                </#if>
                            </#list>
                                <label>
                                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/board-${board.id}-'+this.value+'.html';}">
                                <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
                            </label>
                            <#if pageInfo.hasNextPage>
                                <a href="${base}/board-${board.id}-${pageInfo.nextPage}.html" class="nxt">下一页</a>
                            <#else >
                                <strong>下一页</strong>
                            </#if>
						</div>
					</span>
                    <span class="pgb y">
                        <a rel="index" href="javascript:history.go(-1)">返&nbsp;回</a>
                    </span>
                    <a href="${base}/newTopic-${board.id}.html" title="发新帖">
                        <img src="${base}/static/img/pn_post.png" alt="发新帖">
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">
</body>
</html>