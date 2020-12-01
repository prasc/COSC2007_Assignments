public class Node {
    private Character item;
    public Integer count;
    private Node leftChild;
    private Node rightChild;

    public Node(Integer count) {
        setItem(null);
        setRightChild(null);
        setLeftChild(null);
        this.count = count;
    }

    public Node (Character item, Integer count) {
        setItem(item);
        setRightChild(null);
        setLeftChild(null);
        this.count = count;
    }


    public void setItem(Character item)
    {
        this.item = item;
    }

    public Character getItem()
    {
        return this.item;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setLeftChild(Node n)
    {
        this.leftChild = n;
    }

    public Node getLeftChild()
    {
        return this.leftChild;
    }

    public void setRightChild(Node n)
    {
        this.rightChild = n;
    }

    public Node getRightChild()
    {
        return this.rightChild;
    }

}