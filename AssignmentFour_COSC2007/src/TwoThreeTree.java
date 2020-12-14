// Referenced Algorithms 4th edition Robert Sedwick

public class TwoThreeTree {

    private class Node {
        String itemOne;
        String itemTwo;
        Node leftChild;
        Node middleChild;
        Node rightChild;

        public Node(String itemOne) {
            this.itemOne = itemOne;
            leftChild = null;
            rightChild = null;
        }

        public Node(String itemOne, String itemTwo) {
            this.itemOne = itemOne;
            this.itemTwo = itemTwo;
            leftChild = null;
            middleChild = null;
            rightChild = null;
        }

        public String getItemOne() {
            return itemOne;
        }

        public String getItemTwo() {
            return itemTwo;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getMiddleChild() {
            return middleChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setMiddleChild(Node middleChild) {
            this.middleChild = middleChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static Node root;

    public TwoThreeTree() {
        this.root = null;
    }

    public Node search(String item) {
        Node curr = root;

        while (curr != null) {
            if (item.equals(curr.getItemOne())) {
                return curr;
            } else if (item.compareTo(curr.getItemOne()) < 0) {
                curr = curr.getLeftChild();
            } else if (item.compareTo(curr.getItemOne()) < 0 && item.compareTo(curr.getItemTwo()) > 0) {
                curr = curr.getMiddleChild();
            } else {
                curr = curr.getRightChild();
            }
        }
        return null;
    }

    public void delete(String item) {
        Node parent = root;
        Node curr = root;
        boolean isLeftChild = false;
        boolean isCenterChild = false;

        while (!item.equals(curr.getItemOne())) {
            parent = curr;

            if (item.compareTo(curr.getItemOne()) < 0) {
                isLeftChild = true;
                curr = curr.getLeftChild();
            } else if (item.compareTo(curr.getItemOne()) < 0 && item.compareTo(curr.getItemTwo()) > 0) {
                isCenterChild = true;
                curr = curr.getMiddleChild();
            } else {
                curr = curr.getRightChild();
            }

            if (curr == null) {
                return;
            }
        }

        // Case 1: Node to delete has no child
        if (curr.getLeftChild() == null && curr.getMiddleChild() == null && curr.getRightChild() == null) {
            if (curr == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.setLeftChild(null);
            } else if (isCenterChild) {
                parent.setMiddleChild(null);
            } else {
                parent.setRightChild(null);
            }
        }

        // Case 2: Node to delete has only one child

        else if (curr.getRightChild() == null) {
            if (curr == root) {
                root = curr.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(curr.getLeftChild());
            } else {
                parent.setRightChild(curr.getLeftChild());
            }
        } else if (curr.getLeftChild() == null) {
            if (curr == root) {
                root = curr.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(curr.getRightChild());
            } else {
                parent.setRightChild(curr.getRightChild());
            }
        } else if (curr.getLeftChild() != null && curr.getRightChild() != null) {
            Node replacement = getReplacement(curr);

            if (curr == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }
            replacement.setLeftChild(curr.getLeftChild());
        }
    }

    public Node getReplacement(Node nodeToBeDeleted) {
        Node replacement = null;
        Node replacementParent = null;
        Node curr = nodeToBeDeleted.getRightChild();

        while (curr != null) {
            replacementParent = replacement;
            replacement = curr;
            curr = curr.getLeftChild();
        }

        if (replacement != nodeToBeDeleted.getRightChild()) {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(nodeToBeDeleted.getRightChild());
        }

        return replacement;
     }

     public void insert(String itemOne, String itemTwo) {
        if (itemOne != null && itemTwo != null) {
            Node newNode = new Node(itemOne);

            if (root == null) {
                root = newNode;
                return;
            }

            Node curr = root;
            Node parent = null;

            while (true) {
                parent = curr;

                if (itemOne.compareTo(curr.getItemOne()) < 0) {
                    curr = curr.getLeftChild();

                    if (curr == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    curr = curr.getRightChild();

                    if (curr == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        } else {
            Node newNode = new Node(itemOne, itemTwo);

            if (root == null) {
                root = newNode;
                return;
            }

            Node curr = root;
            Node parent = null;

            while (true) {
                parent = curr;
                if (itemOne.compareTo(curr.getItemOne()) < 0) {
                    curr = curr.getLeftChild();
                    if (curr == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else if (itemOne.compareTo(curr.getItemOne()) > 0 && itemTwo.compareTo(curr.getItemTwo()) < 0) {
                    curr = curr.getMiddleChild();
                    if (curr == null) {
                        parent.setMiddleChild(newNode);
                        return;
                    }
                } else {
                    curr = curr.getRightChild();
                    if (curr == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
     }

     public void inOrderDisplay(Node curr) {

        if (curr != null) {
            if (curr.getItemTwo() == null) {
                    inOrderDisplay(curr.getLeftChild());
                    System.out.print(", " + curr.getItemOne());
                    inOrderDisplay(curr.getRightChild());

            } else {

                    inOrderDisplay(curr.getLeftChild());
                    System.out.print(", " + curr.getItemOne());
                    inOrderDisplay(curr.getMiddleChild());
                    System.out.print(", " + curr.getItemTwo());
                    inOrderDisplay(curr.getRightChild());
            }
        }
     }

    public void preOrderDisplay(Node curr) {
        if (curr != null) {
            if (curr.getItemTwo() == null) {
                System.out.print(", " + curr.getItemOne());
                preOrderDisplay(curr.getLeftChild());
                preOrderDisplay(curr.getRightChild());
            } else {
                System.out.print(", " + curr.getItemOne());
                System.out.print(", " + curr.getItemTwo());
                preOrderDisplay(curr.getLeftChild());
                preOrderDisplay(curr.getMiddleChild());
                preOrderDisplay(curr.getRightChild());

            }
        }
    }

}