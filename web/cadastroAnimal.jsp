<%@page import="entidades.Usuario"%>
<%@page import="controles.AnimalDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entidades.Animal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    AnimalDAO animalDAO = new AnimalDAO();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuário</title>
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

        <div class="container-fluid">
            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modalAnimal">Adicionar</button>
            <h2>Cadastro de Animal</h2>

            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Espécie</th>
                        <th>Raça</th>
                    </tr>
                </thead>

                <tbody>
                    <% ResultSet rset = animalDAO.resultAnimal(); %>
                    <% while (rset.next()) {%>
                    <tr>
                        <td><%= rset.getInt("idanimal")%></td>
                        <td><%= rset.getString("nome")%></td>
                        <td><%= rset.getString("especie")%></td>
                        <td><%= rset.getString("raca")%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <form class="form-horizontal" action="CadastroAnimal" method="POST">
            <div class="modal fade" id="modalAnimal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Adicionar Animal</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="Nome" class="col-sm-2 control-label">Nome: </label>
                                <div class="col-sm-10">

                                    <input type="text" class="form-control" id="nome" name="nome" size="30" placeholder="">

                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Especie" class="col-sm-2 control-label">Espécie: </label>
                                <div class="col-sm-10">

                                    <input type="text" class="form-control" id="especie" name="especie" size="20" placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Raca" class="col-sm-2 control-label">Raça: </label>
                                <div class="col-sm-10">

                                    <input type="text" class="form-control" id="raca" name="raca" size="20" placeholder="">
                                </div>
                            </div>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Salvar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

    </body>
</html>
