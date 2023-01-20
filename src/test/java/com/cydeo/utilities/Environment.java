package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String BROWSER;
    public static final String URL;

    public static final String HR_EMAIL;
    public static final String HR_PASSWORD;

    public static final String MARKETING_EMAIL;
    public static final String MARKETING_PASSWORD;

    public static final String HELPDESK_EMAIL;
    public static final String HELPDESK_PASSWORD;

    public static Properties properties;

    static {

        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.getProperty("environment");
        //String environment = ConfigurationReader.get("environment");

        try {

            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";
            // /Users/HSN/IdeaProjects/CucumberProjectHsnAkd/src/test/resources/Environments/qa1.properties

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BROWSER = properties.getProperty("browser");
        URL = properties.getProperty("url");

        HR_EMAIL = properties.getProperty("hr.username");
        HR_PASSWORD = properties.getProperty("hr.password");

        MARKETING_EMAIL = properties.getProperty("marketing.username");
        MARKETING_PASSWORD = properties.getProperty("marketing.password");

        HELPDESK_EMAIL = properties.getProperty("helpdesk.username");
        HELPDESK_PASSWORD = properties.getProperty("helpdesk.password");
        }


}
