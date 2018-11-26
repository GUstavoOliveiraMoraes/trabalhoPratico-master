<?php
  include_once("conexao.php");
  $id = $_GET['id'];
  $result_usuario = "SELECT * FROM automoveis WHERE id='$id'";
  $resultado_usuario = mysqli_query($conn, $result_usuario);
  $row_usuario = mysqli_fetch_assoc($resultado_usuario);
?>

<!DOCTYPE html>
<html lang="pt-br">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Editar Automóvel - LocaPlus</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
    <script type="text/javascript" src="js/jquery.maskedinput-1.1.4.pack.js"/></script>
    <script type="text/javascript">
       $(document).ready(function($){
       $("#placa").mask("aaa-9999");
  });
</script>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/jquery.maskMoney.js" type="text/javascript"></script>

    <script type="text/javascript">
    $(function($){
      $("#valorSeguro").maskMoney({symbol:'R$ ', 
          showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
    })
    </script>
    <script type="text/javascript">
    $(function($){
      $("#valorLocacao").maskMoney({symbol:'R$ ', 
          showSymbol:true, thousands:'.', decimal:',', symbolStay: true});
    })
    </script>


  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html">Administração</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bell fa-fw"></i>
            <span class="badge badge-danger">9+</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger">7</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

<!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-car"></i>
            <span>Automóveis</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="listar-automovel.html">Listar</a>
            <a class="dropdown-item" href="cadastrar-automovel.html">Cadastrar</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-list-ul"></i>
            <span>Locação</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="listar-locacao.html">Listar</a>
            <a class="dropdown-item" href="cadastrar-locacao.html">Cadastrar</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="far fa-user"></i>
            <span>Clientes</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="listar-clientes.html">Listar</a>
            <a class="dropdown-item" href="cadastrar-cliente.html">Cadastrar</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="far fa-address-card"></i>
            <span>Funcionários</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="listar-funcionario.html">Listar</a>
            <a class="dropdown-item" href="cadastrar-funcionario.html">Cadastrar</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-rocket"></i>
            <span>Inovação</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <a class="dropdown-item" href="cadastrar-conta.html">Cadastrar Conta</a>
            <a class="dropdown-item" href="listar-contas.html">Listar Contas a Pagar</a>
          </div>
        </li>
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Editar Automóvel</li>
          </ol>
              <form name="form" data-toggle="validator" role="form" method="POST" action="alterar_automovel.php">
                 <div class="form-group">
                    <label for="id">ID</label>
                    <input type="text" readonly="readonly" class="form-control" id="id" aria-describedby="emailHelp" name="id" data-error="Por favor, informe uma placa correta." required value="<?php echo $row_usuario['id']; ?>">                   
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="placa">Placa</label>
                    <input type="text" class="form-control" id="placa" aria-describedby="emailHelp" name="placa" data-error="Por favor, informe uma placa correta." required value="<?php echo $row_usuario['placa']; ?>">                   
                    <div class="help-block with-errors"></div>
                  </div>
                      <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" aria-describedby="emailHelp" name="nome" placeholder="Digite o nome do carro" data-error="Por favor, informe um nome correto." required value="<?php echo $row_usuario['nome']; ?>">                 
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputMarca">Marca</label>
                    <input type="text" class="form-control" id="marca" aria-describedby="emailHelp" name="marca" placeholder="Digite a marca do carro" data-error="Por favor, informe uma marca correta." required value="<?php echo $row_usuario['marca']; ?>">                   
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="modelo">Modelo</label>
                    <input type="text" class="form-control" id="modelo" aria-describedby="emailHelp" name="modelo" placeholder="Digite o modelo do carro" data-error="Por favor, informe um modelo correto." required value="<?php echo $row_usuario['modelo']; ?>">                    
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="valorSeguro">Valor do Seguro</label>
                    <input type="text" class="form-control" id="valorSeguro" aria-describedby="emailHelp" name="valorSeguro" placeholder="Digite o valor do seguro do carro" data-error="Por favor, informe o valor do seguro" required value="<?php echo $row_usuario['valorSeguro']; ?>">
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="valorLocacao">Valor da Locação</label>
                    <input type="text" class="form-control" id="valorLocacao" aria-describedby="emailHelp" name="valorLocacao" placeholder="Digite o valor da locação do carro" data-error="Por favor, informe o valor da locação" required value="<?php echo $row_usuario['valorLocacao']; ?>">
                    <div class="help-block with-errors"></div>
                  </div>
                  <div class="form-group">
                    <label for="cor">Cor</label>
                    <input type="text" class="form-control" id="Cor" aria-describedby="emailHelp" name="cor" placeholder="Digite a cor do carro" data-error="Por favor, informe a cor veículo." required value="<?php echo $row_usuario['cor']; ?>">
                    <div class="help-block with-errors"></div>
                  </div>
                  <center><button type="submit" id="btnCadAutomovel" class="btn btn-primary" name="add_automovel">Salvar</a></button></center>
                </form>


        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © LocaPlus 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/demo/chart-area-demo.js"></script>

    <!-- Script para validar os campos do formulário -->
    <script src="js/validator.min.js"></script>

  </body>

</html>