package com.gulaev.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class FileReader {


  public static Set<String> getWordsFromFile() throws IOException {
    File input = new File(
        "/Users/denisgulaev/Documents/projects/Java Automation Task/Library/src/main/resources/input.txt");
    String content = FileUtils.readFileToString(input, "UTF-8");

    String[] words = StringUtils.split(content, " ");
    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

    FileUtils.writeStringToFile(new File(
            "/Users/denisgulaev/Documents/projects/Java Automation Task/Library/src/main/resources/output.txt"),
        "Number of unique words: " + uniqueWords.size(), "UTF-8");
    return uniqueWords;
  }
}
