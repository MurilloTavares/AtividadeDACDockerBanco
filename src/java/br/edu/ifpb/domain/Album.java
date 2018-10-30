package br.edu.ifpb.domain;

import java.time.LocalDate;

public class Album {
    
    private int id = -1;
    private Estilo estilo;
    private Banda banda;
    private LocalDate anoLancamento;

    public Album() {
    }

    public Album(Estilo estilo, Banda banda, LocalDate anoLancamento) {
        this.estilo = estilo;
        this.banda = banda;
        this.anoLancamento = anoLancamento;
    }

    public Album(int id, Estilo estilo, Banda banda, LocalDate anoLancamento) {
        this.id = id;
        this.estilo = estilo;
        this.banda = banda;
        this.anoLancamento = anoLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
}
