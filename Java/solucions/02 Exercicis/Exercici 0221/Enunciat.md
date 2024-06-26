<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 21

Demana a l'usuari que escrigui una contrasenya.

Crea la funció 'validaContrasenya' que apartir d'un text de contrasenya dirà que és vàlida si:

- La contrasenya té almenys 8 caràcters

- La contrasenya té almenys 2 lletres majúscules i 2 lletres minúscules

La resposta de la funció serà el text:

- "La contrasenya és vàlida" si és vàlida

- "La contrasenya NO és vàlida" si no és vàlida

Et calen les funcions 'conta_majuscules' i una funció 'conta_minuscules'.

Exemple:
```text
La contrasenya 'PassWord123': La contrasenya és vàlida
La contrasenya 'password': La contrasenya NO és vàlida
La contrasenya 'PASSWORD': La contrasenya NO és vàlida
La contrasenya 'Pass12': La contrasenya NO és vàlida
La contrasenya 'PassWord': La contrasenya és vàlida
La contrasenya 'ValidPass123': La contrasenya és vàlida
La contrasenya 'AnotherValid1': La contrasenya és vàlida
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
