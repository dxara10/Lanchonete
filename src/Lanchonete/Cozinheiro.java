package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Cozinheiro {
    private String nome;
    private List<Pedido> pedidosEmPreparo;

    public Cozinheiro(String nome) {
        this.nome = nome;
        this.pedidosEmPreparo = new ArrayList<>();
    }

    public void receberPedido(Pedido pedido) {
        pedidosEmPreparo.add(pedido);
    }

    public void prepararPedido(Pedido pedido) {
        if (pedidosEmPreparo.contains(pedido)) {
            // Simula o tempo de preparo
            try {
                Thread.sleep(2000); // 2 segundos de preparo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            pedido.marcarComoPreparado();
            pedidosEmPreparo.remove(pedido);
        }
    }

    public List<Pedido> getPedidosEmPreparo() {
        return pedidosEmPreparo;
    }

    public String getNome() {
        return nome;
    }
}
