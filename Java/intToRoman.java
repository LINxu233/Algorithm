import java.util.HashMap;
import java.util.Map;

/**
 * ClassName intToRoman
 * Author  Lin
 * Date 2018/8/4 9:12
 **/

public class intToRoman {
    public static  String intToRomans(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1000,"M");map.put(900,"CM");map.put(800,"DCCC");map.put(700,"DCC");map.put(600,"DC");map.put(500,"D");
        map.put(400,"CD");map.put(300,"CCC");map.put(200,"CC");map.put(100,"C");
        map.put(90,"XC");map.put(80,"LXXX");map.put(70,"LXX");map.put(60,"LX");
        map.put(50,"L");map.put(40,"XL");map.put(30,"XXX");map.put(20,"XX");map.put(10,"X");
        map.put(9,"IX");map.put(8,"VIII");map.put(7,"VII");map.put(6,"VI");map.put(5,"V");map.put(4,"IV");
        map.put(3,"III");map.put(2,"II");
        map.put(1,"I");
        //
        String[][] romans = {   {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, //1-9
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, //10-90
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, //100-900
                {"M", "MM", "MMM"}//1000-3000
        };//映射数组，不需要map也可以
        //StringBuilder sb = new StringBuilder();

/*        String romans[][] = {   {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, //1-9
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, //10-90
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, //100-900
                {"M", "MM", "MMM"}
        };//1000-3000
        int n =num;
        //String ss = "";
        if(n/1000!=0){

            sb.append(romans[3][n/1000 - 1]);
            n = n - n/1000 *1000;
        }
        if(n/100!=0){
            sb.append(romans[2][n/100-1]);
            n = n - n/100 *100;
        }
        if(n/10!=0){
            sb.append(romans[1][n/10-1]) ;
            n = n - n/10 *10;
        }
        if(n!=0)
        {
            sb.append(romans[0][n-1]);
        }

        return sb.toString();*/
        int n =num;
        String ss = "";
        if(n/1000!=0){

            ss += map.get(n/1000*1000);
            n = n - n/1000 *1000;
        }
        if(n/100!=0){
            ss += map.get(n/100 * 100);
            n = n - n/100 *100;
        }
        if(n/10!=0){
            ss += map.get(n/10*10);
            n = n - n/10 *10;
        }
        ss += map.get(n);
        return ss;
    }
    public static void main(String[]args){
        Integer[] ss = {3,4,9,1994,58};
        for(int s:ss){
            System.out.println(intToRomans(s));
        }
    }
}
