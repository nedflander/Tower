package co.hypw;

public class PrepareMap {
    private Character[][] map;
    private Character[][] path;

    public PrepareMap() {
        map = new Character[][]{{'e','g','g','g','g','g','s','b','b','b','b','b'},
                            {'g','r', 'r', 'r','r','b','g','r', 'r', 'r','r','b'},
                            {'g','b','b','b','b','b','e','g','g','g','g','s'},
                            { 'g','r', 'r', 'r','r','b','b','r', 'r', 'r','r','g'},
                            {'n','g', 'g', 'g','g','w','s','g', 'g', 'g','g','w'},
                            { 'b','r', 'r', 'r','r','g','g','r', 'r', 'r','r','b'},
                            {'e','g', 'g', 'g','g','n','e','g', 'g', 'g','g','s'},
                            { 'g','r', 'r', 'r','r','b','b','r', 'r', 'r','r','g'},
                            {'n','g', 'g', 'g','g','w','s','g', 'g', 'g','g','w'},
                            { 'b','r', 'r', 'r','r','g','g','r', 'r', 'r','r','b'},
                            {'e','g', 'g', 'g','g','n','e','g', 'g', 'g','g','s'},
                            {'g','r', 'r', 'r','r','r','r','r', 'r', 'r','r','g'}};

        path = new int[][]{ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {16, 17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0},
                            {15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {14, 13, 12, 11, 10, 9, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0},
                            {2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        setTypes();
    }

    private void setTypes() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                Tile tile = Tile.getTileWithId(i*12+j);
                if(tile != null) {
                    if (map[i][j] == 'g') {
                        tile.setType(Tile.Type.FRIENDLY);
                    } else if (map[i][j] == 'b') {
                        tile.setType(Tile.Type.BARRIER);
                    } else if (map[i][j] == 'r') {
                        tile.setType(Tile.Type.ENEMY);
                    } else if (map[i][j] == 'n') {
                        tile.setType(Tile.Type.NORTH);
                    } else if (map[i][j] == 's') {
                        tile.setType(Tile.Type.SOUTH);
                    } else if (map[i][j] == 'w') {
                        tile.setType(Tile.Type.WEST);
                    } else if (map[i][j] == 'e') {
                        tile.setType(Tile.Type.EAST);
                    }
                }
            }
        }
    }

}
