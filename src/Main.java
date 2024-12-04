import cofrinho.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        boolean controller = true;

        while (controller) {
            exibirMenuPrincipal();

            int opcao = lerInteiro(teclado);

            switch (opcao) {
                case 1 -> adicionarMoeda(teclado, cofrinho);
                case 2 -> removerMoeda(teclado, cofrinho);
                case 3 -> listarMoedas(cofrinho);
                case 4 -> calcularTotalConvertido(cofrinho);
                case 0 -> {
                    System.out.println("Finalizando o programa");
                    controller = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("""
                COFRINHO
                1 - Adicionar Moeda
                2 - Remover Moeda
                3 - Listar Moedas
                4 - Calcular Total convertido para Real
                0 - Encerrar
                """);
    }

    private static void exibirMenuMoedas() {
        System.out.println("""
                Escolha a moeda:
                1 - Real
                2 - Dolar
                3 - Euro
                """);
    }

    private static int lerInteiro(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número inteiro:");
            teclado.next(); // Limpa entrada inválida
        }
        return teclado.nextInt();
    }

    private static double lerDouble(Scanner teclado) {
        while (!teclado.hasNextDouble()) {
            System.out.println("Entrada inválida! Digite um número decimal:");
            teclado.next(); // Limpa entrada inválida
        }
        return teclado.nextDouble();
    }

    private static void adicionarMoeda(Scanner teclado, Cofrinho cofrinho) {
        exibirMenuMoedas();
        int moedaSelect = lerInteiro(teclado);

        System.out.println("Digite o valor:");
        double valor = lerDouble(teclado);

        Moeda moeda = criarMoeda(moedaSelect, valor);
        if (moeda != null) {
            cofrinho.adicionar(moeda);
            System.out.println("Moeda adicionada com sucesso!");
        } else {
            System.out.println("Opção inválida! Retornando ao menu.");
        }
    }

    private static void removerMoeda(Scanner teclado, Cofrinho cofrinho) {
        exibirMenuMoedas();
        int moedaSelect = lerInteiro(teclado);

        System.out.println("Digite o valor:");
        double valor = lerDouble(teclado);

        Moeda moeda = criarMoeda(moedaSelect, valor);
        if (moeda != null) {
            cofrinho.remover(moeda);
            System.out.println("Moeda removida com sucesso!");
        } else {
            System.out.println("Opção inválida! Retornando ao menu.");
        }
    }

    private static Moeda criarMoeda(int tipo, double valor) {
        return switch (tipo) {
            case 1 -> new Real(valor);
            case 2 -> new Dolar(valor);
            case 3 -> new Euro(valor);
            default -> null;
        };
    }

    private static void listarMoedas(Cofrinho cofrinho) {
        ArrayList<Moeda> moedas = cofrinho.getListaDeMoedas();
        Map<String, Double> totalPorMoeda = new HashMap<>();

        for (Moeda moeda : moedas) {
            String tipo = moeda.getClass().getSimpleName();
            totalPorMoeda.merge(tipo, moeda.valor, Double::sum);
        }

        System.out.println("Totais por moeda:");
        totalPorMoeda.forEach((tipo, valor) -> System.out.println(tipo + ": " + valor));
    }

    private static void calcularTotalConvertido(Cofrinho cofrinho) {
        double total = cofrinho.getListaDeMoedas().stream()
                .mapToDouble(Moeda::converter)
                .sum();

        System.out.println("O total convertido em reais é: " + total);
    }
}