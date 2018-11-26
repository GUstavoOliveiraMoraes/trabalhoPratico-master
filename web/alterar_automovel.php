<?php
	$id = $_POST['id'];
	$placa=$_POST["placa"];
    $nome=$_POST["nome"];
    $marca=$_POST["marca"];
    $modelo=$_POST["modelo"];
    $valorSeguro=$_POST["valorSeguro"];
    $valorLocacao=$_POST["valorLocacao"];
    $cor=$_POST["cor"];

    //banco de dados
	$servidor = "localhost";
	$usuario = "root";
	$senha = "12345678";
	$dbname = "db";
	
	//Criar a conexao
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
	
	//$nome_usuario = "Kelly";
	
	$result_usuario = "UPDATE automoveis SET placa = '$placa', nome = '$nome', marca = '$marca', modelo = '$modelo', valorSeguro = '$valorSeguro', valorLocacao = '$valorLocacao', cor = '$cor' WHERE id = '$id'";
	$resultado_usuario = mysqli_query($conn, $result_usuario);
	
echo "Automóvel editado com sucesso!<br>";
echo "<a href='cadastrar-automovel.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-automovel.html'>Clique aqui para Listar os Automóveis</a><br>";
?>