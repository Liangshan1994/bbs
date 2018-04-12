<div id="pageDiv">
    <span id="fd_page_top">
        <div class="pg">
            <#--上一页-->
            <#if pageInfo.hasPreviousPage>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.prePage}.html" class="nxt">上一页</a>
            <#else >
                <strong>上一页</strong>
            </#if>
            <#--中间页码(关键)-->
            <#--总页数小于10页-->
            <#if pageInfo.pages lt 11>
                <#list 1..pageInfo.pages as page>
                    <#if page=pageInfo.pageNum>
                        <strong>${page}</strong>
                    <#else >
                        <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                    </#if>
                </#list>
            <#--总页数大于10页 且当前页小于10-->
            <#elseif pageInfo.pageNum lt 10>
                <#list 1..10 as page>
                    <#if page=pageInfo.pageNum>
                        <strong>${page}</strong>
                    <#else >
                        <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                    </#if>
                </#list>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-1.html" class="nxt">...${pageInfo.pages}</a>
            <#--总页数大于10页 且当前页小于10-->
            <#elseif pageInfo.pageNum gt 9>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-1.html" class="nxt">1...</a>
                <#if pageInfo.pageNum+4 lt pageInfo.pages>
                    <#list (pageInfo.pageNum-4)..(pageInfo.pageNum+4) as page>
                        <#if page=pageInfo.pageNum>
                            <strong>${page}</strong>
                        <#else >
                            <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                        </#if>
                    </#list>
                    <a href="${base}/${pageInfo.link}-${pageInfo.type}-1.html" class="nxt">...${pageInfo.pages}</a>
                <#else >
                    <#list (pageInfo.pageNum-4)..pageInfo.pages as page>
                        <#if page=pageInfo.pageNum>
                            <strong>${page}</strong>
                        <#else >
                            <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                        </#if>
                    </#list>
                </#if>
            </#if>

            <#--输入页码跳转-->
            <label>
                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/${pageInfo.link}-${pageInfo.type}-'+this.value+'.html';}">
                <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
            </label>
            <#--下一页-->
            <#if pageInfo.hasNextPage>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.nextPage}.html" class="nxt">下一页</a>
            <#else >
                <strong>下一页</strong>
            </#if>

        </div>
    </span>
    <span class="pgb y" id="visitedforums">
        <a rel="index" href="javascript:history.go(-1)">返&nbsp;回</a>
    </span>
</div>