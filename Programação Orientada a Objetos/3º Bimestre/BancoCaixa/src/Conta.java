import java.util.Scanner;


// Muita mágica daqui pra baixo, e preguiça de comentar
public class Conta {
    private String nome;
    private int conta, saques, depositos;
    private double saldo;
    private double credito;

    Scanner entrada = new Scanner(System.in);

    public Conta(String nome, int conta, double inicial, double saldo_inicial, double credito_inicial){
        this.nome=nome;
        this.conta=conta;
        saldo=saldo_inicial;
        credito=credito_inicial;
        saques=0;
        depositos=0;
    }

    public void extrato(){
        System.out.println("\tEXTRATO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número da conta: " + this.conta);
        System.out.printf("Saldo atual: %.2f\n",this.saldo);
        System.out.println("Saques realizados hoje: " + this.saques + "\n");

    }

    public void sacar(double valor){
        if(saldo >= valor){
                saldo -= valor;
                saques++;
                System.out.println("Sacado: " + valor);
                 System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    public void depositar(double valor)
    {
        saldo += valor;
        depositos++;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    public void iniciar(){
        int opcao;

        do{
            exibeMenu();
            opcao = entrada.nextInt();
            escolheOpcao(opcao);
        }while(opcao!=4);
    }

    public void exibeMenu(){

        System.out.println("\t Escolha a opção desejada");
        System.out.println("1 - Extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sair\n");
        System.out.print("Opção: ");

    }

    public void escolheOpcao(int opcao){
        double valor;

        switch( opcao ){
            case 1:
                extrato();
                break;
            case 2:

                    System.out.print("Quanto deseja sacar: ");
                    valor = entrada.nextDouble();
                    sacar(valor);
                break;

            case 3:
                System.out.print("Quanto deseja depositar: ");
                valor = entrada.nextDouble();
                if (valor<0) {
                    System.out.println("ERRO - VALOR DE DEPOSITO NEGATIVO");
                    System.out.println("Retornando Ao Menu....O");
                } else{
                    depositar(valor);
                }
                break;

            case 4:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}
