package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Almoxarifado {
    private List<Produto> produtos;

    public Almoxarifado() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public Produto buscarProduto(String nome) {
        return produtos.stream()
                      .filter(p -> p.getNome().equalsIgnoreCase(nome))
                      .findFirst()
                      .orElse(null);
    }

    public boolean verificarDisponibilidade(Produto produto, int quantidade) {
        return produto.getQuantidadeEstoque() >= quantidade;
    }

    public void atualizarEstoque(Produto produto, int quantidade) {
        produto.reduzirEstoque(quantidade);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
