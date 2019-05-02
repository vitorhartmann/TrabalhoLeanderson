#!/bin/bash

echo "Digite uma opcao"
echo "1) Mostrar Calendario"
echo "2) Lista de arquivos do diretório"
read opcao
if [ $opcao -eq 1 ];
then cal 
elif [ $opcao -eq 2 ];
then ls
else echo "Opcao invalida"
fi
