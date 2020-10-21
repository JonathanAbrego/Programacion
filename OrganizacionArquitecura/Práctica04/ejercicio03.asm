.data 

 x: .word  4 #guardamos en la memoria el valor del primer numero a operar
 y: .word  5 #guardamos en la memoria el valor del segundo numero a operar
 r: .word
 
.text
lw $t0 x #cargamos en $t0 el valor de x
lw $t1 y #cargamos en $t1 el valor de y

bltz $t0, suma #si x es menor que 0 entonces hacemos la suma 
sub $t2, $t0, $t1 #como x es mayor que cero entonces se hace la resta x-y
j res #saltamos a la etiqueta res
suma:  add $t2, $t1, $t0 #realiza la operacion x+y
res: sw $t2 r #se guarda en la memoria el valor ya sea de la suma o resta
