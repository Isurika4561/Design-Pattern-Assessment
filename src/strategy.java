// Strategy interface
interface Strategy {
    int doOperation(int num1, int num2);
}

// Concrete Strategy for addition
class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// Concrete Strategy for subtraction
class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

// Concrete Strategy for multiplication
class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

// Context class
class Context {
    private Strategy strategy;

    // Set the strategy at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Execute the strategy
    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }


// Main class
    public static void main(String[] args) {
        Context context = new Context();

        // Using addition strategy
        context.setStrategy(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        // Using subtraction strategy
        context.setStrategy(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        // Using multiplication strategy
        context.setStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
