package Lanchonete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Lanchonete.gerenciamento.Estabelecimento;
import Lanchonete.modelo.Mesa;
import Lanchonete.salao.Atendente;
import Lanchonete.cozinha.CozinheiroJapones;
import Lanchonete.modelo.Cliente;
import Lanchonete.modelo.Produto;
import Lanchonete.modelo.ItemPedido;
import Lanchonete.modelo.Pedido;
import Lanchonete.modelo.Cardapio;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando o estabelecimento
        Estabelecimento lanchonete = new Estabelecimento("Lanchonete do Zé");
        Cardapio cardapio = new Cardapio();

        // Criando mesas
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        lanchonete.adicionarMesa(mesa1);
        lanchonete.adicionarMesa(mesa2);

        // Criando funcionários
        Atendente atendente = new Atendente("João");
        CozinheiroJapones cozinheiro = new CozinheiroJapones("Takeshi");
        lanchonete.adicionarAtendente(atendente);
        lanchonete.adicionarCozinheiro(cozinheiro);

        // Adicionando produtos ao almoxarifado
        for (Produto produto : cardapio.getProdutos()) {
            lanchonete.getAlmoxarifado().adicionarProduto(produto);
        }

        // Cliente chega
        System.out.println("Bem-vindo à Lanchonete do Zé!");
        System.out.print("Por favor, digite seu nome: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        // Cliente escolhe mesa
        System.out.println("\nMesas disponíveis:");
        System.out.println("1 - Mesa 1");
        System.out.println("2 - Mesa 2");
        System.out.print("Escolha uma mesa (1 ou 2): ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Mesa mesaEscolhida = numeroMesa == 1 ? mesa1 : mesa2;
        cliente.sentarNaMesa(mesaEscolhida);
        System.out.println("\nVocê está sentado na Mesa " + mesaEscolhida.getNumero());

        // Cliente faz pedido
        List<ItemPedido> itens = new ArrayList<>();
        boolean continuarPedido = true;

        while (continuarPedido) {
            cardapio.exibirCardapio();
            System.out.print("\nDigite o nome do item que deseja pedir (ou 'fim' para finalizar): ");
            String itemEscolhido = scanner.nextLine();

            if (itemEscolhido.equalsIgnoreCase("fim")) {
                continuarPedido = false;
                continue;
            }

            Produto produto = cardapio.buscarProduto(itemEscolhido);
            if (produto == null) {
                System.out.println("Item não encontrado no cardápio. Por favor, tente novamente.");
                continue;
            }

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            System.out.print("Alguma observação? (ou pressione Enter para nenhuma): ");
            String observacao = scanner.nextLine();

            itens.add(new ItemPedido(produto, quantidade, observacao));
            System.out.println("Item adicionado ao pedido!");
        }

        if (itens.isEmpty()) {
            System.out.println("Nenhum item foi pedido. Encerrando atendimento.");
            return;
        }

        // Processando o pedido
        Pedido pedido = cliente.fazerPedido(atendente, itens);
        System.out.println("\nPedido criado: " + pedido.getNumero());

        // Atendente encaminha pedido para cozinha
        atendente.encaminharPedidoParaCozinha(pedido, cozinheiro);
        System.out.println("Pedido encaminhado para cozinha");

        // Cozinheiro prepara pedido
        cozinheiro.prepararPedido(pedido);
        System.out.println("Pedido preparado");

        // Atendente entrega pedido
        atendente.entregarPedido(pedido);
        System.out.println("Pedido entregue");

        // Mostra total do pedido
        System.out.println("\nTotal do pedido: R$ " + pedido.calcularTotal());

        // Cliente sai da mesa
        System.out.print("\nDeseja sair da mesa? (s/n): ");
        String sair = scanner.nextLine();
        if (sair.equalsIgnoreCase("s")) {
            cliente.sairDaMesa();
            System.out.println("Obrigado pela visita! Volte sempre!");
        }

        // Mostra faturamento
        System.out.println("\nFaturamento total: R$ " + lanchonete.getFaturamento());
        
        scanner.close();
    }
} 