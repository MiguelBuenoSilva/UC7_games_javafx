package br.senac.sp.gamesjavafx.model;

import java.time.LocalDate;

public class Estudio {
    private int id;
    private String  nomeFundador;
    private String  nomeEstudio;
    private LocalDate anoFundacao;
    private  String paisOrigem;


    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public LocalDate getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(LocalDate anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public String getNomeFundador() {
        return nomeFundador;
    }

    public void setNomeFundador(String nomeFundador) {
        this.nomeFundador = nomeFundador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEstudio() {
        return nomeEstudio;
    }

    public void setNomeEstudio(String nomeEstudio) {
        this.nomeEstudio = nomeEstudio;
    }
}
