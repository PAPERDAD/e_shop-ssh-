<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/head.jspf" %>
<script type="text/javascript">
$(function(){
    //1. 注册事件
    $(".text").change(function(){
    //2. 验证数据的有效性
        var number = this.value; //也可以使用$(this).val();
        //isNaN(number)表示若number不是数字就返回真
        if(!isNaN(number) && parseInt(number)==number && number>0){ 
            //如果合法，同步更新的数
            $(this).attr("lang", number);
            //找到当前标签中第一个是tr的父节点，然后拿到属性为lang的值，也就是商品的id
            var pid = $(this).parents("tr:first").attr("lang");
            //发送Ajax请求，传输当前的数量与商品的id，返回修改数量后的总价格
            $.post("sorder_updateSorder.action", 
                {number:number, 'product.id':pid},
                function(total){        
                    $("#total").html(total); //所有商品小计
                    var yunfei = $("#yunfei").html();
                    $("#totalAll").html((total*1 + yunfei*1).toFixed(2));//所有商品小计和运费的和
            }, "text");
            //计算单个商品的小计，保留两位小数
            var price = ($(this).parent().prev().html()*number).toFixed(2);
            $(this).parent().next().html(price);
        } else {
            //如果非法，还原为刚刚合法的数
            this.value = $(this).attr("lang");
        }
    })
    
    /*
    $(".remove").click(function(){
    	var par = $(this).parents("tr:first");
    	var pid = par.attr("lang");
    	$.post("sorder_deleteSorder.action",{'product.id':pid},
    			function(total){
    					par.remove();
    					 $("#total").html(total);
    	                 var yunfei = $("#yunfei").html();
    	                 $("#totalAll").html((total*1 + yunfei*1).toFixed(2));
    	}
    	,"text")
    	
    })*/
    
 
    $(".remove").click(function(){
    	var par = $(this).parents("tr:first");
    	var pid = par.attr("lang");
    	$.messager.confirm('确认','你去确认要删除该商品吗？',
    			function(r){
    		if(r){
    	    	$.post("sorder_deleteSorder.action",{'product.id':pid},
    	    			function(total){
    	    					par.remove();
    	    					 $("#total").html(total);
    	    	                 var yunfei = $("#yunfei").html();
    	    	                 $("#totalAll").html((total*1 + yunfei*1).toFixed(2));
    	    	},"text")
    		}
    	})
    })
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
<div id="shopping_cart">
				<div class="message success">我的购物车</div>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="10%">商品编号</th>
						<th class="align_left" width="35%" colspan="2">商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
						<th class="align_center" width="10%">删除</th>
					</tr>
					<c:forEach items="${sessionScope.forder.sorders }" var="sorder" varStatus="num">
					<tr lang="${sorder.product.id}">
						<td class="align_center"><a href="#" class="edit">${num.count }</a>
						</td>
						<td width="80px"><img src="${shop}/files/${sorder.product.pic}" width="80" height="80" />
						</td>
						<td class="align_left"><a class="pr_name" href="#">${sorder.name }</a>
						</td>
						<td class="align_center vline">
							${sorder.price }
						</td>
						<td class="align_center vline">
							<!-- 文本框 -->
							<input class="text" style="height: 20px;" value="${sorder.number }" lang="${sorder.number }">		
						</td>
						<td class="align_center vline">
							${sorder.price*sorder.number }
						</td>
						<td class="align_center vline"><a href="#" class="remove"></a>
						</td>
					</tr>
					</c:forEach>

				</table>
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left"><strong>小计</strong>
								</td>
								<td class="align_right" style=""><strong>￥<span
										class="price" id="total">${sessionScope.forder.total}</span>
								</strong>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left">运费</td>
								<td class="align_right" style="">￥<span class="price" id="yunfei">0.00</span>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td class="align_right" style="">￥<span class="total" id="totalAll"><strong>${sessionScope.forder.total}</strong>
								</span>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="action_buttonbar">
						<font><a href="send_user_confirm.action">
							<button type="button" title="" class="checkout fr" style="background-color: #f38256;">
									订单确认
							</button>
						</a></font>
						<button type="button" title="" class=" fr">
							<font><font>清空购物车</font>
							</font>
						</button>
						<a href="${shop}/index.jsp">
							<button type="button" title="" class="continue fr">
								<font>继续购物</font>
							</button></a>
						<div style="clear:both"></div>
					</div>
				</div>
			</div>
	   <div class="footer_container">
			<%@include file="/public/footer.jspf"%>
       </div>
</div>

</body>
</html>