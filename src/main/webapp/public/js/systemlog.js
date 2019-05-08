Ext.onReady(function() {
	//Ext.tip.QuickTipManager.init();
	var itemsPerPage = 26;// 设置每页所需的项数
	var store = Ext.create('Ext.data.Store', {
		fields : ['username', 'operation', 'method','params','ip','createDate', 'type', 'returninfo'],
  		pageSize : itemsPerPage, // 页容量数据
		// 是否在服务端排序 （true的话，在客户端就不能排序）
		remoteSort : false,
		remoteFilter : true,
		proxy : {
			type : 'ajax',
			url:'/get/systemlog',
			reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
				type : 'json', // 返回数据类型为json格式
				root : 'content',
				totalProperty: 'totalElements' //数据总条数
			}
		},
		/*sorters : [{
			// 排序字段。
			property : 'ordeId',
			// 排序类型，默认为 ASC
			direction : 'desc'
		}],
		 listeners : {
                'load' : function(store, records, options) {                
                    grid.getSelectionModel().deselectAll();
                    grid.getSelectionModel().select(0);
                }
            },*/
		autoLoad : true// 即时加载数据
	});
	store.load({
		params : {
			start : 0,
			limit : itemsPerPage
		}
	});

	
	//选择框
	var multiSelect1=Ext.create('Ext.selection.CheckboxModel');
	
	//展示的表格
	var grid = Ext.create('Ext.grid.Panel', {
		renderTo : Ext.getBody(),
		anchor : '100%',
		store : store,
		id:'showgrid',
		selModel: multiSelect1, //选择框
		autoSizeColumns : true, // 根据每一列内容的宽度自适应列的大小
		trackMouseOver : true, //鼠标移动时高亮显示
		columns : [{
				xtype : 'rownumberer'
			}, {
				text : "用户名",
				sortable : true,
				dataIndex : 'username'
			}, {
				text : "操作",
				sortable : true,
				dataIndex : 'operation'
			}, {
				text : "方法名",
				width:370,
				sortable : true,
				dataIndex : 'method'
			}, {
				text : "Ip地址",
				width:108,
				sortable : true,
				dataIndex : 'ip'
			}, {
				text : "操作时间",
				width:143,
				sortable : true,
				dataIndex : 'createDate'
			}, {
				text : "类型",
				width:129,
				sortable : true,
				dataIndex : 'type'
			}, {
				text : "返回信息",
				width:124,
				sortable : true,
				dataIndex : 'returninfo'
			},  {
				text : "参数",
				sortable : true,
				dataIndex : 'params',
				flex : 1
			},{
				text : "id",
				sortable : true,
				width:0,
				dataIndex : 'id'
			}],
		tbar : {
			xtype : "toolbar",
			items : [{
				xtype : "button",
				text : "刷新",
				icon : '../public/image/sx.png',
				listeners : {
					"click" : function(btn) {
						grid.store.reload();
					}
				}
			}]
		}
			});

	
	// 窗口
	var window = Ext.create("Ext.window.Window", {
		title : "系统日志",
		layout : 'anchor',
		items : grid,
		closable : false,
		draggable : false,//禁止拖动
		resizable : false,//禁止缩放
		bbar : [{
			xtype : 'pagingtoolbar',
			store : store,
			displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
			emptyMsg : "没有数据",
			beforePageText : "当前页",
			afterPageText : "共{0}页",
			displayInfo : true
		}]
	});
		
	window.show();
	//win.container.addClass('x-window-maximized-ct'); 
	window.fitContainer();// 填充满浏览器
	
	});
	function showAlert() {
		var selectedData = grid.getSelectionModel().getSelection()[0].data;
		Ext.MessageBox.alert("标题", selectedData.cataId);
	}