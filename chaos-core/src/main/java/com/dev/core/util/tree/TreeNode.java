package com.dev.core.util.tree;



import com.dev.core.util.CollUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassDescription:
 * @JdkVersion: 1.8
 * @Author: lmc
 * @email: mingchao.liu@greatdb.com
 * @Created: 2024/7/3 13:54
 */
public class TreeNode<I extends Serializable, N extends TreeNode<I, N>> implements Node, Tree<N>, Serializable {
    private static final long serialVersionUID = -6980883423724009918L;
    /**
     * 拥有的节点：子节点或叶子节点
     */
    private List<N> nodes = new ArrayList<>();
    /**
     * 父节点ID
     */
    private I pid;
    /**
     * 当前节点ID
     */
    private I id;

    private Integer sortNum = 0;
    /**
     * 树的节点总数（子节点+叶子节点），所有节点的度之和+1
     */
    private Integer treeNodeSize;

    public TreeNode<I,N> sort() {
        if (CollUtil.isEmpty(nodes)) {
            return this;
        }
        nodes = nodes.stream().sorted(Comparator.comparingInt(TreeNode::getSortNum)).collect(Collectors.toList());
        for (TreeNode<I, N> treeNode : nodes) {
            treeNode.sort();
        }
        return this;
    }

    @Override
    public boolean isRootNode() {
        return pid == null;
    }

    @Override
    public boolean isChildNode() {
        return pid != null && CollUtil.isNotEmpty(nodes);
    }


    @Override
    public void toTree() {
        //暂时先不做处理后期tree 有需要更多属性时在该方法扩展
    }

    @Override
    public void add(final N node) {
        if (node.getPid() == null) {
            node.setPid(this.id);
        }
        if (this.nodes.contains(node)) {
            throw new DuplicateNodeException(node.getId() + "");
        }
        this.nodes.add(node);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    protected void setPidNull() {
        this.pid = null;
    }

    public List<N> getNodes() {
        return nodes;
    }

    public void setNodes(List<N> nodes) {
        this.nodes = nodes;
    }

    public I getPid() {
        return pid;
    }

    public void setPid(I pid) {
        this.pid = pid;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getTreeNodeSize() {
        return treeNodeSize;
    }

    public void setTreeNodeSize(Integer treeNodeSize) {
        this.treeNodeSize = treeNodeSize;
    }
}
