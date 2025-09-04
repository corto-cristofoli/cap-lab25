	.text
	.globl main
main: 	                                                           
	addi	sp,sp,-16
	sd	ra,8(sp)
## TODO Your assembly code there
# BEGIN CUT
	la 	t3, mydata # load reading address
	ld 	t4,  0(t3) # first op of minmax
	ld 	t5,  8(t3) # second op of minmax
	la 	t6, min # load writing adress
	blt 	t4, t5, fst_is_min
	mv 	a0, t5
	j 	end
fst_is_min:
	mv 	a0, t4
end:
	sd 	a0, 0(t6) # write result
	call 	print_int
	call	newline
# END CUT
## END TODO End of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	ret

# Data comes here
	.section	.data
mydata:
	.dword 7
	.dword 42
min:
	.dword 0
