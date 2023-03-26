package domain;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    private final Long id;
    private final String name;
    private final Character[][] matrix;
    private final List<String> words;

    private Puzzle(PuzzleBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.matrix = builder.matrix;
        this.words = builder.words;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character[][] getMatrix() {
        return matrix;
    }

    public List<String> getWords() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder puzzleInfo = new StringBuilder("*** domain.Puzzle " + name + "***\n" +
                "-> total words: " + words.size() + "\n\n");
        for (Character[] characters : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                puzzleInfo.append(characters[j]).append(" ");
            }
            puzzleInfo.append("\n");
        }
        return puzzleInfo.toString();

    }

    public static class PuzzleBuilder {
        private Long id;
        private String name;
        private Character[][] matrix;
        private List<String> words;

        public PuzzleBuilder(Long id, String name) {
            this.id = id;
            this.name = name;
            this.matrix = new Character[1][1];
            this.words = new ArrayList<>();
        }

        public PuzzleBuilder matrix(Character[][] matrix) {
            this.matrix = matrix;
            return this;
        }

        public PuzzleBuilder addRow(Character[] newRow) {
            Character[][] newMatrix = new Character[matrix.length + 1][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                newMatrix[matrix.length][i] = newRow[i];
            }
            this.matrix = newMatrix;
            return this;
        }

        public PuzzleBuilder words(List<String> words) {
            this.words = words;
            return this;
        }

        public PuzzleBuilder addWord(String newWord) {
            this.words.add(newWord);
            return this;
        }

        public void validatePuzzle() {
            //some validations for future developing
        }

        public Puzzle build() {
            validatePuzzle();
            return new Puzzle(this);
        }
    }
}
