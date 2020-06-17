interface ChessAlgorithm {

    int calculateNextStep();

}

class Chess {

    private ChessAlgorithm algorithm = new EasyChessAlgorithm();

    public int calculateNextStep(){
        return algorithm.calculateNextStep();
    }

    public void setAlgorithm(ChessAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}

class EasyChessAlgorithm implements ChessAlgorithm{

    @Override
    public int calculateNextStep() {
        return 1;
    }
}

class MediumChessAlgorithm implements ChessAlgorithm{

    @Override
    public int calculateNextStep() {
        return 2;
    }
}

class HardChessAlgorithm implements ChessAlgorithm{

    @Override
    public int calculateNextStep() {
        return 3;
    }
}

class Client {

    public static void main(String[] args) {


        Chess chess = new Chess();

        System.out.println("Calculate next step: " +chess.calculateNextStep());



        chess.setAlgorithm(new HardChessAlgorithm());



        System.out.println("Calculate next step: " +chess.calculateNextStep());


    }

}