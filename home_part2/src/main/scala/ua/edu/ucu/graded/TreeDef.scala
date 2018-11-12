package ua.edu.ucu.graded

object TreeDef {

  sealed trait Tree /* extends Traversable */ /* with Iterable */
  case class Node(value: Int, left: Tree, right: Tree) extends Tree
  case object End extends Tree

  object Node {
    // this is like additional constructor for case class e.g. Node(1)
    def apply(value: Int): Node = Node(value, End, End)
  }

  // TODO
  // Make Tree structure polymorphic by input element type
  // make it covariant by this type parameter

  // TODO
  // Write a function size that counts the number of nodes in arbitrary tree.

  // TODO
  // Write a function maximum that returns the maximum element in a Tree[Int]

  // TODO
  // Write a function depth that returns the maximum path length from the root of a tree to any leaf.

  // TODO
  // Symmetric binary trees.
  //     Let us call a binary tree symmetric if you can draw a vertical line
  //     through the root node and then the right subtree is the mirror image of
  //     the left subtree.  Add an isSymmetric method to the Tree class to check
  //     whether a given binary tree is symmetric.  Hint: Write an isMirrorOf
  //     method first to check whether one tree is the mirror image of another.
  //     We are only interested in the structure, not in the contents of the
  //     nodes.
  //
  //     scala> Node('a', Node('b'), Node('c')).isSymmetric
  //     res0: Boolean = true


  // TODO
  // Binary search tree
  // Write a function to add an element to a binary search tree.
  //
  //     addValue(End, 2)
  //     res0: Node[Int] = T(2 . .)
  //
  //     addValue(res0, 3)
  //     res1: Node[Int] = T(2 . T(3 . .))
  //
  //     addValue(res1, 0)
  //     res2: Node[Int] = T(2 T(0 . .) T(3 . .))
  //
  //     Use that function to construct a binary tree from a list of integers.
  //
  //     fromList(List(3, 2, 5, 7, 1))
  //     res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))
  //
  //     val sym = fromList(List(5, 3, 18, 1, 4, 12, 21))
  //     isSymmetric(sym)
  //     res4: Boolean = true
  //
  //     val nonSym = fromList(List(3, 2, 5, 7, 4))
  //     isSymmetric(nonSym)
  //     res5: Boolean = false


  // TODO
  // implement fromList which builds binary search tree. Hint: use foldLeft on the List
  //def fromList(l: List[Int]): Tree[Int] = ???
  //
}
