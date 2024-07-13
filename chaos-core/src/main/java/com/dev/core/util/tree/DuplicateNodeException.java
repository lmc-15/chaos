package com.dev.core.util.tree;

import com.dev.core.exception.ServerException;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public class DuplicateNodeException extends ServerException {

    private static final long serialVersionUID = 7318418445775797251L;

    public DuplicateNodeException(String msg) {
        super(505, "树构建异常,请检查节点的关系,是否存在重复节点:" + msg);
    }
}
