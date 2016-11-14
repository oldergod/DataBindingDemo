package io.oldering.sandbox.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.design.widget.BottomNavigationView;
import android.widget.ImageView;

// if we used a 'onNavigationItemSelectedListener', we would not need
// to explicitly bind the method since the setter name is matched
@BindingMethods({
        @BindingMethod(
                type = BottomNavigationView.class,
                attribute = "app:onNavigationItemSelected",
                method = "setOnNavigationItemSelectedListener"
        ),
})
public class DataBindingAdapter {
    // use as an exemple but in this case, the attribute name match the setter of
    // the ImageView class so this would still work without the binding adapter declaration
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resourceId) {
        imageView.setImageResource(resourceId);
    }
}
