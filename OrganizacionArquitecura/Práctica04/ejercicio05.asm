#Si aplicamos que  Dividendo = (Divisor * Cociente)+ Residuo entonces tambien nos importan los signos 
#de cociente y residuo
#Si el Dividendo es 0 entonces automaticamente $v0 y $v1 valen 0 por omision
#Si el divisor es 0 entonces usamos teqi 
#Ejemplo que tenemos Divisor=18 y dividendo=4
# 18/4 --------  18 = (4 *(4)) + (2)------- Cociente= 4 y Residuo=2
# 18/-4 -------  18 = (-4 *(-4)) +(2)------ Cociente=-4 y Residuo=2
# -18/4 ------- -18 = (4 *(-4)) + (-2)----- Cociente=-4 y Residuo=-2
# -18/-4------- -18 = (-4* (4)) +(-2)------ Cociente= 4 y Residuo=-2

.data 
incremen:	.word	1
dividendo:	.word 	18
divisor:	.word	4
resultado:	.word 

.text
		lw $t0 incremen
		lw $t1 dividendo
		lw $t2 divisor
		lw $t6 dividendo #auxiliar para guardar el valor de dividendo
		lw $t7 divisor #auxiliar para guardar el valor de divisor
		
		beq $t1 0 fin #caso de que sea 0 el dividendo, automaticamente $v0 y $v1 son igual a cero
		bne $t2 0  c1#termina si el divisro es igual a cero
		break 

c1:		bgtz $t2 r2 #si el divisor es mayor que 0, salta y comprueba a el dividendo
		mul $t2 $t2 -1 
r2:		bgtz $t1 s #si es mayor el dividendo sigue normalmente
		mul $t1 $t1 -1

s:		add $v0 $v0 $t0 
		mul $t3 $t2 $v0
		sub $t4 $t1 $t3
		bltz $t4 coc
		j s

coc:		addi $v0 $v0 -1 #cociente
		mul $t2 $v0 $t2
		sub $v1 $t1 $t2 #residuo		

		bgtz $t6 t1
		bltz $t7 t1
		mul $v1 $v1 -1
						
t1:		bgtz $t6 s1 #caso que dividendo sea negativo
		mul $v0 $v0 -1 		
		
s1:		bgtz $t7 t2  #caso que divisor sea negativo
		mul $v0 $v0 -1
		
t2:		bgtz $t7 fin		
		bgtz $t6 fin
		mul $v1 $v1 -1
						
fin:  		div $t5 $t6 $t7 #para comprobar que el valor en $v0 es el correcto
