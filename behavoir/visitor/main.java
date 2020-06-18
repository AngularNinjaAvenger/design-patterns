class Car {

    List<CarPart> carParts = new ArrayList<CarPart>();

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }

    public void render(){
        RenderCarPartVisitor renderer = new RenderCarPartVisitor();
        for (CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(renderer);
        }
    }

    public void print(){
        PrintCarPartVisitor visitor = new PrintCarPartVisitor();
        for (CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(visitor);
        }
    }

    public void upgrade(){
        UpgradeCarPartVisitor visitor = new UpgradeCarPartVisitor();
        for (CarPart carPart : carParts) {
            carPart.acceptCarPartVisitor(visitor);
        }
    }

}

abstract class CarPart {

    void acceptCarPartVisitor(CarPartVisitor visitor){
        visitor.visit(this);
    }

}

interface CarPartVisitor {

    void visit(CarPart carPart);

}

class PrintCarPartVisitor implements CarPartVisitor{

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Print "+carPart);
    }

}

class RenderCarPartVisitor implements CarPartVisitor{

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Render "+carPart);
    }

}

class UpgradeCarPartVisitor implements CarPartVisitor{

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Upgrade: "+carPart);
    }


}



class Engine extends CarPart {

}

class Light extends CarPart {


}

class Wheel extends CarPart {

}



class Client {

    public static void main(String[] args) {

        Car car = new Car();

        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());
        car.getCarParts().add(new Wheel());

        car.getCarParts().add(new Light());
        car.getCarParts().add(new Light());

        car.getCarParts().add(new Engine());

        car.upgrade();;
        car.print();
        car.render();
        
        
    }

}
