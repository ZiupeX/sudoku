Najpierw trzeba zbudować maven clean install
Później odpalamy cmd i przechodzimy do folderu target gdzie maven zbudował plik jar. 
Odpalamy program używając komendy:

java -jar sudoku-1.0-SNAPSHOT.jar C:\test.csv

gdzie C:\test.csv  jest ścieżką do pliku wsadowego do programu. Źródła klas i testy są widoczne w źródle czyli folder src/main/java i src/test/java