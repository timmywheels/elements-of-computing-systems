# Boolean Arithmetic

## HalfAdder
The **HalfAdder** chip is used to add binary digits and output a 2-bit number.

### HalfAdder Chip API
|Key|Value|
|---|---|
|Input| `a`, `b` |
|Output| `carry`, `sum` |
|Function| `sum = LSB of a + b, carry = MSB of a + b` |

### HalfAdder Truth Table
| A | B | Carry | Sum |
|---|---|---|---|
| 0 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 |
| 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 0 |

### HalfAdder Chip Diagram
![HalfAdder Chip Diagram](../static/02-boolean-arithmetic/half-adder.png)

## FullAdder
The **FullAdder** chip is designed to sum 3 bits, `a`, `b`, and `c`. This is a composite chip where this particular implementation is comprised of 2 **HalfAdder** chips and an **Or** chip.

### FullAdder Chip API
|Key|Value|
|---|---|
|Input| `a`, `b`, `c` |
|Output| `carry`, `sum` |
|Function| `sum = LSB of a + b + c, carry = MSB of a + b + c` |

### FullAdder Truth Table
| A | B | C | Carry | Sum |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 0 | 1 | 0 | 1 |
| 1 | 0 | 0 | 0 | 1 |
| 0 | 1 | 1 | 1 | 0 |
| 1 | 0 | 0 | 0 | 1 |
| 1 | 0 | 1 | 1 | 0 |
| 1 | 1 | 0 | 1 | 0 |
| 1 | 1 | 1 | 1 | 1 |

### FullAdder Chip Diagram
![FullAdder Chip Diagram](../static/02-boolean-arithmetic/full-adder.png)

## Adder (16-bit)
The **Adder** chip is designed to two 16-bit inputs, `a` and `b`. This is a composite chip where this particular implementation is comprised of 1 **HalfAdder** chip and 15 **FullAdder** chips, though there are a handful of other possible implementations.

### Adder Chip API
|Key|Value|
|---|---|
|Input| `a[16]`, `b[16]` |
|Output| `out[16]` |
|Function| `sum = a + b, overflow bit is ignored` |

### Adder Chip Diagram
![Adder Chip Diagram](../static/02-boolean-arithmetic/adder.png)

## Incrementer (16-bit)
The **Incrementer** chip is designed to add `inc` (`1`) to a 16-bit input, `a`. In this example diagram, the input `inc` is always fixed to 16-bit binary representation of `1`.

### Incrementer Chip API
|Key|Value|
|---|---|
|Input| `a[16]`, `inc` |
|Output| `out[16]` |
|Function| `sum = a + inc (1), overflow bit is ignored` |

### Incrementer Chip Diagram
![Incrementer Chip Diagram](../static/02-boolean-arithmetic/incrementer.png)

