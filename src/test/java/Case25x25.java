import org.junit.jupiter.api.Test;

public class Case25x25 {
    @Test
    public void spade15x15() {
        Game game = new Game(25, 25);
        game.addColumn("1, 3, 2, 2, 2");
        game.addColumn("13, 3");
        game.addColumn("3, 8, 5");
        game.addColumn("4, 4, 4, 6");
        game.addColumn("6, 8");

        game.addColumn("7, 1, 3, 3, 2");
        game.addColumn("8, 1, 1, 3, 3");
        game.addColumn("13, 3, 5");
        game.addColumn("8, 1, 1, 2, 6");
        game.addColumn("7, 1, 9");

        game.addColumn("6, 9");
        game.addColumn("4, 4, 8, 1");
        game.addColumn("3, 13, 2");
        game.addColumn("18, 2");
        game.addColumn("20");

        game.addColumn("1, 2, 3, 10");
        game.addColumn("9");
        game.addColumn("8");
        game.addColumn("2, 8");
        game.addColumn("4, 8");

        game.addColumn("6, 6");
        game.addColumn("4, 2, 4");
        game.addColumn("5, 2, 2");
        game.addColumn("4, 4");
        game.addColumn("5, 1");

        game.addRow("1");
        game.addRow("5");
        game.addRow("9");
        game.addRow("13");
        game.addRow("14");

        game.addRow("16");
        game.addRow("2, 7, 2, 1");
        game.addRow("2, 9, 3, 1");
        game.addRow("3, 3, 5, 3");
        game.addRow("4, 1, 1, 1, 4, 5");

        game.addRow("4, 1, 5, 6");
        game.addRow("2, 3, 4, 6");
        game.addRow("3, 1, 4, 5");
        game.addRow("4, 3, 4, 2");
        game.addRow("5, 7, 3");

        game.addRow("16, 3");
        game.addRow("17, 1");
        game.addRow("1, 2, 12, 1");
        game.addRow("3, 13, 2");
        game.addRow("4, 16");

        game.addRow("4, 15");
        game.addRow("4, 5, 8");
        game.addRow("4, 6, 10");
        game.addRow("4, 4, 9");
        game.addRow("1");


        Solver solver = new Solver();
        solver.solve(game);
        game.printNonogram();
    }
}
