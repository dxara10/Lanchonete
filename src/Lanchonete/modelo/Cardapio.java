package Lanchonete.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Produto> produtos;

    public Cardapio() {
        this.produtos = new ArrayList<>();
        inicializarCardapio();
    }

    private void inicializarCardapio() {
        // Lanches
        produtos.add(new Produto("Hambúrguer", "Pão, carne, queijo e alface", 15.0, 10));
        produtos.add(new Produto("X-Burger", "Pão, carne, queijo, alface e tomate", 18.0, 10));
        produtos.add(new Produto("X-Salada", "Pão, carne, queijo, alface, tomate e maionese", 20.0, 10));
        
        // Pratos Especiais
        produtos.add(new Produto("Yakissoba", "Macarrão com legumes e carne", 25.0, 5));
        produtos.add(new Produto("Lamen", "Sopa japonesa com macarrão e carne", 28.0, 5));
        
        // Bebidas
        produtos.add(new Produto("Refrigerante", "Coca-Cola 350ml", 5.0, 20));
        produtos.add(new Produto("Suco Natural", "Suco de laranja 300ml", 8.0, 15));
        produtos.add(new Produto("Água", "Água mineral 500ml", 3.0, 30));
    }

    public void exibirCardapio() {
        System.out.println("\n========== CARDÁPIO ==========");
        System.out.println("\nLANCHES:");
        produtos.stream()
                .filter(p -> p.getNome().matches("Hambúrguer|X-Burger|X-Salada"))
                .forEach(p -> System.out.printf("%s - R$ %.2f\n", p.getNome(), p.getPreco()));

        System.out.println("\nPRATOS ESPECIAIS:");
        produtos.stream()
                .filter(p -> p.getNome().matches("Yakissoba|Lamen"))
                .forEach(p -> System.out.printf("%s - R$ %.2f\n", p.getNome(), p.getPreco()));

        System.out.println("\nBEBIDAS:");
        produtos.stream()
                .filter(p -> p.getNome().matches("Refrigerante|Suco Natural|Água"))
                .forEach(p -> System.out.printf("%s - R$ %.2f\n", p.getNome(), p.getPreco()));
    }

    public Produto buscarProduto(String nome) {
        return produtos.stream()
                      .filter(p -> p.getNome().equalsIgnoreCase(nome))
                      .findFirst()
                      .orElse(null);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
} 