/**
 * @author ToFishes
 * @version 1.0
 * @desc 内容遮罩插件及弹出面板插件，类似于blockUI插件
 */
;(function($){
    var ie6 = !-[1,] && !window.XMLHttpRequest;
    /*
     * jCover
     * 内容遮罩插件，可用于元素遮罩或窗口遮罩
	 * 参数可以是：
	 * {
	 *     msg: "" //可选的，遮罩上面可以显示一些信息
	 *     className: "j-cover" //遮罩元素的类名，如果与已有类名冲突，可以在这里修改
	 *     coverCss:  {} //遮罩的样式定义，一般定义背景色，透明度，鼠标指针即可
	 *     msgCss: {} //遮罩提示信息的样式定义，默认是绝对定位，top,left为0
	 *	   cache: true //开启遮盖缓存，如果在同一个元素上显示不同的msg,则应该设置为false
	 *
	 * }
	 * 
	 * 使用：
	 * {
	 * 		开启遮罩：$.jCover({showWait:true});
	 * 		关闭遮罩：$.jCover({showWait:false});
	 * }
     * */
    $.jCover = $.fn.jCover = function(c){
        c = $.extend({
            msg: "",
            waitImg: basePath + 'static/images/waiting/waiting2.gif',
            className: "j-cover",
            showWait:false,
		    cache: true //开启遮盖缓存，如果在同一个元素上显示不同的msg,则应该设置为false
        }, c);
        c.coverCss = $.extend({
            "top": 0,
            "left": 0,
            "z-index": 9000,
            "opacity": 0.5,
            "background": "#ccc",
            "cursor": "default",
		    "margin": 0,
			"padding": 0
        }, c.coverCss);
        c.msgCss = $.extend({
            "position":"absolute",
            "top":"45%",
            "left":"45%",
            "z-index":"9001",
            "color":"#ff9900",
            "font": "bold 85% 微软雅黑,sans-serif"
        }, c.msgCss);
        
        c.waitImgCss = $.extend({
            "position":"absolute",
            "top":"40%",
            "left":"45%",
            "z-index":"9002",
            "border": "none"
        }, c.waitImgCss);
 
        var $body = $("body"), $html = $("html");
        $body.add($html).css({height: "100%"});
        var full = ! this.jquery,  $o = full ? $body : this;
        return $o.each(function(){
            var _t = $(this), cover = _t.data("jCover");
			if(_t.hasClass("jCovering"))
				_t.jUnCover();
            if(c.cache && cover && cover.parent().length) { //如果开启了缓存，确保cover对象存在并且位于dom中
                cover.show();
            } else {
                !full && _t.css("position", "relative");
                var flag = ie6 || ! full,
                css = $.extend(c.coverCss, {
                    position: flag ? "absolute" : "fixed",
                    height: flag ? _t.innerHeight() : "100%",
                    width: flag ? _t.innerWidth() : "100%"
                });
 
                cover = $(['<p class="', c.className, '"></p>'].join("")).css(css);
                if(c.showWait){
                	cover = cover.add($("<img></img>").attr("src",c.waitImg).css(c.waitImgCss));
                }
                if(c.msg) {
                    cover = cover.add($("<div></div>").html(c.msg).css(c.msgCss));
                };
                _t.append(cover).data("jCover", cover).addClass("jCovering"); 
            };			
			if(ie6) {
				$("select:visible", _t).css("visibility", "hidden").addClass("select-jcover-hidden");
			};
			$(window).resize(function(){
				cover.css({
/*					height: _t.innerHeight(),
					width: _t.innerWidth()*/
				});
			});
        });
    };
    /*
     * 配套的取消内容遮罩的插件
     * */
    $.jUnCover = $.fn.jUnCover = function(){
       var $o = this.jquery ? this : $("body");
       $o.each(function(){
           $(this).data("jCover").fadeOut(300);
           ie6 && $("select.select-jcover-hidden", $(this)).css({"visibility": "visible"}).removeClass("select-jcover-hidden");
       });
    };
})(jQuery);