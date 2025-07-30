public class Main {
    public static void main(String[] args) {

        Cliente plinio = new Cliente("Plínio William", "048.295.350-08");
        Produto televisao = new Produto("Televisão", 1200);

        CompraParcelada compra1 = new CompraParcelada(plinio, televisao, 8, 10);

        //compra1.fazerPagamento(165);
        //compra1.fazerPagamento(350);
        //compra1.fazerPagamento(1012.55);
        compra1.imprimeRelatorio();
        compra1.setDiaPagamento(15);
        compra1.imprimeRelatorio();

    }
}