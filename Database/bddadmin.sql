-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 21 août 2020 à 12:03
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bddadmin`
--

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `MATRICULE_ENS` int(11) NOT NULL,
  `NOM_ENS` varchar(30) NOT NULL,
  `PRENOM_ENS` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`MATRICULE_ENS`, `NOM_ENS`, `PRENOM_ENS`) VALUES
(1, 'smail', 'mohoch'),
(2, 'ghiles', 'iness'),
(3, 'anis', 'dadi'),
(4, 'amine', 'monar'),
(5, 'lotfi', 'bougaoua'),
(6, 'mofdi', 'bosadda'),
(7, 'lyes', 'pomard'),
(8, 'mahfod', 'modar'),
(50, 'mohammed ha', 'karim');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `MATRICULE_ETU` int(11) NOT NULL,
  `NOM_ETU` varchar(40) NOT NULL,
  `PRENOM_ETU` varchar(40) NOT NULL,
  `ADDRESSE` varchar(40) NOT NULL,
  `DATE_NAISSANCE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`MATRICULE_ETU`, `NOM_ETU`, `PRENOM_ETU`, `ADDRESSE`, `DATE_NAISSANCE`) VALUES
(1, 'mohammed', 'said', 'bommerdas', '1990-01-02'),
(2, 'karim', 'fateh', 'bommerdas', '1991-02-02'),
(3, 'omar', 'morad', 'bommerdas', '1992-04-05'),
(4, 'ibrahim', 'bougaoua', 'bommerdas', '1993-06-07'),
(5, 'fahem', 'monir', 'bommerdas', '1994-10-12'),
(6, 'ahmed', 'fateh', 'bommerdas', '1995-03-02'),
(7, 'lamine', 'samed', 'bommerdas', '1996-01-02'),
(10, 'cc', 'kimo', 'alger', '2020-08-13'),
(11, 'fateh', 'vomir', 'bommerdas', '2002-08-10');

-- --------------------------------------------------------

--
-- Structure de la table `etudiantunite`
--

CREATE TABLE `etudiantunite` (
  `MATRICULE_ETU` int(11) NOT NULL,
  `CODE_UNITE` varchar(30) NOT NULL,
  `NOTE_CC` int(11) NOT NULL,
  `NOTE_TP` int(11) NOT NULL,
  `NOTE_EXAMEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiantunite`
--

INSERT INTO `etudiantunite` (`MATRICULE_ETU`, `CODE_UNITE`, `NOTE_CC`, `NOTE_TP`, `NOTE_EXAMEN`) VALUES
(1, 'f10000', 10, 5, 2),
(4, 'f30000', 10, 15, 16),
(5, 'f20000', 10, 12, 14),
(7, 'f40000', 10, 14, 18);

-- --------------------------------------------------------

--
-- Structure de la table `unite`
--

CREATE TABLE `unite` (
  `CODE_UNITE` varchar(30) NOT NULL,
  `LIBELLE` varchar(30) NOT NULL,
  `NBR_HEURES` int(11) NOT NULL,
  `MATRICULE_ENS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `unite`
--

INSERT INTO `unite` (`CODE_UNITE`, `LIBELLE`, `NBR_HEURES`, `MATRICULE_ENS`) VALUES
('f10000', 'algorithm', 11, 5),
('f20000', 'base de donne', 10, 2),
('f30000', 'poo', 8, 1),
('f40000', 'gl', 5, 3),
('f50000', 'logique', 20, 6),
('f60000', 'analise', 12, 7);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`MATRICULE_ENS`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`MATRICULE_ETU`);

--
-- Index pour la table `etudiantunite`
--
ALTER TABLE `etudiantunite`
  ADD PRIMARY KEY (`MATRICULE_ETU`,`CODE_UNITE`),
  ADD KEY `FK_ETUDIANTUNITE_UNITE` (`CODE_UNITE`);

--
-- Index pour la table `unite`
--
ALTER TABLE `unite`
  ADD PRIMARY KEY (`CODE_UNITE`),
  ADD KEY `FK_UNITE_ENSEIGNANT` (`MATRICULE_ENS`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiantunite`
--
ALTER TABLE `etudiantunite`
  ADD CONSTRAINT `FK_ETUDIANTUNITE_ETUDIANT` FOREIGN KEY (`MATRICULE_ETU`) REFERENCES `etudiant` (`MATRICULE_ETU`),
  ADD CONSTRAINT `FK_ETUDIANTUNITE_UNITE` FOREIGN KEY (`CODE_UNITE`) REFERENCES `unite` (`CODE_UNITE`);

--
-- Contraintes pour la table `unite`
--
ALTER TABLE `unite`
  ADD CONSTRAINT `FK_UNITE_ENSEIGNANT` FOREIGN KEY (`MATRICULE_ENS`) REFERENCES `enseignant` (`MATRICULE_ENS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
