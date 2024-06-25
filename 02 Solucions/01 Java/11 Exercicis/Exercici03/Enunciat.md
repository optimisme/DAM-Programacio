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

Fent servir SWING bàsic i el model MVC, fes tres vistes:

* La primera vista 'ViewForm' és un formulari amb els camps 'Name', 'Phone Number', 'Age' i 'Email' amb un botó 'Send'

* La segona vista 'ViewLoading' és una barra de progrés que ha de trigar 2.5 segons a completar-se, i actualitzar-se cada 150 mil·lisegons

* La Tercera vista 'ViewInfo' és una JTextArea amb la informació recollida del formulari anterior.

El canvi de vistes s'ha de fer amb una 'CardLayout', i l'actualització de la barra de progrés amb una combinació de *Timer* i *ActionListener*

<center><img src="./captura.gif" height="250" alt="Calculadora" style="max-height: 250px;"></center>


Per tal que passi el test, cal que:

A l'objecte 'MainWindow' la vista i el controlador han de ser públics:

```java
    public CardLayout cardLayout;
    public JPanel;

    public ViewForm vForm;
    public ViewLoading vLoading;
    public ViewInfo vInfo;
```

Al 'ViewForm.java' hi hagi els següents elements:

```java
    public JTextField nameField;
    public JTextField phoneNumberField;
    public JTextField ageField;
    public JTextField emailField;
    public JButton sendButton;
```

Al 'ViewInfo.java' hi hagi els següents elements:

```java
    public JTextArea dataArea;
```

Al 'ViewLoading.java' hi hagi els següents elements:

```java
    public JProgressBar progressBar;
    private JLabel loadingLabe;
```