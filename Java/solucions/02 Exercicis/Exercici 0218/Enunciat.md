<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 18

Un anagrama és un text, que passat a minúscules i ordenant els seus caràcters, és igual a un altre.

Per exemple:
```text
Mare i Rema
Porta i Tropa
Triangle i Integral
Sopa i Posa
```
Fes una funció anomenada "son_anagrama" que accepta dues paraules d'entrada, i retorna "True" o "False" segons si són anagrames.

Per avaluar si són anagrames:
* Treu tots els espais en blanc de les paraules
* Passa les paraules a minúscules
* Ordena les lletres de les paraules
* Compara si els dos resultats anteriors són iguals

S'ha de mostrar per pantalla: 
```text
        "Són les paraules 'X' i 'Y' anagrames? Z"
        On X i Y són les paraules d'entrada i Z és "True" o "False"
```
Validar els anagrames d'exemple anteriors, i un parell de proves amb quatre paraules que no siguin anagrames.

Exemple:
```text
Són les paraules 'Mare' i 'Rema' anagrames? true
Són les paraules 'Porta' i 'Tropa' anagrames? true
Són les paraules 'Triangle' i 'Integral' anagrames? true
Són les paraules 'Sopa' i 'Posa' anagrames? true
Són les paraules 'Casa' i 'Sopa' anagrames? false
Són les paraules 'Gat' i 'Perro' anagrames? false
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```