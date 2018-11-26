<?php
include_once("config.php");
  $id = NULL;
  $valor=$_POST["valor"];
  $dataVencimento=$_POST["dataVencimento"];
  $dataPagamento=$_POST["dataPagamento"];
  $observacao=$_POST["observacao"];
  $status=$_POST["status"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "INSERT INTO contas VALUES ";
$sql .= "('$id', '$valor', '$dataVencimento', '$dataPagamento', '$observacao', '$status')"; 
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Cliente cadastrado com sucesso!<br>";
echo "<a href='cadastrar-conta.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-contas'>Clique aqui para Listar as Contas</a><br>";
?>