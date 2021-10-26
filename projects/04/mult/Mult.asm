// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.

// Put your code here.

// init R2 (output) to zero
@R2
M=0

// load input r0 to data reg
@R0
D=M

// check for zero, conditionally jump
@END
D;JEQ

// load input R1 to data reg
@R1
D=M

// check for zero, conditionally jump
@END
D;JEQ

// begin loop
@LOOP
0;JMP

// load R1 into R2, R0 amount of times
(LOOP)

    // load R1
    @R1
    D=M

    // add R1 to R2
    @R2
    M=D+M

    // decrement R0 until we reach zero
    // effectively multiplying R1 by R0
    @R0
    M=M-1

    // jump to end if R1 
    // has reached zero
    @R0
    D=M
    @END
    D;JEQ
    
    // keep looping
    @LOOP
    0;JMP

(END)
0;JMP
