<?php
	include_once("conexao.php"); //conexão com o banco de dados
	$id = $_POST['id'];
	$nome=$_POST["nome"];
    $endereco=$_POST["endereco"];
    $cpf=$_POST["cpf"];
    $rg=$_POST["rg"];
    $dataadmissao=$_POST["dataadmissao"];
    $datademissao=$_POST["datademissao"];

	
	$result_usuario = "UPDATE funcionarios SET nome = '$nome', endereco = '$endereco', cpf = '$cpf', rg = '$rg', dataadmissao = '$dataadmissao', datademissao = '$datademissao' WHERE id = '$id'";
	$resultado_usuario = mysqli_query($conn, $result_usuario);
	
echo "Funcionário editado com sucesso!<br>";
echo "<a href='cadastrar-funcionario.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-funcionario.html'>Clique aqui para Listar os Funcionários</a><br>";
?>