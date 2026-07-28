package service;

import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    private List<Tarefa> listaDeTarefas = new ArrayList<>();

    public void salvarTarefa(Tarefa tarefa) {
        listaDeTarefas.add(tarefa);
    }

    public void concluirTarefa(int tarefaDigitada) {
        // proteção contra IndexOutOfBoundsException
        if (tarefaDigitada > 0 && tarefaDigitada <= listaDeTarefas.size()) {
            Tarefa tarefa = listaDeTarefas.get(tarefaDigitada - 1);
            tarefa.setStatus(StatusTarefa.CONCLUIDA);
            System.out.println("STATUS DA TAREFA MUDOU PARA CONCLUÍDA✅ COM SUCESSO!");
        } else {
            System.out.println("Posição inválida!");
        }

    }

    public void removerTarefa(int tarefaDigitada) {

        // proteção contra IndexOutOfBoundsException
        if (tarefaDigitada > 0 && tarefaDigitada <= listaDeTarefas.size()) {
            listaDeTarefas.remove(tarefaDigitada - 1);
            System.out.println("TAREFA REMOVIDA❌ COM SUCESSO!");
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

    }

    public boolean validarAdicionarTarefa(String nomeDigitado, int opcaoCategoria) {
        return !nomeDigitado.trim().isEmpty() && opcaoCategoria > 0 && opcaoCategoria < 7;
    }

}
