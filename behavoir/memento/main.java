class ConnectionSolver {

    private Point2D firstPoint;

    private Point2D secondPoint;


    public void calculateLine(){

        System.out.println("Calculate line between: "+firstPoint+" and "+secondPoint);

    }

    public ConnectionSolverMemento createMemento(){
        return new ConnectionSolverMemento(firstPoint,secondPoint);
    }


    public void setMemento(ConnectionSolverMemento memento){
        firstPoint = memento.getFirstPoint();
        secondPoint = memento.getSecondPoint();
    }


    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point2D secondPoint) {
        this.secondPoint = secondPoint;
    }
}


class ConnectionSolverCaretaker {

    private ConnectionSolverMemento connectionSolverMemento;

    public void saveState(ConnectionSolver connectionSolver){
        connectionSolverMemento = connectionSolver.createMemento();
    }

    public void restoreState(ConnectionSolver connectionSolver){

        connectionSolver.setMemento(connectionSolverMemento);

    }


}


class ConnectionSolverMemento {

    private Point2D firstPoint;

    private Point2D secondPoint;


    public ConnectionSolverMemento(Point2D firstPoint, Point2D secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point2D getFirstPoint() {
        return firstPoint;
    }

    public Point2D getSecondPoint() {
        return secondPoint;
    }
}


class Client {

    public static void main(String[] args) {
        ConnectionSolver connectionSolver = new ConnectionSolver();
        ConnectionSolverCaretaker caretaker = new ConnectionSolverCaretaker();


        connectionSolver.setFirstPoint(new Point2D.Double(1.0,1.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0, 1.0));

        caretaker.saveState(connectionSolver);



        connectionSolver.calculateLine();


        connectionSolver.setFirstPoint(new Point2D.Double(2.0,2.0));
        connectionSolver.setSecondPoint(new Point2D.Double(5.0, 1.0));

        connectionSolver.calculateLine();

        ConnectionSolver newConnectionSolver = new ConnectionSolver();


        caretaker.restoreState(newConnectionSolver);


        newConnectionSolver.calculateLine();


        caretaker.restoreState(connectionSolver);

        connectionSolver.calculateLine();

    }

}
