package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperations {
    private final Logger logger = LoggerFactory.getLogger(FileOperations.class);
    private File fileObj;

    public FileOperations(File file) {
        this.fileObj = file;
    }

    private List<String> readFileLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileObj))) {
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            logger.error("Failed to read the properties from file {}", fileObj.getAbsolutePath(), e);
        }
        return lines;
    }

    public Map<String, String> getPropValuesInMap() {
        Map<String, String> propValues = new HashMap<>();
        val data = readFileLines();
        logger.debug("Total Lines read in properties: " + data.size());
        for (String props : data) {
            if (props == null || props.startsWith("#") || (props.indexOf('=') == -1))
                continue;

            val index = props.indexOf('=');
            logger.debug("Property: {}", props);
            val key = props.substring(0, index).trim();
            val value = props.substring(index + 1).trim();
            propValues.put(key, value);
        }
        logger.debug("alert messages properties file reading is completed.");
        return propValues;
    }
}