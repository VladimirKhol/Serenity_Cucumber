package env;

import lombok.val;

import java.io.File;

public enum Environment {
    INSTANCE;
    private ApplicationProperties appProps;
    private String resourcePath;

    Environment() {

    }

    public ApplicationProperties getApplicationProperties() {
        if (appProps == null) {
            appProps = new ApplicationProperties();
            appProps.loadProperties();
        }
        return appProps;
    }

    public String getResourcePath() {
        if (resourcePath == null) {
            val userDir = System.getProperty("user.dir");
            val projectResourcesPath = userDir.concat("/src/test/resources");
            val f = new File(projectResourcesPath);
            if (f.exists()) {
                resourcePath = projectResourcesPath;
            } else {
                resourcePath = userDir;
            }
        }
        return resourcePath;
    }
}