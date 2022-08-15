package leetcode.solution;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * @author zhihao.mao
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {

            return s;
        }
        int length = s.length();
        int columns = (length / (2 * numRows - 2)) * (numRows - 1)
                + (((length % (2 * numRows - 2)) / numRows) > 0 ? +((length % (2 * numRows - 2)) % numRows + 1) : 1);
        int rows = numRows;

        Character[][] chars = new Character[columns][rows];
        int sIndex = 0;
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            if (columnIndex % (numRows - 1) == 0) {
                for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                    if (sIndex == length) {
                        break;
                    }
                    chars[columnIndex][rowIndex] = s.charAt(sIndex);
                    sIndex++;
                }
            } else {
                chars[columnIndex][rows - 1 - columnIndex % (numRows - 1)] = s.charAt(sIndex);
                sIndex++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                Character c = chars[columnIndex][rowIndex];
                if (c != null) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ab", 1));
    }

}
