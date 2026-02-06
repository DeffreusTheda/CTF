public class Solve {
    private static final String ENC_SEG_A = "wp5_GJECD";
    private static final String ENC_SEG_B = "P_u0q_c0p_";
    private static final String ENC_SEG_C = "GYPB{_ykjcn";
    private static final String ENC_SEG_D = "uKqN_Gj1cd7_zN01z_}";

    public static boolean verifyFlag(String userInput) {
        String firstTen = "com.knighc";
        int shift = computeShiftFromKey(firstTen);
        System.out.println("Shift: " + shift);
        String encodedUserInput = droidMagic(userInput, shift);
        return "GYPB{_ykjcnwp5_GJECDP_u0q_c0p_uKqN_Gj1cd7_zN01z_}".equals(encodedUserInput);
    }

    private static int computeShiftFromKey(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c;
        }
        return sum % 26;
    }

    private static String droidMagic(String input, int droidTask) {
        int droidTask2 = ((droidTask % 26) + 26) % 26;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int originalPos = c - 'A';
                int newPos = (originalPos + droidTask2) % 26;
                sb.append((char) (newPos + 65));
            } else if (Character.isLowerCase(c)) {
                int originalPos2 = c - 'a';
                int newPos2 = (originalPos2 + droidTask2) % 26;
                sb.append((char) (newPos2 + 97));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        verifyFlag("test");
    }
}

