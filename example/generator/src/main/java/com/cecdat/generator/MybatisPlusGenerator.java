package com.cecdat.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.dev.core.util.CollUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisPlusGenerator {
    private static final Logger log = LoggerFactory.getLogger(MybatisPlusGenerator.class);

    static String packageParent = MybatisPlusGenerator.class.getPackage().getName().replaceAll("\\.generator", "");

    public static void main(String[] args) {
        GeneratorConfig config = new GeneratorConfig();
        generator(config);
    }

    public static void generator(GeneratorConfig config) {
        if (StringUtils.isNotBlank(config.getBasePackage())){
            packageParent = config.getBasePackage();
        }
        String basePath = config.getBaseDir();
        String srcPath = basePath + "/src/main/java/";
        String mapperPath_MAPPER = basePath + "/src/main/resources/";
        AutoGenerator mpg = new AutoGenerator();

        /** 全局配置*/
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(pathUtil(srcPath));
        gc.setFileOverride(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(config.getAuthor());


        /** 自定义文件命名，注意 %s 会自动填充表实体属性！*/
        gc.setMapperName("%sDao");
        gc.setXmlName("%sDao");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        /** 数据源配置*/
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new PostgreSqlTypeConvert() {
        });
        dsc.setDriverName(config.getDriver());
        dsc.setUsername(config.getUserName());
        dsc.setPassword(config.getPassword());
        dsc.setUrl(config.getUrl());
        if (StringUtils.isNotBlank(config.getSchema())) {
            dsc.setSchemaName(config.getSchema());
        }
        dsc.setTypeConvert( new PostgreSqlTypeConvert(){
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                log.info("转换类型：" + fieldType);
                if (fieldType.contains("date") || fieldType.contains("time")){
                    return DbColumnType.DATE;
                }else {
                    return super.processTypeConvert(globalConfig, fieldType);
                }
            }
        });
        mpg.setDataSource(dsc);

        /** 策略配置  */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        if (CollUtil.isNotEmpty(config.getTableList())) {
            strategy.setInclude(config.getTableList());
        }
        strategy.setChainModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pkg = new PackageConfig();
        pkg.setParent(packageParent);
        pkg.setMapper("dao");
        pkg.setController("controller");
        mpg.setPackageInfo(pkg);

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        if (config.isCreateService()) {
            focList.add(new FileOutConfig("/genertemplates/service.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return pathUtil(srcPath + packageParent.replaceAll("\\.", "/") + "/service/I"
                            + tableInfo.getEntityName() + "Service.java");
                }
            });
            focList.add(new FileOutConfig("/genertemplates/serviceImpl.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return pathUtil(srcPath + packageParent.replaceAll("\\.", "/") + "/service/impl/"
                            + tableInfo.getEntityName() + "ServiceImpl.java");
                }
            });
        }

        if (config.isCreateController()) {
            focList.add(new FileOutConfig("/genertemplates/controller.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return pathUtil(srcPath + packageParent.replaceAll("\\.", "/") + "/controller/"
                            + tableInfo.getEntityName() + "Controller.java");
                }
            });
        }

        if (config.isCreateEntity()) {
            focList.add(new FileOutConfig("/genertemplates/entity.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return pathUtil(srcPath + packageParent.replaceAll("\\.", "/") + "/entity/"
                            + tableInfo.getEntityName() + ".java");
                }
            });

            focList.add(new FileOutConfig("/genertemplates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return pathUtil(mapperPath_MAPPER + "mapper/" + tableInfo.getEntityName() + "Dao.xml");
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        /** 关闭默认 xml 生成，调整生成 至 根目录  */
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setEntity(null);
        mpg.setTemplate(tc);
        /** 执行生成*/
        mpg.execute();
    }

    /**
     * @param path Unix 下的路径
     * @return 返回当前系统下的路径
     * @throws
     */
    private static String pathUtil(String path) {
        path = path.replaceAll("/", "\\" + File.separator);
        return path;
    }

}
