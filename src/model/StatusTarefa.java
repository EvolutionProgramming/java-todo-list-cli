package model;
//conjunto fixo de constantes
public enum StatusTarefa {
    CONCLUIDA("✅"),
    PENDENTE("⏳");

    private final String emoji;

    StatusTarefa(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
