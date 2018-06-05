package co.hypw;

public class PrepareMap {
    private Character[][] map;
    private int[][] path;

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
