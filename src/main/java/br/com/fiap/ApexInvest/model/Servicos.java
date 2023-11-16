package br.com.fiap.ApexInvest.model;

public class Servicos {

    public static boolean tranferencia(Conta origem, Conta destino, double valorTransferencia){
        if (origem.getSaldo() >= valorTransferencia) {
            origem.setSaldo(origem.getSaldo() - valorTransferencia);
            destino.setSaldo(destino.getSaldo() + valorTransferencia);
            System.out.println("Transferência realizada com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return false;
        }
    }
}
