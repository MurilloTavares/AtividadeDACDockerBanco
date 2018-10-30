package br.edu.ifpb.domain;

import java.util.List;

public class Banda {
    
    private String nome;
    private String localOrigem;
    private List<String> integrantes;

    public Banda() {
    }

    public Banda(String nome, String localDeOrigem, List<String> integrates) {
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

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "Banda{" + "nome=" + nome + ", localOrigem=" + localOrigem + ", integrantes=" + integrantes + '}';
    }
    
}
