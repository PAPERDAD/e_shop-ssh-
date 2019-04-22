<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE !DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<%@ include file="/public/head.jspf"%>
<style type="text/css">
		#menu {
			width:60px;
			/*border:1px solid red;*/
		}
		#menu ul {
			list-style: none;
			padding: 0px;
			margin: 0px;
		}
		#menu ul li {
			border-bottom: 1px solid #fff;
			
		}
		#menu ul li a {
			display: block;
			background-color: #00a6ac;
			color: #fff;
			padding: 5px;
			text-decoration: none;
		}
		#menu ul li a:hover {
			background-color: #008792;
		}
</style>
<script type="text/javascript">

	$(function(){
		$("a[title]").click(function(){
		
			var text = $(this).text();
			var href = $(this).attr("title");
			if($("#tt").tabs("exists", text)) {
				$("#tt").tabs("select", text);
			} else {
				$("#tt").tabs("add",{
					title:text,
					closable:true,
					content:'<iframe  title='+text+' src='+href+' frameborder="0" width="100%" height="100%" />'
				});
			}
			
		});
	});
</script>
</head>

<body class="easyui-layout">
    <div data-options="region:'north',title:'欢迎来到熊熊购物后台',split:true" style="height:100px;"></div>      
    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true" style="width:200px;height:400px;">   
        	<div title="基本操作" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
       			<ul>
    		    	<li><a  href="#" title="send_category_query.action">类别管理</a></li>
    		        <li><a href="#" title="send_product_query.action">商品管理</a></li>
    		        <li><a href="#" title="send_forder_query.action">订单管理</a></li>
    	        </ul>
            </div>   
            <div title="销售管理" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
       			<ul>
    		    	<li><a href="#" title="send_sorder_query.action">销售管理</a></li>
    	        </ul>          
            </div>  
       </div>   
    </div>
    	
    <div data-options="region:'center',title:'后台操作页面'"   style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs"  data-options="fit:true">   
    		<div title="系统缺省页面" style="padding:20px;display:none" >   
    		</div>   
		</div> 
    </div>  
    <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
</body>

</html>