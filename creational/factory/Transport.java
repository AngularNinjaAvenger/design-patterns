public abstract class Transport {

    public abstract String drive();

}

public abstract class TransportFactory {

	abstract Transport create();
	
}



class Car extends Transport{

	public String drive() {
		return "Car driving"; 
	}

}

class Bike extends Transport{

	public String drive() {
		return "Bike driving";
	}

}

// factory class

class BikeFactory extends TransportFactory{
	Transport create() {
		return new Bike();
	}
}


class CarFactory extends TransportFactory{
	Transport create() {
		return new Car();
	}
}



TransportFactory factory = new BikeFactory();

Transport transport = factory.create();

System.out.println(transport.drive());

factory  = new CarFactory();

transport = factory.create();

System.out.println(transport.drive());

