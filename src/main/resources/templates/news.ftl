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
    ${news.content}
    </main>
    </div>
</div>

<#--<#include "common/page.ftl">-->
<#include "common/footer.ftl">
</body>
</html>