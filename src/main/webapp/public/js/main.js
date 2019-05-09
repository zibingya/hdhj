Ext.onReady(panelLayout);
function panelLayout() {
	// 新建tabpanel
	var tab = Ext.create('Ext.TabPanel', {
		region : 'center',// 区域
		deferredRender : false,
		activeTab : 0,// 最初被激活的选项卡。 或者一个主键，索引或者选项卡容器本身
		resizeTabs : true, // turn on tab resizing
		minTabWidth : 115,// 最小的选项卡宽度
		tabWidth : 135,
		enableTabScroll : true,
		items : [{
			title : '首页',
			html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./map.html"></iframe>'
		}]

	});
	var viewPort = Ext.create('Ext.Viewport', {
		layout : "border",// 布局风格
		items : [{
			region : 'north',// 北，头部
			minHeight : 80,// 最小的高度
			region : 'north', // 北(上)
			//html : '<div class="img-top"><h1 style="font-size:50px;line-height: 10px;">环境治理设施智能管理软件</h1></div>',
			border : false, // 是否显示边框 默认是true(显示)
			bodyStyle : {
				background : 'url(./public/image/img-top.jpg)',
				padding : '5px'
			},
			layout: "column",
			items : [{
				xtype : "box",
				html : '<div class="img-top"><h1 style="font-size:50px;line-height: 10px;">环境治理设施智能管理软件</h1></div>'
			}, {
				xtype : "splitbutton",
				cls : "main-btn",
				icon : '../public/image/user.png',
				//x:llqwidth,
				y:25,
				minWidth : 104,
				enabelToggle : true,
				pressed : true,
				text : "Neo",
				menu : new Ext.menu.Menu({
					items : [{
						text : "修改密码",
						icon : '../public/image/password.png'
					}, {
						text : "退出系统",
						icon : '../public/image/exit.png',
						iconCls : "x-btn-exit",
						handler : function() {
							window.location.href = "index.html";
						}
					}]
				})
			}]
		}, {
			title : 'West Region is collapsible',// 标题
			region : 'west',// 区域，西区
			xtype : 'panel',// 类型，画板
			width : 200,// 宽度
			collapsible : true, // 设置可折叠
			id : 'west-region-container',
			layout : 'fit',
			margins : '0 0 0 0',
			layout : 'accordion',
			title : '菜单',
			split : true,// 是否允许改变宽度，true为允许，默认为false
			collapsible : false,// 是否允许在侧边显示黑色箭头允许折叠
			layoutConfig : {
				animate : true
				// 动画？
			},
			items : [{
				title : '视频监控',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '视频监控配置',
								id : '#1',// 这个id用来与下方的监听是否存在，如果存在就不打开
								expanded : true,// 此处展开所有。
								leaf : true
							}, {
								text : '视频实时监控',
								leaf : true,
								id : '#2'
							}, {
								text : '录像回放',
								leaf : true,
								id : '#3'
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true,
								// 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./grid3.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}, {
				title : '巡维管理',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 不显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '考勤规则设置',
								id : 'attendance',// 这个id用来与下方的监听是否存在，如果存在就不打开
								leaf : true
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true, // 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./'+r.raw.id+'.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}, {
				title : '运行报表',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 不显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '水流量报表',
								// id: 'root1',//这个id用来与下方的监听是否存在，如果存在就不打开
								children : [{
											text : '单站点水流量查询表',
											leaf : true,
											id : '#r1'
										}, {
											text : '水流量智能分析报表',
											leaf : true,
											id : '#r2'
										}, {
											text : '村级多站点累计流量报表',
											leaf : true,
											id : '#r3'
										}, {
											text : '镇级各村累计流量报表',
											leaf : true,
											id : '#r4'
										}, {
											text : '县级各镇累计流量报表',
											leaf : true,
											id : '#r5'
										}]
							}, {
								text : '动力设备报表',
								id : 'root',
								children : [{
											text : '风机开启监测',
											leaf : true,
											id : '#r6'
										}, {
											text : '水泵开启监测',
											leaf : true,
											id : '#r7'
										}]
							}, {
								text : '巡检评分汇总表',
								leaf : true,
								id : '#3'
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (r.raw.id == null) {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true, // 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./index/grid3.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}, {
				title : '告警管理',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 不显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '告警列表',
								id : 'toobar',// 这个id用来与下方的监听是否存在，如果存在就不打开
								leaf : true
							}, {
								text : '异常数据汇总表',
								leaf : true,
								id : 'toobar2'
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true, // 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./'+r.raw.id+'.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}, {
				title : '设备管理',
				border : false,
				html : '<div id="tree3" style="overflow:auto;width:100%;height:100%"></div>'
			}, {
				title : '基础信息管理',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '站点管理',
								id : 'z_station',// 这个id用来与下方的监听是否存在，如果存在就不打开
								expanded : true,// 此处展开所有。
								leaf : true
							}, {
								text : '人员管理',
								leaf : false,
								id : 'root',
								// autoShow:true,
								children : [{
									text : '巡维人员',
									leaf : true,
									id : 'z_employee'
								}, {
									text : '管理人员',
									leaf : true,
									id : 'z_employee2'
								}]
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true,
								// 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./'+r.raw.id+'.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}, {
				title : '系统管理',
				xtype : 'treepanel',
				expanded : true,
				animate : true,
				enableDD : false,
				rootVisible : false, // 不显示根节点Root
				border : false,
				containerScroll : true,// 滚动条
				root : {
					text : '..',
					id : 'root',
					autoShow : true,
					children : [{
								text : '部门管理',
								id : 'z_dept',// 这个id用来与下方的监听是否存在，如果存在就不打开
								leaf : true
							}, {
								text : '用户管理',
								leaf : true,
								id : '#2'
							}, {
								text : '角色管理',
								leaf : true,
								id : '#3'
							}, {
								text : '日志管理',
								leaf : true,
								id : 'systemlog'
							}]
				},
				listeners : {
					// 添加节点点击事件
					itemclick : function(v, r, item) {
						var n = tab.getComponent(r.raw.id);
						if (r.raw.id == 'root') {
							return;
						}
						if (!n) { // 判断是否已经打开该面板
							n = tab.add({
								'id' : r.raw.id,
								'title' : r.raw.text,
								closable : true, // 通过html载入目标页
								html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="./'+r.raw.id+'.html"></iframe>'
							});
						}
						tab.setActiveTab(n);
					}
				}
			}]
		}, tab
		]
	})
}