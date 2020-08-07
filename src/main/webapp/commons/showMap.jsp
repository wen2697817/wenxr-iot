<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/meta2.jsp" %>
<script src="http://api.map.baidu.com/api?v=1.5&ak=DjAIL1DOGGcSjUISQGofkeOV"></script>
<script>
$(function(){
	$("#map").height($(document).height());
	initalizeMap();
});
function initalizeMap() {
	var point,v = '<s:property value="#parameters.coord[0]"/>';
	var map = new BMap.Map('map');
	if (v && v.indexOf(",") > 0) {
		point = new BMap.Point(parseFloat(v.split(",")[0]), parseFloat(v.split(",")[1]));
		marker = new BMap.Marker(point);// 创建标注
		map.addOverlay(marker); // 将标注添加到地图中
		map.centerAndZoom(point, v ? 17 : 12);
	} else {
		var myCity = new BMap.LocalCity();
		myCity.get(myFun);
	}

	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	function myFun(result) {
		point = new BMap.Point(result.center.lng, result.center.lat);
		map.centerAndZoom(point, v ? 17 : 12);
	}
}
</script>
</head>
<body style="margin: 0px;">
<div id="map" style="width:100%;height:100%;margin: 0px;"></div>
</body>
</html>
