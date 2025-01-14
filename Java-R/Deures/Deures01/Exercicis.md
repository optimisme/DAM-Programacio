
# Explicació

Aquests exercicis són exemples d'examens.

# Exercici 0

Resol els mètodes de l'*Exercici0* segons la descripció dels seus comentaris al codi amb *//TODO.*

(Examen llarg de dificultat moderada)

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