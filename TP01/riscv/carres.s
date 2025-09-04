	.text
	.globl main
main: 	                                                           
	addi	sp,sp,-16
	sd	ra,8(sp)
## TODO Your assembly code there
# BEGIN CUT
	la 	t3, mydata # load reading address
	ld 	t4,  0(t3) # load input
	mv	t5, t4
	mv 	t6, t4
	li 	t0, 42 # load star
loop:
	beqz	t5, end
	beqz	t6, looploop
	mv	a0, t0
	call 	print_char
	addi	t6, t6, -1
	j loop	
looploop:  # start a new line
	mv	t6, t4
	addi	t5, t5, -1
	call	newline
	j loop
end:
# END CUT
## END TODO End of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	ret

# Data comes here
	.section	.data
mydata:
	.dword 7
