# car-rental

# API DE GESTION DE LOCATION DE VOITURE

Le projet de logiciel de gestion pour une entreprise de location de voiture a pour objectif de fournir aux entreprises de location de voiture un outil permettant de gérer les employés, les voitures et les locations de voitures.

Le logiciel permet de réaliser les actions suivantes :

**Gestion des employés**

    # Créer, modifier et supprimer des employés

    # Enregistrer le nom, l'adresse, l'âge et le poste de chaque employé

    # Gérer les promotions d'employés

**Gestion des voitures**

    # Créer, modifier et supprimer des voitures

    # Enregistrer le numéro d'immatriculation, 
    la marque et la date d'acquisition de chaque voiture

**Gestion des clients**

    # Créer, modifier et supprimer des clients

    # Enregistrer le numéro de CIN, le nom et 
    l'adresse de chaque client

**Gestion des locations de voitures**

    # Enregistrer les locations de voitures

    # Indiquer l'employé qui a effectué la location, 
    le client qui a loué la voiture, la date de début 
    de la location et la date de fin de la location

## Architecture

Le logiciel est développé en Java avec le framework Spring Boot. Il est basé sur une architecture en couche, avec les couches suivantes :

**Couche présentation :** 
    
    Cette couche est responsable de l'interaction 
    avec l'utilisateur. Elle fournit des API RESTful 
    qui permettent aux utilisateurs d'interagir avec 
    les données du logiciel.

**Couche métier :** 

    Cette couche est responsable de la logique métier
    du logiciel. Elle fournit des services qui 
    permettent d'accéder aux données et de les manipuler.

**Couche données :** 
    
    Cette couche est responsable de la gestion des 
    données du logiciel. Elle fournit des interfaces 
    qui permettent d'accéder aux données de la base de données.

La base de données utilisée pour le stockage des données est PostgreSQL.

Le logiciel est déployé en utilisant Docker.


## API Endpoints

#### Create employee

```http
  POST /api/v1/employee/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `employee entity` | `object` | **Required**. |


#### Update employee by id

```http
  PUT /api/v1/employee/update/{employee_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee_id`      | `int` | **Required**. Id of employee to update |
| `employee entity` | `object` | **Required**. |


#### Get all employee saved

```http
  GET /api/v1/employees/
```

#### Get employee by employee_id

```http
  GET /api/v1/employee/{employee_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee_id`      | `int` | **Required**. Id of employee to get |


#### Get employee by poste

```http
  GET /api/v1/employee/all_poste/{poste}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee poste`      | `string` | **Required**. poste of employee to get |

#### Get employee by name

```http
  GET /api/v1/employee/all_name/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee name`      | `string` | **Required**. name of employee to get |

#### Delete employee by id

```http
  GET /api/v1/employee/delete/{employee_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee_id`      | `int` | **Required**. Id of employee to delete |


#### Create customer

```http
  POST /api/v1/customer/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `customer entity` | `object` | **Required**. |


#### Update customer by id

```http
  PUT /api/v1/customer/update/{customer_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customer_id`      | `int` | **Required**. Id of customer to update |
| `customer entity` | `object` | **Required**. |


#### Get all customer saved

```http
  GET /api/v1/customers/
```

#### Get customer by customer_id

```http
  GET /api/v1/customer/{customer_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customer_id`      | `int` | **Required**. Id of customer to get |

#### Get customer by customer CIN

```http
  GET /api/v1/customer/get_cin/{cin}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customer cin`      | `string` | **Required**. CIN of customer to get |

#### Get customer by customer name

```http
  GET /api/v1/customer/all_name/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customer cin`      | `string` | **Required**. Name of customer to get |

#### Delete customer by customer customer_id

```http
  GET /api/v1/customer/delete/{customer_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `customer_id`      | `string` | **Required**. Id of customer to delete |


#### Create car

```http
  POST /api/v1/car/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `car entity` | `object` | **Required**. |


#### Update car by car_id

```http
  PUT /api/v1/car/update/{car_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `car_id`      | `int` | **Required**. Id of car to update |
| `car entity` | `object` | **Required**. |


#### Get all car saved

```http
  GET /api/v1/cars/
```

#### Get car by car_id

```http
  GET /api/v1/car/{car_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `car_id`      | `int` | **Required**. Id of car to get |

#### Get car by car immatriculation

```http
  GET /api/v1/car/get_immatriculation/{immatriculation}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `car immatriculation`      | `string` | **Required**. Immatriculation of car to get |

#### Get car by ar marque

```http
  GET /api/v1/car/all_cars_marque/{marque}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `car marque`      | `string` | **Required**. Marque of car to get |

#### Delete car by car_id

```http
  GET /api/v1/car/delete/{car_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `car_id`      | `int` | **Required**. Id of car to delete |


#### Create rental

```http
  POST /api/v1/rental/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `rental entity` | `object` | **Required**. |


#### Update rental by rental_id

```http
  PUT /api/v1/rental/update/{rental_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `rental_id`      | `int` | **Required**. Id of rental to update |
| `rental entity` | `object` | **Required**. |


#### Get all rental saved

```http
  GET /api/v1/rentals/
```

#### Get rental by rental_id

```http
  GET /api/v1/rental/{rental_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `rental_id`      | `int` | **Required**. Id of rental to get |

#### Get rental by rental status

```http
  GET /api/v1/rental/get_status/{status}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `rental status`      | `string` | **Required**. Status of rental to get |

#### Delete rental by rental_id

```http
  GET /api/v1/car/delete/{car_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `rental_id`      | `int` | **Required**. Id of rental to delete |


## Diagramme de classes-entités

Entités

Le diagramme de classes-entités comporte les classes suivantes :

**Employé :** `Cette classe représente un employé de l'entreprise de location de voiture. Elle a les propriétés suivantes :`

    id : L'identifiant de l'employé
    nom : Le nom de l'employé
    adresse : L'adresse de l'employé
    age : L'âge de l'employé
    poste : Le poste de l'employé

**Voiture :** `Cette classe représente une voiture de l'entreprise de location de voiture. Elle a les propriétés suivantes :`

    id : L'identifiant de la voiture
    immatriculation : La plaque d'immatriculation de la voiture
    marque : La marque de la voiture
    dateAcquisition : La date d'acquisition de la voiture

**Client :** `Cette classe représente un client de l'entreprise de location de voiture. Elle a les propriétés suivantes :`

    id : L'identifiant du client
    cin : Le numéro de CIN du client
    nom : Le nom du client
    adresse : L'adresse du client

**Location :** `Cette classe représente une location de voiture. Elle a les propriétés suivantes :`

    id : L'identifiant de la location
    employe : L'employé qui a effectué la location
    client : Le client qui a loué la voiture
    dateDebut : La date de début de la location
    dateFin : La date de fin de la location

Relations

Les classes `Employé` et `Location` ont une relation `un-à-plusieurs`. Cela signifie qu'un employé peut effectuer plusieurs locations, mais qu'une location ne peut être effectuée que par un seul employé.

Les classes `Voiture` et `Location` ont également une relation `un-à-plusieurs`. Cela signifie qu'une voiture peut être louée plusieurs fois, mais qu'une location ne peut concerner qu'une seule voiture.

Les classes `Client` et `Location` ont enfin une relation `un-à-un`. Cela signifie qu'un client ne peut effectuer qu'une seule location à la fois, et qu'une location ne peut concerner qu'un seul client.

## Panorama des outils et technologies

**Langage de programmation**

Le langage de programmation utilisé pour le développement du logiciel est Java. Java est un langage de programmation orienté objet, robuste et portable. Il est largement utilisé dans le développement d'applications web, mobiles et d'entreprise.

**IDE**

L'IDE utilisé pour le développement du logiciel est Visual Studio Code. Visual Studio Code est un IDE open source et gratuit, disponible sur toutes les plateformes. Il est léger et facile à utiliser.

**Framework**

Le framework utilisé pour le développement du logiciel est Spring Boot. Spring Boot est un framework Java léger et facile à apprendre. Il fournit des fonctionnalités de développement web prêtes à l'emploi.

**Base de données**

La base de données utilisée pour le stockage des données est PostgreSQL. PostgreSQL est une base de données relationnelle open source. Elle est largement utilisée pour le développement d'applications web et d'entreprise.

**Technologies supplémentaires**

Les technologies supplémentaires suivantes ont également été utilisées pour le développement du logiciel :

**Lombok :** Une bibliothèque Java qui permet de générer automatiquement du code boilerplate.

**Spring Web :** Une bibliothèque Spring Boot qui fournit des fonctionnalités pour le développement d'applications web.

**JPA :** Une API Java pour l'accès aux données relationnelles.

**Swagger-UI :** Une bibliothèque Spring Boot qui permet de générer une documentation API interactive.

**Justification des choix effectués**

Le choix de Java comme langage de programmation a été effectué pour les raisons suivantes : `Java est un langage de programmation robuste et portable.
Java est largement utilisé dans le développement d'applications web, mobiles et d'entreprise.`

Le choix de Visual Studio Code comme IDE a été effectué pour les raisons suivantes : `Visual Studio Code est un IDE open source et gratuit, disponible sur toutes les plateformes.
Visual Studio Code est léger et facile à utiliser.`

Le choix de Spring Boot comme framework a été effectué pour les raisons suivantes : `Spring Boot est un framework Java léger et facile à apprendre.
Spring Boot fournit des fonctionnalités de développement web prêtes à l'emploi.`

Le choix de PostgreSQL comme base de données a été effectué pour les raisons suivantes : `PostgreSQL est une base de données relationnelle open source.
PostgreSQL est largement utilisée pour le développement d'applications web et d'entreprise.`

Le choix de Lombok comme bibliothèque a été effectué pour les raisons suivantes : `Lombok permet de générer automatiquement 
du code boilerplate, ce qui permet de gagner du temps et des efforts.`

Le choix de Spring Web comme bibliothèque a été effectué 
pour les raisons suivantes : `Spring Web fournit des fonctionnalités pour le développement d'applications web, 
telles que la gestion des requêtes HTTP et la génération de réponses.`

Le choix de JPA comme API a été effectué pour les raisons suivantes : `JPA fournit une API Java pour l'accès aux 
données relationnelles, ce qui simplifie le développement 
des applications Java.`

Le choix de Swagger-UI comme bibliothèque a été effectué pour les raisons suivantes : `Swagger-UI permet de générer une documentation API interactive, ce qui facilite 
l'utilisation de l'API du logiciel.`

## Documentation

La documentation API du logiciel est disponible à l'adresse suivante :

[Documentation en local](http://localhost:8085/swagger-ui/index.html#/)


## Démarrer le projet

Pour démarrer le logiciel, procédez comme suit :

1. Clonez le dépôt Git sur votre ordinateur.

2. Ouvrez le projet dans votre IDE Java préféré.

3. Exécutez la commande suivante :

```docker build -t car_rental:0.0.1-SNAPSHOT .```

Le logiciel sera alors démarré sur le port 8085.

