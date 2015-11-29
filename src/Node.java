public class Node {
    private char label;
    private Node left, right;
    boolean wierzcholek;
    String oldestPath;

    public void setOldestPath(String oldestPath) {
        this.oldestPath = oldestPath;
    }

    public boolean isWierzcholek(){
        return wierzcholek;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public String getOldestPath() {
        return oldestPath;
    }

    public Node(char label) {
        this.label = label;
        this.left = null;
        this.right = null;
        this.wierzcholek = true;
        this.oldestPath = "0";
    }

    public char getLabel() {
        return label;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void print() {
        if (this.right != null)
            this.right.print();
        System.out.println(label);
        if (this.left != null)
            this.left.print();
    }

    public void printFormated(int level) {
        if (this.right != null)
            this.right.printFormated(level + 1);

        String spaces = "";
        for (int i = 0; i < level; i++)
            spaces = spaces + "  ";

        System.out.println(spaces + label);

        if (this.left != null)
            this.left.printFormated(level + 1);
    }

    public void insert(char label, String position) throws Exception {

        if((position!=null)&&(position.length() > 0)){
            if (position.charAt(0) == 'L') {
                if (this.left == null) {
                    this.left = new Node('-');
                    if(position.length()==1)
                        this.left.setLabel(label);
                    else
                        this.left.insert(label,position.substring(1));
                } else
                    this.left.insert(label, position.substring(1));
            } else if (position.charAt(0) == 'R') {
                if (this.right == null) {
                    this.right = new Node('-');
                    if(position.length()==1)
                        this.right.setLabel(label);
                    else
                        this.right.insert(label,position.substring(1));
                } else
                    this.right.insert(label, position.substring(1));
            } else
                throw new Exception("Nieprawidłowa składnia: Pozycja powinna składać się wyłączeni ze znaków R oraz L");
        }else {
            this.label = label;
        }
    }



    public void findOldestPath(Node root, String curr){
        String currentPath = this.label + curr;

        if((this.left==null) && (this.right==null)){
            if(currentPath.compareTo(root.getOldestPath())>0){
                root.setOldestPath(currentPath);
            }
        }
        if(this.left!=null){
            this.left.findOldestPath(root,currentPath);
        }
        if(this.right!=null){
            this.right.findOldestPath(root,currentPath);
        }


    }

}