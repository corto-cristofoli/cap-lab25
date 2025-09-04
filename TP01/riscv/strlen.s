.section .text
.globl main
main:
	addi	sp,sp,-16
	sd	ra,8(sp)
## Your assembly code there
	la a0, .LC1			# a0 = .LCI (address of the string)
	call	println_string
	# now: compute length in register t0
	li t0, 0			# t0 = 0
loop:	ld t2, 0(a0)			# t2 = *a0
	beq t2, zero, end		# t2 == '\0' => goto end
	addi t0,t0,1			# t0 = t0 + 1
	addi a0, a0, 1			# a0 = a0 + 1 (move one char forward)
	j loop				# goto loop
end:					# at this point t0 contains the length
	mv a0, t0			# feed t0 into a0 (a0 is used as an argument for print_int)
	call print_int
	call newline
	la t1, .res			# t1  = res
	sd t0, 0(t1)			# *t1 = t0
## /end of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	ret

# Data comes here
	.section	.data
	.align	3
.LC1:
	.string	"Hello, world!"

.res :
	.dword 0
