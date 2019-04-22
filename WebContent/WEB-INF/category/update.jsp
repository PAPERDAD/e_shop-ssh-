<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<style>
form div {
	margin:5px;
}
</style>
<script type="text/javascript">
	$(function(){
		var dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
		$("#cc").combobox({
			url:'account_query.action',  
		    valueField:'id',    
		    textField:'login', //我们下拉列表中显示的是管理员的登录名
		    panelHeight:'auto', //自适应高度
		    panelWidth:120,//下拉列表是两个组件组成的
		    width:120, //要同时设置两个宽度才行
		    editable:false, //下拉框不允许编辑
		    required:true,
			missingMessage:'请选择所属类别'
		});
		
		var rows = dg.datagrid("getSelections");
		//将拿到的那一行对应的数据字段加载到表单里，实现回显
		$("#ff").form('load',{
			id:rows[0].id,
		type:rows[0].type,
	        hot:rows[0].hot,
			'account.id':rows[0].account.id //EasyUI不支持account.id这种点操作，所以要加个引号
		});
		
		$("input[name=type]").validatebox({
			required:true,
			missingMessage:'请输入类别名称',
		});
		
		$("#ff").form("disableValidation");
			//注册button的事件
		$("#btn").click(function(){
				//开启验证
			$("#ff").form("enableValidation");
			//如果验证成功，则提交数据
			if($("#ff").form("validate")) {
					//调用submit方法提交数据
				$("#ff").form('submit', {
					url: 'category_update.action', //提交时将请求传给categoryAction的update方法执行
					success: function(){
							//如果成功了，关闭当前窗口，并刷新页面
						parent.$("#win").window("close");
						dg.datagrid("reload");
						}
				});
			}
		});
	})
</script>
</head>
<body>
<form id="ff" method="post">
	<div>
		<label for="name">类别名称：</label><input type="text" name="type"/>
	</div>
	<div>
		<label for="hot">热点:</label>
		是<input type="radio" name="hot" value="true"/>
		否<input type="radio" name="hot" value="false"/>
	</div>
	<div>
		<label for="account">所属管理员：</label>
		<input id="cc" name="account.id"/>
	</div>
	<div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>  
	    	<input type="hidden" name="id" />
	</div>
</form>
</body>
</html>