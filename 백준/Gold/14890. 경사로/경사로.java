import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//boj14890
public class Main {
    static int[][] map;
    static int rampWidth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //mapWidth,  rampWidth 받기
        int mapWidth = Integer.parseInt(st.nextToken());
        rampWidth = Integer.parseInt(st.nextToken());

        //for mapWidth 2중
        //map채우기
        map = new int[mapWidth][mapWidth];
        for (int i = 0; i < mapWidth; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapWidth; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int horizontalRoadCnt = getHorizontalRoadCnt(mapWidth);
        rotateMap(mapWidth);
        int verticalRoadCnt = getHorizontalRoadCnt(mapWidth);
        System.out.println(horizontalRoadCnt + verticalRoadCnt);

    }

    private static void rotateMap(int mapWidth) {
        int[][] rotatedMap = new int[mapWidth][mapWidth];
        for (int i=0;i<mapWidth;i++) {
            for (int j =0;j<mapWidth;j++){
                // 0 0 -> 5 0
                // 0 1 -> 4 0
                // 0 2 -> 3 0
                rotatedMap[mapWidth-j-1][i] = map[i][j];
                // 1 0 -> 5 1
                // 1 1 -> 4 1
            }
        }
        map = rotatedMap;
    }

    private static int getHorizontalRoadCnt(int mapWidth) {
        int count = 0;
        boolean[][] mapWithRamp = new boolean[mapWidth][mapWidth];
        for (int i = 0; i < mapWidth; i++) {
            /*한 라인에서 되는지 확인하고 count추가*/
            int pre = map[i][0];
            boolean disableLine = false;
            for (int j = 1; j < mapWidth; j++) {
                int now = map[i][j];
                //pre이랑 값 똑같으면 지나감
                if (pre == now) {
                    pre = now;
                    continue;
                }

                //pre랑 값 1차이 나면
                if (Math.abs(pre - now) == 1) {
                    //now가 더 작은 경우
                    if (now < pre) {
                        //L까지의 now값이 존재하는지 확인
                        for (int k = 1; k < rampWidth; k++) {
                            if (j + k >= mapWidth || now != map[i][j + k]) {
                                disableLine = true;
                                break;
                            }
                        }

                        if (!disableLine) {
                            for (int k = 0; k < rampWidth; k++) {
                                mapWithRamp[i][j + k] = true;
                            }
                            j = j + rampWidth - 1;
                            pre = map[i][j];
                        }

                    }

                    //now가 더 큰 경우
                    else {
                        for (int k = 1; k <= rampWidth; k++) {
                            if (j - k < 0 || pre != map[i][j - k] || mapWithRamp[i][j - k]) {
                                disableLine = true;
                                break;
                            }
                        }

                        if (!disableLine) {
                            for (int k = 1; k <= rampWidth; k++) {
                                mapWithRamp[i][j - k] = true;
                            }

                        }
                        pre = now;
                    }

                    if (disableLine) {
                        break;
                    }
                }

                //pre랑 값 1보다 크게 차이나면 중지
                if (Math.abs(pre - now) > 1) {
                    disableLine = true;
                    break;
                }
            }
            if (!disableLine) {
                count++;
            }
        }
        return count;
    }
}
