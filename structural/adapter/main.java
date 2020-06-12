package structural.adapter;


// LEGACY CODE
class LegacyRectangle {

	public Integer calculateSize(){
		return 10;
	}
	
}

// LEGCY CODE ADAPTER
class LegacyRectangleAdapter extends Rectangle{

    private LegacyRectangle legacyRectangle;

    public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    // HERE WE OVER RIDE THE DETERNINESIZE METHOD FROM THE RECTANGLE
    // 
    @Override
    public Integer determineSize() {
        return legacyRectangle.calculateSize();
    }
}

// NEW RECTANGLE
class Rectangle {

	public Integer determineSize(){
		return 5;
	}
	
}


class Client {

	public static void main(String [] args){
		Client client = new Client();

        LegacyRectangle legacyRectangle = new LegacyRectangle();

        LegacyRectangleAdapter adapter = new LegacyRectangleAdapter(legacyRectangle);

        client.calculateRectangleSize(adapter);

		
	}
	
	
	public void calculateRectangleSize(Rectangle rectangle){
		System.out.println("Rectangle Size: "+rectangle.determineSize());
	}
	
	
}