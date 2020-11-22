package pl.novomatic.readers;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONReader {

    private IFileReader iFileReader;

    public JSONReader(IFileReader iFileReader) {
        this.iFileReader = iFileReader;
    }

    public JSONArray getJSONArrayFromFile() {
        InputStream is = getClass().getClassLoader().getResourceAsStream(iFileReader.getFilePath());
        JSONParser jsonParser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("There is error with reading data from file");
    }
}
