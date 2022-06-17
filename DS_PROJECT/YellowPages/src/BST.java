class BST {
    Node root;

    BST()
    {
        root = null;
    }


    public void insert(Person key)
    {
        Node n=new Node(key);
        if (root==null) root=n;
        else{
            Node temp=root;
            Node p=root;
            while (temp!=null){
                p=temp;
                if (key.phone_number.compareTo(temp.data.phone_number)<0) temp=temp.left;
                else temp=temp.right;
            }
            if (key.phone_number < p.data.phone_number) p.left=n;
            else p.right=n;
        }
    }


    public String MakeString() {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        MakeString(root,sb);
        return sb.toString();
    }

    private void MakeString(Node root,StringBuilder sb) {

        sb.append(root.data.name).append("\n").append(root.data.phone_number).append("\n")
                .append(root.data.email).append("\n").append(root.data.address).append("\n");
        if (root.left != null) MakeString(root.left,sb);
        if (root.right != null) MakeString(root.right,sb);
    }



    public void delete(Long data) {

        deleteNode(this.root, data);
    }

    private Node deleteNode(Node root, Long data) {

        if(root == null) return root;

        if(data.compareTo(root.getData().phone_number)<0) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(data.compareTo(root.getData().phone_number)>0) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if(root.getLeft() == null && root.getRight() == null) {
                // System.out.println("deleting "+data);
                return null;
            } else if(root.getLeft() == null) {
                // node with one node (no left node)
                //  System.out.println("deleting "+data);
                return root.getRight();
            } else if(root.getRight() == null) {
                // node with one node (no right node)
                //System.out.println("deleting "+data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Long minValue = minValue(root.getRight());
                Node minNode=minNode(root.getRight());
                Person c=new Person();
                c.setAddress(minNode.data.address);
                c.setEmail(minNode.data.email);
                c.setName(minNode.data.name);
                c.setPhone_number(minValue);
                root.setData(c);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }
        return root;
    }

    private Node minNode(Node node){
        if(node.getLeft() != null) {
            return minNode(node.getLeft());
        }
        return node;
    }
    private Long minValue(Node node) {

        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getData().phone_number;
    }


    public Node find(Long key){
        Node temp = root;
        while(temp != null){
            if(key.compareTo(temp.data.phone_number) < 0){
                temp = temp.left;
            } else if(key.compareTo(temp.data.phone_number) == 0){
                break;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }

}

