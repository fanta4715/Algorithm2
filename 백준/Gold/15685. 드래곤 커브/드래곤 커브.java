
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //101 * 101 grid 생성
    static boolean[][] grid = new boolean[101][101];
    static List<Point> points = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        //curveNum 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int curveNum = Integer.parseInt(br.readLine());

        //curveNum만큼 curve입력받음
        //curve에 해당하는 좌표를 grid에 찍어놓음
        for (int i = 0; i < curveNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());
            markingGrid(x, y, direction, generation);
            points.clear();
        }

        //전체 순회하면서 박스 카운팅
        System.out.println(getSquareCnt());
    }

    private static void markingGrid(int x, int y, int direction, int generation) {
        //1. 0세대 기준 끝점 표시 후 포인트에 추가
        points.add(new Point(x, y));
        Point endPoint = new Point(x + dx[direction], y + dy[direction]);
        points.add(endPoint);

        //2. 나머지 모든 좌표를 90도 돌린 좌표를 큐에 추가함.
        for (int i = 1; i <= generation; i++) {
            int rotateCnt = points.size();
            for (int j = 0; j <rotateCnt; j++) {
                Point point = points.get(j);
                if (point == endPoint) {
                    continue;
                }
                Point rotatedPoint = rotate(point, endPoint);
                points.add(rotatedPoint);

            }
            endPoint = rotate(points.get(0), endPoint);
        }

        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            grid[point.x][point.y] = true;
        }
    }

    private static Point rotate(Point point, Point endPoint) {
        int a = point.x;
        int b = point.y;

        int x = endPoint.x;
        int y = endPoint.y;
        return new Point(x + y - b, y - x + a);
    }

    static int getSquareCnt() {

        int squareCnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                //좌표가 존재한다면
                if (grid[i][j] && grid[i][j + 1] && grid[i + 1][j] && grid[i + 1][j + 1]) {
                    squareCnt++;
                }
            }
        }
        return squareCnt;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}