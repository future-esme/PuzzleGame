package domain;

import domain.enumeration.Language;

public class Settings implements Cloneable {
    private boolean sendPushNotification;
    private boolean sendEmailNotification;
    private Language language;

    public Settings() {
        sendPushNotification = true;
        sendEmailNotification = true;
        language = Language.EN;
    }

    public Settings(boolean sendPushNotification, boolean sendEmailNotification, Language language) {
        this.sendPushNotification = sendPushNotification;
        this.sendEmailNotification = sendEmailNotification;
        this.language = language;
    }

    public boolean isSendPushNotification() {
        return sendPushNotification;
    }

    public void setSendPushNotification(boolean sendPushNotification) {
        this.sendPushNotification = sendPushNotification;
    }

    public boolean isSendEmailNotification() {
        return sendEmailNotification;
    }

    public void setSendEmailNotification(boolean sendEmailNotification) {
        this.sendEmailNotification = sendEmailNotification;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public Settings clone() {
        return new Settings(this.sendPushNotification, this.sendEmailNotification, this.language);
    }
    
    @Override
    public String toString() {
        return "domain.Settings{" +
                "sendPushNotification=" + sendPushNotification +
                ", sendEmailNotification=" + sendEmailNotification +
                ", language=" + language +
                '}';
    }
}
