public class Main {
    public static void main(String[] args) throws Exception {
//        Game game = new Game(15, 15);
//        for(int i = 0; i < 10; i++) {
//            game.addColumn("1, 15, 5");
//            game.addRow("5, 7");
//        }
//        for(int i = 10; i < 15; i++) {
//            game.addColumn("1, 1");
//            game.addRow("1, 4, 8");
//        }

        Game game = new Game(15, 15);
        game.addColumn("4");
        game.addColumn("7");
        game.addColumn("8");
        game.addColumn("9");
        game.addColumn("10");
        game.addColumn("10, 1");
        game.addColumn("10, 2");
        game.addColumn("15");
        game.addColumn("10, 2");
        game.addColumn("10, 1");
        game.addColumn("10");
        game.addColumn("9");
        game.addColumn("8");
        game.addColumn("7");
        game.addColumn("4");

        game.addRow("1");
        game.addRow("3");
        game.addRow("5");
        game.addRow("7");
        game.addRow("9");
        game.addRow("11");
        game.addRow("13");
        game.addRow("13");
        game.addRow("15");
        game.addRow("15");
        game.addRow("15");
        game.addRow("6, 1, 6");
        game.addRow("4, 1, 4");
        game.addRow("3");
        game.addRow("5");


        Solver solver = new Solver();
        solver.solve(game);
        game.printNonogram();

    }
}
