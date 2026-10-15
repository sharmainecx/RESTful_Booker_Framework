package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.testng.internal.protocols.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class XMLDataReader {


    public static Map<String, Object> readBooking(String fileName) throws IOException {
        InputStream in = XMLDataReader.class.getClassLoader().getResourceAsStream(fileName);
        return new XmlMapper().readValue(in, new TypeReference<Map<String, Object>>() {});
    }

    public static List<Map<String, Object>> readBookings(String fileName) throws IOException{
        InputStream in = XMLDataReader.class.getClassLoader().getResourceAsStream(fileName);
        return new XmlMapper().readValue(in, new TypeReference<List<Map<String, Object>>>() {});
    }

    public static String toXml(String rootName, Map<String, Object> data) throws IOException {
        return new XmlMapper().writer().withRootName(rootName).writeValueAsString(data);
    }

}
