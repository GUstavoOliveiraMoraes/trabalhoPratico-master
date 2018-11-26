<?php
include_once("config.php");
  $id = $_GET["id"];
if (!$strcon) {
 die('Não foi possível conectar ao Banco de Dados');
}
$sql = "DELETE FROM locacao WHERE id=$id";
mysqli_query($strcon,$sql) or die("Erro ao tentar cadastrar registro");
mysqli_close($strcon);
echo "Locação excluído com sucesso!<br>";
echo "<a href='cadastrar-locacao.html'>Clique aqui para realizar um novo cadastro</a><br>";
echo "<a href='listar-locacao.html'>Clique aqui para Listar as Locação</a><br>";
?>