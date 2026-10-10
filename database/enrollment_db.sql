-- ═══════════════════════════════════════════════════════
-- ENROLLMENT SERVICE DATABASE
-- ═══════════════════════════════════════════════════════
DROP DATABASE IF EXISTS enrollment_db;
CREATE DATABASE enrollment_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE enrollment_db;

-- ─────────────────────────────────────────────────────
-- Table: enrollment
-- ─────────────────────────────────────────────────────
CREATE TABLE enrollment (
    id              BIGINT      NOT NULL AUTO_INCREMENT,
    student_id      BIGINT      NOT NULL,
    course_id       BIGINT      NOT NULL,
    enrollment_date DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_enrollment_student (student_id),
    KEY idx_enrollment_course  (course_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ─────────────────────────────────────────────────────
-- Données de test
-- ═══════════════════════════════════════════════════════
-- NOTE: Course IDs valides : 1 à 8
--       Student IDs valides : 1 à 9
--       Un cours ne peut PAS avoir plus de 3 étudiants
-- ─────────────────────────────────────────────────────
INSERT INTO enrollment (id, student_id, course_id, enrollment_date) VALUES
(1,   1, 1, '2026-05-06 23:14:10'),
(2,   1, 2, '2026-05-06 23:14:10'),
(3,   2, 3, '2026-05-06 23:14:10'),
(52,  1, 1, '2026-05-20 15:28:51'),
(53,  7, 7, '2026-05-20 15:37:04'),
(103, 7, 3, '2026-05-20 21:40:44'),
(105, 2, 6, '2026-05-20 21:49:45'),
(155, 1, 8, '2026-05-31 13:03:58'),
(203, 7, 7, '2026-05-31 13:18:28'),
(302, 2, 2, '2026-06-16 12:37:05'),
(304, 3, 7, '2026-06-17 13:06:55'),
(353, 9, 6, '2026-10-10 00:20:07');

-- Vérification
SELECT * FROM enrollment;

-- ─────────────────────────────────────────────────────
-- Requêtes utiles pour vérifier les règles métier
-- ─────────────────────────────────────────────────────

-- Compter les inscriptions par cours (doit être <= 3)
SELECT course_id, COUNT(*) AS total
FROM enrollment
GROUP BY course_id
HAVING total > 3;   -- Si cette requête retourne des lignes → violation de règle

-- Inscriptions d'un étudiant
SELECT e.*, c.title
FROM enrollment e
LEFT JOIN course_db.course c ON c.id = e.course_id
WHERE e.student_id = 1;