#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
  FILE* arq;
  if ((arq = fopen("TabelinhaMostrar.txt", "w")) == NULL)
  {
    printf("\nErro na abertura/criacao do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo criado/aberto para inclusao!");
  }

  if (fprintf(arq, "%s %i %f", "ElaVaiVoltarCharlieBrown", 24, 3.1415) != 1)
  {
    printf("\nErro na gravacao.");
  }
  else
  {
    printf("\n Dados gravados.");
  }
  fclose(arq);
  
//-------------------------------------

  if ((arq = fopen("TabelinhaMostrar.txt", "r")) == NULL)
  {
    printf("\nErro na abertura do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo aberto para leitura!");
  }

  char texto[50];
  int inteiro;
  float decimal;


  fscanf(arq, "%s %i %f", texto, &inteiro, &decimal);
  printf("\n%s %i %f", texto, inteiro, decimal);
  fclose(arq);

  return(0);
}
