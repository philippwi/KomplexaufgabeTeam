public class UnamSpiral {

    public Number[][] spiral = new Number[100][100]; //Basisgröße 100x100

    public int maximumIndex;

    public enum direction{  //Richtung, in welche die Spirale gerade gefüllt wird
        UP, DOWN, LEFT, RIGHT
    }

    public UnamSpiral(int x){
        this.maximumIndex = x;
        fill(this.maximumIndex);
    }

    public void fill(int valueAmount){
        if(valueAmount==0) return;
        direction dir = direction.DOWN;
        int value = 1;
        int x = 49; //49/48 ist die Position der 1 (Startposition der Spirale)
        int y = 48;

        while(value<=valueAmount) {

            spiral[x][y] = new Number(value);
            value++;

            switch (dir) {
                case RIGHT:
                    if(spiral[x-1][y]==null){
                        dir = direction.UP;
                        x--;
                    }
                    else y++;
                    break;
                case UP:
                    if(spiral[x][y-1]==null){
                        dir = direction.LEFT;
                        y--;
                    }
                    else x--;
                    break;
                case LEFT:
                    if (spiral[x+1][y]==null) {
                        dir = direction.DOWN;
                        x++;
                    } else y--;
                    break;
                case DOWN:
                    if(spiral[x][y+1]==null){
                        dir = direction.RIGHT;
                        y++;
                    }
                    else x++;
                    break;
            }
        }
    }
}
