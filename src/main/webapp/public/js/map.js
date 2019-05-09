Ext.onReady(function(){
            Ext.create('Ext.panel.Panel',{
                renderTo:Ext.getBody(),
                //一般只需要layout属性就可以,requires和xtype不是必须的
                layout:'column',
                requires:['Ext.layout.container.Column'],
                xtype:'layout-column',
                width:document.body.columnWidth,
                items:[{
                    xtype : 'panel',
                    title : '地图',
                    border : 'false',
                    el : 'container',
                    layout : 'border', 
                    bodyStyle : 'padding:500px',
                    columnWidth:0.85
                },{
                    title : '搜索栏待定',
                    columnWidth:0.15,
                    items:townandvillage,
                    html:'告警系统叽叽叽'
                }]
            });

    //定义station数据model
    Ext.define('station', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'station_no', type: 'int'},
            {name: 'station_kind',  type: 'string'},
            {name: 'station_name',  type: 'string'},
            {name: 'station_phone',  type: 'string'},
            {name: 'station_manager',  type: 'string'},
            {name: 'station_town',  type: 'string'},
            {name: 'station_village',  type: 'string'},
            {name: 'station_longitude',  type: 'string'},
            {name: 'station_longitude',  type: 'string'},
            {name: 'station_latitude',  type: 'string'},
            {name: 'station_description',  type: 'int'},
            {name: 'station_pictureoldname',  type: 'string'},
            {name: 'station_picturenewname',  type: 'string'},
            {name: 'station_pictureurl',  type: 'string'},
            {name: 'station_waterwarningtype',  type: 'string'},
            {name: 'station_watermax',  type: 'double'},
            {name: 'station_watermin',type:'double'}
        ]
    });

    

    //从ajax url获取站点数据
    var stationstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        model: 'station',
        proxy : {
            type : 'ajax',
            url:'/getstationbasic/list',
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
            //    root : 'content',
            //   totalProperty: 'totalElements' //数据总条数
            }
        },
        autoLoad : true,// 即时加载数据

        //加载后拿到所要的部分数据
        listeners: {  
            'load': function mapPo(a,b) {  //(store，array)
              //  console.log('==================');
              //  console.log(b);
              // console.log(b[0].data.station_town);
                markPoint(b);
            }  
        }  
    }); 

     function  ObjStory(x,y,title,con,branch) 
     {
        this.x = x;
        this.y = y;
        this.title = title;
        this.con = con;
        this.branch = branch;
     }

    //mappoints添加数据
    function markPoint(b){
        for (var i = 0; i < b.length; i++) {
                    var record = b[i].data;
         //  通过objstory方法添加进数组
         mapPoints.push(new ObjStory(record.station_latitude,record.station_longitude,record.station_kind,record.station_no,record.station_name));
        }
        showmap();//添加完数据展示地图

        //重组数据使之适合tree展示
        
    }

});

    

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
    var point = new BMap.Point(119.617546, 29.849653);
    var marker = new BMap.Marker(point);
    var mapPoints = new Array();
    map.enableScrollWheelZoom(true);
    function showmap(){
        for (var i = 0; i < mapPoints.length; i++) {
        var points = new BMap.Point(mapPoints[i].y, mapPoints[i].x);
        var opts = {//展示信息窗口
            width : 250,
            height : 100,
            title : mapPoints[i].title
        }
        var label = new BMap.Label(mapPoints[i].branch, {
            offset : new BMap.Size(25, 5)
        //标记信息窗口
        });
        var infoWindows = new BMap.InfoWindow(mapPoints[i].con, opts);
        markersshow(points, label, infoWindows, mapPoints[i].con);
    }
    }
    

    //添加标记内容
    function markersshow(points, label, infoWindows, con) {
        var markers = new BMap.Marker(points);
        var markerMenu = new BMap.ContextMenu();
        map.addOverlay(markers);
        markers.setLabel(label);
        markers.addEventListener("click", function(e) {
          //  console.log("gz");
            map.openInfoWindow(infoWindows, points);//参数：窗口、点  根据点击的点出现对应的窗口
        });
        markers.addEventListener("rightclick", function(e) {
            if (e.type == 'onrightclick') {//判断右键单击的是否是marker 
           //     console.log("con:" + con);//如果是则出现根据station_no查询选项
                findstation(con);
            }
        });
    }

    //传值到后台查询单个站点详细信息
    function findstation(con) {
      /**  $.ajax({
            type : "get",
            url : "/getonestationbasic/" + con,
            success : function() {
                window.location.href = "/getonestationbasic/" + con;
            }
        })*/
        window.location.href = "./station.html?con="+con;
       // console.log("window.location.href:"+window.location.href);
    }



    //添加点击事件，点击某坐标，地图级别变为16,并展示以该坐标为中心的新地图
    map.addEventListener("click", function(e) {
        var point = new BMap.Point(e.point.lng, e.point.lat);
        map.centerAndZoom(point, 16);
        //  (e.point.lng + ", " + e.point.lat)地图坐标
        //  ("地图缩放至：" + this.getZoom() + "级")地图缩放级别
    });

    //添加点击获取地图信息事件
    //  map.addEventListener("click",function(e){        
    //      var pt = e.point;
    //      geoc.getLocation(pt, function(rs){
    //          var addComp = rs.addressComponents;
    //     alert(addComp.district + ", " + addComp.street);获取县，街道信息
    //      });        
    //  });
    //定义station树模型
    /**思路：
       for(i=0；i<所有桐庐县记录条数；i++){
           ext.getcmp(town).setvalue(i镇);
           for(j=0;j<所有第i镇纪录条数；j++){
               ext.getcmp(village).setvalue(j村);
           }
       }
    */
    //这里要重组数据
    var store = Ext.create('Ext.data.TreeStore', {
        root: {
            expanded: true,
            children: [ 
                { text: "桐庐县", expanded: true, children: [
                    { text: "城南街道",id:'town', expanded: true, children:[ 
                            {text : "gz3",id:'village', leaf : true}, 
                            {text : "gz4",leaf : true}
                    ]},
                    { text: "桐君街道", id:'town',expanded: true, children:[
                            {text : "gz3", leaf : true}, 
                            {text : "gz4",leaf : true}
                    ]},
                ]}
            ]
        }
    });

        var townandvillage = Ext.create('Ext.tree.Panel', {
            title: '对象',
            width: 200,
            height: 500,
            store: store,
            rootVisible: false
        });    