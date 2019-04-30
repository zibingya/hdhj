<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单个站点展示</title>
<link rel="stylesheet" type="text/css" href="../static/ext-4.2.1/resources/ext-theme-classic/ext-theme-classic-all.css" />
<script type="text/javascript" src="../static/ext-4.2.1/ext-all.js"/> 
<script type="text/javascript" src="../static/ext-4.2.1/locale/ext-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="../static/css/stationbase.css" />
<style>
    /*table 布局样式 start*/
    .mytable>table{border-collapse: collapse;width:100%;padding-bottom:4px;}/*table-layout: fixed;*/
    .mytable>table .thead{text-align:center;width: 100px;line-height: 1.2em;padding: 4px 0;}
    .mytable>table td,th{border:1px solid #a4a4a4;text-align:center;vertical-align:middle;line-height: 28px;}
    .mytable .x-table-form-item{padding:0;margin:0;width:100%;position: relative;}
    .mytable .x-form-display-field-default {line-height: 1.2em;margin:0;padding:5px;}
    .mytable .x-form-trigger-wrap-default{border:none;}
    .mytable input,.mytable .x-form-display-field-default{text-align:left;}
    .mytable .thead{background-color: #ebebeb;}
    .mytable .placeholder-cell{border-right:none;border-left:none;}
    /*table 布局样式 end*/
</style>
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
                             alert(n);
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
                              
                          });
                     },    
            });

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
                 
                 //store
});  
</script>
</html>