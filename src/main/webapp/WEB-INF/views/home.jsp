<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
</html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
		<nav id="colorNav">
	<ul>
		<li class="blue">
		
			<a href="#" class="icon-home">Сортировка</a>
			<ul>
				<li><a href="./?n=price&s=asc${ltype}${price}">От дешевых к дорогим</a> </li>
				<li><a href="./?n=price&s=desc${ltype}${price}">От дорогих к дешевым </a> </li>
				<li><a href="./?n=productName&s=asc${ltype}${price}">В алфавитном порядке</a> </li>
				<li><a href="./?n=productName&s=desc${ltype}${price}">В порядке обратном алфавитному </a>  </li>
			
			</ul>
		</li>

		

	</ul>
	</nav>

	</div>
	<!-- End of Left Sidebar -->
	<!-- Start of Main Content Area -->
	<div id="main_content">
	<div id="filter">
	
	
			
			<a href="./?${link}${ltype}" id="linkprice">По Цене: </a>  от <input type="text" id="less"> до <input type="text" id="more"> 
			<button id="linkprice_sort">Найти</button>
	</div>
	
	
	<div id="pages" >

	
	

	<c:url var="firstUrl" value="/1?${link}${ltype}${price}" />
<c:url var="lastUrl" value="/${page.totalPages}?${link}${ltype}${price}" />
<c:url var="prevUrl" value="/${currentIndex - 1}?${link}${ltype}${price}" />
<c:url var="nextUrl" value="/${currentIndex + 1}?${link}${ltype}${price}" />


    
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
            <c:url var="pageUrl" value="/${i}?${link}${ltype}${price}" />
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

    <c:forEach var="prod" items="${list}">			
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
           
           <div align ="right">
				 <br><a href="param?id=${prod.id}">Подробнее...</a>
			 </div>
			 </br>
           <input type="submit"
					name="Add" id="${prod.id}" value="Добавить в корзину">
          </div> 
                
			</div>
		</c:forEach>

	
 <c:if test="${empty list}">
  <h1>Товаров не найдено</h1>
<script type="text/javascript">
$('#pages').hide();


</script>
  
  
 </c:if>
	
	
	
	
	
	
	
	
	
	
	
		<!-- End of Sub Item Descriptions --> 
		

	
	
	
	</div>
	
	<!-- End of Main Content Area -->
	<c:import url="/WEB-INF/views/footer.jsp" />
</div>
</body>
</html>