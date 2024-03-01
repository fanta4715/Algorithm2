import java.util.*;
class Solution {
    static public String sort;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        sort = sort_by;
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Data dataInList = new Data(data[i][0],data[i][1],data[i][2],data[i][3]);
            if (isValidData(dataInList, ext, val_ext)) list.add(dataInList);
        }
        Collections.sort(list);
        int[][] answer = new int[list.size()][4];
        for (int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).maximum;
            answer[i][3] = list.get(i).remain;
        }
        return answer;
    }
    
    public boolean isValidData(Data data, String ext, int val_ext) {
        if (ext.equals("code")) return data.code <= val_ext; 
        if (ext.equals("date")) return data.date <= val_ext;
        if (ext.equals("maximum")) return data.maximum <= val_ext;
        return data.remain <= val_ext;
    }
    
    static class Data implements Comparable<Data> {
        int code;
        int date;
        int maximum;
        int remain;
        
        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
        
        @Override
        public int compareTo(Data d) {
            if (sort.equals("code")) return code - d.code;
            if (sort.equals("date")) return date - d.date;
            if (sort.equals("maximum")) return maximum - d.maximum;
            return remain - d.remain;
        }
    }
}
