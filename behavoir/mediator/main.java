class InputText {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class List {

    private java.util.List<String> items = new ArrayList<String>();


    private Screendirector screendirector;


    public void selectItem(int itemNumber){
        String item = items.get(itemNumber);
        if(screendirector !=null){
            screendirector.itemSelected(item);
        }
    }


    public java.util.List<String> getItems() {
        return items;
    }


    public void setScreendirector(Screendirector screendirector) {
        this.screendirector = screendirector;
    }
}

interface Screendirector {

    void itemSelected(String item);

}


class ScreenDirectorOne implements Screendirector{

    private InputText inputText;


    @Override
    public void itemSelected(String item) {
        inputText.setValue(item);
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }
}



class Client {

    public static void main(String[] args) {

        List list = new List();
        InputText text = new InputText();


        ScreenDirectorOne screendirector = new ScreenDirectorOne();
        screendirector.setInputText(text);
        list.setScreendirector(screendirector);


        list.getItems().add("Data item one");
        list.getItems().add("Data item two");
        list.getItems().add("Data item three");

        list.selectItem(2);

        System.out.println("Selected value is: "+text.getValue());




    }

}
