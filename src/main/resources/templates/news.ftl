<!DOCTYPE html>
<html>
<head>
    <#include "common/head.ftl">
    <title>新闻 - 皮卡丘</title>
    <script>
        $(function(){
            var type = $('#newsType').val();
            if(type==1){//来源简书
                $('.image-package img').each(function(v,e){
                    var src = $(e).attr('data-original-src');
                    $(e).attr('src',src);
                })
            }else if(type==2){//来源IT之家
                $('.lazy').each(function(v,e){
                    var src = $(e).attr('data-original');
                    $(e).attr('src',src);
                })
            }
        })
    </script>
</head>
<body>
<#include "common/header.ftl">
<div id="wp" class="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="${base}/" class="nvhm" title="首页"></a><em>»</em>
            <a href="${base}/news">新闻</a><em>›</em>
            <a href="${base}/">${news.type}</a> <em>›</em>
            <a href="${base}/">${news.title}</a>
        </div>
    </div>
    <div class="container clearfix">
        <nav class="col-1" id="nav">
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
        <div class="fixed_content col-8">
            <input type="hidden" value="${news.source}" id="newsType">
            <div class="post_title">
                <h1>${news.title}</h1>
                <span class="pt_info">
                    <span>${news.pushDate?string('yyyy-MM-dd HH:mm')}</span>
                    <span>/ 来源：${news.source?if_exists}</span>
                    <span>/ 作者：${news.author?if_exists}</span>
                    <span>/ 阅读：${news.view?if_exists}</span>
                    <a href="${news.link?if_exists}" alt="${news.title?if_exists}">查看原文</a>
                </span>
            </div>
            <div class="post_content">
            ${news.content}
            </div>
        </div>
    </div>
</div>
<#--<#include "common/page.ftl">-->
<#include "common/footer.ftl">
</body>
</html>