# Base de dades MySQL i Docker

Cal instal·lar la base de dates 'dbNatura.sql' en un servidor MySQL.

## Instal·lar base de dades MySQL

Per posar 'dbNatura.sql' en un servidor MySQL amb Docker, amb la comanda 'docker' disponible i el servei 'Docker' funcionant:

A Linux i macOS:
```bash
docker pull mysql
docker run --name mysqlServer -p 3308:3306 -e MYSQL_ROOT_PASSWORD=pwd -d mysql
docker exec -i mysqlServer mysql -uroot -ppwd < dbNatura.sql
```

A Windows:
```bash
docker pull mysql
docker run --name mysqlServer -p 3308:3306 -e MYSQL_ROOT_PASSWORD=pwd -d mysql
type dbNatura.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

Amb la configuració anterior, s'accedeix al servidor MySQL del contenedor Docker, a través de:

* Usuari 'root'
* Constrasenya 'pwd'
* Port '3308'

Així, per veure les taules de la base de dades anterior des de la linia de comandes, des de 'docker exec' que executa comandes dins del terminal d'aquest contenedor Docker:

```bash
docker exec -it mysqlServer mysql -uroot -ppwd -e "USE natura; SHOW TABLES;"
```

Per veure els continguts de la taula 'city':

```bash
docker exec -it mysqlServer mysql -uroot -ppwd -e "USE natura; SELECT * FROM paisos LIMIT 0,10;"
```

En canvi, per veure les taules de la base de dades anterior des de la linia de comandes, des de 'mysql' al port 3308:

```bash
mysql -h 127.0.0.1 -P 3308 -uroot -ppwd
```

Després des d'aquesta consola MySQL:
```SQL
USE natura;
SHOW TABLES;
EXIT;
```

Per veure els continguts de la taula 'city':

```bash
mysql -h 127.0.0.1 -P 3308 -uroot -ppwd
```

Després des d'aquesta consola MySQL:
```SQL
USE natura;
SELECT * FROM paisos LIMIT 0,10;
EXIT;
```

