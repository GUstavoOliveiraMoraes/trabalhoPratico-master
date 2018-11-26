<?php
	$id = $_POST['id'];
	$placa=$_POST["placa"];
    $nome=$_POST["nome"];
    $marca=$_POST["marca"];
    $modelo=$_POST["modelo"];
    $valorSeguro=$_POST["valorSeguro"];
    $valorLocacao=$_POST["valorLocacao"];
    $cor=$_POST["cor"];
    $dataLocacao=$_POST["dataLocacao"];
    $dataDevolucao=$_POST["dataDevolucao"];
    $quilometragem=$_POST["quilometragem"];

    //banco de dados
	$servidor = "localhost";
	$usuario = "root";
	$senha = "";
	$dbname = "db";
	
	//Criar a conexao
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
		
	$result_usuario = "UPDATE locacao SET placa = '$placa', nome = '$nome', marca = '$marca', modelo = '$modelo', valorSeguro = '$valorSeguro', valorLocacao = '$valorLocacao', cor = '$cor', dataLocacao = '$dataLocacao', dataDevolucao = '$dataDevolucao', quilometragem = '$quilometragem' WHERE id = '$id'";
	$resultado_usuario = mysqli_query($conn, $result_usuario);
	
echo "Locação editada com sucesso!<br>";
echo "<a href='cadastrar-locacao.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-locacao.html'>Clique aqui para Listar as Locacao</a><br>";
?>