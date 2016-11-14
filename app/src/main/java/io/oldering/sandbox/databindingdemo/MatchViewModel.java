package io.oldering.sandbox.databindingdemo;

public class MatchViewModel {
    private Match match;

    MatchViewModel(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
