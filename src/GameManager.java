import domain.Level;
import domain.Puzzle;
import domain.Settings;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance;
    private List<Puzzle> puzzles;

    private List<Level> levels;

    private List<User> users;

    private Settings generalSettings;

    private GameManager() {
        puzzles = new ArrayList<>();
        users = new ArrayList<>();
        levels = new ArrayList<>();
        generalSettings = new Settings();
    }


    public static synchronized  GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }


    public boolean isSolutionComplete(Puzzle puzzle, List<String> solution) {
        if (puzzle.getWords().size() != solution.size()) {
            return false;
        }
        for (var item : solution) {
            if (!puzzle.getWords().contains(item)) {
                return false;
            }
        }
        return true;
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void addPuzzles(Puzzle puzzle) {
        this.puzzles.add(puzzle);
    }

    public void removePuzzle(Long puzzleId) {
        //check if id exists
        //method to remove puzzle
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(String login) {
        //check if id exists
        //method to remove user
    }

    public Settings getGeneralSettings() {
        return generalSettings;
    }

    public void setGeneralSettings(Settings generalSettings) {
        this.generalSettings = generalSettings;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public Level getLevelById(Long id) throws Exception {
        for (var level : levels) {
            if (level.getLevelNumber().equals(id)) {
                return level;
            }
        }
        throw new Exception("Not found level");
    }

    public Puzzle getPuzzleById(Long id) throws Exception {
        for (var puzzle : puzzles) {
            if (puzzle.getId().equals(id)) {
                return puzzle;
            }
        }
        throw new Exception("Not found puzzle");
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level) {
        //validate level then add
        this.levels.add(level);
    }

    public void removeLevel(Long levelNumber) {
        //remove level
    }
}
