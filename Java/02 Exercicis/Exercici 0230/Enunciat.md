<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 30

Fes una funció (calcula_irpf) que calculi l'IRPF que ha de pagar una persona segons els ingressos bruts que té.

Si et cal, fes altres funcions de suport a aquesta funció principal. Sigues organitzat/da!

Aquests són els trams que ha de tenir en compte:
```text
                | Trams IRPF            |Total|
                |-----------------------|-----|
                | De 0 a 12.450€        | 19% |
                | De 12.450€ a 20.200€  | 24% |
                | De 20.200€ a 35.200€  | 30% |
                | De 35.200€ a 60.000€  | 37% |
                | De 60.000€ a 300.000€ | 45% |
                | Més de 300.000€       | 47% |
```
Per exemple:

* Si una persona cobra 10.200€, hauria de pagar el 19% = 1.938€
```text
+   0,19 *   10.200€           = 1.938,0€
                               ----------
                         Total:  1.938,0€
```
* Si una persona cobra 15.000€, hauria de pagar:
```text
    0,24 * (15.000€ - 12.450€) =   606,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  2.971,5€
```
* Si una persona cobra 22.000€, hauria de pagar:
```text
    0,3  * (22.000€ - 20.200€) =   540,0€
    0,24 * (20.200€ - 12.450€) = 1.860,0€
+   0,19 *  12.450€            = 2.365,5€
                               ----------
                         Total:  4.765,5€
```
Comprova:
```text
        * 7600 => 1444.0
        * 16000 => 3217.5
        * 26000 => 5965.5
        * 32000 => 7765.5
        * 54500 => 15866.5
        * 64832 => 20075.9
        * 275387 => 114825.65
        * 765915 => 349540.69
```

