package ud6.exam;


/*
    TODO: Explica en aquesta secció els code smells identificats i el procés de refactorització realitzat
    El metodo makeCoffee() es muy largo se deberia dividir crear metodos por ingrediente, que revise si el ingrediente es suficiente
    para la receta del cafe y si lo es, que lo reste a la cantidad de ingrediente de la maquina de cafe, y en el metodo makeCoffee()usar los metodos
    creados para cada ingrediente.

 */
public class CoffeeMachine {
    private int water;
    private int milk;
    private int cups;
    private int coffeBeans;
    private int sugar;

    public CoffeeMachine(int water, int milk, int cups, int coffeBeans, int sugar) {
        this.water = water;
        this.milk = milk;
        this.cups = cups;
        this.coffeBeans = coffeBeans;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "water=" + water +
                ", milk=" + milk +
                ", cups=" + cups +
                ", coffeBeans=" + coffeBeans +
                ", sugar=" + sugar +
                '}';
    }

    public boolean makeCoffee(CoffeeType coffeeType, int sugar){
        if(cups == 0) {
            System.out.println("Not enough cups to make a " + coffeeType);
            return false;
        } else if (this.sugar < sugar) {
            System.out.println("Not enough sugar to make a " + coffeeType);
            return false;
        } else if (this.water < coffeeType.getWaterNeeded()) {
            System.out.println("Not enough water to make a " + coffeeType);
            return false;
        } else if (this.milk < coffeeType.getMilkNeeded()) {
            System.out.println("Not enough milk to make a " + coffeeType);
            return false;
        } else if (this.coffeBeans < coffeeType.getBeansNeeded()) {
            System.out.println("Not enough coffeBeans to make a " + coffeeType);
            return false;
        } else {
            this.cups--;
            this.sugar -= sugar;
            this.water -= coffeeType.getWaterNeeded();
            this.milk -= coffeeType.getMilkNeeded();
            this.coffeBeans -= coffeeType.getBeansNeeded();
            System.out.println(coffeeType + " made!");
            return true;
        }


    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(200, 200, 3, 100, 100);
        coffeeMachine.makeCoffee(CoffeeType.ESPRESSO, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.LATTE, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO, 10);
        System.out.println(coffeeMachine);
        coffeeMachine.makeCoffee(CoffeeType.CAPPUCCINO, 10);
        System.out.println(coffeeMachine);
    }
}
