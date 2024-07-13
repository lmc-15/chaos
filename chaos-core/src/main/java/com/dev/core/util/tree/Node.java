package com.dev.core.util.tree;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public interface Node {

    /**
     * 是否根节点
     * 根节点就是树的最顶端的节点
     *
     * @return true是，false 否
     */
    boolean isRootNode();


    /**
     * 是否子节点
     * 除根节点之外，并且本身下面还连接有节点的节点
     *
     * @return true是，false 否
     */
    boolean isChildNode();

}
