public class Solution {
    public String multiply(String num1, String num2) {
        char[] str1 = num1.toCharArray();
        char[] str2 = num2.toCharArray();
        char[] result = new char[str1.length + str2.length];

        for (int i = 0; i < result.length; i++) result[i] = '0';

        reverse(str1);
        reverse(str2);

        int tmp = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                tmp = (str1[i] - '0') * (str2[j] - '0') + (result[i + j] - '0');
                result[i + j] =  (char)(tmp % 10 + '0');
                
                result[i + j + 1] += tmp / 10;
            }
        }

        reverse(result);

      
        int count = 0;
        for (int i = 0; i < result.length && result[i] == '0'; i++, count++); /* empty */

        if (count == result.length) return "0";
        return new String(result, count, result.length - count);
    }

    private void reverse(char[] chars) {
        int len = chars.length;
        char ch;
        for (int i = 0; i < len/2; i++) {
            ch = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = ch;
        }
    }
}