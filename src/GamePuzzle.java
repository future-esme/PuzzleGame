import domain.Puzzle;
import domain.Settings;
import domain.User;
import domain.enumeration.Language;
import factory.EasyLevelFactory;
import factory.LevelFactory;
import factory.MediumLevelFactory;

import java.util.ArrayList;

public class GamePuzzle {
    public static void main(String[] args) throws Exception {
        createMockPuzzles();
        updateGeneralSettings();
        createMockLevels();
        createMockUsers();

        printPuzzles(new Long[]{1L, 4L, 6L});
        printUsers();
        printLevels();
    }

    private static void createMockPuzzles() {
        var gameManager = GameManager.getInstance();
        var puzzleBuilder1 = new Puzzle.PuzzleBuilder(1L, "puzzle 1 3x3");
        Character[][] matrix1 = {
                {'b', 'b', 'c'},
                {'a', 'o', 'c'},
                {'a', 'l', 'x'}
        };
        puzzleBuilder1.matrix(matrix1);
        puzzleBuilder1.addWord("box");
        gameManager.addPuzzles(puzzleBuilder1.build());

        var puzzleBuilder2 = new Puzzle.PuzzleBuilder(2L, "puzzle 2 4x4");
        Character[][] matrix2 = {
                {'b', 'b', 't', 'a'},
                {'b', 'i', 'c', 'a'},
                {'b', 'b', 'r', 'a'}
        };
        puzzleBuilder2.matrix(matrix2);
        puzzleBuilder2.addRow(new Character[]{'b', 'b', 'r', 'd'});
        puzzleBuilder2.addWord("bird");
        puzzleBuilder2.addWord("bit");
        gameManager.addPuzzles(puzzleBuilder2.build());

        var puzzleBuilder3 = new Puzzle.PuzzleBuilder(3L, "puzzle 3 5x5");
        Character[][] matrix3 = {
                {'b', 'b', 'c', 'z', 'n'},
                {'b', 'o', 'n', 'u', 's'},
                {'b', 'b', 'c', 'z', 'a'},
                {'b', 'a', 'c', 'z', 'a'},
                {'b', 'b', 'c', 'z', 'a'}
        };
        puzzleBuilder3.matrix(matrix3);
        puzzleBuilder3.addWord("bonus");
        puzzleBuilder3.addWord( "bacon");
        gameManager.addPuzzles(puzzleBuilder3.build());

        var puzzleBuilder4 = new Puzzle.PuzzleBuilder(4L, "puzzle 4 3x3");
        Character[][] matrix4 = {
                {'b', 'b', 'c'},
                {'a', 'e', 'c'},
                {'a', 'l', 'e'}
        };
        puzzleBuilder4.matrix(matrix4);
        puzzleBuilder4.addWord("bee");
        gameManager.addPuzzles(puzzleBuilder4.build());

        var puzzleBuilder5 = new Puzzle.PuzzleBuilder(5L, "puzzle 5 4x4");
        Character[][] matrix5 = {
                {'b', 'b', 't', 'a'},
                {'b', 'i', 'c', 'n'},
                {'b', 'b', 'r', 't'}
        };
        puzzleBuilder5.matrix(matrix5);
        puzzleBuilder5.addRow(new Character[]{'b', 'b', 'r', 'd'});
        puzzleBuilder5.addWord("bird");
        puzzleBuilder5.addWord("bit");
        puzzleBuilder5.addWord("ant");
        gameManager.addPuzzles(puzzleBuilder5.build());

        var puzzleBuilder6 = new Puzzle.PuzzleBuilder(6L, "puzzle 6 5x5");
        Character[][] matrix6 = {
                {'b', 'b', 'c', 'z', 'n'},
                {'c', 'o', 'c', 'o', 's'},
                {'b', 'b', 'c', 'z', 'a'},
                {'b', 'a', 'c', 'z', 'a'},
                {'b', 'b', 'c', 'z', 'a'}
        };
        puzzleBuilder6.matrix(matrix6);
        puzzleBuilder6.addWord("cocos");
        puzzleBuilder6.addWord( "bacon");
        gameManager.addPuzzles(puzzleBuilder6.build());

        var puzzleBuilder7 = new Puzzle.PuzzleBuilder(7L, "puzzle 7 3x3");
        Character[][] matrix7 = {
                {'b', 'b', 'c'},
                {'a', 'o', 'c'},
                {'a', 'l', 'x'}
        };
        puzzleBuilder7.matrix(matrix7);
        puzzleBuilder7.addWord("box");
        gameManager.addPuzzles(puzzleBuilder7.build());

        var puzzleBuilder8 = new Puzzle.PuzzleBuilder(8L, "puzzle 8 3x3");
        Character[][] matrix8 = {
                {'b', 'b', 'c'},
                {'a', 'o', 'c'},
                {'a', 'l', 'x'}
        };
        puzzleBuilder8.matrix(matrix8);
        puzzleBuilder8.addWord("box");
        gameManager.addPuzzles(puzzleBuilder8.build());
    }

    private static void updateGeneralSettings() {
        var newGeneralSettings = new Settings(true, false, Language.RO);
        var gameManager = GameManager.getInstance();
        gameManager.setGeneralSettings(newGeneralSettings);
    }

    private static void createMockLevels() throws Exception {
        var gameManager = GameManager.getInstance();
        LevelFactory level1Factory = new EasyLevelFactory();
        var level1Puzzles = new ArrayList<Puzzle>();
        level1Puzzles.add(gameManager.getPuzzleById(1L));
        level1Puzzles.add(gameManager.getPuzzleById(4L));
        level1Puzzles.add(gameManager.getPuzzleById(2L));
        var level1 = level1Factory.createLevel(1L, level1Puzzles);

        gameManager.addLevel(level1);

        LevelFactory level2Factory = new MediumLevelFactory();
        var level2Puzzles = new ArrayList<Puzzle>();
        level2Puzzles.add(gameManager.getPuzzleById(3L));
        level2Puzzles.add(gameManager.getPuzzleById(5L));
        level2Puzzles.add(gameManager.getPuzzleById(6L));
        level2Puzzles.add(gameManager.getPuzzleById(7L));
        level2Puzzles.add(gameManager.getPuzzleById(8L));
        var level2 = level2Factory.createLevel(2L, level2Puzzles);

        gameManager.addLevel(level2);
    }

    private static void createMockUsers() {
        var gameManager = GameManager.getInstance();
        var user1 = new User("gabi", gameManager.getGeneralSettings().clone());
        var user2 = new User("dima", gameManager.getGeneralSettings().clone());
        var user3 = new User("tudor", gameManager.getGeneralSettings().clone());

        gameManager.addUser(user1);
        gameManager.addUser(user2);
        gameManager.addUser(user3);
    }

    private static void printPuzzles(Long[] levelsId) throws Exception {
        var gameManager = GameManager.getInstance();
        for (var id : levelsId) {
            System.out.println(gameManager.getPuzzleById(id));
        }
    }

    private static void printUsers() {
        var gameManager = GameManager.getInstance();
        for (var user : gameManager.getUsers()) {
            System.out.println(user);
        }
    }

    private static void printLevels() {
        var gameManager = GameManager.getInstance();
        for (var level : gameManager.getLevels()) {
            System.out.println(level);
        }
        gameManager.getLevels().get(1).hideLetters(7L);
    }
}
