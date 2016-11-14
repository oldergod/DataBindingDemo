package io.oldering.sandbox.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class DataBindingAdapter {
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resourceId) {
        imageView.setImageResource(resourceId);
    }
}