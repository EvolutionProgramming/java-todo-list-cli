package model;

public class Tarefa {
    private String nome;
    private String categoria;
    private String descricao;
    private StatusTarefa status;

    //usa um construtor para fixar um valor fixo para toda tarefa recém criada
    public Tarefa() {
        this.status = StatusTarefa.PENDENTE;
    }

    @Override
    public String toString() {
        return "| Tarefa: "+nome+"| Categoria: "+categoria+"| Descrição: "+descricao+"| Status: "+status+"\t\n";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Enum<StatusTarefa> getStatus() {
        return this.status;
    }
}
