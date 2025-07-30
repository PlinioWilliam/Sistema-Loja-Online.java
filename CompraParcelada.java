public class CompraParcelada {
    private Cliente cliente;  // ATRIBUTO CLIENTE QUE É O OBJETO CRIADO ATRAVÉS DA CLASSE CLIENTE
    private Produto produto;  // ATRIBUTO PRODUTO QUE É O OBJETO CRIADO ATRAVÉS DA CLASSE PRODUTO
    private int numeroParcelasTotais;  // ATRIBUTO QUE SE REFERE AO NUMERO TOTAL DE PARCELAS ESCOLHIDA
    private double taxaJuros; // ATRIBUTO QUE SE REFERE A TAXA DE JUROS UTILIZADA
    private int numeroParcelasPagas;  // ATRIBUTO QUE SE REFERE AO NUMERO DE PARCELAS PAGAS ATÉ O MOMENTO
    private double saldoDevedor;  // ATRIBUTO QUE SE REFERE AO SALDO DEVEDOR
    private double valorPago;  // ATRIBUTO QUE SE REFERE AO VALOR PAGO ATÉ O MOMENTO
    private double valorMultaDiaria;  // ATRIBUTO QUE SE REFERE AO VALOR DA MULTA DIARIA
    private int numeroParcelasRestantes;  // ATRIBUTO QUE SE REFERE AO NUMERO DE PARCELAS RESTANTES
    private double valorParcela;  // ATRIBUTO QUE SE REFERE AO VALOR DA PARCELA
    private int diaVencimento;  // ATRIBUTO QUE SE REFERE AO DIA DE VENCIMENTO DAS PARCELAS
    private int diaPagamento;  // ATRIBUTO QUE SE REFERE AO DIA QUE FOI PAGO A DEVIDA PARCELA

    public CompraParcelada(Cliente cliente, Produto produto, int numeroParcelasTotais, double taxaJuros) {
        // CONSTRUTOR QUE PEDE O CLIENTE, PRODUTO, NUMERO DE PARCELAS TOTAIS E A TAXA DE JUROS
        this.cliente = cliente;
        this.produto = produto;
        this.numeroParcelasTotais = numeroParcelasTotais;
        this.taxaJuros = taxaJuros;
        this.numeroParcelasPagas = 0;
        this.saldoDevedor = calculaValorComJuros(produto.getPreco(), taxaJuros);
        this.valorPago = 0;
        this.valorMultaDiaria = 1.70;
        this.numeroParcelasRestantes = numeroParcelasTotais;
        this.valorParcela = saldoDevedor / numeroParcelasTotais;
        this.diaVencimento = 10;  // DIA DE VENCIMENTO JA PRÉ ESTABELECIDO COMO DIA 10
        this.diaPagamento = 10;  // DIA DE PAGAMENTO JA PRÉ ESTABELECIDO COMO DIA 10
    }

    public double calculaValorComJuros(double valor, double juros) {
        // METODO PARA PODER CALCULAR O VALOR TOTAL SOMADO DO JUROS
        return valor + (valor * (juros / 100));
    }

    public void setDiaVencimento(int diaVencimento) {
        // METODO PARA MODIFICAR O DIA DE VENCIMENTO
        this.diaVencimento = diaVencimento;
    }

    public void setDiaPagamento(int diaPagamento) {
        // METODO PARA MODIFICAR O DIA DE PAGAMENTO
        this.diaPagamento = diaPagamento;
    }

    public double getValorMulta() {
        int diasMais = diaPagamento - diaVencimento;
        double valorMulta = diasMais * valorMultaDiaria;
        return arredondar(valorMulta);
    }
    public double getValorProximaParcela() {
        //  METODO PARA CALCULAR E INFORMAR O VALOR DA PROXIMA PARCELA
        if (diaPagamento > diaVencimento) {
            // CASO O DIA DE PAGAMENTO SEJA MAIOR QUE O DIA DE VENCIMENTO, ELE ACRESCENTA NO VALOR DA PARCELA A MULTA DIARIA
            double valorComMulta = this.valorParcela + getValorMulta();
            return arredondar(valorComMulta);
        }
        return arredondar(this.valorParcela); // CASO NAO SEJA, ELE RETORNA O VALOR DA PARCELA SEM A MULTA
    }

    public int calculaPontosFidelidade(double valorParcela, double valorPago) {
        // METODO PARA CALCULAR OS PONTOS DE FIDELIDADE
        double diferenca = valorPago - valorParcela;
        if(diferenca > 0) {
            return (int)(diferenca / 4);
        }
        return 0;
    }

    public int getQtdParcelasRestantes() {
        // METODO PARA RETORNAR O NUMERO DE PARCELAS RESTANTES
        return this.numeroParcelasRestantes;
    }

    public int fazerPagamento(double pagamento) {
        // METODO PARA REALIZAR OS CALCULOS DEVIDOS DE PAGAMENTO
        if (pagamento == getValorProximaParcela()) {
            // SE O PAGAMENTO FOR IGUAL AO VALOR DA PARCELA, O PROGRAMA FAZ OS DEVIDOS CALCULOS E RETORNA 0 INDICANDO QUE NAO TEVE ERRO
            this.saldoDevedor -= pagamento;
            this.saldoDevedor = calculaValorComJuros(saldoDevedor, taxaJuros);
            this.valorPago += pagamento;
            this.numeroParcelasRestantes--;
            this.valorParcela = this.saldoDevedor / this.numeroParcelasRestantes;
            this.numeroParcelasPagas++;
            return 0;
        } else if (pagamento < getValorProximaParcela()) {
            // SE O PAGAMENTO FOR MENOR QUE O VALOR DA PARCELA, O PROGRAMA NAO FAZ NADA E RETORNA 1, INDICANDO QUE TEVE UM ERRO
            return 1;
        } else if (pagamento > this.saldoDevedor) {
            // SE O PAGAMENTO FOR MAIOR QUE O VALOR DA PARCELA, O PROGRAMA NAO FAZ NADA E RETORNA 2, INDICANDO QUE TEVE UM ERRO
            return 2;
        } else if (pagamento == this.saldoDevedor){
            // SE O PAGAMENTO FOR IGUAL AO SALDO DEVEDOR TOTAL, O PROGRAMA FAZ OS DEVIDOS CALCULOS, CALCULA OS PONTOS DE FIDELIDADE DO CLIENTE
            // E RETORNA 0 INDICANDO QUE NAO TEVE ERRO
            int pontos = calculaPontosFidelidade(valorParcela, pagamento);
            this.cliente.adicionarPontos(pontos);
            this.saldoDevedor -= pagamento;
            this.valorPago += pagamento;
            this.numeroParcelasRestantes = 0;
            this.valorParcela = 0;
            this.numeroParcelasPagas++;
            return 0;
        } else if (pagamento > getValorProximaParcela()) {
            // SE O PAGAMENTO FOR MAIOR QUE O VALOR DA PARCELA, O PROGRAMA FAZ OS DEVIDOS CALCULOS, CALCULA OS PONTOS DE FIDELIDADE DO CLIENTE
            // E RETORNA 0 INDICANDO QUE NAO TEVE ERRO
            int pontos = calculaPontosFidelidade(valorParcela, pagamento);
            this.cliente.adicionarPontos(pontos);
            this.saldoDevedor -= pagamento;
            this.saldoDevedor = calculaValorComJuros(saldoDevedor, taxaJuros);;
            this.valorPago += pagamento;
            this.numeroParcelasRestantes--;
            this.valorParcela = this.saldoDevedor / this.numeroParcelasRestantes;
            this.numeroParcelasPagas++;
            return 0;
        }
        return 3;
        // SE NENHUMA DAS ALTERNATIVAS ACIMA OCORRER, O PROGRAMA RETORNA 3, INDICANDO UM ERRO
    }

    public void imprimeRelatorio() {
        // METODO QUE RETORNA AS INFORMAÇOES PRINCIPAIS REFERENTE A COMPRA
        System.out.println("----------------- Resumo da Compra -----------------");
        System.out.println("Comprador: " + this.cliente.getNome() + " (" + this.cliente.getCpf() + ") ");
        System.out.println("Produto: " + this.produto.getNome());
        System.out.println("Valor do produto: R$" + arredondar(this.produto.getPreco()));
        System.out.println("Comprado em " + getNumeroParcelasTotal() + " parcelas");
        System.out.println("Taxa de Juros: " + getTaxaJuros() + "%");
        System.out.println("Numero de parcelas pagas: " + getNumeroParcelasPagas());
        System.out.println("Valor total pago até o momento: " + getValorJahPago());
        System.out.println("Número de parcelas restantes: " + getQtdParcelasRestantes());
        System.out.println("Valor da próxima parcela: " + getValorProximaParcela());
        System.out.println("Saldo devedor: " + getSaldoDevedor());
        System.out.println("Valor da multa por atraso: R$" + getValorMulta());
        System.out.println("Pontos de fidelidade: " + this.cliente.getPontos());
        System.out.println("----------------------------------------------------");
    }

    public int getNumeroParcelasTotal() {
        // METODO QUE RETORNA O NUMERO DE PARCELAS TOTAIS
        return this.numeroParcelasTotais;
    }

    public int getNumeroParcelasPagas() {
        // METODO QUE RETORNA O NUMERO DE PARCELAS PAGAS
        return this.numeroParcelasPagas;
    }

    public double getSaldoDevedor() {
        // METODO QUE RETORNA O SALDO AINDA EM ABERTO
        return arredondar(this.saldoDevedor);
    }

    public double getValorJahPago() {
        // METODO QUE RETORNA O VALOR JA PAGO
        return this.valorPago;
    }

    public double getTaxaJuros() {
        // METODO QUE RETORNA A TAXA DE JUROS
        return this.taxaJuros;
    }

    private double arredondar(double valor) {
        // METODO QUE ARREDONDA VALOR EM DUAS CASAS DECIMAIS
        return Math.round(valor * 100.0) / 100.0;
    }
}