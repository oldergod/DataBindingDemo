package io.oldering.sandbox.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MatchViewModel extends BaseObservable {
    private Match match;

    MatchViewModel(Match match) {
        this.match = match;
    }

    // We listener to change on match to refresh the UI automatically when it changes
    @Bindable
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
        notifyPropertyChanged(BR.match);
    }
}
