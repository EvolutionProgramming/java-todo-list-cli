package service;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> listaDeTarefas = new ArrayList<>();

    public void salvarTarefa(Tarefa tarefa) {
        listaDeTarefas.add(tarefa);
    }

    public void removerTarefa(int tarefaDigitada) {

        // proteção contra IndexOutOfBoundsException
        if (tarefaDigitada > 0 && tarefaDigitada <= listaDeTarefas.size()) {
            listaDeTarefas.remove(tarefaDigitada - 1);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void exibirLista() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (int i = 0; i < listaDeTarefas.size(); i++) {
            //concatena a posição da tarefa ao output via toString() lá na classe Tarefa
            System.out.println((i + 1) + ". " + listaDeTarefas.get(i).toString());
        }

        listaDeTarefas.forEach(tarefa -> System.out.println(tarefa));
    }

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
