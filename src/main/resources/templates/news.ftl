<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>新闻 - 皮卡丘</title>
</head>
<body>
<#include "common/header.ftl">

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
                <a href="${base}/news-${page}.html" class="nxt">${page}</a>
              </#if>
            </#list>
            <label>
                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/-'+this.value+'.html';}">
                <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
            </label>
            <#if pageInfo.hasNextPage>
                <a href="${base}/board-${pageInfo.nextPage}.html" class="nxt">下一页</a>
            <#else >
                <strong>下一页</strong>
            </#if>
        </div>
    </span>
    <span class="pgb y" id="visitedforums">
        <a rel="index" href="javascript:history.go(-1)">返&nbsp;回</a>
    </span>
</div>
<#include "common/footer.ftl">
</body>
</html>