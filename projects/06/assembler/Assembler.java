package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Assembler {
    String filePath;

    HashMap<String, String> symbolTable = new HashMap<String, String>();


    public Assembler(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.init();
    }

    public void init() throws FileNotFoundException {
        File file = new File(this.filePath);
        Scanner fileReader = new Scanner(file);

        String commentIndicator = "//";
        String symbolPrefix = "@";

        if (file.exists()) {
            System.out.println("File found");

            while (fileReader.hasNext()) {
                String data = fileReader.nextLine();
                String trimmedData = data.trim();
                InstructionType instructionType;

                if (trimmedData.startsWith(commentIndicator)) {
                    System.out.printf("Comment found: %s\n", trimmedData);
                } else {
                    // TODO
                    instructionType = this.getInstructionType(trimmedData);

                }
            }

        } else {
            System.out.printf("File does not exist: %s\n",  this.filePath);
        }
    }

    public void parseInstruction(String instruction) {
        // TODO
    }

    public void lookupInstructionInSymbolTable (String instruction) {
        // TODO
    }

    public void addToSymbolTable (String instruction) {
        // TODO
    }

    public InstructionType getInstructionType(String instruction) {
        String trimmedInstruction = instruction.trim();
        if (trimmedInstruction.startsWith("//") || trimmedInstruction.isBlank()) {
            System.out.printf("Ignored Instruction: %s\n", trimmedInstruction);
            return InstructionType.IGNORED;
        }
        if (trimmedInstruction.startsWith("(") && trimmedInstruction.endsWith(")")) {
            System.out.printf("L Instruction: %s\n", trimmedInstruction);
            return InstructionType.L_INSTRUCTION;
        } else if (trimmedInstruction.startsWith("@")) {
            try {
                String possibleDecimalInstruction = trimmedInstruction.substring(1);
                Integer decimalInstruction = Integer.parseInt(possibleDecimalInstruction);
                System.out.printf("A Instruction: %s\n", trimmedInstruction);
                return InstructionType.A_INSTRUCTION;
            } catch (NumberFormatException ex) {
                System.out.printf("Instruction unable to be converted to decimal: %s\n", trimmedInstruction);
            }
        }
        System.out.printf("C Instruction: %s\n", trimmedInstruction);
        return InstructionType.C_INSTRUCTION;
    }
}

