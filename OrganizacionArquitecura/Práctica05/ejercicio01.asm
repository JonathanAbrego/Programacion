	.data 
num:	.word 15 #x
num2:	.word 11 #y	
num3:	.word  8 #z
	
	.text
	lw $t0 num
	lw $t1 num2
	lw $t2 num3
main:
	sub $v0, $t0, $t1 #para ver si x>y o x<y
if:	bltz $v0 else  #si y>x entonces salta a else, en caso contrario entonces y<x
	jal f1
else:	add $v0, $t2, 1 #regresamos el valor resultante y lo guardamos en $v0  que es 13
	j fin

f1:	#recur(x-1, y, z)
	move $v0, $t0 #guardamos el valor de x en algun lado
	sub  $t0, $t0, 1
	sub  $v0, $t0, $t1 #para ver si x>y o x<y
	bltz $v0 r
	jal f1
	
r:
	lw $t0 num	
	lw $t1 num2
	lw $t2 num3
	jal f2
	
f2:	#recur(y-1, z, x)
	move $s0, $t0 #guardamos el valor de x en algun lado
	move $s2, $t2 #guardamos el valor de z en algun lado
	sub  $t0, $t1, 1 
	move $t2, $s0
	move $t1, $s2
	sub  $v0, $t0, $t1 #para ver si x>y o x<y
	bltz $v0 r1
	jal f2
	
r1:
	lw $t0 num	
	lw $t1 num2
	lw $t2 num3
	jal f3

f3:	#recur(z-1, x, y)
	move $s0, $t0 #guardamos el valor de x en algun lado
	move $s1, $t1 #guardamos el valor de y en algun lado
	sub  $t0, $t2, 1
	move $t1, $s0
	move $t2, $s1
	sub  $v0, $t0, $t1 #para ver si x>y o x<y
	bltz $v0 main
	jal f3
fin:
