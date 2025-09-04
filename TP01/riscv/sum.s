# riscv64-unknown-elf-gcc -o sum main_ret.c sum.s
# spike pk sum
	.globl main
main:                                                
        addi t0, zero, 0 	# loop counter (i)
	addi t1, t0, 0		# accu
	addi t2, zero, 10
loop:
	add t1, t1, t0      # accu+=i
 	addi t0, t0, 1
	beq t0, t2, end
	j loop
end:
	add a0, zero, t1 # to test.
        ret
