	.text
	.globl main
main:	
	addi	sp,sp,-16
	sd	ra,8(sp)
## Your assembly code there
	la t3, mydata # load address
	ld t4,  4(t3) # load a double word at @+offset
#	mv a0, t4
#	call print_int
## /end of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	ret

# Data comes here
	.section	.data
mydata:
	.dword 7
	.dword 42
	.dword 0
