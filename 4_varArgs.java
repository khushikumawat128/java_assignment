class varArgs {
    
    public static void main(String[] args) {
        int sum1 = add(1, 2, 3, 4, 5);
        System.out.println("Sum 1: " + sum1);
        
        int sum2 = add(10, 20, 30);
        System.out.println("Sum 2: " + sum2);
        
        int sum3 = add(); 
        System.out.println("Sum 3: " + sum3);
    }
    public static int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}