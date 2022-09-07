import java.util.ArrayList;
import java.util.Collections;

public class Game {
    Game(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        rows = new ArrayList<>(heigth);
        columns = new ArrayList<>(width);
        gameSet = new ArrayList<>(width);
        for(int i = 0; i < heigth; i++) {
            gameSet.add(new ArrayList<>(Collections.nCopies(width, Tile.UNSURE)));
        }
    }

    private int width;
    private int heigth;

    private ArrayList<ArrayList<Integer>> rows;
    private ArrayList<ArrayList<Integer>> columns;
    public ArrayList<ArrayList<Tile>> gameSet;

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public ArrayList<Integer> getRow(int rowNum) {
        return rows.get(rowNum);
    }

    public ArrayList<Integer> getColumn(int columnNum) {
        return columns.get(columnNum);
    }

    public void addRow(String row) {
        String[] splitString = row.split(", ");
        ArrayList<Integer> numbers = new ArrayList<>(splitString.length);

        Integer sum = 0;
        for(int i = 0; i < splitString.length; i++) {
            Integer number = Integer.valueOf(splitString[i]);
            numbers.add(number);
            sum += number;
        }

        sum += numbers.size() - 1;
        if(sum > width) {
            System.out.println("***Row is to big for the size of the game***");
        }

        rows.add(numbers);
    }

    public void addColumn(String column) {
        String[] splitString = column.split(", ");
        ArrayList<Integer> numbers = new ArrayList<>(splitString.length);

        Integer sum = 0;
        for(int i = 0; i < splitString.length; i++) {
            Integer number = Integer.valueOf(splitString[i]);
            numbers.add(number);
            sum += number;
        }

        sum += numbers.size() - 1;
        if(sum > heigth) {
            System.out.println("***Column is to big for the size of the game***");
        }

        columns.add(numbers);
    }

    public void printNonogram() {
        int maxLengthColumn = 0;
        int maxLengthRow = 0;

        for(int i = 0; i < heigth; i++) {
            if(rows.get(i).size() > maxLengthRow) {
                maxLengthRow = rows.get(i).size();
            }
        }

        for(int i = 0; i < width; i++) {
            if(columns.get(i).size() > maxLengthColumn) {
                maxLengthColumn = columns.get(i).size();
            }
        }

        for(int k = maxLengthColumn - 1; k >= 0; k--) {
            for(int j = 0; j < maxLengthRow; j++) {
                System.out.print("   ");
            }
            System.out.print(" |");

            for(int i = 0; i < this.width; i++) {
                if(columns.get(i).size() > k ) {
                    System.out.printf("%3s", columns.get(i).get(columns.get(i).size() - 1 - k));
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        String line = "-".repeat(this.width*3 + maxLengthRow*3 +2);
        System.out.println(line);

        for(int i = 0; i < heigth; i++) {
            for(int j = 0; j < maxLengthRow; j++) {
                if(maxLengthRow - rows.get(i).size() > j ) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%3s", rows.get(i).get(j - (maxLengthRow - rows.get(i).size() )));
                }
            }
            System.out.print(" |");

            for(int j = 0; j < this.width; j++) {
                System.out.printf("%3s", gameSet.get(i).get(j) == Tile.FILLED? "■" : gameSet.get(i).get(j) == Tile.EMPTY? " " : "?");
            }
            System.out.println();
        }
    }
}
