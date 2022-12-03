package BSTBackground;

import java.util.NoSuchElementException;

public class Manager {
    private InfoNode base;


    // base constructor
    public Manager(InfoNode base) {
        this.base = base;
    }

    //print function
    public void print() {
        print(base);
        System.out.println(base);
    }


    private void print(InfoNode root) {
        if( root != null) {
            print(base.left);
            System.out.print(base.right);
            print(base.right);
        }
    }

    //displays items will all fields
    public void display() {
        display(base);
    }

    private void display(InfoNode root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.key + ", " +  root.firstName + ", " + root.lastName + ", " + root.address + ", " + root.city + ", " + root.zipCode + ", " + root.email + ", " + root.phoneNumber);
            display(root.right);
        }
    }

    // prints tree key values in "inorder"
    public void printInOrder() {
        printInOrder(base); 
    }
    private void printInOrder(InfoNode root) {
        if (root == null) {
            return; 
        }
        printInOrder(root.left); 
        System.out.println(root.key + " "); 
        printInOrder(root.right); 

    }

    //prints tree key values in "preorder"
    public void printPreOrder() {
        printPreOrder(base); 
    }
    private void printPreOrder(InfoNode root) {
        if (root == null) {
            return; 
        }
        System.out.println(root.key + " "); 
        printPreOrder(root.left); 
        printPreOrder(root.right); 

    }

    //prints tree key values in "postorder"
    public void printPostOrder() {
        printPostOrder(base); 
    }
    private void printPostOrder(InfoNode root) {
        if (root == null) {
            return; 
        }
        printPostOrder(root.left); 
        printPostOrder(root.right); 
        System.out.println(root.key + " "); 
    }


    // searcjes for certain key value
    public void find() {
        find(base);
    }

    private void find(InfoNode root) {
        if (root != null) {
            System.out.println(root.key + ", " +  root.firstName + ", " + root.lastName + ", " + root.address + ", " + root.city + ", " + root.zipCode + ", " + root.email + ", " + root.phoneNumber);
        }
    }


    //extracts value from specific key input
    public void lookup(int newKey) {
        find(lookup(base, newKey));
    }

    private InfoNode lookup(InfoNode root, int newKey) {
        if (root == null) {
           
            System.out.printf("ERROR: Item Does not Exist!%n%n%n%n");
            return null;
        }
        else  if (root.key > newKey) {
            return lookup(root.left, newKey);
        }
        else if (root.key < newKey) {
            return lookup(root.right, newKey);
        }
        else {// root.key == newKey
            return root;
        }
    }

    //prints the tree in a sideways visual format
    public void printS() {
        printS(base, "");
    }

    private void printS(InfoNode root, String indent) {
        if(root != null) {
            printS(root.right, indent + "    ");
            System.out.println(indent + root.key);
            printS(root.left, indent + "     ");
        }

    }

    // returns the minimum value in a given tree
    public int getMin() {
        if(base == null) {
            throw new NoSuchElementException();
        }
        return getMin(base);

    }

    private int getMin(InfoNode root) {
        if(root.left == null) {
            return root.key;
        } else {
            return getMin(root.left);
        }
    }

    //adds an item to the tree given input values
    public void add(int newKey, String fName, String lName, String street, String place, String zip, String mail, String phone) {
        base = add(base, newKey,fName, lName, street, place, zip, mail, phone);
    }

    private InfoNode add(InfoNode root,int newKey, String fName, String lName, String street, String place, String zip, String mail, String phone) {

        if (root == null) {
            root = new InfoNode(newKey, fName, lName, street, place, zip, mail, phone);
        }
        else if (root.key > newKey) {
            root.left = add(root.left,newKey, fName, lName, street, place, zip, mail, phone);

        }
        else if (root.key < newKey) {
            root.right  = add(root.right,newKey, fName, lName, street, place, zip, mail, phone);
        }
        return root;

    }

    //removes an item from the tree given a key value
    public void remove(int newKey) {
        base = remove(base, newKey);
    }

    private InfoNode remove(InfoNode root, int newKey) {

        if (root == null) {
            return null;
        }
        else if (root.key > newKey) {
            root.left = remove(root.left, newKey);
        }
        else if (root.key < newKey) {
            root.right = remove(root.right, newKey);
        }
        else {
            if (root.right == null) {
                return root.left;
            }
            else if (root.left == null) {
                return root.right;
            }
            else {
                root.key = getMin(root.right);
                root.right = remove(root.right, root.key);
            }
        }
        return root;
    }

    //returns the amount of items in a given tree
    public int size() {
        return size(base);
    }

    private int size(InfoNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return (size(root.left) + 1 + size(root.right));
        }
    }

}