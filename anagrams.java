import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {

        try (java.util.Scanner scan = new java.util.Scanner(new java.io.File("C:\\Users\\weshicksstan\\Downloads\\anagrams.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //// Trim to remove leading/trailing spaces, code snippet from FavTutor
                String[] words = line.split(",");
                if (words.length == 2) {
                    String str1 = words[0].trim();
                    String str2 = words[1].trim();
                    System.out.println(anagrams(str1, str2));
                }
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Applied revision on how to convert strings to char arrays, sort the char arrays and compare sorted char arrays from Java Code Geeks
    public static boolean anagrams(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }


        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);


        return Arrays.equals(charArray1, charArray2);
    }
}
