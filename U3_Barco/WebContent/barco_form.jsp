<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="BarcoController">
		<label>Pais:</label><br>
		<input type="text" name="pais" value="${barco.pais}"><br>
		
		<label>Capitan:</label><br>
		<input type="text" name="capitan" value="${barco.capitan}"><br>
		
		<label>Capacidad:</label><br>
		<input type="number" name="capacidad" value="${barco.capacidad}"><br>
		
		<input type="submit" name="btn_save" id="btn_save" value="Save">
	</form>
</body>
</html>