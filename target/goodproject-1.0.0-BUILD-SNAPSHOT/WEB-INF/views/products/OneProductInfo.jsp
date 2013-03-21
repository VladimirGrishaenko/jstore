<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
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
	<script type="text/javascript"
	src="<c:url value="resources/scripts/ControlProduct.js" />"></script>	
<title>Shop</title>
</head>
<div id="container">
		<c:import url="/WEB-INF/views/header.jsp" />
	<!-- End of Page Header -->

	<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Список товаров</h2>
			</div>
			<ul>
				<c:forEach var="type" items="${types}">			
						<li><h5><a href="./?lt=${type.getId()}&n=productName&s=asc">${type.productType}</a></h5></li>	
							</c:forEach>
						<li class="last"><h5><a href="./?lt=0&n=productName&s=asc">Весь список</a></h5></li>
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->

	</div>
	<!-- End of Left Sidebar -->
	<!-- Start of Main Content Area -->
	<div id="main_content">
				<div id="info_item">
        <div id="info_item_header">
          <h1>${product.productName}</h1>
	  
        </div>
        <div id="info_item_image"> <img src="${product.imageLink}"  height="180" alt="New Item Name" /> </div>
        <div id="info_item_text">
          <p>${product.description}<br>
          <input type="submit"
					name="Add" id="${product.id}" value="Добавить в корзину">
					</p>
        </div>
        
       <div id="price_info">
          <h2>${product.price}</h2>
        </div>
        <div id="info_button">
        
		</div>
        <div class="clearthis">&nbsp;</div>
      </div>
		</div>
		<!-- End of Main Content Area --> 
		<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>