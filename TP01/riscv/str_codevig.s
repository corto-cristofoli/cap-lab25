.section .text #xor
.globl main
main:
	addi	sp,sp,-16
	sd	ra,8(sp)
## Your assembly code there
	la t3, .msg		# t3 = .msg
	mv a0, t3		# a0 = t3
	call println_string
	la t4, .key		# t4 = .key
	mv a0, t4		# a0 = t4
	call println_string

# NB: len(msg) == len(key)
# encode msg with key
loop:	lb t2, 0(t3)		# t2 = *t3
	lb t1, 0(t4)		# t1 = *t4
	beq t2, zero, end	# t2 == '\0' => end
	xor t2, t2, t1	     	# t2 = t2 xor t1
	addi t2, t2, 65		# t2 = t2 + 65 (optional in the paper version)
	sb t2, 0(t3)		# *t3 = t2
	addi t3, t3, 1		# t3 = t3 + 1 (move forward in .msg)
	addi t4, t4, 1		# t4 = t4 + 1 (move forward in .key)
	j loop
end:	# now prints the transformed word.
	la a0, .msg
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
.msg:
	.string	"Hello world!\0"
.key:
	.string "keykeykeykey\0"
