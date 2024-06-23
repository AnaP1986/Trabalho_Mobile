package br.edu.fateczl.mobile_relatorio.model;

public class Autor {
    private int id;
    private String nome;
    private String apelido;
    private boolean isAnonimo;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public boolean isAnonimo() {
        return isAnonimo;
    }

    public void setAnonimo(boolean anonimo) {
        isAnonimo = anonimo;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", isAnonimo=" + isAnonimo +
                '}';
    }
}
