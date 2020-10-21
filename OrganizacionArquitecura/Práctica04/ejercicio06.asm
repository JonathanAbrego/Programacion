	
.text	
	li $t0 25 #numero1
	li $t1 15 #numero2
	
r:	
	move $t2 $t1
	div  $t0 $t1
	mfhi $t3
	move $t0 $t1
	move $t1 $t3
finr: 	bnez $t3 r
	move $v0 $t0 #guardamos en $v0 el mcd

		
