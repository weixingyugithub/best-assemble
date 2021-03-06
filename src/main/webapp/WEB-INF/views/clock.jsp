<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<title>时钟</title>
<meta http-equiv= "Expires " content= "0 "> 
<meta http-equiv= "kiben " content= "no-cache "> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static/clock/js/jquery-1.10.2.js"></script>
        <link type="text/css" href="static/clock/css/reset.css"/>
        <style type="text/css">
            .box {margin: 10px auto; width: 894px; height: 863px;}
            .clock {position: relative; width: 894px; height: 863px; background: url("clock/images/bg.png") no-repeat;}
            .second-hand,.minute-hand,.hour-hand {position: absolute; left: 50%; margin-left: -6px; top: -13px; width: 20px; height: 894px; background: url("clock/images/clock_needle.png") no-repeat;}
            .second-hand {background-position: -1px 59px; z-index: 1000;}
            .minute-hand {background-position: -25px 56px; z-index: 100;}
            .hour-hand {background-position: -54px 56px; z-index: 10;}

        </style>
        <script type="text/javascript">
            $(function(){
                var $second = $(".second-hand"), /* 秒针 */
                        $minute = $(".minute-hand"), /* 分针 */
                        $hour = $(".hour-hand"), /* 时针 */
                        timer = setInterval(nowTime,1000); /* 循环调用，一秒后调用一次 */
                function nowTime(){
                    function getTime(){
                        var now = new Date();
                        return {
                            hours: now.getHours() + now.getMinutes() / 60, /* 小时数，包括分钟数 */
                            minutes: now.getMinutes() + now.getSeconds() / 60, /* 分针数，包括秒数 */
                            seconds: now.getSeconds() /* 秒数 */
                        }
                    }
                    var _date = getTime(); /* 接收的时间对象 */
                    var _secondRotate = Math.floor(_date.seconds) * 6; /* 秒针，一圈360度总共是60秒（60格），一秒（一格）就是6度，乘以6的主要原因就是秒数乘以一格的度数等于总度数 */
                    var _minuteRotate = _date.minutes * 6; /* 分针，一圈360度总共是60分钟，和秒数解释类似 */
                    var _hourRotate =  (_date.hours % 12) * 30; /* 时针，一圈360度是12个小时，一个小时就是30度（其实也是5格），小时数乘以一小时的度数就是总度数。但是要考虑大于12的小时数，这里采取整除12的方发即可实现 */
                    $second.css({"transform":"rotate("+_secondRotate+"deg)"}); /* 设置秒针旋转度 */
                    $minute.css({"transform":"rotate("+_minuteRotate+"deg)"}); /* 设置分针旋转度 */
                    $hour.css({"transform":"rotate("+_hourRotate+"deg)"}); /* 设置时针旋转度 */
                }

            })
        </script>

</head>
	<body>
        <div class="box">
            <div class="clock">
                <div class="second-hand"></div>
                <div class="minute-hand"></div>
                <div class="hour-hand"></div>
            </div>
        </div>
    </body>
</html>