import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BST bst = new BST();
        inputProcessor.processInput("input.txt", bst);
        //System.out.println(bst.getSize());
    }
    public static class inputProcessor {

        public static void processInput(String filename, BST bst) throws FileNotFoundException {
            
            try (Scanner scanner = new Scanner(new File(filename))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue; // Skip empty lines
                    String[] parts = line.split("\\s+");
                    String command = parts[0].toUpperCase();

                    switch (command) {
                        case "BUILD":
                            for (int i = 1; i < parts.length; i++) {
                                try {
                                    int data = Integer.parseInt(parts[i]);
                                    bst.insert(data);
                                } catch (NumberFormatException e) {
                                    System.out.println("Input not valid");
                                }
                            }
                            break;
                        case "INSERT":
                            if (parts.length != 2) {
                                System.out.println("Input not valid");
                                break;
                            }
                            try {
                                int data = Integer.parseInt(parts[1]);
                                bst.insert(data);
                            } catch (NumberFormatException e) {
                                System.out.println("Input not valid");
                            }
                            break;
                        case "DELETE":
                            if (parts.length != 2) {
                                System.out.println("Input not valid");
                                break;
                            }
                            try {
                                int data = Integer.parseInt(parts[1]);
                                bst.delete(data);
                            } catch (NumberFormatException e) {
                                System.out.println("Input not valid");
                            }
                            break;
                        case "IN_ORDER":
                            bst.printInOrder();
                            System.out.println();
                            break;
                        case "SIZE":
                            System.out.println(bst.getSize());
                            break;
                        case "HEIGHT":
                            System.out.println(bst.height());
                            break;
                        case "KTH_SMALLEST":
                            if (parts.length != 2) {
                                System.out.println("Input not valid");
                                break;
                            }
                            try {
                                int k = Integer.parseInt(parts[1]);
                                int result = bst.find_kth_smallest(k);
                                if (result != -1) {
                                    System.out.println(result);
                                } else {
                                    System.out.println("Input not valid");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input not valid");
                            }
                            break;
                        case "SEARCH":
                            if (parts.length != 2) {
                                System.out.println("Input not valid");
                                break;
                            }
                            try {
                                int data = Integer.parseInt(parts[1]);
                                System.out.println(bst.search(data));
                            } catch (NumberFormatException e) {
                                System.out.println("Input not valid");
                            }
                            break;
                        default:
                            System.out.println("Input not valid"); 
                            break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
        }
    }

}
