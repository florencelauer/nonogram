import java.util.ArrayList;
import java.util.Arrays;

public class Solver {
    private Game game;

    private int getSum(ArrayList<Integer> indexes) {
        int sum = 0;

        for(int j = 0; j < indexes.size(); j++) {
            sum += indexes.get(j);
        }

        sum += indexes.size() - 1;

        return sum;
    }

    /*
    private class SplitLine {
        SplitLine(ArrayList<ArrayList<Tile>> splitGameSet, ArrayList<Integer> indexes) {
            this.splitGameSet = splitGameSet;
            this.indexes = indexes;
        }

        public ArrayList<ArrayList<Tile>> splitGameSet;
        public ArrayList<Integer> indexes;
    }

    private SplitLine splitOnZeros(ArrayList<Integer> line, String direction, int lineNum) {
        ArrayList<ArrayList<Tile>> splitGameSet = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int numberOfSplits = 0;
        boolean wasZero = true;
        splitGameSet.add(new ArrayList<>());

        int lineLength = direction == "column" ? game.getHeigth() : game.getWidth();
        for(int i = 0; i < lineLength; i++) {
            Tile tile = direction == "column" ? game.gameSet.get(i).get(lineNum) : game.gameSet.get(lineNum).get(i);
            if(tile != Tile.EMPTY) {
                if(splitGameSet.size() == numberOfSplits) {
                    splitGameSet.add(new ArrayList<>());
                }
                if(splitGameSet.get(numberOfSplits).size() == 0) {
                    indexes.add(i);
                }
                splitGameSet.get(numberOfSplits).add(tile);
                wasZero = false;

            } else if(!wasZero) {
                numberOfSplits++;
                wasZero = true;
            }
        }

        SplitLine splitLine = new SplitLine(splitGameSet, indexes);
        return splitLine;
    }

    private void splitAndFill(ArrayList<Integer> line, String direction, int lineNum) {
        SplitLine splitLine = splitOnZeros(line, direction, lineNum);

        //regarder on peut fitter combien de nombres dans chaque split. [0, 1, 2, 3...].
        // 0: On met le split en EMPTY et on l'enlève du tableau.
        // 1: Si le nombre ne se met pas ailleurs, on le met là.
        // 2+: Non concluant
        int lineIndex = 0;
        for(int i = 0; i < splitLine.splitGameSet.size(); i++) {
            // Too small space for the length of the next number
            if(splitLine.splitGameSet.get(i).size() < line.get(lineIndex)) {
                for(int j = splitLine.indexes.get(i); j < splitLine.splitGameSet.get(i).size(); j++) {
                    if(direction == "column") {
                        game.gameSet.get(j).set(lineNum, Tile.EMPTY);
                    } else {
                        game.gameSet.get(lineNum).set(j, Tile.EMPTY);
                    }
                }

                splitLine.indexes.remove(i);
                splitLine.splitGameSet.remove(i);

            } else if(lineIndex == line.size() - 1) {
                for(int k = splitLine.indexes.get(i) + splitLine.splitGameSet.get(i).size() - line.get(lineIndex);
                    k < splitLine.indexes.get(i) + line.get(lineIndex); k++) {
                    if(direction == "column") {
                        game.gameSet.get(k).set(lineNum, Tile.FILLED);
                    } else {
                        game.gameSet.get(lineNum).set(k, Tile.FILLED);
                    }
                }

            // The number is smaller than the spot
            } else if(splitLine.splitGameSet.get(i).size() < line.get(lineIndex) + line.get(lineIndex + 1)) {
                if(splitLine.splitGameSet.get(i).get(0) == Tile.FILLED) {
                    for(int k = splitLine.indexes.get(i); k < splitLine.indexes.get(i) + line.get(lineIndex); k++) {
                        if(direction == "column") {
                            game.gameSet.get(k).set(lineNum, Tile.FILLED);
                        } else {
                            game.gameSet.get(lineNum).set(k, Tile.FILLED);
                        }
                    }

                } else if(splitLine.splitGameSet.get(i).get(splitLine.splitGameSet.get(i).size() - 1) == Tile.FILLED) {
                    for(int k = splitLine.indexes.get(i) + splitLine.splitGameSet.get(i).size() - line.get(lineIndex);
                         k < splitLine.indexes.get(i) + splitLine.splitGameSet.get(i).size();
                         k++) {
                        if(direction == "column") {
                            game.gameSet.get(k).set(lineNum, Tile.FILLED);
                        } else {
                            game.gameSet.get(lineNum).set(k, Tile.FILLED);
                        }
                    }

                } else {
                    for(int k = splitLine.indexes.get(i) + splitLine.splitGameSet.get(i).size() - line.get(lineIndex);
                        k < splitLine.indexes.get(i) + line.get(lineIndex); k++) {
                        if(direction == "column") {
                            game.gameSet.get(k).set(lineNum, Tile.FILLED);
                        } else {
                            game.gameSet.get(lineNum).set(k, Tile.FILLED);
                        }
                    }
                }
            }

            if(lineIndex < line.size() - 1) {
                lineIndex++;
            } else {
                return;
            }
        }

    }

    private void splitAndFillAll() {
        for(int i = 0; i < game.getWidth(); i++) {
            completeLine(game.getColumn(i), "column", i);
            verifyBorder(game.getColumn(i), "column", i);
            splitAndFill(game.getColumn(i), "column", i);
        }
        for(int i = 0; i < game.getHeigth(); i++) {
            completeLine(game.getRow(i), "row", i);
            verifyBorder(game.getRow(i), "row", i);
            splitAndFill(game.getRow(i), "row", i);
        }
        fillEmpty("column");
        fillEmpty("row");
    }

     */

    private ArrayList<Tile> serialize(int lineNumber, boolean isLine) {
        if(isLine) {
            ArrayList<Tile> line = new ArrayList<>(game.gameSet.get(lineNumber));
            return line;
        }

        ArrayList<Tile> column = new ArrayList<>();
        for(int i = 0; i < game.getHeigth(); i++) {
            column.add(game.gameSet.get(i).get(lineNumber));
        }
        return column;
    }

    private void deserialize(ArrayList<Tile> line, int lineNumber, boolean isLine) {
        if(isLine) {
            for(int i = 0; i < game.getWidth(); i++) {
                if(game.gameSet.get(lineNumber).get(i) == Tile.UNSURE) {
                    game.gameSet.get(lineNumber).set(i, line.get(i));
                }
            }
        } else {
            for(int i = 0; i < game.getHeigth(); i++) {
                if(game.gameSet.get(i).get(lineNumber) == Tile.UNSURE) {
                    game.gameSet.get(i).set(lineNumber, line.get(i));
                }
            }
        }
    }

    // Look at the line indexes and fill it the most possible without looking at the current tiles values
    private void fillLine(ArrayList<Tile> line, ArrayList<Integer> indexes) {
        int sum = getSum(indexes);
        int currentSum = 0;
        for(int index : indexes) {
            for(int i = line.size() - (sum - currentSum); i < currentSum + index; i++) {
                line.set(i, Tile.FILLED);
            }

            currentSum += index;

            if(sum == line.size() && currentSum < sum) {
                line.set(currentSum, Tile.EMPTY);
            }

            currentSum++;
        }
    }

    // Verify if the first and last indexes can be used to fill tiles depending on the current FILLED tiles
    private void fillBorder(ArrayList<Tile> line, ArrayList<Integer> indexes) {
        boolean filledTile = false;
        int filledIndex = 0;
        int index = indexes.get(0);
        for(int i = 0; i < index; i++) {
            if(line.get(i) == Tile.FILLED) {
                filledTile = true;
                filledIndex = i;
                break;
            }
        }

        if(filledTile) {
            for (int i = filledIndex; i < index; i++) {
                line.set(i, Tile.FILLED);
            }
            if(filledIndex == 0 && index < line.size()) {
                line.set(index, Tile.EMPTY);
            }
        }

        filledTile = false;
        index = indexes.get(indexes.size()-1);
        for(int i = 0; i < index; i++) {
            if(line.get(line.size() - 1 - i) == Tile.FILLED) {
                filledTile = true;
                filledIndex = i;
                break;
            }
        }

        if(filledTile) {
            for (int i = filledIndex; i < index; i++) {
                line.set(line.size() - 1 - i, Tile.FILLED);
            }
            if(filledIndex == 0 && index < line.size()) {
                line.set(line.size() - 1 - index, Tile.EMPTY);
            }
        }
    }

    // Replace UNSURE tiles with EMPTY if all the FILLED tiles are present
    // Replace the UNSURE tiles with FILLED if all the EMPTY tiles are present
    private void removeUnsureOnCompletedLine(ArrayList<Tile> line, ArrayList<Integer> indexes) {
        int sum = 0;
        for(int index : indexes) {
            sum += index;
        }

        int filledSum = 0;
        int filledAndUnsureSum = 0;
        for(int i = 0; i < line.size(); i++) {
            filledSum += (line.get(i) == Tile.FILLED) ? 1 : 0;
            filledAndUnsureSum += (line.get(i) == Tile.EMPTY) ? 0 : 1;
        }

        if(sum == filledSum) {
            for (int i = 0; i < line.size(); i++) {
                if (line.get(i) == Tile.UNSURE) {
                    line.set(i, Tile.EMPTY);
                }
            }
        }

        if(sum == filledAndUnsureSum) {
            for (int i = 0; i < line.size(); i++) {
                if (line.get(i) == Tile.UNSURE) {
                    line.set(i, Tile.FILLED);
                }
            }
        }
    }

    // Replace UNSURE tiles with EMPTY if they are far away from a FILLED tile on a single index
    private void emptySurroundingUnsure(ArrayList<Tile> line, ArrayList<Integer> indexes) {
        if(indexes.size() != 1) return;

        int first = 0;
        int last = 0;
        boolean filledTilePresent = false;
        for(int i = 0; i < line.size(); i++) {
            if(line.get(i) == Tile.FILLED) {
                if(!filledTilePresent) {
                    first = i;
                }
                filledTilePresent = true;
                last = i;
            }
        }

        if(!filledTilePresent) return;

        int index = indexes.get(0);
        for(int i = 0; i <= last - index; i++) {
            line.set(i, Tile.EMPTY);
        }
        for(int i = first + index; i < line.size(); i++) {
            line.set(i, Tile.EMPTY);
        }
    }

    // Trims EMPTY and FILLED tiles at borders and fills the line
    //TODO: Verify if the FILLED trimming works well
    private void trimAndFillLine(ArrayList<Tile> line, ArrayList<Integer> indexes) {
        ArrayList<Integer> newIndexes = new ArrayList<>(indexes);
        int start = 0;
        int end = line.size() - 1;

        for(int i = 0; i < line.size(); i++) {
            if(newIndexes.isEmpty()) {
                return;
            }

            if(line.get(i) == Tile.UNSURE) {
                start = i;
                break;
            }

            if(line.get(i) == Tile.FILLED) {
                i += newIndexes.get(0);
                newIndexes.remove(0);
            }
        }

        for(int i = line.size() - 1; i > 0; i--) {
            if(newIndexes.isEmpty()) {
                return;
            }

            if(line.get(i) == Tile.UNSURE) {
                end = i;
                break;
            }

            if(line.get(i) == Tile.FILLED) {
                i -= newIndexes.get(newIndexes.size() - 1);
                newIndexes.remove(newIndexes.size() - 1);
            }
        }

        ArrayList<Tile> trimmedLine = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            trimmedLine.add(line.get(i));
        }

        fillLine(trimmedLine, newIndexes);
        fillBorder(trimmedLine, newIndexes);
        removeUnsureOnCompletedLine(trimmedLine, newIndexes);
        emptySurroundingUnsure(trimmedLine, newIndexes);

        for(int i = start; i <= end; i++) {
            line.set(i, trimmedLine.get(i - start));
        }
    }

    private void fillLinesIndependently() {
        for(int i = 0; i < game.getWidth(); i++) {
            ArrayList<Tile> column = serialize(i, false);
            fillLine(column, game.getColumn(i));
            fillBorder(column, game.getColumn(i));
            removeUnsureOnCompletedLine(column, game.getColumn(i));
            emptySurroundingUnsure(column, game.getColumn(i));
            trimAndFillLine(column, game.getColumn(i));
            deserialize(column, i, false);
        }

        for(int i = 0; i < game.getHeigth(); i++) {
            ArrayList<Tile> row = serialize(i, true);
            fillLine(row, game.getRow(i));
            fillBorder(row, game.getRow(i));
            removeUnsureOnCompletedLine(row, game.getRow(i));
            emptySurroundingUnsure(row, game.getRow(i));
            trimAndFillLine(row, game.getRow(i));
            deserialize(row, i, true);
        }
    }

    /*
    TODO
    Logic: Fill simple cases, then split the lines in smaller ones and fill the simple cases again

    Be able to recognize if an ensemble of FILLED tiles are part of a specific index to split the lines into smaller ones
        Maybe add a "done", index parameters to indexes, to not have to iterate over the entire line every time.
        This would split the lines into smaller ones on which it is possible to call fillLine again
        case: Trim borders (completed number, remove indexes also; remove EMPTY tiles)
        case: Remove UNSURE if they are too small for index
        case: Split if a pack of FILLED is bigger than index -> split indexes to match (call recursively)
     */
    public void solve(Game game) {
        this.game = game;
        fillLinesIndependently();
        fillLinesIndependently();
        fillLinesIndependently();
        fillLinesIndependently();
    }
}
