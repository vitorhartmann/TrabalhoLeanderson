/*******************************************************************************
* 1 - Inserir notas do aluno   ## INPUT
* 2 - Listar Notas do Aluno     ## OUTPUT
* 3 - Mostrar média do aluno e se o aluno foi aprovado ou reprovado ## OUTPUT
* 4 - Finalizar o programa
*******************************************************************************/
import java.util.Scanner;

public class Trabalhinho {
	private static int[] Vetor = new int[4];
	private static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		

		boolean continuar = true;
		while(continuar){
			System.out.println("*****************************************************************************");
			System.out.println("* 1 - Inserir notas do aluno , apenas notas inteiras   ");
			System.out.println("* 2 - Listar Notas do Aluno    ");
			System.out.println("* 3 - Mostrar média do aluno e se o aluno foi aprovado ou reprovado com arredondamento simples ");
			System.out.println("* 4 - Finalizar o programa");
			System.out.println("*******************************************************************************");
			System.out.println("Digite uma opcao: ");
			int opcao = entrada.nextInt();
			switch(opcao){
				case 1:
					CarregarVetor();
					break;
				case 2:
					System.out.print(ListarVetor());
					break;
				case 3:
					System.out.print(ListarParesVetor());
					break;
				case 4:
				System.out.println("Finalizando Programa");
					continuar = false;
					
					break;
				default:
					System.out.println("Opcao invalida.");
			}
		}
	}
	//1 - Carregar Vetor
	public static void CarregarVetor(){
		for(int x=0;x<4;x++){
			System.out.println("Digite a nota do "+(x+1)+"º bimestre: ");
			Vetor[x]= entrada.nextInt();
		}
		System.out.println("\nNotas inseridas com sucesso!\n");
	}
	//2 - Listar Vetor
	public static String ListarVetor(){
		String ListaVetor = "Notas do boletim:\n";
		for(int x=0;x<4;x++){
			ListaVetor += "\t "+(x+1)+"º Bimestre:"+Vetor[x]+"\n";
		}
		return ListaVetor;
	}
	//3 - Verificar se Aluno passou de ano
	public static String ListarParesVetor(){
		String ListaVetor = "Situação do Aluno:\n";
		Double Soma =0.00;
		for(int x=0;x<4;x++){


			 Soma= Soma + Vetor[x];
			
			
		}
		Double Divisao =  Soma / 4 ;
		
		System.out.println("DEBUG TESTE:"+Math.rint(+Divisao));

		
	 		Math.round(+Divisao);
		if (Divisao > 6.9){
			ListaVetor = "APROVADO \n";
			
		}else{
		ListaVetor = "REPROVADO \n";
		
		}
		System.out.println("Media:"+Divisao);
		return ListaVetor;
		
	}
	

}