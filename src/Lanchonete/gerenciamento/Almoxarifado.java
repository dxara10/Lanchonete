package Lanchonete.gerenciamento;

import java.util.ArrayList;
import java.util.List;
import Lanchonete.modelo.Produto;

public class Almoxarifado {
    private List<Produto> produtos;

    public Almoxarifado() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
} 