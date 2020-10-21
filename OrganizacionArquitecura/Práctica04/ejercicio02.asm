
	.text

	li $t1 2

valor: add $t2 $t2 $t1
	bne $t2 100 valor 
	add $t3 $t3 $t2 #copiamos el valor final de $t2 en $t3
	mul $t2 $t2 0 #inicializamos a $t2 en 0


