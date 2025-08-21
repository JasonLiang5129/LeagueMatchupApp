package com.example.androidCpp.Classes;

import androidx.annotation.NonNull;

public class MatchupGuide {
    public MatchupGuide(int guideId, double guidePatchVersion, String guideTitle, String guideText) {
        this.guideId = guideId;
        this.guidePatchVersion = guidePatchVersion;
        this.guideTitle = guideTitle;
        this.guideText = guideText;
    }

    int guideId;
    double guidePatchVersion;
    String guideTitle;
    String guideText;

    @NonNull
    @Override
    public String toString() {
        return "MatchupGuide{" +
                "guideId=" + guideId +
                ", guidePatchVersion=" + guidePatchVersion +
                ", guideText='" + guideText + '\'' +
                '}';
    }

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public double getGuidePatchVersion() {
        return guidePatchVersion;
    }

    public void setGuidePatchVersion(double guidePatchVersion) {
        this.guidePatchVersion = guidePatchVersion;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public void setGuideTitle(String guideTitle) {
        this.guideTitle = guideTitle;
    }

    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }
}
