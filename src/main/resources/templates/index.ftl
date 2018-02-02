<!DOCTYPE html>
<html>
<head>
    <#include "common/head.ftl">
    <title>首页</title>
<script type="application/javascript">
    $(function(){
        getNewTopic();
        getTypeTopic();
        getEliteTopic();
        getHotTopic();
        getActiveUser();
    })
    function getNewTopic(){
        $.ajax({
            url:'/getNewTopic',
            asynx:false,
            data:{"size":10},
            type:"post",
            success:function(result){
                if(result!=null){
                    var html = '';
                    $.each(result,function(key,value){
                        html += '<div class="threadline_7ree" style="border-bottom:1px dashed #CDCDCD;">'
                        html += '<a href="/topic-'+value.id+'.html" target="_blank">'+value.title+'</a>';
                        html += '</div>';
                    })
                    $("#newTopicList").html(html);
                }
            }
        })
    }
    function getEliteTopic(){
        $.ajax({
            url:'/getEliteTopic',
            asynx:false,
            data:{"size":10},
            type:"post",
            success:function(result){
                if(result!=null){
                    var html = '';
                    $.each(result,function(key,value){
                        html += '<div class="threadline_7ree" style="border-bottom:1px dashed #CDCDCD;">'
                        html += '<a href="/topic-'+value.id+'.html" target="_blank">'+value.title+'</a>';
                        html += '</div>';
                    })
                    $("#eliteTopicList").html(html);
                }
            }
        })
    }
    function getHotTopic(){
        $.ajax({
            url:'/getEliteTopic',
            asynx:false,
            data:{"size":10},
            type:"post",
            success:function(result){
                if(result!=null){
                    var html = '';
                    $.each(result,function(key,value){
                        html += '<div class="threadline_7ree" style="border-bottom:1px dashed #CDCDCD;">'
                        html += '<a href="/topic-'+value.id+'.html" target="_blank">'+value.title+'</a>';
                        html += '</div>';
                    })
                    $("#hotTopicList").html(html);
                }
            }
        })
    }
    function getTypeTopic(){
        $.ajax({
            url:'/getEliteTopic',
            asynx:false,
            data:{"size":10},
            type:"post",
            success:function(result){
                if(result!=null){
                    var html = '';
                    $.each(result,function(key,value){
                        html += '<div class="threadline_7ree" style="border-bottom:1px dashed #CDCDCD;">'
                        html += '<a href="/topic-'+value.id+'.html" target="_blank">'+value.title+'</a>';
                        html += '</div>';
                    })
                    $("#typeTopicList").html(html);
                }
            }
        })
    }
    function getActiveUser(){
        $.ajax({
            url:'/getActiveUser',
            asynx:false,
            data:{"size":10},
            type:"post",
            success:function(result){
                if(result!=null){
                    var html = '';
                    $.each(result,function(key,value){
                        html += '<div class="threadline_7ree" style="border-bottom:1px dashed #CDCDCD;">'
                        html += '<span class="y" style="margin-right:5px; color:#999999;">'+value.userTopicNum+'</span>';
                        html += '<a href="/home-'+value.userId+'.html" target="_blank" c="1">'+value.userName+'</a>';
                        html += '</div>';
                    })
                    $("#activeUserList").html(html);
                }
            }
        })
    }
</script>
</head>
<body>
<#include "common/header.ftl">

<div class="wp" id="wp">
    <div id="pt" class="bm cl">
        <div class="y">
            <div class="announcement">
                <dl class="cl">
                    <dd>
                        <div class="announcement_list">
                            <ul class="announcement_list_ul">
                                <li><span><a href="javascript:;" target="_blank" class="xi2"><font color="#0000CC">公告标题</font></a></span><em>(2018-1-11)</em></li>
                                <li><span><a href="javascript:;" target="_blank" class="xi2"><font color="#0000CC">公告标题</font></a></span><em>(2018-1-11)</em></li>
                            </ul>
                        </div>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="z">
            <a href="./" class="nvhm" title="首页"></a>
            <em>»</em>
            <a rel="index" href="forum.php">网站</a>
        </div>
    </div>
    <div id="ct" class="wp cl">
        <div id="chart" class="bm bw0 cl">
            <p class="chart z">
                今日: <em>5719</em><span class="pipe">|</span>
                昨日: <em>13158</em><span class="pipe">|</span>
                帖子: <em>15443950</em><span class="pipe">|</span>
                会员: <em>581649</em><span class="pipe">|</span>
                欢迎新会员: <em>huangnanqu</em>
            </p>
        </div>
        <div class="mn">
            <div class="fl bm">
                <div class="bm bmw cl widthauto">
                    <div class="bm_h cl">
                        <span class="y">
                            <a href="javascript:void(0);" onclick="document.getElementById('reply_7ree').style.display='none';slideAd('topbarad_7ree',5,'down',150,0);" title="重播顶部横幅广告" id="reply_7ree" class="reply_7ree"> </a>
                        </span>
                        <h2 style="font-weight:normal; ">
                            <div id="diymsg">
                                <div id="indiymsg">
                                    <div id="diymsg1">
                                        <a style="color:blue" href="thread-688978-1-1.html" target="_blank">【活动】活动名</a>
                                    </div>
                                </div>
                            </div>
                        </h2>
                        <img src="static/img/collapsed_no.gif" height="0" width="0">
                    </div>
                    <div id="category_">
                        <table cellspacing="0" cellpadding="0" width="100%" class="toplist_7ree">
                            <tbody>
                            <tr class="toptitle_7ree">
                                <td align="center" width="21.428571428571%">
                                    <a href="https://www.52pojie.cn/forum.php?mod=guide&amp;view=newthread" target="_blank"><strong>新鲜出炉（更多）</strong></a>
                                </td>
                                <td align="center" width="21.428571428571%">
                                    <a href="https://www.52pojie.cn/forum.php?mod=guide&amp;view=new" target="_blank"><strong>技术分享</strong></a>
                                </td>
                                <td align="center" width="21.428571428571%">
                                    <a href="https://www.52pojie.cn/forum.php?mod=guide&amp;view=hot" target="_blank"><strong>人气热门（更多）</strong></a>
                                </td>
                                <td align="center" width="21.428571428571%">
                                    <a href="https://www.52pojie.cn/forum.php?mod=guide&amp;view=digest" target="_blank"><strong>精华采撷（更多）</strong></a>
                                </td>
                                <td align="center" width="14.285714285714%" style="border-right:none;">
                                    <a href="https://www.52pojie.cn/misc.php?mod=ranklist&amp;type=member&amp;view=post&amp;orderby=today" target="_blank"><strong>活跃榜</strong></a>
                                </td>
                            </tr>
                            <tr class="fl_row">
                                <td valign="top" width="21.428571428571%" style="border-right:1px solid #CDCDCD; padding:5px;">
                                    <div class="boxbg_7ree" id="newTopicList">
                                    </div>
                                </td>
                                <td valign="top" width="21.428571428571%" style="border-right:1px solid #CDCDCD; padding:5px;">
                                    <div class="boxbg_7ree" id="typeTopicList">

                                    </div>
                                </td>
                                <td valign="top" width="21.428571428571%" style="border-right:1px solid #CDCDCD; padding:5px;">
                                    <div class="boxbg_7ree" id="hotTopicList">

                                    </div>
                                </td>
                                <td valign="top" width="21.428571428571%" style="border-right:1px solid #CDCDCD; padding:5px;">
                                    <div class="boxbg_7ree" id="eliteTopicList">

                                    </div>
                                </td>
                                <td valign="top" width="14.285714285714%" style=" padding:5px;">
                                    <div class="boxbg_7ree" id="activeUserList">

                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="mjs:tip" class="tipinfo_7ree" style="position: absolute;left: 382px;top: 557px;display: none;">
                <strong>搜狗输入法（*New*）v8.17谷歌市场版 亲测没有应用推荐广告！</strong><br>
                版块：『精品软件区』<br>
                作者：天已亮丶人依旧<br>
                时间：2018-01-21 13:08:51<br>
            </div>
            <div class="fl bm">
                <#if parentsBoards?exists>
                    <#list parentsBoards as board>
                        <div class="bm bmw  flg cl">
                            <div class="bm_h cl">
							<span class="o">
								<img id="category_26_img" src="/static/img/collapsed_no.gif" title="收起/展开" alt="收起/展开" onclick="toggle_collapse('category_26');">
							</span>
                                <span class="y">分区版主: <a href="home.php?mod=space&amp;username=Hmily" class="notabs" c="1">Hmily</a></span>
                                <h2><a href="forum.php?gid=26" style="">${board.boardName}</a></h2>
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
                                                    <a href="/board-${childrenBoard.id}.html"><img src="/static/img/forum_new.gif" alt="『${childrenBoard.boardName}』"></a>
                                                </td>
                                                <td>
                                                    <h2>
                                                        <a href="/board-${childrenBoard.id}.html">『${childrenBoard.boardName}』</a>
                                                        <em class="xw0 xi1" title="今日"> (231)</em>
                                                    </h2>
                                                    <p class="xg2">${childrenBoard.boardInfo}</p>
                                                    <p>版主:
                                                        <span class="xi2">
                                                        <a href="home.php?mod=space&amp;username=kuwo911" class="notabs" c="1">kuwo911</a>,
                                                        <a href="home.php?mod=space&amp;username=%B7%E3%D2%B6%C6%AE%C1%E3" class="notabs" c="1">枫叶飘零</a>
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
                                                        <a href="forum.php?mod=redirect&amp;tid=689641&amp;goto=lastpost#lastpost" class="xi2">寻找外挂制作教程</a> <cite>2018-1-21 13:41 <a href="home.php?mod=space&amp;username=E%B7%C9%CF%E8">E飞翔</a></cite>
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
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</div>
<#include "common/footer.ftl">
</body>
</html>
