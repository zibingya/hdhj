<html>
<head>   
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
     <!--ExtJs框架开始ʼ-->
	   <script type="text/javascript" src="../static/ext-4.2.1/ext-all.js"></script>
       <script type="text/javascript" src="../static/ext-4.2.1/locale/ext-lang-zh_CN.js"></script>
       <link href="../static/ext-4.2.1/resources/ext-theme-classic/ext-theme-classic-all.css"
	         rel="stylesheet" type="text/css" />
     <!--ExtJs框架结束-->	
	 <!--引入百度api-->  	
	 <script type="text/javascript"
	   src="http://api.map.baidu.com/api?v=2.0&ak=r8Sf8PxT4oD1liRB0CxpFE3C9FbbFf8M">
	   //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
       </script>
     <script type="text/javascript"
	   src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
</head>
 <body>
 <div id="container" ></div>
</body>
<script type="text/javascript" src="../static/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../static/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
Ext.onReady(function () {
  Ext.create('Ext.Panel', {
    width: document.body.clientWidth,
    height: document.body.clientHeight,
    title: "主页",
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    renderTo: document.body,
    items: [{
        xtype: 'panel',
        title: '菜单栏',
        flex: 1
    },{
        xtype: 'panel',
        title: '地图',
        flex: 5,
        anchor: '80%  '  , 
                border : false,
                el:'container' , 
                layout : 'border',  
                renderTo : Ext.getBody() ,
                bodyStyle: "padding:500px"
    },{
        xtype: 'treepanel',
        title: '站点',
        flex: 1,
        expanded : true,
            x:'1400', 
			animate : true,
			enableDD : false,
			rootVisible : false, // 不显示根节点Root
            border : false,
            root:{
               autoShow : true,
               children: [
                   { text: "桐庐县", expanded: true, children: [
                   { text: "城南街道", expanded: false, children: [
                       { text: "gz1", leaf: true },
                       { text: "gz2", leaf: true}
                   ]},
                   { text: "桐君街道", expanded: false, children: [
                       { text: "gz3", leaf: true },
                       { text: "gz4", leaf: true}
                   ]},
                   { text: "旧县街道", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "江南镇", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "凤川街道", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "新合乡", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "富春江镇", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "横村镇", expanded: false,id:'h', children: [
                       { text: "横村镇1号池", leaf: true,id:'61'},
                       { text: "横村镇2号池", leaf: true,id:'62'},
                       { text: "横村镇3号池", leaf: true,id:'63' },
                       { text: "横村镇4号池", leaf: true,id:'64'},
                       { text: "横村镇5号池", leaf: true,id:'65' },
                       { text: "横村镇6号池", leaf: true,id:'66'},
                       { text: "横村镇7号池", leaf: true,id:'67' },
                       { text: "横村镇8号池", leaf: true,id:'68'},
                       { text: "横村镇9号池", leaf: true,id:'69' },
                       { text: "横村镇10号池", leaf: true,id:'70'},
                   ]},
                   { text: "钟山乡", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "莪山乡", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "瑶琳镇", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "分水镇", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "合村乡", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]},
                   { text: "百江镇", expanded: false, children: [
                       { text: "gz", leaf: true },
                       { text: "gzz", leaf: true}
                   ]}
               ]},  
            ]
            
        }
        
     }]
     
  });
    listeners: {
		var hengcun = Ext.getCmp('h');  
		         
    }   
})


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
	
	//新建乡镇标记,站点等级:01-->A,2-->B,3--C,4-->D
	var point = new BMap.Point(119.617546,29.849653);
	var marker = new BMap.Marker(point);
	var mapPoints = [
         {x:29.849653,y:119.617546,title:"A",con:"2",branch:"横村镇1号池"},
         {x:29.845267,y:119.618049,title:"A",con:"62",branch:"横村镇2号池"},
         {x:29.839315,y:119.622145,title:"B",con:"63",branch:"横村镇3号池"},
         {x:29.841445,y:119.601735,title:"C",con:"64",branch:"横村镇4号池"},
         {x:29.841739,y:119.607943,title:"D",con:"65",branch:"横村镇5号池"},
         {x:29.838200,y:119.629241,title:"A",con:"66",branch:"横村镇6号池"},
         {x:29.831934,y:119.613934,title:"C",con:"67",branch:"横村镇7号池"},
         {x:29.840487,y:119.597944,title:"B",con:"68",branch:"横村镇8号池"},
         {x:29.834754,y:119.630463,title:"D",con:"69",branch:"横村镇9号池"},
         {x:29.838325,y:119.620115,title:"A",con:"70",branch:"横村镇10号池"}
     ];
	 map.enableScrollWheelZoom(true);
		 for(var i = 0;i<mapPoints.length;i++){
			 var points = new BMap.Point(mapPoints[i].y,mapPoints[i].x);
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
	 	 
	 //添加标记内容
	 function markersshow(points,label,infoWindows,con){
		 var markers = new BMap.Marker(points);
		 var markerMenu = new BMap.ContextMenu();
		 map.addOverlay(markers);
		 markers.setLabel(label);
		 markers.addEventListener("click",function(e){
			 console.log("gz");
			 map.openInfoWindow(infoWindows,points);//参数：窗口、点  根据点击的点出现对应的窗口
		 });
		 markers.addEventListener("rightclick",function(e){
			 if(e.type=='onrightclick'){//判断右键单击的是否是marker 
				 console.log("con:"+con);//如果是则出现根据station_no查询选项
				 findstation(con);    
			  }
		});  
	 }
	 
	 //传值到后台查询单个站点详细信息
	 function findstation(con){
	    $.ajax({
				 type:"get",
				 url:"/findonestationbasic/"+con,
				 success:function(){
				     window.location.href="/findonestationbasic/"+con;
				 }
		})
	 }
	 
	 

	//添加点击事件，点击某坐标，地图级别变为16,并展示以该坐标为中心的新地图
	map.addEventListener("click",function(e) {
		var point = new BMap.Point(e.point.lng, e.point.lat);
		map.centerAndZoom(point, 16);
	//	(e.point.lng + ", " + e.point.lat)地图坐标
	//	("地图缩放至：" + this.getZoom() + "级")地图缩放级别
	});	
	
	//添加点击获取地图信息事件
// 	map.addEventListener("click",function(e){        
// 	    var pt = e.point;
// 	    geoc.getLocation(pt, function(rs){
// 	        var addComp = rs.addressComponents;
	 //     alert(addComp.district + ", " + addComp.street);获取县，街道信息
// 	    });        
// 	});  
</script>
</html>