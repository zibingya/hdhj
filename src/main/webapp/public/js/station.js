Ext.onReady(function(){
	var tabs = new Ext.TabPanel({   
                 region: 'center', //border 布局，将页面分成东，南，西，北，中五部分，这里表示TabPanel放在中间   
                 margins: '3 3 3 0',   
                 activeTab: 0,   
                 defaults: {   
                    autoScroll: true   
                 },  
                 items: [{   
                     title: '站点基础信息',   
                     html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./stationbasic.html"></iframe>'
                 }, {   
                     title: '站点检测',   
                      html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./stationsurvey.html"></iframe>'
                 },{   
                     title: '动力设备',   
                      html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./powermachine.html"></iframe>'  
                 },{   
                     title: '巡检工单',   
                      html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./patrolinspectionsheet.html"></iframe>'
                 },{   
                     title: '考勤记录',   
                      html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./attendancerecord.html"></iframe>' 
                    }]   
            }); 

	 //定义一个Panel   
                var nav = new Ext.Panel({   
                    title: 'Navigation',   
                     region: 'west', //放在西边，即左侧   
                     split: true,   
                     width: 0,   
                     collapsible: true, //允许伸缩   
                     margins: '3 0 3 3',   
                     cmargins: '3 3 3 3'   
                 });   

    win = new Ext.Window({   
                         title: 'xx村xx池', 
                         id:'station_name_title', 
                         closable: true,   
                         width: document.body.clientWidth,   
                         height:document.documentElement.clientHeight,  
                         border : false,   
                         plain: true,   
                         layout: 'border',   
                         closeAction:'hide',   
                        items: [nav, tabs]//把上面创建的panel和TabPanel放在window中，并采用border方式布局  
                     });    

    win.show();
    var paramName = 'con';
    //getQueryString(name);
    //console.log(parent.frames["map"].document);
    //console.log("parent.frames['map']:"+parent.frames["map"].con);

    //获取con
   function getParam(paramName) { 
    paramValue = "", isFound = !1; 
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) { 
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&"), i = 0; 
        while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++ 
    } 
    return paramValue == "" && (paramValue = null), paramValue 
}  
    //console.log("window.location.href:"+window.location.href);
    var con =  parseInt(getParam(paramName));
    //console.log("con:"+con);

    //从ajax url获取站点数据
    var onestationstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        model: 'station',
        proxy : {
            type : 'ajax',
            url:'/getonestationbasic/'+con,
            ///getonestationbasic/{id}
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
            //    root : 'content',
            //   totalProperty: 'totalElements' //数据总条数
            }
        },
        autoLoad : true,// 即时加载数据

        //加载后拿到所要的stationbasic部分数据
        listeners: {  
            'load': function mapPo(a,b,c,d,e) {  //(stor,array)
                //console.log('==================');
                //console.log(a);
                //console.log(a.proxy.reader.jsonData);
                //console.log(b);
                //console.log(c);
                //console.log(d);
                //console.log(e);  
                //console.log(Ext.getCmp('station_name_title'));
                Ext.getCmp('station_name_title').setTitle(a.proxy.reader.jsonData.station_name);
            }  
        }  
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

    
})