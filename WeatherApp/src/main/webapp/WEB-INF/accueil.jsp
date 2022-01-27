<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ville = (String) request.getParameter("ville");

%>
<!DOCTYPE html>
<html>
<%@ include file="import/head.jsp" %>
<body class="p-5"">
	
	<div class="container shadow p-5 mt-5 rounded" style="background-color : #ffffff; border:solid 1px #ffce00; color:#281b66">
		<h1 class="mb-5 text-center">Welcome on WeatherApp</h1>
	
		<form class="w-75 mx-auto d-flex justify-content-center align-items-end" method="post" action="Accueil">
			<div class="w-75 me-4">
			  <input type="texte" class="form-control" id="ville" name="ville" placeholder="Search a city...">
			</div>
			<button type="submit" class="btn" style="background:#ffce00">Rechercher</button>
		</form>
	
	
	<% if(ville != null) { %>
		<div class="mt-5 w-50 mx-auto p-3 text-white" style="background: #281b66; border-radius:15px">
			<div class="card-body">
				<div class="mb-4">
					<p class="m-0">${date}</h6>
					<h2 class="m-0" style="color:#ffce00">${name}, ${country }</h2>
				</div>
				<div>
					<div class="d-flex align-items-center m-0 mb-3">
						<img class="m-0 me-2" src="http://openweathermap.org/img/wn/${icon }@2x.png" style="background:white; border-radius:50%; width:70px">
						<h2 class="m-0">${celcius} ${C }</h2>
					</div>
					<p  class="fw-bold m-0">Feels like ${feelsC } ${C }. ${main }. ${desc }</p>
					<div style="border-left: 1px solid #9393ff; padding-left:2ch" class="d-flex">
						<div class="me-5">
							<p class="m-0">Wind speed : ${speed} m/s</p>
							<p class="m-0">Wind direction : ${direction}</p>
							<p class="m-0">Humidity : ${humidity} %</p>
						</div>
						<div>
							<p class="m-0">Coord : ${lon }, ${lat }</p>
							<p class="m-0">Kelvin temperature : ${kelvin } ${K }</p>
							<p class="m-0">Feels like in Kelvin : ${feelsK } ${K }</p>
						</div>
					</div>
				</div>		
			</div>
		</div>
		
	<% } %>
	
		
	</div>

	

</body>
</html>