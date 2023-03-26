package domain;

public class User {
    private String login;
    private Settings settings;
    private Long currentLevel;

    public User() {
    }

    public User(String login, Settings settings) {
        this.login = login;
        this.settings = settings;
        this.currentLevel = 0L;
    }

    public String getLogin() {
        return login;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Long getCurrentLevel() {
        return currentLevel;
    }

    public void addToCurrentLevel() {
        this.currentLevel++;
    }

    @Override
    public String toString() {
        return "domain.User{" +
                "login='" + login + '\'' +
                ", settings=" + settings +
                ", currentLevel=" + currentLevel +
                '}';
    }
}
