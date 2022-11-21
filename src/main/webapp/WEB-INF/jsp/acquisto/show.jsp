<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	
	   <title>Visualizza Elemento</title>
	   
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Id:</dt>
							  <dd class="col-sm-9">${show_acquisto_attr.id}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Descrizione Acquisto:</dt>
							  <dd class="col-sm-9">${show_acquisto_attr.descrizione}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">${show_acquisto_attr.prezzo}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data Acquisto:</dt>
							  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_acquisto_attr.data}" /></dd>
					    	</dl>
					    	
					    	
					    <!-- end card body -->
					    </div>
					    
					    <div class='card-footer'>
					        <a href="${pageContext.request.contextPath }/acquisto/list" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					        
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>