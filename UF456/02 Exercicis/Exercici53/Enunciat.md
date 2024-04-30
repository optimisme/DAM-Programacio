<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exerici 53

Fes una funció (calcula_comisió), que demana a un empleat que escrigui les vendes que ha realitzat.

Demanarà vendes fins que l'empleat escrigui 'fi'.

Per cada venda, es calcula la comissió següent:

* Si la venda és inferior a 1000 €, la comissió és del 5%
* Si la venda és igual o superior a 1000 € i inferior a 5000 €, la comissió és del 7%
* Si la venda és igual o superior a 5000 €, la comissió és del 10%

La funció ha de retornar:

* El nombre de vendes entrades
* La suma total
* La suma sense la comissió
* La mitjana
* La comissió total

Al final, el programa ha de mostrar:
```text
S'han entrat X vendes, amb un total de Y € i una mitjana de Z €. 
S'ha aconseguit una comissió de W €.
```

