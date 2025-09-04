	.globl main
main:
	li t0, 0		# t0 = 0
	addi t1, t0, 1		# t1 = t0 + 1
	la t2, data		# t2 = data
	ld t3, 0(t2)		# t3 = *data
loop:
	addi t1, t1, 2		# t1 = t1 + 2
	addi t3, t3, -1		# t3 = t3 - 1
	blt zero, t3, loop	# 0 < t3 => loop
	add a0, zero, t1	# return t1
	ret
    .section .rodata
data:
    .dword 6
