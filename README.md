# WeatherApp

## Description de l'application
Application Java EE permettant d'obtenir les informations météo (température, vitesse du vent, ressenti et autre) de la ville saisie.\
L'application utilise l'API **OpenWeathermap.org** afin d'obtenir les informations (sous format JSON) sur la ville saisie dans barre de recherche.

## Packages de l'application
  - `UOM` : contient les classes définissant les unités de mesures utilisées dans les autres classes
  - `datatype` : contient les Datatypes utilisées par les classes de l'application
  - `beans` : contient les classes permettant la connexion à l'API et effectuant les requêtes JSON
  - `exceptions` : contient les différentes exceptions appelées par les classes
  - `servlets` : contient la classe principale faisant office de controleur
  
## Dossier **WEB-INF**
  - `accueil.jsp` gérant l'affichage des données recueillies
  - `web.xml` qui défini le mapping des différentes URL de l'application
 
## Librairies utilisées
  - `org.json` : traiter les objets JSON de l'application
  - `bootstrap` : mettre en forme la page `accueil.jsp`

L'application fonctionne sur un serveur local **Apache Tomcat**
  
    
