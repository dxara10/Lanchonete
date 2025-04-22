package Lanchonete.salao;

import java.util.ArrayList;
import java.util.List;
import Lanchonete.modelo.Pedido;
import Lanchonete.modelo.Mesa;
import Lanchonete.modelo.ItemPedido;
import Lanchonete.cozinha.Cozinheiro;

public class Atendente {
    private String nome;
    private List<Pedido> pedidosEmAtendimento;

    public Atendente(String nome) {
        this.nome = nome;
        this.pedidosEmAtendimento = new ArrayList<>();
    }

    public Pedido criarPedido(Mesa mesa, List<ItemPedido> itens) {
        Pedido pedido = new Pedido(pedidosEmAtendimento.size() + 1, mesa);
        for (ItemPedido item : itens) {
            pedido.adicionarItem(item);
        }
        pedidosEmAtendimento.add(pedido);
        mesa.registrarPedido(pedido);
        return pedido;
    }

    public void encaminharPedidoParaCozinha(Pedido pedido, Cozinheiro cozinheiro) {
        cozinheiro.receberPedido(pedido);
    }

    public void entregarPedido(Pedido pedido) {
        if (pedido.isPreparado()) {
            pedido.marcarComoEntregue();
            pedidosEmAtendimento.remove(pedido);
        }
    }

    public List<Pedido> getPedidosEmAtendimento() {
        return pedidosEmAtendimento;
    }

    public String getNome() {
        return nome;
    }
} 