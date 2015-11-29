public class Node {
    private char label;
    private Node left, right;

    public Node(char label) {
        this.label = label;
        this.left = null;
        this.right = null;
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

        if (position.length() > 0) {
            System.out.println("Jestem w pętli >0 "+label +" "+ position);
            if (position.charAt(0) == 'L') {
                if (this.left == null) {
                    this.left = new Node(label);
                } else
                    this.left.insert(label, position.substring(1));
            } else if (position.charAt(0) == 'R') {
                if (this.right == null) {
                    this.right = new Node(label);
                } else
                    this.right.insert(label, position.substring(1));
            } else
                throw new Exception("Nieprawidłowa składnia: Pozycja powinna składać się wyłączeni ze znaków P oraz L");
        } else {
            //dodajemy w tym miejscu element
            System.out.println("Coś poszło nie tak, ale nie do końca wiemy co");
        }


    }
    public String findOldestWord(){
        String oldestWord = "" + this.label;
        if(left!=null) {
            if(right!=null) {
                //tutaj wykorzystuje to że compareTo we wszystkich językach uzywa porzadku leksykograficznego czyli tego który potrzebujemy
                if (this.left.getLabel() > this.right.getLabel() )
                    oldestWord += left.findOldestWord();
                else if(this.left.getLabel() < this.right.getLabel())
                    oldestWord += right.findOldestWord();
                else if ((this.left.findOldestWord().compareTo(this.right.findOldestWord()))>0)
                    oldestWord += left.findOldestWord();
                else
                    oldestWord += right.findOldestWord();
            }
        }
        return oldestWord;
    }

    public String findOldestWordFromLeaf(){
        String oldestWord = "" + this.label;
        if(left!=null) {
            if(right!=null) {
                //tutaj wykorzystuje to że compareTo we wszystkich językach uzywa porzadku leksykograficznego czyli tego który potrzebujemy

                if ((reverse(this.left.findOldestWord()).compareTo(reverse(this.right.findOldestWord())))>0)
                    oldestWord += left.findOldestWord();
                else
                    oldestWord += right.findOldestWord();
            }
        }
        return oldestWord;
    }

    public String findOldest(){
        return reverse(findOldestWordFromLeaf());
    }


    public static String reverse(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }







   /* public double get(int index) {
        if (index == this.index) {
            return this.value;
        } else if (index < this.index) {
            if (this.left == null)
                return 0.0;
            else
                return this.left.get(index);
        } else if (index > this.index) {
            if (this.right == null)
                return 0.0;
            else
                return this.right.get(index);
        }
        return 0;
    }*/
}