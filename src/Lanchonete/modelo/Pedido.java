package Lanchonete.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private Mesa mesa;
    private List<ItemPedido> itens;
    private boolean preparado;
    private boolean entregue;

    public Pedido(int numero, Mesa mesa) {
        this.numero = numero;
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.preparado = false;
        this.entregue = false;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream()
                   .mapToDouble(ItemPedido::getSubtotal)
                   .sum();
    }

    public void marcarComoPreparado() {
        this.preparado = true;
    }

    public void marcarComoEntregue() {
        this.entregue = true;
    }

    public boolean isPreparado() {
        return preparado;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getNumero() {
        return numero;
    }
} 