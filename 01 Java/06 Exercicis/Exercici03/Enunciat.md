<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 3

Crear un sistema que permeti processar diferents tipus de pagaments, com pagaments en efectiu, amb targeta de crèdit i pagaments digitals. Cada tipus de pagament tindrà el seu propi conjunt de propietats i mètodes específics, però tots compartiran una estructura bàsica definida per una interfície.

Interfície **Pagable**:

Defineix el mètode processarPagament() que no retorna cap valor.

Interfície **Autoritzable** hereta de Pagable:

Afegeix un mètode autoritzarPagament() que també és sense retorn.

Classe **PagamentEfectiu** implementa Pagable:

Implementa el mètode processarPagament() imprimint un missatge que indiqui que el pagament en efectiu ha estat processat.

Classe **PagamentTargeta** implementa Autoritzable:

Implementa els mètodes processarPagament() i autoritzarPagament(), imprimint missatges que indiquin que el pagament amb targeta ha estat autoritzat i processat, respectivament.

Classe **PagamentDigital** implementa Autoritzable:

Implementa els mètodes processarPagament() i autoritzarPagament(), amb missatges específics per a pagaments digitals.

La crida d'aquesta funció 'main':

```java
public static void main(String[] args) {
    PagamentEfectiu pagamentEfectiu = new PagamentEfectiu();
    PagamentTargeta pagamentTargeta = new PagamentTargeta();
    PagamentDigital pagamentDigital = new PagamentDigital();

    // Processar un pagament en efectiu
    System.out.println("Processant un pagament en efectiu:");
    pagamentEfectiu.processarPagament();

    // Processar un pagament amb targeta
    System.out.println("\nProcessant un pagament amb targeta:");
    pagamentTargeta.autoritzarPagament();
    pagamentTargeta.processarPagament();

    // Processar un pagament digital
    System.out.println("\nProcessant un pagament digital:");
    pagamentDigital.autoritzarPagament();
    pagamentDigital.processarPagament();
}
```

Ha de donar:

```text
Processant un pagament en efectiu:
El pagament en efectiu ha estat processat.

Processant un pagament amb targeta:
El pagament amb targeta ha estat autoritzat.
El pagament amb targeta ha estat processat.

Processant un pagament digital:
El pagament digital ha estat autoritzat.
El pagament digital ha estat processat.
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainValidation
```

