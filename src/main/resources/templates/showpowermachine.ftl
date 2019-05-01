<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动力设备展示</title>
<link rel="stylesheet" type="text/css" href="../static/ext-4.2.1/resources/ext-theme-classic/ext-theme-classic-all.css" />
<script type="text/javascript" src="../static/ext-4.2.1/ext-all.js"/> 
<script type="text/javascript" src="../static/ext-4.2.1/locale/ext-lang-zh_CN.js"></script>
</head>
<body>
</body>
<script src="../static/jquery/jquery-3.2.1.min.js"></script>
<script src="../static/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
Ext.onReady(function() {  
     Ext.create('Ext.data.Store', {
        storeId:'stationSurvey',
        fields:['pm_address', 'pm_state'],
        data:{'items':[
            { "pm_address":"风机1",  "pm_state":"运行"  },
            { "pm_address":"风机1",  "pm_state":"运行" },
            { "pm_address":"风机1",  "pm_state":"运行"  },
            { "pm_address":"风机1", "pm_state":"运行"  }
        ]},
        proxy: {
            type: 'memory',
            reader: {
                type: 'json',
                root: 'items'
            }
        }
     });

   var table1 = Ext.create('Ext.grid.Panel', {
       title: '读取互感器状态 更新时间:<br/><br/>16路设备',
       store: Ext.data.StoreManager.lookup('stationSurvey'),
       columns: [
           {xtype: 'rownumberer',flex: 0.1,header: '序号'},
           { header: '设备风机', dataIndex: 'pm_address', flex: 1,sortable: true},
           { header: '互感器状态', dataIndex: 'pm_state' ,flex: 1,sortable: true}
       ],
       height: 500,
       width: 700,
       renderTo: Ext.getBody()
   });
   
   table1.show();

});  
</script>
</html>