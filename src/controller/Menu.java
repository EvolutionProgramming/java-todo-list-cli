package controller;

import model.CategoriaTarefa;
import model.Tarefa;
import service.TarefaService;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final TarefaService tarefaService = new TarefaService();

    //Guarda o escopo principal da execução
    void iniciar() {
        int opcao = -1;

        do {
            exibirMenuPrincipal();

            try {
                // Integer.pardeInt(sc.nextLine) Evita quebra de linha residual
                opcao = Integer.parseInt(sc.nextLine());
                limparConsole();
                processarOpcaoMenuPrincipal(opcao);
            } catch (NumberFormatException e) {
                limparConsole();
                System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
            }

        } while (opcao != 0);
    }

    void exibirMenuPrincipal() {
        System.out.println("               MENU PRINCIPAL");
        System.out.println("--------------------------------------------");
        System.out.println("Digite 1 para ADICIONAR uma nova tarefa➕");
        System.out.println("Digite 2 para MOSTRAR tarefas\uD83D\uDCCB");
        System.out.println("Digite 3 para CONCLUIR tarefas✅");
        System.out.println("Digite 4 para REMOVER tarefas❌");
        System.out.println("Digite 5 para EDITAR tarefas\uD83D\uDCDD");
        System.out.println("Digite 0 para SAIR do sistema\uD83D\uDC4B");
        System.out.println("--------------------------------------------");
        System.out.println("Digite a opção:");
    }

    public void processarOpcaoMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1:
                //ADICIONA TAREFA
                exibirMenuAdicionarTarefa();
                break;
            case 2:
                //MOSTRA TAREFAS
                System.out.println("              LISTA DE TAREFAS              ");
                System.out.println("--------------------------------------------");
                tarefaService.exibirLista();
                System.out.println("--------------------------------------------");
                limparConsole();
                break;
            case 3:
                //CONCLUI TAREFA
                System.out.println("Digite a posição da tarefa a ser concluída✅ (DIGITE 0 PARA MENU PRINCIPAL): ");
                try {
                    int tarefaDigitadaConclui = Integer.parseInt(sc.nextLine());
                    if (tarefaDigitadaConclui != 0) {
                        tarefaService.concluirTarefa(tarefaDigitadaConclui);
                        limparConsole();
                    }
                } catch (NumberFormatException e) {
                    limparConsole();
                    System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
                }
                break;
            case 4:
                //REMOVE TAREFA
                System.out.println("Digite a posição da tarefa a ser removida❌ (DIGITE 0 PARA MENU PRINCIPAL): ");
                try {
                    int tarefaDigitadaRemove = Integer.parseInt(sc.nextLine());
                    if (tarefaDigitadaRemove != 0) {
                        tarefaService.removerTarefa(tarefaDigitadaRemove);
                        limparConsole();
                    }
                } catch (NumberFormatException e) {
                    limparConsole();
                    System.out.println("\n\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
                }
                break;
            case 5:
                // EDITA TAREFA
                System.out.println("Digite a posição da tarefa a ser editada 📝 (DIGITE 0 PARA CANCELAR): ");
                try {
                    int posicao = Integer.parseInt(sc.nextLine());
                    if (posicao == 0) break;

                    Tarefa tarefaEscolhida = tarefaService.buscarTarefa(posicao);

                    if (tarefaEscolhida == null) {
                        limparConsole();
                        System.out.println("🚨 ERRO: TAREFA NÃO ENCONTRADA! 🚨\n");
                    } else {
                        processarOpcoesEdicao(tarefaEscolhida);
                        limparConsole();
                    }
                } catch (NumberFormatException e) {
                    limparConsole();
                    System.out.println("\n🚨 ERRO: DIGITE APENAS NÚMEROS INTEIROS! 🚨\n");
                }

                break;
            case 0:
                //SAI DO PROGRAMA
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
        exibirMenuCategoria();
        System.out.println("Digite a categoria da tarefa: ");

        int categoriaDigitada;
        try {
            // Integer.pardeInt(sc.nextLine) Evita quebra de linha residual
            categoriaDigitada = Integer.parseInt(sc.nextLine());
            limparConsole();
        } catch (NumberFormatException e) {
            limparConsole();
            System.out.println("\uD83D\uDEA8 ERRO: DIGITE APENAS NÚMEROS INTEIROS!\uD83D\uDEA8\n");
            return;
        }
        //Validação da categoria digitada
        CategoriaTarefa categoriaEscolhida = CategoriaTarefa.porCodigo(categoriaDigitada);
        if (categoriaEscolhida == null) {
            System.out.println("\uD83D\uDEA8 ERRO: CATEGORIA INVÁLIDA! Tente adicionar a tarefa novamente.\uD83D\uDEA8\n");
            return;
        }

        System.out.println("Digite a descrição da tarefa: ");
        String descricaoDigitada = sc.nextLine();
        limparConsole();

        if (tarefaService.validarAdicionarTarefa(nomeDigitado)) {

            exibirTarefaCriada(tarefaService.criarTarefa(nomeDigitado, descricaoDigitada, categoriaEscolhida));

        } else {
            System.out.println("\uD83D\uDEA8 ERRO: O NOME DA TAREFA É OBRIGATÓRIO!\uD83D\uDEA8\n");
        }
        limparConsole();
    }

    //esse menu esta dentro da opção 1 do menu Principal (Adicionar tarefa)
    private void exibirMenuCategoria() {
        System.out.println("             SELECIONE A CATEGORIA          ");
        System.out.println("--------------------------------------------");
        System.out.println("  1. Rotina ⏰                              ");
        System.out.println("  2. Trabalho 💼                            ");
        System.out.println("  3. Educação 🎓                            ");
        System.out.println("  4. Saúde 💊                               ");
        System.out.println("  5. Lazer 🎮                               ");
        System.out.println("  6. Evento Importante 📌                   ");
        System.out.println("  0. Voltar ao Menu Principal 🏠            ");
        System.out.println("--------------------------------------------");
    }

    //entra na opção 5 do menu principal (Editar tarefa)
    private void processarOpcoesEdicao(Tarefa tarefaEscolhida) {

        exibirMenuEditar();

        int opcaoEditar;
        try {
            opcaoEditar = Integer.parseInt(sc.nextLine());
            limparConsole();
        } catch (NumberFormatException e) {
            System.out.println("🚨 ERRO: DIGITE APENAS NÚMEROS INTEIROS! 🚨\n");
            return;
        }

        if (opcaoEditar == 0) return;

        String novoValor = "";

        switch (opcaoEditar) {
            case 1:
                System.out.println("Nome atual: " + tarefaEscolhida.getNome());
                System.out.println("Digite o novo NOME da tarefa: ");
                novoValor = sc.nextLine();
                break;
            case 2:
                System.out.println("Categoria atual: " + tarefaEscolhida.getCategoria().getNome());
                exibirMenuCategoria();
                System.out.println("Escolha o número da nova CATEGORIA: ");
                novoValor = sc.nextLine();
                if ("0".equals(novoValor.trim())) return;
                break;
            case 3:
                System.out.println("Descrição atual: " + tarefaEscolhida.getDescricao());
                System.out.println("Digite a nova DESCRIÇÃO da tarefa: ");
                novoValor = sc.nextLine();
                break;
            default:
                System.out.println("🚨 Opção inválida! 🚨");
                return;
        }

        limparConsole();
        tarefaService.editarTarefa(tarefaEscolhida, opcaoEditar, novoValor);
    }

    private void exibirMenuEditar() {
        System.out.println("               MENU EDIÇÃO");
        System.out.println("--------------------------------------------");
        System.out.println("Digite 1 para editar o Nome");
        System.out.println("Digite 2 para editar a Categoria");
        System.out.println("Digite 3 para editar a Descrição");
        System.out.println("Digite 0 para Voltar ao Menu Principal 🏠");
        System.out.println("--------------------------------------------");

    }

    public static void exibirTarefaCriada(Tarefa novaTarefa) {
            System.out.println("--------------------------------------------");
            System.out.println("         TAREFA CRIADA COM SUCESSO! ➕      ");
            System.out.println();
            System.out.println("Nome:      " + novaTarefa.getNome());
            System.out.println("Categoria: " + novaTarefa.getCategoria().getNome());
            System.out.println("Descrição: " + novaTarefa.getDescricao());
            System.out.println("Status:    " + novaTarefa.getStatus());
            System.out.println("--------------------------------------------");
    }

    //serve para organização e estilização
    void limparConsole() {
        for (int cont = 0; cont < 3; cont++) {
            System.out.println();
        }
    }
}
