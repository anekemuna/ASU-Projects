#####################################################################################
# Assignment #: 7
# Name: Munachimso Aneke
# ASU email: msaneke@asu.edu
# Course: CSE230, TTh 1:30pm
# Description: Manipulating a users input using a recursive function.
#####################################################################################


#data declarations: declare variable names used in program, storage allocated in RAM
                        .data 
prompt:		.asciiz "Enter an integer:\n"		# input prompt
result: 	.asciiz "The solution is: "		# result statement



#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main


# the program begins execution at main()
main:
	# Collect user input
	la		$a0, prompt		# $a0 = address of prompt
	li 		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# print_string()

	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$a1, $v0		# store input in $a1
	

	# store current return address
	addi 		$sp, $sp, -4
	sw		$ra, 0($sp)		# store current address
	
	# call recursive function
	jal		function1
	
	# print result
	la		$a0, result		# $a0 = address of result
	li 		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# print_string()

	move		$a0, $v1		# $a0 = $v1 (result)
	li 		$v0, 1			# $v0 = 4 --- to call print_int()
	syscall					# print_int()
	
	# return stored address
	lw		$ra, 0($sp)
	addi		$sp, $sp, 4
	
	jr		$ra			# return



############################################################################
# Procedure/Function function1
# Description: recursive function tha manipulates the users input.
# parameters: $a1 = n value
# return value: $v1 = computed value
# registers to be used: $s0, $s1, $s3, and $ will be used.
############################################################################
function1:
	# loading integers into registers
	li		$s0, 3			# store 3 in $s0
	li		$s1, 4			# store 4 in $s1
	li		$s2, 5			# store 5 in $s2
	li		$s3, 6			# store 6 in $s3

	# base case
	bgt		$a1, $s2, Recursive	# branch if false
	div		$a1, $s0
	mfhi		$v1			# n % 3
	addi		$v1, $v1, 5		# n + 5 ($v1 = ($v1%3)+5)
	
	jr		$ra			# return


Recursive:
	# store values of the $a1 & $ra
	addi		$sp, $sp, -12		# move stack pointer (for 3 registers)
	sw		$ra, 0($sp)		# store return address
	sw		$a1, 4($sp)		# store $a1
	
	sub		$a1, $a1, $s0		# n-3
	jal		function1		# call function (n-3)	
	lw		$a1, 4($sp)		# return the original value of n
	div		$v1, $a1		# function(n-3)/3
	mflo		$v1			# $v1 = function(n-3)/3
	sw		$v1, 8($sp)		# store result

	sub		$a1, $a1, $s1		# n-4
	jal		function1		# call function (n-4)
	mul		$v1, $v1, $s3		# $v1 = function(n-4)*6
	
	lw		$t0, 8($sp)		# load result of function(n-3)/3
	add		$v1, $v1, $t0		# (function(n-3)/3) + (function(n-4)*6)

	lw		$a1, 4($sp)		# return the original value of n
	sub		$v1, $v1, $a1		# (function(n-3)/3) + (function(n-4)*6) - n

	lw		$ra, 0($sp)		# load return address
	addi		$sp, $sp, 12		# move stack pointer back
	
	jr		$ra			# return
	




# Register Tracking
# $a1 - n value
# $v1 - result
# $s0 - 3
# $s1 - 4
# $s2 - 5
# $s3 - 6
# $t0 - function1(n-3)/n


