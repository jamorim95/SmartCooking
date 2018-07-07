package com.developer.luisgoncalo.smartcooking;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Receita receita = (Receita) getIntent().getSerializableExtra("receita");

        //Toast.makeText(DetalhesActivity.this, receita.getNome(), Toast.LENGTH_SHORT).show();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView receita_title = findViewById(R.id.receita_detalhes_titulo);
        TextView receita_subtitle = findViewById(R.id.receita_detalhes_subtitulo);
        TextView receita_texto = findViewById(R.id.receita_detalhes_preparacao);
        //TextView receita_fornecedor = findViewById(R.id.receita_fornecedor);

        String subtitulo = "Tempo: ";
        subtitulo += receita.getTempo() + " min, Dificuldade: ";

        switch (receita.getDificuldade()) {
            case 1:
                subtitulo += "Facil";
                break;
            case 2:
                subtitulo += "Intermedio";
                break;

            case 3:
                subtitulo += "Avançado";
                break;

            default:
                subtitulo += "Lendário";
                break;
        }

        receita_title.setText(receita.getNome());
        receita_subtitle.setText(subtitulo);
        receita_texto.setText(receita.getPreparacaoString());

        /*String imageUri = receita.getImagem();

        Toast.makeText(DetalhesActivity.this, imageUri, Toast.LENGTH_SHORT).show();

        ImageView iv = findViewById(R.id.receita_image);

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(DetalhesActivity.this));

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(imageUri, iv);*/
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