-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-10-2017 a las 04:59:38
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tpdds`
--

CREATE DATABASE IF NOT EXISTS tpdds;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE IF NOT EXISTS `actividad` (
  `actividadID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulainformatica`
--

CREATE TABLE IF NOT EXISTS `aulainformatica` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  `cantPCS` int(11) DEFAULT NULL,
  `canion` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulamultimedios`
--

CREATE TABLE IF NOT EXISTS `aulamultimedios` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  `televisor` tinyint(1) DEFAULT NULL,
  `canion` tinyint(1) DEFAULT NULL,
  `computadora` tinyint(1) DEFAULT NULL,
  `dvd` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulasra`
--

CREATE TABLE IF NOT EXISTS `aulasra` (
  `aulaID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`aulaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bedel`
--

CREATE TABLE IF NOT EXISTS `bedel` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(10) DEFAULT NULL,
  `email` varchar(35) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catedra`
--

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

CREATE TABLE IF NOT EXISTS `clave` (
  `claveID` INT NOT NULL AUTO_INCREMENT,
  `valor` varchar(30) NOT NULL DEFAULT '',
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `hora` time NOT NULL DEFAULT '00:00:00',
  `userID` int(11) NOT NULL,
  `politicaID` int(11) NOT NULL,
  PRIMARY KEY (`claveID`),
  KEY `fk_politica` (`politicaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
  `actividadID` int(11) NOT NULL,
  `carrera` varchar(40) NOT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diareserva`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE IF NOT EXISTS `docente` (
  `docenteID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`docenteID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fechalectivas`
--

CREATE TABLE IF NOT EXISTS `fechalectivas` (
  `fechainicio1C` date DEFAULT NULL,
  `fechafin1C` date DEFAULT NULL,
  `fechainicio2C` date DEFAULT NULL,
  `fechafin2C` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `politicascontrasenia`
--

CREATE TABLE IF NOT EXISTS `politicascontrasenia` (
  `politicaID` int(11) NOT NULL AUTO_INCREMENT,
  `longMin` int(11) NOT NULL,
  `signosEspeciales` tinyint(1) NOT NULL,
  `letraMay` tinyint(1) NOT NULL,
  `digito` tinyint(1) NOT NULL,
  `passIgual` tinyint(1) NOT NULL,
  `claveID` int(11) NOT NULL,
  PRIMARY KEY (`politicaID`),
  UNIQUE KEY `claveID` (`claveID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodica`
--

CREATE TABLE IF NOT EXISTS `periodica` (
  `reservaID` int(11) NOT NULL AUTO_INCREMENT,
  `tipoReservaPeriodica` varchar(15) NOT NULL,
  PRIMARY KEY (`reservaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `esporadica`
--

CREATE TABLE IF NOT EXISTS `esporadica` (
  `reservaID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`reservaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seminario`
--

CREATE TABLE IF NOT EXISTS `seminario` (
  `actividadID` int(11) NOT NULL,
  `tema` varchar(40) NOT NULL,
  PRIMARY KEY (`actividadID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(15) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `claveID` int(11) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`),
  UNIQUE KEY `claveID` (`claveID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  ADD CONSTRAINT `fk_politica` FOREIGN KEY (`politicaID`) REFERENCES `politicascontrasenia` (`politicaID`),
  ADD CONSTRAINT `clave_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `usuario` (`userID`);

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
-- Filtros para la tabla `politicascontrasenia`
--
ALTER TABLE `politicascontrasenia`
  ADD CONSTRAINT `politicascontrasenia_ibfk_1` FOREIGN KEY (`claveID`) REFERENCES `clave` (`claveID`);

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
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`claveID`) REFERENCES `clave` (`claveID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
