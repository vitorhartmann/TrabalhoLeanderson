#!/bin/bash

echo "Digite o primeiro numero"
read prim
echo "Digite o segundo numero"
read second
result=$(($prim*$second))
echo "$prim * $second = $result"
