package controller;

import model.Tarefa;
import service.TarefaService;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private TarefaService tarefaService = new TarefaService();

    void iniciar() {
        int opcao = -1;

        do {
            exibirMenu();

            try {
                // evita quebra de linha residual
                opcao = Integer.parseInt(sc.nextLine());
                limparConsole();
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                limparConsole();
                System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
            }

        } while (opcao != 0);
    }

    void exibirMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Digite 1 para ADICIONAR uma nova tarefa➕");
        System.out.println("Digite 2 para MOSTRAR tarefas\uD83D\uDCCB");
        System.out.println("Digite 3 para CONCLUIR tarefas✅");
        System.out.println("Digite 4 para REMOVER tarefas❌");
        System.out.println("Digite 0 para SAIR do sistema\uD83D\uDC4B");
        System.out.println("--------------------------------------------");
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                exibirMenuAdicionarTarefa();
                break;
            case 2:
                System.out.println("Mostra tarefas");
                break;
            case 3:
                System.out.println("Conclui tarefas");
                break;
            case 4:
                System.out.println("Remove tarefas");
                break;
            case 0:
                System.out.println("Finalizando sistema...");
                break;
            default:
                System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS DO MENU!\uD83D\uDEA8\n");
                break;
        }
    }

    //entra na opção 1 do menu principal
    public void exibirMenuAdicionarTarefa() {
        System.out.println("Digite o nome da tarefa: ");
        String nomeDigitado = sc.nextLine();
        limparConsole();

        System.out.println("Digite a categoria da tarefa ");
        exibirMenuCategoria();

        int categoriaDigitada = -1;
        try {
            categoriaDigitada = Integer.parseInt(sc.nextLine());
            tarefaService.obterCategoriaEscolhida(categoriaDigitada);
            limparConsole();
        } catch (NumberFormatException e) {
            limparConsole();
            System.out.println("\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
            return;
        }

        if (tarefaService.validarAdicionarTarefa(nomeDigitado, categoriaDigitada)) {
            Tarefa novaTarefa = new Tarefa();
            novaTarefa.setNome(nomeDigitado);
            novaTarefa.setCategoria(tarefaService.obterCategoriaEscolhida(categoriaDigitada));

            System.out.println("Tarefa criada com sucesso!➕");
            System.out.println("O nome da tarefa foi definido como : " + novaTarefa.getNome());
            System.out.println("A categoria da tarefa foi definida como: " + novaTarefa.getCategoria());
            limparConsole();
        } else {
            System.out.println("\uD83D\uDEA8 ERRO: PREENCHA NOME E CATEGORIA PARA CRIAR UMA TAREFA!\uD83D\uDEA8\n");
        }
    }

    //esse menu esta dentro da opção 1 do menu Principal (Adicionar tarefa)
    private void exibirMenuCategoria() {
        System.out.println("--------------------------------------------");
        System.out.println("Digite 1 para Rotina");
        System.out.println("Digite 2 para Trabalho");
        System.out.println("Digite 3 para Educação");
        System.out.println("Digite 4 para Saúde");
        System.out.println("Digite 5 para Lazer");
        System.out.println("Digite 6 para Evento Importante");
        System.out.println("Digite 0 para Voltar ao Menu Principal");
        System.out.println("--------------------------------------------");
    }

    //serve para organização e estilização
    void limparConsole() {
        for (int cont = 0; cont < 3; cont++) {
            System.out.println();
        }
    }
}
