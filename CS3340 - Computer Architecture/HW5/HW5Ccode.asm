# Homework 4
# @author: Kenny Hoang
# CS3340.501
# Professor Nhut Nguyen
# 10/19/2016
#######################################################################################################
# MIPS assembly program that implements the setArray function along with compare and sub functions

.data
prompt: .asciiz "Please enter a number: "


.text
main:
	la 	$a0, prompt	# load string prompt into $a0
	li 	$v0, 4		# service 4 is for printing string
	syscall
	
	li 	$v0, 5		# service 5 is for reading integer
	syscall
	move 	$a0, $v0	# move $v0 to $a0
	jal 	setarray
	
exit:
	li 	$v0, 10 	# service code 10 is for exiting the program
	syscall
setarray:
	# making room for array
	addi 	$sp, $sp, -44	# allocate 44 more bytes for storage, 4 for $ra and 40 for the array
	sw	$ra, 0($sp)
	add 	$s0, $0, $0	# setting i to 0

loop:
	jal 	compare
	sw	$v0, -4($sp)
	sw	$ra, 0($sp)
	addi	$s0, $s0, 1
	blt 	$s0, 10, loop
	
end:
	jr $ra

compare:
	add $a1, $s0, $0
	sub $s1, $a0, $a1
	bge $s1, $0, return1
	li $v0, 0
	jr $ra
return1:
	li $v0, 1
	jr $ra