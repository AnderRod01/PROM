package com.example.ejerciciodialogos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ActividadMenus extends AppCompatActivity {

    private Menu[] datos;

    private ListView lstCarne;
    private ListView lstVegetariano;
    private MenuListener listener;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menus);


        ImageView jayce = new ImageView(this);
        jayce.setImageResource(R.drawable.jayce);

        ImageView jinx = new ImageView(this);
        jinx.setImageResource(R.drawable.jinx);

        ImageView vi = new ImageView(this);
        vi.setImageResource(R.drawable.vi);

        ImageView vander = new ImageView(this);
        vander.setImageResource(R.drawable.vander);

        ImageView silco = new ImageView(this);
        silco.setImageResource(R.drawable.silco);

        datos = new Menu[]{new Menu("Menu Jayce", R.string.menuJayce, jayce),
                new Menu("Menu Jinx", R.string.menuJinx, jinx),
                new Menu("Menu Vi", R.string.menuVi,vi),
                new Menu("Menu Vander", R.string.menuVander, vander),
                new Menu("Menu Silco", R.string.menuSilco,silco)};



        ViewPager viewPager= findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter());

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

    }


    public void setMenuListener(MenuListener listener) {
        this.listener = listener;
    }

    class PageAdapter extends PagerAdapter {

        private ConstraintLayout tab1;
        private ConstraintLayout tab2;
        private final String[] TABS = {"Menus con carne", "Menus Vegetarianos"};

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String s = TABS[position];
            return s;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch(position){
                case 1:

                    if (tab1 == null) {
                        tab1 = (ConstraintLayout) LayoutInflater.from(ActividadMenus.this).inflate(R.layout.tab1, container, false);

                    }
                    page = tab1;
                    AdaptadorCarne adaptadorCarne = new AdaptadorCarne(tab1.getContext(), datos);

                    lstCarne = tab1.findViewById(R.id.lstCarne);

                    lstCarne.setAdapter(adaptadorCarne);
                    break;
                default:
                    if (tab2 == null) {
                        tab2 = (ConstraintLayout) LayoutInflater.from(ActividadMenus.this).inflate(R.layout.tab2, container, false);
                    }
                    page = tab2;
                    break;
            }
            container.addView(page, 0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }

    }
}