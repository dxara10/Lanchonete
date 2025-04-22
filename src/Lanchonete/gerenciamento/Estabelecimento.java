package Lanchonete.gerenciamento;

import java.util.ArrayList;
import java.util.List;
import Lanchonete.salao.Mesa;
import Lanchonete.salao.Atendente;
import Lanchonete.cozinha.Cozinheiro;
import Lanchonete.almoxarifado.Almoxarifado;
import Lanchonete.modelo.Pedido;

public class Estabelecimento {
    private String nome;
    private List<Mesa> mesas;
    private List<Atendente> atendentes;
    private List<Cozinheiro> cozinheiros;
    private Almoxarifado almoxarifado;
    private double faturamento;

    public Estabelecimento(String nome) {
        this.nome = nome;
        this.mesas = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.cozinheiros = new ArrayList<>();
        this.almoxarifado = new Almoxarifado();
        this.faturamento = 0.0;
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void adicionarAtendente(Atendente atendente) {
        atendentes.add(atendente);
    }

    public void adicionarCozinheiro(Cozinheiro cozinheiro) {
        cozinheiros.add(cozinheiro);
    }

    public void registrarPedido(Pedido pedido) {
        faturamento += pedido.calcularTotal();
    }

    public double getFaturamento() {
        return faturamento;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }
} 