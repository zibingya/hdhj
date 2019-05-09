Ext.onReady(function(){

	 var changingImage = Ext.create('Ext.Img', {
        src: './public/image/img-top.jpg',
        renderTo: Ext.getBody(),
        html:'站点图片'
    });
	 //从ajax url获取站点数据
    var onestationstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        model: 'station',
        proxy : {
            type : 'ajax',
            url:'/getonestationbasic/'+station_no,
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
                //console.log(a.proxy.reader);
                //console.log(a.proxy.reader.jsonData);//数据对象已经拿到
                //console.log(a.proxy.reader.jsonData.station_kind);
                //var ta = Ext.getCmp('station_kind');
                //console.log(ta.body);
                //console.log(a.proxy.reader.jsonData[0].station_kind);
                Ext.getCmp("station_kind").body.update(a.proxy.reader.jsonData.station_kind+'类站点');
                Ext.getCmp("station_no").body.update(a.proxy.reader.jsonData.station_no);
                Ext.getCmp("station_name").body.update(a.proxy.reader.jsonData.station_name);
                Ext.getCmp("station_manager").body.update(a.proxy.reader.jsonData.station_manager);
                Ext.getCmp("station_phone").body.update(a.proxy.reader.jsonData.station_phone);
                Ext.getCmp("station_town").body.update(a.proxy.reader.jsonData.station_town);
                Ext.getCmp("station_village").body.update(a.proxy.reader.jsonData.station_village);
                Ext.getCmp("station_latitude").body.update(a.proxy.reader.jsonData.station_latitude);
                Ext.getCmp("station_longitude").body.update(a.proxy.reader.jsonData.station_longitude);
                Ext.getCmp("station_description").body.update(a.proxy.reader.jsonData.station_description); 
            }  
        }  
    });
    //console.log(table);

    var table = Ext.create('Ext.panel.Panel', {
        title: '',
        x:document.body.clientWidth*0.1,
        width: document.body.clientWidth*0.8,
        height: document.documentElement.clientHeight*0.72,
         align: 'center',
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 4
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:20px'
        },
        items: [{
            html: '站点类型',
            id:'name_station_kind',
            height: document.documentElement.clientHeight*0.12,
            width:document.body.clientWidth*0.2,
            rowspan: 1,
        },{
            colspan: 3,
            height: document.documentElement.clientHeight*0.12,
            id:'station_kind'
        },{
            html: '站点编号',
            width:document.body.clientWidth*0.2,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
             id:'station_no',
              width:document.body.clientWidth*0.2,
                height: document.documentElement.clientHeight*0.12,
             cellCls: 'highlight'
        },{
            html: '站点名称',
              height: document.documentElement.clientHeight*0.12,
             width:document.body.clientWidth*0.2,
            cellCls: 'highlight'
        },{
            id:'station_name',
              height: document.documentElement.clientHeight*0.12,
             width:document.body.clientWidth*0.2,
            cellCls: 'highlight'
        },{
            html: '站点管理员',
            width:document.body.clientWidth*0.2,
             height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_manager',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '联系方式',
             height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_phone',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '所属乡镇',
           width:document.body.clientWidth*0.2,
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_town',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '所在村',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_village',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '纬度',
            width:document.body.clientWidth*0.2,
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_latitude',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '经度',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_longitude',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '站点描述',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_description',
              height: document.documentElement.clientHeight*0.12,
            colspan: 3
        }],
        renderTo: Ext.getBody()
    }); 

 /**   function table1(a){
    	
        var propertyGrid =new Ext.grid.PropertyGrid({
        title:"",
        width:500,
        border:0,
        autoHeight:true,
        frame: true, 
        source:{
            "站点类型":a.proxy.reader.jsonData[0].station_kind,
            "站点编号":a.proxy.reader.jsonData[0].station_no,
            "站点管理员":a.proxy.reader.jsonData[0].station_manager,
            "所属乡镇":a.proxy.reader.jsonData[0].station_town,
            "经度":a.proxy.reader.jsonData[0].station_longitude,
            "站点描述":a.proxy.reader.jsonData[0].station_decription
        }
    });
    propertyGrid.render('grid1');
    }

    function table2(a){
        var propertyGrid =new Ext.grid.PropertyGrid({
        title:"",
        width:500,
        border:0,
        autoHeight:true,
        frame: true, 
        source:{
            "站点名称":a.proxy.reader.jsonData[0].station_name,
            "联系方式":a.proxy.reader.jsonData[0].station_phone,
            "所在村":a.proxy.reader.jsonData[0].station_village,
            "纬度":a.proxy.reader.jsonData[0].station_latitude
        }
    });
    propertyGrid.render('grid1');
    }
    
  
    
    //定义列
     var columns = [  
        {header:'站点类型',dataIndex:'station_type'},
        {header:'站点编号',dataIndex:'station_no'},  
        {header:'站点名称',dataIndex:'station_name'},
        {header:'站点管理员',dataIndex:'station_manager'},
        {header:'联系方式',dataIndex:'station_phone'},
        {header:'所属乡镇',dataIndex:'station_town'},
        {header:'所在村',dataIndex:'station_village'},
        {header:'经度',dataIndex:'station_longitude'},
        {header:'纬度',dataIndex:'station_latitude'},
        {header:'站点描述',dataIndex:'station_decription'} 
     ]; */
})

var station_no =  window.parent.arrSource[0].substring(window.parent.arrSource[0].indexOf("=")+1,(window.parent.arrSource[0].length));//找父窗口要参数
//console.log(window);
//console.log(window.parent);
//console.log(window.parent.arrSource[0].substring(window.parent.arrSource[0].indexOf("=")+1,(window.parent.arrSource[0].length)));