<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
	$(function(){
		
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
      <c:if test="${empty requestScope.searchList }">
  	 	<!-- 如果购物查询结果为空-->
  	 	<h2 class="sub_title">Ooops!!未找到相关商品！！</h2>
  	 </c:if>
  	 <c:if test="${not empty pageMap.searchList }">
  	 	                 <!-- 产品列表 -->
	           <div class="products_list products_slider clear">
	            	<!-- 显示类别名称 -->
	                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
	                   <c:forEach items="${pageMap.searchList}" var="product">
		                    <li> 
		                    	<a href="${shop}/product_get.action?id=${product.id}" class="product_image"><img src="${shop}/files/${product.pic}" /></a>
		                        <div class="product_info">
		                            <h3><a href="${shop}/product_get.action?id=${product.id}">商品名称：${product.name }</a></h3>
		                            <small>简单描述：${product.remark}</small> </div>
		                        <div class="price_info"> 
		                            <a href="${shop}/sorder_addSorder.action?product.id=${product.id}"><button><span class="pr_add">添加购物车</span></button></a>
		                            <button class="price_add" title="" type="button">
		                            	<span class="pr_price">￥${product.price}</span>
		                            </button>
		                        </div>
		                    </li>
		                </c:forEach>
	                </ul>
	            </div>
           
  	 </c:if>
  	         <!-- 导航栏结束 -->
        <div class="footer_container">
			<%@include file="/public/footer.jspf"%>
       </div>
  	 

</div>
        
</body>
</html>