#	Computer Systems Organization
#	Winter Semester 2021-2022
#	3rd Assignment
#
# 	MIPS Code by MARIA KONTARATOU(p3200078@aueb.gr/3200078) and 
#				GEORGIOS KOUMOUNDOUROS(p3200083@aueb/3200083)

.text
.globl main
 
#main()
#	int s0=0; 
#	int s1=head;
#
#	while(true)
#		print(\nMenu:\n1. Insert an integer \n2. Remove an integer\n3. Print list (ascending order)\n4. Exit\n\n);
#		int s2=userinput();
#		if(s2==1) 
#			insert();
#		else if(s2==2)
#			remove();
#		else if(s2==3)
#			ascending();
#		else
#			exit();
#	
#

main:
		
	li $s0,0 						#$s0= no of nodes
	li $s1,0 						#$s1=ptr to head of list
	
print_menu:	
	
	la $a0,menuSTR
	li $v0,4
	syscall
	
	
	li $v0,5						#read input for menu
	syscall
	move $s2,$v0 					#store user's input
	
	bne $s2,1,next0					#input=1, go to insert function
	jal insert

next0:

	bne $s2,2,next1					#input=2, go to remove function
	jal remove
	
next1:


	bne $s2,3,next2					#input=3, go to ascending function
	jal ascending

	bne $s0,0, not_empty 			#if list is empty, print message
	la $a0,emptyList
	li $v0,4
	syscall
	
	j print_menu
	
not_empty:
	
	
next2:

	beq $s2,4,exit 				#input=4, exit program
	j print_menu
	
	


# insert(){
# 	int node[2]=new int[2]; 
#	user input=node[0];
# 	
# 	if (s0==0)
#		// insert at head, list is empty
# 		node[1] = s1; 
# 		s1 = &node[1] 
# 		s0++;
# 	
# 	int t0 = s1; 
#	int t1 = &node[1]; 
# 	int t2 = *t0; 
#
#	while(true)
# 		if (t2 == null) 
#			// insert at the end:
#	 		t0 = &t1;
#	 		t1 = null;
#	 		s0++;
#  		
#  		//insert t1 between t0 and t2
#  		if(data of t1 < data of t2)  
#			// swap
#			t1 = &t2;
#   		t0 = &t1; 
#			s0++
#			
# 
#		t0 = *(t0);
#		t2 = *(t2);
#	
#
#t0=node smaller than t1
#t1=new node
#t2=node greater than t1
#


insert:
		
	li $a0,8 						#space for 2 int
	li $v0,9
	syscall
	
	move $t1,$v0 					#t1=ptr to new space
	

	la $a0,userINT
	li $v0,4
	syscall
	
	li $v0,5 						#read user input and store
	syscall
	sw $v0,($t1)
	
	
	la $t1,4($t1) 					#t1 compatible to t0,t2  
									#t1 = ptr of t1 and -4(t1)=data of t1
	

	beqz $s0,insert_at_head			#if empty_list, we insert_at_head

	lw $t3,-4($t1)					#if n(t1)<head n(s1) we insert_at_head
	lw $t4,-4($s1)
	blt $t3,$t4,insert_at_head

	move $t0,$s1 					# t0=head node
	lw $t2,($t0) 					# t2=t0.next=second node
	

sort_loop:
	
	beqz $t2,insert_at_end 			# if t2 = zero, insert t1 at the end of list
	
	
	lw $t3,-4($t1)					#if current node(t1) < t2 insert it between t0 and t2
	lw $t4,-4($t2)
	blt $t3,$t4,swap
	
	lw $t0,($t0) 					# next node
	lw $t2,($t2) 					# next node
	
	j sort_loop 				
	
insert_at_head:	
	sw $s1,($t1) 					# t1 pointer -> head. If list is empty t1 pointer -> zero
	la $s1,($t1) 					# head pointer -> t1
	addi $s0,$s0, 1 				# noNodes++
	jr $ra

	
insert_at_end:	
	sw $t1,($t0) 					# previous last node pointer -> t1
	sw $zero,($t1) 					# t1 pointer -> zero
	addi $s0, $s0, 1 				# increase number of current nodes
	jr $ra
	
swap:	
	sw $t2,($t1) 					# t1 pointer -> t2
	sw $t1,($t0) 					# t0 pointer -> t1
	addi $s0, $s0, 1 				# increase number of current nodes
	jr $ra






# remove(){
#	if (s0 == 0)
#		print(emptyList)
#		
#	print(removeINT)
#	int t0=user's input
# 
#	int t1 = s1  //t1=head
#	int t2 = *t1 // t2 = second element.
#
#	if (data of t1 == t0)
#		// remove first node.
#		s1 = *s1 
#		s0--;
#		print(removeSuc)
#		
#	
#	while(true)
#		if (t2 == null)
#			print(notFound)
#		
#		if(data of t2 == t0)
#			// remove element
#			*t1 = *t2; 
#			s0--;
#			print(removeSuc)
#				
#		t1 = *(t1);
#		t2 = *(t2);
#	
#t0=int to remove
#t1=node prior to iterator
#t2=iterator from list


remove:
	bne $s0,0,not_empty_for_remove	#check if list is empty
	la $a0,emptyList
	li $v0,4
	syscall
	
	jr $ra

not_empty_for_remove:

	la $a0,removeINT
	li $v0,4
	syscall 
	
	
	li $v0,5						#read user's input
	syscall
	move $t0, $v0 					# t0 = user input to remove
	
	move $t1,$s1 					# t1 = head node of list
	lw $t2,($t1) 					# t2 = second node of the list
	
	
	lw $t3,-4($t1)					# if t1 == t0 remove first element
	beq $t0,$t3, remove_first

search_loop:
	
	beqz $t2,not_found 				# if t2 = zero, then search finished unsuccessfully
	lw $t3,-4($t2)
	beq $t3,$t0,remove_element 		# if current node = t0, remove this node
	
	lw $t1,($t1)  					# next node
	lw $t2,($t2)  					# next node

	j search_loop

remove_element:

	la $a0,removeSuc
	li $v0,4
	syscall

	lw $t3,($t2)
	sw $t3,($t1) 					# t1 pointer = t2 pointer(so t2 has deleted)
	addi $s0,$s0,-1 				# noNodes--
	
	jr $ra 
	
remove_first:
	lw $s1,($s1) 					# s1 pointer -> second node(or zero if list contains only one element)
	addi $s0,$s0,-1 				# decrease number of current nodes. 
	
	
	la $a0,removeSuc
	li $v0,4
	syscall
	
	jr $ra 							
	
not_found:

	la $a0,notFound
	li $v0,4
	syscall
	
	jr $ra 							
	


#ascending(){
#
#	if(s0==0)
#		print(empty_list)
#	
#	while(t0 != null)
#		print(node + " ")
#
#	t0=iterator of list

ascending:
		
	move $t0, $s1 					#$t0 is an iterator for list
	
	
	bne $s0, 0, print_loop			#empty list
	la $a0,emptyList
	li $v0, 4
	syscall

	jr $ra 
	
print_loop:
		
	beqz $t0,return_from_print 		# if ptr is 0 then the current node is the last one and iteration should stop
	
	lw $a0,-4($t0)					#print node
	li $v0,1
	syscall
	
	
	la $a0,blank					#print space
	li $v0,4
	syscall
	
	lw $t0,($t0) 					# next node
	
	j print_loop 

return_from_print:
	jr $ra 
	




exit:
	la $a0,exitSTR
	li $v0,4
	syscall
	
	li $v0,10
	syscall




	.data
menuSTR: 			.asciiz "\nMenu:\n1. Insert an integer \n2. Remove an integer\n3. Print list (ascending order)\n4. Exit\n\n"
userINT: 			.asciiz "\nEnter the integer you want to insert to the list\n\n"
emptyList: 			.asciiz "\nList is empty."
blank: 				.asciiz "  "
removeINT: 			.asciiz "\nEnter the integer you want to remove from the list\n\n"
notFound: 			.asciiz "\nInteger does not exist"
removeSuc: 			.asciiz "\nYou removed an element"
exitSTR: 			.asciiz "\n\nProgram finished"