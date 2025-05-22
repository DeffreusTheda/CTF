public class Solve {
  public static void main(String... args) {
    StringBuilder sb = new StringBuilder("TechtonicExpoCTF{");
    for (String str : new String[]{"2", "15", "11", "21", "14", "15", "3", "8", "9", "14", "3", "8", "9", "14", "23", "1", "3", "8", "9", "9", "19", "1", "9"}) {
        sb.append((char) ((Integer.parseInt(str) - 1) + 65));
    }
    sb.append("}");
    System.out.println(sb.toString());
  }
}
