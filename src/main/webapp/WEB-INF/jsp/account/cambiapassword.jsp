<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="it">
	<head>
	  <meta charset="utf-8">
		<title>Cambio Password</title>
	
		<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
 		<style>
		    .error_field {
		        color: red; 
		    }
		</style>
	
		 <!-- Custom styles for login -->
	    <link href="${pageContext.request.contextPath}/assets/css/signin.css" rel="stylesheet">
	</head>
	
	<body class="d-flex flex-column h-100" style="background-color:light;">
		
		<main class="flex-shrink-0">
			  <div class="container mb-5">
			  
			  <div class='card w-50' style="margin: auto">
				    <div class='card-header' style="background-color:GreenYellow;">
				        <h5 class="text">Cambia Password</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form:form modelAttribute="changePass_utente_attr" method="post" action="${pageContext.request.contextPath}/account/executeCambiaPassword" novalidate="novalidate" class="row g-3">
								<div class="col-md-12">
									<label for="password" class="form-label">Password <span class="text-danger">*</span></label>
										<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" name="password" id="password" placeholder="Inserire vecchia Password"  required>
									<form:errors  path="password" cssClass="error_field" />
								</div>
								
								<div class="col-md-12">
									<label for="nuovaPassword" class="form-label">Nuova Password <span class="text-danger">*</span></label>
										<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" name="nuovaPassword" id="nuovaPassword" placeholder="Inserire nuova Password"  required>
									<form:errors  path="nuovaPassword" cssClass="error_field" />
								</div>
								
								<div class="col-md-12">
									<label for="confermaNuovaPassword" class="form-label">Conferma Password <span class="text-danger">*</span></label>
										<input type="password" class="form-control ${status.error ? 'is-invalid' : ''}" name="confermaNuovaPassword" id="confermaNuovaPassword" placeholder="Confermare Password"  required>
									<form:errors  path="confermaNuovaPassword" cssClass="error_field" />
								</div>
								
								<div class="col-12">
									<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
									<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
								</div>
						</form:form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
	</body>
</html>