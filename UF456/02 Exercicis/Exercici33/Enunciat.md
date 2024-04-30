<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 33

Un cinema ofereix diferents tarifes segons l'edat del client i el dia de la setmana. 

Escriu una funció (calcula_entrada) que determini el preu de l'entrada d'una persona segons la seva edat i el dia que vol anar al cinema.

Els preus són:
```text
Preu estàndard: 10€
Nens (menors de 12 anys): 5€
Gent gran (65 anys o més): 6€
Dimarts (Dia del client): Totes les entrades tenen un descompte del 20%.
Dijous (Dia familiar): Si un adult compra una entrada, l'entrada del primer nen té un 50% de descompte els altres nens no paguen.
```

Els paràmetres de la funció són: 
```text
* Número d'adults
* Número de nens
* Número de persones grans
* Dia
```

No feu inputs, feu servir la funció amb els valors d'exemple i un print per cada cas.

Per exemple:
* Un nen que va al cinema un dimarts: 5€ - 20% = 4€.
* Un adult que va al cinema amb un nen un dijous: L'adult paga 10€ i el nen paga 2,50€ (50% de descompte sobre 5€).
* Un adult que va al cinema amb tres nens un dijous: L'adult paga 10€, el primer nen paga 2,50€, els altres res.
* Si et cal, fes altres funcions de suport per a calcula_entrada. Sigues organitzat/da!

Exemples per comprovar:
* Adult un dilluns: 10€
* Nen un dimarts: 4€
* Gent gran un dijous: 6€ (El descompte del dia familiar només s'aplica als nens)
* Adult i nen un dijous: 10€ + 2,50€ = 12,50€

