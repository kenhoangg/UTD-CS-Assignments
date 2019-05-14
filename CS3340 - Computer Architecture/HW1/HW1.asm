# Homework 1
# @author: Kenny Hoang
# CS3340.501
# Professor Nhut Nguyen
# 9/5/2016
#######################################################################################################
# MIPS assembly program that prompts users for two integers input from the keyboard
# and then prints out the sum.

.data
prompt1: .asciiz "Give me an integer number: "
prompt2: .asciiz "Give me another integer number: "
prompt3: .asciiz "The sum of the two inputted numbers is: "

.text
main:
	
	#Prints prompt1 string
	la $a0, prompt1
	li $v0, 4
	syscall
	
	#Read in first integer
	li $v0, 5
	syscall
	move $t0, $v0 # move integer read from $v0 to temporary register $t0
		      # t0 will hold the first integer
	
	#Prints prompt2 string
	la $a0, prompt2
	li $v0, 4
	syscall
	
	#Reads in second integer
	li $v0, 5
	syscall
	move $t1, $v0 # move integer read from $v0 to temporary register $t1
		      # t1 will hold the second integer
	
	# t2 will hold the sum of the two integers inputted by user
	add $t2, $t0, $t1 # adding the two integers in $t0 and $t1 and storing in $t2
	
	# printing out the resulting message and sum
	la $a0, prompt3
	li $v0, 4
	syscall
	
	move $a0, $t2 # moving the sum in $t2 to $a0 for printing
	li $v0, 1
	syscall
	
exit:
	li $v0, 10    #syscall to exit
        syscall
	