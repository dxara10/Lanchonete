package Lanchonete.modelo;

public class Mesa {
    private int numero;
    private boolean ocupada;
    private Cliente cliente;
    private Pedido pedido;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.cliente = null;
        this.pedido = null;
    }

    public void ocupar(Cliente cliente) {
        this.cliente = cliente;
        this.ocupada = true;
    }

    public void desocupar() {
        this.cliente = null;
        this.ocupada = false;
        this.pedido = null;
    }

    public void registrarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getNumero() {
        return numero;
    }
} 