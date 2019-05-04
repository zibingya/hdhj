Ext.onReady(function() {
	Ext.tip.QuickTipManager.init();
	var itemsPerPage = 2;// 设置每页所需的项数
	var store = Ext.create('Ext.data.Store', {
		fields : ['station_pictureurl', 'station_no', 'station_name',
				'station_kind', 'station_manager', 'station_phone',
				'station_description','station_longitude','station_latitude'],
		pageSize : itemsPerPage, // 页容量数据
		// 是否在服务端排序 （true的话，在客户端就不能排序）
		remoteSort : false,
		remoteFilter : true,
		proxy : {
			type : 'ajax',
			url:'/stationbasic',
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
				text : "照片",
				sortable : true,
				width:200,
				renderer : function(value) {
					var img ="<img style='width:160px;height:90px' src='../public/image/station/"+value+"' />" 
					return img;
				},
				dataIndex : 'station_pictureurl'
			}, {
				text : "站点编号",
				sortable : true,
				dataIndex : 'station_no'
			}, {
				text : "站点名称",
				sortable : true,
				dataIndex : 'station_name'
			}, {
				text : "站点类型",
				sortable : true,
				dataIndex : 'station_kind'
			}, {
				text : "站点管理员",
				sortable : true,
				dataIndex : 'station_manager'
			}, {
				text : "联系方式",
				sortable : true,
				dataIndex : 'station_phone'
			}, {
				text : "站点描述",
				sortable : true,
				dataIndex : 'station_description'
			},  {
				text : "经度",
				sortable : true,
				dataIndex : 'station_longitude'
			}, {
				text : "纬度",
				sortable : true,
				dataIndex : 'station_latitude'
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
						Ext.getCmp('d_station_pictureurl').setValue(model.get('station_pictureurl')); //赋值操作
						Ext.getCmp('d_station_name').setValue(model.get('station_name'));
						Ext.getCmp('d_station_no').setValue(model.get('station_no'));
						Ext.getCmp('d_station_kind').setValue(model.get('station_kind'));
						Ext.getCmp('d_station_manager').setValue(model.get('station_manager'));
						Ext.getCmp('d_station_phone').setValue(model.get('station_phone'));
						Ext.getCmp('d_station_description').setValue(model.get('station_description'));
						Ext.getCmp('d_station_longitude').setValue(model.get('station_longitude'));
						Ext.getCmp('d_station_latitude').setValue(model.get('station_latitude'));
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
											url : './delstation',
											method : 'post',
											params : {
												'station_name' : model.get('station_name'),
												'station_no' : model.get('station_no'),
												'station_pictureurl' : model.get('station_pictureurl'),
												'station_kind' : model.get('station_kind'),
												'station_manager' : model.get('station_manager'),
												'station_phone' : model.get('station_phone'),
												'station_description' : model.get('station_description'),
												'station_longitude' : model.get('station_longitude'),
												'station_latitude' : model.get('station_latitude')
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
		id: 'fileUploadForm',
		bodyStyle : {
			padding : '10px'
		},
		items : [{
			xtype : "filefield",
			buttonText: '选择图片',
			id: 'upFile',
			name : "upFile",
			fieldLabel : "图片地址："
		}, {
			xtype : "textfield",
			name : "station_name",
			fieldLabel : "站点名称"
		}, {
			xtype : "textfield",
			name : "station_kind",
			fieldLabel : "站点类型"
		}, {
			xtype : "textfield",
			name : "station_manager",
			fieldLabel : "站点管理员"
		}, {
			xtype : "textfield",
			name : "station_phone",
			fieldLabel : "联系方式"
		}, {
			xtype : "textfield",
			name : "station_description",
			fieldLabel : "站点描述"
		}, {
			xtype : "textfield",
			name : "station_longitude",
			fieldLabel : "经度"
		}, {
			xtype : "textfield",
			name : "station_latitude",
			fieldLabel : "纬度"
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
				var formUpload = Ext.getCmp('fileUploadForm');
				formUpload.getForm().submit({
							url :  './addstation',
							waitMsg : '文件正在上传，请耐心等待....',
							method : 'post',
							success : function(response,o) {
								Ext.example.msg('添加', '添加成功！', true);
								var grid = Ext.getCmp('showgrid');//通过grid的id取到grid
								grid.store.reload();//刷新数据，也就是向后台请求数据再加载出来
								form.reset();//清楚表单的记录
								addWindow.close();
								
							},
							failure : function(response,o) {
								Ext.Msg.alert('系统提示', o.msg);
								form.reset();
								return;
							}
						});
				/*Ext.Ajax.request({
					url : './addstation',
					method : 'post',
					
					params : {
						'station_name' : form.findField("station_name").getValue(),
						'station_pictureurl' : form.findField("station_pictureurl").getValue(),
						'station_kind' : form.findField("station_kind").getValue(),
						'station_manager' : form.findField("station_manager").getValue(),
						'station_phone' : form.findField("station_phone").getValue(),
						'station_description' : form.findField("station_description").getValue(),
						'station_longitude' : form.findField("station_longitude").getValue(),
						'station_latitude' : form.findField("station_latitude").getValue()
					},
					isUpload:true,
					form:'form',
					dataType : 'text',
					waitMsg: '正在上传...',
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
				})*/
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
			name : "station_no",
			id : "d_station_no",
			fieldLabel : "站点编号",
			disabled : true
			// readOnly:true
		},{
			xtype : "textfield",
			name : "station_pictureurl",
			id:"d_station_pictureurl",
			fieldLabel : "图片地址："
		}, {
			xtype : "textfield",
			name : "station_name",
			id:"d_station_name",
			fieldLabel : "站点名称"
		}, {
			xtype : "textfield",
			name : "station_kind",
			id:"d_station_kind",
			fieldLabel : "站点类型"
		}, {
			xtype : "textfield",
			name : "station_manager",
			id:"d_station_manager",
			fieldLabel : "站点管理员"
		}, {
			xtype : "textfield",
			name : "station_phone",
			id:"d_station_phone",
			fieldLabel : "联系方式"
		}, {
			xtype : "textfield",
			name : "station_description",
			id:"d_station_description",
			fieldLabel : "站点描述"
		}, {
			xtype : "textfield",
			name : "station_longitude",
			id:"d_station_longitude",
			fieldLabel : "经度"
		}, {
			xtype : "textfield",
			name : "station_latitude",
			id:"d_station_latitude",
			fieldLabel : "纬度"
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
					url : './updatestation',
					method : 'post',
					params : {
						'station_name' : form.findField("station_name").getValue(),
						'station_pictureurl' : form.findField("station_pictureurl").getValue(),
						'station_kind' : form.findField("station_kind").getValue(),
						'station_manager' : form.findField("station_manager").getValue(),
						'station_phone' : form.findField("station_phone").getValue(),
						'station_description' : form.findField("station_description").getValue(),
						'station_longitude' : form.findField("station_longitude").getValue(),
						'station_no' : form.findField("station_no").getValue(),
						'station_latitude' : form.findField("station_latitude").getValue()
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
		title : "添加站点",
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
		title : "更新窗口",
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
		//height: window.innerHeight,
    	//width: window.innerWidth,
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