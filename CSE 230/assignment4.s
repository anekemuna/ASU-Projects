#####################################################################################
#  Assignment #: 4
#  Name: Munachimso Aneke
#  ASU email: msaneke@asu.edu
#  Course: CSE230, TTh 1:30pm
#  Description: This program computes a customers total payment 
#			for a T-shirt purchase.
#####################################################################################

#data declarations: declare variable names used in program, storage allocated in RAM
			    .data
prompt1:		.asciiz "How many T-shirts would you like to order?\n"		# first prompt
prompt2:		.asciiz "\nDo you have a discount coupon? Enter 1 for yes.(any other integer will indicate no discount)\n"	# second prompt
Error:			.asciiz "\nInvalid Number of T-shirts.\n"			# error message
result:			.asciiz "Your total payment is $"				# result statement


#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main

# the program begins execution at main()
main:
	# collect number of t-shirts (howMany)
	la		$a0, prompt1		# $a0 = address of prompt1
	li		$v0, 4 			# $v0 = 4  --- this is to call print_string()
	syscall					# call print_string()
	li		$v0, 5			# $v0 = 5  --- this is to call read_int()
	syscall					# read integer
	move 		$t0, $v0		# store howMany (no of t-shirts)


	ble		$t0, $zero, Exit	# if $t0 <= 0, end program

	# if howMany < 50
	slt 		$t2, $t0, 50		# if $t0 < 50, $t2 = 1
	beq 		$t2, $zero, Case2	# if $t2 = 0, check second condition
	li		$t4, 7			# $t4 = 7, price of shirts btw 1 - 49
	mult		$t0, $t4		# $t0 * 7
	mflo		$t3			# $t3 = $t0 * 7

	j		Discount		# jump to Discount
	
Case2:	
	# if howMany < 100 && howMany >= 50
	slt		$t2, $t0, 100		# if $t0 < 100, $t2 = 1
	beq		$t2, $zero, Case3	# if $t2 = 0, check third condition
	sge		$t2, $t0, 50		# if $t0 < 50, $t2 = 1
	beq 		$t2, $zero, Case3	# if $t2 = 0, check third condition
	li		$t4, 6			# $t4 = 6, price of shirts btw 50 - 99
	mult		$t0, $t4		# $t0 * 6
	mflo		$t3			# $t3 = $t0 * 6

	j		Discount		# jump to Discount

Case3: 
	# if howMany >= 100
	li		$t4, 5			# $t4 = 5, price of shirts 100 or more
	mult		$t0, $t4		# $t0 * 5
	mflo		$t3			# $t3 = $t0 * 5

	j		Discount		# jump to Discount


Discount:
	# collect discount input
	la		$a0, prompt2		# $a0 = address of prompt2
	li		$v0, 4 			# $v0 = 4  --- this is to call print_string()
	syscall					# call print_string()
	li		$v0, 5			# $v0 = 5  --- this is to call read_int()
	syscall					# read integer
	move 		$t1, $v0		# store discount
	
	li 		$t5, 1			# $t5 = 1
	
	bne		$t1, $t5, Result	# branch if $t1 != 1
	addi		$t3, $t3, -5		# calculate discount	

	j		Result			# jump to result

 

Exit:
	# end program for invalid 
	la		$a0, Error		# $a0 = address of Error
	li		$v0, 4 			# $v0 = 4  --- this is to call print_string()
	syscall					# call print_string()
	
	jr 		$ra			# return

Result: 
	# end program
	la		$a0, result		# $a0 = address of result
	li		$v0, 4 			# $v0 = 4  --- this is to call print_string()
	syscall	
	move		$a0, $t3		# $a0 = $t3
	li 		$v0, 1			# $v0 = 4  --- this is to call print_int()
	syscall					# print_int()
	jr 		$ra			# return


# register tracking
# $t0 = howMany
# $t1 = discount
# $t2 = condition checker
# $t3 = payment
# $t4 = price
# $t5 = 1 (for discount)
