# Sistema de Gerenciamento de Lanchonete

Este projeto implementa um sistema completo de gerenciamento para uma lanchonete, simulando todo o fluxo de atendimento desde a chegada do cliente até o fechamento do pedido.

## Contexto do Projeto

O sistema foi desenvolvido em Java e implementa um fluxo completo de atendimento em uma lanchonete, incluindo:
- Gerenciamento de mesas e clientes
- Sistema de pedidos
- Controle de estoque
- Preparação de pedidos
- Faturamento

## Fluxo do Sistema

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Cliente   │────▶│   Atendente │────▶│  Cozinheiro │
└─────────────┘     └─────────────┘     └─────────────┘
       │                   │                   │
       │                   │                   │
       ▼                   ▼                   ▼
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│    Mesa     │     │   Pedido    │     │ Almoxarifado│
└─────────────┘     └─────────────┘     └─────────────┘
       │                   │                   │
       │                   │                   │
       ▼                   ▼                   ▼
┌─────────────────────────────────────────────────────┐
│                Estabelecimento                       │
└─────────────────────────────────────────────────────┘
```

## Fluxo de Atendimento

1. Cliente chega e senta em uma mesa
2. Atendente recebe o pedido do cliente
3. Pedido é registrado no sistema
4. Cozinheiro recebe o pedido
5. Almoxarifado verifica disponibilidade dos produtos
6. Cozinheiro prepara o pedido
7. Atendente entrega o pedido ao cliente
8. Cliente sai da mesa
9. Sistema registra o faturamento

## Tecnologias Utilizadas

- Java
- Git para controle de versão

## Como Executar

1. Clone o repositório
2. Navegue até a pasta src
3. Compile os arquivos Java:
   ```
   javac Lanchonete/*.java
   ```
4. Execute o programa:
   ```
   java Lanchonete.Main
   ```

## Estrutura do Projeto

- `src/Lanchonete/`
  - `Main.java` - Classe principal com o fluxo de demonstração
  - `Estabelecimento.java` - Classe que gerencia todo o estabelecimento
  - `Cliente.java` - Representa os clientes
  - `Mesa.java` - Gerencia as mesas do estabelecimento
  - `Atendente.java` - Responsável pelo atendimento
  - `Cozinheiro.java` - Responsável pela preparação dos pedidos
  - `Almoxarifado.java` - Gerencia o estoque
  - `Pedido.java` - Representa os pedidos
  - `ItemPedido.java` - Itens individuais de um pedido
  - `Produto.java` - Produtos disponíveis no cardápio

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
