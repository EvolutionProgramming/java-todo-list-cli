package controller;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("Digite 1 para ADICIONAR uma nova tarefa➕");
        System.out.println("Digite 2 para MOSTRAR tarefas\uD83D\uDCCB");
        System.out.println("Digite 3 para CONCLUIR tarefas✅");
        System.out.println("Digite 4 para REMOVER tarefas❌");
        System.out.println("Digite 0 para SAIR do sistema\uD83D\uDC4B");
        System.out.println("--------------------------------------------");
        int opcao = sc.nextInt();
    }
}
