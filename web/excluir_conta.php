<?php
include_once("config.php");
  $id = $_GET["id"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "DELETE FROM contas WHERE id=$id";
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Conta excluído com sucesso!<br>";
echo "<a href='cadastrar-conta.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-contas.html'>Clique aqui para Listar as Contas</a><br>";
?>