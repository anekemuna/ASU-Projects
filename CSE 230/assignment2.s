###########################################################
# Assignment #: 2
#  Name: Munachimso Aneke
#  ASU email: msaneke@asu.edu
#  Course: CSE230, TTh 1:30pm
#  Description: This program displays the sum and the
#				difference of 2 integers
###########################################################

#data declarations: declare variable names used in program, storage allocated in RAM
                            .data  
num1:		.word 69482 		# create an integer
num2:		.word 0xBC7 		# create hex number
dnum1:		.asciiz "num1 is: "     # display statement for num1
dnum2:		.asciiz "num2 is: "     # display statement for num2
sum:		.asciiz "num1+num2 = "  # sum statement
diff:		.asciiz "num1-num2 = "  # difference statement
newline:	.asciiz "\n"     	# print a newline


#program code is contained below under .text
                        .text
                        .globl    main    #define a global function main

# the program begins execution at main()
main:
	    la 		$t0, num1       # $t0 = address of num1
	    lw		$t1, 0($t0)	# $t1 = 69482
	    la 		$t0, num2	# $t0 = address of num2
	    lw		$t2, 0($t0)    	# $t2 = 0xBC7

	    # print first statement "num1 is: XXX"
            la          $a0, dnum1   	# $a0 = address of dnum1
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall                  	# call print_string()
	    move	$a0, $t1     	# $a0 = 69482
	    li 		$v0, 1	     	# $v0 = 1  --- this is to call print_int()
	    syscall                  	# call print_string()
	    la          $a0, newline 	# $a0 = address of newline
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall                  	# call print_string()

 	    # print second statement "num2 is: XXX"
            la          $a0, dnum2   	# $a0 = address of dnum2
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall                  	# call print_string()
	    move	$a0, $t2     	# $a0 = 0xBC7
	    li 		$v0, 1	     	# $v0 = 1  --- this is to call print_int()
	    syscall                  	# call print_string()
	    la          $a0, newline 	# $a0 = address of newline
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall 

	    # addition of num1 & num2
	    la		$a0, sum	# $a0 = address of sum
	    li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	    syscall                  	# call print_string()
	    add		$t3, $t1, $t2   # $t3 = $t1 + $t2
	    move	$a0, $t3     	# $a0 = $t1 + $t2
	    li 		$v0, 1	     	# $v0 = 1  --- this is to call print_int()
	    syscall                  	# call print_string()
	    la          $a0, newline 	# $a0 = address of newline
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall 

            # difference of num1 & num2
	    la		$a0, diff	# $a0 = address of diff
	    li 		$v0, 4		# $v0 = 4  --- this is to call print_string()
	    syscall                  	# call print_string()
	    sub		$t4, $t1, $t2   # $t4 = $t1 - $t2
	    move	$a0, $t4     	# $a0 = $t1 - $t2
	    li 		$v0, 1	     	# $v0 = 1  --- this is to call print_int()
	    syscall                  	# call print_string()
	    la          $a0, newline 	# $a0 = address of newline
            li          $v0, 4       	# $v0 = 4  --- this is to call print_string()
	    syscall 

            jr          $ra           	# return
           