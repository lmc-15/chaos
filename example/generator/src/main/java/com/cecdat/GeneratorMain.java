package com.cecdat;

import com.cecdat.generator.GeneratorConfig;
import com.cecdat.generator.MybatisPlusGenerator;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * <code>GeneratorMain</code>
 *
 * @author dengrijin
 * @version v0.1 2020/07/08
 * @see
 * @since JDK1.8
 */

public class GeneratorMain {

    public static void main(String[] args) throws Exception {
        GeneratorConfig config = new GeneratorConfig();
        System.out.println(config.getModuleName());
        MybatisPlusGenerator.generator(config);
        generateMaven(config);
        generateMain(config);
        copyConfigs(config);
    }

    private static void copyConfigs(GeneratorConfig config) throws IOException {
        File dir = ResourceUtils.getFile("classpath:");
        String[] list = dir.list((dir1, name) -> {
            if (name.endsWith("yml") && !name.equals("generator.yml")) {
                return true;
            }
            if (name.equals("logback-spring.xml")) {
                return true;
            }
            return false;
        });
        List<String> configList = Arrays.asList(list);
        configList.forEach(file -> copyFile(config, file));
    }

    private static void copyFile(GeneratorConfig config, String filename) {
        FileSystem fileSystem = FileSystems.getDefault();
        Resource resource = new ClassPathResource(filename);
        String srcPath = config.getBaseDir() + "/src/main/resources/" + filename;
        try {
            Files.copy(fileSystem.getPath(resource.getFile().getAbsolutePath()), fileSystem.getPath(srcPath), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateMain(GeneratorConfig config) throws IOException {
        String name = config.getModuleName();
        String appName = name.substring(0, 1).toUpperCase() + name.substring(1) + "App";
        String srcPath = config.getBaseDir() + "/src/main/java/com/cecdat" + File.separator + appName + ".java";

        BufferedWriter writer = new BufferedWriter(new FileWriter(srcPath));
        writer.write("package com.cecdat;\n" +
                "\n" +
                "import org.mybatis.spring.annotation.MapperScan;\n" +
                "import org.springframework.boot.SpringApplication;\n" +
                "import org.springframework.boot.autoconfigure.SpringBootApplication;\n");

        writer.write(" \n" +
                "@SpringBootApplication\n" +
                "@MapperScan(\"com.cecdat.server.**.dao*\")\n");
        writer.write("public class " + appName);
        writer.write(" {\n" +
                "    public static void main(String[] args ) {\n");
        writer.write("        SpringApplication.run(" + appName + ".class, args);\n");
        writer.write("    }\n" +
                "}\n");
        writer.close();
    }

    private static void generateMaven(GeneratorConfig config) throws Exception {
        String pomFile = config.getBaseDir() + File.separator + "pom.xml";
        Resource resource = new ClassPathResource("genertemplates/pom.xml.template");
        Model pomModel = new MavenXpp3Reader().read(new FileReader(resource.getFile()));
        pomModel.setName(config.getModuleName());
        pomModel.setArtifactId(config.getModuleName());
        List<Dependency> dependencies = new ArrayList<>();
        Dependency core = new Dependency();
        core.setArtifactId("core");
        core.setGroupId("com.cecdat");
        dependencies.add(core);
        Dependency web = new Dependency();
        web.setArtifactId("web");
        web.setGroupId("com.cecdat");
        dependencies.add(web);
        Dependency data = new Dependency();
        data.setArtifactId("data");
        data.setGroupId("com.cecdat");
        dependencies.add(data);
        Dependency lombok = new Dependency();
        lombok.setArtifactId("lombok");
        lombok.setGroupId("org.projectlombok");
        dependencies.add(lombok);
        pomModel.setDependencies(dependencies);
        new MavenXpp3Writer().write(new FileWriter(pomFile), pomModel);
    }
}
