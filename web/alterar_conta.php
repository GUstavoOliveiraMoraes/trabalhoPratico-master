<?php
	$id = $_POST['id'];
    $valor=$_POST["valor"];
    $dataVencimento=$_POST["dataVencimento"];
    $dataPagamento=$_POST["dataPagamento"];
    $observacao=$_POST["observacao"];
    $status=$_POST["status"];

    //banco de dados
	$servidor = "localhost";
	$usuario = "root";
	$senha = "";
	$dbname = "db";
	
	//Criar a conexao
	$conn = mysqli_connect($servidor, $usuario, $senha, $dbname);
	
	//$nome_usuario = "Kelly";
	
	$result_usuario = "UPDATE contas SET valor = '$valor', dataVencimento = '$dataVencimento', dataPagamento = '$dataPagamento', observacao = '$observacao', status = '$status' WHERE id = '$id'";
	$resultado_usuario = mysqli_query($conn, $result_usuario);
	
echo "Conta editada com sucesso!<br>";
echo "<a href='cadastrar-conta.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-contas.html'>Clique aqui para Listar os Automóveis</a><br>";
?>