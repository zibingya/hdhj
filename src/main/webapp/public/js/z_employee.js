Ext.onReady(function() {
	Ext.tip.QuickTipManager.init();
	var itemsPerPage = 2;// 设置每页所需的项数
	var store = Ext.create('Ext.data.Store', {
		fields : ['ename', 'eid', 'esex','ephonenum', 'edistrict', 'eemail'],
		pageSize : itemsPerPage, // 页容量数据
		// 是否在服务端排序 （true的话，在客户端就不能排序）
		remoteSort : false,
		remoteFilter : true,
		proxy : {
			type : 'ajax',
			url:'/getemployee',
			reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
				type : 'json', // 返回数据类型为json格式
				root : 'content',
				totalProperty: 'totalElements' //数据总条数
			}
		},
		sorters : [{
			// 排序字段。
			property : 'ordeId',
			// 排序类型，默认为 ASC
			direction : 'desc'
		}],
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
				text : "姓名",
				sortable : true,
				dataIndex : 'ename'
			}, {
				text : "巡维卡号",
				sortable : true,
				dataIndex : 'eid'
			}, {
				text : "性别",
				sortable : true,
				dataIndex : 'esex'
			}, {
				text : "手机号",
				sortable : true,
				dataIndex : 'ephonenum'
			}, {
				text : "所属区域",
				sortable : true,
				dataIndex : 'edistrict'
			}, {
				text : "电子邮箱",
				sortable : true,
				width:200,
				dataIndex : 'eemail'
			},{
				sortable : false,
				flex : 1
			}],
		tbar : {
			xtype : "toolbar",
			items : [{
				xtype : "button",
				text : "添加",
				icon : '../public/image/add.png',
				listeners : {
					"click" : function(btn) {
						addWindow.show();
					}
				}
			}, {
				xtype : "button",
				text : "修改",
				icon : '../public/image/edit.png',
				listeners : {
					"click" : function() {
						var grid = window.down("grid");
						var records = grid.getSelectionModel().getSelection();
						var model = records[0];//得到被选中的第一行
						if(records.length == ""){
							Ext.Msg.show({
								title: '操作提示',
								msg: '您没有选择需要修改的行，请选择后重试！！',
								buttons: Ext.MessageBox.OK,
								icon: Ext.MessageBox.ERROR
							});
							return;
						}
						updateWindow.show();
						Ext.getCmp('d_Ename').setValue(model.get('ename')); //赋值操作
						Ext.getCmp('d_Eid').setValue(model.get('eid'));
						Ext.getCmp('d_Esex').setValue(model.get('esex'));
						Ext.getCmp('d_Ephonenum').setValue(model.get('ephonenum'));
						Ext.getCmp('d_Edistrict').setValue(model.get('edistrict'));
						Ext.getCmp('d_Eemail').setValue(model.get('eemail'));
					}
				}
			}, {
				xtype : "button",
				text : "删除",
				icon : '../public/image/delete.png',
				listeners : {
					"click" : function(btn) {
						var grid = window.down("grid");
						var records = grid.getSelectionModel().getSelection();
						if(records.length == 0){
							Ext.Msg.show({
								title: '操作提示',
								msg: '您没有选择需要修改的行，请选择后重试！！',
								buttons: Ext.MessageBox.OK,
								icon: Ext.MessageBox.ERROR
							});
							return;
						}else{
							Ext.MessageBox.confirm("确认","是否所选得删除站点",function(btn){  
								if(btn == "yes"){
									for (var i = 0; i < records.length; i++) {
										var model = records[i];//得到model
										Ext.Ajax.request({
											url : './delemployee',
											method : 'post',
											params : {
												'Ename' : model.get('ename'),
												'Eid' : model.get('eid'),
												'Esex' : model.get('esex'),
												'Ephonenum' : model.get('ephonenum'),
												'Edistrict' : model.get('edistrict'),
												'Eemail' : model.get('eemail')
											},
											dataType : 'text',
											success : function(response) {
												var val = response.responseText
												if (val == 'Y') {
													Ext.example.msg('成功', '删除成功！', true);
													var grid = Ext.getCmp('showgrid');//通过grid的id取到grid
													grid.store.reload();//刷新数据，也就是向后台请求数据再加载出来
												}
												if (val == 'N') {
													Ext.example.msg('失败', '删除失败！', true);
												}
											}
										});
									}
								}else{
									return;
								}
							});
						};
						//console.dir(model.get('station_phone'));//控制台输出
					}
				}
			}]
		}
			});
		
	// 新增
	var addform = Ext.create('Ext.form.Panel', {
		bodyStyle : {
			padding : '10px'
		},
		items : [{
			xtype : "textfield",
			name : "Ename",
			fieldLabel : "姓名"
		}, {
			xtype : "textfield",
			name : "Esex",
			fieldLabel : "性别"
		}, {
			xtype : "textfield",
			name : "Ephonenum",
			fieldLabel : "手机号码"
		}, {
			xtype : "textfield",
			name : "Edistrict",
			fieldLabel : "所属区域"
		}, {
			xtype : "textfield",
			name : "Ee-mail",
			vtype:'email',
			fieldLabel : "邮箱"
		}],
		buttons: [{
        	text: '取消',
        	handler: function() {
            	this.up('form').getForm().reset();
            	this.up('window').hide();
       		}
    	}, {
        	text: '保存',
        	handler: function() {
			var form = addform.getForm();
				Ext.Ajax.request({
					url : './addemployee',
					method : 'post',
					params : {
						'Ename' : form.findField("Ename").getValue(),
						'Esex' : form.findField("Esex").getValue(),
						'Ephonenum' : form.findField("Ephonenum").getValue(),
						'Edistrict' : form.findField("Edistrict").getValue(),
						'Eemail' : form.findField("Ee-mail").getValue()
					},
					dataType : 'text',
					success : function(response) {
						var val = response.responseText
						if (val == 'Y') {
							Ext.example.msg('成功', '添加成功！', true);
							var grid = Ext.getCmp('showgrid');//通过grid的id取到grid
							grid.store.reload();//刷新数据，也就是向后台请求数据再加载出来
							addWindow.close();
						}
						if (val == 'N') {
							Ext.example.msg('成功', '添加失败,请重试！', true);
						}
					}
				})
        	}
    	}]
	});
			
	//更新
	var updateform = Ext.create('Ext.form.Panel', {
		bodyStyle : {
			padding : '10px'
		},
		items : [{
			xtype : "textfield",
			name : "Eid",
			id : "d_Eid",
			fieldLabel : "巡维卡号",
			disabled : true
			// readOnly:true
		},{
			xtype : "textfield",
			name : "Ename",
			id : "d_Ename",
			fieldLabel : "姓名"
		}, {
			xtype : "textfield",
			name : "Esex",
			id : "d_Esex",
			fieldLabel : "性别"
		}, {
			xtype : "textfield",
			name : "Ephonenum",
			id : "d_Ephonenum",
			fieldLabel : "手机号码"
		}, {
			xtype : "textfield",
			name : "Edistrict",
			id : "d_Edistrict",
			fieldLabel : "所属区域"
		}, {
			xtype : "textfield",
			name : "Eemail",
			id : "d_Eemail",
			vtype:'email',
			fieldLabel : "邮箱"
		}],
		buttons: [{
        	text: '取消',
        	handler: function() {
            	this.up('form').getForm().reset();
            	this.up('window').hide();
       		}
    	}, {
        	text: '更新',
        	handler: function() {
				var form = updateform.getForm();
				Ext.Ajax.request({
					url : './updateemployee',
					method : 'post',
					params : {
						'Eid' : form.findField("Eid").getValue(),
						'Ename' : form.findField("Ename").getValue(),
						'Esex' : form.findField("Esex").getValue(),
						'Ephonenum' : form.findField("Ephonenum").getValue(),
						'Edistrict' : form.findField("Edistrict").getValue(),
						'Eemail' : form.findField("Eemail").getValue()
					},
					dataType : 'text',
					success : function(response) {
						var val = response.responseText
						if (val == 'Y') {
							Ext.example.msg('成功', '更新成功！', true);
							var grid = Ext.getCmp('showgrid');//通过grid的id取到grid
							grid.store.reload();//刷新数据，也就是向后台请求数据再加载出来
							updateWindow.close();
						}
						if (val == 'N') {
							Ext.example.msg('失败', '更新失败！', true);
						}
					}
				})
        	}
    	}]
	});
			
	// 新增窗口
	var addWindow = Ext.create('Ext.window.Window', {
		title : "添加人员",
		closeAction : "hide",// 设置该属性新增窗口关闭的时候是隐藏
		items : addform,
        width: 287,
        height: 327,
        minWidth: 287,
        minHeight: 327,
		layout : "fit",
		//bodyStyle:"text-align:center",
		modal : true//在其父容器设置一个蒙版，不能点击
		//resizable: false,
		
	});

	// 更新窗口
	var updateWindow = Ext.create('Ext.window.Window', {
		title : "更新",
		closeAction : "hide",// 设置该属性新增窗口关闭的时候是隐藏
		items : updateform,
		width: 285,
        height: 360,
        minWidth: 285,
        minHeight: 360,
		layout : "fit",
		modal : true//在其父容器设置一个蒙版，不能点击
	});
	
	// 窗口
	var window = Ext.create("Ext.window.Window", {
		title : "站点",
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
	window.fitContainer();// 填充满浏览器
	
	});
	function showAlert() {
		var selectedData = grid.getSelectionModel().getSelection()[0].data;
		Ext.MessageBox.alert("标题", selectedData.cataId);
	}