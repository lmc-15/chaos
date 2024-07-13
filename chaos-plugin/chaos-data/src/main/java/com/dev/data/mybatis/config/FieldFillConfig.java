package com.dev.data.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.StrictFill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <code>FieldFillConfig</code>
 *
 * @author    dengrijin
 * @version  v0.1 2020/06/30
 *
 * @since    JDK1.8
 */
public class FieldFillConfig {
    protected final List<StrictFill> strictFills = new ArrayList<>();

    public FieldFillConfig() {
        strictFills.add(StrictFill.of("createdTime", Date.class, Date::new));
        strictFills.add(StrictFill.of("updatedTime", Date.class, Date::new));
        strictFills.add(StrictFill.of("deleteStatus", Integer.class, 0));
        strictFills.add(StrictFill.of("deleted", Integer.class, 0));
    }

    public List<StrictFill> getStrictFills() {
        return strictFills;
    }
}
