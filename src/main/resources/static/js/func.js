/**
 * 通用公共方法
 * Created by lvls on 2018/1/30.
 */
$(document).ready(function() {

});

// 恢复提示框显示
function resetTip(){
    top.$.jBox.tip.mess = null;
}

// 关闭提示框
function closeTip(){
    top.$.jBox.closeTip();
}

//显示提示框
function showTip(mess, type, timeout, lazytime){
    //resetTip();
    setTimeout(function(){
        $.jBox.tip(mess, (type == undefined || type == '' ? 'info' : type), {opacity:0,
            timeout:  timeout == undefined ? 2000 : timeout});
    }, lazytime == undefined ? 500 : lazytime);
}
