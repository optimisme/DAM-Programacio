<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 24

Fes un programa que demani una xifra a l'usuari entre 0 i 100.000

El programa ha de dir: "Per un import de X, els impostos que has de pagar són un Y% i el total és Z"

Aleshores:

- Si el valor és menor a 10.000 calcularà un 10% del valor. (Y serà 10% i Z el resultat del càlcul)

- Si el valor està entre 10.001 i 50.000 calcularà un 20% del valor. (Y serà 20% i Z el resultat del càlcul)

- Si el valor és superior a 50.000 calcularà un 30% del valor (Y serà 30% i Z el resultat del càlcul)

Recorda que Z ha de tornar el total a pagar, és a dir els impostos més el valor inicial.

Exemple:
```text
Introdueix una xifra entre 0 i 100.000: 34
Per un import de 34, els impostos que has de pagar són un 10% i el total és 37,40
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```