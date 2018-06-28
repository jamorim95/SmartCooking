package com.developer.luisgoncalo.smartcooking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        String subtitulo;

        Receita receita = (Receita) getIntent().getSerializableExtra("receita");

        TextView receita_title = findViewById(R.id.receita_detalhes_titulo);
        /*TextView receita_subtitle = findViewById(R.id.receita_detalhes_subtitulo);
        TextView receita_texto = findViewById(R.id.receita_detalhes_texto);*/
        //TextView receita_fornecedor = findViewById(R.id.receita_fornecedor);

        switch (receita.getDificuldade()) {
            case 1:
                subtitulo = "Facil";
                break;
            case 2:
                subtitulo = "Intermedio";
                break;

            case 3:
                subtitulo = "Avançado";
                break;

            default:
                subtitulo = "Lendário";
                break;
        }

        subtitulo += "  +/- " + receita.getTempo_prep() + " minutos";

        receita_title.setText(receita.getTitle());
        /*receita_subtitle.setText(subtitulo);
        receita_texto.setText(receita.getSpecialString_ingrs()+"\n"+receita.getSpecialString_prep());*/

        //receita_fornecedor.setMovementMethod(LinkMovementMethod.getInstance());
        //receita_fornecedor.setText(getLinkFornecedor(receita.getFornecedor()));

        //String image_url = receita.getURLLink();

        //Toast.makeText(DetailsReceita_activity.this, receita.getURL_link(), Toast.LENGTH_SHORT).show();


        /*int loader = R.drawable.back;
        ImageView iv =(ImageView) findViewById(R.id.receita_image);

        ImageLoader imgload = new ImageLoader(getApplicationContext());

        imgload.DisplayImage(image_url, loader, iv);*/
    }


    public Spanned getLinkFornecedor(String nome) {
        String s = "";
        Spanned sp;

        if (nome.equals("Hoje Para Jantar")) {
            s = "<a href=\'http://hojeparajantar.blogspot.pt/'>Hoje para jantar</a>";
        } else if (nome.equals("SmartCooking")) {
            s = "<a href=\'https://www.facebook.com/SmartCookingApp/'>SmartCookingApp</a>";
        } else if (nome.equals("Mais Um Sobre Culinária")) {
            s = "<a href=\'http://maisumsobreculinaria.blogspot.pt/'>Mais Um Sobre Culinária</a>";
        } else if (nome.equals("Comida de Quinta")) {
            s = "<a href=\'http://comidadequinta.blogspot.pt/'>Comida de Quinta</a>";
        }

        sp = fromHtml(s);
        return sp;
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}