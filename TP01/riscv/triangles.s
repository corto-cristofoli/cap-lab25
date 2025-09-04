	.text
	.globl main
main: 	                                                           
	addi	sp,sp,-16
	sd	ra,8(sp)
## TODO Your assembly code there
# BEGIN CUT
	la 	t3, mydata # load reading address
	ld 	t4,  0(t3) # load input
	mv	t5, t4 # init number of spaces
	mv	t6, zero # counter
	li 	t0, 42 # load star
	li 	t1, 32 # load space

lineloop:
	addi	t5, t5, -1 # number of starting spaces
spaceloop:
	bge	t6, t5, starloop
	mv	a0, t1
	call 	print_char
	addi	t6, t6, 1
	j spaceloop	
starloop: 
	bge	t6, t4, endstarloop
	mv	a0, t0
	call 	print_char
	mv	a0, t1
	call 	print_char
	addi	t6, t6, 1
	j starloop	
endstarloop:
	mv	t6, zero
	call	newline
	bgtz	t5, lineloop	
# END CUT
## END TODO End of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	ret

# Data comes here
	.section	.data
mydata:
	.dword 7
