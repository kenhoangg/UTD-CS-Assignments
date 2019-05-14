
.text
#____________________________Function that calculates and prints seconds remaining_________________________#
timeLeft:
lw $a0, startTime 		# load start time into $a0
jal timeLapse 			# caclulate diff between times
add $t1, $v0, $zero 		# add time to $t1

lw $t2, leftTime 		# load remaining time into $t2
sub $t2, $t2, $t1 		# subtract time time diff from time remaining
sw $t2, leftTime 		# update left time with new time

blt $t2, $0, endGamePrompt 	# if time left is 0 exit

la $a0, intrTime 		# prompt for time left
li $v0,4
syscall

move $a0, $t2			# move time left to register
li $v0, 1 			# print
syscall

j timeShift
 
#____________________________Check the word with valid word list_________________________#
# adds time to current time
addTime:
lw $t1,leftTime
addi $t1,$t1,10
sw $t1,leftTime
j saveWordLoopTwo

#____________________________Get current system time _________________________#
# calcluates current seconds of system time returns at $v0
 timeSeconds:
 li $v0,30
 syscall
 li $t0,1000
 div $a0, $t0
 mflo $v0
 jr $ra 

#____________________________Get difference in time_________________________#
# calculates the difference in start time inputted at $a0  return at $v0
timeLapse:
addi $sp, $sp,-8
sw $ra, ($sp)
sw $a0, 4($sp)
jal timeSeconds
lw $t0, 4($sp)
lw $ra, ($sp)
addi $sp, $sp, 8
sub $v0, $v0, $t0
jr $ra

