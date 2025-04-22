package Lanchonete.modelo;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private String observacao;

    public ItemPedido(Produto produto, int quantidade, String observacao) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getObservacao() {
        return observacao;
    }
} 