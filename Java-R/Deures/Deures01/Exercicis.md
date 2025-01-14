
# Explicació

Aquests exercicis són exemples d'examens.

# Exercici 0

Resol els mètodes de l'*Exercici0* segons la descripció dels seus comentaris al codi amb *//TODO.*

(Examen llarg de dificultat moderada)

Aquí hi ha un exemple del "Resolt0"

```bash
./run.sh com.exercicis.Resolt0
```

```bash
# Testeja les funcions individualment
./runTest.sh com.exercicis.TestExercici0#testValidarNom
./runTest.sh com.exercicis.TestExercici0#testValidarEdat
./runTest.sh com.exercicis.TestExercici0#testValidarFactors
./runTest.sh com.exercicis.TestExercici0#testValidarDescompte
./runTest.sh com.exercicis.TestExercici0#testValidarTipusOperacio
./runTest.sh com.exercicis.TestExercici0#testValidarClients
./runTest.sh com.exercicis.TestExercici0#testIsAllDigits
./runTest.sh com.exercicis.TestExercici0#testValidarData
./runTest.sh com.exercicis.TestExercici0#testValidarPreu
./runTest.sh com.exercicis.TestExercici0#testGeneraClauClient
./runTest.sh com.exercicis.TestExercici0#testAfegirClient
./runTest.sh com.exercicis.TestExercici0#testModificarClient
./runTest.sh com.exercicis.TestExercici0#testEsborrarClient
./runTest.sh com.exercicis.TestExercici0#testLlistarClients
./runTest.sh com.exercicis.TestExercici0#testGeneraClauOperacio
./runTest.sh com.exercicis.TestExercici0#testAfegirOperacio
./runTest.sh com.exercicis.TestExercici0#testModificarOperacio
./runTest.sh com.exercicis.TestExercici0#testEsborrarOperacio
./runTest.sh com.exercicis.TestExercici0#testLlistarOperacions
./runTest.sh com.exercicis.TestExercici0#testLlistarOperacionsClient
./runTest.sh com.exercicis.TestExercici0#testAlineaColumnes
./runTest.sh com.exercicis.TestExercici0#testTaulaOperacionsClient0
./runTest.sh com.exercicis.TestExercici0#testTaulaOperacionsClient1
./runTest.sh com.exercicis.TestExercici0#testTaulaOperacionsClient2
./runTest.sh com.exercicis.TestExercici0#testGetCadenesMenu
./runTest.sh com.exercicis.TestExercici0#testObtenirOpcio
./runTest.sh com.exercicis.TestExercici0#testLlistarClientsMenu
./runTest.sh com.exercicis.TestExercici0#testDibuixarLlista
./runTest.sh com.exercicis.TestExercici0#testLlegirNom
./runTest.sh com.exercicis.TestExercici0#testLlegirEdat
./runTest.sh com.exercicis.TestExercici0#testLlegirFactors
./runTest.sh com.exercicis.TestExercici0#testLlegirDescompte
./runTest.sh com.exercicis.TestExercici0#testAfegirClientMenu
./runTest.sh com.exercicis.TestExercici0#testModificarClientMenu
./runTest.sh com.exercicis.TestExercici0#testEsborrarClientMenu
```

# Exercici 1

Resol els mètodes de l'*Exercici1* segons la descripció dels seus comentaris al codi amb *//TODO.* 

Al final has de tenir un joc tipus **2048** implementat per línia de comandes.

(Examen curt de dificultat alta)

Teniu un exemple del joc en aquest enllaç **"[Play 2048](https://play2048.co)"**, però enlloc de posar el final a *2048* serà a **128**

Aquí hi ha un exemple del "Resolt1"

```bash
./run.sh com.exercicis.Resolt1
```

<br/>
<center>
<video width="100%" style="max-width:450px;" controls allowfullscreen>
  <source src="./Exercici1.mov" type="video/mp4">
</video>
</center>
<br/>

```bash
# Testeja les funcions individualment
./runTest.sh com.exercicis.TestExercici1#testPrintEmptyBoard
./runTest.sh com.exercicis.TestExercici1#testPrintBoardWithSingleNumber
./runTest.sh com.exercicis.TestExercici1#testPrintBoardWithMultipleNumbers
./runTest.sh com.exercicis.TestExercici1#testPrintBoardWithFullRow
./runTest.sh com.exercicis.TestExercici1#testPrintBoardWithLargeNumbers
./runTest.sh com.exercicis.TestExercici1#testSpawnAddToEmptyBoard
./runTest.sh com.exercicis.TestExercici1#testSpawnOnPartiallyFilled
./runTest.sh com.exercicis.TestExercici1#testSpawnDoNotOverwriteExisting
./runTest.sh com.exercicis.TestExercici1#testMoveLeftSimpleMove
./runTest.sh com.exercicis.TestExercici1#testMoveLeftWithMerge
./runTest.sh com.exercicis.TestExercici1#testMoveLeftNoMergeWithEmptySpaces
./runTest.sh com.exercicis.TestExercici1#testMoveLeftEmptyRow
./runTest.sh com.exercicis.TestExercici1#testMoveLeftFullRowWithoutMerge
./runTest.sh com.exercicis.TestExercici1#testMoveRightSimpleMove
./runTest.sh com.exercicis.TestExercici1#testMoveRightWithMerge
./runTest.sh com.exercicis.TestExercici1#testMoveRightNoMergeWithEmptySpaces
./runTest.sh com.exercicis.TestExercici1#testMoveRightEmptyRow
./runTest.sh com.exercicis.TestExercici1#testMoveRightFullRowWithoutMerge
./runTest.sh com.exercicis.TestExercici1#testMoveRightMultipleRows
./runTest.sh com.exercicis.TestExercici1#testMoveRightConsecutiveMerges
./runTest.sh com.exercicis.TestExercici1#testMoveUpSimpleMove
./runTest.sh com.exercicis.TestExercici1#testMoveUpWithMerge
./runTest.sh com.exercicis.TestExercici1#testMoveUpNoMergeWithEmptySpaces
./runTest.sh com.exercicis.TestExercici1#testMoveUpEmptyColumn
./runTest.sh com.exercicis.TestExercici1#testMoveUpFullColumnWithoutMerge
./runTest.sh com.exercicis.TestExercici1#testMoveUpMultipleColumns
./runTest.sh com.exercicis.TestExercici1#testMoveDownSimpleMove
./runTest.sh com.exercicis.TestExercici1#testMoveDownWithMerge
./runTest.sh com.exercicis.TestExercici1#testMoveDownNoMergeWithEmptySpaces
./runTest.sh com.exercicis.TestExercici1#testMoveDownEmptyColumn
./runTest.sh com.exercicis.TestExercici1#testMoveDownFullColumnWithoutMerge
./runTest.sh com.exercicis.TestExercici1#testMoveDownMultipleColumns
./runTest.sh com.exercicis.TestExercici1#testMoveDownConsecutiveMerges
./runTest.sh com.exercicis.TestExercici1#testGameWin
./runTest.sh com.exercicis.TestExercici1#testGameContinueWithEmptyCell
./runTest.sh com.exercicis.TestExercici1#testGameContinueWithAdjacentHoriz
./runTest.sh com.exercicis.TestExercici1#testGameContinueWithAdjacentVert
./runTest.sh com.exercicis.TestExercici1#testGameLost
./runTest.sh com.exercicis.TestExercici1#testGameContinueWithMultipleConditions
./runTest.sh com.exercicis.TestExercici1#testGameWinWithMultipleConditions
./runTest.sh com.exercicis.TestExercici1#testPlayExitGame
./runTest.sh com.exercicis.TestExercici1#testPlayInvalidMove
./runTest.sh com.exercicis.TestExercici1#testPlayValidMoves
./runTest.sh com.exercicis.TestExercici1#testPlayShortCommands
./runTest.sh com.exercicis.TestExercici1#testPlayWinCondition
```