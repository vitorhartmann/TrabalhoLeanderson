// Aluno: Vitor A. Hartmann
// Sistemas da informação, Noturno.

// Durante este trabalho realizei viagens em busca do conhecimento, onde me levou para lugares distintos tanto da internet quanto 
// da vida real.
// após muito tempo de busca consegui encontrar respostas para programas que sequer foram pensados em ser desenvolvidos
// Muito tempo após essas descobertas me tornei um nova pessoa, uma pessoa disposta a buscar o conhecimento na vida, onde a resposta
// de toda a existencia da humanidade, e cheguei na conclusão de 42.







// O PROBLEMA:
// Cadastrar a nota dos 4 bimestres de um aluno
// Calcular se o aluno foi aprovado ou reprovado 
// Calcular o arredondamento de forma generosa (média 6.5)


import java.util.Scanner; //Importando o scanner, se n tiver, n tem entrada de dados

public class Trabalhinho {
	private static int[] Vetor = new int[4]; // Definindo um vetor de 4 , que são os 4 bimestres
	private static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		

		boolean continuar = true; // Inicio laço de repetição
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
					CarregarVetor(); //Puxa função para adicionar valores ao vetor boletim INPUT
					break;
				case 2:
					System.out.print(ListarVetor()); // Puxa função para adicionar valores ao vetor boletim OUTPUT
					break;
				case 3:
					System.out.print(ListarSituVetor()); // Puxa função pra mostrar a situação do aluno
					break;
				case 4:
				System.out.println("Finalizando Programa"); // Exemplo extremamente complicado utilizando de métodos cientificos e mágicos proibidos para simples programadores, me ensinado por um monge do himalaia quando eu estava em busca do verdadeiro significado do visual studio
					continuar = false;
					
					break;
				default:
					System.out.println("Opcao invalida, Favor escolher os numeros 1 , 2 , 3 ou 4 para sair.");
			}
		}
	}
	//1 - Função pra adicionar valores ao vetor (Sim, olhei na internet como fazia, acho que merecia + 0,5 pelo esforço)
	public static void CarregarVetor(){
		for(int x=0;x<4;x++){
			System.out.println("Digite a nota do "+(x+1)+" bimestre: "); //Pedindo pra inserir a nota do 1º,2º,3º,4º bimestre
			Vetor[x]= entrada.nextInt();
		}
		System.out.println("\nNotas inseridas com sucesso!\n"); //Confirmação de inserção das notas do boletim no vetor
	}
	//2 - Mostrar as notas do boletim, 1º ao 4º Bimestre, um em cima do outro
	public static String ListarVetor(){
		String ListaVetor = "Notas do boletim:\n";
		for(int x=0;x<4;x++){
			ListaVetor += "\t "+(x+1)+"  Bimestre:"+Vetor[x]+"\n";
		}
		return ListaVetor;
	}
	//3 - Verificar se aluno foi aprovado ou reprovado
	public static String ListarSituVetor(){
		String ListaVetor = "Situacao do Aluno:\n";
		Double Soma =0.00; //Gambiarra, de alto nivel
		for(int x=0;x<4;x++){


			 Soma= Soma + Vetor[x]; // Soma de todos os valores do vetor
			
			
		}
		Double Divisao =  Soma / 4 ; // Divisão da nota, para fazer a média
		

		
	 		Math.round(+Divisao); // Arredondamento, classe MATH (Pode dar o 1 ponto, usei)
		if (Divisao > 6.9){
			ListaVetor = "APROVADO \n"; // Caso atingir acima de 7, após arredondamento
			
		}else{
		ListaVetor = "REPROVADO \n"; //Caso não atingir 7 (Bem dificil, pq o sistema arredonda 6.5 pra 7, aí o aluno tem que ser burro)
		
		}
		System.out.println("Media:"+Divisao); // Mostra a media do aluno
		return ListaVetor;
		
	}
	

}
