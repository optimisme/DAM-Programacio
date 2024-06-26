<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 35

Estàs organitzant festes d'aniversari i oferixes diferents paquets segons les necessitats del client. 

Necessites una funció (calcula_festa) que determini el cost total d'una festa segons el nombre de convidats, el lloc on es realitzarà la festa, si es vol menjar inclòs i si volen entreteniment en directe.

Les tarifes són:

Lloc:
```text
Sala estàndard: 100€.
Jardí amb piscina: 200€.
Saló gran amb escenari: 500€.
Menjar per convidat:

Menú bàsic: 15€.
Menú premium: 30€.
Entreteniment:

Màgia: 250€.
Música en directe: 500€.
```

La funció hauria d'acceptar els següents paràmetres: 
```text
* tipus de lloc
* nombre de convidats
* tipus de menjar
* tipus d'entreteniment
```

A més, ofereixes les següents promocions:
```text
Si contracten música en directe per la sala gran amb escenari, tenen un descompte de 100€ en l'entreteniment.
Si més de 50 persones assisteixen a la festa, ofereixes un 5% de descompte en el menjar.
```

Només es pot contractar una sala, però es pot contractar diversos entreteniments.

Et pot anar bé definir primer les següents funcions:
* calcula_cost_lloc(tipus_lloc)
* calcula_cost_menjar(tipus_menjar, num_convidats)
* calcula_cost_entreteniment(tipus_entreteniment)

Per exemple:
* Sala estàndard, 20 convidats amb menú bàsic, sense entreteniment: 100€ + (15€ * 20) = 400€.
* Jardí amb piscina, 60 convidats amb menú premium, màgia com a entreteniment: 200€ + [(30€ * 60) - 5%] + 250€ = 2.150€.
* Si et cal, crea funcions auxiliars per a calcula_festa. Sigues organitzat/da!

Exemples per comprovar:
* Jardí amb piscina, 40 convidats, menú bàsic, música en directe: 1.300€
* Saló gran amb escenari, 70 convidats, menú premium, música en directe (amb descompte): 2.895€
* Sala estàndard, 15 convidats, menú premium, màgia: 800€


Exemple
```text
Jardí amb piscina, 40 convidats, menú bàsic, música en directe: 1300,00€
Saló gran amb escenari, 70 convidats, menú premium, música en directe: 2895,00€
Sala estàndard, 15 convidats, menú premium, màgia: 800,00€
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
