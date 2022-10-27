package main.java.字符串.IP地址;

import java.util.ArrayList;
import java.util.List;

public class 求一个数字字符串的所有合法ip地址 {
    /**
     *
     * 一个有效的 IP 地址正好由四个由单点分隔的整数组成。每个整数都介于0和255（包括）之间，并且不能有前导零。
     *
     *
     * s给定一个只包含数字的字符串，返回所有可能的有效 IP 地址，这些地址可以通过在s. 您不得重新排序或删除 中的任何数字s。您可以按任何顺序返回有效的 IP 地址。
     *
     *
     * 输入： s = "25525511135"
     * 输出： ["255.255.11.135","255.255.111.35"]
     *
     *
     * 输入： s = "101023"
     * 输出： ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *
     *
     * 输入： s = "0000"
     * 输出： ["0.0.0.0"]
     *
     * 1 <= s.length <= 20
     *
     */

    List<String> ans = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {

        //Check if string is valid length
        if(s.length() < 4 || s.length() > 12)
            return ans;

        //Check if string contains non numerical values
        if(!s.matches("^[0-9]+$"))
            return ans;

        ip(s, 0 , "");
        return ans;
    }

    public void ip(String s , int x , String ad){
        //If at last integer
        if(x == 3){
            int num = -1;
            if(s.length() > 0){
                num =  Integer.parseInt(s);
            }

            if(s.length() > 1 && s.charAt(0) == '0'){}
            else if(num >= 0 && num<= 255) {
                ans.add(ad+"."+s); //Adding to list of string ans
            }
        }
        else{
            int lim = Math.min(3, s.length());
            for(int i = 0 ; i < lim ; i++){
                String temp = s.substring(0 , i+1);
                int num = Integer.parseInt(temp);
                if(i > 0 && temp.charAt(0) == '0'){}
                else if(num >= 0 && num<= 255) {
                    if(x==0){
                        ip(s.substring(i+1), x + 1, temp);
                    }
                    else{
                        ip(s.substring(i+1), x + 1, ad+"."+temp);
                    }

                }
            }
        }
    }

}
