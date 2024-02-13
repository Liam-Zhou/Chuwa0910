### Consider an undirected graph G with n verticles and e edges. What is the time taken by Depth First Tree if the graph is represented by (i)adjaceny matrix and (ii)adjacent list?

O(n^2), O(n + e)
Adjacency Matrix:
For an adjacency matrix representation, each vertex maintains an array or matrix of size n×n to represent the edges between vertices.
In DFS using an adjacency matrix, for each vertex, the algorithm needs to visit all n vertices to check for adjacent vertices.
O(n)
Adjacency List:
In the worst-case scenario, where each vertex has an edge to every other vertex (dense graph), the total number of edges e is O(n2).
However, in a sparse graph where the number of edges is much less than n^2, the time complexity is typically O(n+e), which is more efficient.

### AVL Tree

AVL 树是计算机科学中最早被发明的自平衡二叉查找树。在 AVL 树中，任一节点对应的两棵子树的最大高度差为 1，因此它也被称为高度平衡树。
