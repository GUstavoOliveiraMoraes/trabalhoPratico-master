<?php
	$id = $_POST['id'];
	$nome=$_POST["nome"];
    $endereco=$_POST["endereco"];
    $cpf=$_POST["cpf"];
    $rg=$_POST["rg"];
    $cnh=$_POST["cnh"];
    $dependentes=$_POST["dependentes"];

    //banco de dados
	$servidor = "localhost";
	$usuario = "root";
	$senha = "";
	$dbname = "db";
	
	//Criar a conexao
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
	
	//$nome_usuario = "Kelly";
	
	$result_usuario = "UPDATE clientes SET nome = '$nome', endereco = '$endereco', cpf = '$cpf', rg = '$rg', cnh = '$cnh', dependentes = '$dependentes' WHERE id = '$id'";
	$resultado_usuario = mysqli_query($conn, $result_usuario);
	
echo "Cliente editado com sucesso!<br>";
echo "<a href='cadastrar-cliente.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-clientes.html'>Clique aqui para Listar os Clientes</a><br>";
?>