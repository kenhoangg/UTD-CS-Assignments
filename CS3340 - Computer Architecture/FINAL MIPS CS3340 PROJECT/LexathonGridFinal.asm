######################################################################
# This program prints the grid and tries to seperately implement the "key" character (the middle character in the grid) and uses a seperate 8 character array plannned for scrambling


#.data
	#outerBorder:	.asciiz "\t+---+---+---+\n"
	#middleBorder:	.asciiz "\t|---+---+---|\n"
	#leftBorder:	.asciiz "\t| "
	#rightBorder:	.asciiz " |\n"
	#innerBorder:	.asciiz " | "
	#shufflePrompt: .asciiz "Shuffle grid?(Y/N)"
	#wordCharacters: .asciiz "ABANDONED" # THIS HOLDS THE WORD READ IN FROM THE FILE
	#toShuffleChars: .space 8
	#shuffledChars:	.space 8

#.text
j start
#shuffle:
#	addi $sp, $sp, -4	# make room on the stack
#	sw   $ra, 0($sp)	# store return address
#	jal  shuffleCharactersInGrid
#	lw   $ra, 0($sp)  	# restore return address
#	addi $sp, $sp, 4
	
#	li $a0, 10
#	li $v0, 11
#	syscall
	#jal printGrid
#	jr $ra
	# Prompt and check if user wants to scramble #
#askShuffle:
#	la $a0, shufflePrompt
#	li $v0, 4
#	syscall
#	li $v0, 12
#	syscall
#	move $t0, $v0
#	li $t1, 'Y'
#	li $t2, 'y'
#	beq $t0, 2, shuffle
#	beq $t0, $t2, shuffle	
#	li $a0, 10
#	li $v0, 11
#	syscall
#	j finalExit
	#li $v0, 10
	#syscall
mainGrid:
	#jal setKey
	#jal fillCharArray
	# -- Calling shuffleCharactersInGrid function initially to shuffle first grid -- #	
#	li $s7, -1		# set $s7 to -1, $s7 stores the last shuffle call to ensure when shuffle is called, it the same grid does not appear
#____________________________Setting the key character for the grid_________________________#	
setKey:
	li $a0, 1
	li $a1, 9
	li $v0, 42
	syscall
	
	move $a2, $a0 # register $a2 stores the key character index within the original word
		
	beq $a2, 0, setKey1
	beq $a2, 1, setKey2
	beq $a2, 2, setKey3
	beq $a2, 3, setKey4
	beq $a2, 4, setKey5
	beq $a2, 5, setKey6
	beq $a2, 6, setKey7
	beq $a2, 7, setKey8
	beq $a2, 8, setKey9
	
		setKey1:
			la $t0, nineCharacters
			lb $s0, 0($t0) # store key character in $s0
			j endSetKey
			
		setKey2:
			la $t0, nineCharacters
			lb $s0, 1($t0) # store key character in $s0
			j endSetKey
			
		setKey3:
			la $t0, nineCharacters
			lb $s0, 2($t0) # store key character in $s0
			j endSetKey
			
		setKey4:
			la $t0, nineCharacters
			lb $s0, 3($t0) # store key character in $s0
			j endSetKey
			
		setKey5:
			la $t0, nineCharacters
			lb $s0, 4($t0) # store key character in $s0		
			j endSetKey	
			
		setKey6:
			la $t0, nineCharacters
			lb $s0, 5($t0) # store key character in $s0
			j endSetKey
			
			
		setKey7:
			la $t0, nineCharacters
			lb $s0, 6($t0) # store key character in $s0
			j endSetKey		
			
		setKey8:
			la $t0, nineCharacters
			lb $s0, 7($t0) # store key character in $s0
			j endSetKey
			
		setKey9:
			la $t0, nineCharacters
			lb $s0, 8($t0) # store key character in $s0
			j endSetKey
endSetKey:
	jr $ra
#____________________________End setting the key character for the grid_________________________#

#____________________________Filling array of characters to be scrambled_________________________#
fillCharArray:
	li $a1, 0 	# set $a1 to position in wordCharacters
	li $t0, 0	# set $t0 to position in toShuffleChars
	li $t1, 0	# $t1 is the counter in the loop
	charloop:
		beq	$a1, $a2, ignoreKey # check if the character at $a1 in wordCharacters is the key of the grid
		lb 	$t2, nineCharacters($a1) # get character at $a1 in wordCharacters and store in $t2
		sb	$t2, toShuffleChars($t0) # store character at $a1 in wordCharacters in toShuffleChars at index $t0
		addi	$a1, $a1, 1	# move to next character in wordCharacters
		addi	$t0, $t0, 1	# move to next position in outerChars
		addi	$t1, $t1, 1	# increment counter
		j checkCounter
	ignoreKey:
		addi	$a1, $a1, 1
	checkCounter:
		blt $t1, 8, charloop
endFillCharArray:
	jr $ra
#____________________________End filling array of characters to be scrambled_________________________#

#____________________________Printing the grid and characters_________________________#

printGrid:	
	li $a1, 0		# set $a1 to the position in wordCharacters
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printOuterBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printLeftBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printRightBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printMiddleBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4		
		
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printLeftBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	# -- KEY CHARACTER -- #
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printKeyCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printRightBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printMiddleBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printLeftBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printInnerBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printNextCharacter
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printRightBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4	# make room on the stack
	sw   $ra, 0($sp)	# store return address
	jal  printOuterBorder
	lw   $ra, 0($sp)  	# restore return address
	addi $sp, $sp, 4	
	
	jr $ra
	
	
printOuterBorder:
	li $v0, 4
	la $a0, outerBorder
	syscall
	jr $ra
	
printMiddleBorder:
	li $v0, 4
	la $a0, middleBorder
	syscall
	jr $ra

printInnerBorder:
	li $v0, 4
	la $a0, innerBorder
	syscall
	jr $ra
	
printLeftBorder:	
	li $v0, 4
	la $a0, leftBorder
	syscall
	jr $ra 
	
printRightBorder:
	li $v0, 4
	la $a0, rightBorder
	syscall
	jr $ra

printNextCharacter:
	lb $a0, shuffledChars($a1)
	li $v0, 11
	syscall
	add $a1, $a1, 1
	jr $ra

printKeyCharacter:
	move $a0, $s0
	li $v0, 11
	syscall
	jr $ra
#____________________________End printing the grid and characters_________________________#		

#____________________________Shuffling the characters within the grid_________________________#
shuffleCharactersInGrid:

reshuffle:
	li $a0, 1
	li $a1, 9
	li $v0, 42
	syscall
	move $t0, $a0
	beq $s1, $t0, reshuffle
	move $s1, $t0
	
	beq $t0, 0, shuffle1
	beq $t0, 1, shuffle2
	beq $t0, 2, shuffle3
	beq $t0, 3, shuffle4
	beq $t0, 4, shuffle5
	beq $t0, 5, shuffle6
	beq $t0, 6, shuffle7
	beq $t0, 7, shuffle8
	beq $t0, 8, shuffle9
		
		shuffle1:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle2:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle3:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars	
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
							
		shuffle4:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle5:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle6:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle7:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle8:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
#			 beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
			
		shuffle9:
			li $t1, 0 # $t1 stores the current index in shuffledChars
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 4
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 5
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 7
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 3
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 2
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 1
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 6
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
			li $t0, 0 # $t0 stores the current index in toShuffleChars
			addi $t0, $t0, 0
			lb $t2, toShuffleChars($t0) # $t2 holds the character grabbed from toShuffleChars
			sb $t2, shuffledChars($t1) # store the character grabbed from toShuffleChars and store inShuffledChars
			addi $t1, $t1, 1 # move to next index in shuffledChars
			
#			beq $a3, 2, jumpShuffleComplete
			j endShuffleCharactersInGrid
			
endShuffleCharactersInGrid:
	jr $ra
#____________________________End shuffling the characters within the grid_________________________#		
finalExit:

#jumpShuffleComplete:
#j shuffleJumpDone
