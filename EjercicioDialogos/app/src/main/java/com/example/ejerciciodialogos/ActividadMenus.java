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

    private Menu[] datos = new Menu[]{new Menu("Menu Jayce", R.string.menuJayce, R.drawable.jayce, true),
            new Menu("Menu Jinx", R.string.menuJinx, R.drawable.jinx, true),
            new Menu("Menu Vi", R.string.menuVi, R.drawable.vi, true),
            new Menu("Menu Vander", R.string.menuVander, R.drawable.vander, false),
            new Menu("Menu Silco", R.string.menuSilco, R.drawable.silco, false)};

    private ListView lstMenu;
    private MenuListener listener;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menus);

        ViewPager viewPager= findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter());
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);






    }

    class AdaptadorMenu extends ArrayAdapter<Menu> {
        private Activity context;

        public AdaptadorMenu(@NonNull Context context, Menu [] datos) {
            super(context, R.layout.listitem_menu, datos);

            //AYUDA
            this.context=context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_menu, null);

            TextView lblMenu = (TextView) item.findViewById(R.id.lblMenu);
            lblMenu.setText(datos[position].getNombre());

            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setImageDrawable(getResources().getDrawable(datos[position].getImg()));

            return item;
        }
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
                case 0:

                    if (tab1 == null) {
                        tab1 = (ConstraintLayout) LayoutInflater.from(ActividadMenus.this).inflate(R.layout.tab1, container, false);
                        AdaptadorMenu adaptadorMenu = new AdaptadorMenu(tab1.getContext(), datos);
                        lstMenu = (ListView) tab1.findViewById(R.id.lstCarne);
                        lstMenu.setAdapter(adaptadorMenu);
                    }

                    page = tab1;
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