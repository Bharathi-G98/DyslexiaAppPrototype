package com.example.lenovo.dyslexianew;


class CardData {

    String activityName;
    String activityType;
    String activityInfo;

    CardData(String activityName, String activityType, String activityInfo) {
        this.activityName = activityName;
        this.activityType = activityType;
        this.activityInfo = activityInfo;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }
}
