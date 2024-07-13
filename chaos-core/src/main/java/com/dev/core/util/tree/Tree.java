package com.dev.core.util.tree;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public interface Tree<T> {


    /**
     * 转化成树（计算树的属性值等）
     */
    void toTree();

    /**
     * 将指定的节点添加到树子节点列表的末尾
     *
     * @param node 子节点
     */
    void add(T node);




    /**
     * 如果树不包含任何节点（除根节点），则返回true
     *
     * @return 如果树不包含任何节点（除根节点），则返回true
     */
    boolean isEmpty();

}
