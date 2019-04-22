<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
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
		<!--导航栏结束-->
		<div class="section_container">
			<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form method="post" action="user_login.action">
					<div>
						<label for="login">账号:&nbsp;</label> 
						<input type="text" name="login" />
					</div>
					<div>
						<label for="pass">密码:&nbsp;</label> 
						<input type="password" name="pass" />
					</div>
					<div>
						${sessionScope.error}  
					</div>
					<div>
						<input type="submit" value="登陆" style="width:60px;height:30px" />
						<input type="button" value="注册" onclick="window.location.href='${shop}/register.jsp'" style="width:60px;height:30px" />
					</div>
			   </form>
			   <div style="clear:both"></div>
			</div>
		</div>
			<!-- 导航栏结束 -->
		<div class="footer_container">
			<%@include file="/public/footer.jspf"%>
       </div>
		</div>
</body>
</html>
