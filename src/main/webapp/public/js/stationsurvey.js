Ext.onReady(function(){
	var surveytable = Ext.create('Ext.panel.Panel', {
        title: '',
        width: document.body.clientWidth*0.72,
        height: document.documentElement.clientHeight*0.8,
        border:0,
        y:50,
        x:document.body.clientWidth*0.1,
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 8
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:20px'
        },
        items: [{
            html: '出水口水质：',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            rowspan: 1

        },{
            html: '',
            height: document.documentElement.clientHeight*0.12,
            colspan: 2
        },{
            html: '出水口流量：',
            x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'time',
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight',
            colspan: 2
        },{
            html: '电控箱开合状态：',
            border:0,
            x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '暂无数据',
            border:0,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: 'COD(mg/L):',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_cod',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '温度(℃)',
            x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_airtemperature',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
            x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
            cellCls: 'highlight'
        },{
            html: 'NH3-N(mg/L)',
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_nh3n',
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '详情',       
            height: document.documentElement.clientHeight*0.12,  
            cellCls: 'highlight'
        },{
            html: '瞬时流速(吨/小时)',
            x:document.body.clientWidth*0.01,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_instantspeed', 
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: 'PH',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            id:'survey_ph',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '流量计读数(吨)',
            height: document.documentElement.clientHeight*0.12,
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            id:'survey_flowmeterReading',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '总磷(mg/L)',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_totalp',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '今日累计流量',
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'survey_totalflowtoday',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '水温(℃)',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            id:'survey_watertemperature',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '前一日累计流量',
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            id:'survey_totalflowyesterday',
            height: document.documentElement.clientHeight*0.12,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '详情',
            width: document.body.clientWidth*0.09,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            border:0,
             x:document.body.clientWidth*0.01,
            width: document.body.clientWidth*0.09,
            cellCls: 'highlight'
        },{
            html: '',
            border:0
        }],
        renderTo: Ext.getBody()
    });


    //获取当前时间，精确到小时
    var date = new Date();
    //console.log(Ext.Date.format(date, 'F j, Y, g:i a'));                  // January 10, 2007, 3:05 pm
    var time = Ext.Date.format(date,'Y-m-d H:i:s');
    var hour = Ext.Date.format(date,'H');
    //console.log(hour);
     //从ajax url获取站点数据
    var onestationstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        model: 'station',
        proxy : {
            type : 'ajax',
            url:'/getonestationsurvey/'+hour,
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
            }
        },
        autoLoad : true,// 即时加载数据

        //加载后拿到所要的stationbasic部分数据
        listeners: {  
            'load': function mapPo(a,b,c,d,e) {  //(stor,array)
                //console.log('==================');
              //  console.log(a);
                //console.log(b);
                //console.log(c);
                //console.log(a.proxy.reader.jsonData[0].station_kind);
                Ext.getCmp("time").body.update('更新于：'+time);
                Ext.getCmp("survey_cod").body.update(a.proxy.reader.jsonData.survey_cod);
                Ext.getCmp("survey_nh3n").body.update(a.proxy.reader.jsonData.survey_nh3n);
                Ext.getCmp("survey_ph").body.update(a.proxy.reader.jsonData.survey_ph);
                Ext.getCmp("survey_totalp").body.update(a.proxy.reader.jsonData.survey_totalp);
                Ext.getCmp("survey_watertemperature").body.update(a.proxy.reader.jsonData.survey_watertemperature);
                Ext.getCmp("survey_airtemperature").body.update(a.proxy.reader.jsonData.survey_airtemperature);
                Ext.getCmp("survey_instantspeed").body.update(a.proxy.reader.jsonData.survey_instantspeed);
                Ext.getCmp("survey_flowmeterReading").body.update(a.proxy.reader.jsonData.survey_flowmeterReading);
                Ext.getCmp("survey_totalflowtoday").body.update(a.proxy.reader.jsonData.survey_totalflowtoday);
                Ext.getCmp("survey_totalflowyesterday").body.update(a.proxy.reader.jsonData.survey_totalflowyesterday);
            }  
        }  
    });

    //定义stationsurvey数据model
    Ext.define('stationsurvey', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'survey_cod',  type: 'double'},
            {name: 'survey_nh3n',  type: 'string'},
            {name: 'survey_ph',  type: 'string'},
            {name: 'survey_totalp',  type: 'string'},
            {name: 'survey_watertemperature',  type: 'string'},
            {name: 'survey_airtemperature',  type: 'string'},
            {name: 'survey_instantspeed',  type: 'double'},
            {name: 'survey_flowmeterReading',  type: 'string'},
            {name: 'survey_totalflowtoday',  type: 'string'},
            {name: 'survey_totalflowyesterday',  type: 'string'},
        ]
    });
    
    
})