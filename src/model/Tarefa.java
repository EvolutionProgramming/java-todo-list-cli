package model;

public class Tarefa {
    private String nome;
    private String categoria;
    private boolean estado;
    private StatusTarefa status;

    //usa um construtor para fixar um valor fixo para toda tarefa recém criada
    public Tarefa() {
        this.status = StatusTarefa.PENDENTE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Enum<StatusTarefa> getStatus() {
        return this.status;
    }
}
