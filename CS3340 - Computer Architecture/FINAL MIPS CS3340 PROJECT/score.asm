
.text
#____________________________Main function called to calculate score_________________________#
mainScore:
la $a0, userInput       # laod user input into $a0
jal addScore		# calculate score
sw $v0,score 		# store returned value in score
j toTime

#____________________________Funtion to caaculate the new score_________________________#
# adds new points to score
addScore:
li $t0, 0		# initialize the count to zero
loopTwo:
lb $t1, 0($a0) 		# load the next character into t1
beqz $t1, exitTwo 	# check for the null character
addi $a0, $a0, 1 	# increment the string pointer
addi $t0, $t0, 1 	# increment the count
j loopTwo 		# return to the top of the loop
exitTwo:
lw $a1, score 		# score loaded into $a1
add $t1, $zero, $a1  	# current score laoded into $t1

mul $t0, $t0,2		# multplit 2 points per letter
mflo $t0

add $v0, $t0, $t1	# add previous score to current score
sub $v0,$v0,2 		# compensate for null character
jr $ra




