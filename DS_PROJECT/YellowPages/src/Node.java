public class Node {
    Person data;
    Node left, right;

    public Node(Person p)
    {
        data = p;
        left = right = null;
    }

    public Person getData(){
        return data;
    }

    public void setData(Person p){
        data=p;
    }

    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
