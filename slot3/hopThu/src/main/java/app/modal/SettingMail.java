package app.modal;

import org.springframework.context.annotation.Bean;

public class SettingMail {
    private String language;
    private int pageSize;
    private boolean filler;
    private String signature;

    public SettingMail(String language, int pageSize, boolean filler, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filler = filler;
        this.signature = signature;
    }

    public SettingMail() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFiller() {
        return filler;
    }

    public void setFiller(boolean filler) {
        this.filler = filler;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
