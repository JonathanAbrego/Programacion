	.data
cad: 	.asciiz " Inserte el valor de x: "
cad1: 	.asciiz " Inserte el valor ded y: "
cad2: 	.asciiz " el valor de x^y es: : "
    	.text
main:
    	la $a0,cad
    	li $v0,4
    	syscall
    	
    	li $v0,5
    	syscall
    	
    	move $t0,$v0
    	la $a0,cad1
    	li $v0,4
    	syscall
    	
    	li $v0,5
	syscall
    
    	move $a1,$v0 	#$a1 es igual al valor de Y
    	move $a0, $t0 	#$a0 es igual al valor de X
   	jal Potencia 	#Salta a la subrutina potencia
	move $s0,$v0
    	
    	la $a0,cad2
    	li $v0,4
    	syscall
    	
    	move $a0,$s0
    	li $v0,1
    	syscall
    	
    	li $v0,10
    	syscall
    
Potencia: 
	addi $sp,$sp,-4
    	sw $ra,0($sp)
   	bne $a1,$zero, f1
	addi $v0,$zero,1
	addi $sp, $sp,4
    	jr $ra
f1: 
	bne $a1,1, f2
	add $v0,$zero, $a0
	addi $sp,$sp,4
    	jr $ra
f2: 
	move $t1,$a1
    	andi $t0, $t1,1 
    	bne $t0,$zero, f3
    	srl $a1, $a1,1 
    	jal Potencia
    	mul $v0,$v0,$v0
    	lw $ra, 0($sp)
    	addi $sp,$sp,4
    	jr $ra
f3:
	addi $a1,$a1,-1 #odd X*power(x,n-1)
    	jal Potencia
	lw $ra, 0($sp)
	addi $sp,$sp,4
    	mul $v0,$v0,$a0
    	jr $ra