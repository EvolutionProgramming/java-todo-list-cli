package model;

public enum CategoriaTarefa {
    ROTINA(1, "Rotina"),
    TRABALHO(2, "Trabalho"),
    EDUCACAO(3, "Educação"),
    SAUDE(4, "Saúde"),
    LAZER(5, "Lazer"),
    EVENTO_IMPORTANTE(6, "Evento importante");

    private final int codigo;
    private final String nome;

    CategoriaTarefa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static CategoriaTarefa porCodigo(int codigo) {
        for (CategoriaTarefa c : values()) {
            if (c.codigo == codigo) return c;
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public static int getTotalCategorias() {
        return values().length;
    }
}
