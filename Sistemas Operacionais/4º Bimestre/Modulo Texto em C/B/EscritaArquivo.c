#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
  int codigo = 2469;
  char nome[50] = "Churrasqueira controle remoto";
  float preco = 99.00;
  float desconto = 1.00;

  FILE* arq;
  if ((arq = fopen("EscritaArquivo.txt", "w")) == NULL)
  {
    printf("\nErro na abertura/criacao do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo criado/sobreescrito para inclusão!");
  }

  fprintf(arq, "%d - %s - %f  %f", codigo, nome, preco, desconto);
  printf("\nProduto gravado!");
  fclose(arq);
  
//-------------------------------------

  /*if ((arq = fopen("EscritaArquivo.txt", "r")) == NULL)
  {
    printf("\nErro na abertura do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo aberto para leitura!");
  }

  fread(&lerProd, sizeof(sProduto), 1, arq);
  fclose(arq);

  printf("\n");
  printf("%i", codigo);
  printf("\n");
  printf("%s", lerProd.nome);
  printf("\n");
  printf("%f", lerProd.preco);
  printf("\n");
  printf("%f", lerProd.desconto);
  printf("\n");
  printf("Total %f", lerProd.preco - lerProd.desconto);
  printf("\n");*/

  return(0);
}
