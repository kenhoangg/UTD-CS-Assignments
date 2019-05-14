# Homework 4
# @author: Kenny Hoang
# CS3340.501
# Professor Nhut Nguyen
# 10/6/2016
#######################################################################################################
# MIPS assembly program that prompts users for an integer N input from the keyboard
# and then prints out the sum of 1 + 2 + 3 + ..... + N

.data
prompt1: .asciiz "Give an integer number N: "
bye: .asciiz "Goodbye!"
outputit1: .asciiz "The sum of integers up to "
outputit2: .asciiz " (iterative) is: "
outputrec1: .asciiz "The sum of integers up to "
outputrec2: .asciiz " (recursive) is: "

.text
	
main:	
	
start:	
	li $v0, 4
	la $a0, prompt1
	syscall
	
	#Read in N integer
	li $v0, 5
	syscall
	move $s0, $v0 # move integer read from $v0 to temporary register $s0
		      # s0 will hold the N integer
	ble $s0, 1, exit # if $s0 <= 1
	addi $s1, $zero, 1 # set $s1 to 1
	jal iter
	# setting s1 back to original value
	and $s1, $s1, $zero # clear $s1
	addi $s1, $zero, 1 # set $s0 back to 1
	add $s3, $s0, $zero # set $s3 to $s0 for recursive call
	jal rec
	
	and $s0, $s0, $zero # clear $s0 register
	j start
iter:
	add $s2, $s2, $s1 # $s2(sum) = $s2 + $s1(counter) where sum = 1 + 2 + ... + N
	addiu $s1, $s1, 1 # increment $s1
	ble $s1, $s0, iter # if($s1 <= $s0) goto iter
	
	# printing out the resulting message
	la $a0, outputit1
	li $v0, 4
	syscall
	
	move $a0, $s0 # moving N integer in $s0 to $a0 for printing
	li $v0, 1
	syscall
	
	# printing out the resulting message
	la $a0, outputit2
	li $v0, 4
	syscall
	
	# printing out sum of iterative algorithm
	li $v0, 1
	move $a0, $s2
	syscall
	
	# printing newline to separate outputs	
	addi $a0, $0, 10
	addi $v0, $0, 11
	syscall
	
	# clear $s2 for next call
	and $s2, $s2, $0
	jr $ra
rec:		
	# printing out the resulting message
	la $a0, outputrec1
	li $v0, 4
	syscall
	
	move $a0, $s0 # moving N integer in $s0 to $a0 for printing
	li $v0, 1
	syscall
	
	# printing out the resulting message
	la $a0, outputrec2
	li $v0, 4
	syscall
	
	# printing out sum of recursive algorithm
	
	# printing newline to separate outputs	
	addi $a0, $0, 10
	addi $v0, $0, 11
	syscall
	jr $ra
exit:
	#Prints goodbye string
	la $a0, bye
	li $v0, 4
	syscall
	
	li $v0, 10    #syscall to exit
        syscall