
.text

# $s5 points to 9 letter character in valid words after asterick
#s0 contains key

	

	
mainValidate:	
	
	addi $t2, $zero, 0  # clear out $t2 and $t0 registers
	addi $t0, $zero, 0
	li $s6, 0 #pointer for entered Words
	li $s7, 0 #pointer for checking words
	
######## VALIDATION FOR INPUT ###########
test: 
	move $t8, $s0              		#load keyCharacter into $t8
	li $v0, 4
	la $a0, promptGame
	syscall
	

	jal timeSeconds 			# calculate start time
	sw $v0,startTime 			# load into start value
	
	#get user input
	li $v0, 8
	la, $a0, userInput
	li $a1, 12
	syscall
	
#	li $a1, 0
#	li $a2, 0
#	upperLoop:
#		lb $t2, tempInput($a1)
#		slti $t1, $t2, 96
#		slti $t3, $t2, 65
#		beq $t1, 0, changeToUpper
#		beq $t3, 1, endtheString
#		sb $t2, userInput($a2)
#		addi $a1, $a1, 1
#		addi $a2, $a2, 1
#		j upperLoop
#	changeToUpper:
#		addi $t2, $t2, -32
#		sb $t2, userInput($a2)
#		addi $a1, $a1, 1
#		addi $a2, $a2, 1
#		j upperLoop
#	endtheString:
#		lb $t2, userInput($a2)
	
  	
  	j timeLeft	
  	
  	timeShift:	
	li $a1, 0
	lb $a0, userInput($a1)
	beq $a0, '0', endGamePromptZero
	
# INITIATE THE VALIDATION METHODS FOR USERINPUT	
	
	#jump to wordLength subroutine
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	jal wordLength
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	#jump to checkMiddle subroutine
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	jal checkMiddle  			#return only if middle is used, if not should go back to test
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	#jump to checkWord subroutine
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	jal checkWord
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	j fourthEnd

#--------------------------- Check for the Middle Letter ---------------------------------#	
checkMiddle:
	li $a0, 0  				#counter for position
	loopValidateMiddle:
		lb $t2, userInput($a0)
		beq $t2, $zero, notValid
		beq $t2, $t8, foundMiddle
		addi $a0, $a0, 1
		j loopValidateMiddle
		
	notValid:
		li $v0, 4
		la $a0, middleAbsent
		syscall
		lw $ra, 0($sp)
		addi $sp, $sp, 4
		j test 				# ask for word again. No need to continue validating the word
	
	foundMiddle:
		jr $ra
		
#_______________________________ End the check for middle letter ________________________#

#_____________________________Check for valid word length___________________________________#
wordLength:
	li $a0, 0		
	li $s2, 0 				#hold word length
	
	wordLengthLoop:
		lb $t3, userInput($a0)
		beq $t3, $zero, finishCount
		addi $s2, $s2, 1
		addi $a0, $a0, 1
		j wordLengthLoop
		
	finishCount:
		slti $t4, $s2, 5
		bne $t4, $zero, notValidLength
		jr $ra 				#Go back to other checks
		
	notValidLength:
		li $v0, 4
		la $a0, wrongLength
		syscall
		lw $ra, 0($sp)
		addi $sp, $sp, 4
		j test 				# ask for word again. No need to continue validating the word
	
	

#____________________________Check the word with valid word list_________________________#
#check userInput with every word in the valid word list
# $s0 contains pointer after asterick
checkWord:
	li $a0, 0  				#counter for characters in userInput
	li $a2, 0 				# reset position in validwords to 0
	li $s6, 0
	
	move $t7, $s6 				#store initial position of entered valid words
	move $t8, $s7 				#store initial position of checkingWords space
	move $t9, $s7 				#store initial position of checkingWords space
	
	j checkNext
	checkNextUpdate: 			#set userInput at postion 0
		li $a2, 0
	checkNext:   				#looks at next valid word
		lb $t0, validWords($s6)
		lb $t1, userInput($a2)
		slti $t2, $t0, 65		#if loaded byte is not a letter, set to 1
		bne $t2, $zero, endOfValidWord	#branch if loaded byte is not a letter
		bne $t1, $t0, errorSearch	#branch if the bytes loaded from userInput and validWords are not equal
		addi $a2, $a2, 1
		addi $s6, $s6, 1
	
		j checkNext
		
			
		endOfValidWord:
			beq $t0, 42, endOfWordFile	#if the character is *, then check is over
			slti $t3, $t1, 65		#check the end of user input
			bne $t3, $zero, saveWordStart	#if not a character, jump to save word
			j nextValidWord
		nextValidWord:
			lb $t0, validWords($s6)		#this means current validWord and userinput are not equal.
			beq $t0, 10, increment    	#branch when newline is found. i.e. end of current word
			addi $s6, $s6, 1
			j nextValidWord
		increment:
			addi $s6, $s6, 1		#increment pointer in validWords to next byte, which is start of new word
			j checkNextUpdate		#go back for further checking
			
		saveWordStart:
			li $t6, 0			#set the pointer in checkingWords to 0
		saveWord:
			li $t1, 0			#set pointer in userInput to 0
			lookForDuplicate:
				lb $t0, userInput($t1)
				lb $t4, checkingWords($t6)
				slti $t2, $t0, 65
				bne $t2, $zero, checkDuplicate		#if end of userInput is found, then this means the word may be duplicate
				bne $t0, $t4, goToNextCheckingWord	#if characters are different, then save because not duplicate
				addi $t1, $t1, 1
				addi $t6, $t6, 1
				j lookForDuplicate
			checkDuplicate:
				slti $t2, $t4, 65			#if end of checking word is also at the end	
				bne $t2, $zero, throwErrorMessage	#then branch because words are the same
				j saveWordLoopStar			#if not then continue to save word, this means the word may be a root of another
			throwErrorMessage:
				li $v0, 4
				la $a0, errorMessagez
				syscall
				lw $ra, 0($sp)
				addi $sp, $sp, 4
				j test 					#jump to ask user for next word
				
			goToNextCheckingWord:				#since the current checkingWords is not the same with user
				lb $t4, checkingWords($t6)		#check with next word in checkingWords
				beq $t4, 10, incrementDuplicate		#newline indicates next new word in checkingWords
				slti $t2, $t4, 65
				bne $t2, $zero, saveWordLoopStar	#if character is not 10, or letters, then checkingWords
				addi $t6, $t6, 1			#list is over and move to save word
				j goToNextCheckingWord
				
			incrementDuplicate:
				addi $t6, $t6, 1			#increment pointer in checkingWords to point to next character
				j saveWord
				
			saveWordLoopStar:
			j mainScore					#Go to add points to current score for correct word
			toTime:
			j addTime					#jump to add time for correct word
			saveWordLoopTwo:	
			li $a0, 0					#set pointer to 0
			saveWordLoop:					#This loop will save user input to list of correct
				lb $t1, userInput($a0)			#words entered by user
				slti $t2, $t1, 65
				bne $t2, $zero, moveNextCheckWord
				sb $t1, checkingWords($s7)
				addi $a0, $a0, 1
				addi $s7, $s7, 1
				j saveWordLoop
		
		moveNextCheckWord:				#add new line after the end of new word added to checkingWords
			li $t1, 10
			sb $t1, checkingWords($s7)
			addi $s7, $s7, 1
			lw $ra, 0($sp)
			addi $sp, $sp, 4
			j test 							#jump to ask user for next word
		errorSearch: 							#go the next valid word for checking
			lb $t0, validWords($s6)
			beq $t0, 10, increment
			addi $s6, $s6, 1
			j errorSearch
		
			
		endOfWordFile:				#This means the entire validWords list has been checked and no matches
		li $v0, 4
		la $a0, notFound
		syscall
		
		li $v0, 4
		la $a0, foundSoFar
		syscall
		
		li $v0, 4
		la $a0, checkingWords
		syscall					#Display current correct words
		
		j menu					#jump to get grid if wanted
afterMenu:
		
		lw $ra, 0($sp)
		addi $sp, $sp, 4
		j test
			
	
fourthEnd:	
	li $v0, 4
	la $a0, correctWordPrompt
	syscall
	
	
	la $a0, checkingWords
	li $v0, 4
	syscall
	
	

