-- ═══════════════════════════════════════════════════════
-- STUDENT SERVICE DATABASE
-- ═══════════════════════════════════════════════════════
DROP DATABASE IF EXISTS student_db;
CREATE DATABASE student_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE student_db;

-- ─────────────────────────────────────────────────────
-- Table: student
-- ─────────────────────────────────────────────────────
CREATE TABLE student (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    cnie        VARCHAR(255) NOT NULL,
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    email       VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY uk_student_cnie (cnie)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ─────────────────────────────────────────────────────
-- Données de test
-- ─────────────────────────────────────────────────────
INSERT INTO student (id, cnie, first_name, last_name, email) VALUES
(1, 'CN123',   'Sara',    'Benali',      'sara@gmail.com'),
(2, 'CN124',   'Ali',     'El Amrani',   'ali@gmail.com'),
(3, 'CN125',   'Yassine', 'Haddad',      'yassine@gmail.com'),
(4, 'CD5678',  'Youssef', 'Tazi',        'youssef@example.com'),
(5, 'CN789',   'Khadija', 'Mansouri',    'khadija@example.com'),
(6, 'CD9012',  'Omar',    'Fassi',       'omar@example.com'),
(7, 'CN345',   'Leila',   'Berrada',     'leila@example.com'),
(8, 'CD6789',  'Hassan',  'Benjelloun',  'hassan@example.com'),
(9, 'AB2004',  'Salma',   'Idrissi',     'salma@example.com');

-- Vérification
SELECT * FROM student;