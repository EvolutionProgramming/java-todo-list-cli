package service;

import model.Tarefa;

public class TarefaService {

    public boolean validarAdicionarTarefa(String nomeDigitado, int opcaoCategoria) {
        return !nomeDigitado.trim().isEmpty() && opcaoCategoria > 0 && opcaoCategoria < 7;
    }

    public String obterCategoriaEscolhida(int opcao) {
        switch (opcao) {
            case 1:
                return "Rotina";
            case 2:
                return "Trabalho";
            case 3:
                return "Educação";
            case 4:
                return "Saúde";
            case 5:
                return "Lazer";
            case 6:
                return "Evento importante";
            case 0:
                return "Não informada";
            default:
                System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS DO MENU!\uD83D\uDEA8\n");
                return "Opção inválida";

        }
    }

}
