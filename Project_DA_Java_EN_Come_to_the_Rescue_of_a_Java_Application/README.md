# Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application

HemeBiotech Analytics
=====================

HemeBiotech Analytics est une application Java permettant de compter les occurrences des symptômes médicaux et de les enregistrer dans un fichier de sortie.

Installation
------------

1.  Cloner le repository sur votre machine locale.
2.  Ouvrir le projet dans votre environnement de développement Java préféré.

Utilisation
-----------

### Comptage des symptômes

L'application compte les occurrences des symptômes à partir d'un fichier d'entrée contenant une liste de symptômes, un symptôme par ligne. Pour cela, elle utilise les classes suivantes :

*   `ReadSymptomDataFromFile` : Cette classe lit les symptômes à partir d'un fichier d'entrée.
*   `AnalyticsCounter` : Cette classe compte les occurrences des symptômes en utilisant une `TreehMap`.
*   `WriteSymptomDataToFile` : Cette classe écrit les symptômes et leurs occurrences dans un fichier de sortie.

### Exécution de l'application

Pour exécuter l'application, utilisez la classe `AnalyticsCounter` avec les arguments appropriés :

bash

`java com.hemebiotech.analytics.AnalyticsCounter`

