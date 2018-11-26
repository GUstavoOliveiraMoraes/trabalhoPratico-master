<?php
include_once("config.php");
  $id = NULL;
  $nome=$_POST["nome"];
  $endereco=$_POST["endereco"];
  $cpf=$_POST["cpf"];
  $rg=$_POST["rg"];
  $dataadmissao=$_POST["dataadmissao"];
  $datademissao=$_POST["datademissao"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "INSERT INTO funcionarios VALUES ";
$sql .= "('$id', '$nome', '$endereco', '$cpf', '$rg', '$dataadmissao', '$datademissao')"; 
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Funcionário cadastrado com sucesso!<br>";
echo "<a href='cadastrar-funcionario.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='add_automovel.php'>Clique aqui para realizar uma consulta</a><br>";
?>