class Solution {
    //n: 사람수 (10억)
    //times: 검사하는데 걸리는 시간.(최대 10억)
    //times.length: 최대 10만
    public long solution(int peopleNum, int[] times) {
        //0분~10억^2 으로 binarySearch시작
        //mid값(시간) 안에 n명을 수행할 수 있는지 판단하고 범위를 좁힘
        //mid안에 가능하다고 하더라도, 더 작은 범위에서 binarySearch해야 함.
        long left = 0L;
        long right = 1_000_000_000L * 1_000_000_000L;
        long minTime = 1_000_000_000L * 1_000_000_000L + 1000L;
        
        while (left <= right) {
            long mid = (left + right)/2;
            
            //mid시간안에 검사할 수 있는 인원수 파악
            long possibleNum = getPossibleCheckNum(mid, times);
            
            //인원수가 peopleNum보다 크거나 같다면, right를 줄이고
            if (possibleNum >= peopleNum) {
                minTime = mid;
                right = mid - 1;
            }
            //작다면 left를 키움.
            else {
                left = mid + 1;
            }
        }
        
        return minTime;
    }
    
    public static long getPossibleCheckNum(long limit, int[] times) {
        long peopleNum = 0L;
        for (int time : times) {
            peopleNum += limit/(long)time ;
        }
        return peopleNum;
    }
}