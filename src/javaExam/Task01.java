package javaExam;

/**
 * @author 张辉
 * @Description Task 1
 * @create 2020-07-02 22:06
 */
public class Task01 {

    public static void main(String[] args) {
        Task01 t = new Task01();
        t.ReadSequenceNumbers("1,2,3,4,5");
        t.SequenceInversion("ashdfjka");
    }

    /**
     * Task 1 (1)
     * @param string
     * @return int[]
     */
    public int[] ReadSequenceNumbers(String string) {
        String[] str = string.split(",");
        int[] nums = new int[str.length];
        int index = 0;
        for (String s : str) {
            nums[index++] = Integer.parseInt(s);
        }
        return nums;
    }

    /**
     * Task 1 (2)
     * @param string
     * @return String
     */
    public String SequenceInversion(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = string.length() - 1; i >= 0; i--) {
            sb.append(string.charAt(i));
        }
        return sb.toString();
    }


}
