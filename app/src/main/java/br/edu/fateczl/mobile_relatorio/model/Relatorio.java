package br.edu.fateczl.mobile_relatorio.model;

public class Relatorio {
    private int id;
    private String titulo;
    private String resumo;
    private String texto;
    private boolean isPublico;
    private int autorId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isPublico() {
        return isPublico;
    }

    public void setPublico(boolean publico) {
        isPublico = publico;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", texto='" + texto + '\'' +
                ", isPublico=" + isPublico +
                ", autorId=" + autorId +
                '}';
    }
}
