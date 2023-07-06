public class test {
    public static void main(String[] args) {
        String str = "as1dwf1";
            for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
               System.out.println("Число");
            }
        }
    }
}
