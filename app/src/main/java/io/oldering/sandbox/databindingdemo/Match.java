package io.oldering.sandbox.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Match extends BaseObservable {
    static Match tigersDragons = new Match(2016, 7, 30, "甲子園", Team.tigers, Team.dragons, "神8－2中");
    static Match giantsTigers = new Match(2016, 5, 28, /* "東京ドーム" */ null, Team.giants, Team.tigers, "巨4－6神");
    static Match swallowsTigers = new Match(2016, 9, 11, "明治神宮", Team.swallows, Team.tigers, "ヤ0－5神");

    private int year;
    private int month;
    private int day;
    private String stadium;
    private Team homeTeam;
    private Team awayTeam;
    private String score;
    private boolean showScore;

    private Match(int year, int month, int day, String stadium, Team homeTeam, Team awayTeam, String score) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.stadium = stadium;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.showScore = false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getStadium() {
        return stadium;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }

    // we listener to showScore change to update the visibility of 'scoreView'
    // on change automatically
    @Bindable
    public boolean isShowScore() {
        return showScore;
    }

    public void setShowScore(boolean showScore) {
        this.showScore = showScore;
        notifyPropertyChanged(BR.showScore);
    }
}
