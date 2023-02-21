#	Computer Systems Organization
#	Winter Semester 2021-2022
#	1st Assignment
#
# 	Pseudocode by MARIA TOGANTZH (mst@aueb.gr)
#
# 	MIPS Code by ΜΑΡΙΑ ΚΟΝΤΑΡΑΤΟΥ(p3200078@aueb.gr/3200078) 
# 	(Please note your name, e-mail and student id number)


	.text
	.globl main	

# ------------------- Read and Validate Data ------------------------------

main:	  		 		
	li $t0,4						# counter = 4
									
loop: 
	beqz $t0,exit_loop		 		# while counter != 0 do 
	
	li $v0,4								 
	la $a0,	newline	
	syscall
	
	li $v0, 4								
	la $a0, give_char
    syscall							# Print for user: Give character
     								
	li $v0,12                		
	syscall  						# Read hex character in $v0
						
	
check_letter:						

	bgt $v0,70,exit_on_error		# 	if character is not ('0'..'9') and is not ('A'..'F') then
	blt	$v0,65,check_digits			# (kanoume is (0..9) kai (A..F) gia short - circuting) 
	j isHex							# 			goto exit_on_error
																
check_digits:						# 		else 				
	bgt $v0,57,exit_on_error		# 			goto isHex	
	blt $v0,48,exit_on_error
										
isHex: 
	sll $t1,$t1,8					# 	shift left $t1
	or $t1,$v0,$t1					# 	pack $v0 to $t1 
	addi $t0,$t0,-1 				# 	counter = counter - 1
									
	j loop							# goto loop
		
# ------------------- Calculate Decimal Number -----------------------------		

exit_loop:	
	li $v0,4								 
	la $a0,	newline	
	syscall							#print '\n'
									
	li $t4,0						# result = 0
									
	li $t0,4						# counter = 4
									
	li $t3,1 						# power = 1
								 								
	li $s1,255						# $s1 = 255 (mask = 11111111)
	

loop2:	
	beqz $t0,exit_loop2				# while counter != 0 do
								 	
	and $t2,$t1,$s1					# 	$t2 =  least significant byte from $t1 (unpack)
	srl $t1,$t1,8					# 	shift right $t1 


	blt $t2,65, else1				# 	if $t2 is letter A..F then (error if lower than A,greater than F)
    bgt $t2,70, else1				#		$t2 = $t2 - 55
    addi $t2,$t2,-55				# 	else 
	j ADD							#		$t2 = $t2 - 48			

else1: 
	addi $t2,$t2,-48

ADD:		
	mul $t2,$t2,$t3					# 	$t2 = $t2 * power
	sll $t3,$t3,4					# 	power = power * 16
	addi $t0,$t0,-1					# 	counter = counter - 1
	add $t4,$t4,$t2					# 	result = result + $t2
									
	j loop2							# goto loop2


# ------------------- Print Results ------------------------------------		

exit_loop2:

	move $a0,$t4
	li $v0,1
	syscall							# print result 
																		
	j exit							# goto exit
									
exit_on_error:

	li $v0,4								 
	la $a0,	newline	
	syscall							# print '\n'
									
	la $a0,error
	li $v0,4
	syscall							# print error message
									
									
									
exit:								
	li $v0,4								 
	la $a0,	newline	
	syscall							# print '\n'
									
												
	li $v0,10
	syscall							# exit
										

	.data
	
error: .asciiz "Wrong Hex Number ..." 
give_char: .asciiz "Give a character: "
newline: .asciiz "\n"
