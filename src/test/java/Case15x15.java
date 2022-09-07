import org.junit.jupiter.api.Test;

public class Case15x15 {
    @Test
    public void spade15x15() {
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

    @Test
    public void sun15x15() {
        Game game = new Game(15, 15);
        game.addColumn("15");
        game.addColumn("7, 7");
        game.addColumn("2, 4, 4, 2");
        game.addColumn("3, 7, 3");
        game.addColumn("5, 5");
        game.addColumn("4, 4");
        game.addColumn("4, 1, 1, 4");
        game.addColumn("1, 1, 1, 1, 1");
        game.addColumn("4, 1, 1, 4");
        game.addColumn("4, 4");
        game.addColumn("5, 5");
        game.addColumn("3, 7, 3");
        game.addColumn("2, 4, 4, 2");
        game.addColumn("7, 7");
        game.addColumn("15");

        game.addRow("15");
        game.addRow("7, 7");
        game.addRow("2, 4, 4, 2");
        game.addRow("3, 7, 3");
        game.addRow("5, 5");
        game.addRow("4, 4");
        game.addRow("4, 1, 1, 4");
        game.addRow("1, 1, 1, 1");
        game.addRow("4, 4");
        game.addRow("4, 3, 4");
        game.addRow("5, 5");
        game.addRow("3, 7, 3");
        game.addRow("2, 4, 4, 2");
        game.addRow("7, 7");
        game.addRow("15");

        Solver solver = new Solver();
        solver.solve(game);
        game.printNonogram();
    }

    @Test
    public void music15x15() {
        Game game = new Game(15, 15);
        game.addColumn("3, 1, 9");
        game.addColumn("3, 3, 2, 2");
        game.addColumn("6, 1, 1, 2, 1");
        game.addColumn("2, 2");
        game.addColumn("1, 3, 1, 2, 4");
        game.addColumn("2, 3, 5");
        game.addColumn("11, 3");
        game.addColumn("3, 1, 1, 1, 1, 3");
        game.addColumn("3, 1, 1, 1, 1, 3");
        game.addColumn("3, 1, 1, 1, 3");
        game.addColumn("3, 1, 1, 3");
        game.addColumn("3, 1, 1, 1, 1, 3");
        game.addColumn("3, 1, 1, 1, 3");
        game.addColumn("3, 1, 1, 3");
        game.addColumn("3, 1, 1, 1, 1, 3");

        game.addRow("15");
        game.addRow("4, 10");
        game.addRow("3, 1, 9");
        game.addRow("1, 1, 1");
        game.addRow("3, 1, 7, 1");
        game.addRow("2, 2");
        game.addRow("2, 6, 2, 1");
        game.addRow("1, 1, 2");
        game.addRow("1, 1, 4, 1, 2");
        game.addRow("1, 1, 1, 1");
        game.addRow("2, 4, 5");
        game.addRow("3, 2");
        game.addRow("1, 1, 11");
        game.addRow("2, 12");
        game.addRow("15");

        Solver solver = new Solver();
        solver.solve(game);
        game.printNonogram();
    }
}

