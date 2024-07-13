package com.dev.core.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public class TreeUtils {
    private TreeUtils() {
    }

    /**
     * 把树节点构造成树列表
     *
     * @param treeNodes 树节点
     * @param <N>       node节点
     * @return 树列表
     */
    public static <I extends Serializable, N extends TreeNode<I, N>> List<N> build(List<N> treeNodes) {
        return build(treeNodes, true);
    }

    /**
     * 把树节点构造成树列表
     *
     * @param treeNodes 树节点
     * @param <N>       node节点
     * @return 树列表
     */
    public static <I extends Serializable, N extends TreeNode<I, N>> List<N> build(List<N> treeNodes, boolean isSort) {
        List<N> treeList = new ArrayList<>();
        if (treeNodes == null || treeNodes.isEmpty()) {
            return treeList;
        }
        TreeNode<I, N> rootNode = buildRootNode(treeList);
        Map<I, N> nodeMap = treeNodes.stream().collect(Collectors.toMap(N::getId, node -> node));
        nodeMap.forEach((id, node) -> {
            I pid = node.getPid();
            if (nodeMap.containsKey(pid)) {
                node.setPidNull();
                nodeMap.get(pid).add(node);
            } else {
                treeList.add(node);
            }
        });
        return isSort ? rootNode.sort().getNodes() : rootNode.getNodes();
    }

    private static <N extends TreeNode<I, N>, I extends Serializable> TreeNode<I, N> buildRootNode(List<N> treeList) {
        TreeNode<I, N> rootNode = new TreeNode<>();
        rootNode.setNodes(treeList);
        return rootNode;
    }


}
