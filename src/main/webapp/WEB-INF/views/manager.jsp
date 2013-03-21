<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/tramps.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery-1.9.1.js" />"></script>
<script type="text/javascript"	
	src="<c:url value="resources/scripts/manager.js" />"></script>
<script type="text/javascript"
	src="<c:url value="resources/scripts/jquery.tablesorter.js" />"></script>
<title>Shop</title>
</head>
<body>
<div id="container">
<c:import url="/WEB-INF/views/header.jsp" />
<!-- Start of Left Sidebar -->
	<div id="left_sidebar">
		<div id="categories">
			<div id="categories_header">
				<h2>Страница менеджера</h2>
			</div>
		</div>
		<!-- End of Categories Box -->
</div>
	
	<!-- End of Left Sidebar -->
<div id="main_content">

	<c:if test="${not empty orders}">
 
    <center><table id="myTable" class="tablesorter">
        <thead>
            <tr>
            	<th>Order number</th>
                <th>Customer name</th>
                <th>Customer E-mail</th>
                <th>Order items</th>
                <th>Number order items</th>
                <th>Order status</th>
            </tr>
        </thead>
        <tbody>
        	 <c:forEach var="order" items="${orders}">        	 
            <tr>
            	<td>
            	<div id="idOrder${order.id}" name="idOrder">${order.id}</div>
            	</td>
                <td>${order.user.firstName}</td>
                <td>${order.user.email}</td>
                <td>
                <c:forEach var="orderItem" items="${order.orderItem}">
                ${orderItem.product.productName}                
                <br/>
                </c:forEach>                  
                </td>
                <td>                
                <c:forEach var="orderItem" items="${order.orderItem}">
                ${orderItem.quantity}                
                <br/>
                </c:forEach> 
                </td>
                <td>
                <select id="status${order.id}" name="status" onchange="editStatus(${order.id});">
					 	<option
					 	<c:if test="${order.orderStatus == 'DELIVERED'}">
					 	selected
						</c:if>				 	
					 	 value="DELIVERED">DELIVERED</option>
					 	 
					 	<option 
					 	<c:if test="${order.orderStatus == 'PROCESSED'}">
					 	selected
						</c:if>
						value="PROCESSED">PROCESSED</option>
						
					 	<option 
					 	<c:if test="${order.orderStatus == 'CANCELED'}">
					 	selected
						</c:if>
					 	value="CANCELED">CANCELED</option> 
				</select>
				</td>                
           </tr>
		</c:forEach>
        </tbody>
    </table></center>
</c:if>

</div>
<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>