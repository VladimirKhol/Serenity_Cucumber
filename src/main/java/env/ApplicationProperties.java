package env;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utilities.ApplicationConstants;
import utilities.FileOperations;
import utilities.FilePathBuilder;

public class ApplicationProperties {

    private final Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);
    private String baseURL;
    private String path;

    private Map<String, String> additionalProps = null;

    protected ApplicationProperties() {
        additionalProps = new HashMap<>();
    }

    protected void loadProperties() {
        val fpb = new FilePathBuilder(ApplicationConstants.ENVIRONMENT_PROPS);
        fpb.setParentDirectory(ApplicationConstants.PROPERTIES_DIRECTORY);

        val envProps = fpb.getFilePath();
        logger.debug("Environment Properties Path {}", envProps);

        val fileOps = new FileOperations(new File(envProps));
        Map<String, String> props = fileOps.getPropValuesInMap();

        if (props == null) {
            logger.error("Failed to read the properties for the application from resource: " + envProps);
            return;
        }

        props.forEach((key, value) -> {
            if (ApplicationConstants.APPLICATION_BASE_URL.equals(key)) {
                setBaseURL(value);
            } else if (ApplicationConstants.PATH.equals(key)) {
                setPath(value);
            } else
                setProperty(key, value);
        });
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String path() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void setProperty(String key, String value) {
        additionalProps.put(key, value);
    }
}