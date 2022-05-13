#####################################################################################
# Assignment #: 6
# Name: Munachimso Aneke
# ASU email: msaneke@asu.edu
# Course: CSE230, TTh 1:30pm
# Description: Reading, printing, and manipulating arrays with functions.
#####################################################################################


#data declarations: declare variable names used in program, storage allocated in RAM
                        .data 
numbers1:       .word   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 	# array1
numbers2:       .word	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0	# array2
prompt1:	.asciiz	"Enter an integer:\n"  		  	# first prompt
prompt2: 	.asciiz "Enter another integer:\n"		# second prompt
prompt3:	.asciiz	"Enter 12 integers.\n"			# third prompt (in readArray function)
print:		.asciiz	"Array Content:\n"			# print statement
result:		.asciiz	"The number of changed items is "  	# function1 result statement
maxchange:	.asciiz	"The maximum number of changed items is " # max change statement
colon:		.asciiz	":\n"					# colon with newline
newline:	.asciiz "\n"					# newline



#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main


# the program begins execution at main()
main:
	# initialize parameters
	li		$a3, 12			# load arraysize
	la		$a1, numbers1		# load base address of numbers1
	la		$a2, numbers2		# load base address of numbers2
	li 		$t4, 0			# count2 = 0

	# collect user input1
	la 		$a0, prompt1		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$s3, $v0		# store input in $s3

	# collect user input2
	la 		$a0, prompt2		# $a0 = address of prompt2
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$s4, $v0		# store input in $s4

	addi		$sp, $sp, -4		# move stack pointer
	sw		$ra, 0($sp)		# store return address
	
	jal 		readArray		# jump to readArray

	# values to be passed into function1 
	move		$t5, $s3		# $t5 = x
	move		$t6, $s4		# $t6 = y
	jal		function1		# jump to function1		
	
	# if (count > count2) is false, branch
	ble		$v1, $t4, Skip		# branch to Skip
	move		$t4, $v1		# count2 = count

Skip:
	jal		printArray		# jump to printArray

	# values to be passed into function1 
	move		$t5, $s4		# $t5 = y
	move		$t6, $s3		# $t6 = x
	jal		function1		# jump to function1

	# if (count > count2) is false, branch
	ble		$v1, $t4, Skip2		# branch to Skip
	move		$t4, $v1		# count2 = count

Skip2:	
	jal		printArray		# jump to printArray

	# values to be passed into function1 
	move		$t5, $s3		# $t5 = x
	move		$t6, $s3		# $t6 = x
	jal		function1		# jump to function1

	# if (count > count2) is false, branch
	ble		$v1, $t4, Skip3		# branch to Skip
	move		$t4, $v1		# count2 = count

Skip3:	
	jal		printArray		# jump to printArray

	# values to be passed into function1 
	move		$t5, $s4		# $t5 = y
	move		$t6, $s4		# $t6 = y
	jal		function1		# jump to function1

	# if (count > count2) is false, branch
	ble		$v1, $t4, Skip4		# branch to Skip
	move		$t4, $v1		# count2 = count

Skip4:
	jal		printArray		# jump to printArray
	
	la 		$a0, maxchange		# $a0 = address of maxchange
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	
	move 		$a0, $t4		# $a0 = $t4
	li		$v0, 1			# $v0 = 4 --- to call print_int()
	syscall					# print_int()

	la		$a0, colon		# $a0 = address of colon
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall	
	
	lw 		$ra, 0($sp) 		# lw return address
	addi 		$sp, $sp, 4		# return stack pointer

	jr		$ra			# return




############################################################################
# Procedure/Function readArray
# Description: Reads integers from user input and store them in the array
# parameters: $a1 = base address of array1 , $a3 = length
# return value: N/A
# registers to be used: $t0, $t1, $s0, and $s1 will be used.
############################################################################
readArray: 
	li		$t0, 0			# intialize loop counter, i = 0

	la 		$a0, prompt3		# $a0 = address of prompt3
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
Loop:
	bge		$t0, $a3, endRead	# if $t0 >= $a3 (if i < arraysize is false) branch
	sll		$t1, $t0, 2		# $t2 = i * 4
	add		$s1, $a1, $t1		# $s1 = base addr + (i*4) = current addr

	# store user input
	la 		$a0, prompt1		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall
	li		$v0, 5			# $v0 = 5 --- to call read_int()
	syscall					# read_int()
	move		$s0, $v0		# store input in $s0
	sw		$s0, 0($s1)		# numbers1[i] = $s0 

	# update & loop
	addi		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop			# go back to Loop

endRead:
	jr 		$ra			# return
	
	
		
		

############################################################################
# Procedure/Function printArray
# Description: prints out the integers in an array
# parameters: $a2 = base address of array2, $a3 = length
# return value: N/A
# registers to be used: $t0, $t1, $s0, and $s2 will be used.
############################################################################
printArray: 
	li		$t0, 0			# intialize loop counter, i = 0
	
	la 		$a0, print		# $a0 = address of print
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall

Loop2:
	bge		$t0, $a3, endPrint	# if $t0 >= $a3 (if i < arraysize is false) branch
	sll		$t1, $t0, 2		# $t2 = i * 4
	add		$s2, $a2, $t1		# $s2 = base addr + (i*4) = current addr

	# print value numbers[i]
	lw		$s0, 0($s2)		# $s0 = numbers1[i] 
	move		$a0, $s0
	li		$v0, 1			# $v0 = 1 --- to call print_int()
	syscall					# print_int()

	la 		$a0, newline		# $a0 = address of prompt1
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall

	# update & loop
	addi		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop2			# go back to Loop

endPrint:
	jr 		$ra			# return
	
	


############################################################################
# Procedure/Function function1
# Description: Modifies and array and returns the number of items changed
# parameters: $a1 = address of array1 , $a2 = addres of array2, $a3 = length,
#		$t5 = integer 1, $t6 = integer 2 
# return value: $v1 = count
# registers to be used: $t0, $t1, $s1 and $s2 will be used.
############################################################################
function1:
	li		$v1, 0			# $v1 = 0 (initialize count = 0)
	li		$t0, 0			# $t0 = 0 (Initialize loop counter)

Loop3:	
	bge		$t0, $a3, endFunction	# if $t0 >= $a3 (if i < arraysize is false) branch
	sll		$t1, $t0, 2		# $t2 = i * 4
	add		$s1, $a1, $t1		# $s2 = base addr + (i*4) = current addr
	add		$s2, $a2, $t1		# $s2 = base addr + (i*4) = current addr

	lw		$t2, 0($s1)		# $t2 = numbers1[i]

	# if (numbers1[i] < a)
	bge 		$t2, $t5, Else		# if $t2 >= $s5 (if numbers1[i] < a is false) branch
	sub		$t3, $t2, $t6		# numbers2[i] = numbers1[i] - b
	sw		$t3, 0($s2)		# numbers2[i] = $t3	
	addi		$v1, $v1, 1		# increment $v1 (count = count + 1)

	# update & loop
	addi		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop3			# go back to Loop


Else:
	# else
	move		$t3, $t2		
	sw		$t3, 0($s2)		# numbers2[i] = $t3

	# update & loop
	addi		$t0, $t0, 1 		# update loop counter, $t0 = $t0 + 1
	j		Loop3			# go back to Loop

	
endFunction:
	# print result for function1
	la		$a0, result		# $a0 = address of result
	li		$v0, 4			# $v0 = 4 --- to call print_int()
	syscall					# print_int()

	move 		$a0, $v1		# $a0 = $v1
	li		$v0, 1			# $v0 = 4 --- to call print_int()
	syscall					# print_int()

	la		$a0, colon		# $a0 = address of colon
	li		$v0, 4			# $v0 = 4 --- to call print_string()
	syscall					# print_string()

	
	jr		$ra			# return






# Register Tracking
# $a1 - base address of array1
# $a2 - base address of array2
# $a3 - size of array

# $v1 - function1 result (count)

# $s0 - user input (num)
# $s1 - current address of numbers1
# $s2 - current address of numbers2
# $s3 - integer 1 (original)
# $s4 - integer 2 (original)

# $t0 - loop counter
# $t1 - address incrementer (i << 2)
# $t2 - value of numbers1[]
# $t3 - value of numbers2[]
# $t4 - count2
# $t5 - integer 1(passed into function1)
# $t6 - integer 2 (passed into function1)
 








