#             IMPORTING                               #
# Imports word file and creats valid word list of 9 letter word

chooseRandom:

	li $a0, 0     					#set lower bound 
	li $a1, 5     					#set upper bound
	li $v0, 42					#randon int with above range
	syscall
	
	move $t0, $a0
	la $a0, startPrompt
	li $v0, 4
	syscall
	
	addi $a0, $t0, 65 				#starts at char A in Ascii table
	la $t7, fileName  				#set $t7 to address of fileName
	sb $a0, ($t7)  					#store random letter in filename 
	
	la $a0, fileName
	la $a1, concat
	jal strcopier 
	
	# Concatenate second string on result buffer
	la $a0, extension
	or $a1, $v0, $zero
	jal strcopier

	j finish
	# String copier function
	strcopier:
	or $t0, $a0, $zero 				# Source
	or $t1, $a1, $zero 				# Destination

	loop:
	lb $t2, 0($t0)
	beq $t2, $zero, end
	addiu $t0, $t0, 1
	sb $t2, 0($t1)
	addiu $t1, $t1, 1
	b loop
	
	end:
	or $v0, $t1, $zero 				# Return last position on result buffer
	jr $ra

	finish:
#----------------------IMPORT FILE -------------------------#
#This function will will the Random letter concatenated with .txt in concat and open the corresponding file. 

importFile:
	
	li $v0, 13  					#system call for open file
	la $a0, concat 					# load address
	li $a1, 0 					# flags
	li $a2, 0  					#mode: O is for read
	syscall

	move $s6, $v0
	
	li $v0, 14  					#system call for read from file
	move $a0, $s6
	la $a1, fileContents				#Use fileContents to hold all of the words from file
	li $a2, 500000
	syscall
	
	li $v0, 16
	move $a0, $s6
	syscall  					#close the file


#____________________________________________________________________________________
	
# CREATE VALID WORD LIST FROM A RANDOM 9 LETTER WORD
# Subroutine will choose a random character. It will then find the next new line
# character. It will assume the next character is a new word. Then it will count the 
# letters of each new word until it reaches a length of 9

validWordList:

	li $a0, 0
	li $a1, 80000			#set upper bound for random int
	li $v0, 42  					# randon int with upper bound of 100000
	syscall
	
	
	addi $sp, $sp, -4 				#make room on stack to store $ra before using jal
	sw $ra, 0($sp)
	jal lookForWord					#Go to look for word function
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	move $a0, $v0  					#$a0 contains first character of random word
	jal lookForNineLetters				#Go to lookForNineLEtters function
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	move $a0, $v0  					#move position of first character of 9 letter word to $a0
	jal makeWordList				#Go to makeWordList function
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	jal extractNineLetters				#ExtractNineLetters from the first nine letters
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	jal getKeyLetter				#Get a random Key character. This function is overrided elsewhere in the Grid file
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	j secondExit
	
# _____________________________ LOOK FOR WORD _________________________#
#This function will look for the word following the random character. $a0 points to a random character. 
#This will go through the file until a newline is found. Then the next character is guaranteed to be the start of a word.

lookForWord:
	lookForWordLoop:
		lb $t8, fileContents($a0)
		beq $t8, 10, returnWordPosition 		#branches if newline character found
		addi $a0, $a0, 1
		j lookForWordLoop
returnWordPosition:
	addi $a0, $a0, 1 					#this will point to first character in word
	move $v0, $a0  						#return first character
	jr $ra

		
#______________________________________________________________________#
#___________________Look for Nine Letter Word__________________________#
#This will look for the first nine letter word. It will go through the file after first word found until it finds an asterick.
#Each nine letter word starts with an asterick. It will then move to character after so it points to start of nine letter word. 

lookForNineLetters:
	lb $t8, fileContents($a0)
	beq $t8, 42, returnNineLetters
	addi $a0, $a0, 1
	j lookForNineLetters
returnNineLetters:
	addi $a0, $a0, 1 					#move to character after *
	move $s5, $a0
	move $v0, $a0 						#return starting character of nine letter word
	jr $ra

	

#___________________MAKE VALID WORD LIST OF NINE LETTER WORD___________#
#creates a word list until the next nine letter word or *
#This will save the words in validWords. Each word will be separated by a new line. It will continue to save each character ("word")
#until an asterisk is found. Then this means that the next word is the next nine character word. 
makeWordList:
	li $a1, 0
	li $a2, 0
	li $t1, 10 						#used to add a new line for after each word
	li $t2, 0 						#used as counter for validWord list
	li $t5, 32 						#used to reload space character in CurrentWord
		makeWordListLoop:
		lb $t8, fileContents($a0)
		beq $t8, 42, endOfList  			#means next word is 9 letters
		beq $t8, 10, endOfWord 				#means end of current word so go to save
		sb $t8, validWords($a2) 			#save character to currentWord
		addi $a2, $a2, 1
		addi $a0, $a0, 1
		j makeWordListLoop
		
		endOfWord:
		sb $t8, validWords($a2)
		addi $a2, $a2, 1
		addi $a0, $a0, 1
		j makeWordListLoop

		endOfList:
		sb $t8, validWords($a2) 			#save asterisk at the end of word list
		jr $ra
		
				
		



#____________________________________________________________________#
#______________________EXTRACT NINE LETTERS_________________________#
# returns the nine letters that will be used for the game.
#This function will place the characters in nineCharacters
			
extractNineLetters:
	li $a0, 0 					#count for first position in validWords
	li $t0, 0 					#reset $t0
	extraction:
		lb $t0, validWords($a0) 		#load characters from first word (nine letter word)
		beq $t0, 10, endExtraction
		sb $t0, nineCharacters($a0) 		#save in nineCharacters
		addi $a0, $a0, 1 			#move to next character
		j extraction
	endExtraction:
	jr $ra
	
	
#___________________________________________________________________________#
#___________________________GET KEY LETTER_______________________________________#
#saves a random key letter and saves the remaining 8 letters of the nine letter word. 
getKeyLetter:
	li $a3, 0 					#count for first position in nineCharacters
	li $a0, 0
	li $a1, 8  					#set upper bound for random int
	li $v0, 42  					# randon int with upper bound of 100000
	li $t1, 0 					#count for nine Characters
	li $t2, 0 					#count for remainingLetters
	
	syscall
	lb $t0, nineCharacters($a0)
	sb $t0, keyCharacter($a3)
	eightLetters:
		beq $t1, $a0, skipKey
		beq $t2, 10, endKey
		lb $t0, nineCharacters($t1)
		sb $t0, remainingLetters($t2)
		addi $t1, $t1, 1
		addi $t2, $t2, 1
		j eightLetters
		skipKey:
			addi $t1, $t1, 1
			j eightLetters
			
		endKey:
			jr $ra
			
	
		secondExit:
		

	

	
	
	
