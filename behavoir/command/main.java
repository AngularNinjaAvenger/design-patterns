// in this example we are implementing a texte ewdiror where users can do and undo actions

interface Command {

    void action();

    void undo();


}

abstract class AbstractCommand implements Command{

    private TextEditor textEditor;


    public AbstractCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public TextEditor getTextEditor() {
        return textEditor;
    }
}


class ClearTextCommand extends AbstractCommand{

    private String undoText ="";

    public ClearTextCommand(TextEditor textEditor) {
        super(textEditor);
    }


    @Override
    public void action() {
        // first back up the undo text
        undoText = getTextEditor().getText();
        getTextEditor().setText("");
    }

    @Override
    public void undo() {
        getTextEditor().setText(undoText);
    }
}


class AddTextCommand extends AbstractCommand{

    private String undoText;

    private String textToBeAdded;

    public AddTextCommand(TextEditor textEditor, String textToBeAdded) {
        super(textEditor);
        this.textToBeAdded = textToBeAdded;
    }

    @Override
    public void action() {
        undoText = getTextEditor().getText();
        getTextEditor().setText(getTextEditor().getText()+textToBeAdded);
    }

    @Override
    public void undo() {
        getTextEditor().setText(undoText);
    }
}




class TextEditor {

    private String text;

    private Queue<Command> queue = new LinkedList<Command>();

    private void executeAction(Command command){
        command.action();
        queue.add(command);
    }

    private void undo(){
        Command command = queue.poll();
        if(command!=null){
            command.undo();
        }
    }

    // GETTer ANd SETTER


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Queue<Command> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Command> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.setText("1234");
        ClearTextCommand command = new ClearTextCommand(editor);
        editor.executeAction(command);
        System.out.println("Text is: " + editor.getText());
        editor.undo();
        System.out.println("Text is: " + editor.getText());
        AddTextCommand addTextCommand = new AddTextCommand(editor," fun text");
        editor.executeAction(addTextCommand);
        System.out.println("Text is: " + editor.getText());
    }
}
