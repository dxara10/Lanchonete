package Lanchonete.modelo;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String descricao, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade solicitada maior que o estoque disponível");
        }
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEstoque += quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
} 