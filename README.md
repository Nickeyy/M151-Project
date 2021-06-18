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
1. Postman benutzen (Für dass das Postman export File im Ordner `postman` verwenden)
2. Es ist bereits beim Start ein Benutzer erstellt. (Username: `NickD` Passwort: `test`)

### Postman Beispiele
Die Beispiele laufen alle über den Port ````8080````, welcher aber noch angepasst werden kann.
Einige Calls sind nur als Admin verfügbar.
<br><br>
Alle Beispiele sind im Postman File im `Postman` Ordner. Einfach in Postman importieren und man ist bereit
das Program zu benutzen.