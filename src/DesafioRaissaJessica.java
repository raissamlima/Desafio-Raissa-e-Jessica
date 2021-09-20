
import java.util.Scanner;

public class DesafioRaissaJessica {
    // DESAFIO 20/09 - DUPLA RAISSA E JESSICA //
    /* Enunciado: Crie um programa em linguagem Java que atenda aos seguintes requisitos:
_ Deve exibir um menu onde o usuário pode escolher números pares, números ímpares, números primos,
                            calculo de juros compostos e sair.
_ Na opção de números pares, o usuário poderá digitar um valor e o sistema exibirá todos os números
                        pares de zero até o valor que o usuário digitou.
_ Na opção de números ímpares, o usuário deverá digitar um valor e o sistema exibirá todos os números
                        ímpares de zero até o valor digitado pelo usuário.
_ Na opção dos números primos, o sistema deve solicitar que o usuário digite um número e dizer quais são
                      os números primos de zero ao valor digitado pelo usuário.
_ Para o calculo do juros, o sistema deve solicitar ao usuário que digite o valor do investimento,
 o prazo e a taxa de juros mensal. O sistema deve imprimir o retorno mês a mês e o montante para resgate
                                        ao final do prazo.
_ O programa deve validar os dados inseridos, não permitindo valores negativos.
_ Deve ser criado um novo repositório no github para a dupla e inserido o usuário */

    public static boolean Primo(int numero) {
        boolean ePrimo = true;

        for (int n = 2; n < numero; n++) {
            if (numero % n == 0) {
                ePrimo = false;
            }
        }
        return ePrimo;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int op, numero = 0;
        boolean validaNumero = true;
        do {
            System.out.printf("\n------ MENU de Funções Raissa e Jessica ------\n");
            // MENU
            System.out.printf("\t 1 - Números Pares\n");
            System.out.printf("\t 2 - Números Ímpares\n");
            System.out.printf("\t 3 - Números Primos\n");
            System.out.printf("\t 4 - Cálculo de Juros Compostos\n");
            System.out.printf("\t 0 - Sair\n");
            System.out.println("Escolha uma Opção: \n");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    // --------- NÚMEROS PARES --------- //
                    do {
                        System.out.print("Digite um número: ");
                        numero = sc.nextInt();

                        if (numero < 0 || numero > 200) {
                            System.out.println("O número não pode ser negativo e nem maior que 200, tente novamente!");
                            validaNumero = false;
                        } else {
                            validaNumero = true;

                            for (int n = 0; n <= numero; n++) {
                                if (n % 2 == 0) {
                                    System.out.printf("%d ", n);
                                }
                            }
                        }
                    } while (validaNumero == false);

                    break;

                case 2:

                    // --------- NÚMEROS ÍMPARES --------- //
                    do {
                        System.out.print("Digite um número: ");
                        numero = sc.nextInt();

                        if (numero < 0 || numero > 200) {
                            System.out.println("O número não pode ser negativo e nem maior que 200, tente novamente!");
                            validaNumero = false;
                        } else {
                            validaNumero = true;

                            for (int n = 0; n <= numero; n++) {
                                if (n % 2 != 0) {
                                    System.out.printf("%d ", n);
                                }
                            }
                        }
                    } while (validaNumero == false);
                    break;

                case 3:

                    // --------- NÚMEROS PRIMOS --------- //
                    do {
                        System.out.print("Digite um número: ");
                        numero = sc.nextInt();
                        if (numero < 0) {
                            System.out.println("O número não pode ser negativo, tente novamente!");
                            validaNumero = false;
                        } else {
                            validaNumero = true;

                            for (int n = 2; n <= numero; n++) {
                                if (Primo(n)) {
                                    System.out.printf("%d ", n);
                                }
                            }
                        }
                    } while (validaNumero == false);
                    break;

                case 4:
                    // --------- CÁLCULO DE JUROS COMPOSTOS --------- //
                    boolean validaInvestimento = true;

                    do {
                        System.out.print("Digite o valor do investimento: ");
                        double valorInvestimento = sc.nextDouble();

                        if (valorInvestimento < 0) {
                            validaInvestimento = false;
                            System.out.println("O valor do investimento não pode ser negativo, tente novamente!");
                        } else {
                            validaInvestimento = true;

                            System.out.print("Digite o prazo em dias do investimento: ");
                            int prazoInvestimento = sc.nextInt();
                            System.out.print("Digite a taxa de juros do investimento: ");
                            int taxaJuros = sc.nextInt();

                            System.out.printf("\nValor inicial: R$%.2f\n", valorInvestimento);
                            System.out.printf("Taxa de juros: %d%%\n\n", taxaJuros);

                            double retorno = 0.0;

                            for (int n = 0; n < prazoInvestimento; n++) {
                                retorno += (valorInvestimento * taxaJuros / 100);
                                System.out.printf("Retorno %dº mês: R$%.2f\n", n + 1, retorno);
                            }
                            System.out.printf("\nMontante final: R$%.2f\n", (valorInvestimento + retorno));
                        }
                    } while (validaInvestimento == false);
                    break;

                case 0:

                    // --------- SAIR --------- //
                    System.out.printf("Sair");
                    sc.nextLine();
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
                    break;
            }
        }while(op != 0);
    }
}

