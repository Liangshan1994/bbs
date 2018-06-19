<footer>
    <div id="jz52top">
		<span>
			<a rel="nofollow" title="搜索" class="jzsoso" href="javascript:" onclick="showWindow('jzso','plugin.php?id=jz52_top:jz52_so')">
				<b>搜索</b>
			</a>
		</span>
        <span>
			<a title="聊天室" class="jzwx" id="chatBtn" href="javascript:void(0)">
				<b>聊天室</b>
			</a>
		</span>
        <span>
			<ul id="navmenu">
				<li>
					<a title="个人中心" class="jzwo">
						<b>个人中心</b>
					</a>
					<ul>
						<div id="jzwon">
							<div id="jzgrzxkp" class="jzgrzxkp">
								<div class="jzgrzxkptop">
									<div class="jzgrzxkpthtle">
										<h3>个人中心</h3>
									</div>
									<div class="jzgrzxkpimg">
									</div>
									<div class="jzyhm">
										<a href="home.php?mod=space&amp;uid=313493" target="_blank" title="访问我的空间">千与千寻千般痛</a>
									</div>
								</div>
								<div class="jzgrzxkpbox">
									<a href="home.php?mod=space&amp;do=favorite&amp;view=me" class="box01" target="_blank" title="收藏"></a>
									<a href="forum.php?mod=guide&amp;view=my" class="box02" target="_blank" title="帖子"></a>
									<a href="home.php?mod=space&amp;do=friend" class="box03" target="_blank" title="好友"></a>
									<a href="home.php?mod=space&amp;do=notice" class="box09" target="_blank" title="提醒"></a>
									<a href="home.php?mod=space&amp;do=pm" class="box04" target="_blank" title="消息"></a>
									<a href="home.php?mod=spacecp" class="box05" target="_blank" title="设置"></a>
									<a href="home.php?mod=medal" class="box06" target="_blank" title="勋章"></a>
									<a href="home.php?mod=task" class="box07" target="_blank" title="任务"></a>
								</div>
							</div>
						</div>
					</ul>
				</li>
			</ul>
		</span>
        <span>
			<div style="bottom: 0px;" id="goTopBtn">
				<a title="返回顶部" class="jz52topa">
					<b>返回顶部</b>
				</a>
			</div>
		</span>
    </div>
    <div id="ft" class="wp cl">
        <div id="flk" class="y">
            <p>
                <a href="javascript:void(0)" target="_blank">RSS订阅</a><span class="pipe">|</span>
                <a href="javascript:void(0)">手机版</a><span class="pipe">|</span>
                <a href="javascript:void(0)">小黑屋</a><span class="pipe">|</span>
                <a href="mailto:758831364@qq.com" target="_blank">联系我们</a><span class="pipe">|</span>
                <a href="http://www.miitbeian.gov.cn/" target="_blank">鄂ICP备18007216号</a><span class="pipe"></span>
            </p>
            <p class="xs0">
			${.now}<span id="debuginfo">
			</span>
            </p>
        </div>
        <div id="frt">
            <p>Powered by <strong>SpringBoot</strong></p>
            <p class="xs0">© 2001-2017 Comsenz Inc.</p>
        </div>
    </div>






    <div class="chatContainer">
        <div class="chatBox" ref="chatBox">
            <div class="chatBox-head">
                <div class="chatBox-head-one">
					聊天室(<span class="online-num"></span>人在线)
                    <div class="chat-close" style="font-size: 14px">关闭</div>
                </div>
            </div>
            <div class="chatBox-info">
                <div class="chatBox-kuang" ref="chatBoxkuang">
                    <div class="chatBox-content">
                        <div class="chatBox-content-demo" id="chatBox-content-demo">
                            <#--<div class="clearfloat">
                                <div class="author-name">
                                    <small class="chat-date">2017-12-02 14:26:58</small>
                                </div>
                                <div class="left">
                                    <div class="chat-avatars"><img src="${base}/static/plugins/chat/img/icon02.png" alt="头像"/></div>
									<div class="chat-message">
										给你看张图
									</div>
                                </div>
                            </div>
                            <div class="clearfloat">
                                <div class="author-name">
                                    <small class="chat-date">2017-12-02 14:26:58</small>
                                </div>
                                <div class="right">
                                    <div class="chat-message">嗯，适合做壁纸</div>
                                    <div class="chat-avatars"><img src="${base}/static/plugins/chat/img/icon02.png" alt="头像"/></div>
                                </div>
                            </div>-->

                        </div>
                    </div>
                    <div class="chatBox-send">
                        <div class="div-textarea" contenteditable="true"></div>
                        <div>
                            <button id="chat-fasong" style="width:45px;height:25px" class="btn-default-styles">发送</i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>

        screenFuc();
        function screenFuc() {
            var topHeight = $(".chatBox-head").innerHeight();//聊天头部高度
            //屏幕小于768px时候,布局change
            var winWidth = $(window).innerWidth();
            if (winWidth <= 768) {
                var totalHeight = $(window).height(); //页面整体高度
                $(".chatBox-info").css("height", totalHeight - topHeight);
                var infoHeight = $(".chatBox-info").innerHeight();//聊天头部以下高度
                //中间内容高度
                $(".chatBox-content").css("height", infoHeight - 46);
                $(".chatBox-content-demo").css("height", infoHeight - 46);

                $(".chatBox-list").css("height", totalHeight - topHeight);
                $(".chatBox-kuang").css("height", totalHeight - topHeight);
                $(".div-textarea").css("width", winWidth - 106);
            } else {
                $(".chatBox-info").css("height", 520);
                $(".chatBox-content").css("height", 473);
                $(".chatBox-content-demo").css("height", 473);
                $(".chatBox-kuang").css("height", 520);
                $(".div-textarea").css("width", 620);
            }
        }
        (window.onresize = function () {
            screenFuc();
        })();
        //打开/关闭聊天框
        $("#chatBtn").click(function () {
            var display = $('.chatBox').css('display');
            console.log(display);
            if(display=='none'){
                var userName = $.cookie("chat_userName");
            	console.log(userName);
                if(userName == null){
					userName = prompt("请输入昵称","");
					userName = userName.trim();
					if(userName!=null){
						openChat(userName);
						$.cookie("chat_userName",userName);
						$(".chatBox").toggle(10);
					}
				}else{
					$(".chatBox").toggle(10);
				}
			}else{
				$(".chatBox").toggle(10);
			}
        })
        $(".chat-close").click(function () {
            closeChat();
            $.cookie("chat_userName", "", {expires: -1});
            $('#chatBox-content-demo').html('');
            $(".chatBox").toggle(10);
        })

        //      发送信息
        $("#chat-fasong").click(function () {
            var textContent = $(".div-textarea").html().replace(/[\n\r]/g, '<br>')
            if (textContent != "") {
                sendmessage(textContent);
                //发送后清空输入框
                $(".div-textarea").html("");
                //聊天框默认最底部
                $(document).ready(function () {
                    $("#chatBox-content-demo").scrollTop($("#chatBox-content-demo")[0].scrollHeight);
                });
            }
        });
    </script>
    <script type="application/javascript">
        var websocket = null;
        var cahtNum = $('.chat-num').text();
        function openChat(userName){
			if ('WebSocket' in window) {
				websocket = new WebSocket('ws://localhost:8080/bbs/webSocket/'+userName);
			} else {
				alert('该浏览器不支持websocket');
			}
            websocket.onopen = function (event) {
                console.log('websocket建立连接');
            }
            websocket.onclose = function (event) {
                console.log('websocket关闭连接');
                $(".chatBox-content-demo").append("<div class='new-online'><span class='chat-date'>"+event.result.userName+"离开聊天室</span></div>");
                websocket.close();
            }
            websocket.onmessage = function (event) {
                console.log('websocket收到消息' + event.data);
                var result = $.parseJSON(event.data);
                var sessionId = $.cookie("chat_sessionId");
                //有新连接加入
                if (result.type == 1) {
                    if(sessionId!=result.sessionId){
                        $(".chatBox-content-demo").append("<div class='new-online'><span class='chat-date'>"+result.userName+"加入聊天室</span></div>");
                    }else{
                        $(".chatBox-content-demo").append("<div class='new-online'><span class='chat-date'>欢迎加入聊天室</span></div>");
                    }
                }
                if(result.type == 2){
                    $(".chatBox-content-demo").append("<div class='new-online'><span class='chat-date'>"+result.userName+"离开聊天室</span></div>");
				}
                if (result.type == 3) {
                    var html = "";
                    html += "<div class='clearfloat'>";
                    html += "<div class='author-name'><small class='chat-date'>" + result.createDate + "</small> </div> ";
                    if(sessionId==result.sessionId){
                        html += "<div class='right'> <div class='chat-message'> " + result.message + " </div> ";
                        html += "<div class='chat-avatars'><img src='${base}/static/plugins/chat/img/icon02.png' alt='头像' /></div> </div>";
                    }else{
                        html += "<div class='left'> <div class='chat-avatars'><img src='${base}/static/plugins/chat/img/icon02.png' alt='头像' /></div>";
                        html += "<div class='chat-message'> " + result.message + " </div></div> ";
                    }
                    html += "</div>";
                    $(".chatBox-content-demo").append(html);
                }
                $('.online-num').text(result.userNum);
            }
            websocket.onerror = function (event) {
                console.log('websocket通信发生错误');
            }
            // window.onbeforeunload = function (event) {
            //     websocket.close();
            // }
		}
        function closeChat(){
			websocket.close();
		}

        $('.send-message').click(function () {
            var message = $('.chat-message').val();
            if (message == "") {
                mdui.alert('请输入要发送的消息');
                return;
            }
            sendmessage(message);
            $('.chat-message').val("");
        })
        function sendmessage(message) {
            websocket.send(message);
        }
    </script>
</footer>