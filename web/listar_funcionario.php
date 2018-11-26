<?php
include_once "conexao.php";

//consultar no banco de dados
$result_usuario = "SELECT * FROM funcionarios ORDER BY id ASC";
$resultado_usuario = mysqli_query($conn, $result_usuario);


//Verificar se encontrou resultado na tabela "usuarios"
if(($resultado_usuario) AND ($resultado_usuario->num_rows != 0)){
	?>
	<table class="table table-bordered" id="conteudo" width="100%" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>CPF</th>
				<th>RG</th>
				<th>Data de Admissão</th>
				<th>Data de Demissão</th>
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
					<th><?php echo $row_usuario['endereco']; ?></th>
					<th><?php echo $row_usuario['cpf']; ?></th>
					<td><?php echo $row_usuario['rg']; ?></td>
					<td><?php echo $row_usuario['dataadmissao']; ?></td>
					<td><?php echo $row_usuario['datademissao']; ?></td>
					<td><a href="editar_funcionario.php?id=<?php echo $row_usuario['id']; ?>"><i class="far fa-edit"></i> <a href="excluir_funcionario.php?id=<?php echo $row_usuario['id']; ?>"><i class="fas fa-times"></i></a></td>
				</tr>
				<?php
			}?>
		</tbody>
	</table>
<?php
}else{
	echo "<div class='alert alert-danger' role='alert'>Nenhum usuário encontrado!</div>";
}