package com.developer.luisgoncalo.smartcooking;


import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Receita implements Serializable,Comparable<Receita> {
    private long id;   // uma boa ideia é por este ID= ao índice da receita na lista de TODAS as receitas
    private String title;
    private String lista_ingr;
    private int dificuldade;
    private int tempo_prep;   // EM MINUTOS
    private String categoria;
    private String fornecedor;
    private String preparacao;
    private String URLLink;
    private String ids_ingr;
    private int pesoPesquisa;


    public Receita(long id, String title, int tempo_prep, int dificuldade, String categoria, String fornecedor,  String prep, String lista_ingr, String URLLink, String ids_ingr){
        this.id=id;
        this.title=title;
        this.categoria=categoria;
        this.lista_ingr=lista_ingr;
        this.dificuldade=dificuldade;
        this.tempo_prep=tempo_prep;
        this.fornecedor=fornecedor;
        this.preparacao=prep;
        this.URLLink=URLLink;
        this.ids_ingr=ids_ingr;
    }




    public Receita(){

    }

    public Receita(String title, int dificuldade, String URLLink){
        this.title=title;
        this.dificuldade=dificuldade;
        this.URLLink= URLLink;
    }

    public Receita(String title, int tempo_prep, int dificuldade, String categoria, String fornecedor,  String prep, String lista_ingr, String URLLink, String ids_ingr){
        this.title=title;
        this.categoria=categoria;
        this.lista_ingr=lista_ingr;
        this.dificuldade=dificuldade;
        this.tempo_prep=tempo_prep;
        this.fornecedor=fornecedor;
        this.preparacao=prep;
        this.URLLink=URLLink;
        this.ids_ingr=ids_ingr;
    }


    // Calcular o peso da pesquisa

    public void setPesoPesquisa(ArrayList<String> listaIngrs){
        pesoPesquisa=existIngrs(listaIngrs);
    }

    public int existIngrs(ArrayList<String> lista) {
        ArrayList<String> aux = this.getListaIngr();
        int count = 0;
        for (String s : lista) {
            for (String s2 : aux) {
                if (s2.toLowerCase().contains(s.toLowerCase())) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }



    // Gerar as listas dos ingredientes e da preparação

    public ArrayList<String> getListaIngr(){
        ArrayList<String> lista=new ArrayList<>();
        String s;
        if(this.lista_ingr.isEmpty()){
            return lista;
        }
        if(!this.lista_ingr.contains("|")){
            lista.add(lista_ingr);
            return lista;
        }

        String auxIngr=this.lista_ingr;
        StringTokenizer token= new StringTokenizer(auxIngr,"|");

        while(token.hasMoreElements()){
            lista.add((String)token.nextElement());
        }
        return lista;
    }

    public ArrayList<String> getListaPrep(){
        ArrayList<String> lista=new ArrayList<>();
        String s;
        if(this.preparacao.isEmpty()){
            return lista;
        }
        if(!this.preparacao.contains("|")){
            lista.add(lista_ingr);
            return lista;
        }

        String auxIngr=this.preparacao;
        StringTokenizer token= new StringTokenizer(auxIngr,"|");

        while(token.hasMoreElements()){
            lista.add((String)token.nextElement());
        }
        return lista;
    }



    // Gerar Texto para a Descriçao da Receitaa

    public String getSpecialString_ingrs(){
        String str="";
        ArrayList<String> lista=this.getListaIngr();
        String aux;

        for(int i=0; i<lista.size(); i++){
            aux=lista.get(i);
            str+="-  " + aux;
            if(i<lista.size()-1){
                str+="\n";
            }
        }
        return str;
    }

    public String getSpecialString_prep(){
        String str="";
        ArrayList<String> lista=this.getListaPrep();
        String aux;

        for(int i=0; i<lista.size(); i++){
            aux=lista.get(i);
            str+="-  " + aux;
            if(i<lista.size()-1){
                str+="\n";
            }
        }
        return str;
    }



    // Getter e Setters

    public long getmID() {
        return id;
    }

    public void setmID(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLista_ingr() {
        return lista_ingr;
    }

    public void setLista_ingr(String lista_ingr) {
        this.lista_ingr = lista_ingr;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getTempo_prep() {
        return tempo_prep;
    }

    public void setTempo_prep(int tempo_prep) {
        this.tempo_prep = tempo_prep;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPreparacao() {
        return preparacao;
    }

    public void setPreparacao(String preparacao) {
        this.preparacao = preparacao;
    }

    public String getURLLink() {
        return URLLink;
    }

    public void setURLLink(String URLLink) {
        this.URLLink = URLLink;
    }

    public String getIds_ingr() {
        return ids_ingr;
    }

    public void setIds_ingr(String ids_ingr) {
        this.ids_ingr = ids_ingr;
    }

    public int getPesoPesquisa() {
        return pesoPesquisa;
    }

    public void setPesoPesquisa(int pesoPesquisa) {
        this.pesoPesquisa = pesoPesquisa;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "mID='" + id + '\'' +
                ", title='" + title + '\'' +
                ", lista_ingr='" + lista_ingr + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", tempo_prep='" + tempo_prep + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", preparacao='" + preparacao + '\'' +
                ", URLLink='" + URLLink + '\'' +
                ", ids_ingr='" + ids_ingr + '\'' +
                '}';
    }

    static Comparator<Receita> ReceitaNameComparator = new Comparator<Receita>() {

        public int compare(Receita left, Receita right) {

            String leftName = left.getTitle().toUpperCase();
            String rightName = right.getTitle().toUpperCase();

            //ascending order
            return leftName.compareTo(rightName);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };

    static Comparator<Receita> ReceitaNameComparator2 = new Comparator<Receita>() {

        public int compare(Receita left, Receita right) {

            //ascending order
            return left.getPesoPesquisa() - right.getPesoPesquisa();

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };

    @Override
    public int compareTo(@NonNull Receita receita) {
        return 0;
    }
}
