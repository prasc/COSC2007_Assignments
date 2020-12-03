public class Maze {

    static char[][] maze = {
            { '.', '#', '.', '.'} ,
            { 'S', '.', '.', '.'},
            { '.', '#', '.', 'E'}
    };

    private static char read(Location location) {
        return maze[location.row][location.col];
    }

    private static void write(Location location, char symbol) {
        if (read(location) != 'S' || read(location) != 'E' || read(location) != '#') {
            maze[location.row][location.col] = symbol;
        }
    }

    public static void solve() {
        display();

        Location start = getStart();

        if (searchPath(start)) {
            display();
        } else {
            System.out.println("Path not found");
        }
    }

    private static void display() {
        System.out.println();
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                System.out.print(read(new Location(r, c)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static Location left(Location location) {
        return new Location(location.row, location.col - 1);
    }

    private static Location right(Location location) {
        return new Location(location.row, location.col + 1);
    }

    private static Location up(Location location) {
        return new Location(location.row + 1, location.col + 1);
    }

    private static Location down(Location location) {
        return new Location(location.row + 1, location.col);
    }

    private static void markVisited(Location location) {
        write(location, '-');
    }

    private static void markPath(Location location) {
        write(location, '*');
    }

    private static boolean isEnd(Location location) {
        return read(location) == 'E';
    }

    private static boolean isValid(Location location) {
        if (!(location.col >= 0 && location.col < 4 && location.row >= 0 && location.row < 4)) {
            return false;
        }

        char symbol = read(location);
        if (!(symbol == '.' || symbol == 'S' || symbol == 'E')) {
            return false;
        }

        return true;
    }

    private static Location getStart() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                Location location = new Location(row, col);
                if (read(location) == 'S') {
                    return location;
                }
            }
        }
        return new Location(-1, -1);
    }

    private static boolean searchPath(Location location) {
        boolean success = false;

        if (isValid(location)) {
            if (isEnd(location)) {
                success = true;
            } else {
                markVisited(location);
                success = searchPath(left(location));

                if (!success) {
                    success = searchPath(right(location));
                }

                if (!success) {
                    success = searchPath(up(location));
                }

                if (!success) {
                    success = searchPath(down(location));
                }

                if (success) {
                    markPath(location);
                }
            }
        }
        return success;
    }


}
