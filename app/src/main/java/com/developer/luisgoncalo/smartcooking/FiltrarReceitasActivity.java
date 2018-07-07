package com.developer.luisgoncalo.smartcooking;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltrarReceitasActivity extends AppCompatActivity {
    private String categoria;
    private ArrayList<Receita> receitas;

    // List view
    private ListView lista_receitas;

    // Listview Adapter
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_receitas);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        lista_receitas = findViewById(R.id.layout_FiltrarReceitas);

        categoria = getIntent().getStringExtra("categoria");

        // Adding items to listview
        List<Receita> receitas = todosAsReceitas(); //Get receitas por categoria
        adapter = new MyAdapter(receitas, this,FiltrarReceitasActivity.this);
        lista_receitas.setAdapter(adapter);
    }

    private List<Receita> todosAsReceitas() {
        return new ArrayList<>(Arrays.asList(
                new Receita(1, "Tostas de Frango no Forno",15,3,"Snack","https://i.redditmedia.com/asjwnETQdQ4SouvtlCFU2Ek6-TeDNj_fu_XeH88T40Y.jpg?w=903&s=45dbac737ef1389eccee05cd4eade812"),
                new Receita(2, "Salsichas com Queijo e Fiambre",15,3,"Carne"),
                new Receita(3, "Esparguete com atum e Rucula", 15,2,"Peixe"),
                new Receita(4, "Bolo da Caneca",10,1,"Sobremesa"),
                new Receita(5, "Tarte de Limão em Copo",25,4,"Sobremesa"),
                new Receita(6, "Sopa de Peixe",40,4,"Peixe"),
                new Receita(7, "Alheira com Batata Frita e Ovo",15,2,"Carne"),
                new Receita(8, "Salmão Grelhado",15,3,"Peixe"),
                new Receita(9, "Esparguete à Bolonhesa",20,3,"Carne"),
                new Receita(10, "Peixe à Algarvia",30,5,"Peixe"),
                new Receita(11, "Bifes de Peru com Cogumelos",15,2,"Carne"),
                new Receita(12, "Ovos Mexidos com Chouriço",15,2,"Carne"),
                new Receita(13, "Esparguete com Miolo de Camarão", 30, 2, "Peixe"),
                new Receita(14, "Frango Frito", 45, 3, "Carne"),
                new Receita(15, "Macarrão com Bacon, Fiambre, Presunto e Salsichas", 45, 2, "Carne"),
                new Receita(16, "Costeletas de Porco de cebolada", 45, 3, "Carne"),
                new Receita(17, "Salada Americana com Molho French", 15, 1, "Vegetariano"),
                new Receita(18, "Salada Colorida", 10, 1, "Vegetariano"),
                new Receita(19, "Salada Tropical", 10, 1, "Vegetariano"),
                new Receita(20, "Caracóis de Queijo e Fiambre", 15, 2, "Snack"),
                new Receita(21, "Pão de Alho", 5, 2, "Snack"),
                new Receita(22, "Tapas de Queijo de Cabra e Tomate", 10, 2, "Snack"),
                new Receita(23, "Pãezinhos com Chouriço", 20, 2, "Snack"),
                new Receita(24, "Risotto de Abóbora e Brócolos", 35, 3, "Vegetariano"),
                new Receita(25, "Bolo de Cenoura com cobertura de Chocolate", 50, 3, "Sobremesa"),
                new Receita(26, "Bolo de Chocolate e Café com cobertura de Cacau", 40, 3, "Sobremesa"),
                new Receita(27, "Bolo de Chocolate para emergências", 60, 3, "Sobremesa"),
                new Receita(28, "Bacalhau com legumes",15,2,"Peixe"),
                new Receita(29, "Costeleta grelhada com arroz de bróculos", 30, 4, "Carne"),
                new Receita(30, "Esparguete com Atum e Molho de Tomate",15,2,"Peixe"),
                new Receita(31, "Coxas de Frango no Forno com Batatinhas", 20, 3, "Carne"),
                new Receita(32, "Filetes de Pescada com Arroz de tomate", 25, 4, "Peixe"),
                new Receita(33, "Gambas à Oriental com Arroz de Castanhas", 20, 3, "Peixe"),
                new Receita(34, "Panados com Arroz Primavera", 30, 3, "Carne"),
                new Receita(35, "Salada de Frango", 10, 1, "Snack"),
                new Receita(36, "Massa com atum",15,2,"Peixe"),
                new Receita(37, "Ovos Mexidos com Atum",10,1,"Peixe")

        ));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
