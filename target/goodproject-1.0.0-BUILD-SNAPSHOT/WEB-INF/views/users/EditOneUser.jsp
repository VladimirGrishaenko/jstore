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
	src="<c:url value="resources/scripts/EditUser.js" />"></script>
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
	
	<div id="pages" >

		<c:url var="firstUrl" value="./editfewuser1" />
		<c:url var="lastUrl" value="./editfewuser${page.totalPages}" />
		<c:url var="prevUrl" value="./editfewuser${currentIndex - 1}" />
		<c:url var="nextUrl" value="./editfewuser${currentIndex + 1}" />
    
        <c:choose>
            <c:when test="${currentIndex == 1}">
               <a href="#"><img src="resources/images/first.png"/></a>
               <a href="#"><img src="resources/images/prev.png"/></a>
            </c:when>
            <c:otherwise>
              <a href="${firstUrl}"><img src="resources/images/first.png"/></a>
              <a href="${prevUrl}"><img src="resources/images/prev.png"/></a>
            </c:otherwise>
        </c:choose>
        
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="./editfewuser${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <a href="${pageUrl}"><c:out value="${i}" /></a>
                </c:when>
                <c:otherwise>
                   <a href="${pageUrl}"><c:out value="${i}" /></a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == page.totalPages}">
                <a href="#"><img src="resources/images/next.png"/></a>
                <a href="#"><img src="resources/images/last.png"/></a>
            </c:when>
            <c:otherwise>
               <a href="${nextUrl}"><img src="resources/images/next.png"/></a>
               <a href="${lastUrl}"><img src="resources/images/last.png"/></a>
            </c:otherwise>
        </c:choose>
            
   </div>
	
	<div class="container">
		
	<br>
				
				
		<form action="EditUser" method="post">
		
			<fieldset>		
			
					<legend>Delete Few or Edit Users</legend>
				<br> <input type="hidden" id="ids" value="${ids}" />
<c:if test="${not empty list}">
 <br><br>
    <center><table id="myTable" class="tablesorter">
        <thead>
            <tr>
       		     <th>Id</th>
            	<th>Name</th>
                <th>Phone</th>
                <th>E-mail</th>
                <th>Role</th>
                <th>UserName</th>
                 <th>Edit</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${list}">
            <tr>
            	<td>${user.id }</td>
            	<td id="name${user.id }">${user.firstName }</td>
              	 <td id="phone${user.id }">${user.phone}</td>
             	 <td id="email${user.id }">${user.email}</td>
               <td id="role${user.id }">${user.role}</td>
               <td id="username${user.id }">${user.userName}</td>
               <td>
										<center>
											<input type="radio" name="Radiobutton" id=${user.id }>
										</center>
									</td>
                
                      </tr>
        </c:forEach>
        </tbody>
    </table></center>
</c:if>
<br><br>						
			</fieldset>

		</form>	
	<fieldset>
<br> <input type="text" id="Editname" name="Editname"
					placeholder="Name" />					
				<input type="text" id="Editphone" name="Editphone" placeholder="phone" />
				<input type="text" id="Editemail" name="Editemail" placeholder="Editemail" /> 		
					<input type="text" id="Editusername" name="Editusername" placeholder="username" />
					 <select  id="Editrole" name="Editrole">
					 	<option>ROLE_ANONYMOUS</option>
					 	<option>ROLE_LOGUSER</option>
					 	<option>ROLE_MANAGER</option> 
					    <option>ROLE_ADMIN</option> 	 					   
					</select>				 
					 	<br> <input type="submit"
					name="Edit" id="EEdit1" value="Edit">
			</fieldset>

		<a href="./products">View all users</a><br> <a href="./">Back
			to main</a>


	
	</div>




	
	</div>
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>