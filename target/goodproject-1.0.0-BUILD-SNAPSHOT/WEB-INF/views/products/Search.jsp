<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
</html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value="resources/scripts/ControlProduct.js" />"></script>	
	<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
<title>Shop</title>
</head>
<div id="container">
	<!-- Start of Page Header -->
	<c:import url="/WEB-INF/views/header.jsp" />
	<!-- End of Page Header -->

	<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Список товаров</h2>
			</div>
			<ul>
				<c:forEach var="type" items="${productTypes}">			
						<li><h5><a href="./?lt=${type.getId()}&${link}">${type.productType}</a></h5></li>	
							</c:forEach>
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->

	</div>
	<!-- End of Left Sidebar -->
	<!-- Start of Main Content Area -->
	<div id="main_content">
	
	<c:if test="${empty products}">
	 <h1>Товаров не найдено</h1>
	</c:if>
	<c:forEach var="prod" items="${products}">			
			<div id="new_item">
				<div id="new_item_header">
					<h1>${prod.productName}</h1>

				</div>
				<div id="new_item_image">
					<img src="${prod.imageLink}" height="150" alt="New Item Name" />
				</div>
				<div class="price">
					<h2>${prod.price}</h2>
				</div>
  <div id="new_item_link">  
		<!--  		    <div id="new_item_link">  <a href="<c:url value="/shopcart/add">
    			<c:param name="prod_id" value="${prod.id}"/>         
           </c:url>">Добавить в корзину</a>              
           </div>   -->	
           <input type="submit"
					name="Add" id="${prod.id}" value="Добавить в корзину">
          </div> 
           
           
                   
			 <div align ="right">
				 <br><br><br><br><a href="param?id=${prod.id}">Подробнее...</a>
			 </div>
			</div>
		</c:forEach>
		<!-- End of Sub Item Descriptions --> 

	
	
	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>