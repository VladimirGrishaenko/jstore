<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
</html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
	<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery.tablesorter.js" />"></script>
<link href="<c:url value="/resources/css/tramps.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript"	
	src="<c:url value="resources/scripts/AddUser.js" />"></script>
<title>Shop</title>
</head>
<div id="container">
	<c:import url="/WEB-INF/views/header.jsp" />
	
		<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Редактирование пользователей</h2>
			</div>
			<ul>						
					<li><h5><a href="./infouser1">Все пользователи</a></h5></li>	
					<li><h5><a href="./adduser">Добавить ползователей</a></h5></li>
					<li><h5><a href="./editfewuser1">Редактировать пользователей</a></h5></li>		
					<li class="last"><h5><a href="./edituser1">Удалить Пользователей</a></h5></li>
			</ul> 
			<div class="clearthis">&nbsp;</div>
		</div>
		<!-- End of Categories Box -->
</div>
	
	<!-- End of Left Sidebar -->
	
	<!-- Start of Main Content Area -->
	<div id="main_content1">
	<div class="container">
		<h1>Работа с пользователями</h1>
	<br>
				 <fieldset> 
				<legend>Добавить пользователя</legend>
					<br><br>
										
					<input type="text" id="name" name="name" placeholder="Name" /> 
					<input type="text" id="phone" name="phone" placeholder="phone" /> 
					<input type="text" id="email" name="email" placeholder="email" /> 				
					<input type="text" id="username" name="username" placeholder="username" /> 
					<select id="role" name="role">
					 	<option>ROLE_ANONYMOUS</option>
					 	<option>ROLE_LOGUSER</option>
					 	<option>ROLE_MANAGER</option> 
					    <option>ROLE_ADMIN</option> 	 					   
					</select>								
					<input type="submit" name="Add" 
					id="add" value="Add"><br>
					<br><br>
			</fieldset> 
	
		<br><br><br>
		
		
		
		
	



	
	</div>




	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>