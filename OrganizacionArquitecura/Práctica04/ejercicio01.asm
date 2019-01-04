.data
	num1: .word 6 #guardamos en la memoria el valor del primer numero a sumar
	num2: .word 5 #guardamos en la memoria el valor del segundo numero a sumar
	num3: .word  #para guardar en la memoria el resultado de la suma de num1  y num2
.text
	lw $t0, num1 #cargamos el valor de num1
	lw $t1, num2 #cargamos el valor de num2
	add $t3,$t0,$t1 #hacemos la operacion de num1+num3 y lo guardamos en $t3
	sw $t3,num3 #guardamos en la memoria el valor  de $t3 en la direccion  de memoria con etiqueta num3 
