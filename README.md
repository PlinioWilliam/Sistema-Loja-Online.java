# 💳 Sistema de Compras Parceladas com Fidelidade

Este projeto implementa um sistema de compras parceladas para uma loja online, com suporte a:

- Parcelamento com aplicação mensal de juros.
- Pagamentos antecipados com geração de pontos de fidelidade.
- Cálculo e redistribuição automática do saldo devedor.
- Relatórios completos da compra e do cliente.

## 📘 Cenário

Clientes podem parcelar compras de produtos entre **2 a 10 vezes**, com **juros mensais** aplicados sobre o saldo devedor. O sistema também permite **pagamentos antecipados**, os quais:

- Reduzem o saldo devedor.
- Diminuem o valor das parcelas futuras.
- Geram pontos de fidelidade: a cada R$ 4,00 pagos antecipadamente, o cliente recebe 1 ponto.

## 📦 Estrutura do Projeto

### `Cliente`
Representa o comprador.

- `nome`, `cpf`, `pontosFidelidade`
- Métodos: `adicionarPontos()`, `removerPontos()`, etc.

### `Produto`
Representa um item à venda.

- `nome`, `preco`

### `CompraParcelada`
Gerencia a compra parcelada.

- Atributos:
  - Cliente e produto
  - Parcelas totais, parcelas pagas
  - Saldo devedor, valor pago, taxa de juros
- Métodos principais:
  - `calculaValorComJuros(valor, taxa)`
  - `calculaPontosFidelidade(valorParcela, valorPago)`
  - `fazerPagamento(valorPago)`
  - `getValorProximaParcela()`, `getSaldoDevedor()`
  - `imprimeRelatorio()`

## 🔁 Regras de Negócio

- Parcelamento permitido: de 2 a 10 vezes.
- Não é permitido:
  - Pagar menos que o valor da parcela prevista.
  - Pagar mais do que o saldo devedor.
- Juros são aplicados mensalmente sobre o saldo restante.

## 📌 Exemplo

- Produto: Xbox One S — R$ 2.900,00
- Parcelado em 10x com juros de 5% ao mês.
- Ao pagar R$ 450,00 antecipadamente em uma parcela de R$ 319,73, o cliente reduz o saldo e acumula pontos.

## ✅ Avaliação

- Implementação correta das regras e métodos.
- Clareza e organização do código.
- Penalidades para atrasos e cópias indevidas conforme regulamento.