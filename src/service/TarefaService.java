package service;

import model.CategoriaTarefa;
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

    public void editarTarefa(Tarefa tarefa, int opcaoEditar, String novoValor) {
        switch (opcaoEditar) {
            case 1:
                if (novoValor.trim().isEmpty()) {
                    System.out.println("🚨 ERRO: O nome da tarefa não pode ser vazio! 🚨");
                } else {
                    tarefa.setNome(novoValor.trim());
                    System.out.println("Nome atualizado com sucesso! ✅");
                }
                break;
            case 2:
                try {
                    int codigoCategoria = Integer.parseInt(novoValor);
                    CategoriaTarefa novaCategoria = CategoriaTarefa.porCodigo(codigoCategoria);

                    if (novaCategoria != null) {
                        tarefa.setCategoria(novaCategoria);
                        System.out.println("Categoria atualizada com sucesso! ✅");
                    } else {
                        System.out.println("🚨 ERRO: Categoria inválida! 🚨");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("🚨 ERRO: Digite um número válido para a categoria! 🚨");
                }
                break;
            case 3:
                tarefa.setDescricao(novoValor.trim());
                System.out.println("Descrição atualizada com sucesso! ✅");
                break;
            default:
                System.out.println("Opção de edição inválida!");
        }
    }

    // busca a tarefa pela posição exibida ao usuário (protegida contra IndexOutOfBoundsException)
    public Tarefa buscarTarefa(int posicao) {
        if (posicao > 0 && posicao <= listaDeTarefas.size()) {
            return listaDeTarefas.get(posicao - 1);
        }
        return null;
    }

    public boolean validarAdicionarTarefa(String nomeDigitado, int opcaoCategoria) {
        return !nomeDigitado.trim().isEmpty() && opcaoCategoria > 0 && opcaoCategoria <= CategoriaTarefa.getTotalCategorias();
    }

}
