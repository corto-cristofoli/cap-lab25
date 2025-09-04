.section .text #code de cesar
.globl main
main:
	addi	sp,sp,-16
	sd	ra,8(sp)
## Your assembly code there
	la t3, .LC1		# t3 = .LC1
	mv a0, t3		# a0 = t3
	call println_string
	# now: encode with cesar code.
	li t0, 0		# t0 = 0
	la a1, .dec		# a1 = .dec
	ld t1, 0(a1)    	# t1 = *a1
loop:
	lb t2, 0(t3)		# t2 = *t3
	beq t2, zero, end	# t2 == '\0' => end
	add t2, t2, t1		# t2 = t2 + t1 (add .dec to t2)
	sb t2,0(t3)		# *t3 = t2
	addi t3, t3, 1		# t3 = t3 + 1 (move forward in the string)
	j loop
end:	# now prints the transformed word.
	la a0, .LC1		# a0 = .LC1
	call println_string
	call newline
## /end of user assembly code
	ld	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	ret

# Data comes here
	.section	.data
	.align	3
.LC1:
	.string	"Hello world!\0"
.dec :
	.byte 4
