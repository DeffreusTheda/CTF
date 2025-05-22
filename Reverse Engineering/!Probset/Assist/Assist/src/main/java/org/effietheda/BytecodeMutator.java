package org.effietheda;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.Opcode;

import java.nio.file.Paths;
import java.util.Random;

public class BytecodeMutator {
  public static void main(String[] args) throws Exception {
    String className = "org.effietheda.FlagChecker"; // Fully qualified name
    String classPath = Paths.get("build/classes/java/main").toAbsolutePath().toString();
    
    // Load the class using Javassist
    ClassPool pool = ClassPool.getDefault();
    pool.insertClassPath(classPath);
    CtClass ctClass;
    try {
      ctClass = pool.get(className);
    } catch (NotFoundException e) {
      System.out.println("Class not found: " + className);
      System.out.println("Working Directory = " + System.getProperty("user.dir"));
      return;
    }
    
    // Get the main method
    CtMethod mainMethod = ctClass.getDeclaredMethod("main");
    
    // Convert method to bytecode instruction list
    CodeAttribute codeAttr = mainMethod.getMethodInfo().getCodeAttribute();
    CodeIterator iterator = codeAttr.iterator();
    
    // Seeded random (for deterministic mutations)
    Random rand = new Random(System.currentTimeMillis() / 1000); // Changes every second
    
    while (iterator.hasNext()) {
      int index = iterator.next();
      int opcode = iterator.byteAt(index);
      
      // Example Mutation: Modify jump instructions randomly
      if (opcode == Opcode.IFEQ || opcode == Opcode.IFNE) {
        int newOffset = rand.nextInt(20) - 10; // Small chaos in jump offset
        iterator.write16bit(newOffset, index + 1);
      }
      
      // Example Corruption: If opcode is RETURN, replace with a random instruction
//      if (opcode == Opcode.RETURN) {
//        iterator.writeByte(Opcode.NOP, index); // Sometimes replace RETURN with NOP (subtle)
//      }
    }
    
    // Save mutated class
    ctClass.writeFile();
    System.out.println("✅ Bytecode mutated! Run the class again.");
  }
}
