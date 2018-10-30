package br.edu.ifpb.domain;

import java.util.List;

public class Banda {
    
    private String nome;
    private String localOrigem;
    private List<Integrante> integrantes;

    public Banda() {
    }

    public Banda(String nome, String localDeOrigem, List<Integrante> integrates) {
        this.nome = nome;
        this.localOrigem = localDeOrigem;
        this.integrantes = integrates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "Banda{" + "nome=" + nome + ", localOrigem=" + localOrigem + ", integrantes=" + integrantes + '}';
    }
    
}
