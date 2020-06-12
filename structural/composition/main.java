
// first we define an interfce with all the methods

interface Graphic {

    void draw();

}

class GraphicItemGroup implements Graphic {

    private List<Graphic> graphics = new ArrayList<Graphic>();

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }

    public List<Graphic> getGraphics() {
        return graphics;
    }
}


class Line implements Graphic{

    public void draw(){
        System.out.println("Draw line");
    }

}

class Rectangle implements Graphic{

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    class Client {

        public static void main(String[] args) {
    
            Line line = new Line();
            Rectangle rectangle = new Rectangle();
            GraphicItemGroup group = new GraphicItemGroup();
    
            group.getGraphics().add(line);
            group.getGraphics().add(rectangle);
    
            group.draw();
    
    
            Line line1 = new Line();
            GraphicItemGroup group2 = new GraphicItemGroup();
            group2.getGraphics().add(line1);
    
    
            group2.getGraphics().add(group);
    
            System.out.println("drawing group two");
    
            group2.draw();
    
            line.draw();
    
    
    
    
    
        }
    
    }
    