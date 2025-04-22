package Lanchonete.cozinha;

import java.util.ArrayList;
import java.util.List;
import Lanchonete.modelo.Pedido;
import Lanchonete.modelo.ItemPedido;

public class CozinheiroJapones extends Cozinheiro {
    private List<String> ingredientesYakissoba;

    public CozinheiroJapones(String nome) {
        super(nome);
        this.ingredientesYakissoba = new ArrayList<>();
        inicializarIngredientesYakissoba();
    }

    private void inicializarIngredientesYakissoba() {
        ingredientesYakissoba.add("Macarrão para yakissoba");
        ingredientesYakissoba.add("Molho shoyu");
        ingredientesYakissoba.add("Legumes variados");
        ingredientesYakissoba.add("Carne de porco");
        ingredientesYakissoba.add("Óleo de gergelim");
    }

    @Override
    public void prepararPedido(Pedido pedido) {
        if (pedido.getItens().stream().anyMatch(item -> 
            item.getProduto().getNome().equalsIgnoreCase("Yakissoba"))) {
            prepararYakissoba(pedido);
        } else {
            super.prepararPedido(pedido);
        }
    }

    private void prepararYakissoba(Pedido pedido) {
        System.out.println("Iniciando preparo do Yakissoba...");
        prepararMacarrao();
        refogarLegumes();
        adicionarMolhoEspecial();
        finalizarPreparo();
        pedido.marcarComoPreparado();
        System.out.println("Yakissoba pronto!");
    }

    private void prepararMacarrao() {
        System.out.println("Cozinhando o macarrão al dente...");
        // Implementação específica do preparo do macarrão
    }

    private void refogarLegumes() {
        System.out.println("Refogando os legumes no wok...");
        // Implementação específica do refogado
    }

    private void adicionarMolhoEspecial() {
        System.out.println("Adicionando o molho especial da casa...");
        // Implementação específica do molho
    }

    private void finalizarPreparo() {
        System.out.println("Finalizando o preparo com toque especial...");
        // Implementação específica da finalização
    }
} 