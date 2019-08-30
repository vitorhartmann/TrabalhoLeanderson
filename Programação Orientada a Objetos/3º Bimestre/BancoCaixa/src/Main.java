import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        // Declarando as variáveis, Scanner e Random
        String nome;
        double inicial;
        double credito;
        Scanner entrada = new Scanner(System.in);

        int conta = 1;

        //Obtendo os dados iniciais do Cliente
        System.out.println("Cadastrando novo cliente.");
        System.out.print("Entre com seu nome: ");
        nome = entrada.nextLine();

        System.out.print("Entre com o valor inicial depositado na conta: ");
        inicial = entrada.nextDouble();

        System.out.print("Entre com o valor inicial de credito da conta: ");
        credito = entrada.nextDouble();

        //Criando a conta de um cliente
        Conta minhaConta = new Conta(nome, conta, inicial);
        minhaConta.iniciar();
    }


}