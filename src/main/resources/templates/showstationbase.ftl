<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单个站点展示</title>
<link rel="stylesheet" type="text/css" href="/js/ext-4.2.1.883/resources/ext-theme-classic/ext-theme-classic-all.css" />
<link rel="stylesheet" type="text/css" href="/css/stationbase.css" />
</head>
<body>
   <div class="title">
       <div id="stationitem"><a>站点基础信息</a></div>
       <div id="stationitem"><a>站点监测</a></div>
       <div id="stationitem"><a>动力设备</a></div>
       <div id="stationitem"><a>巡检工单</a></div>
       <div id="stationitem"><a>站点QQs</a></div>
       <div id="stationitem"><a>考勤记录</a></div>
   </div>
   <!--基础信息开始-->
   <div class="station">
       <div><img src="/stationpicture/gzvillage.jpg" width="300" height="200"/></div>
       <table >
          <tr>
             <td>站点类型</td>
             <td colspan="3">${stationBasic.station_kind}类站点</td>
          </tr>
          <tr>
             <td>站点编号</td>
             <td>${stationBasic.station_no}</td>
             <td>站点名称</td>
             <td>${stationBasic.station_name}</td>
          </tr>
          <tr>
             <td>站点管理员</td>
             <td>${stationBasic.station_manager}</td>
             <td>联系方式</td>
             <td>${stationBasic.station_phone}</td>
          </tr>
          <tr>
             <td>所属乡镇</td>
             <td>${stationBasic.station_town}</td>
             <td>所在村</td>
             <td>${stationBasic.station_village}</td>
          </tr>
          <tr>
             <td>经度</td>
             <td>${stationBasic.station_longitude}</td>
             <td>纬度</td>
             <td>${stationBasic.station_latitude}</td>
          </tr>
          <tr>
             <td>站点描述</td>
             <td colspan="3">${stationBasic.station_description}</td>
          </tr>
      
       </table>
       <div>${stationBasic.station_village}村委会</div>
   </div>
   <!--基础信息结束-->
  <!--站点监测开始-->
   <div class="station" ">
          <div id="waterquality">
             <div id="surveytitle1">出水口水质</div>
                <div class="survey_cod" >COD(mg/L)</div>
                <div class="survey_cod" >${stationSurvey.survey_cod}</div>
                <div class="survey_cod" id="table"><img src="/img/sheet.jpg" />详情</div>
                
                <div class="survey_nh3n" >NH3-N(mg/L)</div>
                <div class="survey_nh3n" >${stationSurvey.survey_nh3n}</div>
                <div class="survey_nh3n" id="table"><img src="/img/sheet.jpg" />详情</div>
      
                <div class="survey_ph" >PH</div>
                <div class="survey_ph" >${stationSurvey.survey_ph}</div>
                <div class="survey_ph" id="table"><img src="/img/sheet.jpg"/>详情</div>
                
                <div class="survey_totalp" >磷总量(mg/L)</div>
                <div class="survey_totalp" >${stationSurvey.survey_totalp}</div>
                <div class="survey_totalp" id="table"><img src="/img/sheet.jpg" />详情</div>
                
                <div class="survey_watertemperature" >水温(℃)</div>
                <div class="survey_watertemperature" >${stationSurvey.survey_watertemperature}</div>
                <div class="survey_watertemperature" id="table"><img src="/img/sheet.jpg" />详情</div>
          </div>
          
          <div id="waterquality">
             <div class="surveytitle">出水口流量:<a id="updatetime">更新于(时间)</a></div>
            
             
             <div class="survey_airtemperature">温度(℃)</div>
             <div class="survey_airtemperature">${stationSurvey.survey_airtemperature}</div>
             <div class="survey_airtemperature" id="table"><a class="black">2</a></input></div>
             
             <div class="survey_instantspeed">瞬时流速(吨/小时)</div>
             <div class="survey_instantspeed" >${stationSurvey.survey_instantspeed}</div>
             <div class="survey_instantspeed" id="table"><a class="black">2</a></div>
             
             <div class="survey_flowmeterReading">流量计读数(吨)</div>
             <div class="survey_flowmeterReading">${stationSurvey.survey_flowmeterReading}</div>
             <div class="survey_flowmeterReading" id="table"><img src="/img/sheet.jpg" />详情</div>
             
             <div class="survey_totalflowtoday">今日累计流量(吨)</div>
             <div class="survey_totalflowtoday">${stationSurvey.survey_totalflowtoday}</div>
             <div class="survey_totalflowtoday" id="table"><img src="/img/sheet.jpg" />详情</div>
             
             <div class="survey_totalflowyesterday">昨日累计流量(吨)</div>
             <div class="survey_totalflowyesterday">${stationSurvey.survey_totalflowyesterday}</div>
             <div class="survey_totalflowyesterday" id="table"><img src="/img/sheet.jpg" />详情</div>
          </div>
          
          <div id="waterquality">
             <div class="surveytitle1" id="table">电控箱开合状态:暂无数据</div>
          </div>
   </div>
   <!--站点监测结束-->
   <!--动力设备开始-->
   <div class="station" >
      <div><button>读取交流互感器状态</button><p>更新时间:time()</p></div>
      <div>
          路设备
      </div>
      <div>
         <div>
             <#list powerMachine as pm>
                ${pm.pm_address}
                ${pm.pm_state}
             </#list>
         </div>
      </div>
   </div>
   <!--动力设备结束-->
   <!-_巡检工单开始-->
   <div class="station">
   	   <div>
   	   	   <div class="pistitle" id="pistitle1">否决项</div>
           <div class="pissheet" id="pistitle2">工程无进水或无出水</div>
   	   </div>
   	   <br/>
       <div>
       	   <div class="pistitle">工程主体运行维护</div>
           <div class="pissheet">
       	        <div class="pis">工程有无渗漏</div>      	      
       	        <div class="pis">有无积水</div>       	   
          	    <div class="pis">进水流量</div>          	         
          	    <div class="pis">出水流量</div>          	 
          	    <div class="pis">进水水质感官</div>       
          	    <div class="pis">出水水质感官</div>      
                <div class="pis">设备风机运行</div>
                <div class="pis">菌种状况</div>
                <div class="pis">亲水植物长势</div>
                <div class="pis">标识牌设置</div>
                <div class="pis">排污口清洗</div>
                <div class="pis" id="pis3">周边环境状况</div>
           </div>
           <div class="pissheet">
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">2</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis2">1</div>
          	    <div class="pis" id="pis4">1</div>
           </div>
       </div>
       <br/><br/>
       <div>
       	<br/><br/>
       	   <div class="pistitle">管网、窖井运行维护</div>
       	   <div class="pissheet">
          	   <div class="pis1">发现应纳管而未纳管农户</div>
          	   <div class="pis1">管网破损</div>
          	   <div class="pis1">管网堵塞</div>
          	   <div class="pis1">节点窖井无进出水</div>
          	   <div class="pis1">管网裸露</div>
          	   <div class="pis1">窖井编号模糊</div>
          	   <div class="pis1">窖井盖破损</div>
          	   <div class="pis1">窖井有雨水进入</div>
          	   <div class="pis1" id="pis3">窖井未清掏</div>
           </div>
           <div class="pissheet">
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">2</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis2">1</div>
          	    <div class="pis1" id="pis4">1</div>
           </div>
       </div>
       <br/><br/>
       <div>
           <div class="pistitle">其他扣分事项</div>
           <div class="pissheet">
           	   <div>存在问题图片</div>
               <div>图片</div>
           </div>    
       </div>
   </div>
   <!--巡检工单结束-->
   <!--站点QQs开始-->
   <div class="station" ">站点QQs
   </div>
   <!--站点QQs结束-->
   <!--考勤记录开始-->
   <div class="station" ">
      <div class="artitle">人员</div>
	  <div class="artitle">到达时间</div>
	  <div class="artitle">离开时间</div>
	  <div class="artitle">总计时长(分钟)是否有效</div>
   </div>
   <!--考勤记录结束-->

    <script type="text/javascript" src="/js/ext-4.2.1.883/ext-all.js"/>
    <script type="text/javascript" src="/js/ext-4.2.1.883/bootstrap.js"></script>      
	<script type="text/javascript" src="/js/ext-4.2.1.883/locale/ext-lang-zh_CN.js"></script>
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	var index; 
	  $(function(e){
	     $(".title div").click(function(){
	       index = $(this).index();
	       $(".station").each(function(i){
			       if(i==index){
				       $(this).show();
				   }else{
				       $(this).hide();
				   }
		   })
	       
	     })
	  })
	  
	  var time;
	  function time(){
	     var date = new Date();
	     var year = date.getFullYear();//年
	     var month = date.getMonth()+1;//月
	     var day = date.getDate();//日
	     var h = date.getHours();//时
	     var m = date.getMinutes();//分
	     var s = date.getSeconds();
	     var time = year+month+day+h+m+s+"";
	     return time;
	  }
	</script>
</html>