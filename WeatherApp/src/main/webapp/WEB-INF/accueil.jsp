<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ville = (String) request.getParameter("ville");
	

%>
<!DOCTYPE html>
<html>
<%@ include file="import/head.jsp" %>
<body class="p-5 bg-dark">
	
	<div class="container shadow p-3 mb-5 bg-body rounded">
		<h1 class="mb-3 text-center">Bienvenue sur Pessi App</h1>
	
		<form class="w-75 mx-auto d-flex justify-content-around align-items-end" method="post" action="Accueil">
			<div class="w-75">
			  <input type="texte" class="form-control" id="ville" name="ville" placeholder="Paris">
			</div>
			<button type="submit" class="btn btn-primary">rechercher</button>
		</form>
	
	
	<% if(ville != null) { %>
		<div class="mt-5">
			<div>
				<p>${date}</p>
				<h1>${name}, ${country } (${lon }, ${lat })</h1>
			</div>
			<div id="informations">
				<h2>${celcius} ${C } (${kelvin } ${K })</h2>
				<div>
					<p>ressenti : ${feelsC } ${C } (${feelsK } ${K })</p>
					<p>${main } (${desc })</p>
				</div>
				<div id="presition">
					<p>Speed : ${speed} - Direction : ${direction}</p>
					<p>Humidity : ${humidity} %</p>
				</div>
			</div>
		</div>
		
	<% } %>
	
		
	</div>

	

</body>
</html>