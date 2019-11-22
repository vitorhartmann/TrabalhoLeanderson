#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(void) {
  FILE* arq;
  if ((arq = fopen("dataehora.txt", "a")) == NULL)
  {
    printf("\nErro na abertura/criacao do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo criado/aberto para inclusao!");
  }

  fprintf(arq, "%s - %s\n",__DATE__,__TIME__);
  fclose(arq);
  
//-------------------------------------

  /*if ((arq = fopen("dataehora.txt", "r")) == NULL)
  {
    printf("\nErro na abertura do arquivo!");
    exit(1);
  }
  else
  {
    printf("\nArquivo aberto para leitura!");
  }

  struct produto lerProd;
  fread(&lerProd, sizeof(sProduto), 1, arq);
  fclose(arq);

  printf("\n");
  printf("%i", lerProd.codigo);
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
