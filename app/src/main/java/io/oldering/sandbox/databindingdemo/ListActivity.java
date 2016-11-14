package io.oldering.sandbox.databindingdemo;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ListActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        CheckBox.OnCheckedChangeListener {

    MatchViewModel matchViewModel = new MatchViewModel(Match.giantsTigers);
    private ConstraintLayout activityList;
    private TextView dateView;
    private TextView stadiumView;
    private CheckBox showScoreView;
    private TextView scoreView;
    private BottomNavigationView bottomNavigationView;
    private ImageView homeTeamIconView;
    private TextView homeTeamNameView;
    private ImageView awayTeamIconView;
    private TextView awayTeamNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupListeners();
        fillData(matchViewModel);
        setupTransitionDelay(activityList);
    }

    private void bindViews() {
        activityList = (ConstraintLayout) findViewById(R.id.activity_list);
        dateView = (TextView) findViewById(R.id.date);
        stadiumView = (TextView) findViewById(R.id.stadium);
        showScoreView = (CheckBox) findViewById(R.id.showScore);
        scoreView = (TextView) findViewById(R.id.score);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        View homeTeam = findViewById(R.id.homeTeam);
        homeTeamIconView = (ImageView) homeTeam.findViewById(R.id.teamicon);
        homeTeamNameView = (TextView) homeTeam.findViewById(R.id.teamName);

        View awayTeam = findViewById(R.id.awayTeam);
        awayTeamIconView = (ImageView) awayTeam.findViewById(R.id.teamicon);
        awayTeamNameView = (TextView) awayTeam.findViewById(R.id.teamName);
    }

    private void setupListeners() {
        showScoreView.setOnCheckedChangeListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void fillData(MatchViewModel matchViewModel) {
        Match match = matchViewModel.getMatch();
        dateView.setText(getString(R.string.year_date, match.getYear(), match.getMonth(), match.getDay()));
        if (match.getStadium() == null) {
            stadiumView.setText(R.string.unknown_stadium);
        } else {
            stadiumView.setText(match.getStadium());
        }
        showScoreView.setChecked(match.isShowScore());
        scoreView.setText(match.getScore());
        scoreView.setVisibility(match.isShowScore() ? VISIBLE : GONE);
        homeTeamIconView.setImageResource(match.getHomeTeam().getDrawableId());
        homeTeamNameView.setText(match.getHomeTeam().getFullname());
        awayTeamIconView.setImageResource(match.getAwayTeam().getDrawableId());
        awayTeamNameView.setText(match.getAwayTeam().getFullname());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        matchViewModel.getMatch().setShowScore(b);
        scoreView.setVisibility(b ? VISIBLE : GONE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_bottom_dragons:
                matchViewModel.setMatch(Match.tigersDragons);
                break;
            case R.id.menu_bottom_giants:
                matchViewModel.setMatch(Match.giantsTigers);
                break;
            case R.id.menu_bottom_swallows:
                matchViewModel.setMatch(Match.swallowsTigers);
                break;
        }
        fillData(matchViewModel);
        return true;
    }

    private void setupTransitionDelay(ConstraintLayout activityList) {
        LayoutTransition layoutTransition = activityList.getLayoutTransition();
        layoutTransition.setDuration(200);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, null);
    }
}
