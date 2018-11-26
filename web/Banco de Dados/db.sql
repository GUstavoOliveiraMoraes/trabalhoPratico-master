-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24-Nov-2018 às 01:43
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `automoveis`
--

CREATE TABLE `automoveis` (
  `id` int(11) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `valorSeguro` varchar(25) NOT NULL,
  `valorLocacao` varchar(25) NOT NULL,
  `cor` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `automoveis`
--

INSERT INTO `automoveis` (`id`, `placa`, `nome`, `marca`, `modelo`, `valorSeguro`, `valorLocacao`, `cor`) VALUES
(5, 'ABC-1234', 'Fabio Selau', 'Ford', 'Mustang', 'R$ 8.000,00', 'R$ 1.500,00', 'Branco'),
(19, 'ABC-1221', 'Fabio', 'Ford', 'Mustang', 'R$ 1.500,00', 'R$ 200,00', 'Branco'),
(23, 'abc-6666', 'fabio selau', 'chevrolet', 'camaro', 'R$ 5.000,00', 'R$ 5.000,00', 'Rosa'),
(22, 'abc-6666', 'fabio selau', 'chevrolet', 'camaro', 'R$ 5.000,00', 'R$ 5.000,00', 'Branco');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `rg` int(11) NOT NULL,
  `cnh` int(11) NOT NULL,
  `dependentes` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `endereco`, `cpf`, `rg`, `cnh`, `dependentes`) VALUES
(1, 'Cesar', 'Rua 666', '12333', 500, 600, 4),
(2, 'Frodo', 'Rua 6661', '1233333', 5030, 600, 4),
(3, 'Gustavo', 'Rua 66644', '1233444', 400, 550, 5),
(6, 'Gustavo Viado', 'Rua 666', '2147483647', 212121, 2122121, 5),
(7, 'Teste', 'Teste', '123456789', 1234567, 1234567, 1),
(8, 'Rodrigo Gay', 'Rua 666', '121221', 2121, 212121, 2121),
(9, 'Testesssasa', 'teste 666555', '123.456.789-00', 122121, 212144, 444),
(11, '', '', '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE `contas` (
  `id` int(11) NOT NULL,
  `valor` varchar(25) NOT NULL,
  `dataVencimento` date NOT NULL,
  `dataPagamento` date DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `contas`
--

INSERT INTO `contas` (`id`, `valor`, `dataVencimento`, `dataPagamento`, `observacao`, `status`) VALUES
(1, '555', '1998-04-18', '2018-04-18', 'giovani cunhado', 'Pago'),
(2, '123', '2018-03-12', '4556-03-12', 'pago', 'Pago'),
(3, '250', '2018-11-15', '2018-11-12', 'Pago via boleto', 'Pago'),
(8, 'R$ 5.000,00', '2018-11-20', '2018-11-18', 'Giovani Cunhada', 'Pago');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(220) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` varchar(220) NOT NULL,
  `datadeAdmissao` date NOT NULL,
  `datadeDemissao` date DEFAULT NULL,
  `nivel` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id`, `nome`, `endereco`, `cpf`, `rg`, `datadeAdmissao`, `datadeDemissao`, `nivel`) VALUES
(1, 'Fabio Selau', 'Rua 6666', '1234567890', '123456', '2005-11-08', '2015-10-20', 0),
(2, 'Fabio', 'Rua 666', '1234567890', '123456', '2015-11-08', '2017-10-10', 0),
(4, 'Fabio Gostoso', 'Rua Amael Pompeu Filho', '01580524125', '2148337', '2015-04-18', '2018-04-18', 0),
(5, 'Andrei Viado', 'Rua 666', '1233131', '2121', '2017-04-18', '2018-04-18', 0),
(6, 'fabio', 'rua 666', '1212121', '212121', '1998-04-18', '1998-08-17', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE `locacao` (
  `id` int(11) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `valorSeguro` varchar(25) NOT NULL,
  `valorLocacao` varchar(25) NOT NULL,
  `cor` varchar(30) NOT NULL,
  `dataLocacao` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `quilometragem` int(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `locacao`
--

INSERT INTO `locacao` (`id`, `placa`, `nome`, `marca`, `modelo`, `valorSeguro`, `valorLocacao`, `cor`, `dataLocacao`, `dataDevolucao`, `quilometragem`) VALUES
(1, 'ABC-6666', 'Cesar', 'BMW', 'X1', '500', '800', 'preto', '2018-10-20', '2018-10-30', 100),
(2, 'ABC-6667', 'Fabio', 'BMW', 'X6', '700', '900', 'branco', '2017-10-20', '2018-10-30', 50),
(3, 'ABC-6668', 'Tonhao ViadÃ£o', 'BMW', 'X5', 'R$ 2.500,00', 'R$ 1.000,00', 'prata', '2016-10-20', '2018-10-30', 200),
(9, 'ABC-6666', 'Fernanda Gostosa', 'Ford', 'Mustang', 'R$ 1.500,00', 'R$ 1.500,00', 'Branco', '1998-04-18', '2018-04-18', 195);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(220) NOT NULL,
  `email` varchar(220) NOT NULL,
  `usuario` varchar(220) NOT NULL,
  `senha` varchar(220) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `email`, `usuario`, `senha`) VALUES
(1, 'Cesar', 'cesar@celke.com.br', 'cesar@celke.com.br', '$2y$10$d8Hpwwj/DENEW4sBuUDvUuCw4/2QgEoWvs8YlAXASltHqw5w7vKDm'),
(2, 'Kelly', 'kelly@celke.com.br', 'kelly@celke.com.br', '$2y$10$vbRUBxSLOCK00HsOd4Djxu.6I8JWzqMkhR2UwdMiCKvvB3lq/yD1u'),
(3, 'Jessica', 'jessica@celke.com.br', 'jessica@celke.com.br', '$2y$10$3QR5vemGVmxMXNh68/XdHumXRSpK6UXdl7yK9dmqLfh4QSw.lKMPy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `automoveis`
--
ALTER TABLE `automoveis`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contas`
--
ALTER TABLE `contas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `automoveis`
--
ALTER TABLE `automoveis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `contas`
--
ALTER TABLE `contas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
