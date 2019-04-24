<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>站点基础信息管理:查看列表</title>
<style>
   #sheet{
      display:inline-block;
   }
</style>
</head>
<body>
   <div id="sheet">
       <div>站点编号</div>
       <div>站点名称</div>
       <div>站点类型</div>
       <div>联系方式</div>
       <div>管理员</div>
       <div>所在镇</div>
       <div>所在村</div>
       <div>纬度</div>
       <div>经度</div>
       <div>描述</div>
       <div>不主动展示部分开始</div>
       <div>图片原名</div>
       <div>图片地址</div>
       <div>水警类型</div>
       <div>水警最大倍数</div>
       <div>水警最小倍数</div>
       <div>不主动展示部分结束</div>
       <div>删除部分:</div>
       <div>单个查询:</div>
       <div>编辑:</div>
   </div>
   
   <#list stationBasicList as item >
      <div id="sheet">
        <div>${item.station_no}</div>
         <div>${item.station_name}</div>
         <div>${item.station_kind}类站点</div>
         <div>${item.station_phone}</div>
        <div>${item.station_manager}</div>
        <div>${item.station_town}</div>
        <div>${item.station_village}</div>
        <div>${item.station_latitude}</div>
         <div>${item.station_longitude}</div>
         <div>${item.station_description}</div>
         <div>不主动展示部分</div>
         <div>${item.station_pictureoldname}</div>
         <div>${item.station_pictureurl}</div>
         <div>${item.station_waterwarningtype}</div>
         <div>${item.station_watermax}</div>
         <div>${item.station_watermin}</div>
         <div>不主动展示部分结束</div>
         <div><a href="/delstationbasic/${item.station_no}">删除</a></div>
         <div><a href="/findonestationbasic/${item.station_no}">单个查询</a></div>
         <div><a href="/updstationbasic/updstationbasic.html&id=${item.station_no}">编辑</a></div>
       </div>
   </#list>
   <div>
      <a href="/addstationbasic.html">添加</a>
    </div>
</body>
</html>