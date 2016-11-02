<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Expires " content="0 ">
<meta http-equiv="kiben " content="no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<script type="text/javascript">
	var map = new BMap.Map("allmap");

	var point = new BMap.Point(116.331398, 39.897445);

	map.centerAndZoom(point, 12);

	var geolocation = new BMap.Geolocation(); //实例化浏览器定位对象。

	//下面是getCurrentPosition方法。调用该对象的getCurrentPosition()，与HTML5不同的是，这个方法原型是getCurrentPosition(callback:function[, options: PositionOptions])，也就是说无论成功与否都执行回调函数1，第二个参数是关于位置的选项。 因此能否定位成功需要在回调函数1中自己判断。

	geolocation.getCurrentPosition(function(r) { //定位结果对象会传递给r变量

		if (this.getStatus() == BMAP_STATUS_SUCCESS) { //通过Geolocation类的getStatus()可以判断是否成功定位。

			var mk = new BMap.Marker(r.point); //基于定位的这个点的点位创建marker

			map.addOverlay(mk); //将marker作为覆盖物添加到map地图上

			map.panTo(r.point); //将地图中心点移动到定位的这个点位置。注意是r.point而不是r对象。

			alert('您的位置：' + r.point.lng + ',' + r.point.lat); //r对象的point属性也是一个对象，这个对象的lng属性表示经度，lat属性表示纬度。

		}

		else {

			alert('failed' + this.getStatus());

		}

	}, {
		enableHighAccuracy : true
	})
	
	</script>

	</head>
	<body>
		123
	</body>
	</html>
