package com.cecdat.generator;


import com.dev.core.util.CollUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;


public class GeneratorConfig {
    final static String SUFFIX = ".yml";

    String author;
    String moduleName;
    String baseDir;
    String url;
    String driver;
    String userName;
    String password;
    String schema;
    String basePackage;
    String[] tableList;
    boolean isCreateService = true;
    boolean isCreateController = false;
    boolean isCreateEntity = true;


    public Properties parseYaml(String filename) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        String path = filename.concat(SUFFIX);
        yaml.setResources(new ClassPathResource(path));
        Properties prop = yaml.getObject();
        return prop;
    }

    public GeneratorConfig(String configFile) {
        Properties base = parseYaml(configFile);

        Properties config = new Properties();
        config.putAll(base);
        String dataBaseFile = findDatabase(config);
        Properties dateBase = parseYaml(dataBaseFile);
        config.putAll(dateBase);

        init(config);

        if (StringUtils.isBlank(baseDir)) {
            if (StringUtils.isBlank(moduleName)) {
                baseDir = findBaseDir();
            }else {
                baseDir = new File(findBaseDir()).getParentFile().getAbsoluteFile() + File.separator + moduleName;
            }
        }
    }

    private String findDatabase(Properties config) {
        String prefix = "application-";
        String database = config.getProperty("database");
        if (CollUtil.isEmpty(database)) {
            database = "datasource-dev";
        }
        return prefix.concat(database);
    }

    private void init(Properties config) {
        this.author = config.getProperty("author");
        this.basePackage = config.getProperty("basePackage");
        this.url = config.getProperty("spring.datasource.url");
        this.driver = config.getProperty("spring.datasource.driverClassName");
        this.userName = config.getProperty("spring.datasource.username");
        this.password = config.getProperty("spring.datasource.password");
        this.moduleName = config.getProperty("moduleName");
        this.schema = parseSchema();
        String tables = config.getProperty("tables");
        if (CollUtil.isNotEmpty(tables.trim())) {
            this.tableList = tables.replaceAll(" ", "").split(",");
        }
    }

    private String parseSchema() {
        String url = this.url;
        if (StringUtils.isEmpty(url.trim())) {
            return null;
        }

        String[] temps = url.split("currentSchema=");
        if (temps.length < 2) {
            return null;
        }
        String schema = temps[1].split("=")[0].split("&")[0];
        return schema;
    }

    public GeneratorConfig() {
        this("generator");
    }

    private static String findBaseDir() {
        try {
            URI uri = Thread.currentThread().getContextClassLoader().getResource("").toURI();
            File file = new File(uri);
            String path = file.getAbsolutePath().split("target")[0];
            return path;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String getSUFFIX() {
        return SUFFIX;
    }

    public String getAuthor() {
        return author;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSchema() {
        return schema;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String[] getTableList() {
        return tableList;
    }

    public boolean isCreateService() {
        return isCreateService;
    }

    public boolean isCreateController() {
        return isCreateController;
    }

    public boolean isCreateEntity() {
        return isCreateEntity;
    }

    public static void main(String[] args) {
        GeneratorConfig config = new GeneratorConfig();
    }
}
