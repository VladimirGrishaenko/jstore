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
						<li><h5><a href="?lt=${type.getId()}&${link}">${type.productType}</a></h5></li>	
							</c:forEach>
						<li class="last"><h5><a href="?lt=0&${link}">Весь список</a></h5></li>	
		
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->

	</div>
	<!-- End of Left Sidebar -->
	<!-- Start of Main Content Area -->
	<div id="main_content">
				<!-- Start of New Item Description -->
	
			<div class="complite_order">
				<h2>Заказ оформлен!</h2>
				<h2>Номер вашего заказа ${id}</h2>	
				<h3>Просмотреть статус вашего заказа сможете на этой <a href="./Status?id=${id}">странице</a></h3>
<a href="./">На главную</a>		
			
			</div>
			

		<!-- End of Sub Item Descriptions --> 
		</div>
		<!-- End of Main Content Area --> 
		<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>