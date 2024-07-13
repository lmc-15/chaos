# [Tree模块&TreeUtils使用](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeUtils.java)

> [Tree模块&TreeUtils](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeUtils.java)提供了通过设置节点间的关联关系，构造无限级的树结构



## tree 模块

| 接口                                                         | 说明                         |
| :----------------------------------------------------------- | :--------------------------- |
| [Node](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/Node.java)<T> | 节点接口：用于描述节点的关系 |
| [Tree](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/Tree.java)<T> | 树接口                       |

| 类                                                           | 说明                                            |
| :----------------------------------------------------------- | :---------------------------------------------- |
| [TreeNode](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeNode.java)<N extends [TreeNode](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeNode.java)<N>> | 树节点 抽象的树的表达，具体的业务功能由子类实现 |
| [TreeUtils](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeUtils.java) | 树工具                                          |

| 异常错误                                                     | 说明         |
| :----------------------------------------------------------- | :----------- |
| [DuplicateNodeException](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/DuplicateNodeException.java) | 节点重复异常 |
| [UnBuiltTreeException](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/UnBuiltTreeException.java) | 树未构建异常 |



### 类 TreeNode<N extends TreeNode<N>>

- java.lang.Object
  - com.cecdat.core.util.tree.TreeNode<N>

  - 所有已实现的接口:

    [Node](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/Node.java)<N>, [Tree](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/Tree.java)<N>, java.io.Serializable, java.lang.Comparable<N>, java.lang.Iterable<N>

  ------

  ```
  public abstract class TreeNode<N extends TreeNode<N>>
  extends java.lang.Object
  implements Node<N>, Tree<N>, java.lang.Comparable<N>, java.io.Serializable
  ```

  树节点：抽象的树的表达，具体的业务功能由子类实现

  - **另请参阅:**

    [`TreeUtils.build(java.util.List)`](http://gitlab.cecdat.com/framework/backend/rock/blob/develop/core/src/main/java/com/cecdat/core/util/tree/TreeUtils.java), `Itr`, `TreeTest`

    #### 构造器概要

    | 构造器和说明                                                 |
    | :----------------------------------------------------------- |
    | `TreeNode(java.lang.Object id)`构造函数                      |
    | `TreeNode(java.lang.Object id, java.lang.Object pid)`构造函数 |
    | `TreeNode(java.lang.String id, java.lang.String pid, java.util.List nodes)` |

    #### 主要方法概要

    | 限定符和类型         | 方法和说明                                                   |
  | :------------------- | :----------------------------------------------------------- |
    | `void`               | `add(N node)`添加子节点或叶子节点                            |
    | `void`               | `addTo(N node)`将指定的节点添加到树的指定位置，添加到 node.pid指向的父节点的子节点列表的末尾 |
    | `boolean`            | `check()`检查树结构                                          |
    | `boolean`            | `contains(N n)`如果树包含指定的节点，则返回true              |
    | `boolean`            | `isBrotherOf(N target)`是否兄弟节点                          |
    | `boolean`            | `isChildNode()`是否子节点 除根节点之外，并且本身下面还连接有节点的节点 |
    | `boolean`            | `isChildOf(N target)`this是target的子节点                    |
    | `boolean`            | `isEmpty()`如果树不包含任何节点（除根节点），则返回true      |
    | `boolean`            | `isLeafNode()`是否叶子节点 本身下面不再连接有节点的节点，即末端 注：只有根节点的树，根节点也是叶子节点，度为0 |
    | `boolean`            | `isParentOf(N target)`this是target的父节点                   |
    | `boolean`            | `isRootNode()`是否根节点 根节点就是树的最顶端的节点          |
    | `java.util.Iterator` | `iterator()`内部实现迭代器 遍历逻辑： 1、先遍历根节点 2、按节点层次，从左至右遍历 |
    | `int`                | `size()`返回树的节点数                                       |
    | `void`               | `toTree()`树化                                               |
  
    #### 从接口继承的方法 java.lang.Iterable
  
    ```
    forEach, spliterator
    ```
  
    #### 从接口继承的方法 java.lang.Comparable
  
    ```
    compareTo
    ```
  

  

<!-- tabs:start -->

#### ** 使用TreeUtils构造一棵树 **

``` java
        // 节点列表
		List<SideBarTree> treeNodeList = new ArrayList<>();

        SideBarTree treeNode1 = new SideBarTree(0, "模块一");
        SideBarTree treeNode2 = new SideBarTree(1, 0, "name2");
        SideBarTree treeNode3 = new SideBarTree(2, 0, "name3");
        SideBarTree treeNode4 = new SideBarTree(3, 1, "name4");
        SideBarTree treeNode6 = new SideBarTree(5, 2, "name6");

        // 无子节点和叶子节点的单根节点树
        SideBarTree treeNode11 = new SideBarTree(11, "模块三");
        // 父节点找不到的单根节点树
        SideBarTree treeNode12 = new SideBarTree(12, 15, "模块四");
        // 节点ID和父节点ID一致的树
        SideBarTree treeNode13 = new SideBarTree(16, 16, "模块五");

        treeNodeList.add(treeNode1);
        treeNodeList.add(treeNode2);
        treeNodeList.add(treeNode3);
        treeNodeList.add(treeNode4);
        treeNodeList.add(treeNode6);
        treeNodeList.add(treeNode11);
        treeNodeList.add(treeNode12);
        treeNodeList.add(treeNode13);
        // 把树节点构造成树列表
        List<SideBarTree> trees = TreeUtils.build(treeNodeList);

 /**
  * 侧边栏树（树的具体实现）
  */
 static class SideBarTree extends TreeNode<SideBarTree> {
        /** 标题 */
        private String title;
        /**  展示顺序 */
        private int order;

        public SideBarTree(Object id, Object pid, String title) {
            super(id, pid);
            this.title = title;
            this.order = new Random().nextInt(100);
        }

        public SideBarTree(Object id, String title) {
            super(id);
            this.title = title;
            this.order = new Random().nextInt(100);
        }
     ...
 }
```

#### ** 手动构造一棵树 **

``` java
        SideBarTree tree = new SideBarTree(0, "模块一");

		// 添加子节点
        SideBarTree treeNode2 = new SideBarTree(1, 0, "name2");
        SideBarTree treeNode3 = new SideBarTree(2, 0, "name3");
        tree.add(treeNode2);
        tree.add(treeNode3);

		// 添加节点到指定位置
        SideBarTree treeNode4 = new SideBarTree(3, 1, "name4");
        SideBarTree treeNode5 = new SideBarTree(4, 1, "name5");
        SideBarTree treeNode6 = new SideBarTree(5, 2, "name6");
        SideBarTree treeNode7 = new SideBarTree(6, 2, "name7");
        SideBarTree treeNode17 = new SideBarTree(27, 2, "name7");
        tree.addTo(treeNode4);
        tree.addTo(treeNode5);
        tree.addTo(treeNode6);
        tree.addTo(treeNode7);
        tree.addTo(treeNode17);
		
		// 转化成树结构
        tree.toTree();


 /**
  * 侧边栏树（树的具体实现）
  */
 static class SideBarTree extends TreeNode<SideBarTree> {
        /** 标题 */
        private String title;
        /**  展示顺序 */
        private int order;

        public SideBarTree(Object id, Object pid, String title) {
            super(id, pid);
            this.title = title;
            this.order = new Random().nextInt(100);
        }

        public SideBarTree(Object id, String title) {
            super(id);
            this.title = title;
            this.order = new Random().nextInt(100);
        }
     ...
 }

```

<!-- tabs:end -->





**本页编辑**      **[@gongshiwen](http://192.168.1.23/gongshiwen)** <img src="http://192.168.1.23/uploads/-/system/user/avatar/10/avatar.png?width=100" style="zoom:10%;" /> 

