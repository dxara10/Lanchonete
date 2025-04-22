package Lanchonete.modelo;

import java.util.List;
import Lanchonete.salao.Atendente;

public class Cliente {
    private String nome;
    private Mesa mesa;

    public Cliente(String nome) {
        this.nome = nome;
        this.mesa = null;
    }

    public void sentarNaMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.ocupar(this);
    }

    public void sairDaMesa() {
        if (mesa != null) {
            mesa.desocupar();
            mesa = null;
        }
    }

    public Pedido fazerPedido(Atendente atendente, List<ItemPedido> itens) {
        if (mesa != null) {
            return atendente.criarPedido(mesa, itens);
        }
        throw new IllegalStateException("Cliente não está sentado em nenhuma mesa");
    }

    public String getNome() {
        return nome;
    }

    public Mesa getMesa() {
        return mesa;
    }
} 