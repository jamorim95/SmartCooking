package com.developer.luisgoncalo.smartcooking;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class FiltrarReceitasActivity extends AppCompatActivity {

    private LinearLayout layout;
    private String categoria;
    private ArrayList<Button> lista_btn;

    private ArrayList<Receita> lista_receitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_receitas);


        lista_receitas = new ArrayList<>();
        lista_btn = new ArrayList<>();


        layout = (LinearLayout) findViewById(R.id.layout_FiltrarReceitas);


        categoria = getIntent().getStringExtra("categoria");

        //lista_receitas = receitas_database.getReceitasBy_categoria(s);


        //updateLayout(lista_receitas);
    }


    private void updateLayout(ArrayList<Receita> lista){
        Button btn;

        for(final Receita r:lista){
            btn = new Button(FiltrarReceitasActivity.this);
            btn.setText(r.getTitle());
            btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FiltrarReceitasActivity.this, DetalhesActivity.class);
                    i.putExtra("receita", r);
                    startActivity(i);
                }
            });

            lista_btn.add(btn);
        }

        for(Button b:lista_btn){
            layout.addView(b);
        }
    }


    private void SortPesoPesquisa(ArrayList<Receita> lista){
        Receita[] receitas;
        receitas = lista.toArray(new Receita[lista.size()]);
        Arrays.sort(receitas, Receita.ReceitaNameComparator2);
    }

}
