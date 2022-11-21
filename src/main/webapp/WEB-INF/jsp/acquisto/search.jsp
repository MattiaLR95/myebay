<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it" class="h-100" >
<head>
	<jsp:include page="../header.jsp" />
	<title>Ricerca</title>
	
    
</head>
<body class="d-flex flex-column h-100">
	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>
	
	<!-- Begin page content -->
	<main class="flex-shrink-0">
	  <div class="container">
	
			<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
			  ${errorMessage}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			
			<div class='card'>
			    <div class='card-header'>
			        <h5>Ricerca elementi</h5> 
			    </div>
			    <div class='card-body'>
	
						<form method="post" action="${pageContext.request.contextPath}/acquisto/list" class="row g-3">
						
							<div class="col-md-6">
								<label for="descrizione" class="form-label">Descrizione:</label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione dell'acquisto" >
							</div>
							
							<div class="col-md-6">
								<label for="prezzo" class="form-label">A partire da:</label>
								<input type="number" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo di partenza" >
							</div>
							
							<div class="col-md-6">
								<label for="data" class="form-label">Data acquisto:</label>
                        		<input class="form-control" id="data" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="data" >
							</div>
							
							<div class="col-12">	
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
							</div>
	
							
						</form>
			    
				<!-- end card-body -->			   
			    </div>
			</div>	
	
		</div>
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>