import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        //국가 수, 특정 국가 받기
        int numCountry=Integer.parseInt(st.nextToken());
        int searchId=Integer.parseInt(st.nextToken());

        //국가 수 만큼 입력받고 저장
        Country[] countries = new Country[numCountry];
        for (int i=0;i<numCountry;i++){

            //한 줄 가져옴
            st = new StringTokenizer(br.readLine());

            //끊어서 각각 id, gold, sliver, bronze로 생성
            int id=Integer.parseInt(st.nextToken());
            int gold=Integer.parseInt(st.nextToken());
            int sliver=Integer.parseInt(st.nextToken());
            int bronze=Integer.parseInt(st.nextToken());
            countries[i]=new Country(id,gold,sliver,bronze);
        }
        //배열 정렬
        Arrays.sort(countries);
//        for (Country country : countries){
//            System.out.println(country.id);
//        }
        int rank = 0;
        //serachId의 인덱스 찾아서 +1하기
        for (int i=0;i<numCountry;i++){
            if (countries[i].id==searchId){
                rank=i+1;
                break;
            }
        }

        int realRank = rank;
        //앞의 숫자와 같다면, 그 숫자로 출력하기
        for (int i=rank-2;i>=0;i--){
           // System.out.println(countries[rank].compareTo(countries[i]));
            //객체 비교 어케함!!
            if (countries[rank-1].compareTo(countries[i])==0){
                realRank--;
             //   System.out.println("dd");
            }
            else break;
        }

        System.out.println(realRank);
        //바로 입력 처리 가능? -> X

    }

    //내부 클래스는 static을 사용해야 하는가?
    static class Country implements Comparable<Country>{
        int id;
        int gold;
        int silver;
        int bronze;

        public Country(int id,int gold, int silver, int bronze) {
            this.id=id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (o.gold==this.gold){
                if (o.silver==this.silver){
                    return o.bronze-this.bronze;
                }
                else return o.silver-this.silver;
            }
            else return o.gold-this.gold;
        }


    }
}
