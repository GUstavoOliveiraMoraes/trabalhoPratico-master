<?php
include_once("config.php");
  $id = NULL;
  $placa=$_POST["placa"];
  $nome=$_POST["nome"];
  $marca=$_POST["marca"];
  $modelo=$_POST["modelo"];
  $valorSeguro=$_POST["valorSeguro"];
  $valorLocacao=$_POST["valorLocacao"];
  $cor=$_POST["cor"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "INSERT INTO automoveis VALUES ";
$sql .= "('$id', '$placa', '$nome', '$marca', '$modelo', '$valorSeguro', '$valorLocacao', '$cor')"; 
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Automóvel cadastrado com sucesso!<br>";
echo "<a href='cadastrar-automovel.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='index.html'>Clique aqui para voltar para a Home</a><br>";
?>