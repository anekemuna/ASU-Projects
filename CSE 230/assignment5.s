#####################################################################################
# Assignment #: 5
# Name: Munachimso Aneke
# ASU email: msaneke@asu.edu
# Course: CSE230, TTh 1:30pm
# Description: Updating the content of an array based on defined rules
#####################################################################################


#data declarations: declare variable names used in program, storage allocated in RAM
                        .data 
numbers_len:    .word   12		# number of elements in the array
numbers:        .word   -4, 23, 15, -26, 27, 8, -21, 31, 15, -17, 11, -7  # array
prompt1:	.asciiz	"Enter an integer:\n"  		# first prompt
prompt2: 	.asciiz "Enter another integer:\n"	# second prompt
result:		.asciiz	"Result Array Content:\n"	# third prompt
newline:	.asciiz "\n"				# newline


#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main


# the program begins execution at main()
main:
	# store first integer
	la 		$a0, prompt1		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# call print_string()
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$s0, $v0		# store first integer in $s0

	# store second integer
	la 		$a0, prompt2		# $a0 = address of prompt2
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# call print_string()
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$s1, $v0		# store second integer in $s1

	# store number_len
	la		$t0, numbers_len	# $t0 = address of numbers_len
	lw 		$s2, 0($t0)		# $s2 = 12

	# store base address of array (numbers)
	la		$s3, numbers		# $s3 = base address of array numbers

	# i = 0
	li		$t0, 0			# initialize loop control variable
	
Loop:	
	# 1. Check if i < numbers_len
	slt		$t1, $t0, $s2		# if $t0 < $s2 -> $t1 = 1, else $t1 = 0
	beq 		$t1, $zero, Result	#  if $t0 == 0, go to Result

	# 2. Load numbers[i]
	sll 		$t2, $t0, 2		# $t2 = i * 4
	add		$t3, $s3, $t2		# $t3 = base addr + (i*4) = current addr
	lw		$t4, 0($t3)		# $t4 = numbers[i]

	# 3. if (numbers[i]/ num1 <3)
	div		$t4, $s0		# $t4 / $s0 
	mflo		$t5			# $t5 = $t4 / $s0 
	
	slti		$t1, $t5, 3		# if $t5 < 3 -> $t1 = 1, else $t1 = 0
	beq		$t1, $zero, Skip	#  if $t0 == 1, go to Skip
	
	# 4. if true, numbers[i] = numbers[i] % 2
	div		$t4, $s1		# $t4 / $s1
	mfhi 		$t6 			# $t6 = $t4 % $s0 
	sw 		$t6, 0($t3)		# numbers[i] = $t6

Skip:
	# 5. Update Counter
	addi 		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	
	# 6. Loop
	j		Loop			# go back loop beginning

	
Result:	
	# print result display statement
	la 		$a0, result		# $a0 = address of result
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# call print_string()
	
	# i = 0
	li		$t0, 0			# initialize loop control variable

Loop2: 
	# 1. Check if i < numbers_len
	slt		$t1, $t0, $s2		# if $t0 < $s2 -> $t1 = 1, else $t1 = 0
	beq 		$t1, $zero, Exit	#  if $t0 == 0, go to Exit


	# 2. Load numbers[i]
	sll 		$t2, $t0, 2		# $t2 = i * 4
	add		$t3, $s3, $t2		# $t3 = base addr + (i*4) = current addr
	lw		$t4, 0($t3)		# $t4 = numbers[i]

	
	# 3. Print numbers[i] + "\n"
	move 		$a0, $t4		# $a0 = $t4
	li		$v0, 1			# $v0 = 1 --- to call print_int()
	syscall					# call print_int()
	la 		$a0, newline		# $a0 = address of newline
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# call print_string()

	# 4. Update Counter
	addi 		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	
	# 5. Loop
	j		Loop2			# go back loop beginning

Exit:
	
	jr 		$ra			# return



# Register Tracking
# $s0 - first integer (num1)
# $s1 - second integer (num2)
# $s2 - no of elements in array (numbers_len)
# $s3 - base address of array (numbers[])

# $t0 - loop counter (1st loop)
# $t1 - condition checker
# $t2 - i << 2 = i *4
# $t3 - base address + (i * 4)
# $t4 - integer at numbers[i]
# $t5 - result of numbers[i]/num1
# $t6 - result of numbers [i] % num2






