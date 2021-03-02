package com.sdl.lc.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterTypes {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer(replaceWithEmptyString = "[blank]")
    @DefaultDataTableCellTransformer(replaceWithEmptyString = "[blank]")
    public Object transformer(Object fromValue, Type toValueType) {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }

    @ParameterType(name = "list", value = "\"[\\d_,;:.{}+=~#$%`\\\\&\\-\\pL\\pM'!()<>\\s™®©?@^\\p{Sc}\\/؟]+\"")
    public List<String> list(String strings) {
        String s = strings; //CucumberTypeUtils.removeDoubleQuotes(strings);
        String first = s.substring(0, 1);
        String splitChar = ",";
        if (first.equals(";")) {
            splitChar = ";";
            s = s.substring(1);
        }
        return Arrays.stream(s.split(splitChar)).map(String::trim).collect(Collectors.toList());
    }
}
