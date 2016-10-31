package com.example.thiagoduarte.pedeaquif;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<ItensCardapio> itensCardapios;
    ItensCardapioAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);//R.layout.activity_main
        listView = (ListView)findViewById(R.id.minha_lista);



        itensCardapios = new ArrayList<ItensCardapio>();
        itensCardapios.add(new ItensCardapio("Cappuccino","10" ,"Bebida",0));
        itensCardapios.add(new ItensCardapio("Chocolate","12","Sobremesa",1));
        itensCardapios.add(new ItensCardapio("Crepioca","8","Comida",2));
        itensCardapios.add(new ItensCardapio("Empada","7","Comida",3));
        itensCardapios.add(new ItensCardapio("Empada de  Frango","9","Comida",4));
        itensCardapios.add(new ItensCardapio("Expresso","9","Bebida",5));
        itensCardapios.add(new ItensCardapio("Pão de Queijo","9","Comida",6));
        itensCardapios.add(new ItensCardapio("Quiche","9","Comida",7));
        itensCardapios.add(new ItensCardapio("Refrigerante","9","Bebida",8));
        itensCardapios.add(new ItensCardapio("Sanduiche","9","Comida",9));



        //cabeçalho
        final int PADDING = 8;
        TextView txtHeader = new TextView(this);

        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.text_cabecalho);
        txtHeader.setPadding(PADDING,PADDING,0,PADDING);

        listView.addHeaderView(txtHeader);
        //-----------------




        adapter = new ItensCardapioAdapter(this,itensCardapios);
        listView.setAdapter(adapter);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent it2 = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(it2);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cardapio) {
            Intent it = new Intent(MainActivity.this, MainActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_login) {
            Intent it = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(it);

        } else if (id == R.id.nav_cadastrar) {

            Intent it = new Intent(MainActivity.this, CadastoActivity.class);
            startActivity(it);

        }else if (id == R.id.nav_maps) {
            Intent it = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(it);

        } else if (id == R.id.nav_sair) {

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
