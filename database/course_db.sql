-- ═══════════════════════════════════════════════════════
-- COURSE SERVICE DATABASE
-- ═══════════════════════════════════════════════════════
DROP DATABASE IF EXISTS course_db;
CREATE DATABASE course_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE course_db;

-- ─────────────────────────────────────────────────────
-- Table: course
-- ─────────────────────────────────────────────────────
CREATE TABLE course (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255),
    description VARCHAR(500),
    credits     INT          NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ─────────────────────────────────────────────────────
-- Données de test
-- ─────────────────────────────────────────────────────
INSERT INTO course (id, title, description, credits) VALUES
(1, 'Java',                    'Java programming course',                          3),
(2, 'Spring Boot',             'Microservices with Spring Boot',                   4),
(3, 'Database',                'MySQL fundamentals',                               2),
(4, 'Java Programming',        'Advanced Java concepts and best practices',        4),
(5, 'REST API Development',    'Build RESTful APIs with Spring Boot',              3),
(6, 'Database Design',         'MySQL, PostgreSQL, and database normalization',    4),
(7, 'Cloud Computing',         'AWS, Azure, and cloud deployment strategies',      5),
(8, 'DevOps Basics',           'CI/CD, Docker, and Kubernetes fundamentals',       3);

-- Vérification
SELECT * FROM course;