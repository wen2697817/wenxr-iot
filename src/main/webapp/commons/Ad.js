/**
 * file : Ad.js
 * 
 * @class : Ad
 * 
 * @author : yanghl
 * 
 * desc : the ad project.
 */

Ext.QuickTips.init();

// use msg target
Ext.form.Field.prototype.msgTarget = 'title';

var base, globalPageSize = 15;

/**
 * 覆盖store的默认分页参数名字，使之自动注入page
 */
Ext.data.Store.prototype.defaultParamNames = {
	start : 'page.start',
	limit : 'page.limit'
}

Ad = function(grid) {
	base = this;
	this.grid = grid;
}

/**
 * 生成表格，需要提供store,sm,cm,tbar
 * 
 * @param store
 * @param sm
 * @param cm
 * @param tbar
 * @param title
 *            for tabpanel's title
 * @return
 */
Ad.prototype.initGrid = function(store, sm, cm, tbar, title) {
	if (this.grid) {
		return this.grid;
	}
	this.grid = new Ext.grid.GridPanel({
				loadMask : {
					msg : '正在加载...'
				},
				title : title,
				autoWidth : true,
				height : Ext.getBody().getHeight(),
				autoScroll : true,
				store : store,
				sm : sm,
				cm : cm,
				tbar : tbar,
				plugins : this.plugins,
				enableColumnMove : false,
				bbar : new Ext.PagingToolbar({
							pageSize : globalPageSize,
							store : store,
							displayInfo : true,
							displayMsg : '当前显示第{0}-{1}条 共有{2}条数据',
							emptyMsg : "当前列表没有数据"
						})
			});
	return this.grid;
}

/**
 * 将grid表格放到Viewport中
 * 
 * @param grid
 * @return
 */
Ad.prototype.render = function(grid) {
	this.grid = grid || this.grid;

	if (!this.grid) {
		this.errroAlert("", "grid 无值!");
		return false;
	}
	new Ext.Viewport({
				layout : "fit",
				items : this.grid
			});
}
/**
 * grid的plugin属性
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.setGridPlugins = function(plugins) {
	this.plugins = plugins;
}
/**
 * 未选择一行的提示窗
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.selectAlert = function(title, msg, callBack) {
	this.show(title ? title : '提示', msg ? msg : '请选择一条数据！', callBack, 0);
}

/**
 * 保存后的提示窗
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.saveAlert = function(title, msg, callBack) {
	this.show(title ? title : '提示', msg ? msg : '保存成功！', callBack, 0);
}

/**
 * 更新后的提示窗
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.updateAlert = function(title, msg, callBack) {
	this.show(title ? title : '提示', msg ? msg : '修改成功！', callBack, 0);
}

/**
 * 删除成功提示框
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.deleteAlert = function(title, msg, callBack) {
	this.show(title ? title : '提示', msg ? msg : '删除成功！', callBack, 0);
}

/**
 * 删除前的警告窗
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.deleteConfirm = function(title, msg, callBack) {
	this.show(title ? title : '警告', msg ? msg : '你确定要删除所选数据？', callBack, 1);
}

/**
 * 错误提示框，需要给定msg值
 * 
 * @param title
 * @param msg
 * @param callBack
 * @return
 */
Ad.prototype.errorAlert = function(title, msg, callBack) {
	Ext.Msg.show({
				title : title ? title : '错误',
				msg : msg ? msg : '程序执行错误！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR,
				fn : callBack ? callBack : undefined
			});
}

/**
 * 消息框 type : {0 : OK, 1 : YESNO, 2 : YESCANCEL, 3 : YESNOCANCEL}
 * 
 * @param title
 * @param msg
 * @param callBack
 * @param type
 * @return
 */
Ad.prototype.show = function(title, msg, callBack, type) {
	Ext.Msg.show({
				title : title ? title : '消息',
				msg : msg ? msg : '提示',
				buttons : type == 0 ? Ext.Msg.OK : type == 1 ? Ext.Msg.YESNO : type == 2
						? Ext.Msg.YESCANCEL
						: type == 3 ? Ext.Msg.YESNOCANCEL : Ext.Msg.OK,
				icon : type == 0 ? Ext.Msg.INFO : type == 1 ? Ext.Msg.WARNING : type == 2 ? Ext.Msg.WARNING : type == 3
						? Ext.Msg.WARNING
						: Ext.Msg.INFO,
				fn : callBack ? callBack : undefined
			});
}

/**
 * 刷新grid的store
 * 
 * @param grid
 * @param params
 * @return
 */
Ad.prototype.reloadStore = function(grid, params) {
	var g = grid ? grid : this.grid;
	if (!g) {
		this.errorAlert(null, "grid is null", null);
		return false;
	}
	if (params) {
		g.getStore().reload(params);
	} else {
		g.getStore().reload();
	}
}
/**
 * 获取单行选择记录
 * 
 * @param grid
 * @return
 */
Ad.prototype.getSelected = function(grid) {
	var g = grid ? grid : this.grid;
	if (!g) {
		this.errorAlert(null, "grid is null", null);
		return false;
	}

	var r = g.getSelectionModel().getSelected();
	if (!r) {
		this.selectAlert();
		return false;
	}
	return r.data;
}

/**
 * 获取所选多行记录
 * 
 * @param grid
 * @return
 */
Ad.prototype.getSelections = function(grid) {
	var g = grid ? grid : this.grid;
	if (!g) {
		this.errorAlert(null, "grid is null", null);
		return [];
	}

	var r = g.getSelectionModel().getSelections();
	if (!r || !r[0]) {
		this.selectAlert(null, "请至少选择一条数据！");
		return [];
	}
	var arr = [];
	Ext.each(r, function(item) {
				arr[arr.length] = item.data;
			});
	return arr;
}

/**
 * 获取loadmask ,需要关闭（隐藏）
 * 
 * @param mask
 * @param el
 * @return
 */
Ad.prototype.getLoadMask = function(mask, el) {
	base.mask = new Ext.LoadMask(el || Ext.getBody(), {
				msg : mask ? mask : "正在执行..."
			});
	return base.mask;
}

Ad.prototype.stationMenuCheck = function(title, container, callback) {
	var btn = new Ext.Button({
				text : title || "选择车站",
				menu : {
					id : "stationMenu",
					xtype : "menu",
					items : [{
								text : "正在加载..."
							}]
				}
			});
	container.add(btn);
	container.doLayout();
	var menu = Ext.getCmp("stationMenu");
	Ext.Ajax.request({
				url : "media/stationTree.action",
				success : function(response, options) {
					var json = response.responseText || response.responseData;
					var list = Ext.decode(json);
					menu.removeAll();
					for (var i = 0; i < list.length; i++) {
						if (list[i].children && list[i].children.length > 0) {
							var m1 = new Ext.menu.Menu({
										items : []
									});
							var m = new Ext.menu.CheckItem({
										id : list[i].id,
										checked : false,
										hideOnClick : false,
										text : list[i].text,
										menu : m1,
										checkHandler : checkFunc
									});
							var ch = list[i].children;
							for (var j = 0; j < ch.length; j++) {
								var mm = new Ext.menu.CheckItem({
											id : ch[j].id,
											checked : false,
											hideOnClick : false,
											text : ch[j].text,
											checkHandler : checkFunc
										});
								m1.add(mm);
							}
							menu.add(m);
						} else {
							var m = new Ext.menu.CheckItem({
										id : list[i].id,
										checked : false,
										hideOnClick : false,
										text : list[i].text,
										checkHandler : checkFunc
									});
							menu.add(m);
						}
					}
				},
				failure : function() {
					base.errorAlert();
				}
			});
	var checkFunc = function(item, checked) {
		if (item.menu) {
			for (var i = 0; i < item.menu.items.length; i++) {
				item.menu.items.get(i).setChecked(checked, true);
			}
		}
		// 若有回调则执行回调，否则执行搜索按钮
		if (callback) {
			callback(getStationMenuSelectIds("stationMenu"));
		} else if (Ext.getCmp("searchBtn")) {
			Ext.getCmp("searchBtn").fireEvent("click");
		}
	}
}
Ad.prototype.cityMenuCheck = function(title, container, callback) {
	var btn = new Ext.Button({
				text : title || "选择地区",
				menu : {
					id : "cityMenu",
					xtype : "menu",
					items : [{
								text : "正在加载..."
							}]
				}
			});
	container.add(btn);
	container.doLayout();
	var menu = Ext.getCmp("cityMenu");
	menu.removeAll();
	for (var i = 0; i < cityScope.length; i++) {
		var m = new Ext.menu.CheckItem({
					id : cityScope[i],
					checked : false,
					hideOnClick : false,
					text : cityScope[i],
					checkHandler : function(item, checked) {
						// 若有回调则执行回调，否则执行搜索按钮
						if (callback) {
							callback(getStationMenuSelectIds("cityMenu"));
						} else if (Ext.getCmp("searchBtn")) {
							Ext.getCmp("searchBtn").fireEvent("click");
						}
					}
				});
		menu.add(m);
	}
}
var getStationMenuSelectIds = function(cid) {
	var menu = Ext.getCmp(cid);
	if (!menu) {
		return [];
	}
	var ids = [];
	for (var i = 0; i < menu.items.length; i++) {
		var ch = menu.items.get(i).menu;
		if (ch) {
			for (var j = 0; j < ch.items.length; j++) {
				if (ch.items.get(j).checked === true) {
					ids[ids.length] = ch.items.get(j).id;
				}
			}
		} else {
			if (menu.items.get(i).checked === true) {
				ids[ids.length] = menu.items.get(i).id;
			}
		}
	}
	return ids;
}
/**
 * 增加查询功能
 * 
 * @param condition
 * @return
 */
Ad.prototype.appendCondition = function(condition) {
	if (!this.grid) {
		return;
	}
	if (!condition || condition.length <= 0) {
		return;
	}
	var conditionCombo = new Ext.form.ComboBox({
				id : "conditionCombo",
				typeAhead : true,
				triggerAction : 'all',
				lazyRender : true,
				forceSelection : true,
				editable : false,
				width : 100,
				mode : 'local',
				store : new Ext.data.ArrayStore({
							fields : ['myId', 'displayText'],
							data : condition
						}),
				valueField : 'myId',
				displayField : 'displayText'
			});

	valueHtml = "<input type='text' id='_value'/>";
	var topBar = base.grid.getTopToolbar();
	topBar.add("搜索");
	topBar.add(conditionCombo);
	topBar.add({
				xtype : "textfield",
				id : "valueField",
				listeners : {
					"specialkey" : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							Ext.getCmp("searchBtn").fireEvent("click");
						}
					}
				}
			});
	topBar.add({
				text : "查询",
				icon : "img/search.gif",
				id : "searchBtn",
				listeners : {
					"click" : function() {
						var c = conditionCombo.getValue();
						var v = Ext.getCmp("valueField").getValue();
						var p = {
							"page.condition" : [],
							"page.keyWord" : [],
							"page.relation" : []
						};
						if (v) {
							p["page.condition"].push(c);
							p["page.keyWord"].push(v);
							p["page.relation"].push("and");
						}
						if (Ext.getCmp("stationMenu")) {
							var ids = getStationMenuSelectIds("stationMenu");
							if (ids.length > 0) {
								if(p.length > 0) {
									p[""].push();
								}
								for (var i = 0; i < ids.length; i++) {
									p["page.condition"].push("paramStation.staId");
									p["page.keyWord"].push(ids[i]);
									p["page.relation"].push("or");
								}
							}
						} else if (Ext.getCmp("trainMenu")) {
						} else if (Ext.getCmp("cityMenu")) {
						}
						base.grid.getStore().load({
									params : p
								});
						Ext.apply(base.grid.getStore().baseParams, base.grid.getStore().lastOptions.params);
					}
				}
			});
	conditionCombo.setValue(condition[0][0]);
	topBar.doLayout();
}