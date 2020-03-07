package com.timkontrakan.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter (Context context){
        this.context = context;
    }

    //Arrays
    public int[] slide_preview = {
            R.drawable.pepsi_can,
            R.drawable.fanta,
            R.drawable.cocacola
    };

    public int[] product = {
            R.drawable.bg_gradient_white,
            R.drawable.bg_gradient_white_fanta,
            R.drawable.bg_gradient_white_cola
    };

    public int[] backgrounds = {
            R.drawable.bg_gradient_pepsi,
            R.drawable.bg_gradient_cola,
            R.drawable.bg_gradient_fanta
    };

    public String[] slide_headings = {
            "Pepsi",
            "Fanta",
            "Coca - Cola"
    };

    public String[] slide_desc = {
            "Lorem Ipsum is simply dummy text of the\nprinting and typesetting industry",
            "Lorem Ipsum is simply dummy text of the\nprinting and typesetting industry",
            "Lorem Ipsum is simply dummy text of the\nprinting and typesetting industry"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_fanta, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageSlide);
        TextView textView = (TextView) view.findViewById(R.id.productName);
        TextView textView1 = (TextView) view.findViewById(R.id.captionProduct);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.background);
        View view1 = (View) view.findViewById(R.id.viewProduct);

        imageView.setImageResource(slide_preview[position]);
        textView.setText(slide_headings[position]);
        textView1.setText(slide_desc[position]);
        constraintLayout.setBackgroundResource(backgrounds[position]);
        view1.setBackgroundResource(product[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
