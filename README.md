# M151-Project
Folgende Anleitung zeigt Schritt für Schritt wie man mein M151 Projekt inbetrieb nimmt. 

### Installationen

1. Java (JDK 11)
2. Editor (wie zum Beispiel IntelliJ)
3. Postman für das Aufrufen der Endpunkte
4. Docker

### Setup Guide
Es wird vorausgesetzt dass das Repository bereits gecloned ist. Und dem User ist bekannt wo dieses Repository
abgespeichert ist.

#### Docker
1. Terminal starten
2. Ins Docker Verzeichniss wechseln ````cd Docker;````
3. Docker starten ````docker-compose up;````
4. Browser öffnen und auf ``localhost:5050`` wechseln.

#### Endpunkte erreichen
1. Postman starten

### Postman Beispiele
Die Beispiele laufen alle über den Port ````8080````, welcher aber noch angepasst werden kann.
Einige Calls sind nur als Admin verfügbar.


```GET``` call für alle Schuhe: ```http://localhost:8080/shoe/``` <br>
``DELETE`` call für Schuh löschen: ```http://localhost:8080/shoe/1``` (nur als Admin möglich) <br>
```POST``` call für neuen Schuh erstellen: ```http://localhost:8080/shoe/``` (nur als Admin möglich) <br><br>

Konstrukt für neuen Schuh:

    {
       "price": {
           "price": 768.68
       },
       "name": "Jordan 1 Union",
       "size": "45",
       "realse_date": "2021-06-07",
       "inventory": 23
    }
    