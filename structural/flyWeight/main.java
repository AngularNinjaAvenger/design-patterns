// this letter factory will store all create or new instaces in this case words
// this letter factory is the factory 
class LetterFactory {

    private Map<String, Letter> letterMap = new HashMap<String, Letter>();

    public Letter createLetter(String key){
        Letter letter = letterMap.get(key);
        if(letter == null){
            letter = new Letter(key);
            letterMap.put(key,letter);
        }

        return letterMap.get(key);
    }

}


class WordProcessor {

    private List<Letter> letters = new ArrayList<Letter>();

    public void addLetter(Letter letter){
        this.letters.add(letter);
    }

    public void printLetters(){
        for (Letter letter : letters) {
            System.out.print(letter.getValue());
        }
    }

}


class Letter {

    private String value;

    public Letter(String value) {
        System.out.println("New letter created with value: "+value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


class Client {

    public static void main(String[] args) {
        WordProcessor processor = new WordProcessor();

        String textToAdd = "Hello i'm aaaa wwworddd pprocessorrrr";
        int length = textToAdd.length();


        LetterFactory factory = new LetterFactory();

        for(int i = 0; i<length;i++){

            String value = textToAdd.substring(i,i+1);
            processor.addLetter(factory.createLetter(value));

        }

        processor.printLetters();
    }


}
