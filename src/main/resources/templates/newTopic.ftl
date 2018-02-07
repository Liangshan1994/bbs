<!DOCTYPE html>
<html>
<head>
  <#include "common/head.ftl">
  <title>发表帖子 - ${board.boardName}</title>
</head>
<body>
<#include "common/header.ftl">

<div class="wp" id="wp">
    <div id="pt" class="bm cl">
        <div class="z">
            <a href="${base}/" class="nvhm" title="首页"></a>  <em>›</em>
            <a rel="index" href="${base}/">网站</a> <em>›</em>
            <a href="${base}/board-${board.parentBoard.id}.html">${board.parentBoard.boardName}</a> <em>›</em>
            <a href="${base}/board-${board.id}.html">${board.boardName}</a><em>›</em>
            发表帖子
        </div>
    </div>
    <form method="post" id="postform" action="/saveNewTopic">
        <div id="ct" class="ct2_a ct2_a_r wp cl">
            <input type="hidden" name="boardId" value="${board.id}">
            <div class="bm bw0 cl" id="editorbox">
                <ul class="tb cl mbw">
                    <li class="a">
                        <a href="/newTopic-${board.id}.html">发表帖子</a>
                    </li>
                    <li>
                        <a href="javascript:alert('等待开发')" >发起投票</a>
                    </li>
                </ul>
                <div id="postbox">
                    <div class="pbt cl">
                        <div class="ftid">
                            <select name="type" id="typeid">
                                <option value="0">选择主题分类</option>
                                <option value="1">主题类别1</option>
                                <option value="2">主题类别2</option>
                                <option value="3">主题类别3</option>
                            </select>
                        </div>
                        <div class="z">
                            <span>
                                <input type="text" name="title" class="px" style="width: 25em" tabindex="1">
                            </span>
                        </div>
                    </div>
                    <script id="editor" name="content" style="height:400px;width:800px ;" >

                    </script>
                    <div class="mtm mbm pnpost">
                        <button type="submit" class="pn pnc">
                            <span>发表帖子</span>
                        </button>
                        <span id="adddynamicspan">
                            <label>
                                <input type="checkbox" name="adddynamic" value="true" class="pc" checked="checked">转播给听众
                            </label>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script>
        var ue = UE.getEditor('editor',{imageUrlPrefix:"${base}"});
    </script>
</div>

<#include "common/footer.ftl">
</body>
</html>