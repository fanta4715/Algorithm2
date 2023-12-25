import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int N = 0;
    static final int S = 1;
    static final int clockwise = 1;
    static final int counterclockwise = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gear[] gears = new Gear[5];
        String line;
        //gear1,2,3,4에 값 넣기
        for (int i = 1; i < 5; i++) {
            line = br.readLine();
            int numbers[] = new int[8];
            for (int j = 0; j < 8; j++) {
                 numbers[j] = line.charAt(j)-'0';
            }
            gears[i] = new Gear(numbers);
        }

        //rotateCnt받기
        int rotateCnt = Integer.parseInt(br.readLine());

        //for : rotateCnt
        // pointer옮기기
        for (int i = 0; i < rotateCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

//            System.out.println("round"+i);
            rotateGears(gears, gearNum, direction);
//            System.out.println();
        }

        //pointer에 해당하는 결과값 반환
        int result = calculateResult(gears);

        //결과값 출력
        System.out.println(result);
    }

    private static void rotateGears(Gear[] gears, int gearNum, int direction) {
        //같이 돌아가는 애들 파악
        int[] directions = new int[5];
        directions[gearNum] = direction;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(gearNum);

        while (!queue.isEmpty()) {
            int targetGearNum = queue.poll();
            int targetGearRight = gears[targetGearNum].getRightDirNum();
            int targetGearLeft = gears[targetGearNum].getLeftDirNum();

            if (targetGearNum > 1 && directions[targetGearNum - 1] == 0) {
                //targetGearNum-1 기어의
                int nearGearRight = gears[targetGearNum - 1].getRightDirNum();
                if (nearGearRight != targetGearLeft) {
                    queue.add(targetGearNum - 1);
                    directions[targetGearNum - 1] = directions[targetGearNum] * -1;
                }
                //가장 오른쪽 값 (pointer를 통해 확인) == targetGear의 왼쪽값
            }
            if (targetGearNum < 4 && directions[targetGearNum + 1] == 0) {
                int nearGearLeft = gears[targetGearNum + 1].getLeftDirNum();
                if (nearGearLeft != targetGearRight) {
                    queue.add(targetGearNum + 1);
                    directions[targetGearNum + 1] = directions[targetGearNum] * -1;
                }
            }
        }
        //bfs로 파악
        //순차적으로 돌리기
        for (int i = 1; i < 5; i++) {
            if (directions[i]!=0) {
                gears[i].rotate(directions[i]);
//                System.out.println("gear["+i+"] rotate : "+directions[i]);
            }
        }
    }

    static int calculateResult(Gear[] gears) {
        int result = 0;
        int score = 1;
        for (int i = 1; i < 5; i++) {
            if (gears[i].getUpDirNum() == S) {
                result += score;
            }
            score *= 2;
        }
        return result;
    }
}

class Gear {
    int[] numbers;
    int pointer;

    public Gear(int[] numbers) {
        this.numbers = numbers;
        pointer = 0;
    }

    public int getUpDirNum() {
        return numbers[pointer];
    }

    public int getRightDirNum() {
        return numbers[(pointer + 2) % 8];
    }

    public int getLeftDirNum() {
        return numbers[(pointer + 6) % 8];
    }

    public void rotate(int direction) {
        //dir이 -1이면 pointer +1
        if (direction == -1) {
            pointer = (pointer + 1) % 8;
            return;
        }
        pointer = (pointer + 7) % 8;
    }
}
