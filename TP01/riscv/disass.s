# pour obtenir le obj: riscv64-unknown-elf-as -march=rv64g  -c disass.s -o disass.o
# riscv64-unknown-elf-objdump disass.o -d
	.globl main
main:	
ici:
	addi t1, t0, 1
	j ici

  ret
