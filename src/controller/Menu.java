package controller;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
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

    public void exibirMenu() {
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
                System.out.println("Adiciona tarefas");
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

    public void limparConsole() {
        for (int cont = 0; cont < 3; cont++) {
            System.out.println();
        }
    }
}
