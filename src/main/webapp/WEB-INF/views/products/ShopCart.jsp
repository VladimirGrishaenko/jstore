<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
</html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
	<%-- <script type="text/javascript"
	src="<c:url value="resources/scripts/ControlUser.js" />"></script> --%>	
	<script type="text/javascript"
	src="<c:url value="resources/scripts/cookie.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
	
	<script type="text/javascript"
	src="<c:url value="resources/scripts/DeleteOrderItem.js" />"></script>


	<link href="<c:url value="/resources/css/tramps.css" />"
	rel="stylesheet" type="text/css" media="screen" />
	
<title>Shop</title>
</head>

<div id="container">
	<!-- Start of Page Header -->
		<c:import url="/WEB-INF/views/header.jsp" />
			<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Список товаров</h2>
			</div>
			<ul>
			
						<li class="last"><h5><a href="./?lt=0&n=productName&s=asc">Весь список</a></h5></li>	
		
			</ul> 
			<div class="clearthis">&nbsp;</div>
	</div>
	</div>
	<div id="main_content2">
    	<div class="container">	
 	<h1>Введите контактную информацию</h1>
			 <fieldset > 					
					Имя* <input type="text" name="name"  id="name" placeholder="Name"/> 
					Телефон* <input type="text" name="phone" id="phone"  placeholder="phone"/> 
					E-mail <input type="text" name="email" id="email"  placeholder="email"/> 				
 					
			</fieldset> 
			<br>
			

  	 <table class="normal-table" id="normtable">
        <thead>
            <tr>
            	<th>Название продукта</th>
            	<th>Цена</th>
            	<th>Количество</th>
            	<th>Удалить продукт c корзины</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="prod" items="${products}">
        <input type="hidden" name="prod_id" value="${prod.product.id}"/>
            <tr id="tr${prod.product.id}" name="ProductTR">         
            	
            	<td ><input disabled type="text" name="prod_name" value="${prod.product.productName}"/></td>
            	<td><input disabled type="text" name="prod_price" value="${prod.product.price}"/></td>
            	<td><input type="text" name="prod_q" value="${prod.quantity}"/></td>
            	<td> <input type="submit" name="Delete" id="${prod.product.id}" value="Удалить"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
	
	</div>
      
    
 <script>
       function sendRequest(){ 
    	   var url="compliteorder";
    	   var quant=document.getElementsByName('prod_q');
    	   var p_id=document.getElementsByName('prod_id');
    	   
    	   var s="";
     	  for ( var i = 0; i < quant.length; i++) {
   			s=s+quant[i].value+"-"+p_id[i].value+",";
   			}
    	   url=url+"?name="+document.getElementsByName('name')[0].value+"&"+"phone="+document.getElementsByName('phone')[0].value+"&"+"email="+document.getElementsByName('email')[0].value+"&"+"quant="+s;
    	   location.href=url;
       }
       
       function sendT(){

       }
 </script>   
 
 <script>
 
 </script>
      <div id="makeorder">
     <a href="#" id="action"  >Оформить Заказ</a> 
		</div>
 <c:if test="${empty products}">
  <h1>Корзина пуста</h1>
<script type="text/javascript">
$('#makeorder').hide();
$('#normtable').hide();

</script>
<a href="./">На главную</a>
</c:if>



	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>

