#####################################################################################
# Assignment #: 3
# Name: Munachimso Aneke
# ASU email: msaneke@asu.edu
# Course: CSE230, TTh 1:30pm
# Description: This program collects integer data from a user
#			and performs arithmetic calculation on the input
#####################################################################################

#data declarations: declare variable names used in program, storage allocated in RAM
                            .data 
prompt1:		.asciiz "Enter a value:\n"		# prompts user for num1
prompt2:		.asciiz "Enter another value:\n"	# prompts user for num2
prompt3:		.asciiz "Enter one more value:\n"	# prompts user for num3
prompt4:		.asciiz "Enter one more value:\n"	# prompts user for num4
sum:			.asciiz "\nnum2+num4=" 			# ans1 statement
diff:			.asciiz "\nnum4-num1="			# ans2 statement
multiply:		.asciiz "\nnum2*num3="			# ans3 statement
divide:			.asciiz "\nnum1/num4="			# ans4 statement
remain:			.asciiz "\nnum4 mod num3="		# ans5 statement
combo:			.asciiz "\n((num3/num2)-7)*(num4 mod num1)=" 	# ans6 statement


#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main

# the program begins execution at main()
main:
	# collect user input
	la 		$a0, prompt1	# $a0 = address of prompt1
        li          	$v0, 4       	# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	li		$v0, 5		# $v0 = 5  --- this is to call read_int()
	syscall				# read integer
	move 		$t0, $v0	# store num1
	
	la          	$a0, prompt2	# $a0 = address of prompt2
        li          	$v0, 4       	# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	li		$v0, 5		# $v0 = 5  --- this is to call read_int()
	syscall				# read integer
	move 		$t1, $v0	# store num2

	la          	$a0, prompt3	# $a0 = address of prompt3
        li          	$v0, 4       	# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	li		$v0, 5		# $v0 = 5  --- this is to call read_int()
	syscall				# read integer
	move 		$t2, $v0	# store num3

	la          	$a0, prompt4	# $a0 = address of prompt4
        li          	$v0, 4       	# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	li		$v0, 5		# $v0 = 5  --- this is to call read_int()
	syscall				# read integer
	move 		$t3, $v0	# store num4


	# addition "num2 + num4"
	la          	$a0, sum	# $a0 = address of sum
        li          	$v0, 4       	# $v0 = 4  --- this is to call print_string()
	syscall
	add		$t4, $t1, $t3   # $t4 = $t1 + $t3
 	move		$a0, $t4     	# $a0 = $t4
	li 		$v0, 1	     	# $v0 = 1  --- this is to call print_int()
	syscall                  	# call print_string()
	 
	
	# subtraction "num4 - num1"
	la		$a0, diff	# $a0 = address of diff
	li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	sub		$t5, $t3, $t0 	# $t5 = $t3 - $t0
	move 		$a0, $t5	# $a0 = $t5
	li		$v0, 1		# $v0 = 1  --- this is to call print_int()
	syscall                  	# call print_string()


	# multiplication "num2 * num3"
	la		$a0, multiply	# $a0 = address of multiply
	li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	mult		$t1, $t2 	# $t1 * $t2
	mflo 	 	$t6		# $t6 = $t1 * $t2
	move 		$a0, $t6	# $a0 = $t6
	li		$v0, 1		# $v0 = 1  --- this is to call print_int()
	syscall                  	# call print_string()


	# division "num1 / num4"
	la		$a0, divide	# $a0 = address of divide
	li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	div		$t0, $t3 	# $t0 / $t4
	mflo 	 	$t7		# $t7 = $t0 / $t4
	move 		$a0, $t7	# $a0 = $t7
	li		$v0, 1		# $v0 = 1  --- this is to call print_int()
	syscall                  	# call print_string()


	# remainder of division "num4 % num3"
	la		$a0, remain	# $a0 = address of remain
	li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	syscall                  	# call print_string()
	div		$t3, $t2 	# $t3 % $t2
	mfhi 	 	$t8		# $t8 = $t3 % $t2
	move 		$a0, $t8	# $a0 = $t8
	li		$v0, 1		# $v0 = 1  --- this is to call print_int()
	syscall
	

	# combo operation "((num3 / num2) - 7) * (num4 % num1)"
	la		$a0, combo	# $a0 = address of combo
	li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	syscall
	
	div		$t2, $t1 	# $t2 / $t1         (step 1- num3/num2)
	mflo 	 	$t6		# $t6 = $t0 / $t4  
	
	addi		$t7, $t6, -7 	# $t7 = $t6 - 7	    (step 2- step -7)
	
	div		$t3, $t0 	# $t3 % $t0	    (step 3- num4 % num1)
	mfhi 	 	$t8		# $t8 = $t3 % $t2
	
	mult		$t7, $t8 	# $t7 * $t8	    (step 4- step2 * step3)
	mflo 	 	$t9		# $t9 = $t7 * $t8

	move 		$a0, $t9	# $a0 = $t9
	li		$v0, 1		# $v0 = 1  --- this is to call print_int()
	syscall                  	# call print_string()


	jr		$ra		# return

