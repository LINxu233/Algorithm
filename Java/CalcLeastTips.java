import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CalcLeastTips {
    public static ArrayList<Integer> parseLineToIntegers(String line) {
        String[] elems = line.split(",");
        ArrayList<Integer> numbers = new ArrayList<Integer>(elems.length);
        for (int i = 0; i < elems.length; ++ i) {
            numbers.add(Integer.valueOf(elems[i]));
        }
        return numbers;
    }
    public static int calcLeastTips(ArrayList<Integer> scores) {
        int sum = 0;
        int currentI =1;
        int currentJ =1;
        int currentScoreI = -1;
        int currentScoreJ = -1;

        int len = scores.size();
        int[] tips = new int[len];
        ArrayList<Integer> Max = new ArrayList<>(len);
        int maxCnt=0;int minCnt=0;
        ArrayList<Integer> Min = new ArrayList<>(len);

        for(int i=0;i<len;i++){
            if( (i==0&&scores.get(i)<=scores.get(i+1)) || (i==len-1&&scores.get(i)<=scores.get(i-1) ) ||
                    (scores.get(i)<=scores.get(i+1)&& scores.get(i)<=scores.get(i-1))){
                Min.add(i);
            }
            else if((i==0&&scores.get(i)>scores.get(i+1)) || (i==len-1&&scores.get(i)>scores.get(i-1) ) ||
                    (scores.get(i)>scores.get(i+1)&& scores.get(i)>scores.get(i-1)) ){
                Max.add(i);
            }
        }
        for(int i=0;i<Max.size();i++)
            System.out.print("峰"+i+":"+Max.get(i)+" ");
        for(int i=0;i<Min.size();i++)
        {
            System.out.print("谷"+i+":"+Min.get(i)+" ");
            tips[Min.get(i)] = 1;
        }

        for(int i=0;i<Min.size();i++)
        {
            int k = Min.get(i);
            //tips[k] = 1;
            currentScoreI = currentScoreJ = scores.get(k);
            currentI=currentJ=1;
            int left =  k - 1;
            int right = k + 1;
            while (left >= 0)
            {
                if (left>=0&&scores.get(left) > currentScoreI) {
                    currentI++;
                    currentScoreI = scores.get(left);
                    if (Max.contains(left) ) {
                        tips[left] =  currentI > tips[left]?currentI:tips[left];
                        break;
                    }else{
                        tips[left] = currentI;
                        left--;
                    }

                } else {
                    break;
                }
            }
            while (right < len)
            {
                if (right<len&&scores.get(right) > currentScoreJ) {
                    currentJ++;
                    currentScoreJ = scores.get(right);
                    if (Max.contains(right) && currentJ > tips[right]) {
                        tips[right] = currentJ;
                        break;
                    }
                    else{
                        tips[right] = currentJ;
                        right++;
                    }

                } else {
                    break;
                }

            }

        }

        for(int i =0 ;i <len; i++)
        {sum+= tips[i];System.out.print(tips[i]+" ");}
        return sum;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
           // String line = scanner.nextLine();
           // ArrayList<Integer> scores = parseLineToIntegers(line);
           // ArrayList<Integer> sss = new ArrayList<>(){2,3,4,1,2,8,12,1,2,4,99,74};
            ArrayList<Integer> ss = new ArrayList<>(Arrays.asList(2,3,4,1,2,8,12,1,2,4,99,74));
            for(Integer i:ss)
                System.out.print(" "+i);
            System.out.println();
            int sum = calcLeastTips(ss);
            System.out.println(sum);
      //  }
    }
}