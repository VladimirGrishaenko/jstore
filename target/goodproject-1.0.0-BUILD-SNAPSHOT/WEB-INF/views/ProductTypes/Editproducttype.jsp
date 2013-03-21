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
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery.tablesorter.js" />"></script>
<link href="<c:url value="/resources/css/tramps.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value="resources/scripts/Control.js" />"></script>
<title>Shop</title>
</head>
<div id="container">
	<c:import url="/WEB-INF/views/header.jsp" />
	
		<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Редактирование категорий товаров</h2>
			</div>
			<ul>
						
					<li><h5><a href="./editproduct">Добавить товар</a></h5></li>	
						<li><h5><a href="./deleteProduct">Удалить товар</a></h5></li>	
						<li><h5><a href="./addProduct">Изменить товар</a></h5></li>	
						<li><h5><a href="./editpicture">Изменить картинку</a></h5></li>	
						<li><h5><a href="./editproducttype">Добавить категорию товара</a></h5></li>	
						<li class="last"><h5><a href="./infoproducttype">Типы продуктов</a></h5></li>
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->
</div>
	
	<!-- End of Left Sidebar -->
	
	<!-- Start of Main Content Area -->
	<div id="main_content1">
	<div class="container">
	
	<form action="AddProductType" method="post">
			 <fieldset> 
			 <br>
				<legend>Добавление категории товаров </legend>
					
					<input type="text" name="productType" placeholder="productType" /> 
					<input type="submit" value="AddProductType">
					<br>
					<br>
			</fieldset> 
		</form>
		<br>
		<form action="DeleteProductType" method="post">
			<fieldset>
			<br>
				<legend>Удалить категорию товаров по имени</legend>
				<input type="text" name="productType" placeholder="productType" />
				 <input	type="submit" value="DeleteType">
				 <br><br>
			</fieldset>
		</form>
	
	
	
	</div>




	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>