package utilities;

import java.io.File;

import env.Environment;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilePathBuilder {
    private final Logger logger = LoggerFactory.getLogger(FilePathBuilder.class);
    private boolean loadFromApplicationPath = true;
    private String resourceName;
    private String parentDirectory;

    public FilePathBuilder(String resName) {
        logger.debug("File Path Builder initialized to build the path for resource: " + resName);
        this.resourceName = resName;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getFilePath() {
        val builder = new StringBuilder();
        if (loadFromApplicationPath) {
            logger.debug("Resource is set to load from Application Path.");
            builder.append(Environment.INSTANCE.getResourcePath()).append(File.separatorChar);
        }

        if (parentDirectory != null) {
            builder.append(parentDirectory).append(File.separatorChar);
        }

        builder.append(resourceName);

        return builder.toString();
    }
}