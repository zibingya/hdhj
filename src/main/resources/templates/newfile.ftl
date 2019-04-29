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
        layout: 'anchor',
        renderTo: Ext.getBody(),
        items: [
            {
                xtype: 'fieldcontainer',
                defaultType: 'checkboxfield',
                bodyPadding: 10,
                width: document.body.clientWidth,
                anchor: ' document.body.clientWidth  document.body.clientHeight*0.5',
                vertical: true,
                columns: 4,
                items: [{
                        boxLabel  : 'A类站点',
                        name      : 'A类站点',
                        inputValue: '1',
                        id        : 'checkbox1'
                    }, {
                        boxLabel  : 'B类站点',
                        name      : 'B类站点',
                        inputValue: '2',
                        id        : 'checkbox2'
                    },{
                        boxLabel  : 'C类站点',
                        name      : 'C类站点',
                        inputValue: '2',
                       
                        id        : 'checkbox3'
                    }, {
                        boxLabel  : 'D类站点',
                        name      : 'D类站点',
                        inputValue: '3',
                        id        : 'checkbox4'
                    }
                ],
                bbar: [{
                    text: 'Select A',
                    handler: function() {
                        Ext.getCmp('checkbox1').setValue(true);
                    }
                },{
                    text: 'Select All',
                    handler: function() {
                        Ext.getCmp('checkbox1').setValue(true);
                        Ext.getCmp('checkbox2').setValue(true);
                        Ext.getCmp('checkbox3').setValue(true);
                        Ext.getCmp('checkbox4').setValue(true);
                }    
                },{
                    text: 'Deselect All',
                    handler: function() {
                        Ext.getCmp('checkbox1').setValue(false);
                        Ext.getCmp('checkbox2').setValue(false);
                        Ext.getCmp('checkbox3').setValue(false);
                        Ext.getCmp('checkbox4').setValue(false);
                   }   
                }
                ],
            },{
                xtype: 'panel',
                title: '地图',
                anchor: 'document.body.clientWidth document.body.clientHeight*0.5'     
            }
        ]
    });
 })              
</script>
</html>