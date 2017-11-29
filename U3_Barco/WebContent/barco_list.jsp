<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="BarcoController">
					<input type="submit" name="btn_new" value = "New"/>
				</form>
			</th>
			 <th>Id</th>
			 <th>Pais</th>
			 <th>Capitan</th>
			 <th>Capacidad</th>
		</tr>
		<c:forEach var="barco" items="${barcos}">
			<tr>
				<td>
					<form action= "BarcoController">
					<input type = "hidden" name = "id" value= "${barco.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
				</td>
			<td> ${barco.id}</td>
			<td> ${barco.pais}</td>
			<td> ${barco.capitan}</td>
			<td> ${barco.capacidad}</td>
			</tr>
			</c:forEach>
	</table>
	
	<form action="BarcoReport">
				
					<input type = "submit" name = "btn_reporte" value = "Generar reporte"/>
				</form>
</body>
</html>