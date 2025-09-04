	.globl main
main: 	                                                           
	addi	sp,sp,-16
	sd	ra,8(sp)
## TODO Your assembly code there
# BEGIN CUT
	la 	t3, mydata # load reading address
	ld 	t4,  0(t3) # load input
	addi 	t0, zero, 1 # init mask
	mv 	t1, zero # init accu
loop:	
	mv 	a0, t0
	call 	print_int
	call    newline
	and 	t5, t4, t0 # apply mask
	beqz 	t5, skip # test if the mask is empty
	addi 	t1, t1, 1
skip:
	bltz 	t0, end # the last bit is the sign bit
	add 	t0, t0, t0 # double the counter
	j 	loop
end:
	mv 	a0, t1
	call 	print_int
	call    newline
# END CUT
## END TODO End of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	ret

# Data comes here
	.section	.data
mydata:
	.dword 7
