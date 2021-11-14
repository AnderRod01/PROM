package com.example.ejerciciodialogos;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class PageAdapter extends PagerAdapter {



    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,
                                  int position) {
        View page;
        switch (position){
            case 0:
                if (pestana1 == null){
                    pestana1 = (LinearLayout)
                            LayoutInflater.from(PestanasConViewPager.this)
                                    .inflate(R.layout.pestana1, container,false );
                }
                page= pestana1;
                break;
            default:
                if (pestana2 == null) {
                    pestana2 = (LinearLayout)
                            LayoutInflater.from(PestanasConViewPager.this)
                                    .inflate(R.layout.pestana3,container,false);
                }
                page=pestana2;
                break;
        }
        container.addView(page, 0);
        return page;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view,
                                    @NonNull Object object) {
        //return false;
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container,
                            int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
