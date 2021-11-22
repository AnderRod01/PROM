package com.example.ejerciciodialogos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class AdaptadorMenus extends ArrayAdapter<Menu> {

    private Menu [] datos;

    public AdaptadorMenus(@NonNull Context context, Menu [] datos) {
        super(context, R.layout.listitem_menu, datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_menu, null);

        TextView lblMenu = (TextView) item.findViewById(R.id.lblMenu);
        lblMenu.setText(datos[position].getNombre());

        ImageView img = (ImageView) item.findViewById(R.id.imgMenu);
        img.setImageDrawable(datos[position].getImg().getDrawable());

        return item;
    }




}