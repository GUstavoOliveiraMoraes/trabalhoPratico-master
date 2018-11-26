<?php
include_once("config.php");
  $id = NULL;
  $nome=$_POST["nome"];
  $endereco=$_POST["endereco"];
  $cpf=$_POST["cpf"];
  $rg=$_POST["rg"];
  $cnh=$_POST["cnh"];
  $dependentes=$_POST["dependentes"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "INSERT INTO clientes VALUES ";
$sql .= "('$id', '$nome', '$endereco', '$cpf', '$rg', '$cnh', '$dependentes')"; 
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Cliente cadastrado com sucesso!<br>";
echo "<a href='cadastrar-cliente.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='index.html'>Clique aqui para voltar para a Home</a><br>";
?>