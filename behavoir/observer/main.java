interface Observer {

    void update();

}



// this holds down a list of observer, this is the subject that has the state 
// that we want to observe .  so whenever the state is changed it notifys all
//  the observers in thelist
interface Subject {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void change();

}


class Button implements Subject{

    java.util.List<Observer> observers = new ArrayList<Observer>();


    public void clicked(){

        change();

    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void change() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class InputText implements Observer {

    public void setText(String text){
        System.out.println("Inputtext set text: "+text);
    }


    @Override
    public void update() {
        this.setText("button has been clicked");
    }
}

class Client {

    public static void main(String[] args) {
        Button button = new Button();
        InputText text = new InputText();
        List list = new List();



        button.attachObserver(text);
        button.attachObserver(list);

        button.clicked();

    }

}