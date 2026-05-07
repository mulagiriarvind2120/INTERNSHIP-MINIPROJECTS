import java.util.*;

public class MagicalFoodFestival {
    // Data structures
    private ArrayList<String> foodStalls = new ArrayList<>();
    private Vector<String> dishes = new Vector<>();
    private Queue<String> customerQueue = new LinkedList<>();
    private Stack<String> revisitStack = new Stack<>();
    private LinkedList<String> dailyHistory = new LinkedList<>();

    // Add new food stall
    public void addFoodStall(String stall) {
        foodStalls.add(stall);
        System.out.println("New stall added: " + stall);
    }

    // Chef updates dishes
    public void updateDish(String dish) {
        dishes.add(dish);
        System.out.println("Dish updated: " + dish);
    }

    // Customer joins queue
    public void addCustomer(String customer) {
        customerQueue.add(customer);
        System.out.println(customer + " joined the line.");
    }

    // Serve customers in order
    public void serveCustomer() {
        if (!customerQueue.isEmpty()) {
            String customer = customerQueue.poll();
            System.out.println("Serving: " + customer);
            dailyHistory.add("Served " + customer);
        } else {
            System.out.println("No customers in line.");
        }
    }

    // Customer forgets something → goes back
    public void customerForget(String customer) {
        revisitStack.push(customer);
        System.out.println(customer + " went back to stall.");
        dailyHistory.add(customer + " revisited a stall.");
    }

    // Track last visited stall
    public void lastVisitedStall() {
        if (!revisitStack.isEmpty()) {
            System.out.println("Last revisited stall by: " + revisitStack.peek());
        } else {
            System.out.println("No revisits yet.");
        }
    }

    // Show daily festival history
    public void showHistory() {
        System.out.println("Daily Festival History:");
        for (String record : dailyHistory) {
            System.out.println(record);
        }
    }

    // Demo run
    public static void main(String[] args) {
        MagicalFoodFestival festival = new MagicalFoodFestival();

        festival.addFoodStall("Spicy Tandoor");
        festival.addFoodStall("Sweet Treats");

        festival.updateDish("Paneer Tikka");
        festival.updateDish("Gulab Jamun");

        festival.addCustomer("Alice");
        festival.addCustomer("Bob");

        festival.serveCustomer();
        festival.customerForget("Alice");
        festival.lastVisitedStall();

        festival.serveCustomer();
        festival.showHistory();
    }
}
