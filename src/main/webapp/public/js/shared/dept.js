Ext.onReady(function() {
	Ext.tip.QuickTipManager.init();
	var itemsPerPage = 2;// 设置每页所需的项数
	var store = Ext.create('Ext.data.Store', {
		fields : ['dname', 'deptno', 'ddescription','dstate','dtime','content.dceater', 'dchangetime', 'dchanger','totalElements'],
		pageSize : itemsPerPage, // 页容量数据
		// 是否在服务端排序 （true的话，在客户端就不能排序）
		remoteSort : false,
		remoteFilter : true,
		proxy : {
			type : 'ajax',
			url:'/dept',
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
			start : 1,
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
				text : "部门名称",
				sortable : true,
				dataIndex : 'dname'
			}, {
				text : "部门编号",
				sortable : true,
				dataIndex : 'deptno'
			}, {
				text : "部门描述",
				sortable : true,
				dataIndex : 'ddescription'
			}, {
				text : "状态",
				sortable : true,
				dataIndex : 'dstate'
			}, {
				text : "创建时间",
				sortable : true,
				dataIndex : 'dtime'
			}, {
				text : "创建者w1",
				sortable : true,
				dataIndex : 'content.dceater'
			}, {
				text : "修改时间",
				sortable : true,
				dataIndex : 'dchangetime'
			},  {
				text : "修改者",
				sortable : true,
				dataIndex : 'dchanger'
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
						Ext.getCmp('d_dname').setValue(model.get('dname')); //赋值操作
						Ext.getCmp('d_deptno').setValue(model.get('deptno'));
						Ext.getCmp('d_ddescription').setValue(model.get('ddescription'));
						Ext.getCmp('d_dstate').setValue(model.get('dstate'));
						Ext.getCmp('d_dtime').setValue(model.get('dtime'));
						Ext.getCmp('d_dceater').setValue(model.get('dceater'));
						Ext.getCmp('d_dchangetime').setValue(model.get('dchangetime'));
						Ext.getCmp('d_dchanger').setValue(model.get('dchanger'));
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
											url : './deldept',
											method : 'post',
											params : {
												'dname' : model.get('dname'),
												'deptno' : model.get('deptno'),
												'ddescription' : model.get('ddescription'),
												'dstate' : model.get('dstate'),
												'dtime' : model.get('dtime'),
												'dceater' : model.get('dceater'),
												'dchangetime' : model.get('dchangetime'),
												'dchanger' : model.get('dchanger')
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
							name : "dname",
							fieldLabel : "部门名称"
						}, {
							xtype : "textfield",
							name : "ddescription",
							fieldLabel : "部门描述"
						}, {
							xtype : "textfield",
							name : "dstate",
							fieldLabel : "部门状态"
						}, {
							xtype : "textfield",
							name : "dtime",
							fieldLabel : "创建时间"
						}, {
							xtype : "textfield",
							name : "dceater",
							fieldLabel : "创建者"
						}, {
							xtype : "textfield",
							name : "dchangetime",
							fieldLabel : "修改时间"
						}, {
							xtype : "textfield",
							name : "dchanger",
							fieldLabel : "修改者"
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
									url : './adddept',
									method : 'post',
									params : {
										'dname' : form.findField("dname").getValue(),
										'ddescription' : form.findField("ddescription").getValue(),
										'dstate' : form.findField("dstate").getValue(),
										'dtime' : form.findField("dtime").getValue(),
										'dceater' : form.findField("dceater").getValue(),
										'dchangetime' : form.findField("dchangetime").getValue(),
										'dchanger' : form.findField("dchanger").getValue()
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
			name : "deptno",
			id : "d_deptno",
			fieldLabel : "部门编号",
			disabled : true
			// readOnly:true
		},{
			xtype : "textfield",
			name : "dname",
			id:"d_dname",
			fieldLabel : "部门名称"
		}, {
			xtype : "textfield",
			name : "ddescription",
			id:"d_ddescription",
			fieldLabel : "部门描述"
		}, {
			xtype : "textfield",
			name : "dstate",
			id:"d_dstate",
			fieldLabel : "部门状态"
		}, {
			xtype : "textfield",
			name : "dtime",
			id:"d_dtime",
			fieldLabel : "创建时间"
		}, {
			xtype : "textfield",
			name : "dceater",
			id:"d_dceater",
			fieldLabel : "创建者"
		}, {
			xtype : "textfield",
			name : "dchangetime",
			id:"d_dchangetime",
			fieldLabel : "修改时间"
		}, {
			xtype : "textfield",
			name : "dchanger",
			id:"d_dchanger",
			fieldLabel : "修改者"
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
					url : './updatedept',
					method : 'post',
					params : {
						'dname' : form.findField("dname").getValue(),
						'deptno' : form.findField("deptno").getValue(),
						'ddescription' : form.findField("ddescription").getValue(),
						'dstate' : form.findField("dstate").getValue(),
						'dtime' : form.findField("dtime").getValue(),
						'dceater' : form.findField("dceater").getValue(),
						'dchangetime' : form.findField("dchangetime").getValue(),
						'dchanger' : form.findField("dchanger").getValue()
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
		title : "添加部门",
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
		title : "部门",
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