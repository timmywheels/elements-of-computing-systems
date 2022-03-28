# Computer Arhictecture

## The Stored Program Concept

Considered to be one of the most profound inventions in all of computer science, the stored program concept (also known
as 'software'), allows for a fixed hardware platform that is capable of executing a fixed set of instructions to execute
arbitrary programs stored in memory allowing for dynamic applications as opposed to a fixed set of programs stored
within the machine's hardware that cannot be altered.

## The von Neumann Architecture

The 'Stored Program Concept' is a fundamental component of both abstract (Turing machine, 1936) and practical (von
Neumann Machine, 1945) computer models.

The von Neumann architecture is based on a CPU interacting with a memory device, receiving data from some input device,
and emitting data to some output device. At the heart of this architecture lies the __stored program concept__.

## Memory

Memory can be discussed from both physical and logical perspectives. Physically speaking, memory is a linear sequence of
addressable, fixed-size registers each of which have a unique address and store some value. Logically the address space
serves two purposes: storing data and storing instructions.

### Data Memory

High-level programs are designed to manipulate abstract artifacts like variables, arrays, objects, etc. but at the
hardware level these abstractions are realized by binary values that are stored in memory registers.

### Instruction Memory

Before a high-level program can be executed on a target computer, it must first be translated into a machine language
that the target computer can understand. Each high-level statement is translated into one or more low-level instructions
which are written as binary values to a file called the __binary__ or __executable__ version of the program. This
program is then loaded from ROM and it's instructions are serialized into the computer's instruction memory.

## Central Processing Unit

The CPU is the core component of a computer's architecture. It is in charge of executing the instructions of the program
at hand. Each instruction tells the computer which computation to perform, which registers to access, and which
instruction to fetch and execute next. The CPU executes these tasks uses three primary components: the ALU, a set of
Registers, and a Control Unit.

### Arithmetic Logic Unit (ALU)

The ALU is a chip built to perform all low-level arithmetic and logical operations available to the computer. How much
functionality the ALU offers is a design decision. Generally any function that cannot be computed by the ALU can later
be realized by a software abstraction, though the trade-off is generally cost (hardware) vs. performance (software
abstraction).

### Registers

In the course of performing computations, the CPU generally needs to store interim values temporarily. Though in theory
these interim values could be stored in memory, this would entail long-distance round trips between the CPU and RAM (two
separate chips) leading to CPU "frustration" which runs computations extremely fast, resulting in what's known as "
starvation" which is what happens when a fast processor depends on a sluggish data store for supplying and consuming
inputs. Thus, a CPU is generally equipped with an "in-house" set of high-speed memory __registers__ acting as the
processors "immediate" memory. Data registers store interim values and address registers store values used to address
the RAM. The __program counter__ stores the address of the instruction that should be fetched and executed next, while
the __instruction register__ stores the current instruction.

### Control

A computer instruction is a structured package of agreed-upon "micro-codes" which are a sequence of 1 or more bits that
instruct the computer on what to do. Prior to being executed, these "micro-codes" must be decoded and then routed to the
proper hardware component (ALU, registers, memory) within the CPU.

### Fetch-Execute

In each step (cycle) of the program's execution, the CPU fetches a binary machine instruction from the instruction
memory, decodes it, then executes it. The CPU also determines which instruction to execute next. This is known as the __
fetch-execute cycle__.

## Input and Output

Computers interact with their external environments via Input/Output (I/O) devices such as a mouse, keyboard, screens,
printers, microphones, speakers, etc. All I/O devices adhere to an abstraction referred to as __memory-mapped I/O__
which allows for all of these different peripherals to look the same to the computer under the hood, i.e. they use the
same underlying interface.
