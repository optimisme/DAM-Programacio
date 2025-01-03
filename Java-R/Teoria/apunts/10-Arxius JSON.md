<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Arxius JSON

Els arxius .json (JavaScript Object Notation) són un tipus d'arxius que permeten guardar dades basades en text. 

És un format fàcil de llegir tant per humans com per màquines. 

## Estructura

L'estructura basada en claus i valors:

```json
{
    "nom": "Eirik",
    "edat": 20,
    "estudis": ["CFGS DAM", "CFGM SMX"],
    "treballa": true,
    "adreça": {
        "carrer": "Carrer de la Llibertat",
        "ciutat": "Cornellà"
    }
}
```

**Nota**: En aquest exemple l'arrel és de tipus diccionari entre **{}** (claus), però podria ser una llista entre **[]** (claudàtors).

En els arxius *".json"*:

- Les **claus** són sempre cadenes (strings) entre " (cometes dobles).
- Els **valors** poden ser cadenes, nombres, booleans, llistes, altres diccionaris ...

**Important**: Com que l'esctructura és del tipus *clau/valor*:

- Les claus han de ser úniques.
- Les claus poden estar desordenades quan es guarda l'arxiu.

## Avantatges

- **Simplicitat**: Molt fàcil de llegir i escriure manualment.
- **Compatibilitat**: Suport extens en gairebé totes les biblioteques i llenguatges.
- **Legibilitat**: Fàcilment interpretable pels humans.
- **Flexibilitat**: Permet estructurar dades jeràrquiques.

# JSON a Java

Per poder fer servir arxius JSON a Java necessitem una llibreria que ens permeti llegir i escriure aquests arxius. En el nostre cas:

```java
import org.json.JSONArray;
import org.json.JSONObject;
```

## JSONArray

Els **JSONArray** són llistes on cada posició pot tenir un tipus de dades diferent:

```json
["hola", 3, false, 4.5]
```

Per obtenir cada un dels elements de l'array a partir del seu índex, cal indicar el tipus de dades que hi ha guardada en aquella posició:

```java
    String jsonData = "[\"hola\", 3, false, 4.5]";

    // Convertir la cadena JSON a un JSONArray
    JSONArray jsonArray = new JSONArray(jsonData);

    // Obtenir els valors per índex
    String text = jsonArray.getString(0);   
    int number = jsonArray.getInt(1);
    boolean flag = jsonArray.getBoolean(2);
    double decimal = jsonArray.getDouble(3);
```

Per modificar un **JSONArray** podem:

- **.put(valor)**: Afegir o modificar una clau del diccionari.
- **.put(index, valor)**: Modificar un element de la llista.
- **.remove(index)**: Borrar un element de la llista.

```java
    JSONArray jsonArray = new JSONArray();

    // Afegir elements
    jsonArray.put("hola");  // Índex 0
    jsonArray.put(3.14);    // Índex 1
    jsonArray.put(false);   // Índex 2

    // Modificar un element existent
    jsonArray.put(1, 6.28); // Modifica l'índex 1 per 6.28

    // Eliminar un element
    jsonArray.remove(0);    // Elimina l'índex 0

    // Imprimir el JSONArray resultant
    System.out.println(jsonArray);
```

## JSONObject

Els **JSONObject** són diccionaris on cada *clau* té dades de diferent tipus:

```java
    String jsonData = """
    {
        "nom": "Eirik",
        "edat": 20,
        "estudis": ["CFGS DAM", "CFGM SMX"],
        "treballa": true,
        "adreça": {
            "carrer": "Carrer de la Llibertat",
            "ciutat": "Cornellà"
        }
    }
    """;

    // Convertir la cadena JSON a un JSONObject
    JSONObject jsonObject = new JSONObject(jsonData);

    // Obtenir valors per clau
    String nom = jsonObject.getString("nom");
    int edat = jsonObject.getInt("edat");
    boolean treballa = jsonObject.getBoolean("treballa");

    // Obtenir un array de JSON
    JSONArray estudis = jsonObject.getJSONArray("estudis");

    // Obtenir un objecte aniuat
    JSONObject adreça = jsonObject.getJSONObject("adreça");
    String carrer = adreça.getString("carrer");
    String ciutat = adreça.getString("ciutat");
```

Per modificar un **JSONArray** podem:

- **.put("clau", valor)**: Afegir o modificar una clau del diccionari.
- **.remove("clau")**: Borrar una clau i el seu valor del diccionari.

```java
    JSONObject jsonObject = new JSONObject();

    // Afegir claus
    jsonObject.put("nom", "Eirik");   // Afegeix la clau "nom"
    jsonObject.put("edat", 20);       // Afegeix la clau "edat"
    jsonObject.put("treballa", true); // Afegeix la clau "treballa"

    System.out.println("JSON inicial: " + jsonObject);

    // Modificar una clau existent
    jsonObject.put("edat", 25); // Modifica el valor de la clau "edat"
    System.out.println("Després de modificar 'edat': " + jsonObject);

    // Eliminar una clau
    jsonObject.remove("treballa"); // Elimina la clau "treballa"
    System.out.println("Després d'eliminar 'treballa': " + jsonObject);
```

## Lectura d'arxius

Ubicarem els arxius *".json"* dins del propi projecte:

```text
    Java-R/Teoria/data/list.json
```

I els llegirem així:

```java
    String filePath = "./data/list.json";
    String content = new String(Files.readAllBytes(Paths.get(filePath)));>
```

Cal indicar a **Java** el tipus de dades que va llegint, en el nostre cas l'arxiu *".json"* té com a element principal una llista **[]**, per tant farem servir **JSONArray** (si tingués un objecte faríem servir **JSONObject**).

Un cop tenim el contingut de l'arxiu en una cadena *"String"*, farem la conversió a **JSONArray**:

```java
    JSONArray jsonArray = new JSONArray(content);
```

**Exemple de lectura d'arxius JSON:**

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1000.Main
```

## Escriptura d'arxius

Per modificar un arxiu JSON ja existent i guardar-lo amb informació actualitzada:

```java
    String filePath = "./data/list.json";

    // Format JSON amb 4 espais d'indentació
    Files.write(Paths.get(filePath), jsonArray.toString(4).getBytes());
```

**Exemple de lectura, modificació i escriptura d'arxius JSON:**

```bash
# Fes anar l'exemple amb
./run.sh com.exemple1001.Main
```