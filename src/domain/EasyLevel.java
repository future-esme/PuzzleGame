package domain;

import java.util.List;

public class EasyLevel extends Level{
    public EasyLevel(Long levelNumber,
                     Integer puzzleCount,
                     Integer timeLimitForPuzzle,
                     List<Puzzle> puzzles) {
        super(levelNumber, puzzleCount, timeLimitForPuzzle, puzzles);
    }

    @Override
    public void hideLetters(Long puzzleId) {
        var puzzle = getPuzzleById(puzzleId);
        var hideLettersMatrix = puzzle.getMatrix().clone();
        for (var i = 0; i < puzzle.getMatrix().length; i++) {
            hideLettersMatrix[i][i] = '$';
        }
        var matrixPrint = new StringBuilder();
        for (Character[] characters : hideLettersMatrix) {
            for (int j = 0; j < hideLettersMatrix[0].length; j++) {
                matrixPrint.append(characters[j]).append(" ");
            }
            matrixPrint.append("\n");
        }
        System.out.println(matrixPrint);
    }
}
