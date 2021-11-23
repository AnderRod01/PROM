package com.example.ejerciciodialogos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

public class ActividadMenus extends AppCompatActivity {

    private Menu[] datosCarne;
    private Menu[] datosVeg;

    private ListView lstCarne;
    private ListView lstVegetariano;
    private MenuListener listener;
    private TabLayout tabLayout;
    private String direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menus);

        datosCarne = new Menu[]{new Menu("Menu Jayce", R.string.menuJayce, R.drawable.jayce),
                new Menu("Menu Jinx", R.string.menuJinx, R.drawable.jinx),
                new Menu("Menu Vi", R.string.menuVi,R.drawable.vi)};

        datosVeg =new Menu[]{ new Menu("Menu Vander", R.string.menuVander, R.drawable.vander),
                new Menu("Menu Silco", R.string.menuSilco,R.drawable.silco)};

        Bundle datos =  getIntent().getExtras();
        direccion = datos.getString("direccion");

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

        private LinearLayout tab1;
        private LinearLayout tab2;
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
                        tab1 = (LinearLayout) LayoutInflater.from(ActividadMenus.this).inflate(R.layout.tab1, container, false);

                    }
                    page = tab1;
                    AdaptadorMenus adaptadorCarne = new AdaptadorMenus(tab1.getContext(), datosCarne);

                    lstCarne = (ListView) tab1.findViewById(R.id.lstCarne);

                    lstCarne.setAdapter(adaptadorCarne);


                    lstCarne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Menu m= (Menu) adapterView.getItemAtPosition(i);
                            System.out.println(direccion);
                            Intent intent = new Intent(ActividadMenus.this, ActividadDescripcion.class);
                            intent.putExtra("imagen", m.getImg());
                            intent.putExtra("desc", m.getDesc());
                            //intent.putExtra("direccion", direccion);
                            startActivity(intent);

                            finish();
                        }
                    });
                    break;
                default:
                    if (tab2 == null) {
                        tab2 = (LinearLayout) LayoutInflater.from(ActividadMenus.this).inflate(R.layout.tab2, container, false);
                    }
                    page = tab2;
                    AdaptadorMenus adaptadorMenus = new AdaptadorMenus(tab2.getContext(), datosVeg);

                    lstVegetariano = (ListView) tab2.findViewById(R.id.lstVegetariana);

                    lstVegetariano.setAdapter(adaptadorMenus);

                    lstVegetariano.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Menu m= (Menu) adapterView.getItemAtPosition(i);
                            System.out.println(direccion);
                            Intent intent = new Intent(ActividadMenus.this, ActividadDescripcion.class);
                            intent.putExtra("imagen", m.getImg());
                            intent.putExtra("desc", m.getDesc());
                            //intent.putExtra("direccion", direccion);
                            startActivity(intent);

                            finish();
                        }
                    });
                    break;
            }
            container.addView(page, 0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }

    }
}