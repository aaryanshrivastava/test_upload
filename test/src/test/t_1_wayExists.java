package test;
import java.util.ArrayList;
import java.util.List;

public class t_1_wayExists {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean routeExists(boolean[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {
        List<List<Integer>> path = new ArrayList<>();
        path.add(new ArrayList<>(List.of(startRow, startColumn)));

        boolean found = false;
        while (!path.isEmpty()) {
            List<Integer> current = path.remove(0);
            int row = current.get(0);
            int column = current.get(1);

            if (row == endRow && column == endColumn) {
                found = true;
                break;
            }

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];

                if (newRow >= 0 && newRow < matrix.length && newColumn >= 0 && newColumn < matrix[0].length && matrix[newRow][newColumn]) {
                    path.add(new ArrayList<>(List.of(newRow, newColumn)));
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{
            {true, false, false},
            {true, true, false},
            {false, true, true}
        };

        System.out.println(routeExists(matrix, 0, 0, 2, 2)); // true
        System.out.println(routeExists(matrix, 0, 0, 0, 0)); // false
    }
}
