package com.example.mylittledoctor.MainUI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {
    private Context mContext;
    LayoutInflater inflater;
    ArrayList<Drawable> drawer=new ArrayList<>();
    public  ImagePagerAdapter(){

    }
    public  ImagePagerAdapter(Context context,ArrayList<Drawable> drawer){
        this.mContext = context;
        this.drawer=drawer;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=null;
        if(mContext!=null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.main_pageview, container, false);
        }
        ImageView img=(ImageView)view.findViewById(R.id.img);
        img.setImageDrawable(drawer.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        Log.d("확인","개수");
        return 4;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(View)object);
    }
}