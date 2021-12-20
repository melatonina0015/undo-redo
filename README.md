Aplikacja implementuje mechanizm undo-redo dla prostego Systemu Manipulowania Kwadratami. 
Rozwiązanie korzysta ze wzorca projektowego polecenie (command).

Program wczytuje dane wejściowe jako kolejne linie ze standardowego wejścia.
Linia może mieć następujące formy (i, j, j są nieujemnymi liczbami całkowitymi):

- C i j
- M i j k
- S i j
- U
- R
- P

Program zakłada, że dane wejściowe są poprawne (walidacja danych wejściowych i obsługa błędów nie została zaimplementowana).

- Komenda C (Create) tworzy kwadrat o numerze i i długości krawędzi j, którego środek znajduje się w punkcie (0,0). Zastępuje on wcześniejszy kwadrat o numerze i (jeżeli taki istnieje).
- Komenda M (Move) przenosi kwadrat numer i o j pikseli w prawo i k pikseli w górę. Jeżeli nie ma kwadratu o numerze i to komenda niczego nie robi.
- Komenda S (Scale) zwiększa wielkość kwadratu i j razy. Jeżeli nie ma kwadratu o numerze i to komenda niczego nie robi.
- Komenda U (Undo) anuluje ostatnią jeszcze nie anulowaną komendę C, M albo S. Jeżeli nie ma komendy którą można anulować to komenda U niczego nie robi.
- Komenda R (Redo) działa jedynie jeżeli ostatnią wykonaną komendą jest U albo R, w przeciwnym przypadku komenda niczego nie robi. Komenda to wykonuje ponownie ostatnią anulowaną (i nie wykonaną ponownie z użyciem R) komendę C, M albo S.
- Komenda P (Print) wypisuje na standardowe wyjście informacje o wszystkich kwadratach w systemie. Kwadraty wypisane są wg rosnącego identyfikatora i, każdy w osobnej linii, gdzie każda linia ma następujący format:
i j k l
i - identyfikator kwadratu
j - współrzędna x
k - współrzędna y
l - długość krawędzi
Wartości są oddzielone spacjami.

