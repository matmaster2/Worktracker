package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class IFileReader {

    public abstract String getFilePath();

    JSONArray getJSONArrayFromFile() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(getFilePath());
        JSONParser jsonParser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("There is error with reading data from file");
    }

}
