Ext.onReady(function(){

    var date = new Date();
    //console.log(Ext.Date.format(date, 'F j, Y, g:i a'));                  // January 10, 2007, 3:05 pm
    var time = Ext.Date.format(date,'Y-m-d H:i:s');
    var hour = Ext.Date.format(date,'H');
    //console.log(hour);

    //定义PowerMachine数据model
    var pmmodel = Ext.define('powermachine', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'pm_id', type: 'int'},
            {name: 'pm_address',  type: 'int'},
            {name: 'pm_state',  type: 'boolean'},
            {name: 'pm_line',  type: 'int'},
            {name: 'pm_time',  type: 'int'}
        ]
    });

        var table = Ext.create('Ext.panel.Panel', {
        title: '',
        //x:document.body.clientWidth*0,
        width: document.body.clientWidth,
        height: document.documentElement.clientHeight*0.24,
         align: 'center',
        layout: {
            type: 'table',
            columns: 2
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:20px'
        },
        items: [{
            html:'读取交流器互感状态',
            height: document.documentElement.clientHeight*0.12,
            width:document.body.clientWidth*0.5,
            //rowspan: 1,
        },{
            //colspan: 1,
            height: document.documentElement.clientHeight*0.12,
            width:document.body.clientWidth*0.5,
            id:'time'
        },{
            id:'pm_line',
            height: document.documentElement.clientHeight*0.12,
            colspan: 2
        }],
        renderTo: Ext.getBody()
    }); 

    var table1 = Ext.create('Ext.panel.Panel', {
        title: '',
        x:document.body.clientWidth*0.1,
        width: document.body.clientWidth*0.6,
        height: document.documentElement.clientHeight*0.72,
         align: 'center',
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 3
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:20px'
        },
        items: [{
            html: '序号',
            id:'name_station_kind',
            height: document.documentElement.clientHeight*0.12,
            width:document.body.clientWidth*0.2,
            rowspan: 1,
        },{
            html: '设备名称',
            width:document.body.clientWidth*0.2,
            height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '互感器状态',
              height: document.documentElement.clientHeight*0.12,
             width:document.body.clientWidth*0.2,
            cellCls: 'highlight'
        },{
            id:'no1',
              height: document.documentElement.clientHeight*0.12,
             width:document.body.clientWidth*0.2,
            cellCls: 'highlight'
        },{
            id:'pm_address1',
            width:document.body.clientWidth*0.2,
             height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'pm_state1',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id: 'no2',
             height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'pm_address2',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'pm_state2',
           width:document.body.clientWidth*0.2,
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_town',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_village',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
            width:document.body.clientWidth*0.2,
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_latitude',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_longitude',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            html: '',
              height: document.documentElement.clientHeight*0.12,
            cellCls: 'highlight'
        },{
            id:'station_description',
              height: document.documentElement.clientHeight*0.12,
            colspan: 3
        }],
        renderTo: Ext.getBody()
    }); 


    //var station_no =  window.parent.arrSource[0].substring(window.parent.arrSource[0].indexOf("=")+1,(window.parent.arrSource[0].length));//找父窗口要参数
    //从ajax url获取站点数据
    var pmstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
      storeId:'pmstoreid',
        model:'powermachine',
        proxy : {
            type : 'ajax',
            url:'/findonepowermachine/'+hour,
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
            //    root : 'content',
            //   totalProperty: 'totalElements' //数据总条数
            }
        },
        autoLoad : true,// 即时加载数据
        listeners: {  
            'load': function mapPo(a,b,c,d,e) {  //(stor,array)
               // console.log(a.proxy.reader.jsonData.station_kind);
               //console.log('123');
               console.log(a);
                    console.log(a.proxy.reader.jsonData);
                    Ext.getCmp('time').body.update('更新于:'+time);
                    Ext.getCmp('pm_line').body.update(a.proxy.reader.jsonData.pm_line+'路设备');
                    Ext.getCmp('no1').body.update(a.proxy.reader.jsonData.pm_id);
                    Ext.getCmp('pm_address1').body.update(a.proxy.reader.jsonData.pm_address+"路风机");
                    Ext.getCmp('pm_state1').body.update(a.proxy.reader.jsonData.pm_state);
                //Ext.getCmp("station_kind").body.update(a.proxy.reader.jsonData.station_kind+'类站点');
            }  
        }  
    });
    //console.log(table);
  
})

