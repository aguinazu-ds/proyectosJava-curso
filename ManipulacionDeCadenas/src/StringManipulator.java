public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        return a.trim().concat(b.trim());
    }

    public int getIndexOrNull(String a, char b) {
        return a.indexOf(b);
    }

    public int getIndexOrNull(String a, String b) {
        return a.indexOf(b);    
    }

    public String concatSubstring(String str1, int n, int m, String str2) {
        return str1.substring(n,m).concat(str2);
    }
}
