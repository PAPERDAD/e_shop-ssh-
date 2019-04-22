<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript">
$(function(){
		$.extend($.fn.validatebox.defaults.rules, {
		    equals: {
				validator: function(value,param){
					return value == $(param[0]).val();
				},
				message: '两次输入密码不一致.'
		    },
		    mobile: {//value值为文本框中的值
		    	validator: function (value) {
		    	var reg = /^1[3|4|5|8|9]\d{9}$/;
		    	return reg.test(value);
		    	},
		    	message: '输入手机号码格式不准确.'
		    },
		    name: {
		    	validator: function (value) {
		    	return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
		    	},
		    	message: '请输入姓名'
		    },
		    username: {// 验证用户名
		    	validator: function (value) {
		    	return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
		    	},
		    	message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
		    },

		    	
		});

		$("input[name=login]").validatebox({
			required:true,
			validType:'username',
			missingMessage:'请输入用户名'
		});
		
		
		$("input[name=name]").validatebox({
			required:true,
			missingMessage:'请输入姓名'
		});
		
		$("input[name=checkCode]").validatebox({
			required:true,
			missingMessage:'请输入验证码'
		});
		
		$("input[name=phone]").validatebox({
			required:true,
			validType:'mobile',
			missingMessage:'请输入手机号码'
		});
		
		$("input[name=email]").validatebox({
			required:true,
			validType:'email',
			missingMessage:'请输入邮箱地址'
		});
		
		$("input[name=pass]").validatebox({
			required:true,
			validType:'minLength[6]',
			missingMessage:'请输入不少于6位密码'
		});
		
		$("#rpwd").validatebox({
			required:true,
			validType:"equals['#pwd']",
			missingMessage:'请再次输入密码'
		});
		
		
		$("#ff").form("disableValidation");
		
		$("#submit").click(function(){
			$("#ff").form("enableValidation");
			if($("#ff").form("validate")) {
				$("#ff").attr("action","user_register.action").submit();
			}else{
				alert("请检查输入");
			};
              
		
		});
		
		$("#reset").click(function(){
			$("#ff").form("disableValidation");//重置不需要表单验证
			//重置当前表单数据
			$("#ff").form("reset");
		});
		
		$("#checkImg").click(function(){
			$("#checkImg").attr("src","${pageContext.request.contextPath}/checkImage.action?"+new Date().getTime());
		});
		
	})
</script>
</head>

<body>
<div class="wrapper">
  	    <div class="header_container">
   			 <%@ include file="/public/header.jspf" %>
    	</div>
        <!-- 头部结束 -->

        <!-- 导航栏 -->
        <div class="navigation_container">
        <!---->
        	 <%@ include file="/public/nav.jspf" %>
        </div>
        
        <div class="form_container" >
        <div class="action_buttonbar"  style="text-align:center；">
        	<form title="注册" id="ff" method="post" >
        	<table frame=void   style="margin: 0 auto">
        	<tr><td colspan=2 align="center" valign="middle" ><p>${sessionScope.error}</p></td></tr>
        	<tr>
					<td><label>用户名:</label></td>
					 <td><input  type="text" name="login" /></td>
			</tr>
			<tr>
					<td><label>姓名:</label></td>
					<td><input  type="text" name="name" /></td>
			</tr>
			<tr>	
					<td><label>性别:</label></td>
					<td> 男<input type="radio" name="sex" checked="checked" value="male" /> 
					            女<input type="radio" name="sex" value="female" /></td> 
			</tr>
			<tr>
					<td><label>电话:</label></td> 
					<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
					<td><label>邮箱:</label></td> 
					<td><input  type="text" name="email" /></td>
			</tr>
			<tr>
					<td><label>密码：</label></td>
					<td><input id="pwd" name="pass" type="password" /></td>   
			</tr>
			<tr>
					<td><label>确认密码：</label></td>
					<td><input id="rpwd" type="password" /></td> 
			</tr>
			<tr>
					<td colspan=2 align="center" valign="middle" >
						<span class="fieldSet">
							<label>验证码：</label><input type="text" id="checkCode" name="checkCode" class="text captch"
							maxlength="4" autocomplete="off">
							<img id="checkImg" class="captchaImage"
							src="${pageContext.request.contextPath}/checkImage.action"  title="点击更换验证码">
						</span>
					</td>

          </tr>
			<tr>
					<td colspan=2 align="center" valign="middle" ><a id="submit" href="#" class="easyui-linkbutton">注册</a>
					<a id="reset" href="#" class="easyui-linkbutton">重 置</a></td>
			</tr>
				</table>
	  </form>
	  </div>	
        </div>
        
        
        
       <div class="footer_container">
			<%@include file="/public/footer.jspf"%>
       </div>
</div>
</body>
</html>