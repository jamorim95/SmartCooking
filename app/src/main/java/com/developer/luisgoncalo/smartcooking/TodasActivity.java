package com.developer.luisgoncalo.smartcooking;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class TodasActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    private LinearLayout layout;
    private ArrayList<Button> lista_btn;


    ArrayList<Receita> lista_receitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        lista_receitas=new ArrayList<>();
        lista_btn=new ArrayList<>();

        layout=(LinearLayout) findViewById(R.id.layout_todasReceitas);


        //lista_receitas=getTodasReceitas();

        lista_receitas.add(new Receita("Tostas de Frango no Forno",15,3,"Snack","SmartCooking","Levar um tacho ao lume com a cebola picada e uma colher de sopa de azeite e deixar refogar|Acrescentar o frango desfiado e envolver bem.|Polvilhar com a farinha e junte o leite.|Deixar cozinhar, mexendo sempre de modo a ficar com uma espécie de creme.|Temperar com sal, pimenta e reserve.|Rechear duas fatias de pão com o creme de frango e cubra com o queijo.|Tapar com a outra fatia de pão e leve à tostadeira para tostar o pão e derreter o queijo.|Servir ainda quente.","4 Fatias de pão caseiro ou pão de forma|Meia chávena de restos de frango cozinhado|Meia cebola|1 Colher de sobremesa de farinha|100ml de Leite|Azeite q.b.|2 Fatias de queijo|Sal e pimenta a gosto","https://smartcookingapp.files.wordpress.com/2015/10/receita_pgi.jpg","45|25|38|49|79"));

        SortAlfabetic(lista_receitas);
        updateLayout(lista_receitas);
    }


    private void updateLayout(ArrayList<Receita> lista){
        Button btn;
        for(final Receita r:lista){
            btn = new Button(TodasActivity.this);
            btn.setText(r.getTitle());
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(TodasActivity.this, DetalhesActivity.class);
                    i.putExtra("receita", r);
                    startActivity(i);
                    //finish();
                }
            });

            lista_btn.add(btn);
        }
        for(Button b:lista_btn){
            layout.addView(b);
        }
    }


    private void SortAlfabetic(ArrayList<Receita> lista){
        Receita[] receitas;
        receitas = lista.toArray(new Receita[lista.size()]);
        Arrays.sort(receitas, Receita.ReceitaNameComparator);
    }


    private void addDrawerItems() {
        String osArray[] = getResources().getStringArray(R.array.menu);

        mAdapter = new ArrayAdapter<>(this, R.layout.menu, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position){
                    case 0:
                        i=new Intent(TodasActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 1:
                        i=new Intent(TodasActivity.this, PesquisaActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 2:
                        i=new Intent(TodasActivity.this, CategoriasActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 3:
                        mDrawerLayout.closeDrawers();
                        break;
                    case 4:
                        i=new Intent(TodasActivity.this, AcercaActivity.class);
                        startActivity(i);
                        finish();
                        break;
                }

            }
        });
    }


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            // Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            // Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}