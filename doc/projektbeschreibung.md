# Projekt M151

## Um was geht es in meinem Projekt?
Ich habe mich dazu entschieden einen Schuhladen für mein Projekt zu machen. In meiner Applikation soll es dann möglich sein Schuhe zu kaufen,
Schuhe upzudaten und die neusten Schuhen vom Markt hinzuzufügen.

## Wer sind meine Personengruppen?
Person | Kurzbeschreibung |
-------- | -------- |
Filialleiter (Admin)   | Kann neue Schuhe hinzufügen und entfernen   | 
Mitarbeiter   | Kann Schuhe abfragen und updaten   |
Käufer (User)   | Kann alle Schuhe ansehen und kaufen    |

**Wichtig:**  Die Berechtigungen von meinen Personengruppen sind hierarchisch aufgebaut, das heisst der Filialleiter kann das selbe wie die ihm unterstellten Rollen, das gleiche gillt auch für den Mitarbeiter. 

## Wie soll die Applikation von den User genutzt werden? (Use Case)
 Priorität | Beschreibung |
-------- | -------- |
Inhalt   | Als Filialleiter möchte ich neue Schuhe dem Sortiment hinzufügen, um das Sortiment des Ladens zu vergrössern.   | 
Inhalt   | Als Filialleiter möchte ich Schuhe aus dem Sortiment entfernen, um das Sortiment zu verkleinern um Platz für neue Schuhe zu machen.   | 
Inhalt   | Als Mitarbeiter möchte ich einen Schuh aktualiesieren können, um denn Lagerbestand auf dem neusten Stand zu halten   | 
Inhalt   | Als Mitarbeiter möchte ich einen Schuh aktualiesieren können, um denn Preis anzupassen   | 
Inhalt   | Als Mitarbeiter möchte ich einen oder mehrere Schuhe abfragen können, um zu sehen wieviele Stücke noch an Lager sind.   | 
Inhalt   | Als Käufer möchte ich mir alle Schuhe im Sortiment ansehen können, um zu sehen was alles zur verfügung steht. | 
Inhalt   | Als Käufer möchte ich mir einen Schuh im Detail ansehen können, um mehr Information über dieses Modell zu erhalten. | 
Inhalt   | Als Käufer möchte ich mir einen Schuh kaufen können, um diesen dann später anziehen zu können. | 

## Welche Technologien werden eingesetzt?
Meine Auswahl für die Programmiersprache ist auf Java gefallen, da wir im Geschäft auch Java einsetzten ich aber noch nicht dazu gekommen bin dies zu verwenden. Darum dachte ich das es eine gute Übung were es mit Java zu machen. Als Framwork um die Verbindung der Datenbank zu gewährleisten werde ich Spring verwenden. Für das Chaching-System werde ich Redis anwenden.
