package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JSONDataReader {

    public static Map<String, Object> readBooking(String fileName) throws IOException {
        InputStream in = JSONDataReader.class.getClassLoader().getResourceAsStream(fileName);
        return new ObjectMapper().readValue(in, new TypeReference <Map<String, Object>>() {});
    }
}
