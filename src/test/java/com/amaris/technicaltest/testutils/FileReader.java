package com.amaris.technicaltest.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class FileReader {

    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static String readAsString(String path) throws IOException {
        return new String(FileReader.class.getClassLoader().getResourceAsStream(path).readAllBytes());
    }

    public static <T> T readAsObject(String path, Class<T> clazz) throws IOException {
        return mapper.readValue(FileReader.class.getClassLoader().getResourceAsStream(path), clazz);
    }

}
