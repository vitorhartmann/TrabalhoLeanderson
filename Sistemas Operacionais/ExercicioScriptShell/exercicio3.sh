#!/bin/bash

echo "Digite um numero"
read numero
if [ $numero -lt 0 ]; then echo "Negativo"
else echo "Positivo" 
fi
