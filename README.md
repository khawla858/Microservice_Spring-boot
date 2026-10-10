# 🎓 AcadémIA — Student Enrollment System

Application de gestion des inscriptions étudiantes basée sur une **architecture microservices avec Spring Boot et Spring Cloud**.

## 📌 Présentation

AcadémIA permet aux étudiants de :

* 📚 Consulter les cours disponibles.
* 📝 S'inscrire à un cours via leur CNIE.
* 📋 Consulter leurs inscriptions.
* ❌ Annuler une inscription dans les 24 heures.

## 🏗️ Architecture

| Composant          |   Port | Rôle                     |
| ------------------ | -----: | ------------------------ |
| Eureka Server      | `8761` | Découverte des services  |
| API Gateway        | `8080` | Point d'entrée unique    |
| Student Service    | `8081` | Gestion des étudiants    |
| Course Service     | `8082` | Gestion des cours        |
| Enrollment Service | `8083` | Gestion des inscriptions |
| Frontend           | `5500` | Interface web            |

## 🛠️ Technologies

| Technologie           | Utilisation                  |
| --------------------- | ---------------------------- |
| Java 17               | Langage de programmation     |
| Spring Boot 3.1.5     | Développement backend        |
| Spring Cloud 2022.0.4 | Architecture microservices   |
| Spring Cloud Gateway  | Routage des requêtes         |
| Eureka                | Découverte des services      |
| WebClient / WebFlux   | Communication entre services |
| Spring Data JPA       | Persistance des données      |
| MySQL 8               | Bases de données             |
| HTML, CSS, JavaScript | Frontend                     |
| Maven                 | Gestion des dépendances      |

## 📁 Structure du projet

```text
Microservice_Spring-boot/
├── database/
├── eureka-server/
├── api-gateway/
├── student-service/
├── course-service/
├── enrollment-service/
├── frontend/
│   └── index.html
└── README.md
```

## ⚙️ Installation

### 1. Cloner le projet

```bash
git clone https://github.com/khawla858/Microservice_Spring-boot.git
cd Microservice_Spring-boot
```

### 2. Créer les bases de données

```bash
mysql -u root -p < database/01_student_db.sql
mysql -u root -p < database/02_course_db.sql
mysql -u root -p < database/03_enrollment_db.sql
```
### 3. Configurer MySQL

Dans le fichier application.properties de chaque microservice concerné, la connexion est configurée avec les variables d’environnement :

 - DB_USERNAME : nom d’utilisateur MySQL, root par défaut.
 - DB_PASSWORD : mot de passe de votre utilisateur MySQL.

## ▶️ Démarrage

Lancer les services dans cet ordre, avec un terminal par service :

1. Eureka Server
2. Student Service
3. Course Service
4. Enrollment Service
5. API Gateway
6. Frontend avec Live Server dans VS Code

Pour chaque microservice, exécuter depuis son dossier :

```bash
mvnw spring-boot:run
```

Sous Windows PowerShell, utiliser `.\mvnw.cmd spring-boot:run` si le Maven Wrapper est présent.

**Interface web :** http://localhost:5500

**Console Eureka :** http://localhost:8761


## 📋 Règles métier

| Règle              | Description                                           |
| ------------------ | ----------------------------------------------------- |
| Capacité maximale  | 3 étudiants par cours                                 |
| Annulation         | Dans les 24 heures suivant l'inscription              |
| Inscription unique | Pas de doublon pour un même étudiant et un même cours |

## 🧪 Données de test

| CNIE     | Nom           |
| -------- | ------------- |
| `AB2004` | Salma Idrissi |
| `CN123`  | Sara Benali   |

Utiliser `AB2004` pour tester la recherche par CNIE, si cet étudiant existe dans la base de données.

## 🐛 Dépannage

| Problème              | Solution                                |
| --------------------- | --------------------------------------- |
| `Port already in use` | Vérifier le processus utilisant le port |
| Erreur HTTP 500       | Consulter les logs du service           |
| Erreur CORS           | Vérifier la configuration du Gateway    |
| `DB_PASSWORD not set` | Configurer la variable dans Eclipse     |
| `Failed to fetch`     | Vérifier que le Gateway est démarré     |

## 👩‍💻 Auteur

**Khawla Sidi** — [GitHub @khawla858](https://github.com/khawla858)

Projet académique — 2026.

---

⭐ Si ce projet vous intéresse, n'hésitez pas à lui donner une étoile !
