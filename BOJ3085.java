import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    static int n = 0;
    static char[][] array;

    static int result = 1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char temp;
        // nxn보드
        n = Integer.parseInt(br.readLine());
        array = new char[n + 1][n + 1];
        // 사탕 배열

        // 사탕입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            array[i] = str.toCharArray();
        }


        for(int i=0;i<n;i++) {
            for(int j=0;j<n-1;j++) {
                //양옆 바꾸고
                swapBothSide(i, j);
                //비교
                compare();
                //원상복귀
                swapBothSide(i, j);

                //위아래 바꾸고
                swapUpAndDown(j, i);
                //비교
                compare();
                //원상복귀
                swapUpAndDown(j, i);
            }
        }

        System.out.println(result);

    }

    static void swapBothSide(int i,int j) {
        char temp;
        temp = array[i][j];
        array[i][j] = array[i][j+1];
        array[i][j+1]= temp;
    }


    static void swapUpAndDown(int j,int i) {
        char temp;
        temp = array[j][i];
        array[j][i] = array[j+1][i];
        array[j+1][i]= temp;
    }


    static void compare() {
        //양옆 비교
        for(int i=0;i<n;i++) {
            //한 줄, 한 행마다 초기화 그리고 사탕은 무조건 1개 이상
            int sum=1;
            for(int j=0;j<n-1;j++) {
                //양옆이 같다면
                if(array[i][j]==array[i][j+1]) {
                    //sum ++;
                    sum ++;
                }else { //다를때
                    //이전의 누적 사탕 갯수와 현재 누적 사탕 갯수 비교
                    result = Math.max(sum, result);
                    //가장 큰 값을 정해줬으니까 sum은 다시 1로 초기화
                    sum = 1;
                }
            }
            //한줄 다 돌고 result 보다 큰 sum이 존재할 수 있기 때문에 갱신 해줘야함 ex) aabbb
            result = Math.max(sum, result);
        }

        //위아래 비교
        for(int i=0;i<n;i++) {
            int sum =1;
            for(int j=0;j<n-1;j++) {
                if(array[j][i]==array[j+1][i]) {
                    sum++;
                }else {
                    result = Math.max(sum, result);
                    sum = 1;
                }
            }
            result = Math.max(sum, result);
        }
    }


}
