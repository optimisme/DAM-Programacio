<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 68

Fes una funció, que escrigui la informació de la matriu  d'arrays 'inventari_neteja' separada per categories.

Potser necessites funcions auxiliars per:
- Obtenir una llista amb totes les categories
- Esriure la informació dels elements d'una determinada categoria

Exemple:
```python
Categoria 'Casa':
- Detergent, 5.99
- Esprai netejador, 3.49
...
Categoria 'Personal':
- Xampú, 4.99
...
```

Prova-ho amb:

```java
Object[][] inventariNetja = {
    {"Detergent", "Casa", 5.99},
    {"Netejador d'interiors", "Automoció", 7.99},
    {"Tovalloles de paper", "Casa", 2.99},
    {"Paper higiènic de luxe", "Personal", 7.99},
    {"Netejador de vidres", "Casa", 4.79},
    {"Aspiradora", "Casa", 29.69},
    {"Cera de cotxes", "Automoció", 8.49},
    {"Tovalloletes netejadores", "Personal", 6.29},
    {"Xampú per al cos", "Personal", 4.99},
    {"Sabó de mans líquid", "Personal", 2.49},
    {"Esprai netejador", "Casa", 3.49},
    {"Estopa de cotxes", "Automoció", 1.99},
};
```

**Nota**: Fixa't que 'Object' ens permet guardar dades genèriques en un array (en aquest cas un array d'arrays)

