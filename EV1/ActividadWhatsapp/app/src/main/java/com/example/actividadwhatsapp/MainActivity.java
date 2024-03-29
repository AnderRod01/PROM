package com.example.actividadwhatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private MenuItem mnItem_NuevoGrupo;
    private MenuItem mnItem_NuevaDifu;
    private MenuItem mnItem_Dispositivos;
    private MenuItem mnItem_MsgDestacados;
    private MenuItem mnItem_PrivEstados;
    private MenuItem mnItem_borrarLlamadas;
    private TabLayout tabLayout;
    private ListView lvChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager =  findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdapter());


        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);


        mnItem_NuevoGrupo = (MenuItem) findViewById(R.id.nuevoGrupo);
        mnItem_NuevaDifu = (MenuItem) findViewById(R.id.nuevaDifu);
        mnItem_Dispositivos = (MenuItem) findViewById(R.id.dispVinculados);
        mnItem_MsgDestacados = (MenuItem) findViewById(R.id.msgDestacados);
        mnItem_PrivEstados = (MenuItem) findViewById(R.id.privEstados);
        mnItem_borrarLlamadas  =(MenuItem) findViewById(R.id.borrarLlamadas);

        lvChats = (ListView) findViewById(R.id.lvChats);
        rellenarLista();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        mnItem_NuevoGrupo.setVisible(true);
                        mnItem_NuevaDifu.setVisible(true);
                        mnItem_Dispositivos.setVisible(true);
                        mnItem_MsgDestacados.setVisible(true);
                        mnItem_PrivEstados.setVisible(false);
                        mnItem_borrarLlamadas.setVisible(false);
                        break;
                    case 1:
                        mnItem_NuevoGrupo.setVisible(false);
                        mnItem_NuevaDifu.setVisible(false);
                        mnItem_Dispositivos.setVisible(false);
                        mnItem_MsgDestacados.setVisible(false);
                        mnItem_PrivEstados.setVisible(true);
                        mnItem_borrarLlamadas.setVisible(false);


                        break;
                    default:
                        mnItem_NuevoGrupo.setVisible(false);
                        mnItem_NuevaDifu.setVisible(false);
                        mnItem_Dispositivos.setVisible(false);
                        mnItem_MsgDestacados.setVisible(false);
                        mnItem_PrivEstados.setVisible(false);
                        mnItem_borrarLlamadas.setVisible(true);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void rellenarLista(){
        final Chat[] CHATS = {new Chat("Juan", "Como estas?", "12:32"),
                new Chat("Eskalope", "Quien eres?", "13:45"),
                new Chat("Guillem", "Hola furro", "13:26")
        };

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, CHATS);
        lvChats.setAdapter(adaptadorTitulares);

    }



    class AdaptadorTitulares extends ArrayAdapter<Chat> {

        private Chat[] datos;

        public AdaptadorTitulares(@NonNull Context context, Chat[] datos) {
            super(context, R.layout.listitem_chats, datos);
            this.datos=datos;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_chats, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.lblNombre);
            lblTitulo.setText(datos[position].getNombre());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblMensaje);
            lblSubtitulo.setText(datos[position].getMensaje());

            TextView lblHora = (TextView)item.findViewById(R.id.lblHora);
            lblHora.setText(datos[position].getMensaje());

            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setImageDrawable(getDrawable(R.drawable.icon));

            return (item);
        }
    }



    class PageAdapter extends PagerAdapter {

        private LinearLayout tab1;
        private LinearLayout tab2;
        private LinearLayout tab3;
        private final int[] TABS ={R.string.tab1, R.string.tab2 ,R.string.tab3};

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String s = getString(TABS[position]);
            return s;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch(position){
                case 0:
                    if (tab1 == null) {
                        tab1 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab1, container, false);

                    }
                    page = tab1;
                    break;
                case 1:
                    if (tab2 ==  null) {
                        tab2 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab2, container, false);
                    }
                    page = tab2;
                    break;
                default:
                    if (tab3 == null){
                        tab3 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab3, container, false);
                    }
                    page = tab3;
                    break;
            }

            container.addView(page,0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            //return false;
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}