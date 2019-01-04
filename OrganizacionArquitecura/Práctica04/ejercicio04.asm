	.data
in:	.byte 1 #guardamos en la memoria el valor 1, que nos servira para hacer el incremento
x:	.word 10 #guardamos en la memoria el valor de x 
y:	.word 5 #guardamos el la memoria el valor de y
r:	.word   #para guardar en la memoria el resultado de y=y+x

	.text
	lb $t0 in #cargamos el valor de in
	lw  $t1 x #cargamos el valor de x
	lw  $t2 y #cargamos el valor de y 
inc:	add $t3,$t3,$t0 #va haciendo el incremento de uno en uno
	beq $t3,101,fin #la condicion de salida
	add $t2,$t1,$t2 #la operacion y=x+y
	sw  $t2 r #va guardando el valor de y despues de hacer la operacion y=x+y
	j inc #regresa a inc para seguir haciendo el incremento
fin: 	sw $t2 r #guarda el valor final de y, de acuerdo a la operacion y=x+y

