
package com.dev.data.mybatis.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/**
 * MyMetaObjectHandler
 *
 * @author dengrijin
 * @version v0.1 2020/07/16
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    final FieldFillConfig fillConfig;

    public MyMetaObjectHandler(FieldFillConfig fillConfig) {
        this.fillConfig = fillConfig;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        fillConfig.getStrictFills()
                .forEach(s -> strictInsertFill(metaObject, s.getFieldName(), s.getFieldType(), s.getFieldVal().get()));
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        fillConfig.getStrictFills()
                .forEach(s -> strictUpdateFill(metaObject, s.getFieldName(), s.getFieldType(), s.getFieldVal().get()));
    }
}
