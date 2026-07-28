package model;

public class Tarefa {
    private String nome;
    private CategoriaTarefa categoria;
    private String descricao;
    private StatusTarefa status;

    //usa um construtor para fixar um valor fixo para toda tarefa recém criada
    public Tarefa() {
        this.status = StatusTarefa.PENDENTE;
    }

    @Override
    public String toString() {
        return "| Tarefa: " + nome + "| Categoria: " + categoria + "| Descrição: " + descricao + "| Status: " + status + "\t\n";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaTarefa getCategoria() {
        return this.categoria;
    }

    public void setCategoria(CategoriaTarefa categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return this.status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }
}
