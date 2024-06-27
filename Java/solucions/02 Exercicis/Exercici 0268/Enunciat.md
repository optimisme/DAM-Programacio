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
- Obtenir una llista amb totes les categories ordenades alfabèticament
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

Fes les funcions:
```java

    public static void escriuInformacioPerCategories(Object[][] inventari) {
    // Mostra la informació amb les categories ordenades alfabèticament
    }

    public static Map<String, List<Object[]>> obtenirCategories(Object[][] inventari) {
    // Retorna les categories de l'inventari
    }

    public static void escriuElementsCategoria(List<Object[]> elements) {
    // Mostra per pantalla els elements de la categoria tipus: "- " + element[0] + ", " + element[2]
    }
```

Exemple:
```text
Categoria 'Automoció':
- Netejador d'interiors, 7.99
- Cera de cotxes, 8.49
- Estopa de cotxes, 1.99
Categoria 'Casa':
- Detergent, 5.99
- Tovalloles de paper, 2.99
- Netejador de vidres, 4.79
- Aspiradora, 29.69
- Esprai netejador, 3.49
Categoria 'Personal':
- Paper higiènic de luxe, 7.99
- Tovalloletes netejadores, 6.29
- Xampú per al cos, 4.99
- Sabó de mans líquid, 2.49
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
