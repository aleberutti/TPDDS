-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-10-2017 a las 02:25:13
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tpdds`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

DROP TABLE IF EXISTS `actividad`;
CREATE TABLE IF NOT EXISTS `actividad` (
  `actividadID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

DROP TABLE IF EXISTS `aula`;
CREATE TABLE IF NOT EXISTS `aula` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `aireacond` tinyint(1) DEFAULT NULL,
  `pizarron` varchar(10) DEFAULT NULL,
  `ventiladores` int(11) DEFAULT NULL,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulainformatica`
--

DROP TABLE IF EXISTS `aulainformatica`;
CREATE TABLE IF NOT EXISTS `aulainformatica` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  `cantPCS` int(11) DEFAULT NULL,
  `canion` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulamultimedios`
--

DROP TABLE IF EXISTS `aulamultimedios`;
CREATE TABLE IF NOT EXISTS `aulamultimedios` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  `televisor` tinyint(1) DEFAULT NULL,
  `canion` tinyint(1) DEFAULT NULL,
  `computadora` tinyint(1) DEFAULT NULL,
  `dvd` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulasra`
--

DROP TABLE IF EXISTS `aulasra`;
CREATE TABLE IF NOT EXISTS `aulasra` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bedel`
--

DROP TABLE IF EXISTS `bedel`;
CREATE TABLE IF NOT EXISTS `bedel` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(10) DEFAULT NULL,
  `email` varchar(35) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catedra`
--

DROP TABLE IF EXISTS `catedra`;
CREATE TABLE IF NOT EXISTS `catedra` (
  `actividadID` int(11) NOT NULL,
  `carrera` varchar(40) NOT NULL,
  `comision` varchar(40) NOT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clave`
--

DROP TABLE IF EXISTS `clave`;
CREATE TABLE IF NOT EXISTS `clave` (
  `claveID` int(11) NOT NULL AUTO_INCREMENT,
  `valor` varchar(30) NOT NULL DEFAULT '',
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `hora` time NOT NULL DEFAULT '00:00:00',
  `userID` int(11) DEFAULT NULL,
  `politicaID` int(11) NOT NULL,
  PRIMARY KEY (`claveID`),
  KEY `fk_politica` (`politicaID`),
  KEY `clave_ibfk_1` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `actividadID` int(11) NOT NULL,
  `carrera` varchar(40) NOT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diareserva`
--

DROP TABLE IF EXISTS `diareserva`;
CREATE TABLE IF NOT EXISTS `diareserva` (
  `diaReservaID` int(11) NOT NULL AUTO_INCREMENT,
  `diaSemana` varchar(15) NOT NULL,
  `fecha` date NOT NULL,
  `horainicio` time NOT NULL,
  `horafin` time NOT NULL,
  `aulaID` int(11) NOT NULL,
  `reservaID` int(11) NOT NULL,
  PRIMARY KEY (`diaReservaID`),
  KEY `aulaID` (`aulaID`),
  KEY `reservaID` (`reservaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

DROP TABLE IF EXISTS `docente`;
CREATE TABLE IF NOT EXISTS `docente` (
  `docenteID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`docenteID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `esporadica`
--

DROP TABLE IF EXISTS `esporadica`;
CREATE TABLE IF NOT EXISTS `esporadica` (
  `reservaID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`reservaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fechalectivas`
--

DROP TABLE IF EXISTS `fechalectivas`;
CREATE TABLE IF NOT EXISTS `fechalectivas` (
  `fechainicio1C` date DEFAULT NULL,
  `fechafin1C` date DEFAULT NULL,
  `fechainicio2C` date DEFAULT NULL,
  `fechafin2C` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodica`
--

DROP TABLE IF EXISTS `periodica`;
CREATE TABLE IF NOT EXISTS `periodica` (
  `reservaID` int(11) NOT NULL AUTO_INCREMENT,
  `tipoReservaPeriodica` varchar(15) NOT NULL,
  PRIMARY KEY (`reservaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `politicascontrasenia`
--

DROP TABLE IF EXISTS `politicascontrasenia`;
CREATE TABLE IF NOT EXISTS `politicascontrasenia` (
  `politicaID` int(11) NOT NULL AUTO_INCREMENT,
  `longMin` int(11) NOT NULL,
  `signosEspeciales` tinyint(1) NOT NULL,
  `letraMay` tinyint(1) NOT NULL,
  `digito` tinyint(1) NOT NULL,
  `passIgual` tinyint(1) NOT NULL,
  PRIMARY KEY (`politicaID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `politicascontrasenia`
--

INSERT INTO `politicascontrasenia` (`politicaID`, `longMin`, `signosEspeciales`, `letraMay`, `digito`, `passIgual`) VALUES
(1, 8, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `reservaID` int(11) NOT NULL AUTO_INCREMENT,
  `cantAlumnos` int(11) NOT NULL,
  `fecha_solicitud` datetime NOT NULL,
  `periodo` varchar(15) NOT NULL,
  `userID` int(11) NOT NULL,
  `docenteID` int(11) NOT NULL,
  `actividadID` int(11) NOT NULL,
  PRIMARY KEY (`reservaID`),
  KEY `userID` (`userID`),
  KEY `docenteID` (`docenteID`),
  KEY `actividadID` (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seminario`
--

DROP TABLE IF EXISTS `seminario`;
CREATE TABLE IF NOT EXISTS `seminario` (
  `actividadID` int(11) NOT NULL,
  `tema` varchar(40) NOT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `userID` int(11) NOT NULL,
  `nombreUsuario` varchar(15) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `claveID` int(11) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`),
  UNIQUE KEY `claveID` (`claveID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `usuario` (`userID`);

--
-- Filtros para la tabla `aulainformatica`
--
ALTER TABLE `aulainformatica`
  ADD CONSTRAINT `aulainformatica_ibfk_1` FOREIGN KEY (`aulaID`) REFERENCES `aula` (`aulaID`);

--
-- Filtros para la tabla `aulamultimedios`
--
ALTER TABLE `aulamultimedios`
  ADD CONSTRAINT `aulamultimedios_ibfk_1` FOREIGN KEY (`aulaID`) REFERENCES `aula` (`aulaID`);

--
-- Filtros para la tabla `aulasra`
--
ALTER TABLE `aulasra`
  ADD CONSTRAINT `aulasra_ibfk_1` FOREIGN KEY (`aulaID`) REFERENCES `aula` (`aulaID`);

--
-- Filtros para la tabla `bedel`
--
ALTER TABLE `bedel`
  ADD CONSTRAINT `bedel_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `usuario` (`userID`);

--
-- Filtros para la tabla `catedra`
--
ALTER TABLE `catedra`
  ADD CONSTRAINT `catedra_ibfk_1` FOREIGN KEY (`actividadID`) REFERENCES `actividad` (`actividadID`);

--
-- Filtros para la tabla `clave`
--
ALTER TABLE `clave`
  ADD CONSTRAINT `clave_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `usuario` (`userID`),
  ADD CONSTRAINT `fk_politica` FOREIGN KEY (`politicaID`) REFERENCES `politicascontrasenia` (`politicaID`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`actividadID`) REFERENCES `actividad` (`actividadID`);

--
-- Filtros para la tabla `diareserva`
--
ALTER TABLE `diareserva`
  ADD CONSTRAINT `diareserva_ibfk_1` FOREIGN KEY (`aulaID`) REFERENCES `aula` (`aulaID`),
  ADD CONSTRAINT `diareserva_ibfk_2` FOREIGN KEY (`reservaID`) REFERENCES `reserva` (`reservaID`);

--
-- Filtros para la tabla `esporadica`
--
ALTER TABLE `esporadica`
  ADD CONSTRAINT `esporadica_ibfk_1` FOREIGN KEY (`reservaID`) REFERENCES `reserva` (`reservaID`);

--
-- Filtros para la tabla `periodica`
--
ALTER TABLE `periodica`
  ADD CONSTRAINT `periodica_ibfk_1` FOREIGN KEY (`reservaID`) REFERENCES `reserva` (`reservaID`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `bedel` (`userID`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`docenteID`) REFERENCES `docente` (`docenteID`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`actividadID`) REFERENCES `actividad` (`actividadID`);

--
-- Filtros para la tabla `seminario`
--
ALTER TABLE `seminario`
  ADD CONSTRAINT `seminario_ibfk_1` FOREIGN KEY (`actividadID`) REFERENCES `actividad` (`actividadID`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`claveID`) REFERENCES `clave` (`claveID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
