Ext.onReady(function(){
    var table1 = Ext.create('Ext.panel.Panel', {
        title: '',
        width: document.body.clientWidth*0.72,
        height: document.documentElement.clientHeight*0.13,
        y:document.documentElement.clientHeight*0.1,
        x:document.body.clientWidth*0.1,
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 2
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:10px'
        },
        items: [{
            html: '否决项',
            height:document.documentElement.clientHeight*0.065,
            width: document.body.clientWidth*0.72,
            colspan: 2
           // rowspan: 2
        },{
            html: '工程无进水或无出水',
            height:document.documentElement.clientHeight*0.65,
            width: document.body.clientWidth*0.36,
            //colspan: 2
        },{
            id:'pis_wetherintakeoreffluent',
            height:document.documentElement.clientHeight*0.65,
            width: document.body.clientWidth*0.36,
        }],
        renderTo: Ext.getBody()
    });

    var table2 = Ext.create('Ext.panel.Panel', {
        title: '',
        width: document.body.clientWidth*0.72,
        height: document.documentElement.clientHeight*0.15,
        y:document.documentElement.clientHeight*0.13,
        x:document.body.clientWidth*0.1,
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 12
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:10px'
        },
        items: [{
            html: '工程主体运行维护',
            height:document.documentElement.clientHeight*0.05,
            colspan: 12
           // rowspan: 2
        },{
            html: '工程有无渗漏',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '有无积水',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '进水流量',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '出水流量',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '进水水质感官',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '出水水质感官',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '设备风机运行',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '菌种状况',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '亲水植物长势',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '标识牌设置',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '排污口清洗',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            html: '周边环境状况',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_leakage',//工程有无渗漏
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_ponding',//有无积水
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_floodingvelocity',//进水流量
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_effluentdischarge',//出水流量
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_waterqualityin',//进水水质感官
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_waterqualityout',//出水水质感官
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_equipmentOperation',//设备风机运行
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_strainStatus',//菌种状况
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_hydrophilicplantgrowth',//亲水植物长势
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_logosettings',//标识牌设置
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_sewageoutletcleaning',//排污口清洗
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        },{
            id:'pis_surroundingenvironment',//周边环境状况
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.06,
            //colspan: 2
        }],
        renderTo: Ext.getBody()
    });

    var table3 = Ext.create('Ext.panel.Panel', {
        title: '',
        width: document.body.clientWidth*0.72,
        height: document.documentElement.clientHeight*0.30,
        y:document.documentElement.clientHeight*0.15,
        x:document.body.clientWidth*0.1,
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 9
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:10px'
        },
        items: [{
            html: '管网窖井维护',
            height:document.documentElement.clientHeight*0.1,
            colspan: 9
           // rowspan: 2
        },{
            html: '发现应纳管而未纳管农户(0.5分/户)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '管网破损(0.5分/主干管处，支干管处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '管网堵塞(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '节点窖井无进出水(0.5分/只)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '管网裸露(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '窖井编号模糊(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '窖井盖破损(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '窖井有雨水进入(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            html: '窖井未清掏(0.5分/处)',
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_eligiblefarmers',//发现应纳管而未纳管农户
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_damagedpipenetwork',//管网破损
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_pipenetworkblockage',//管网堵塞
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_wateraroundinnodalpits',//节点窖井无进出水
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_pipenetworkexposed',//管网裸露
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_pitnumberambiguity',//窖井编号模糊
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_pitcoverdamage',//窖井盖破损
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_rainenterthecellarwell',//窖井有雨水进入
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        },{
            id:'pis_pitcleaning',//窖井未清掏
            height:document.documentElement.clientHeight*0.1,
            width: document.body.clientWidth*0.08,
            //colspan: 2
        }],
        renderTo: Ext.getBody()
    });

    var table4 = Ext.create('Ext.panel.Panel', {
        title: '',
        width: document.body.clientWidth*0.72,
        height: document.documentElement.clientHeight*0.5,
        y:document.documentElement.clientHeight*0.1,
        x:document.body.clientWidth*0.1,
        layout: {
            type: 'table',
            // The total column count must be specified here
            columns: 1
        },
        defaults: {
            // applied to each contained panel
            bodyStyle: 'padding:10px'
        },
        items: [{
            html: '其他扣分项:',
            height:document.documentElement.clientHeight*0.05,
            width: document.body.clientWidth*0.72,
           // rowspan: 2
        },{
            id: 'pis_other',
            height:document.documentElement.clientHeight*0.05
        },{
            html: '存在问题图片',
            height:document.documentElement.clientHeight*0.4
        }],
        renderTo: Ext.getBody()
    });
})

    //定义station数据model
    Ext.define('patrolinspectionsheet', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'pis_id', type: 'int'},
            {name: 'pis_time',  type: 'string'},
            {name: 'pis_wetherintakeoreffluent',  type: 'int'},
            {name: 'pis_leakage',  type: 'int'},
            {name: 'pis_ponding',  type: 'int'},
            {name: 'pis_floodingvelocity',  type: 'int'},
            {name: 'pis_effluentdischarge',  type: 'int'},
            {name: 'pis_waterqualityin',  type: 'int'},
            {name: 'pis_waterqualityout',  type: 'int'},
            {name: 'pis_equipmentOperation',  type: 'int'},
            {name: 'pis_strainStatus',  type: 'int'},
            {name: 'pis_hydrophilicplantgrowth',  type: 'int'},
            {name: 'pis_logosettings',  type: 'int'},
            {name: 'pis_sewageoutletcleaning',  type: 'int'},
            {name: 'pis_surroundingenvironment',  type: 'int'},
            {name: 'pis_eligiblefarmers',  type: 'int'},
            {name: 'pis_damagedpipenetwork',  type: 'int'},
            {name: 'pis_pipenetworkblockage',  type: 'int'},
            {name: 'pis_wateraroundinnodalpits',  type: 'int'},
            {name: 'pis_pipenetworkexposed',  type: 'int'},
            {name: 'pis_pitnumberambiguity',  type: 'int'},
            {name: 'pis_pitcoverdamage',  type: 'int'},
            {name: 'pis_rainenterthecellarwell',  type: 'int'},
            {name: 'pis_pitcleaning',  type: 'int'},
            {name: 'pis_url',  type: 'int'},
            {name: 'pis_pmid',  type: 'string'},
            {name: 'pis_finalevaluation',  type: 'int'},
            {name: 'pis_deadline',  type: 'int'}
        ]
    });

     //获取当前时间，精确到小时
    var date = new Date();
    //console.log(Ext.Date.format(date, 'F j, Y, g:i a'));                  // January 10, 2007, 3:05 pm
    var time = Ext.Date.format(date,'Y-m-d H:i:s');
    var hour = Ext.Date.format(date,'H');
    var day = Ext.Date.format(date,'Ymd');
   // console.log(day);
    //从ajax url获取站点数据
    var pisdatabasestore = Ext.create('Ext.data.Store', {
      //  remoteSort : false,
      //  remoteFilter : true,
        model: 'station',
        proxy : {
            type : 'ajax',
            url:'/findonepis/'+day,
            reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                type : 'json', // 返回数据类型为json格式
            }
        },
        autoLoad : true,// 即时加载数据

        //加载后拿到所要的stationbasic部分数据
        listeners: {  
            'load': function mapPo(a,b,c,d,e) {  //(stor,array)
               // console.log(a);

                if(a.proxy.reader.jsonData.pis_wetherintakeoreffluent==1){//工程是否无进水或无出水,正常1,无0
                    Ext.getCmp('pis_wetherintakeoreffluent').body.update('正常');
                }else{
                    Ext.getCmp('pis_wetherintakeoreffluent').body.update('异常');
                }

                if(a.proxy.reader.jsonData.pis_leakage==1){//工程有无渗漏,正常1,有2
                    Ext.getCmp('pis_leakage').body.update('正常');
                }else{
                    Ext.getCmp('pis_leakage').body.update('异常');
            }

                if(a.proxy.reader.jsonData.pis_ponding==1){//有无积水,正常1,堵2,地势低0
                    Ext.getCmp('pis_ponding').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_ponding==2){
                    Ext.getCmp('pis_ponding').body.update('堵塞');
                }else{
                    Ext.getCmp('pis_ponding').body.update('地势低');   
                }

                if(a.proxy.reader.jsonData.pis_floodingvelocity==1){//进水流量,正常1,偏小0,偏大2
                    Ext.getCmp('pis_floodingvelocity').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_floodingvelocity==0){
                    Ext.getCmp('pis_floodingvelocity').body.update('偏小');
                }else{
                     Ext.getCmp('pis_floodingvelocity').body.update('偏大');
                }

                if(a.proxy.reader.jsonData.pis_effluentdischarge==1){//出水流量,正常1,偏小0,偏大2
                    Ext.getCmp('pis_effluentdischarge').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_effluentdischarge==0){
                    Ext.getCmp('pis_effluentdischarge').body.update('偏小');
                }else{
                    Ext.getCmp('pis_effluentdischarge').body.update('偏大');
                }

                if(a.proxy.reader.jsonData.pis_waterqualityin==1){//进水水质感官,正常1,过清2,过清采样0
                    Ext.getCmp('pis_waterqualityin').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_waterqualityin==2){
                    Ext.getCmp('pis_waterqualityin').body.update('过清');
                }else{
                    Ext.getCmp('pis_waterqualityin').body.update('过清采样');
                }

                if(a.proxy.reader.jsonData.pis_waterqualityout==1){//出水水质感官,正常1,浑浊2,浑浊采样3
                    Ext.getCmp('pis_waterqualityout').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_waterqualityout==2){
                    Ext.getCmp('pis_waterqualityout').body.update('浑浊');
                }else{
                    Ext.getCmp('pis_waterqualityout').body.update('浑浊采样');
                }

                if(a.proxy.reader.jsonData.pis_equipmentOperation==1){//设备风机运行,正常1,不正常0
                    Ext.getCmp('pis_equipmentOperation').body.update('正常');
                }else{
                    Ext.getCmp('pis_equipmentOperation').body.update('异常');
                }

                if(a.proxy.reader.jsonData.pis_strainStatus==1){//菌种状况,正常1，一般2,差3
                    Ext.getCmp('pis_strainStatus').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_strainStatus==2){
                    Ext.getCmp('pis_strainStatus').body.update('一般');
                }else{
                    Ext.getCmp('pis_strainStatus').body.update('差');
                }

                if(a.proxy.reader.jsonData.pis_hydrophilicplantgrowth==1){//亲水性植物涨势,正常1，一般2,差3
                    Ext.getCmp('pis_hydrophilicplantgrowth').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_hydrophilicplantgrowth==2){
                    Ext.getCmp('pis_hydrophilicplantgrowth').body.update('一般');
                }else{
                    Ext.getCmp('pis_hydrophilicplantgrowth').body.update('差');
                }

                if(a.proxy.reader.jsonData.pis_logosettings==1){//标识牌设置,正常1,模糊2,无3
                    Ext.getCmp('pis_logosettings').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_logosettings==2){
                    Ext.getCmp('pis_logosettings').body.update('模糊');
                }else{
                    Ext.getCmp('pis_logosettings').body.update('无');
                }

                if(a.proxy.reader.jsonData.pis_sewageoutletcleaning==1){//排污口清洗,正常1，一般2,差3
                    Ext.getCmp('pis_sewageoutletcleaning').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_sewageoutletcleaning==2){
                    Ext.getCmp('pis_sewageoutletcleaning').body.update('一般');
                }else{
                    Ext.getCmp('pis_sewageoutletcleaning').body.update('差');
                }

                if(a.proxy.reader.jsonData.pis_surroundingenvironment==1){//周边环境状况,正常1，一般2,差3
                    Ext.getCmp('pis_surroundingenvironment').body.update('正常');
                }else if(a.proxy.reader.jsonData.pis_surroundingenvironment==2){
                     Ext.getCmp('pis_surroundingenvironment').body.update('一般');
                }else{
                     Ext.getCmp('pis_surroundingenvironment').body.update('差');
                }

                Ext.getCmp('pis_eligiblefarmers').body.update(a.proxy.reader.jsonData.pis_eligiblefarmers);//发现应纳管而未纳管农户pis_eligiblefarmers
                Ext.getCmp('pis_damagedpipenetwork').body.update(a.proxy.reader.jsonData.pis_damagedpipenetwork);//管网破损(0.5分/主干管处，支干管处)
                Ext.getCmp('pis_pipenetworkblockage').body.update(a.proxy.reader.jsonData.pis_pipenetworkblockage);//管网堵塞(0.5分/处)
                Ext.getCmp('pis_wateraroundinnodalpits').body.update(a.proxy.reader.jsonData.pis_wateraroundinnodalpits);//节点窖井无进出水(0.5分/只)
                Ext.getCmp('pis_pipenetworkexposed').body.update(a.proxy.reader.jsonData.pis_pipenetworkexposed);//管网裸露(0.5分/处)
                Ext.getCmp('pis_eligiblefarmers').body.update(a.proxy.reader.jsonData.pis_eligiblefarmers);//窖井编号模糊(0.5分/处)
                Ext.getCmp('pis_pitcoverdamage').body.update(a.proxy.reader.jsonData.pis_pitcoverdamage);//窖井盖破损(0.5分/处)
                Ext.getCmp('pis_rainenterthecellarwell').body.update(a.proxy.reader.jsonData.pis_rainenterthecellarwell);//窖井有雨水进入(0.5分/处)
                Ext.getCmp('pis_pitcleaning').body.update(a.proxy.reader.jsonData.pis_pitcleaning);//窖井未清掏(0.5分/处)
                Ext.getCmp('pis_other').body.update(a.proxy.reader.jsonData.pis_other);//其他扣分项
        }  
        }
    }); 