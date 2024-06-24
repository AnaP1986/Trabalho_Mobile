package br.edu.fateczl.mobile_relatorio.model;

public class AcessoRelatorio {
    private int id;
    private String dataAcesso;
    private int numeroAcesso;
    private int clienteId;
    private int relatorioId;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(String dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public int getNumeroAcesso() {
        return numeroAcesso;
    }

    public void setNumeroAcesso(int numeroAcesso) {
        this.numeroAcesso = numeroAcesso;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getRelatorioId() {
        return relatorioId;
    }

    public void setRelatorioId(int relatorioId) {
        this.relatorioId = relatorioId;
    }
}
