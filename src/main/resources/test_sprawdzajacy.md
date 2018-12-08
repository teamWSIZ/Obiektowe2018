## Aplikacja do rezerwowania aliasów

* Rezerwacja aliasu "karramba":
http://localhost:8443/alias/new?alias=karramba

--> zwraca:
sukces:

```
{
    id:7,
    alias:karramba
}
```

błąd (jeśli nowy alias już istnieje w systemie):
```
{
   id:-1,
   alias:
}
```


* Odczytanie aliasu o id=7
http://localhost:8443/alias/byid?id=7

(błąd jeśli nie ma aliasu o takim id)

* Odczytanie aliasu o alias=karramba
http://localhost:8443/alias/byalias?alias=karramba

(błąd jeśli nie ma aliasu o takim "alias")


* Odczytanie wszystkich aliasów
http://localhost:8443/alias

--> zwraca wszystkie aliasy
```
[
{id:7,alias:karramba},
{id:8,alias:karramba1},
{id:9,alias:karrambaX}
]
```
* Liczba zapisanych aliasów

http://localhost:8443/alias/count


* Usuwanie aliasu "karramba"

http://localhost:8443/alias/delete?alias=karramba





### Użyty markdown, .md

https://www.markdownguide.org/cheat-sheet/
