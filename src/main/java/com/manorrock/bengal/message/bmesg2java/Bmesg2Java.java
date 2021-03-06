package com.manorrock.bengal.message.bmesg2java;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

/**
 * The 'bmesg2java' CLI.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Command(name = "bmesg2java", description = "The Bengal Message to Java transpiler")
public class Bmesg2Java implements Callable<Integer> {

    /**
     * Stores the source files.
     */
    @Parameters(description = "The source file(s) to transpile")
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
                transpileFile(sourceFile);
            }
        } else {
            System.out.println("No source files found");
        }
        return result;
    }

    /**
     * Convert to nodes.
     * 
     * @param inputString the input string.
     */
    private List<Node> convertToNodes(String inputString) {
        return inputString
            .chars()
            .mapToObj(character -> new CharacterNode((char) character))
            .collect(Collectors.toList());
    }

    /**
     * Transpiler - phase 1.
     * 
     * @param inputList the input list.
     * @return the output list.
     */
    private List<Node> phase1(List<Node> inputList) {
        List<Node> result = new ArrayList<>();
        KeywordNode keyword = new KeywordNode("object");
        StringBuilder candidate = new StringBuilder();
        for(Node node : inputList) {
            candidate.append(node.toString());
            if (!keyword.getKeyword().startsWith(candidate.toString())) {
                result.addAll(convertToNodes(candidate.toString()));
                candidate.setLength(0);
            } else if (candidate.toString().equals(keyword.getKeyword())) {
                result.add(keyword);
                candidate.setLength(0);
            }
        }
        return result;
    }

    /**
     * Tranpsile the given file.
     * 
     * @throws IOException when an I/O error occurs.
     */
    private void transpileFile(String sourceFile) throws IOException {
        System.out.println("Transpiling - " + sourceFile);
        String sourceContent = new String(Files.readAllBytes(Paths.get(sourceFile)), UTF_8);
        String destinationFilename = sourceFile;
        destinationFilename = destinationFilename.substring(0, destinationFilename.lastIndexOf("."));
        destinationFilename = destinationFilename + ".java";
        PrintWriter destinationWriter = new PrintWriter(new FileWriter(new File(destinationFilename)));
        List<Node> nodes = convertToNodes(sourceContent);
        nodes = phase1(nodes);
        if (!nodes.isEmpty()) {
            for(Object node : nodes) {
                destinationWriter.print(node.toString());
            }
        }
        destinationWriter.flush();
    }

    /**
     * Main entrypoint for bmesg2java.
     *
     * @param arguments the command line arguments.
     */
    public static void main(String[] arguments) {
        System.exit(new CommandLine(new Bmesg2Java()).execute(arguments));
    }
}
