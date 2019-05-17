
import java.util.Scanner; 
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Sistema {




 

  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);

    System.out.printf("\n");
    System.out.printf("Informe o nome de arquivo texto:\n");
    System.out.printf("Favor Digitar o nome do arquivo do programa\n");
    System.out.printf("-----------------------------------------\n");
    System.out.printf(" Programa1.txt\n");
    System.out.printf(" Programa2.txt\n");
    System.out.printf(" Programa3.txt\n");
    System.out.printf("-----------------------------------------\n");
    String nome = ler.nextLine();
  

   
    System.out.printf("\nAbrindo Arquivo:\n");
 
    System.out.printf("\n");
     // Inicio da Execução do programa 1
    if (nome.equals("Programa1.txt")){

      try 
      {
          Thread.sleep(2000);
      
      } 
      catch(InterruptedException e)
      { }
      
        for(int cont=6; cont>0; cont--){
          System.out.println("Simulador SO Monotarefa");
          System.out.println("---------------------------------");
          System.out.println("Executando processo: Programa1.txt");
          System.out.println("Tipo do processo: CPU");
          System.out.println("Tempo estimado de execucao: 6");
          System.out.println("Tempo Restante  " +cont + " Segundos");
          System.out.println("---------------------------------");
        
      
          try 
      {
          Thread.sleep(1000);
          for (int i = 0; i < 50; ++i){ // Gambiarra pra limpar a tela
          System.out.println ();
        }
      } 
      catch(InterruptedException e)
      {
           
      }
      

      
        }

       


      // Inicio da Execução do programa 2
    }else if (nome.equals("Programa2.txt")){

      try 
      {
          Thread.sleep(2000);
      
      } 
      catch(InterruptedException e)
      { }
      
        for(int cont=10; cont>0; cont--){
          System.out.println("Simulador SO Monotarefa");
          System.out.println("---------------------------------");
          System.out.println("Executando processo: Programa2.txt");
          System.out.println("Tipo do processo: ES");
          System.out.println("Tempo estimado de execucao: 10");
          System.out.println("Tempo Restante  " +cont + " Segundos");
          System.out.println("---------------------------------");
        
      
          try 
      {
          Thread.sleep(1000);
          for (int i = 0; i < 50; ++i){ // Gambiarra pra limpar a tela
          System.out.println ();
        }
      } 
      catch(InterruptedException e)
      {
           
      }
        
      
        }
      



 // Inicio da Execução do programa 3
    }else if (nome.equals("Programa3.txt")){

      try 
      {
          Thread.sleep(2000);
      
      } 
      catch(InterruptedException e)
      { }
      
        for(int cont=15; cont>0; cont--){
          System.out.println("Simulador SO Monotarefa");
          System.out.println("---------------------------------");
          System.out.println("Executando processo: Programa3.txt");
          System.out.println("Tipo do processo: GPU");
          System.out.println("Tempo estimado de execucao: 15");
          System.out.println("Tempo Restante  " +cont + " Segundos");
          System.out.println("---------------------------------");
          
        
      
          try 
      {
          Thread.sleep(1000);
          for (int i = 0; i < 50; ++i){  // Gambiarra pra limpar a tela
          System.out.println ();
          }
      } 
      catch(InterruptedException e)
      {
           
      }
        
      
        }
      
        // Inserir aqui
    
        









   

  }


  try {
    FileReader arq = new FileReader(nome);
    BufferedReader lerArq = new BufferedReader(arq);

    String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
    while (linha != null) {
      System.out.printf("%s\n", linha);

      linha = lerArq.readLine(); // lê da segunda até a última linha
    
    }

    arq.close();
  } catch (IOException e) {
      System.err.printf("Erro na abertura do arquivo: %s.\n",
        e.getMessage());
  

  System.out.println();
}








}
}



/*CONTADOR PRA ESPERA X SEGUNDOS


   try 
{
    Thread.sleep(2000);

} 
catch(InterruptedException e)
{ }

  for(int cont=0; cont<10; cont++){
    System.out.println("---------------------------------");
    System.out.println("Carregando:  " +cont + "/10");
    System.out.println("---------------------------------");
    
  

    try 
{
    Thread.sleep(200);
    for (int i = 0; i < 50; ++i) // Gambiarra pra limpar a tela
    System.out.println ();
} 
catch(InterruptedException e)
{
     
}
  

  }



*/


/* Parada que fazia o codigo funcionar mas n abria o coiso

try {
  

          FileReader arq = new FileReader(nome);
          BufferedReader lerArq = new BufferedReader(arq);
     
          String linha = lerArq.readLine(); // lê a primeira linha
          // a variável "linha" recebe o valor "null" quando o processo
          // de repetição atingir o final do arquivo texto
          while (linha != null) {
            System.out.printf("%s\n", linha);
     
            linha = lerArq.readLine(); // lê da segunda até a última linha
    
           
          }
    
          
        
     
          arq.close();
        } catch (IOException e) {
            System.err.printf("O seguinte arquivo e invalido:  %s .\n",
              e.getMessage());
        }
     
        System.out.println();
        
      }



*/