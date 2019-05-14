# Homework 4
# @author: Kenny Hoang
# CS3340.501
# Professor Nhut Nguyen
# 10/19/2016
#######################################################################################################
# MIPS assembly program that prompts users for unsigned integer from the keyboard
# and then displays the number of the 1-bit of the unsigned integer

.data
prompt: .asciiz "Please enter an unsigned integer: "
output: .asciiz "The number of 1-bit is "

.text
main: 
	li $v0, 4		# service 4 is for printing string
	la $a0, prompt		# load the string prompt into $a0
	syscall		
	
	li $v0, 5		# service 5 is for reading integer
	syscall
	move $a0, $v0		# move integer input from $v0 to $s0
	
	and $s0, $s0, $0
	jal bitcount		# call subroutine bitcount
	li $v0, 4		# service 4 is for printing string
	la $a0, output		# load the string output into $a0 
	syscall
	
	move $a0, $s0		# move result of bitcount in $s0 to $a0 for output
	li $v0, 1		# service 1 is for printing integer
	move $a0, $s0		# move result of bitcount in $s0 to $a0 for output
	syscall
	j exit			# jump to exit

bitcount:
	andi $t0, $a0, 1	# register $t0 holds whether the least significant bit is set
	srl $a0, $a0, 1		# shift $a0 to the right one bit
	beq $t0, $0, bitcount	# if $t0 is equal to zero, loop back to bitcount
	addi $s0, $s0, 1	# increment $s0(counter) when the bit is set
	bne $a0, $0, bitcount	# if $a0 != 0 continue looping bitcount
	jr $ra
exit:
	li $v0, 10	# service 10 is for exiting the program
	syscall
