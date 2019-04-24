<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hello, World</title>
<link rel="stylesheet"
	href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
	height: 100%
}
</style>
</head>

<body>
	<div>
		状态说明【 
		<input type="checkbox" value="allstation" onclick="stationchoose(1);" id="station" />所有站点 
		<input type="checkbox" name="stationtype" value="A" onclick="stationchoose(2);" />A类站点 
		<input type="checkbox" name="stationtype" value="B" onclick="stationchoose(2);" />B类站点
		<input type="checkbox" name="stationtype" value="C" onclick="stationchoose(2);" />C类站点 
		<input type="checkbox" name="stationtype" value="D" onclick="stationchoose(2);" />D类站点 
		】
	</div>
	<div id="container"></div>
</body>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=r8Sf8PxT4oD1liRB0CxpFE3C9FbbFf8M">
	//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
</script>
<script type="text/javascript"
	src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var map = new BMap.Map("container");// 创建地图实例  
	var point = new BMap.Point(119.663056, 29.852344);// 创建点坐标  
	map.centerAndZoom(point, 12);// 初始化地图，设置中心点坐标和地图级别
	var geoc = new BMap.Geocoder();    
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.enableScrollWheelZoom();//启动鼠标滚轮缩放地图
	map.enableKeyboard();//启动键盘操作地图

	<!--选择站点类型实现全选和分选-->
	function stationchoose(obj) {
		var all = document.getElementById("station");
		var stationtypes = document.getElementsByName("stationtype");
		var temp = true;
		if (obj == 1) {//<!--全选，遍历其他勾上checked-->
			if (all.checked == true) {
				for (var i = 0; i < stationtypes.length; i++) {
					stationtypes[i].checked = "checked";
					getmark();
				}
			} else {
				for (var i = 0; i < stationtypes.length; i++) {
					stationtypes[i].checked = "";
				}
			}
		} else {//<!--不全选，遍历其他，如果全都选了则勾上全选-->
			for (var i = 0; i < stationtypes.length; i++) {
				if (stationtypes[i].checked == false) {
					temp = false;
					<!--如果有一个没勾则temp = false-->
					break;
				}
				var tempPoints = mapPoints;
				for(var j =0;j<mapPoints.length;j++){
					if(mapPoints[j].title != stationtypes[i].value){
						mapPoints.remove[j];
					}
				}
				mapPoints = tempPoints;
			}
			if (temp) {
				all.checked = "checked";
				<!--如果全都选了则勾上全选-->
			} else {
				all.checked = "";
				<!--如果temp = false则不能全选-->
			}
		}
	}

	//新建乡镇标记,站点等级:01-->A,2-->B,3--C,4-->D
	var point = new BMap.Point(119.617546,29.849653);
	var marker = new BMap.Marker(point);
	var mapPoints = [
         {x:29.849653,y:119.617546,title:"A",con:"61",branch:"1号站"},
         {x:29.845267,y:119.618049,title:"A",con:"62",branch:"2号站"},
         {x:29.839315,y:119.622145,title:"B",con:"63",branch:"3号站"},
         {x:29.841445,y:119.601735,title:"C",con:"64",branch:"4号站"},
         {x:29.841739,y:119.607943,title:"D",con:"65",branch:"5号站"}
     ];
	 map.addOverlay(marker);
	 map.enableScrollWheelZoom(true);
	 	 
	 //循环
	 function getmark(){
		 for(var i = 0;i<mapPoints.length;i++){
			 var points = new BMap.Point(mapPoints[i].y,mapPoints[i].x);//添加标记
			 var opts = {//展示信息窗口
					 width:250,
			         height:100,
			         title:mapPoints[i].title
			 }
			 var label = new BMap.Label(mapPoints[i].branch,{
				 offset:new BMap.Size(25,5)//标记信息窗口
			 });
			 var infoWindows = new BMap.InfoWindow(mapPoints[i].con,opts);
			 markersshow(points,label,infoWindows,mapPoints[i].con);
		 }
	 }
	 	 
	 //展示标记
	 function markersshow(points,label,infoWindows,con){
		 var markers = new BMap.Marker(points);
		 var markerMenu = new BMap.ContextMenu();
		 map.addOverlay(markers);
		 markers.setLabel(label);
		 markers.addEventListener("click",function(e){
			 console.log("gz");
			 map.openInfoWindow(infoWindows,points);//参数：窗口、点  根据点击的点出现对应的窗口
		 })
		 map.addEventListener("rightclick",function(e){
			  if(e.overlay){//判断右键单击的是否是marker 
				  console.log("con:"+con);//如果是则出现根据station_no查询选项
				  window.location.href="/findeonestationbasic/${con}";  
			  }else{
				  if(confirm("确定添加新站点?")){
					  form = $("<form></form>");
				      form.attr('action',"/addstationbasic");
				      form.attr('method','get');
				      input1 = $("<input type='hidden' name='longitude'/>");
				      input1.attr('value',e.point.lng);//经度 
				      input2 = $("<input type='hidden' name='latitude'/>");
				      input2.attr('value',e.point.lat);//纬度 
				      form.append(input1);
				      form.append(input2);
				      form.appendTo("body");
				      form.css('display','none')
				      form.submit();
				  }else{
					  alert("您取消了添加新站点");
				  }    
			  }
		});  
	 }

	//添加点击事件，点击某坐标，地图级别变为16,并展示以该坐标为中心的新地图
	map.addEventListener("click", function(e) {
		var point = new BMap.Point(e.point.lng, e.point.lat);
		map.centerAndZoom(point, 16);
	//	(e.point.lng + ", " + e.point.lat)地图坐标
	//	("地图缩放至：" + this.getZoom() + "级")地图缩放级别
	});	
	
	//添加点击获取地图信息事件
// 	map.addEventListener("click", function(e){        
// 	    var pt = e.point;
// 	    geoc.getLocation(pt, function(rs){
// 	        var addComp = rs.addressComponents;
	 //     alert(addComp.district + ", " + addComp.street);获取县，街道信息
// 	    });        
// 	});
</script>
</html>