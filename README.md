# EnigmaZadanie2
Zadanie rekrutacyjne do firmy Enigma

Aplikacja posiada dwa endpointy.

1. POST localhost:8080/geolocation - w body request'u należy
przesłać JSON z trzema polami:
{
   "deviceId" : "12345",
   "longitude" : 123,
   "latitude" : 67890
}. Endpoint ten służy do utworzenia
w bazie danych nowego obiektu. Warunkiem poprawnego zapisu 
danych do bazy jest obecność wszystkich trzech pól w body.
2. GET localhost:8080/geolocation - jest to endpoint, który
służy do pobrania wszystkich danych zapisanych przez system. 
Stowrzony głównie do testów tego pierwszego.

W projekcie została użyta baza danych H2.
Jest to baza danych in-memory i dane w niej zapisane są tracone
po wyłączeniu aplikacji.

Skompilowany jar należy uruchomić poleceniem
java -jar EnigmaZadanie2-0.0.1-SNAPSHOT.jar