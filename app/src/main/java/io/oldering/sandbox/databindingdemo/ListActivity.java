package io.oldering.sandbox.databindingdemo;

import android.animation.LayoutTransition;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.oldering.sandbox.databindingdemo.databinding.ActivityMainBinding;

public class ListActivity extends AppCompatActivity {
    MatchViewModel matchViewModel = new MatchViewModel(Match.giantsTigers);
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMatchVM(matchViewModel);
        binding.setHandler(this);

        setupTransitionDelay();
    }

    public boolean onNavigationClick(@NonNull MenuItem item) {
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

    private void setupTransitionDelay() {
        LayoutTransition layoutTransition = binding.activityList.getLayoutTransition();
        layoutTransition.setDuration(200);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, null);
    }
}
