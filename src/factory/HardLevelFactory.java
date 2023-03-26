package factory;

import domain.HardLevel;
import domain.Level;
import domain.Puzzle;
import factory.LevelFactory;

import java.util.List;

public class HardLevelFactory implements LevelFactory {
    public Level createLevel(Long levelNumber, List<Puzzle> puzzles) {
        Integer puzzleCount = 7;
        Integer timeLimit = 170;
        return new HardLevel(levelNumber, puzzleCount, timeLimit,puzzles);
    }
}