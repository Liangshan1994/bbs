<!DOCTYPE html>
<html>
<head>
    <#include "common/head.ftl">
    <title>${board.boardName}</title>
</head>
<body>
<#include "common/header.ftl">

<div class="wp" id="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="./" class="nvhm" title="首页"></a><em>»</em>
            <a rel="index" href="/">网站</a><em>›</em>
            <a href="/board-${board.id}">【${board.boardName}】</a>
        </div>
    </div>
    <div id="ct" class="wp cl">
        <div class="mn">
            <div class="fl bm">
                <div class="bm bmw  flg cl">
                    <div class="bm_h cl">
                    <span class="o">
                        <img src="/static/img/collapsed_no.gif" title="收起/展开" alt="收起/展开" >
                    </span>
                        <span class="y">分区版主:
                            <a href="/home-${board.adminUserInfo.userId}.html" class="notabs">
                                ${board.adminUserInfo.userName}
                            </a>
                        </span>
                        <h2><a href="javascript:alert('等待开发')" style="">${board.boardName}</a></h2>
                    </div>
                    <div id="category_26" class="bm_c" style="">
                        <#if board.childrenBoardList?exists>
                            <table cellspacing="0" cellpadding="0" class="fl_tb">
                                <tbody>
                                    <#assign index = 0>
                                    <#list board.childrenBoardList as childrenBoard>
                                    <#if index==0>
                                        <tr>
                                    <#else >
                                        <tr class="fl_row">
                                    </#if>
                                        <td class="fl_icn">
                                            <a href="/board-${childrenBoard.id}.html">
                                                <img src="/static/img/forum_new.gif" alt="『${childrenBoard.boardName}』">
                                            </a>
                                        </td>
                                        <td>
                                            <h2>
                                                <a href="/board-${childrenBoard.id}.html">『${childrenBoard.boardName}』</a>
                                                <em class="xw0 xi1" title="今日">
                                                    (
                                                        <#if childrenBoard.topicList?exists>
                                                            ${childrenBoard.topicList?size}
                                                        </#if>
                                                    )</em>
                                            </h2>
                                            <p class="xg2">${childrenBoard.boardInfo}</p>
                                            <p>版主:
                                                <span class="xi2">
                                                <a href="/home-${childrenBoard.adminUserInfo.userId}.html" class="notabs" c="1">${childrenBoard.adminUserInfo.userName}</a>
                                                </span>
                                            </p>
                                        </td>
                                        <td class="fl_i">
                                            <span class="xi2">
                                                <span title="62779">6万</span>
                                            </span>
                                            <span class="xg1"> /
                                                <span title="671279">67万</span>
                                            </span>
                                        </td>
                                        <td class="fl_by">
                                            <div>
                                                <a href="/topic-${childrenBoard.lastTopic.id}-1.html" class="xi2">
                                                    ${childrenBoard.lastTopic.title}
                                                </a>
                                                <cite>${childrenBoard.lastTopic.createDate?datetime}
                                                    <a href="home-${childrenBoard.lastTopic.userInfo.userId}.html">${childrenBoard.lastTopic.userInfo.userName}</a>
                                                </cite>
                                            </div>
                                        </td>
                                    </tr>
                                    <#assign index = index + 1>
                                    </#list>
                                </tbody>
                            </table>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "common/footer.ftl">
</body>
</html>
