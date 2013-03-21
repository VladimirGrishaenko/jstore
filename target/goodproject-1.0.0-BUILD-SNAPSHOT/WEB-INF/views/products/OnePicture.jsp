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
				<h2>Редактирование товаров</h2>
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
	<div id="main_content">
				<div id="info_item">        
        <div id="info_item_image"> <img src="${product.imageLink}"  height="150" alt="New Item Name" /> </div>
       	<br>
		
			 <h1>Загрузить новую картинку</h1>
			 	<br>
   				 <c:if test="${not empty originalFileName}">
     				 <h2>Uploaded file's name is: <c:out value="${originalFileName}" /></h2>
   				 </c:if>
		 		   <div>
		      <form action="form" method="post" enctype="multipart/form-data">
		        <div>
		          <input type="file" name="file" />
		          <input type="hidden" name="idpicture" value=${product.id} />
		        </div>
		        <div>
		          <input type="submit" value="Upload" />
		        </div>
		      </form>
		    </div>
		
        
     
        <div class="clearthis">&nbsp;</div>
      </div>
		</div>
		<!-- End of Main Content Area --> 
		<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>