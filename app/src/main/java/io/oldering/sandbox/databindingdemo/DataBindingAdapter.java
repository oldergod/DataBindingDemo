package io.oldering.sandbox.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.design.widget.BottomNavigationView;
import android.widget.CheckBox;
import android.widget.ImageView;

@BindingMethods({
        @BindingMethod(
                type = BottomNavigationView.class,
                attribute = "app:onNavigationItemSelected",
                method = "setOnNavigationItemSelectedListener"
        ),
        @BindingMethod(
                type = CheckBox.class,
                attribute = "app:onCheckedChanged",
                method = "setOnCheckedChangeListener"
        ),
})
public class DataBindingAdapter {
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resourceId) {
        imageView.setImageResource(resourceId);
    }
}
