package io.oldering.sandbox.databindingdemo;

public class Team {
    static final Team tigers = new Team(
            "阪神タイガース",
            R.drawable.ic_hanshin
    );
    static final Team dragons = new Team(
            "中日ドラゴンズ",
            R.drawable.ic_chunichi
    );
    static final Team swallows = new Team(
            "東京ヤクルトスワローズ",
            R.drawable.ic_swallows
    );
    static final Team giants = new Team(
            "読売巨人軍",
            R.drawable.ic_giants
    );

    private String fullname;
    private int drawableId;

    private Team(String fullname, int drawableId) {
        this.fullname = fullname;
        this.drawableId = drawableId;
    }

    public String getFullname() {
        return fullname;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
