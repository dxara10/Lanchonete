package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando o estabelecimento
        Estabelecimento lanchonete = new Estabelecimento("Lanchonete do Zé");

        // Criando mesas
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        lanchonete.adicionarMesa(mesa1);
        lanchonete.adicionarMesa(mesa2);

        // Criando funcionários
        Atendente atendente = new Atendente("João");
        Cozinheiro cozinheiro = new Cozinheiro("Maria");
        lanchonete.adicionarAtendente(atendente);
        lanchonete.adicionarCozinheiro(cozinheiro);

        // Criando produtos no almoxarifado
        Produto hamburguer = new Produto("Hambúrguer", "Pão, carne, queijo e alface", 15.0, 10);
        Produto refrigerante = new Produto("Refrigerante", "Coca-Cola 350ml", 5.0, 20);
        lanchonete.getAlmoxarifado().adicionarProduto(hamburguer);
        lanchonete.getAlmoxarifado().adicionarProduto(refrigerante);

        // Cliente chega e senta na mesa
        Cliente cliente = new Cliente("Pedro");
        cliente.sentarNaMesa(mesa1);

        // Cliente faz pedido
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(hamburguer, 1, "Sem cebola"));
        itens.add(new ItemPedido(refrigerante, 1, "Gelado"));

        Pedido pedido = cliente.fazerPedido(atendente, itens);
        System.out.println("Pedido criado: " + pedido.getNumero());

        // Atendente encaminha pedido para cozinha
        atendente.encaminharPedidoParaCozinha(pedido, cozinheiro);
        System.out.println("Pedido encaminhado para cozinha");

        // Cozinheiro prepara pedido
        cozinheiro.prepararPedido(pedido);
        System.out.println("Pedido preparado");

        // Atendente entrega pedido
        atendente.entregarPedido(pedido);
        System.out.println("Pedido entregue");

        // Cliente sai da mesa
        cliente.sairDaMesa();
        System.out.println("Cliente saiu da mesa");

        // Mostra faturamento
        System.out.println("Faturamento total: R$ " + lanchonete.getFaturamento());
    }
} 