import java.util.*;

class ListNode {
    int value;
    ListNode next;
    
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class PrisonersLinkedListSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of prisoners: ");
        int N = scanner.nextInt();
        
        System.out.print("Enter number of simulations: ");
        int SIMULATIONS = scanner.nextInt();
        
        int successCount = 0;
        
        for (int i = 0; i < SIMULATIONS; i++) {
            ListNode[] boxes = generateLinkedList(N);
            if (simulate(boxes, N)) {
                successCount++;
            }
        }
        
        double probability = (double) successCount / SIMULATIONS * 100;
        System.out.printf("Success Probability over %d trials: %.2f%%\n", SIMULATIONS, probability);
        scanner.close();
    }
    
    // Function to generate a linked list representation of boxes
    static ListNode[] generateLinkedList(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        
        ListNode[] boxes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = new ListNode(numbers.get(i));
        }
        
        for (int i = 0; i < n; i++) {
            boxes[i].next = boxes[boxes[i].value];
        }
        
        return boxes;
    }
    
    // Function to simulate one full round
    static boolean simulate(ListNode[] boxes, int n) {
        for (int prisoner = 0; prisoner < n; prisoner++) {
            int attempts = 0;
            ListNode currentNode = boxes[prisoner];
            
            while (attempts < n / 2) { // Each prisoner can open only N/2 boxes
                if (currentNode.value == prisoner) {
                    break; // Success for this prisoner
                }
                currentNode = currentNode.next; // Follow the linked list (cycle)
                attempts++;
            }
            
            if (attempts >= n / 2) {
                return false; // If any prisoner fails, all are executed
            }
        }
        return true; // All prisoners survived
    }
}
