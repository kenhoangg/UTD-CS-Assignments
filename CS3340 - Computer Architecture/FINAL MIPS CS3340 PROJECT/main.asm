# Name: 		Aditya Buvanendiran, Changho Lee, Kenny Hoang, Nick Ramos
# Date:			10/30/2016
# Project:		This is the main file for the Lexathon MIPS project. This is a word game written in MIPS. Please 
#			read User Manual for information of how to play the game. 
.data
#MAIN MENU PROMPTS

welcomeMessage:		.asciiz "Welcome to LEXATHON!\n"
border: 		.asciiz "===================================\n"
goalMessage: 		.asciiz "The goal of the game is to find as many possible word combinations as you can given the letters you are provided with.\n\n"
instructions1:		.asciiz "INSTRUCTIONS:\n"
instructions2:		.asciiz "               1. At the start of the game you will be given 60 seconds and a 3x3 grid of letters.\n"
instructions3:		.asciiz	"               2. The letter located in the center of the grid is your key letter.\n"
instructions4:		.asciiz "               3. During the 60 seconds you must find as many word combinations as you can using the provided letters.\n"
instructions5: 		.asciiz "               4. Every word that you enter MUST contain the key letter somewhere within the word.\n"
instructions6: 		.asciiz "               5. Every word that you enter MUST be AT LEAST four letters long.\n"
instructions7: 		.asciiz "               6. For every correct word you guess, you will receive an additional 10 seconds of time.\n"
instructions8: 		.asciiz "               7. For every correct word you guess, you will receive 2 points for every word.\n"
instructions9:		.asciiz "               8. The game ends when the time reaches ZERO or you type '0'(zero) to GIVE UP.\n"
instructions10:		.asciiz "               9. Please turn on CAPS LOCK when playing the game. The letters must match exactly with letters given (Capital)\n"
instructions11:		.asciiz "               10. Please restart program if you would like to play again with a different set of random letters\n\n"
beginLexathon: 		.asciiz "Press space to start the game."
gameOver:		.asciiz "\n             		GAME OVER!		             \n"
correctWords:		.asciiz "\nCorrect words entered: \n"
outOfTime:		.asciiz "\nOUT OF TIME!\n"
errorMessagez: 		.asciiz "\nDuplicate word entered!\n"
endGameMessage:  	.asciiz "\n\nGAME IS OVER!!!!\n"
scoreprompt: 		.asciiz "\nFINAL SCORE: "
promptGame:		.asciiz  "\nEnter your word or type '0' to Give Up: "
middleAbsent:		.asciiz  "\nThe middle character has not been used. "
notFound:		.asciiz	 "\nThis is not a valid word.\n"
correctWordPrompt:	.asciiz  "\nThis is a correct word. "
wrongLength:		.asciiz  "\n Word must be at least 4 letters. "
foundSoFar:		.asciiz  "\nThese are your correct words so far: \n"

#SCORE AND TIME PROMPTS
score: 			.word 	0
leftTime: 		.word 	0
startTime:              .word 	0

#INPUT PROMPTS

fileName:		.space	1
fileContents: 		.space 500000
concat:			.space  8
currentWord: 		.asciiz "             "
extension:		.asciiz ".txt"
letterA:		.asciiz "A.txt"
validWords:		.space 1000
checkingWords:		.space 100000
userInput:		.asciiz "          "
tempInput:		.asciiz "          "
validatingWord:		.asciiz "          "
nineCharacters:		.asciiz "          "
keyCharacter:		.asciiz " "
remainingLetters:	.asciiz "         "
outputWord:		.asciiz "          "
newLine:		.asciiz "\n"
startPrompt:		.asciiz  "\nSTARTING GAME....\n"	
displayCorrectWords:	.asciiz "\n\nYour Correct Entered Words: \n"
intrTime:               .asciiz "\nSeconds remaining: "

# PRINTING GRID

outerBorder:		.asciiz "\t\t\t+---+---+---+\n"
middleBorder:		.asciiz "\t\t\t|---+---+---|\n"
bottomBorder:		.asciiz "\t\t\t+---+---+---+\n"
leftBorder:		.asciiz "\t\t\t| "
rightBorder:		.asciiz " |\n"
innerBorder:		.asciiz " | "
blankLetter: 		.asciiz "a"
toShuffleChars: 	.space 8
shuffledChars:		.space 8
shufflePrompt: 		.asciiz "Press 2 to shuffle the grid:   "
displayGrid:		.asciiz "Press 1 to display the grid. "

.text

.include "importing.asm"
.include "LexathonGridFinal.asm"
.include "validate.asm"
.include "timetrack.asm"
.include "score.asm"

#print rules and instructions
start:
li $v0, 4
la $a0, welcomeMessage
syscall

la $a0, border
syscall

la $a0, goalMessage
syscall

la $a0, instructions1
syscall

la $a0, instructions2
syscall

la $a0, instructions3
syscall

la $a0, instructions4
syscall

la $a0, instructions5
syscall

la $a0, instructions6
syscall

la $a0, instructions7
syscall

la $a0, instructions8
syscall

la $a0, instructions9
syscall

la $a0, instructions10
syscall

la $a0, instructions11
syscall

la $a0, beginLexathon
syscall

setupGame:
li $a1, 0
sw $a1, score
li $a1, 60
sw $a1, leftTime

startGame:
#text
li $v0, 12
syscall

bne $v0, 32, exit

jal setKey
jal fillCharArray
jal shuffleCharactersInGrid
jal printGrid
j mainValidate

menu:
li $v0, 4
la $a0, displayGrid
syscall
la $a0, shufflePrompt
syscall
li $v0, 5
syscall
move $a3, $v0
beq $a3, 2, shufflePrint
beq $a3, 1, printOnly
shufflePrint:
jal shuffleCharactersInGrid
printOnly:
jal printGrid
j afterMenu

endGamePromptZero:

li $v0, 4
la $a0, endGameMessage
syscall

la $a0,scoreprompt
li $v0,4
syscall

lw $a0,score
li $v0, 1
syscall

li $v0, 4
la $a0, displayCorrectWords
syscall

li $v0, 4
la $a0, checkingWords
syscall

j exit

endGamePrompt:

la $a0, outOfTime
li $v0, 4
syscall

li $v0, 4
la $a0, endGameMessage
syscall

la $a0,scoreprompt
li $v0,4
syscall

lw $a0,score
li $v0, 1
syscall

li $v0, 4
la $a0, displayCorrectWords
syscall

li $v0, 4
la $a0, checkingWords
syscall
#lw $a0, leftTime
#li $v0, 1
#syscall

exit: 
	li $v0, 10
	syscall
