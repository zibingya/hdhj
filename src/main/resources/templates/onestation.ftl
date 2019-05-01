<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单个站点展示</title>
<link rel="stylesheet" type="text/css" href="../static/ext-4.2.1/resources/ext-theme-classic/ext-theme-classic-all.css" />
<script type="text/javascript" src="../static/ext-4.2.1/ext-all.js"/> 
<script type="text/javascript" src="../static/ext-4.2.1/locale/ext-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="../static/css/stationbase.css" />

</head>
<body>
</body>
<script src="../static/jquery/jquery-3.2.1.min.js"></script>
<script src="../static/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
Ext.onReady(function() {           
            var tabs = new Ext.TabPanel({  //创建TabPanel  
                 region: 'center', //border 布局，将页面分成东，南，西，北，中五部分，这里表示TabPanel放在中间   
                 margins: '3 3 3 0',   
                 activeTab: 0,   
                 width:1000,
                 id:'root',
                 defaults: {   
                    autoScroll: true   
                 },       
                items: [{   
                     title: '站点基础信息',   
                     layout: 'anchor',
                     id:'basic',
                     border:'false',
                     items: [
                        {
                            xtype: 'box',
                            title: '',
                            anchor: '1 40%',
                            width: 500, //图片宽度  
                            height: 800, //图片高度  
                            autoEl: {  
                                tag: 'img',    //指定为img标签  
                                src: '../static/image/village2.jpg'    //指定url路径  
                            }  
                        }, 
                        {
                            xtype: 'panel',
                            title: '',
                            anchor: '1 60%',
                            layout: {
                                 type: 'table',
                                 // The total column count must be specified here
                                 columns: 4,
                                 
                                 align: 'middle',
                                 pack: 'center',
                            },
                             defaults: {
                                 // applied to each contained panel
                                 bodyStyle: 'padding:20px',
                            },
                             items: [{
                                 html: '站点类型',
                                 width:200,
                            },{
                                 html: 'A类站点',
                                 colspan:3,
                                 width:602,
                            },{
                                 html: '站点编号',
                                 width:200,
                            },{
                                 html: '2',
                                 width:200,
                            },{
                                 html: '站点名称',
                                 width:200,
                            },{
                                 html: 'gz站',
                                 width:200,
                            },{
                                 html: '站点管理员',
                                 width:200,
                            },{
                                 html: 'gz',
                                 width:200,
                            },{
                                 html: '联系方式',
                                 width:200,
                            },{
                                 html: '110',
                                 width:200,
                            },{
                                 html: '所属乡镇',
                                 width:200,
                            },{
                                 html: 'gz镇',
                                 width:200,
                            },{
                                 html: '所属村',
                                 width:200,
                            },{
                                 html: 'gz村',
                                 width:200,
                            },{
                                 html: '经度',
                                 width:200,
                            },{
                                 html: '所属村',
                                 width:200,
                            },{
                                 html: '纬度',
                                 width:200,
                            },{
                                 html: '所属村',
                                 width:200,
                            },{
                                 html: '站点描述',
                                 
                            },{
                                 html: 'gzgzggzgzgzgzgzgz',
                                 colspan:3
                            }]
                        } 
                     ]             
                 }, {   
                      title: '站点监测',   
                      xtype: 'panel', 
                      id:'survey',  
                      listeners:{ 
                              itemclick:function(e) {
                                      e.body.on('click', function() { 
                                          console.log(1);             
                                      });
                              }
                      }
                 },
                 {   
                     title: '动力设备',   
                     html: "我是另一个Tab" ,
                     id:'pm',  
                 },{   
                     title: '巡检工单',
                     id:'pis',   
                     html: "我是另一个Tab"   
                 },{   
                     title: '站点QOs', 
                     id:'QOs',  
                     html: "我是另一个Tab"   
                 }, {   
                     title: '考勤记录',
                     id:'ar',   
                     html: "这是一个可以关闭的Tab",   
                    }
                ] ,
                listeners:{
                          itemclick:function(v,r,item){
                             var n = tabs.getComponent(r.raw.id);
                             alert(1);
                             alert(r.raw.id);
                             if(r.raw.id == 'survey'){
                                 //点击站点检测从后台获取查询数据
                                 Ext.MessageBox.prompt('输入框','请输入time',function(){
                                     alert('station_no');
                                 });
                                 html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="/findonestationsurvey/"+time></iframe>'
                             }
                             if(r.raw.id == 'pm'){//点击动力设备打开当前检测数据
                                 html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="/findonepowermachine/"+station_no></iframe>'
                             }
                             if(r.raw.id == 'pis'){//点击巡检工单打开最近的纪录
                                html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="/findonepis/"+station_no></iframe>'
                             } 
                             if(r.raw.id == 'QOs'){//点击巡检工单打开最近的纪录
                                html : '喵喵喵'
                             } 
                             if(r.raw.id == 'ar'){//点击考勤记录打开最近的考勤纪录
                                html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="/findonepis/"+station_no></iframe>'
                             }                              
                          }//itemclick回括
                }, //listener回括   
            });//tabs回括

                 //定义一个Panel   
                var nav = new Ext.Panel({   
                     title: '菜单栏',   
                     region: 'west', //放在西边，即左侧   
                     split: true,   
                     width: 200,   
                     collapsible: true, //允许伸缩   
                     margins: '3 0 3 3',   
                     cmargins: '3 3 3 3'   
                 });   
    
                 //如果窗口第一次被打开时才创建   
                   var win = new Ext.Window({   
                         title: '主页',   
                         closable: true,   
                         width: 1400,   
                         height: 700,  
                         border : false,   
                         plain: true,   
                         layout: 'border',   
                         closeAction:'hide',   
                         items: [nav, tabs]//把上面创建的panel和TabPanel放在window中，并采用border方式布局   
                    });   
                 win.show();  

            //stationbasic--store
             Ext.define('stationBasic', {
                 extend: 'Ext.data.Model',
                 fields: [
                     {name: 'station_kind',type:'string'},
                     {name: 'station_no',  type:'int'},
                     {name: 'station_name',type:'string'},
                     {name: 'station_manager',type:'string'},
                     {name: 'station_phone',type:'string'},
                     {name: 'station_town',type:'string'},
                     {name: 'station_village',type:'string'},
                     {name: 'station_longitude',type:'double'},
                     {name: 'station_latitude',type:'double'},
                     {name: 'station_description',type:'string'}  
                 ]
             });
            
             var myStore = Ext.create('Ext.data.Store', {
                 model: 'stationBasic',
                 proxy: {
                     type: 'ajax',
                     url: '/users.json',
                     reader: {
                         type: 'json',
                         root: 'users'
                     }
                 },
                 autoLoad: true
                });
});  
</script>
</html>