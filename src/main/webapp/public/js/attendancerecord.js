Ext.onReady(function(){
      //定义attendancerecord数据model
    Ext.define('attendancerecord', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'ar_ename',  type: 'String'},
            {name: 'ar_arrivingtime',  type: 'int'},
            {name: 'ar_leavingtime',  type: 'int'},
            {name: 'ar_totaltime',  type: 'double'},
            {name: 'ar_wethervalid',  type: 'boolean'}
        ]
    })

  //从ajax url获取站点数据
    var station_no =  window.parent.arrSource[0].substring(window.parent.arrSource[0].indexOf("=")+1,(window.parent.arrSource[0].length));//找父窗口要参数
    var attendancerecordstore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        storeId:'attendancerecordstore',
        model: 'attendancerecord',
        proxy : {
            type : 'ajax',
            url:'/findonear/'+station_no,
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
                //root: 'content'
            }
        },
        autoLoad : true,// 即时加载数据

        //加载后拿到所要的stationbasic部分数据
        listeners: {  
            'load': function mapPo(a,b,c,d,e) {  //(stor,array)
               // console.log(a);
                //}
                
            }  
        }  
    }); 
  attendancerecordstore.load();
    
    //创建表格
    var grid = Ext.create('Ext.grid.Panel', {
                   title: '',
                   store: attendancerecordstore,//Ext.data.StoreManager.lookup('attendancerecordstore'),
                   columns: [
                       { header: '人员',  dataIndex: 'ar_ename', flex: 1,id:'ar_ename'},
                       { header: '到达时间', dataIndex: 'ar_arrivingtime', flex: 1,id:'ar_arrivingtime' },
                       { header: '离开时间', dataIndex: 'ar_leavingtime',flex: 1 ,id:'ar_leavingtime'},
                       { header: '总计时长(分钟)', dataIndex: 'ar_totaltime',flex: 1,id:'ar_totaltime' },
                       { header: '是否有效', dataIndex: 'ar_wethervalid',flex: 1,id:'ar_wethervalid' }
                   ],
                   height: document.documentElement.clientHeight,
                   width: document.body.clientWidth,
                   renderTo: Ext.getBody()
               });

        // console.log(grid.getColumnModel());
        //var colname = grid.getColumnModel().getDataIndex(cell[1]);  //获取列名      
        //var celldata = grid.getStore().getAt(cell[0]).get(colname); //获取数据  



    
});