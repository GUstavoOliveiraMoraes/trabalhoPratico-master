<?php
include_once "conexao.php";

//consultar no banco de dados
$result_usuario = "SELECT * FROM clientes ORDER BY id ASC";
$resultado_usuario = mysqli_query($conn, $result_usuario);


//Verificar se encontrou resultado na tabela "usuarios"
if(($resultado_usuario) AND ($resultado_usuario->num_rows != 0)){
	?>
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endereco</th>
				<th>CPF</th>
				<th>RG</th>
				<th>CNH</th>
				<th>Dependentes</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<?php
			while($row_usuario = mysqli_fetch_assoc($resultado_usuario)){
				?>
				<tr>
					<th><?php echo $row_usuario['id']; ?></th>
					<th><?php echo $row_usuario['nome']; ?></th>
					<td><?php echo $row_usuario['endereco']; ?></td>
					<td><?php echo $row_usuario['cpf']; ?></td>
					<td><?php echo $row_usuario['rg']; ?></td>
					<td><?php echo $row_usuario['cnh']; ?></td>
					<td><?php echo $row_usuario['dependentes']; ?></td>
					<td><a href="editar_cliente.php?id=<?php echo $row_usuario['id']; ?>"><i class="far fa-edit"></i> <a href="excluir_cliente.php?id=<?php echo $row_usuario['id']; ?>"><i class="fas fa-times"></i></a></td>
				</tr>
				<?php
			}?>
		</tbody>
	</table>
<?php
}else{
	echo "<div class='alert alert-danger' role='alert'>Nenhum usuário encontrado!</div>";
}