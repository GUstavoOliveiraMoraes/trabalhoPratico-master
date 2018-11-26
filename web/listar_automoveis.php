<?php
include_once "conexao.php";

//consultar no banco de dados
$result_usuario = "SELECT * FROM automoveis ORDER BY id ASC";
$resultado_usuario = mysqli_query($conn, $result_usuario);


//Verificar se encontrou resultado na tabela "usuarios"
if(($resultado_usuario) AND ($resultado_usuario->num_rows != 0)){
	?>
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Placa</th>
				<th>Nome</th>
				<th>Marca</th>
				<th>Modelo</th>
				<th>Valor Seguro</th>
				<th>Valor Locação</th>
				<th>Cor</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<?php
			while($row_usuario = mysqli_fetch_assoc($resultado_usuario)){
				?>
				<tr>
					<th><?php echo $row_usuario['id']; ?></th>
					<th><?php echo strtoupper($row_usuario['placa']); ?></th>
					<td><?php echo ucfirst($row_usuario['nome']); ?></td>
					<td><?php echo ucfirst($row_usuario['marca']); ?></td>
					<td><?php echo $row_usuario['modelo']; ?></td>
					<td><?php echo $row_usuario['valorSeguro']; ?></td>
					<td><?php echo $row_usuario['valorLocacao']; ?></td>
					<td><?php echo ucfirst($row_usuario['cor']); ?></td>
					<td><a href="editar_automovel.php?id=<?php echo $row_usuario['id']; ?>"><i class="far fa-edit"></i> <a href="excluir_automovel.php?id=<?php echo $row_usuario['id']; ?>"><i class="fas fa-times"></i></a></td>
				</tr>
				<?php
			}?>
		</tbody>
	</table>
<?php
}else{
	echo "<div class='alert alert-danger' role='alert'>Nenhum usuário encontrado!</div>";
}