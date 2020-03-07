package com.timkontrakan.checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cocacola extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SlideAdapter slideAdapter;
    private int mCurrentPage;
    Integer[] backgrounds = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private ConstraintLayout constraintLayout;
    private int jumlah =0;
    ImageView imageView;
    ImageView imageView1;
    TextView textView;
    TextView textView2;
    private int harga= 5000;
    private int totalBayar =0;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cocacola);

        viewPager = (ViewPager) findViewById(R.id.imagePreview);
        linearLayout = (LinearLayout) findViewById(R.id.dotsLiniear);
        slideAdapter = new SlideAdapter(this);
        viewPager.setAdapter(slideAdapter);

         imageView = (ImageView) findViewById(R.id.btnUp);
         imageView1 = (ImageView) findViewById(R.id.btnDown);
         textView = (TextView) findViewById(R.id.showValue);
         textView2 = (TextView) findViewById(R.id.totalHarga);

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }
    public void addDotsIndicator(int position){
        dots = new TextView[3];
        linearLayout.removeAllViews();
        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.greyPrimary));

            linearLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.whitePrimary));
        }
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void mUp (View view) {
        jumlah+=1;
        textView.setText(Integer.toString(jumlah));
        if (jumlah > 1){
            imageView1.animate().alpha(1).setDuration(300).start();
            imageView1.setEnabled(true);
        }

        totalBayar = harga * jumlah;
        textView2.setText("Rp" + totalBayar);

    }

    public void mDown (View view){
        jumlah-=1;
        textView.setText(Integer.toString(jumlah));
        if (jumlah < 2){
            imageView1.animate().alpha(0).setDuration(300).start();
            imageView1.setEnabled(false);
        }
        totalBayar = harga * jumlah;
        textView2.setText("Rp" + totalBayar);
    }

}
