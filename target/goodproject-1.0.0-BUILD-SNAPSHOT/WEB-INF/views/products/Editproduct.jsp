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
	<div id="main_content1">
	<div class="container">		
					<fieldset>
				<legend>Добавить продукт</legend>
		<br>
				<input type="text" id="name" name="name" placeholder="Name" /> <select
					name="type" id="type">
					<c:forEach var="type"  items="${types}">
						<option>${type.getProductType()}</option>
					</c:forEach>
				</select> <input type="text" id="price" name="price" placeholder="Price" />
				<input type="text" id="quantity" name="quantity"
					placeholder="Quantity" /></br><br> <textarea id="descr" rows="10" cols="45"
					name="descr" placeholder="Description" > </textarea>
					<br>
					<input type="submit"
					id="add" value="Add"><br>
			</fieldset>
			
				<br>
					<fieldset>
			 <h1>Загрузить картинку</h1>
			 	<br>
    <c:if test="${not empty originalFileName}">
      <h2>Uploaded file's name is: <c:out value="${originalFileName}" /></h2>
    </c:if>
    <div>
      <form action="form" method="post" enctype="multipart/form-data">
        <div>
          <input type="file" name="file" />
          <input type="hidden" name="idpicture" value="0" />
        </div>
        <div>
          <input type="submit" value="Upload" />
        </div>
      </form>
    </div>
		</fieldset>
		<br>
		<!-- <form action="AddFromFile" method="post" enctype="multipart/form-data">
			<fieldset>
				<h3>Add Products From File</h3>
				<input type="File" name="File" placeholder="Path To File" /> <input
					type="submit" value="Add From File">
			</fieldset>
		</form> -->
	<!-- 	<br>
		<form action="Delete" method="post">
			<fieldset>
				<h3>Delete Product By Name</h3>
				<input type="text" name="name" placeholder="name" /> <input
					type="submit" value="Delete">
			</fieldset>
		</form>

		<form action="DeleteFew" method="post">
			<fieldset>
				<h3>Delete Few or Edit Products</h3>
				<br> <input type="hidden" id="lastId" value="${lastId}" />

				<c:if test="${not empty products}">

					<table id="myTable" class="tablesorter">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Type</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Description</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<c:forEach var="prod" items="${products}">
								<tr >
									<td name="idColumn" id="${prod.id }">${prod.id }</td>
									<td  id="name${prod.id }">${prod.productName}</td>
									<td id="type${prod.id }">${prod.getProductType().getProductType()}</td>
									<td id="price${prod.id }">${prod.price}</td>
									<td id="quantity${prod.id }">${prod.quantity}</td>
									<td id="descr${prod.id }">${prod.description}</td>
									<td>
										<center>
											<input type="checkbox" name=${prod.id } value=${prod.id }>
										</center>
									</td>
									<td>
										<center>
											<input type="radio" name="Radiobutton" id=${prod.id }>
										</center>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<br> <input type="submit" value="DeleteFew"> <br>
			
			</fieldset>

		</form>
      <fieldset>
      
      <br> <input type="text" id="Editname" name="Editname"
					placeholder="Name" /> <select name="Edittype" id="Edittype">
					<c:forEach var="type" items="${types}">
						<option>${type.getProductType()}</option>
					</c:forEach>
				</select> <input type="text" id="Editprice" name="Editprice" placeholder="Price" />
				<input type="text" id="Editquantity" name="Editquantity"
					placeholder="Quantity" /> </br><br> <textarea id="Editdescr" rows="10" cols="45"
					name="Editdescr" placeholder="Description" > </textarea>
					<br> <input type="submit"
					name="Edit" id="EEdit1" value="Edit">
			</fieldset>

		<a href="./products">View all Products</a><br> <a href="./">Back
			to main</a>   -->
	</div>




	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>