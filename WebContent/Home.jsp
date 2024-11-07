<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.5/font/bootstrap-icons.min.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<title>Home</title>
</head>
<body>
	<header>
	    <jsp:include page="componentes/navbar-home.jsp"></jsp:include>
	</header>
	<div class="container-fluid p-0">
    <div class="image-container">
        <img src="images/imagen-home.png" class="img-fluid" alt="Banco" />
        <div class="overlay">
            <h2>Bienvenido a BancoNejo</h2>
            <p>
                En BancoNejo, ofrecemos las mejores soluciones financieras para satisfacer tus necesidades. Nuestro compromiso es brindar un servicio de calidad y ayudar a nuestros clientes a alcanzar sus metas.
            </p>
        </div>
    </div>
	</div>
	<jsp:include page="componentes/footer.jsp" />
	
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</body>
</html>