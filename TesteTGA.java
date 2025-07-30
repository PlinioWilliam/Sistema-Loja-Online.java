public class TesteTGA{

    public static void main(String[] args){
        Cliente c = new Cliente("Fulano", "72276538190");

        if(c != null) System.out.println("[OK] Criação de cliente");
        else System.out.println("[NOK] Criação de cliente");

        if(c.getNome().equals("Fulano")) System.out.println("[OK] Nome do cliente");
        else System.out.println("[NOK] Nome do cliente");

        if(c.getCpf().equals("72276538190")) System.out.println("[OK] CPF do cliente");
        else System.out.println("[NOK] CPF do cliente");

        if(c.getPontos() == 0) System.out.println("[OK] Pontos do cliente zerados");
        else System.out.println("[NOK] Pontos do cliente não estão zerados na criação");

        c.adicionarPontos(20);

        if(c.getPontos() == 20) System.out.println("[OK] Pontos do cliente atualizados");
        else System.out.println("[NOK] Pontos do cliente não estão sendo atualizados");

        c.removerPontos(19);

        System.out.println("" + c.getPontos());

        if(c.getPontos() == 1) System.out.println("[OK] Pontos do cliente atualizados");
        else System.out.println("[NOK] Pontos do cliente não estão sendo atualizados");

        c.removerPontos(1);

        if(c.getPontos() == 0) System.out.println("[OK] Pontos do cliente atualizados");
        else System.out.println("[NOK] Pontos do cliente não estão sendo atualizados");

        Produto p = new Produto("Nintendo Switch", 2100);

        if(p != null) System.out.println("[OK] Criação de produto");
        else System.out.println("[NOK] Criação de produto");

        if(p.getNome().equals("Nintendo Switch")) System.out.println("[OK] Nome do produto");
        else System.out.println("[NOK] Nome do produto");

        if(p.getPreco() == 2100) System.out.println("[OK] Preço do produto");
        else System.out.println("[NOK] Preço do produto");

        CompraParcelada cp = new CompraParcelada(c, p, 8, 3.5);

        if(cp != null) System.out.println("[OK] Criação da compra parcelada");
        else System.out.println("[NOK] Criação da compra parcelada");

        if(cp.getNumeroParcelasTotal() == 8) System.out.println("[OK] Criação da compra parcelada com total de parcelas correto");
        else System.out.println("[NOK] Criação da compra parcelada com total de parcelas incorreto");

        if(cp.getSaldoDevedor() == 2173.5) System.out.println("[OK] Criação da compra parcelada com saldo devedor correto");
        else System.out.println("[NOK] Criação da compra parcelada com saldo devedor incorreto");

        if(cp.calculaValorComJuros(180, 4.5) == 188.1) System.out.println("[OK] Método CompraParcelada.calculaValorComJuros");
        else System.out.println("[NOK] Erro no método CompraParcelada.calculaValorComJuros");

        if(cp.calculaPontosFidelidade(100, 123) == 5) System.out.println("[OK] Método CompraParcelada.calculaPontosFidelidade");
        else System.out.println("[NOK] Erro no método CompraParcelada.calculaPontosFidelidade");

        if(cp.getQtdParcelasRestantes() == 8) System.out.println("[OK] Método CompraParcelada.getQtdParcelasRestantes");
        else System.out.println("[NOK] Erro no método CompraParcelada.getQtdParcelasRestantes, deveria ser 8");

        if(cp.getValorProximaParcela() == 271.69) System.out.println("[OK] Método CompraParcelada.getValorProximaParcela");
        else System.out.println("[NOK] Erro no método CompraParcelada.getValorProximaParcela, deveria ser 271.69");

        cp.fazerPagamento(271.69);

        if(cp.getQtdParcelasRestantes() == 7) System.out.println("[OK] Método CompraParcelada.getQtdParcelasRestantes");
        else System.out.println("[NOK] Erro no método CompraParcelada.getQtdParcelasRestantes, deveria ser 7");

        if(cp.getValorProximaParcela() == 281.2) System.out.println("[OK] Método CompraParcelada.getValorProximaParcela");
        else System.out.println("[NOK] Erro no método CompraParcelada.getValorProximaParcela, deveria ser 281.20");

        cp.fazerPagamento(300);

        if(cp.getQtdParcelasRestantes() == 6) System.out.println("[OK] Método CompraParcelada.getQtdParcelasRestantes");
        else System.out.println("[NOK] Erro no método CompraParcelada.getQtdParcelasRestantes, deveria ser 6");

        if(cp.getValorProximaParcela() == 287.79) System.out.println("[OK] Método CompraParcelada.getValorProximaParcela");
        else System.out.println("[NOK] Erro no método CompraParcelada.getValorProximaParcela, deveria ser 287.79");

        if(c.getPontos() == 4) System.out.println("[OK] Método Cliente.getPontos");
        else System.out.println("[NOK] Erro no método Cliente.getPontos, deveria ser 4");
        System.out.println("" + c.getPontos());
    }
}