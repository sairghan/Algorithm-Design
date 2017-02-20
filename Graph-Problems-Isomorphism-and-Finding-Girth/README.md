# Graph-Problems-Isomorphism-and-Finding-Girth

This is one of my projects from Algorithm Design (INFSCI 2591) course. The projects in this course are relatively hard (many are NPC problems, this is NP-intermediate problem) and are very helpful as well. I have pushed the source code of this project onto Github.

# Graph isomorphism problem
This problem is a special case of the subgraph isomorphism problem. There is actually still a "unsolved problem in computer science":

     Can the graph isomorphism problem be solved in polynomial time?
     
This problem cannot even be solved by those remarkable scientists or mathematicians. I will discuss the very basic solution only - backtracking.

The idea of this problem is to check all edges of two graphs to see whether they are corresponding or not. If graph1 has an edge between vertices A and B, graph2 should also have an edge between some point M and N. And if graph1 doesn't have an edge between A and B, graph2 should also have no edge between corresponding points M and N. That is to say, we should backtrack all points of graph1 and graph2, and then checkEdges().

We use DFS to go through all vertices, using used[] to label a used vertex, and using perm[] to label permutations of the vertices.
 
    bool DFS(int n, int level, int[][] graph1, int[][] graph2, int[] used, int[] perm) {  
    bool result = false;
    if (level == -1) {
        result = checkEdges(n, graph1, graph2);
    } else {
        index i = 0;
        while (i < n && result == false) {
            if (used[i] == false) {
                used[i] = true;
                perm[level] = i;
                result = DFS(n, level - 1, graph1, graph2, used, perm);
            }
            i++;
        }
    }
    return result;
    }
    
 Then use checkEdges() to see whether these two graphs are actually the same or not.
 
     bool checkEdges(int n, int[][] graph1, int[][] graph2) {  
     bool same = true;
     for x = 0 to n - 1 {
        index y = 0;
        while (y > 0 && same == true) {
            if  (graph1[x][y] != graph2[perm[x]][perm[y]]) {
                same = false;
            }
            y++;
        }
      }
      return same;
     }
     
   The time complexity of this algorithm is O(N2*N!), where N is the number of vertices in graph1 and 2.
   
# Girth of Graph G
  
If we build a tree of a graph on a paper, using a random vertex as the root. We can see the smallest cycle straightforwardly. For example, the graph below:

![Preview](https://github.com/sairghan/Graph-Problems-Isomorphism-Finding-Girth/blob/master/img-path/Capture.PNG)


Use 1 as the root, let's build the corresponding small tree.

![Preview](https://github.com/sairghan/Graph-Problems-Isomorphism-and-Finding-Girth/blob/master/img-path/new.PNG)

As we can see above, the hierarchy is very clear, all we need to do is to BFS the tree, and find the node 2, which is the child node of 4 and 6. It is pretty easy to find such a node.

Before we start, we need to think that what data structure is suitable or easier for this task. We can store a vertex with its depth in the node like the pseudocode below.

    class Node {  
       public int vertex, depth;
       public Node(int vertex, int depth) {
        this.vertex = vertex;
        this.depth = depth;
      }
     }
     
In this task, like isomorphism problem, we still need a label[] array to label the used vertices. In Java, you can use ArrayDeque() to do this, or LinkedList() if you want. If you use C++, you can use std::queue<int>. The different names in these languages actually have similar functions, using which language is not a big deal.

Below is the main part of the BFS process.

![Preview](https://github.com/sairghan/Graph-Problems-Isomorphism-and-Finding-Girth/blob/master/img-path/BFS.PNG)            
                 
The time complexity of BFS is O(m + n), where m is the number of edges and n is the number of vertices. But we have an outer loop to try all vertex as the root, while(root < n - 2 && short > 3). So the time complexity is O(n * (m + n)).

# References:
 
     Wikipedia - Girth (graph theory)
     Wikipedia - Graph isomorphism problem
     cs.umu.se
     Optimal algorithm for finding the girth of a sparse graph? - Theoretical Computer Science
     StackOverflow
     Computing the girth of a graph
     jaspervdj/Genus
     Ullman’s Subgraph Isomorphism Algorithm
