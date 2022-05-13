##########################################################################################
# Assignment #: 11
# Name: Munachimso Aneke
# ASU email: msaneke@asu.edu
# Course: CSE230, TTh 1:30pm
# Description: Reading, printing, and manipulating arrays filled with floating point data.
##########################################################################################


#data declarations: declare variable names used in program, storage allocated in RAM
                        .data 
array1:		.float   0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0  # array1
array2:         .float	 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0  # array2
prompt1:	.asciiz	"Specify how many numbers should be stored in the array (at most 12)\n" # first prompt
prompt2: 	.asciiz "Enter a number:\n"			# second prompt
prompt3:	.asciiz	"Please enter a number:\n"		# third prompt
first:          .asciiz "First Array\n" 
print1:		.asciiz	"First Array Content:\n"		# print statement for first array
print2:		.asciiz	"Second Array Content:\n"		# print statement for second array
newline:	.asciiz "\n"					#newline



#program code is contained below under .text
                        .text
                        .globl main #define a global function main


# the program begins execution at main()
main:
	# initialize parameters
	li		$t0, 12			# load arraysize
	la		$s0, array1		# load base address of array1
	la		$s1, array2		# load base address of array2

	# collect input for howMany 
	la 		$a0, prompt1		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$t1, $v0		# store input in $t1

	# print out "First Array"
	la 		$a0, first		# $a0 = address of first
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall	

	# while loop to read elements
	li		$t2, 0			# intialize loop counter, i = 0

Loop: 
	bge     	$t2, $t0, endRead	# if $t2 >= $t0 (if i < arraysize is false) branch
	bge		$t2, $t1, endRead	# if $t2 >= $t1 (if i < howMany is false) branch
	sll		$t3, $t2, 2		# $t3 = i * 4
	add		$s2, $s0, $t3		# $s2 = base addr + (i*4) = current addr

	# prompt and store user for num
	la 		$a0, prompt2		# $a0 = address of prompt2
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	li		$v0, 6			# $v0 = 6 --- to call read_float()
	syscall					# read_float()
	s.s		$f0, 0($s2)		# array1[i] = $s2

	# update  and loop 
	addi		$t2, $t2, 1		# update loop counter, $t2 = $t2 + 1
	j		Loop			# go back to Loop

endRead:
	# print out array
	la 		$a0, print1		# $a0 = address of print1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	addi		$sp, $sp, -4		# move stack pointer
	sw		$ra, 0($sp)		# store return address
	move		$a2, $s0
	jal 		printArray		# jump to printArray
	lw 		$ra, 0($sp) 		# lw return address
	addi 		$sp, $sp, 4		# return stack pointer

	# for loop for function1
	li		$t6, 0			# intialize loop counter, i = 0
	li		$t5, 3			# load $t5 = 3
	
Loop3:
	# print prompt
	bge 		$t6, $t5, endForLoop 	# if $t6 >= $t5 (if i < 3 is false) branch
	la 		$a0, prompt3		# $a0 = address of prompt3
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	
	# read user input (num2)
	li		$v0, 6			# $v0 = 6 --- to call read_float()
	syscall					# read_float()
	mov.s		$f10, $f0		# f10 = $f0
	
	addi		$sp, $sp, -4		# move stack pointer
	sw		$ra, 0($sp)		# store return address
	jal		function1
	lw 		$ra, 0($sp) 		# lw return address
	addi 		$sp, $sp, 4		# return stack pointer

	# print out array
	la 		$a0, print2		# $a0 = address of print2
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	addi		$sp, $sp, -4		# move stack pointer
	sw		$ra, 0($sp)		# store return address
	move		$a2, $s1
	jal 		printArray		# jump to printArray
	lw 		$ra, 0($sp) 		# lw return address
	addi 		$sp, $sp, 4		# return stack pointer
	
	# update & loop
	addi		$t6, $t6, 1 		# update loop counter, $t2 = $t2 + 1
	j		Loop3			# go back to Loop


endForLoop:
	jr		$ra			# return



############################################################################
# Procedure/Function printArray
# Description: prints out the floats in an array
# parameters: $a2 = base address of array, $t0 = arraysize, $t1 = howMany
# return value: N/A
# registers to be used: $t2, $t3, $f12, $s0, and $s2 will be used.
############################################################################
printArray: 
	li		$t2, 0			# intialize loop counter, i = 0
	
Loop2:
	bge     	$t2, $t0, endPrint	# if $t2 >= $t0 (if i < arraysize is false) branch
	bge		$t2, $t1, endPrint	# if $t2 >= $t1 (if i < howMany is false) branch
	sll		$t3, $t2, 2		# $t3 = i * 4
	add		$s2, $a2, $t3		# $s2 = base addr + (i*4) = current addr

	# print value numbers[i]
	l.s		$f12, 0($s2)		# $f0 = array[i] 
	li		$v0, 2			# $v0 = 2 --- to call print_float()
	syscall					# print_float()

	la 		$a0, newline		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall

	# update & loop
	addi		$t2, $t2, 1 		# update loop counter, $t2 = $t2 + 1
	j		Loop2			# go back to Loop

endPrint:
	jr 		$ra			# return
	
	


##################################################################################
# Procedure/Function function1
# Description: Modifies and array and returns the number of items changed
# parameters: $s0 = address of array1 , $s1 = address of array2, $t0 = arraysize
#		$t1 = howMany, $f10 = num1
# return value: N/A
# registers to be used: $f13, $f14, $t2, $t3, $s2 and $s3 will be used.
##################################################################################
function1:
	li		$t2, 0			# intialize loop counter, i = 0

Loop4:	
	bge     	$t2, $t0, endFunction	# if $t2 >= $t0 (if i < arraysize is false) branch
	bge		$t2, $t1, endFunction	# if $t2 >= $t1 (if i < howMany is false) branch
	sll		$t3, $t2, 2		# $t3 = i * 4
	add		$s2, $s0, $t3		# $s2 = base addr1 + (i*4) = current addr
	add		$s3, $s1, $t3		# $s3 = base addr2 + (i*4) = current addr

	l.s		$f13, 0($s2)		# $f13 = array1[i]

	# if array1[i] < num1
	c.lt.s		$f13, $f10		# condition checker if $f13 < $f10 is true, code = 1
	bc1f		Else			# code = 0, branch to Else
	
	add.s		$f14, $f13, $f10	# $f14 = $f13 + $f10		
	s.s		$f14, 0($s3)		# array2[i] = $f14

	# update & loop
	addi		$t2, $t2, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop4			# go back to Loop

Else:
	# else
	mov.s		$f14, $f13		#f14 = $f13		
	s.s		$f14, 0($s3)		# array2[i] = $f14

	# update & loop
	addi		$t2, $t2, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop4			# go back to Loop

endFunction:
	jr		$ra			# return






# Register Tracking

# $a2 - base address to printed

# $s0 - base address of array 1
# $s1 - base address of array 2
# $s2 - current address of array
# $s3 - current address of array 2

# $t0 - 12 (array_size)
# $t1 - num of elements in array (howMany)
# $t2 - loop counter 
# $t3 - i * 4
# $t4 - num
# $t5 - 3 (for loop)
# $t6 - loop counter 2

 








