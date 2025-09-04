.section .text
.globl main
main:	
	addi	sp,sp,-16
	sd	ra,8(sp)
## Your assembly code there
	lui	a5,%hi(HELLO)
	addi	a0,a5,%lo(HELLO)
	call	println_string
	lui	a6,%hi(COURSE)
	addi	a0,a6,%lo(COURSE)
	call	println_string

## /end of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	ret

# Data comes here
	.section	.data
	.align	3
HELLO:
	.string	"Hello"
COURSE:
	.string "CAP ENSL 2019-20"
