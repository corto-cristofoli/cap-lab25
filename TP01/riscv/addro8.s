# Préférer les ti aux ai.
	.globl main
main:                                                            
    	addi t0, zero, 1 	# or li t0, 1
	addi t1, zero, 8
loop:
	addi t0, t0, 1
	beq t0, t1, end
	j loop
end:
        ret
