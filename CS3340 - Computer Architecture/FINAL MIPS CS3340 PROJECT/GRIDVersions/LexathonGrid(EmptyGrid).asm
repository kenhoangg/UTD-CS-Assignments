######################################################################
# This program prints an empty grid
								   
.data
	gridPrintTopString:	.asciiz "\t\t+---+---+---+\n"
	gridPrintMiddleString:	.asciiz "\t\t|---+---+---|\n"
	gridPrintBottomString:	.asciiz "\t\t+---+---+---+\n"
	gridPrintSideLeftString:.asciiz "\t\t| "
	gridPrintSideRightString:.asciiz " |\n"
	gridPrintInsideString:	.asciiz " | "
	blankLetter: .asciiz " "
.text

main:
	jal printGrid
	
	li $v0, 10
	syscall
############################################################################
# -- Printing the grid -- #

printGrid:

#	addi $sp, $sp, -4	#make room on the stack
#	sw   $ra, 0($sp)	#store return address
#	jal  shuffleLetters
#	lw   $ra, 0($sp)  #restore return address
#	addi $sp, $sp, 4	
	
	
	li $a1, 0	#$a1 stores the current char position in lettersInGrid
	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintTop
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideLeft
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideRight
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintMiddle
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
		
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideLeft
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideRight
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintMiddle
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideLeft
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintInside
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintNextChar
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintSideRight
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	#make room on the stack
	sw   $ra, 0($sp)	#store return address
	jal  gridPrintBottom
	lw   $ra, 0($sp)  #restore return address
	addi $sp, $sp, 4	
	
	jr $ra
	
	
gridPrintTop:
	li $v0, 4
	la $a0, gridPrintTopString
	syscall
	jr $ra
gridPrintMiddle:
	li $v0, 4
	la $a0, gridPrintMiddleString
	syscall
	jr $ra
gridPrintBottom:
	li $v0, 4
	la $a0, gridPrintBottomString
	syscall
	jr $ra

gridPrintInside:
	li $v0, 4
	la $a0, gridPrintInsideString
	syscall
	jr $ra
	
gridPrintSideLeft:	
	li $v0, 4
	la $a0, gridPrintSideLeftString
	syscall
	jr $ra 
	
gridPrintSideRight:
	li $v0, 4
	la $a0, gridPrintSideRightString
	syscall
	jr $ra

gridPrintNextChar:
	li $v0, 4
	la $a0, blankLetter
	syscall
	jr $ra
#gridPrintNextChar:
#	lb $a0, lettersInGrid($a1)
#	li $v0, 11
#	syscall
#	add $a1, $a1, 1
#	jr $ra
