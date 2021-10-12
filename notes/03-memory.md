# Memory

## Bit
The **Bit** chip a.k.a the 1-bit **Register** is designed to hold a 1-bit value, `0` or `1`, over time. If the `load` bit is present, then
the output will equal whatever the value of `in` is after the current clock cycle, otherwise `out` remains the same.

### Bit Chip API
|Key|Value|
|---|---|
|Input| `in`, `load` |
|Output| `out` |
|Function| `if load(t) then out(t+1) = in(t) else out(t+1) = out(t)` |

### Bit Chip Diagram
![Bit Chip Diagram](../static/03-memory/bit.png)

## Register


### Register Chip API
|Key|Value|
|---|---|
|Input| `in[16]`, `load` |
|Output| `out[16]` |
|Function| `if load(t) then out(t+1) = in(t) else out(t+1) = out(t)` |

### Register Chip Diagram
![Register Chip Diagram](../static/03-memory/register.png)