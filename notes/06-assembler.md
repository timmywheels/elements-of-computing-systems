# Assembler

The assembler is in charge of converting symbolic programs into their binary representations. One complicated piece of
translating symbolic code is that the symbolic references to underlying memory addresses need to be resolved -- this is
often handled via a "symbol table" data structure.

## Program Types

### Binary

A binary program is a sequence of text lines, each consisting of sixteen `0` & `1` characters representing an
instruction.
If the line starts with a `0`, then the instruction is an `A` instruction, otherwise it's a `C` instruction.

### Assembly

An assembly program is a sequence of text lines, with each line being an assembly instruction, a label declaration, or a
comment.

- Assembly Instruction: A symbolic `A` or `C` instruction
- Label Declaration: A text line of the form `(xxx)` where `xxx` is a symbol
- Comment: A line beginning with two-slashes (`//`) is considered to be a comment used for informational purposes and
  ignored by the compiler.

### Symbols

Symbols fall into three categories:

#### Predefined Symbols

Predefined symbols are symbols used to represent the memory addresses assigned to things such as registers, the
keyboard, and the screen to name a few.

#### Label Symbols

Label symbols are used to refer to the location in the ROM that holds the next instruction in the program. Label symbols
are defined once and can be used throughout an assembly program (even before the line at which the label symbol was
defined). Labels are often used to "jump" to a given instruction. Labels appear in assembly programs in this format:

```
...
(LOOP)
  ...
  
  @LOOP
  0;JMP
...
```

#### Variable Symbols

Any symbol that is not a predefined symbol or a label symbol is treated as a variable symbol.

### Syntax Conventions

#### Symbols

A symbol can be any sequence of letters, digits, underscore, dot, dollar sign, and colon that does not begin with a
digit.

#### Constants

May appear only in `A` instructions of the form `@xxx`. The constant `xxx` is a value in the range 0-32767 and is
written in decimal notation.

#### White Space

Leading space characters and empty lines are ignored.

#### Case Conventions

All assembly mnemonics (e.g. JEQ, A+1, and so on) must be written in uppercase. However, labels and variable names are
case-sensitive. The recommended convention is to use uppercase for labels and lowercase for variables.

## Assembly-to-Binary Translation

The assembler takes an input stream of assembly instructions and outputs a stream of translated binary instructions.

### Handling Assembly Instructions

For each assembly instruction, the assembler:

- Parses the instruction to its underlying fields
- For each field, generates the corresponding bit-code
- If the instruction contains a symbolic reference, resolves the symbol into its numeric value
- Assembles the resulting binary codes into a string of sixteen 0 and 1 characters
- Writes the assembled string to the output file

### Handling Symbols

A common assembler implementation is a _two-pass_ assembler that reads the code twice, from start to finish. In the
first pass, the assembler builds a `symbol table` and adds all the label symbols to said table. In the second pass, the
assembler handles the variable symbols and generates the binary code using the symbol table.

#### Initialization

The assembler creates a symbol table and populates it with all predefined symbols and their pre-allocated values.

#### First Pass

The assembler scans the entire assembly program, line by line, whilst keeping track of the current line number and
ignoring any comments from the line number count. Any labels are added to the symbol table with their corresponding line
number. No code is generated in the first pass.

#### Second Pass

The assembler scans the entire assembly program again and parses each line. Each time an `A` instruction is found, the
assembler looks it up un the symbol table, and if the value is found in the symbol table, the assembler replaces it with
its numeric value (sixteen 0s and 1s). Otherwise, if the value is not found in the symbol table, the assembler adds a
new entry (`<xxx, value>`) to the symbol table with the symbol (`xxx`) and the next available memory address (`value`)
in the memory block that is specifically designated for storing variables.
