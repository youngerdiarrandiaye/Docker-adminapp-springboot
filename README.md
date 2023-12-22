[![work status](https://img.shields.io/badge/work-on%20progress-red.svg)](https://img.shields.io/badge/Youssou%20Diarra%20work-blue
)
# Documentation

# admin-app
Mapping - services -dtos -execptions -config

## Prérequis

Assurez-vous d'avoir installé les logiciels suivants avant de commencer :

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Configuration

Assurez-vous de configurer les variables d'environnement nécessaires dans le fichier `.env`. Utilisez le fichier `.env.example` comme modèle.

```plaintext
MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=admin_app_db
MYSQL_USER=user
MYSQL_PASSWORD=user

Clonez ce dépôt sur votre machine locale.
git clone https://github.com/youngerdiarrandiaye/Docker-adminapp-springboot.git

Lancez les conteneurs Docker avec la commande suivante :
docker-compose up -d

phpMyAdmin:

Accédez à http://localhost:8085/ dans votre navigateur.
Utilisateur: user
Mot de passe: user
