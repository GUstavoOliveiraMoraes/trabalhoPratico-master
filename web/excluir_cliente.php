<?php
include_once("config.php");
  $id = $_GET["id"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "DELETE FROM clientes WHERE id=$id";
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Cliente excluído com sucesso!<br>";
echo "<a href='cadastrar-cliente.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-clientes.html'>Clique aqui para Listar os Clientes</a><br>";
?>