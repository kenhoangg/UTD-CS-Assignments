# Homework 5
# @author: Kenny Hoang
# CS3340.501
# Professor Nhut Nguyen
# 10/27/2016
#######################################################################################################
# MIPS assembly program that prompts user for an amount in US dollars and the
# displays the equivalent amount in Japanese Yen.

.data
prompt: .asciiz "Please enter amount of US dollars: "
output: .asciiz "The equivalent value in Japanese Yen is: "
convert: .float 103.97

.text
main:
	lwc1 $f4, convert
	
	
loop:	# Display message
	li $v0, 4		# service 4 is for printing string
	la $a0, prompt		# load the string prompt into $a0
	syscall	
	
	# Read user input
	li $v0, 6		# service 5 is for reading integer
	syscall
	mov.s $f2, $f0
	
	
	add $t0, $t0, 1
	
	# Display output message
	li $v0, 4
	la $a0, output
	syscall
	
	# call usdtoyen to calculate equivalent value in Yen
	jal usdtoyen
	
	li $v0, 2
	syscall
	
	# printing newline to separate outputs	
	addi $a0, $0, 10
	addi $v0, $0, 11
	syscall
	
	j loop
usdtoyen:
	mul.s $f12, $f2, $f4	# multiply USD by conversion rate (103.97)
	jr $ra

exit:
	li $v0, 10	# service 10 is for exiting the program
	syscall
