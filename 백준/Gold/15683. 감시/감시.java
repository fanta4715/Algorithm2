import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static int min = 100;
    static List<CCTV> cctvs = new ArrayList<>();
    static int ROW;
    static int COL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //row col 받고
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        //배열생성
        int[][] map = new int[ROW][COL];

        //배열 차례대로 받아서 저장
        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        //for cctv개수 (cctv의 좌표를 배열로 저장해야 함)
        //dfs
        if (cctvs.size() == 0) {
            System.out.println(findUnwatchedArea(map));
            return;
        }
        dfs(0, map);
        //min값 출력
        System.out.println(min);
    }

    private static void dfs(int index, int[][] map) {
        // 마지막 타이밍인 경우, 시도하고 계산하고 map초기화
        for (int i = 0; i < 4; i++) {
            //현재 가리는 크기 구하기
            CCTV nowCctv = cctvs.get(index);
            if (index == cctvs.size() - 1) {
                int unwatchedArea = findUnwatchedArea(map);
                min = (min > unwatchedArea) ? unwatchedArea : min;
                nowCctv.rotate();
                continue;
            }
            dfs(index + 1, map);
            nowCctv.rotate();
        }
    }

    private static int findUnwatchedArea(int[][] map) {
        //cctvs를 갖고 모든 cctv로 방향에 해당하는 거 마킹하기
        markingMapWithCCTVs(map, cctvs);
        //0 세기
        int area = countZero(map);
        //마킹을 0으로 복귀시키기
        clearMap(map);
        return area;
    }

    private static void markingMapWithCCTVs(int[][] map, List<CCTV> cctvs) {
        for (CCTV cctv : cctvs) {
            cctv.markingMapWithCCTV(map);
        }
    }

    private static int countZero(int map[][]) {
        int area = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 0) {
                    area++;
                }
            }
        }
        return area;
    }

    private static void clearMap(int map[][]) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 7) {
                    map[i][j] = 0;
                }
            }
        }
    }
}

class CCTV {
    //상 우 하 좌    순서
    int row;
    int col;
    boolean[] direction;
    int point;

    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};

    public CCTV(int number, int row, int col) {
        switch (number) {
            case 1:
                direction = new boolean[]{false, true, false, false};
                break;
            case 2:
                direction = new boolean[]{false, true, false, true};
                break;
            case 3:
                direction = new boolean[]{true, true, false, false};
                break;
            case 4:
                direction = new boolean[]{true, true, false, true};
                break;
            case 5:
                direction = new boolean[]{true, true, true, true};
                break;
        }
        point = 0;
        this.row = row;
        this.col = col;
    }

    List<Integer> getDirection() {
        List<Integer> directions = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (direction[(point + i) % 4]) {
                directions.add(i);
            }
        }
        return directions;
    }

    void rotate() {
        point = (point + 1) % 4;
    }


    public void markingMapWithCCTV(int map[][]) {
        List<Integer> directions = getDirection();
        int x = row;
        int y = col;

        for (int i = 0; i < directions.size(); i++) {
            while (x >= 0 && x < Main.ROW && y >= 0 && y < Main.COL) {
                x = x + dRow[directions.get(i)];
                y = y + dCol[directions.get(i)];
                if (x >= 0 && x < Main.ROW && y >= 0 && y < Main.COL
                        && map[x][y] != 6) {
                    if (map[x][y] == 0) {
                        map[x][y] = 7;
                    }
                }
                if (x >= 0 && x < Main.ROW && y >= 0 && y < Main.COL
                        && map[x][y] == 6) {
                    break;
                }
            }
            x = row;
            y = col;
        }
    }
}
