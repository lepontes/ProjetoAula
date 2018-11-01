<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ControladorAluno" method="post">
 <p>Primeiro nome: <input type="text" name="pnome" placeholder="Primeiro Nome"></p><br></br>
 <p>Ultimo nome: <input type="text" name="unome" placeholder="Ultimo Nome"></p><br></br>
 <p>Email: <input type="text" name="email" placeholder="Email"></p><br></br>
 <input type="submit" name="cadastrar" value="Cadastrar">
 <input type="hidden" name="acao" value="cadastrar">
</form>

</body>
</html>