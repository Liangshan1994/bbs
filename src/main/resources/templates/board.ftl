<#setting datetime_format="yyyy-MM-dd HH:mm">
<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>${board.boardName}</title>
</head>
<body>
<#include "common/header.ftl">

<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="/" class="nvhm" title="首页"></a><em>»</em>
            <#if board.parentBoard?exists>
                <a href="/board/boardList?id=${board.parentBoard.id}">${board.parentBoard.boardName}</a><em>›</em>
            </#if>
            <a href="/board-${board.id}.html">${board.boardName}</a>
        </div>
    </div>
    <div class="boardnav">
        <div id="ct" class="wp cl">
            <div class="mn">
                <div class="bm bml pbn">
                    <div class="bm_h cl">
                        <span class="o">
                            <img src="/static/img/collapsed_no.gif" title="收起/展开" alt="收起/展开">
                        </span>
                        <span class="y">
							<a href="javascript:void(0)" class="fa_fav">收藏本版
							</a>
							</span>
                        <h1 class="xs2">
                            <a href="/board-${board.id}.html">${board.boardName}</a>
                            <span class="xs1 xw0 i">今日: <strong class="xi1">0</strong><span class="pipe">|</span>主题: <strong class="xi1">122</strong><span class="pipe">|</span>排名: <strong class="xi1" title="上次排名:45">45</strong><b class="ico_increase">&nbsp;</b></span></h1>
                    </div>
                    <div class="bm_c cl pbn">
                        <div>版主:
                            <span class="xi2">
                                <a href="/home?username=LCG" class="notabs" c="1">LCG</a>,
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
                            <strong>1</strong>
                            <a href="forum-29-2.html">2</a>
                            <a href="forum-29-3.html">3</a>
                            <label>
                                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="1">
                                <span title="共 3 页"> / 3 页</span>
                            </label>
                            <a href="forum-29-2.html" class="nxt">下一页</a>
                        </div>
                    </span>
                    <span class="pgb y" id="visitedforums">
							<a rel="index" href="forum.php">返&nbsp;回</a>
						</span>
                    <a href="javascript:;" id="newspecial" title="发新帖">
                        <img src="https://static.52pojie.cn/static/image/common/pn_post.png" alt="发新帖">
                    </a>
                </div>
                <ul id="thread_types" class="ttp bm cl">
                    <li id="ttp_all" class="xw1 a">
                        <a href="forum-29-1.html">全部</a>
                    </li>
                    <li>
                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=typeid&amp;typeid=259">公告<span class="xg1 num">5</span></a>
                    </li>
                    <li>
                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=typeid&amp;typeid=40">待考核<span class="xg1 num">2</span></a>
                    </li>
                    <li>
                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=typeid&amp;typeid=41">考核中</a>
                    </li>
                </ul>
                <div id="threadlist" class="tl bm bmw" style="position: relative;">
                    <div class="th">
                        <table cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <th colspan="2">
                                    <div class="tf">
                                        <span id="atarget" onclick="setatarget(-1)" class="y atarget_1" title="在新窗口中打开帖子">新窗</span>
                                        <a id="filter_special" href="javascript:;" class="showmenu xi2" onclick="showMenu(this.id)">全部主题</a>&nbsp;
                                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=lastpost&amp;orderby=lastpost" class="xi2">最新</a>&nbsp;
                                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=heat&amp;orderby=heats" class="xi2">热门</a>&nbsp;
                                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=hot" class="xi2">热帖</a>&nbsp;
                                        <a href="forum.php?mod=forumdisplay&amp;fid=29&amp;filter=digest&amp;digest=1" class="xi2">精华</a>&nbsp;
                                        <a id="filter_dateline" href="javascript:;" class="showmenu xi2" onclick="showMenu(this.id)">更多</a>&nbsp;
                                        <span id="clearstickthread" style="display: none;">
											<span class="pipe">|</span>
											<a href="javascript:;" onclick="clearStickThread()" class="xi2" title="显示置顶">显示置顶</a>
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
                            <tbody>
                            <tr>
                                <td class="icn">
                                    <img src="/static/img/ann_icon.gif" alt="公告">
                                </td>
                                <th>
                                    <strong class="xst">公告:
                                        <a href="https://www.52pojie.cn/thread-686063-1-1.html" target="_blank">
                                            <font color="#0000CC">【权威发布】板块公告帖子</font>
                                        </a>
                                    </strong>
                                </th>
                                <td class="by">
                                    <cite>
                                        <a href="/home?id=1">Hmily</a>
                                    </cite>
                                    <em>2018-1-11</em>
                                </td>
                                <td class="num">&nbsp;</td>
                                <td class="by">&nbsp;</td>
                            </tr>
                            </tbody>
                            <#if topTopics?exists>
                                <#list topTopics as topTopic>
                                    <tbody>
                                    <tr>
                                        <td class="icn">
                                            <a href="/topic-${topTopic.id}.html" title="全局置顶主题 - 新窗口打开" target="_blank">
                                                <img src="/static/img/pin_3.gif" alt="全局置顶">
                                            </a>
                                        </td>
                                        <th class="common">
                                            <a href="/topic-${topTopic.id}.html" style="font-weight: bold;color: #2B65B7;" class="s xst">【权威发布】${topTopic.title}</a>
                                        </th>
                                        <td class="by">
                                            <cite>
                                                <a href="/home?id=${topTopic.userId}" style="color: #FF0000;">Hmily</a>
                                                <a href="/home?id=${topTopic.userId}" target="_blank">
                                                    <img src="https://attach.52pojie.cn/common/c8/common_2_verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                                </a>
                                            </cite>
                                            <em><span>${topTopic.createDate?datetime}</span></em>
                                        </td>
                                        <td class="num">
                                            <a href="/topic-${topTopic.id}.html" class="xi2">430</a><em>24272</em></td>
                                        <td class="by">
                                            <cite><a href="/home?id=${topTopic.userId}">yesav123</a></cite>
                                            <em><a href="/home?id=${topTopic.userId}">${topTopic.createDate?datetime}</a></em>
                                        </td>
                                    </tr>
                                    </tbody>
                                </#list>
                            </#if>
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
                            <#if topicByBoardId?exists>
                                <#list topicByBoardId as topic>
                                    <tbody>
                                    <tr>
                                        <td class="icn">
                                            <a href="/topic-${topic.id}.html" title="新窗口打开" target="_blank">
                                                <img src="/static/img/folder_new.gif">
                                            </a>
                                        </td>
                                        <th class="new">
                                            <em>[<a>测试帖子</a>]</em>
                                            <a href="/topic-${topic.id}.html" class="s xst">${topic.title}</a>
                                        </th>
                                        <td class="by">
                                            <cite>
                                                <a href="/home?id=1">Ericky</a>
                                                <a href="/home?id=1" target="_blank">
                                                    <img src="/static/img/verify_icon.gif" class="vm" alt="论坛大牛" title="论坛大牛">
                                                </a>
                                            </cite>
                                            <em><span>${topic.createDate?datetime}</span></em>
                                        </td>
                                        <td class="num">
                                            <a href="/topic-${topic.id}.html" class="xi2">1</a><em>519</em></td>
                                        <td class="by">
                                            <cite><a href="/home?id=1">ximo</a></cite>
                                            <em><a>${topic.createDate?datetime}</a></em>
                                        </td>
                                    </tr>
                                    </tbody>
                                </#list>
                            </#if>
                        </table>
                    </div>
                </div>
                <a class="bm_h" href="javascript:;" rel="forum.php?mod=forumdisplay&amp;fid=29&amp;page=2" curpage="1" id="autopbn" totalpage="3" picstyle="0" forumdefstyle="">下一页 »</a>
                <div class="bm bw0 pgs cl">
					<span id="fd_page_bottom">
						<div class="pg">
							<strong>1</strong>
							<a href="forum-29-2.html">2</a>
							<a href="forum-29-3.html">3</a>
							<label>
								<input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="1">
								<span title="共 3 页"> / 3 页</span>
							</label>
							<a href="forum-29-2.html" class="nxt">下一页</a>
						</div>
					</span>
                    <span id="visitedforumstmp" onmouseover="$('visitedforums').id = 'visitedforumstmp';this.id = 'visitedforums';showMenu({'ctrlid':this.id,'pos':'21'})" class="pgb y"><a rel="index" href="forum.php">返&nbsp;回</a></span>
                    <a href="javascript:;" id="newspecialtmp" onmouseover="$('newspecial').id = 'newspecialtmp';this.id = 'newspecial';showMenu({'ctrlid':this.id})" onclick="showWindow('newthread', 'forum.php?mod=post&amp;action=newthread&amp;fid=29')" title="发新帖"><img src="https://static.52pojie.cn/static/image/common/pn_post.png" alt="发新帖"></a>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer.ftl">
</body>
</html>