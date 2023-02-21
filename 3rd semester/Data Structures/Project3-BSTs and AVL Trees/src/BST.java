import java.io.PrintStream;
import java.io.*;


public class BST implements WordCounter {

    private static class TreeNode {
        WordFreq item;
        TreeNode left; // pointer to left subtree
        TreeNode right; // pointer to right subtree
        TreeNode parent; //pointer to node parent
        int subtreeSize; //number of nodes in subtree starting at this node

        public TreeNode(){
            this.item= new WordFreq();
            this.left=null;
            this.right=null;
            this.parent=null;
            this.subtreeSize=0;
        }

        public TreeNode(WordFreq item){
            this.item=item;
            this.left=null;
            this.right=null;
            this.parent=null;
            this.subtreeSize=0;
        }

    }

    protected TreeNode head; //root of the tree
    protected List stopWords; // list of stopwords
    private int totalWords;
    private WordFreq maxFW;

    private boolean isLeaf; //for insert to add as leaf

    //default constructor
    public BST(){
        head=null;
        stopWords= new List();
        totalWords=0;
        maxFW=new WordFreq("word",0);
    }


    public int compare(WordFreq a, WordFreq b){
        return a.key().compareToIgnoreCase(b.key());
    }

    //O(N)
    @Override
    public void insert(String w) {
        if(!stopWords.isInList(w)){
            totalWords++;
            isLeaf=false;
            head=insertR(head,new WordFreq(w));
        }
    }

    //O(N)
    @Override
    public WordFreq search(String w) {
        if(w==null) throw new IllegalArgumentException();

        TreeNode n= find(w); //does the string exist in the tree,if so find it
        if(n==null) {
            System.out.println("Word "+w+" doesn't exist");
            return null;
        }
        if(n.item.getTimesFound()>getMeanFrequency()){
            insertRoot(n);
        }
        return head.item;
    }

    //O(N)
    @Override
    public void remove(String w) {
        if(find(w)!=null)
            removeR(head,w);
        if(maxFW.key().equalsIgnoreCase(w)){
            maxFW=head.item;
            findNewmaxFW(head);
        }
    }


    @Override
    public void load(String filename) throws Exception {

        boolean isOK = true;
        boolean isStringWithOther = false;
        String punctuation = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~" + '"' + "\n";

        boolean build = false;
        StringBuilder buildString = new StringBuilder();
        FileReader reader = new FileReader(filename);

        int i;
        while ((i = reader.read())!= -1) {
            char c = (char) i;

            if (isOK) {
                if (Character.isLetter(c)||c == '\'') {
                    isOK = false;
                    build = true;
                }
                if (c == ' '||punctuation.indexOf(c) != -1) {
                    continue;
                }
                if (Character.isDigit(c)) {
                    isStringWithOther = true;
                    isOK = false;
                    continue;
                }

            }

            if (isStringWithOther) {
                if (Character.isLetter(c) || c == '\'' || Character.isDigit(c)) {
                    continue;
                }
                if (c == ' '||punctuation.indexOf(c) != -1) {
                    isStringWithOther = false;
                    isOK = true;
                    continue;
                }
            }

            if (build) {
                if (Character.isLetter(c) || c == '\'') {
                    buildString.append(c);
                    continue;
                }
                if (Character.isDigit(c)) {
                    buildString.setLength(0);
                    isStringWithOther = true;
                    build = false;
                    continue;
                }
                if (c == ' ' || punctuation.indexOf(c)!=-1) {
                    insert(buildString.toString());
                    buildString.setLength(0);
                    build = false;
                    isOK = true;
                }
            }


        }

    }


    //O(1)
    @Override
    public int getTotalWords() {
        return totalWords;
    }

    //O(1)
    @Override
    public int getDistinctWords() {
        if(totalWords==0) return 0;
        return head.subtreeSize+1;

    }

    //O(N)
    @Override
    public int getFrequency(String w) {
        WordFreq x = search(w);
        if(x==null) return 0;
        return x.getTimesFound();
    }

    //O(1)
    @Override
    public WordFreq getMaximumFrequency() {
        if(totalWords==0) return null;
        return maxFW;
    }

    //O(1)
    @Override
    public double getMeanFrequency() {
        return (float)getTotalWords()/getDistinctWords();
    }

    //O(1)
    @Override
    public void addStopWord(String w) {
        stopWords.insertAtList(w);
    }

    //O(stopWords.size())
    @Override
    public void removeStopWord(String w) {
        stopWords.removeFromList(w);
    }


    //O(N)
    @Override
    public void printΤreeAlphabetically(PrintStream stream) {
        printAlphaR(head,stream);
    }


    @Override
    public void printΤreeByFrequency(PrintStream stream) {

    }



    //-------------------------------------------
    //private methods for Tree
    //-------------------------------------------

    private TreeNode insertR(TreeNode h, WordFreq item){

        //insert as leaf, has no elements
        if(h==null) {
            isLeaf = true;
            return new TreeNode(item);
        }

        //check if item is already in BST, so do not insert it
        if(h.item.key().equalsIgnoreCase(item.key())){
            h.item.timesFound++;
            if (h.item.timesFound>maxFW.timesFound)
                maxFW=h.item;
        }
        //check left subtree
        else if(compare(h.item,item)<0){
            h.right=insertR(h.right,item);
            if(isLeaf) h.subtreeSize++;
        }
        //check right subtree
        else{
            h.left=insertR(h.left,item);
            if(isLeaf) h.subtreeSize++;
        }

        return h;
    }

    private TreeNode removeR(TreeNode h, String w){
        if(h==null) return null;
        if(h.item.key().compareToIgnoreCase(w)<0){
            h.right=removeR(h.right,w);
            h.subtreeSize--;
        }
        else if(h.item.key().compareToIgnoreCase(w)>0){
            h.left=removeR(h.left,w);
            h.subtreeSize--;
        }
        else{
            totalWords-=h.item.getTimesFound(); //minus total words

            if(h.item==maxFW) maxFW=null; //if node is maximum frequency node

            //binary search tree delete for tree with one or no children
            if(h.left==null) return h.right;
            if(h.right==null) return h.left;

            //binary search tree delete for tree with two children
            TreeNode newTreeR= h.right; //minimum element in right subtree

            while(newTreeR.left!=null)
                newTreeR=newTreeR.left;

            h.item= newTreeR.item;
            h.subtreeSize--;
            h.right=removeR(h.right, newTreeR.item.key());
            return h;
        }
        return h;
    }



    private TreeNode rotR(TreeNode h){
        //pivot's parent
        TreeNode parent=h.parent;

        //pivot's child
        TreeNode child=h.left;

        if (parent == null) {
            head = child;
            head.subtreeSize = h.subtreeSize;

        } else if (parent.left == h) {
            parent.left = child;
            parent.left.subtreeSize = h.subtreeSize;
        } else {
            parent.right = child;
            parent.right.subtreeSize = h.subtreeSize;
        }
        if(h.right!=null){
            h.subtreeSize= h.right.subtreeSize + 1;
        }else{
            h.subtreeSize=1;
        }
        if (child.right != null) {
            h.subtreeSize += child.right.subtreeSize;
        }
        //new number for pivot and child
        child.parent = h.parent;
        h.parent = child;
        h.left = child.right;
        if (child.right!= null) child.right.parent = h;
        child.right= h;
        return child;
    }


    private TreeNode rotL(TreeNode h){
        //pivot's parent
        TreeNode parent=h.parent;
        //pivot's child
        TreeNode child=h.right;

        if (parent == null) {
            head = child;
            head.subtreeSize=h.subtreeSize;

        } else if (parent.left== h) {
            parent.left= child;
            if (child != null){parent.left.subtreeSize=h.subtreeSize;}

        } else {
            parent.right=child;
            if (child != null){parent.right.subtreeSize=h.subtreeSize;}
        }

        if(h.left!=null){//left numbers
            h.subtreeSize= h.left.subtreeSize+ 1;//no right leaf anymore at right leaf
        }else{
            h.subtreeSize=1;
        }

        if (child != null && child.left!=null) {
            h.subtreeSize+= child.left.subtreeSize;
        }
        //new number for pivot and child
        child.parent = h.parent;

        h.parent = child;
        h.right= child.left;
        if (child.left!= null)child.left.parent =h;
        child.left=h;
        return child;
    }

    //insert node at head of tree - for search method
    private void insertRoot(TreeNode n){
        while(n.parent!=null){
            if (n.parent.parent==n)
                n=rotL(n.parent);
            else
                n=rotR(n.parent);
        }
    }

    //does the string exist in the tree - for search and remove method
    private TreeNode find(String w){
        TreeNode tmp=head;
        while(tmp!=null){
            //compare w with element of current subtree
            if(tmp.item.key().equalsIgnoreCase(w))
                return tmp;
            else if(tmp.item.key().compareToIgnoreCase(w)<0)
                tmp=tmp.right;
            else
                tmp=tmp.left;
        }
        return null;
    }

    //find node with max frequency in this tree O(N) - for remove method
    private void findNewmaxFW(TreeNode h){
        if(h==null) return;
        findNewmaxFW(h.left);
        if(maxFW.getTimesFound()<h.item.getTimesFound())
            maxFW= h.item;
        findNewmaxFW(h.right);
    }

    //helper to print alphabetically - for printΤreeAlphabetically method
    private void printAlphaR(TreeNode h, PrintStream stream){
        if(h==null) //BST empty, no traversing
            return;
        printAlphaR(h.left,stream); //check left tree
        stream.println(h.item.key()); //check root
        printAlphaR(h.right,stream);  //check right tree
    }




}
