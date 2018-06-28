package com.developer.luisgoncalo.smartcooking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class PesquisaActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    private Button cleat_btn;

    // List view
    private ListView lista_receitas;

    // Listview Adapter
    MyAdapter adapter;

    // Search EditText
    EditText nomeReceitaPesquisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        //Menu
        mDrawerList = findViewById(R.id.navList);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        lista_receitas = findViewById(R.id.list_receitas);
        nomeReceitaPesquisa = findViewById(R.id.nomeReceita_search);


        cleat_btn = findViewById(R.id.clear_pesquisa);
        cleat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeReceitaPesquisa.getText().length() != 0)
                    nomeReceitaPesquisa.setText("");
            }
        });

        // Adding items to listview
        List<Receita> receitas = todosAsReceitas();
        adapter = new MyAdapter(receitas, this,PesquisaActivity.this);
        lista_receitas.setAdapter(adapter);


        // Enabling Search Filter
        nomeReceitaPesquisa.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (!nomeReceitaPesquisa.getText().toString().equals("")) { //if edittext include text
                    cleat_btn.setVisibility(View.VISIBLE);
                } else { //not include text
                    cleat_btn.setVisibility(View.GONE);
                }

                // When user changed the Text
                String text = cs.toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private List<Receita> todosAsReceitas() {
        return new ArrayList<>(Arrays.asList(
                new Receita(1, "Tostas de Frango no Forno",15,3,"Snack","SmartCooking","Levar um tacho ao lume com a cebola picada e uma colher de sopa de azeite e deixar refogar|Acrescentar o frango desfiado e envolver bem.|Polvilhar com a farinha e junte o leite.|Deixar cozinhar, mexendo sempre de modo a ficar com uma espécie de creme.|Temperar com sal, pimenta e reserve.|Rechear duas fatias de pão com o creme de frango e cubra com o queijo.|Tapar com a outra fatia de pão e leve à tostadeira para tostar o pão e derreter o queijo.|Servir ainda quente.","4 Fatias de pão caseiro ou pão de forma|Meia chávena de restos de frango cozinhado|Meia cebola|1 Colher de sobremesa de farinha|100ml de Leite|Azeite q.b.|2 Fatias de queijo|Sal e pimenta a gosto","https://smartcookingapp.files.wordpress.com/2015/10/receita_pgi.jpg","45|25|38|49|79"),
                new Receita(2, "Salsichas com Queijo e Fiambre",15,3,"Carne","SmartCooking","Estender uma fatia de fiambre e, por cima colocar uma fatia de queijo.|Barrar o queijo com a mostarda a seu gosto.|Colocar a salsicha por cima e enrolar nas fatias.|Polvilhar as salsichas enroladas com o queijo mozzarella.|Colocar no forno e deixe ficar até gratinar o queijo e está pronto a servir!","6 Salsichas para cachorro|6 Fatias de queijo|6 Fatias de fiambre|Queijo mozzarella|Mostarda q.b","https://smartcookingapp.files.wordpress.com/2015/10/sals.jpg","90|79|43|79|84|62"),
                new Receita(3, "Esparguete com atum e Rucula", 15,2,"Peixe","Comida de Quinta","Cozinhe o esparguete em agua fervente com sal. Enquanto isso tempere o atum com sal e pimenta, pincele com azeite e coloque numa frigideria anti-aderente por 30 segundos a 1 minuto, transfira para um prato.|Na mesma frigideira coloque o azeite, alcaparras, alho picado, frite até o alho dourar, adicione o esparguete cozido, rucula e suco de limao, e mexa para misturar.|Transfira para os pratos de servir, coloque o atum por cima.","Esparguete|Posta de atum|Azeite|sal|pimenta|2 colheres sopa Alcaparras|3 dentes Alho|Folhas de Rucula picadas|Suco de Limao","http://4.bp.blogspot.com/-OzBpI4GwzQM/VpbopX-mXkI/AAAAAAAAEtM/S-J30fCqndY/s1600/espaguete-atum-rucula.jpg","37|10|86"),
                new Receita(4, "Bolo da Caneca",10,1,"Sobremesa","SmartCooking","NOTA: A caneca deve ter capacidade mínima de 300 ml.|Na própria caneca onde irá consumir, colocar o ovo e bater bem com um garfo.|Colocar o óleo, o açúcar , o leite e o chocolate e bater novamente.|Colocar a farinha de trigo e o fermento e misturar delicadamente até encorpar.|Levar ao microondas por 3 minutos em potência alta.|NOTA:  No fim, pode ainda adicionar qualquer cobertura conforme desejar.","1 Ovo|4 Colheres de sopa de leite|3 Colheres de sopa de óleo|2 Colheres de sopa de chocolate em pó|4 Colheres de sopa de farinha de trigo|4 Colheres sopa de açúcar|1 colher de café de fermento em pó","https://smartcookingapp.files.wordpress.com/2015/11/caneca.jpg","49|65|28|38|1|42"),
                new Receita(5, "Tarte de Limão em Copo",25,4,"Sobremesa","Mais Um Sobre Culinária","Colocar num tacho o açúcar, a raspa e o sumo de limão e a manteiga.|Deixar ferver dois minutos e depois juntar aos ovos batidos, mexendo sempre.|Vai novamente ao lume,mexendo sempre até engrossar, sem deixar ferver.|Retirar e deixar arrefecer.|Depois de frio, colocar num frasco esterilizado.|Agora procedesse a preparação do merengue:|Bater as claras em castelo|Acrescentar o açúcar e bater mais um pouco até ficar firme|Depois colocar por cima para decorar os copos.|Por fim, para montar a sobremesa no copo, triture umas bolachas, junte um pouco de manteiga, para ficar igual a base da tarte|Deite por cima o curd de Limão|Decore com o merengue e queime com o maçarico.","Sumo de 3 limões|Raspa de 3 limões|200 g de Açúcar|65 g de Manteiga|3 Ovos|Bolachas maria|3 Claras de ovos|3 Colheres de sopa de açúcar","https://smartcookingapp.files.wordpress.com/2015/11/tartelimaocopo.jpg","1|53|67|16|30"),
                new Receita(6, "Sopa de Peixe",40,4,"Peixe","Mais Um Sobre Culinária","Cozer a cabeça do salmão (ou outro peixe a gosto)|Passa-se a água pelo passador, para eliminar vestígios de espinhas.|Fazer um refogado com cebola, alho, polpa de tomate e pimenta moída na hora|Acrescenta-se a água da cozedura do peixe e coloca-se os legumes a cozer.|Enquanto os legumes cozem, desfia-se a cabeça do salmão|Triturar bem os legumes e acrescentar a massa 'cotovelinhos'|Rectificar o sal, juntar o camarão e as delicias do mar.","1 Cabeça de salmão (ou outro peixe a gosto)|Cebola (por norma bastante)|Alho|Polpa de tomate|Cenoura|Batata|Alho francês|Courgette|Massa 'cotovelinhos'|Miolo de Camarão|Delícias do mar","https://smartcookingapp.files.wordpress.com/2015/11/sopapeixe1.jpg","71|88|25|76|56|36|13|5|33|61|35"),
                new Receita(7, "Alheira com Batata Frita e Ovo",15,2,"Carne","SmartCooking","Fritam-se as batatas|Ao mesmo tempo, barra-se uma frigideira com um pouco de azeite|Deixa-se aquecer e coloca-se a alheira|Vira-se de um lado e do outro com cuidado para não rebentar.|Estrela-se o ovo.|Serve-se com acompanhamento de legumes cozidos, ou se preferir, com uma salada.","1 Alheira|Batatas|1 Ovo|Legumes ou Saladas para acompanhamento","https://smartcookingapp.files.wordpress.com/2015/11/alheira-com-batata-frita-grelos-cozidos-e-ovo-estrelado51.jpg","4|13|48|87|67"),
                new Receita(8, "Salmão Grelhado",15,3,"Peixe","SmartCooking","NOTA: Para o peixe não pegar, antes de ir ao lume com um guardanapo de papel embebido em azeite passa-se na grelha de arame e deixa-se aquecer um pouco antes de colocar o peixe.|Tempera-se o peixe com sal e pode deixar-se durante cerca de vinte minutos.|Coloca-se o peixe a grelhar numa grelha de arame.|Não deixar o peixe no lume mais do que o tempo necessário para não secar.|Acompanhar com batata e bróculos cozidos temperados com bom azeite e vinagre ou salada.","Salmão em Posta|Batatas|Bróculos ou Salada|Azeite e Vinagre","https://smartcookingapp.files.wordpress.com/2015/11/salmao-batata.jpg","88|13|17|87|71"),
                new Receita(9, "Esparguete à Bolonhesa",20,3,"Carne","SmartCooking","Faz-se um refogado com a cebola, alho e chouriço picado.|Quando a cebola estiver \"transparente\" junta-se um pouco de polpa de tomate, mexe-se e deixa-se refogar por dois minutos.|Junta-se meio copo de água e quando levantar fervura junta-se a carne|Mexe-se bem para separar bem a carne.|De seguida tempera-se com um pouco de sal e em lume brando deixa-se refugar durante cerca de dez minutos.|Junta-se então o vinho e água até a carne ficar quase coberta|Tapa-se o tacho e deixa-se cozer, mexendo de vez em quando|Se for necessário junte mais um pouco de água para não secar demasiado.|Quando a carne estiver quase cozida rectificam-se os temperos e junta-se um pouco de mostarda e ketchup, deixando de seguida ferver mais um pouco.|Entretanto coze-se a massa com água, um dente de alho picado e um pouquinho de azeite.|Quando estiver cozida coloca-se num  tabuleiro de vidro e mistura-se a carne.","400g Carne picada|Cebola|Alho|Chouriço|Azeite|Polpa de tomate|Um cálice de vinho tinto, do Porto ou branco ou cerveja|Massa Esparguete|Mostarda e Ketchup (opcional)","https://smartcookingapp.files.wordpress.com/2015/11/esparguete_bolonhesa.jpg","22|23|25|29|76|37|62"),
                new Receita(10, "Peixe à Algarvia",30,5,"Peixe","SmartCooking","NOTA: A receita original é feita numa cataplana algarvia mas pode fazer-se num tacho térmico.|Tempera-se o peixe com sal e deixa-se algum tempo.|Aloura-se a cebola em rodelas com o azeite e os alhos|Frita-se o camarão inteiro nesse azeite durante alguns minutos.|Retira-se do lume e coloca-se o peixe de modo que o preparado anterior fique por cima do peixe.|Junta-se os pimentos cortados em tiras, as amêijoas e o caldo de peixe, previamente desfeito em dois decilitros de água|Não se põe sal porque o peixe já está temperado.|Tapa-se o tacho ou fecha-se a cataplana e vai ao lume (brando) durante cerca de vinte e cinco minutos. Só de abre na hora de servir|Mesmo antes de servir, polvilha-se com coentros picados.|Acompanha com pão torrado e manteiga de alho.","Peixe em posta (ex.perca do nilo, pargo)|Sal|Azeite|Pimento verde e vermelho|Alhos|Cebola|Caldo de peixe|Polpa de tomate|Camarão inteiro (pouca quantidade)|Amêijoas com casca|Coentros","https://smartcookingapp.files.wordpress.com/2015/12/peixe_sopa_peixe.jpg","71|73|25|76|21|6"),
                new Receita(11, "Bifes de Peru com Cogumelos",15,2,"Carne","SmartCooking","Cortam-se os bifes em tiras e temperam-se com sal alhos e um pouco de pimenta e deixam-se ficar cerca de meia hora|Depois numa frigideira coloca-se o azeite e fritam-se os bifes em lume baixo.|Quando estiverem quase fritos juntam-se os cogumelos e deixa-se mais um pouco no lume.|Por fim junta-se as natas e deixa ferver durante cerca de três ou quatro minutos em lume brando.|Acompanha com batata frita ou um arroz solto e uma salada.","Bifes de Peru|Cogumelos|Natas|Sal|Azeite|Alhos|Pimenta","https://smartcookingapp.files.wordpress.com/2015/11/500x500.jpg","15|31|63"),
                new Receita(12, "Ovos Mexidos com Chouriço",15,2,"Carne","SmartCooking","Corta-se o chouriço em pequenos cubos.|Numa frigideira coloca-se uma  colher de chá de margarina e deixa-se derreter em lume brando|De seguida junta-se os ovos inteiros e o chouriço.|Mexe-se com um garfo envolvendo-os  com a manteiga e deixando fritar até estarem 'sólidos'.|Retira-se do lume e numa travessa pequena tempera-se com um pouco de sal e salsa, ou pimenta moída.|Pode acompanhar-se com pão torrado e uma boa salada.","Ovos|Manteiga Margarina|Pão Torrado|Chouriço","https://smartcookingapp.files.wordpress.com/2015/12/farinhera_com_ovos_mexidos_3_d.jpg","67|29|53|68"),
                new Receita(13, "Esparguete com Miolo de Camarão", 30, 2, "Peixe", "SmartCooking", "Num tacho coloca-se a cebola picada, os alhos o chouriço cortado em bocadinhos pequeninos e o azeite|deixa-se refogar em lume brando mexendo de vez em quando para não torrar|quando a cebola estiver translúcida/\"transparente\", junta-se um pouco de polpa de tomate mexe-se|Junta-se o camarão que pode estar ainda congelado, tempera-se a gosto com sal e piripiri se quiser|Tapa-se o tacho e quando levantar fervura, deixa-se ferver cerca de dez minutos|Acrescenta-se mais um pouco de água e quando ferver junta-se a massa deixa-se cozer, rectifica-se o tempero|Serve-se em tabuleiro de vidro polvilhando com a salsa picada na hora de ir a mesa.","miolo de camarão|esparguete|cebola|alho|chouriço|azeite|polpa de tomate|salsa", "https://i0.wp.com/smartcookingapp.files.wordpress.com/2015/12/3386721948_c04ffc3880.jpg?w=450","61|37|25|29|76|89"),
                new Receita(14, "Frango Frito", 45, 3, "Carne", "SmartCooking", "Depois de cortado em bocados, tempera-se o frango com sal, alhos e limão|deixa-se algum tempo|Numa frigideira aquece-se o azeite ou óleo e em lume brando frita-se o frango, virando-se de vez em quando, para fritar bem|Pode acompanhar com arroz, massa esparguete ou batata frita e com uma boa salada ou legumes salteados.","frango|alho|louro|limão", "https://smartcookingapp.files.wordpress.com/2015/12/receita-frango-frito-americano.jpg?w=748&h=561","45|50"),
                new Receita(15, "Macarrão com Bacon, Fiambre, Presunto e Salsichas", 45, 2, "Carne", "SmartCooking", "Coze-se a massa com água, um dente de alho picado e um pouquinho de azeite|Cortam-se as carnes em cubos pequeninos. Corta-se o queijo aos bocadinhos|Quando a massa estiver cozida coloca-se num tabuleiro de vidro, uma camada massa cozida, uma camada de carnes e uma de queijo, repete-se ate terminarem e envolve-se tudo|Vai ao forno. De vez em quando mexe-se para envolver bem o queijo derretido e por fim deixa-se gratinar um pouco|Antes de servir polvilha-se com salsa picada.","massa macarrão|bacon|fiambre|presunto|salsicha|queijo|salsa", "https://smartcookingapp.files.wordpress.com/2015/12/macarrao.jpg?w=748","59|12|43|78|90|79|89"),
                new Receita(16, "Costeletas de Porco de cebolada", 45, 3, "Carne", "SmartCooking", "Tempera-se a carne com sal e um dente de alho|Num tacho faz-se um refogado com a cebola as rodelas, alhos e azeite|Junta-se a polpa de tomate deixa-se refogar um pouco e junta-se o vinho branco e um copo de água|coloca-se neste molho a carne depois de passada por farinha maizena|Baixa-se o lume e acrescenta-se mais um pouco de agua até a carne ficar completamente tapada|Deixa-se cozer e rectifica-se o tempero|Serve-se com batata cozida e legumes ou uma boa salada.","costeletas de porco do cachaco|cebola|alho|polpa de tomate|vinho branco|azeite", "https://smartcookingapp.files.wordpress.com/2015/12/5609379356_97fea9b14d.jpg?w=748&h=561","32|77|25|76"),
                new Receita(17, "Salada Americana com Molho French", 15, 1, "Vegetariano", "Hoje Para Jantar", "Lave e corte todos os vegetais aos cubinhos para dentro de uma taça.|Prepare o molho, misturando todos os ingredientes e deite por cima da salada envolvendo bem.", "1 tomate|1 cebola|1 alface|canónigos|rúcula|1 pepino|Para o molho: 2 colheres de sopa de azeite|1 colher de sobremesa de vinagre de vinho|1 colher de sobremesa de mostarda|sumo de 1/2 limão|sal|pimenta", "https://smartcookingapp.files.wordpress.com/2016/01/salada2bamericana2bcom2bmolho2bfrench.jpg?w=1462","25|3|86|72|62"),
                new Receita(18, "Salada Colorida", 10, 1, "Vegetariano", "Hoje Para Jantar", "Cortar os legumes aos cubos, dispor numa taça em camadas e decorar com as passas.|Temperar com flor de sal, azeite e vinagre de sidra e polvilhar com oregãos.", "1 tomate maduro|1/2 pimento vermelho|1/2 pimento verde|1 maçã|um punhado de passas|flor de sal|azeite|vinagre de sidra|oregãos", "https://smartcookingapp.files.wordpress.com/2016/01/salada2bcolorida.jpg?w=1462","74|73|51|70|66"),
                new Receita(19, "Salada Tropical", 10, 1, "Vegetariano", "Hoje Para Jantar", "Lave e corte a alface como o caldo verde mas com 1 cm de espessura.|Lave os tomates e corte às rodelas e depois aos quartos. Arranje o ananás e corte aos cubos.|Coloque todos os ingredientes numa saladeira.|Leve a amêndoa ao lume numa frigideira só para realçar o sabor e polvilhe a salada com elas.|Tempere com azeite, vinagre, sal e polvilhe com os orégãos e as folhas de manjericão cortadas.", "1 alface|4 tomates chucha|3 fatias de ananás|30 g de amêndoa palitada|orégãos q.b.|4 folhas de manjericão fresco|flor de sal|azeite|vinagre de sidra q.b.", "https://smartcookingapp.files.wordpress.com/2016/01/salada2btropical.jpg?w=1462","3|8|66|52"),
                new Receita(20, "Caracóis de Queijo e Fiambre", 15, 2, "Snack", "Hoje Para Jantar", "Em cima da tábua de corte, desenrole a massa folhada e tape com as fatias de fiambre e queijo.|Enrole como se fosse uma torta e corte às fatias com 1 cm de espessura.|Coloque as fatias num tabuleiro forrado com papel vegetal e leve ao forno quente (200ºC) durante 15 minutos. Retire do forno e sirva ainda quentes.", "1 base de massa folhada fresca|100 g de fiambre fatiado|100 g de queijo fatiado", "https://smartcookingapp.files.wordpress.com/2016/01/caracois2bde2bfiambre2be2bqueijo.jpg?w=1462","58|43|79"),
                new Receita(21, "Pão de Alho", 5, 2, "Snack", "Hoje Para Jantar", "Corte a baguete em fatias com a grossura de um dedo.|Entretanto coloque os alhos no esmagador e coloque-os numa taça juntamente com a manteiga.|Leve esta mistura ao microondas por 10 segundos.|Pincele as fatias de pão com a manteiga de alho.|Coloque 1 fatia de queijo sobre cada uma das fatias de pão, polvilhe com um pouco de oregão e leve ao forno forte para gratinar o queijo e torrar o pão.|Sirva quente como aperitivo antes do jantar.", "1 baguete|75g de manteiga|4 dentes de alho|100gr de queijo amanteigado ou mozzarella|oregãos q.b. (opcional)", "https://smartcookingapp.files.wordpress.com/2016/01/pao2bde2balho.jpg?w=1462","53|80|66|68"),
                new Receita(22, "Tapas de Queijo de Cabra e Tomate", 10, 2, "Snack", "Hoje Para Jantar", "Corte o pão às fatias e pincele cada uma com manteiga de alho (aquecida no microondas).|Em metade do pão, coloque uma fatia de tomate e por cima um bocadinho de mozzarella.|Polvilhe com oregãos e com o manjericao picado.|Nas restantes fatias de pão, coloque uma fatia de queijo de cabra e polvilhe com oregãos.|Tempere com um bocadinho de pimenta.|Leve ao forno quente (200ºC) durante 10 minutos.", "1 pão tipo baguete (se não tiver, qualquer pão dá, basta cortar a parte de cima e a de baixo e fazer duas fatias)|2 tomates fatiados|queijo de cabra|queijo mozzarella|4 folhas de manjericão|oregãos e pimenta q.b.|manteiga de alho", "https://smartcookingapp.files.wordpress.com/2016/01/tapas2bde2bqueijo2bde2bcabra2be2btoamate2bcom2bmanjeric25c325a3o.jpg?w=1462","68|81|79|84|52|66|54|53"),
                new Receita(23, "Pãezinhos com Chouriço", 20, 2, "Snack", "Hoje Para Jantar", "Corte pequenas bolinhas na massa de pão.|Estenda as bolinhas de massa e coloque 2 fatias de chourição, enrole e coloque no tabuleiro previamente forrado com papel vegetal.|Polvilhe os pães com farinha e faça 3 golpes na diagonal em cada pão.|Leve ao forno quente (200ºC) durante 20 minutos.", "massa de pão|fatias de chourição", "https://smartcookingapp.files.wordpress.com/2016/01/paezinhos2bcom2bchouri25c325a7o.jpg?w=1462","57|29"),
                new Receita(24, "Risotto de Abóbora e Brócolos", 35, 3, "Vegetariano", "Hoje Para Jantar", "Arranje a abóbora e corte-a aos cubos todos do mesmo tamanho.|Lave os brócolos e separe os raminhos.|Leve-os a cozer em água temperada com sal.|Deixe levantar fervura e deixe cozer com o tacho destapado durante cinco minutos.|Escorra e coloque de imediato em água bem fria ou gelada. Deixe escorrer novamente e reserve. |Pique a cebola finamente.|Deite um fio de azeite num tacho e junte a cebola.Deixe cozinhar em lume brando, para que não ganhe cor.|Junte a abóbora aos cubos e deixe cozinhar durante alguns minutos, até começar a ficar macia.|Acrescente o arroz e deixe-o fritar ao mesmo tempo que absorve o sabor da abóbora.|Refresque com um pouco de vinho branco (não mais que meio copo), mexa e deixe-o evaporar.|No momento em que o arroz começa a ficar seco, junte uma concha de caldo de galinha quente. |Continue a mexer e vá acrescentando caldo à medida que o arroz o vai absorvendo.|O arroz demora cerca de 18-20 minutos a cozer. Cinco minutos antes do final deste tempo, junte os brócolos cozidos.|Quando o arroz estiver cozido, retire o tacho do lume e junte o queijo parmesão.|Prove e verifique se o sal do queijo é suficiente. Se necessário, tempere com flor de sal.|Sirva de imediato.", "arroz caranoli|100 g de abóbora|1 cebola média|1 brócolo|queijo parmesão|caldo de galinha caseiro|vinho branco de boa qualidade|flor de sal", "https://smartcookingapp.files.wordpress.com/2016/01/risotto2bde2babc3b3bora2be2bbrocolos2bhoje2bpara2bjantar2b3.jpg?w=1462","9|0|25|85|20|17"),
                new Receita(25, "Bolo de Cenoura com cobertura de Chocolate", 50, 3, "Sobremesa", "Hoje Para Jantar", "Forre o fundo de um tabuleiro com papel vegetal e depois unte com manteiga e enfarinhe.|Coza a cenoura e depois de bem escorrida, triture-a. Reserve.|Ligue o forno a 180ºC.|Numa taça bata os ovos com o açúcar até obter uma massa fofa, esbranquiçada e a fazer bolhas na superfície.|Junte a cenoura e bata mais um pouco.|Acrescente o óleo e depois a farinha e o fermento.|Deite a massa no tabuleiro e com a ajuda do rapa-tudo nivele a massa para que não fique mais alta no meio.|Leve a cozer na prateleira do meio durante 40 minutos. Faça o teste do palito na zona mais central do tabuleiro. Assim que o palito saia seco, retire o bolo do forno para que não seque. Ele fica no ponto, húmido e fofo se não cozer demasiado!|Retire e deixe arrefecer um pouco antes de desenformar.|Preparação da Cobertura:|Misture todos os ingredientes e bata muito bem.|Se não tiver a certeza da \"frescura\" dos ovos, leve esta mistura ao lume para que a gema coza.|Depois de desenformar o bolo, pode simplesmente cobrir com o chocolate ou cortar ao meio, rechear com chocolate, colocar a outra metade por cima e cobrir com o restante chocolate.", "Bolo:|500 g de cenoura cozida e escorrida|4 ovos à temperatura ambiente|2 chávenas de açúcar|2 chávenas de farinha|1/2 chávena de óleo|1 c. de chá bem cheia de fermento|Cobertura:|1 pacote de chocolate|12 c. sopa de leite|1 c. sopa manteiga|1 gema de ovo fresco|6 c. sopa de açúcar em pó", "https://smartcookingapp.files.wordpress.com/2016/01/bolodecenouraechocolatecarrotandchocopatecake3.jpg?w=1462","26|67|1|38|65|42|27|28|49|53"),
                new Receita(26, "Bolo de Chocolate e Café com cobertura de Cacau", 40, 3, "Sobremesa", "Hoje Para Jantar", "Bata os ovos com o açúcar até obter uma massa fofa e com bolhas.|Junte o chocolate em pó e o óleo mexendo sempre.|Acrescente a farinha e quando estiver bem batido, deite cuidadosamente uma chávena de café acabado de fazer.|Deite a massa num tabuleiro untado com manteiga e farinha ou forrado com papel vegetal.|Leve ao forno pré-aquecido a 180ºC durante 30 minutos.|Retire do forno, desenforme e deixe arrefecer o bolo em cima de uma rede.|Cobertura: |Derreta a manteiga no microondas e junte aos restantes ingredientes.|Deite por cima do bolo e decore a gosto.", "4 ovos|2 chávenas de açúcar|1 pacote de chocolate em pó|3/4 chávena de óleo|2 chávenas de farinha para bolos|1 colher de chá de fermento em pó|1 chávena de café Delta Lote Angola|Cobertura:|1 pacote de cacau|6 colheres de açúcar em pó|12 colheres de leite|3 colheres de manteiga magra", "https://smartcookingapp.files.wordpress.com/2016/01/bolodechocolateecafc3a9hojeparajantar2.jpg?w=1462","67|1|27|28|65|38|42|19|18|49|53"),
                new Receita(27, "Bolo de Chocolate para emergências", 60, 3, "Sobremesa", "Hoje Para Jantar", "Numa taça, misture o cacau em pó com 225 ml de água a ferver. Mexa bem até ficar cremoso e sem grumos. Junte o chocolate de leite partido aos pedacinhos e mexa muito bem até este derreter.|Noutra taça, bata a manteiga com o açúcar até obter uma massa macia.|Junte os ovos, um a um, batendo sempre.|Junte a farinha e o fermento e envolva sem bater.|Acrescente o chocolate e mexa até ficar bem misturado.|Deite a massa para a cuba da máquina do pão, devidamente untada.|Selecione o programa de cozer e programe 60 minutos.|Deixe arrefecer um pouco antes de desenformar.|Pode servir simples ou com uma cobertura feita com 200 g de chocolate negro, 175g de açúcar amarelo e 150 g de manteiga sem sal. Basta derreter o chocolate em banho maria ou no microondas e juntar ao açúcar batido com a manteiga.", "75 g de cacau em pó|75 g de chocolate de leite|150 g de manteiga sem sal|250 g de  açúcar mascavado|2 ovos|200 g de farinha auto-levedante|1/2 c. chá de fermento|225 ml de água", "https://smartcookingapp.files.wordpress.com/2016/01/bolo2bde2bchocolate2bmfp2bhoje2bpara2bjantar2b2.jpg?w=1462","18|27|53|1|2|67|38|42"),
                new Receita(28, "Bacalhau com legumes",15,2,"Peixe","SmartCooking","Cozem-se os legumes com o bacalhau e ovo|Serve-se tudo ainda quente temperado com azeite e um pouco de vinagre (se se quiser poderá temperar-se também com um pouco de pimenta).","1 Posta de Bacalhau|Batata|Feijão verde ou bróculos|Cenoura|1 Ovo|Azeite e vinagre q.b.","http://www.receitasemenus.net/wp-content/uploads/2012/12/bacalhau-cozido-legumes.jpg","11|13|17|41|26|67|71"),
                new Receita(29, "Costeleta grelhada com arroz de bróculos", 30, 4, "Carne", "SmartCooking","Tempera-se a carne com um pouco de sal e dente de alho, deixa-se um pouco a tomar o tempero.|Num tacho colocam-se os restantes alhos picados com azeite e deixa-se aquecer em lume brando, junta-se o arroz e deixa-se fritar mexendo sempre durante cerca de 3 ou 4 minutos. Junta-se água e deixa-se levantar fervura, junta-se os bróculos cortados e bocadinhos pequeninos, tempera-se comum pouco de sal e deixa-se cozer. Quando estiver quase cozido apaga-se o lume, mexe-se e tapa-se o tacho.|Para o arroz ficar mais soltinho deverá utilizar-se três medidas de água por cada uma de arroz.|Entretanto na Chapa do grelhador ou no grelhador coloca-se a carne a grelhar sem deixar secar muito.|Serve-se com boa salada.", "1 Costoleta de porco (do Cachaço) ou de vitela|150 g Arroz agulha|4 Dentes de alho|1 Bróculo pequeno|Azeite q.b|Pimenta", "http://tgexpress.net/shop/components/com_virtuemart/shop_image/product/X24._FRIEDRICE__4bac4ebda946b.jpg","77|92|9|32|17"),
                new Receita(30, "Esparguete com Atum e Molho de Tomate",15,2,"Peixe","SmartCooking","Refogue a cebola e o alho picados, no azeite.|Acrescente o tomate e deixe cozinhar.|Junte o atum e tempere a gosto com oregaos e pimenta e, se necessario uma pitada de sal.|Entretanto coza o esparguete em água e sal.|Misture suavemente com o molho preparado e bastante queijo ralado.|Sirva imediatamente.","400gr Tomates maduros cortados aos bocados|350gr Esparguete|50gr Atum|1 Cebola|Queijo Ralado|Oregaos|Sal|Pimenta|Azeite","http://cdn.temperando.com/wp-content/uploads/2012/07/MACARRAO-MOLHO-TOMATE-PELADO.jpg","37|10|25|79|83|66"),
                new Receita(31, "Coxas de Frango no Forno com Batatinhas", 20, 3, "Carne", "SmartCooking", "Esmagam-se cinco dentes de alho e junta-se azeite, louro pimentão doce e piripiri (caso se goste) mexe-se tudo e com esse molho barra-se o frango que entretanto foi temperado com sal. Deixa-se ficar cerca de meia hora.|Num tabuleiro de vidro (que possa ir ao forno) coloca-se cebola ás rodelas e o fango temperado por cima. Á volta colocam-se as batatas descascadas. Por cima das batatas espalha-se o restante molho do frango. Junta-se o vinho branco e um copo de água (de modo as batatas ficar quase tapadas).|Vai ao forno pré aquecido, até a carne e as batatas estarem \"lourinhas\".|E serve-se com uma boa salada.", "Coxas de frango (ou frango inteiro)|Sal|Alhos|Pimentão doce|Louro|Azeite|PiriPiri|Cebola|Cálice vinho branco|Batata miúda (ou cortada em quartos)", "http://littlebitesofeverything.com/wp-content/uploads/2013/02/067.jpg","34|45|22|75|25|13"),
                new Receita(32, "Filetes de Pescada com Arroz de tomate", 25, 4, "Peixe", "SmartCooking", "Tempera-se o peixe com sal, alhos e sumo de limão. E deixa-se durante algum tempo.|Numa frigideira aquece-se óleo de girassol ou outro óleo alimentar a gosto. Passa-se os filetes por ovo mexido e de seguida por pão ralado e vai a fritar.|Quando estiverem fritos colocam-se numa travessa com papel de cozinha dobrado ou um guardanapo de papel, para absorver a gordura em excesso.|Entretanto aloura-se a cebola picada, com azeite, alho, bocadinhos de chouriço de carne e o pimento cortado em bocadinhos pequenos. Deixa-se refogar e junta-se a polpa de tomate deixa-se um pouco mais no lume e junta-se meio copo de água, tapa-se deixa-se ferver cerca de três ou quatro minutos.|Junta-se a água suficiente para cozer o arroz e quando este ferver junta-se o arroz,mexe-se de deixa-se cozer, rectifica-se o tempero de sal.|E serve-se com uma boa salada.", "Filetes de Pescada|Sal|Limão|Alhos|Pão Ralado|Ovos|Arroz|Cebola|Polpa de Tomate (ou tomate maduro pelado)|Chouriço|Azeite|Pimento verde", "http://www.segredosdavo.pt/cms_sa/images/filetes_pescada.jpg","44|71|68|69|67|9|25|76|73|29"),
                new Receita(33, "Gambas à Oriental com Arroz de Castanhas", 20, 3, "Peixe", "SmartCooking", "Tempera-se as gambas com algum tempo de antecedência, com sal, piripiri, louro.|Num tacho alouraram-se os alhos com o azeite, junta-se o caldo de galinha previamente dissolvido num 1dl água quente. Deixa-se levantar fervura e juntam-se as castanhas laminadas. Quando estiver em quase cozidas, acrescenta-se a água suficiente para a cozedura do arroz.|Coze-se o arroz e no final tapa-se até servir para secar um pouco e ficar soltinho.|Numa frigideira aquece-se o azeite ou o óleo e fritam-se as gambas.|Retiram-se e colocam-se numa travessa com papel de cozinha para absorver a gordura em excesso.","Gambas inteiras|Sal|Piripiri|Louro|Alhos|Arroz agulha|Azeite|Caldo de galinha (Knorr)|Castanhas (descascadas)", "http://2.bp.blogspot.com/-cvgZ0lZ7t2A/TVqMXxuq41I/AAAAAAAAB-Q/QE14Cw0pT9o/s1600/cama","46|75|50|9|20|24"),
                new Receita(34, "Panados com Arroz Primavera", 30, 3, "Carne", "SmartCooking", "Tempera-se a carne com sal, alhos e limão e deixa-se algum tempo.|Numa frigideira aquece-se o azeite ou óleo e frita-se a carne depois de passada por ovo mexido e pão ralado. Retira-se do lume e colocam-se, antes de servir, numa travessa com papel de cozinha para absorver a gordura em excesso.|Num tacho aloura-se em azeite o bacon cortado em pequenos cubos e junta-se os alhos picados e os legumes, mexe-se. Junta-se um pouco de água e deixa-se ferver, junta-se o caldo de galinha.|Acrescenta-se a água suficiente para cozer o arroz, tempera-se com sal a gosto e quando estiver cozido desliga-se o lume e tapa-se para secar um pouco.", "Bifes de peru ou Bifanas de porco|Sal|Alhos|Louro|Limão|Azeite/Óleo|Arroz|Ervilhas|Milho doce cozido|Cenoura|Pimento vermelho|Bacon|Cubo de caldo de galinha (Knorr)", "http://www.teleculinaria.pt/wp-content/uploads/2015/04/Panados_com_arroz_primavera_3_Detalhe.jpg","14|15|77|50|65|9|36|60|26|74|12|20"),
                new Receita(35, "Salada de Frango", 10, 1, "Snack", "SmartCooking", "Depois de bem lavados os legumes, coloca-se as alfaces ripadas, o tomate cortado apenas ao meio, a cenoura ralada, a rucúla, a cebola em rodelas separadas e o frango.|Tempera-se com sal, um pouco de bom azeite e um pouco de vinagre balsâmico.|Junta-se o queijo cortado em pequenos cubos e as nozes em metades ou quartos.|E serve-se de imediato.","Frango cozido desfiado (pode ser utilizado peito de frango ou aproveitar a sobra de outra refeição)|Alface roxa e branca|Tomate Cherry|Rúcula|Cenoura|Cebola|Nozes descascadas|Queijo fresco (ou outro a gosto)", "http://ccook3.vila.to/receita/salada-tex-mex-com-frango-f8-13410.jpg","45|3|86|26|25|64|82"),
                new Receita(36, "Massa com atum",15,2,"Peixe","SmartCooking","Começar por fazer um refogado com azeite, alhos e cebola.|Quando a cebola estiver transparente juntar o atum escorrido do oleo.|Deixar cozinhar por 10 minutos, mexendo para envolver com o refogado.|Aparte comece a cozer a massa em água abundante temperada com sal.|Juntar a polpa de tomate ao atum, mexer, e ao fim de 10 minutos misturar as natas.|Quando a massa estiver cozida escorrê-la e juntar o prepaado de atum.","350gr Esparguete|2 Latas de Atum|2 Alhos|1 Cebola media|Sal|1 Pacote Polpa de Tomate|1 Pacote Natas","http://receitas-faceis.e-menta.pt/wp-content/uploads/2014/11/massa-com-atum.jpg","37|10|25|76|63"),
                new Receita(37, "Ovos Mexidos com Atum",10,1,"Peixe","SmartCooking","Mexa bem os ovos numa taça ou prato fundo e adicione a salsa picada, a pimenta e o sal, envolvendo tudo.|Derreta a manteiga numa frigideira em lume brando e junte a cebola picada. Deixe alourar ligeiramente.|Acrescente o atum em lata escorrido e envolva com a cebola durante alguns segundos.|Adicione finalmente os ovos e vá mexendo até estes cozerem. Retire-os da frigideira e sirva de imediato.|Acompanhe com umas tostas ou com uma simples fatia de pão.","3 Ovos|1 Lata de Atum|1 Colher Sopa de Manteiga|Sal|Pimenta|Salsa Picada","http://sm2.imgs.sapo.pt/mb/5/2/6c4c6828ede96225e31099ede115557f87ce9c.jpg","67|10|53|89")

        ));
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
                        i=new Intent(PesquisaActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 1:
                        mDrawerLayout.closeDrawers();
                        break;
                    case 2:
                        i=new Intent(PesquisaActivity.this, CategoriasActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 3:
                        i=new Intent(PesquisaActivity.this, TodasActivity.class);
                        startActivity(i);
                        finish();
                        break;
                    case 4:
                        i=new Intent(PesquisaActivity.this, AcercaActivity.class);
                        startActivity(i);
                        finish();
                        break;
                }

            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
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
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }
}
