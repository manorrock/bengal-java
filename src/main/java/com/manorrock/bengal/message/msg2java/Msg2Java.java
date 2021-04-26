package com.manorrock.bengal.message.msg2java;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "bmsg2java", description = "The Bengal Message to Java compiler")
public class Msg2Java implements Callable<Integer> {

    /**
     * Stores the source files.
     */
    @Parameters(description = "The source file(s) to process")
    List<String> sourceFiles;

    /**
     * Call the command.
     * 
     * @return the status code.
     */
    public Integer call() throws Exception {
        int result = 0;
        if (sourceFiles != null) {
            for (String sourceFile : sourceFiles) {
                compileFile(sourceFile);
            }
        } else {
            System.out.println("No source files found");
        }
        return result;
    }

    /**
     * Compile the given file.
     * 
     * @throws IOException when an I/O error occurs.
     */
    private void compileFile(String sourceFile) throws IOException {
        System.out.println("Compiling - " + sourceFile);
        String sourceContent = new String(Files.readAllBytes(Paths.get(sourceFile)), UTF_8);
        String destinationFilename = sourceFile;
        destinationFilename = destinationFilename.substring(0, destinationFilename.lastIndexOf("."));
        destinationFilename = destinationFilename + ".java";
        PrintWriter destinationWriter = new PrintWriter(new FileWriter(new File(destinationFilename)));
        destinationWriter.println(sourceContent);
        destinationWriter.flush();
    }

    /**
     * Main entrypoint for msg2java.
     *
     * @param arguments the command line arguments.
     */
    public static void main(String[] arguments) {
        System.exit(new CommandLine(new Msg2Java()).execute(arguments));
    }
}
