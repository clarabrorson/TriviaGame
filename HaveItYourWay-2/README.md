# TriviaGame
## En beskrivning av projektet:
+ TriviaGame är ett spel som låter en spelare svara på 10 frågor som denna själv väljer kategori och svårighetsgrad på. Spelarens resultat sparas sen i en leaderboard i databasen.


## Du behöver följande:

+ libraries, klicka på länkarna för dokumentation:
  + json-20230227.jar (https://mvnrepository.com/artifact/org.json/json/20230227)
  + sqlite-jdbc-3.32.3.8.jar (https://jar-download.com/artifacts/com.github.gotson/sqlite-jdbc/3.32.3.8/documentation)
  + commons-lang3-3.11 (https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.11)

## Javaversion:
+ Oracle openJDK 20.0.1

## Databastyp:
+ SQLite som lokalt följer med projektet.

+ Api: https://opentdb.com/
+ Ingen nyckel krävs.

## Instruktioner för att använda spelet:
+ Klona projektet på Github och starta det i Intelijej,
+ Läs in mappen och dess medföljande libraries.
+ Starta sedan programmet från Main classen.


## Spelets funktionalitet:
+ Vid uppstart kommer spelet visa en välkomst-text för att sedan visa en meny där spelaren får välja mellan att starta ett nytt spel eller skriva ut de typ 10 bästa spelarna.
+ om användaren väljer att att starta ett nytt spel kommer spelet be användaren att skriva in sitt namn.
+ spelet skriver sen först ut en lista av kategorier och sen en av svårighetsgrader som användaren får välja mellan.
+ Spelet tar sen användarens val och skickar en förfrågan till APIet som hämtar en matchande fråga och skriver ut den för användaren.
+ Användaren får sen gissa mellan sant eller falskt.
+ Spelet jämför användarens svar med svaret från APIet. om det är rätt, skrivs det ut för användaren och ett poäng  läggs till hos användaren och användaren får välja en ny kategori. Om det är fel skrivs det ut för    användaren och spelet går direkt till att välja en ny kategori.
+ Detta fortsätter tills spelaren har svarat på 10 frågor. När detta uppnåtts skickar spelet användarens namn och poäng till databasen och återgår sen till huvudmenyn.

