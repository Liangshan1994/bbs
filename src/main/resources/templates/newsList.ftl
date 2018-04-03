<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
    <title>新闻 - 皮卡丘</title>
</head>
<body>
<#include "common/header.ftl">

<div class="container clearfix">
    <nav class="clearfix" id="nav">
        <div class="clearfix">
            <div class="nav_com">
                <ul>
                    <li class=""><a href="/">推荐</a></li>
                    <li class="active"><a href="//news">最新文章</a></li>
                    <li class=""><a href="${base}/news">关注</a></li>
                    <li class=""><a href="${base}/news-1-1.html">IT互联网</a></li>
                    <li class=""><a href="${base}/news">人工智能</a></li>
                    <li class=""><a href="${base}/news">云计算/大数据</a></li>
                    <li class=""><a href="${base}/news">区块链</a></li>
                    <li class=""><a href="${base}/news">数据库</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="fixed_content">
        <main>
            <ul class="feedlist_mod" id="feedlist_id" style="padding-top: 0px;">
                <#list pageInfo.list as news>
                    <li class="clearfix" data-type="blog" data-id="${news.id}">
                        <div class="list_con">
                            <div class="title">
                                <h2 class="csdn-tracking-statistics">
                                    <a strategy="watchers" href="${base}/news-${news.id?c}.html" target="_blank">${news.title}</a>
                                </h2>
                            </div>
                            <dl class="list_userbar">
                                <dd class="strategy">来源:简书</dd>
                                <dd class="name">
                                    作者:<a href="javascript:;">${news.author}</a>
                                </dd>
                                <dd class="time csdn-tracking-statistics tracking-click">
                                    <a strategy="watchers" href="${base}/news-${news.id?c}.html" target="_blank">${news.pushDate?string('yyyy-MM-dd HH:mm')}</a>
                                </dd>
                                <dd class="strategy">
                                    <a strategy="watchers" href="${base}/news-${type}-1.html" target="_blank">IT互联网</a>
                                </dd>
                                <!--新增评论数+阅读 begin-->
                            <#--
                                                        <dd class="common_num"><a target="_blank" class="csdn-tracking-statistics tracking-click" href="http://blog.csdn.net/po86BHac10C4/article/details/79564376#comment_form" data-mod="popu_459" strategy="career">  <svg><path id="v0.2" d="M4,15V12H3a2,2,0,0,1-2-2V4A2,2,0,0,1,3,2H13a2,2,0,0,1,2,2v6a2,2,0,0,1-2,2H8ZM3,3A.94.94,0,0,0,2,4v6a.94.94,0,0,0,1,1H5v2l2.7-2H13a1.08,1.08,0,0,0,1-1V4a.94.94,0,0,0-1-1Z" transform="translate(-1 -2)"></path></svg>13</a></dd>
                            -->
                                <!--新增评论数+阅读 end-->
                            </dl>
                            <!--阅读 begin-->
                            <div class="read_num">
                                <p class="num">${news.view}</p>
                                <p class="text">阅读量</p>
                            </div>
                            <!--阅读 end-->
                        </div>
                    </li>
                </#list>
            </ul>
        </main>
    </div>

</div>


<#--<#include "common/page.ftl">-->
<#include "common/footer.ftl">
</body>
</html>