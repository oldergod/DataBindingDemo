package io.oldering.sandbox.databindingdemo;

import android.animation.LayoutTransition;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import io.oldering.sandbox.databindingdemo.databinding.ActivityMainBinding;

public class ListActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        CheckBox.OnCheckedChangeListener {

    MatchViewModel matchViewModel = new MatchViewModel(Match.giantsTigers);
    private ConstraintLayout activityList;
    private CheckBox showScoreView;
    private BottomNavigationView bottomNavigationView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bindViews();
        setupListeners();
        binding.setMatchVM(matchViewModel);
        setupTransitionDelay(activityList);
    }

    private void bindViews() {
        activityList = binding.activityList;
        showScoreView = binding.showScore;
        bottomNavigationView = binding.bottomNavigation;
    }

    private void setupListeners() {
        showScoreView.setOnCheckedChangeListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        matchViewModel.getMatch().setShowScore(b);
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
        return true;
    }

    private void setupTransitionDelay(ConstraintLayout activityList) {
        LayoutTransition layoutTransition = activityList.getLayoutTransition();
        layoutTransition.setDuration(200);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, null);
    }
}
