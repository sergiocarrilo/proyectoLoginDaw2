-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-01-2018 a las 17:57:51
-- Versión del servidor: 5.6.37-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `discu351_proyectodaw`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ALUMNOS`
--

CREATE TABLE `ALUMNOS` (
  `ID` int(10) NOT NULL,
  `NOMBRE` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `FECHA_NACIMIENTO` datetime(6) NOT NULL,
  `MAYOR_EDAD` tinyint(4) NOT NULL,
  `FECHA_ENTRADA` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ALUMNOS`
--

INSERT INTO `ALUMNOS` (`ID`, `NOMBRE`, `FECHA_NACIMIENTO`, `MAYOR_EDAD`, `FECHA_ENTRADA`) VALUES
(5, 'Alumno 1', '2018-01-11 00:00:00.000000', 0, '2018-01-11 00:00:00.000000'),
(6, 'Alumno 2', '2018-01-09 00:00:00.000000', 0, '2018-01-11 00:00:00.000000'),
(7, 'alumno 3', '2018-01-02 00:00:00.000000', 0, '2018-01-11 00:00:00.000000'),
(8, 'alumno 4', '2000-12-03 00:00:00.000000', 1, '2018-01-11 00:00:00.000000'),
(9, 'alumno 5', '2018-01-10 00:00:00.000000', 0, '2018-01-11 00:00:00.000000'),
(73, 'AlumnoPrueba', '1996-03-23 00:00:00.000000', 1, '2010-02-02 00:00:00.000000'),
(75, 'AlumnoMiercoles', '1997-03-02 00:00:00.000000', 1, '2008-01-02 00:00:00.000000'),
(77, 'Alumno 10', '2017-11-10 00:00:00.000000', 0, '2018-01-10 00:00:00.000000'),
(78, 'ALUMNO 100', '2018-01-10 00:00:00.000000', 0, '2018-01-10 00:00:00.000000'),
(79, 'Ricardo', '1990-08-23 00:00:00.000000', 1, '2018-01-10 00:00:00.000000'),
(80, 'ricardoAlumn', '1990-08-23 00:00:00.000000', 1, '2018-01-10 00:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ALUMNOS_ASIGNATURAS`
--

CREATE TABLE `ALUMNOS_ASIGNATURAS` (
  `ID_ALUMNOS_ASIGNATURAS` int(11) NOT NULL,
  `ID_ALUMNO` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `ALUMNOS_ASIGNATURAS`
--

INSERT INTO `ALUMNOS_ASIGNATURAS` (`ID_ALUMNOS_ASIGNATURAS`, `ID_ALUMNO`, `ID_ASIGNATURA`) VALUES
(3, 5, 19),
(4, 6, 9),
(5, 5, 17),
(6, 6, 17),
(7, 7, 1),
(8, 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ASIGNATURAS`
--

CREATE TABLE `ASIGNATURAS` (
  `ID` int(10) NOT NULL,
  `NOMBRE` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `ASIGNATURAS`
--

INSERT INTO `ASIGNATURAS` (`ID`, `NOMBRE`) VALUES
(1, 'Servidor UP2'),
(3, 'Ingles'),
(5, '← Æ ♣®η'),
(6, '<script>alert(\"Escapa los scripts - Asignatura\");</script>'),
(7, 'Ingles\'2'),
(8, '\" !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~\"\r\n'),
(9, 'AstroFísica'),
(13, 'Ingles'),
(17, 'Asterisk'),
(19, 'FISICA I'),
(21, 'Servidor UP22'),
(22, 'prueba'),
(23, 'probando2'),
(25, 'lengua'),
(27, '¤§µ¶ÆËØë');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ASIGNATURAS_CURSOS`
--

CREATE TABLE `ASIGNATURAS_CURSOS` (
  `ID` int(10) UNSIGNED ZEROFILL NOT NULL,
  `ID_ASIGNATURA` int(10) NOT NULL,
  `ID_CURSO` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ASIGNATURAS_CURSOS`
--

INSERT INTO `ASIGNATURAS_CURSOS` (`ID`, `ID_ASIGNATURA`, `ID_CURSO`) VALUES
(0000000003, 17, 7),
(0000000004, 6, 5),
(0000000005, 7, 6),
(0000000006, 5, 5),
(0000000007, 1, 6),
(0000000008, 8, 5),
(0000000011, 3, 8),
(0000000021, 17, 6),
(0000000022, 9, 7),
(0000000025, 27, 9),
(0000000026, 25, 5),
(0000000027, 27, 10),
(0000000029, 27, 10),
(0000000030, 27, 10),
(0000000031, 27, 10),
(0000000032, 27, 10),
(0000000033, 27, 10),
(0000000034, 27, 10),
(0000000035, 27, 10),
(0000000037, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CURSOS`
--

CREATE TABLE `CURSOS` (
  `ID` int(10) NOT NULL,
  `CURSO` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CURSOS`
--

INSERT INTO `CURSOS` (`ID`, `CURSO`) VALUES
(5, 'daw 3'),
(6, 'TERCERO'),
(7, 'Novenos'),
(8, '2 ESO'),
(9, 'Octavo'),
(10, 'DAM 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `NOTAS`
--

CREATE TABLE `NOTAS` (
  `ID` int(10) NOT NULL,
  `ID_ASIGNATURA` int(10) NOT NULL,
  `ID_ALUMNO` int(10) NOT NULL,
  `NOTA` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `NOTAS`
--

INSERT INTO `NOTAS` (`ID`, `ID_ASIGNATURA`, `ID_ALUMNO`, `NOTA`) VALUES
(2, 17, 6, 5),
(3, 1, 7, 8),
(4, 9, 7, 8),
(5, 7, 8, 5),
(6, 19, 9, 7),
(7, 17, 7, 7),
(8, 9, 8, 8),
(9, 5, 6, 7),
(10, 1, 9, 5),
(11, 17, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PERMISOS`
--

CREATE TABLE `PERMISOS` (
  `ID` int(10) NOT NULL,
  `DESCRIPCION` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PERMISOS`
--

INSERT INTO `PERMISOS` (`ID`, `DESCRIPCION`) VALUES
(1, 'SUPERUSER'),
(2, 'ADMIN'),
(3, 'PROFESOR'),
(4, 'ALUMNO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PROFESORES`
--

CREATE TABLE `PROFESORES` (
  `ID` int(10) NOT NULL,
  `NOMBRE` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `FECHA_NACIMIENTO` datetime(6) NOT NULL,
  `FECHA_ENTRADA` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `PROFESORES`
--

INSERT INTO `PROFESORES` (`ID`, `NOMBRE`, `FECHA_NACIMIENTO`, `FECHA_ENTRADA`) VALUES
(70, 'profesorInformatica', '1980-02-02 00:00:00.000000', '2010-03-03 00:00:00.000000'),
(71, 'profesorInformatica 2', '1980-02-02 00:00:00.000000', '2010-03-03 00:00:00.000000'),
(81, 'ricardoProfe', '2010-06-09 00:00:00.000000', '2018-01-10 00:00:00.000000'),
(84, 'sergioProfe', '1996-03-02 00:00:00.000000', '2016-04-03 00:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PROFES_ASIGNATURAS`
--

CREATE TABLE `PROFES_ASIGNATURAS` (
  `ID` int(10) NOT NULL,
  `ID_PROFE` int(10) NOT NULL,
  `ID_ASIGNATURA` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PROFES_ASIGNATURAS`
--

INSERT INTO `PROFES_ASIGNATURAS` (`ID`, `ID_PROFE`, `ID_ASIGNATURA`) VALUES
(31, 70, 17),
(34, 70, 1),
(35, 71, 3),
(37, 70, 23),
(44, 81, 1),
(45, 71, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TAREAS`
--

CREATE TABLE `TAREAS` (
  `ID_TAREA` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL,
  `NOMBRE` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `FECHA_ENTREGA` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `TAREAS`
--

INSERT INTO `TAREAS` (`ID_TAREA`, `ID_ASIGNATURA`, `NOMBRE`, `FECHA_ENTREGA`) VALUES
(1, 9, 'Nueva Tarea AF', '2018-04-17 13:24:00.343484'),
(2, 19, 'Trabajo F1', '2018-01-17 00:00:00.000000'),
(3, 17, 'pruebaLunes11', '2017-02-02 00:00:00.000000'),
(4, 17, 'EJERCICIO2', '2018-03-02 00:00:00.000000'),
(5, 1, 'Tarea Ricardo profe', '2018-01-11 00:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TAREAS_ALUMNOS`
--

CREATE TABLE `TAREAS_ALUMNOS` (
  `ID_TAREAS_ALUMNOS` int(11) NOT NULL,
  `ID_TAREA` int(11) NOT NULL,
  `ID_ALUMNO` int(11) NOT NULL,
  `HECHO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `TAREAS_ALUMNOS`
--

INSERT INTO `TAREAS_ALUMNOS` (`ID_TAREAS_ALUMNOS`, `ID_TAREA`, `ID_ALUMNO`, `HECHO`) VALUES
(1, 1, 5, 1),
(3, 2, 5, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USERS`
--

CREATE TABLE `USERS` (
  `ID` int(10) NOT NULL,
  `NOMBRE` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `PASSWORD` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `EMAIL` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CODIGO_ACTIVACION` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `FECHA_ACTIVACION` datetime(6) NOT NULL,
  `ACTIVO` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USERS`
--

INSERT INTO `USERS` (`ID`, `NOMBRE`, `PASSWORD`, `EMAIL`, `CODIGO_ACTIVACION`, `FECHA_ACTIVACION`, `ACTIVO`) VALUES
(1, 'xd', '2000:97c242f297087b8d4ad7091a4bfb2976e08b9335dd67ee1a:18a9fb705988edc0a57c0025e7cef0d2876c14067088ee5e', '1', '2YMHRW4GOFLM921EQ7AY9UMTED5Q6OBH2ON', '2017-12-13 00:24:37.000000', 0),
(2, 'prueba', '2000:97c242f297087b8d4ad7091a4bfb2976e08b9335dd67ee1a:18a9fb705988edc0a57c0025e7cef0d2876c14067088ee5e', '1', '2', '2017-12-13 00:24:37.000000', 0),
(3, 'Profesor 1', 'passworddddd', 'profe@gmail.com', 'activation', '2018-01-03 03:09:16.086000', 0),
(4, 'profe 2', 'password', 'profe@mail.com', 'code', '2018-01-04 08:18:24.000000', 0),
(5, 'Alumno 1', 'password', 'mail@correo.com', 'code', '2018-01-23 00:00:18.148320', 0),
(6, 'Alumno 2', 'password', 'mail@correo.com', 'code', '2018-01-23 00:00:18.148320', 0),
(7, 'Alumno Num 3', 'password', 'mail@correo.com', 'code', '2018-01-23 00:00:18.148320', 0),
(8, 'Alumno Num 4', 'password', 'mail@correo.com', 'code', '2018-01-23 00:00:18.148320', 0),
(9, 'Alumno Num 5', 'password', 'mail@correo.com', 'code', '2018-01-23 00:00:18.148320', 0),
(10, 'testq', 'test', 'e', 'e', '2018-01-23 00:00:18.148320', 0),
(21, 'prueba', 'whatever', 'algo@gmail.com', ' ', '2017-12-13 00:24:37.000000', 1),
(49, 'profesordEPRUEBAS', '1000:ae5c92603ae2be34ece26fcca0dc5ce21718db2056b178d8:4af05afa3a407b757c108f0504b9a3b5e4be0b7ed93f89c3', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(50, 'profesordEPRUEBAS', '1000:ae5c92603ae2be34ece26fcca0dc5ce21718db2056b178d8:4af05afa3a407b757c108f0504b9a3b5e4be0b7ed93f89c3', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(70, 'profesorInformatica', '1000:6763e0ea0c2eb54615e26415c0d23f0a19c139d4fc1e47f6:eaf28ac5dc2b0fc9126ecd18f42a74eb494d29ff9397e0ef', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(71, 'profesorInformatica 2', '1000:6763e0ea0c2eb54615e26415c0d23f0a19c139d4fc1e47f6:eaf28ac5dc2b0fc9126ecd18f42a74eb494d29ff9397e0ef', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(72, 'AlumnoPrueba', '1000:63bef0989a82e4335c6c6b38db72d6cabd548f903dd3ad64:17385d7ff45990513b0c7157cf6173b6bcb690ae1199130c', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(73, 'AlumnoPrueba', '1000:63bef0989a82e4335c6c6b38db72d6cabd548f903dd3ad64:17385d7ff45990513b0c7157cf6173b6bcb690ae1199130c', 'prueba@crud.com', ' ', '2018-01-09 00:00:00.000000', 1),
(74, 'AlumnoMiercoles', '1000:511285a4dea3b8b52bf3f1349b33853a21346e6c466283d7:fce67d4c9f34c976b4f44c273ac253c35d8e7620a1ed6a05', 'prueba@gmail.com', ' ', '2018-01-10 00:00:00.000000', 1),
(75, 'AlumnoMiercoles', '1000:511285a4dea3b8b52bf3f1349b33853a21346e6c466283d7:fce67d4c9f34c976b4f44c273ac253c35d8e7620a1ed6a05', 'prueba@gmail.com', ' ', '2018-01-10 00:00:00.000000', 1),
(76, 'Alumno 10', '1000:df739b0882a6299a467c3763ecf16cea001b09ff84131228:588e3923d8e66513e0473ee1872bbdfc4713fd4fe2332df3', 'alumno10@gmail.com', ' ', '2018-01-10 00:00:00.000000', 1),
(77, 'Alumno 10', '1000:df739b0882a6299a467c3763ecf16cea001b09ff84131228:588e3923d8e66513e0473ee1872bbdfc4713fd4fe2332df3', 'alumno10@gmail.com', ' ', '2018-01-10 00:00:00.000000', 1),
(78, 'ALUMNO 100', '1000:41276f8a527747d8a9ef4385eb489fa8b9b9e57638f46f8f:a5f527bce1afe2b83e35c2ea9167fc968f33a18795e15972', 'alumno10@gmail.com', ' ', '2018-01-10 00:00:00.000000', 1),
(79, 'Ricardo', '1000:bd5a4417e9fc8c00425459a21d5177ac20f267faa4049f3c:f005a158109d2a8a2fd300f37f24b643486e1f8cad83a7f0', 'alumno@discutivo.com', ' ', '2018-01-10 00:00:00.000000', 1),
(80, 'ricardoAlumn', '1000:723872c88618c33ffe20e5562c11ba950bc4c35e19ca57ff:a82605d85928e1152594d3cf001f1864501f3d242195c051', 'alumno@discutivo.com', ' ', '2018-01-10 00:00:00.000000', 1),
(81, 'ricardoProfe', '1000:baa446bb1aae831033d41ad07ec2c223b478165be334d609:a04a8804de843c98f0a188297cc9a0fb8bb4ae16de43b2e7', 'profe@discutivo.com', ' ', '2018-01-10 00:00:00.000000', 1),
(83, 'UserRegis', '1000:9efa204218844a72c28d6b7b310a0aef1261e301f9818fa9:e6cf072fa38df9a9328f30a4fa04a2013b2e596ec5b4d6c5', 'registro@discutivo.com', 'W1ZN', '2018-01-11 18:21:11.407000', 1),
(84, 'sergioProfe', '1000:9cb0663b293631f369debb4ef9ab04d23369495e88d69ccb:507fab4cd4c5668b2436dd306566930da16469e3d5cc6d17', 'sergio@profe.com', ' ', '2018-01-12 00:00:00.000000', 1),
(85, 'ricardoSuper', '1000:7dc074d2fad3948802fbae379579b8e3989663a75972906f:ea3c9fdac3791a409321545d816c774522ccf812cb371661', 'ricardoSuper@discutivo.com', 'QR3OE8YHDQRPL', '2018-01-13 16:11:17.431000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER_PERMISOS`
--

CREATE TABLE `USER_PERMISOS` (
  `ID_USER_PERMISO` int(10) NOT NULL,
  `ID_USER` int(10) NOT NULL,
  `ID_PERMISOS` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USER_PERMISOS`
--

INSERT INTO `USER_PERMISOS` (`ID_USER_PERMISO`, `ID_USER`, `ID_PERMISOS`) VALUES
(3, 49, 3),
(4, 50, 3),
(15, 70, 3),
(16, 71, 3),
(17, 72, 3),
(18, 73, 4),
(19, 74, 3),
(20, 75, 4),
(22, 77, 4),
(23, 78, 4),
(24, 79, 4),
(25, 80, 4),
(26, 81, 3),
(27, 83, 2),
(28, 84, 3),
(29, 85, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ALUMNOS`
--
ALTER TABLE `ALUMNOS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indices de la tabla `ALUMNOS_ASIGNATURAS`
--
ALTER TABLE `ALUMNOS_ASIGNATURAS`
  ADD PRIMARY KEY (`ID_ALUMNOS_ASIGNATURAS`),
  ADD KEY `ALUMNOS_ASIG_FK1` (`ID_ALUMNO`),
  ADD KEY `ALUMNOS_ASIG_FK2` (`ID_ASIGNATURA`);

--
-- Indices de la tabla `ASIGNATURAS`
--
ALTER TABLE `ASIGNATURAS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indices de la tabla `ASIGNATURAS_CURSOS`
--
ALTER TABLE `ASIGNATURAS_CURSOS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ASIGN_CURSO_idx` (`ID_ASIGNATURA`),
  ADD KEY `CURSO_ASIG_idx` (`ID_CURSO`);

--
-- Indices de la tabla `CURSOS`
--
ALTER TABLE `CURSOS`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `NOTAS`
--
ALTER TABLE `NOTAS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ASIG_NOTA_idx` (`ID_ASIGNATURA`),
  ADD KEY `ALUMNO_NOTA_idx` (`ID_ALUMNO`);

--
-- Indices de la tabla `PERMISOS`
--
ALTER TABLE `PERMISOS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indices de la tabla `PROFESORES`
--
ALTER TABLE `PROFESORES`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `PROFES_ASIGNATURAS`
--
ALTER TABLE `PROFES_ASIGNATURAS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PROFE_ASIGNATURA_idx` (`ID_PROFE`),
  ADD KEY `ASIGNATURA_PROFE_idx` (`ID_ASIGNATURA`);

--
-- Indices de la tabla `TAREAS`
--
ALTER TABLE `TAREAS`
  ADD PRIMARY KEY (`ID_TAREA`),
  ADD KEY `ID_ASIGNATURA` (`ID_ASIGNATURA`);

--
-- Indices de la tabla `TAREAS_ALUMNOS`
--
ALTER TABLE `TAREAS_ALUMNOS`
  ADD PRIMARY KEY (`ID_TAREAS_ALUMNOS`),
  ADD KEY `ID_ALUMNO` (`ID_ALUMNO`),
  ADD KEY `ID_TAREA` (`ID_TAREA`);

--
-- Indices de la tabla `USERS`
--
ALTER TABLE `USERS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indices de la tabla `USER_PERMISOS`
--
ALTER TABLE `USER_PERMISOS`
  ADD PRIMARY KEY (`ID_USER_PERMISO`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID_USER_PERMISO`),
  ADD KEY `ID_ALUMNO_idx` (`ID_USER`),
  ADD KEY `PERMISO_USER_idx` (`ID_PERMISOS`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ALUMNOS_ASIGNATURAS`
--
ALTER TABLE `ALUMNOS_ASIGNATURAS`
  MODIFY `ID_ALUMNOS_ASIGNATURAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `ASIGNATURAS`
--
ALTER TABLE `ASIGNATURAS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT de la tabla `ASIGNATURAS_CURSOS`
--
ALTER TABLE `ASIGNATURAS_CURSOS`
  MODIFY `ID` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT de la tabla `CURSOS`
--
ALTER TABLE `CURSOS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `NOTAS`
--
ALTER TABLE `NOTAS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `PERMISOS`
--
ALTER TABLE `PERMISOS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `PROFES_ASIGNATURAS`
--
ALTER TABLE `PROFES_ASIGNATURAS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT de la tabla `TAREAS`
--
ALTER TABLE `TAREAS`
  MODIFY `ID_TAREA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `TAREAS_ALUMNOS`
--
ALTER TABLE `TAREAS_ALUMNOS`
  MODIFY `ID_TAREAS_ALUMNOS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `USERS`
--
ALTER TABLE `USERS`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT de la tabla `USER_PERMISOS`
--
ALTER TABLE `USER_PERMISOS`
  MODIFY `ID_USER_PERMISO` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ALUMNOS`
--
ALTER TABLE `ALUMNOS`
  ADD CONSTRAINT `ALUMNOS_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ALUMNOS_ASIGNATURAS`
--
ALTER TABLE `ALUMNOS_ASIGNATURAS`
  ADD CONSTRAINT `ALUMNOS_ASIG_FK1` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `ALUMNOS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ALUMNOS_ASIG_FK2` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `ASIGNATURAS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ASIGNATURAS_CURSOS`
--
ALTER TABLE `ASIGNATURAS_CURSOS`
  ADD CONSTRAINT `ASIGNATURAS_CURSOS_ibfk_1` FOREIGN KEY (`ID_CURSO`) REFERENCES `CURSOS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ASIGNATURAS_CURSOS_ibfk_2` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `ASIGNATURAS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `NOTAS`
--
ALTER TABLE `NOTAS`
  ADD CONSTRAINT `ASIG_NOTA` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `ASIGNATURAS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `NOTAS_ibfk_1` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `ALUMNOS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `PROFESORES`
--
ALTER TABLE `PROFESORES`
  ADD CONSTRAINT `ID` FOREIGN KEY (`ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `PROFES_ASIGNATURAS`
--
ALTER TABLE `PROFES_ASIGNATURAS`
  ADD CONSTRAINT `ASIGNATURA_PROFE` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `ASIGNATURAS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `PROFES_ASIGNATURAS_ibfk_1` FOREIGN KEY (`ID_PROFE`) REFERENCES `PROFESORES` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `TAREAS`
--
ALTER TABLE `TAREAS`
  ADD CONSTRAINT `TAREAS_ibfk_1` FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES `ASIGNATURAS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `TAREAS_ALUMNOS`
--
ALTER TABLE `TAREAS_ALUMNOS`
  ADD CONSTRAINT `TAREAS_ALUMNOS_ibfk_1` FOREIGN KEY (`ID_TAREA`) REFERENCES `TAREAS` (`ID_TAREA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `TAREAS_ALUMNOS_ibfk_2` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `ALUMNOS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `USER_PERMISOS`
--
ALTER TABLE `USER_PERMISOS`
  ADD CONSTRAINT `PERMISO_USER` FOREIGN KEY (`ID_PERMISOS`) REFERENCES `PERMISOS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `USER_PERMISO` FOREIGN KEY (`ID_USER`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
