    <span id="fd_page_top">
        <div class="pg">
            <#if pageInfo.hasPreviousPage>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.prePage}.html" class="nxt">上一页</a>
            <#else >
                <strong>上一页</strong>
            </#if>
            <#list 1..pageInfo.pages as page>
                <#if page=pageInfo.pageNum>
                <strong>${page}</strong>
                <#else >
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                </#if>
            </#list>
        <#--${pageInfo.pageNum}
        <#if pageInfo.pages gt 5>
            <#if pageInfo.pageNum gt 2>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.pageNum-1}.html" class="nxt">${page}</a>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.pageNum-2}.html" class="nxt">${page}</a>
               <strong>${pageInfo.pageNum}</strong>
            <#else >
                <#list 1..3 as page>
                    <#if page=pageInfo.pageNum>
                        <strong>${page}</strong>
                    <#else >
                        <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                    </#if>
                </#list>
                <strong>...</strong>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.pageSize-1}.html" class="nxt">${pageInfo.pages-1}</a>
                <a href="${base}/${pageInfo.link}-${pageInfo.type}-${pageInfo.pageSize}.html" class="nxt">${pageInfo.pages}</a>
            </#if>
        <#else >
            <#list 1..pageInfo.pages as page>
                <#if page=pageInfo.pageNum>
            <strong>${page}</strong>
                <#else >
            <a href="${base}/${pageInfo.link}-${pageInfo.type}-${page}.html" class="nxt">${page}</a>
                </#if>
            </#list>
        </#if>-->
            <label>
                <input type="text" name="custompage" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageNum}" onkeydown="if(event.keyCode==13) {window.location='${base}/${pageInfo.link}-${pageInfo.type}-'+this.value+'.html';}">
                <span title="共 ${pageInfo.pages} 页"> / ${pageInfo.pages} 页</span>
            </label>
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