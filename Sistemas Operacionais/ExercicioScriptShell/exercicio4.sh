#!/bin/bash

echo "Digite um numero para mostrar a tabuada"
read numero
y=1
while [  $y -le 10  ]; do
result=$(($numero*$y))
echo " $numero * $y = $result "            
 y=$[ $y + 1 ]
 done
