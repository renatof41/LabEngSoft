<%-- 
    Document   : inicial
    Created on : 13/09/2017, 10:12:39
    Author     : fatec
--%>

<%@page import="entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Entrada</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="inicial.jsp">Projeto Web</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="cadastroUsuario.jsp">Usuários</a></li>
                    <li><a href="cadastroAnimal.jsp">Animais</a></li>
                    <li><a href="cadastroFornecedor.jsp">Fornecedores</a></li>
                    <li><a href="cadastroFuncionario.jsp">Funcionarios</a></li>
                    <li><a href="cadastroProduto.jsp">Produtos</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> &nbsp; <%= user.getNome() %> </a></li>
                    <li><a href="index.html"><span class="glyphicon glyphicon-log-in"></span> Sair </a></li>
                </ul>
            </div>
        </nav>
     </body>
</html>
