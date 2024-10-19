public class LengthOfLastWordEasy {
//    public static int lengthOfLastWord(String s) {
//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//        String[] words = s.split(" ");
//        if (words.length == 0) {
//            return 0;
//        }
//        return words[words.length - 1].length();

//    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int count  = 0 ;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count >= 1) {
                break;
            }
            if (s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
//        String s = "luffy is still joyboy";
        String s = "   fly me   to   the moon  ";
        int count = lengthOfLastWord(s);
        System.out.println(count);

    }

}
