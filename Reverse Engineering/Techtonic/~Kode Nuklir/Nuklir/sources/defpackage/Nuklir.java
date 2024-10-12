package defpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Scanner;

/* loaded from: Nuklir.class */
public class Nuklir {
    public static void main(String[] strArr) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode nuklir: ");
        if (!isValidKodeNuklir(scanner.nextLine(), fetchKodeNuklirFromServer())) {
            System.out.println("Maaf, Kode nuklirnya salah gan");
        } else {
            StringBuilder sb = new StringBuilder("TechtonicExpoCTF{");
            for (String str : new String[]{"2", "15", "11", "21", "14", "15", "3", "8", "9", "14", "3", "8", "9", "14", "23", "1", "3", "8", "9", "9", "19", "1", "9"}) {
                sb.append((char) ((Integer.parseInt(str) - 1) + 65));
            }
            sb.append("}");
            System.out.println(sb.toString());
        }
        scanner.close();
    }

    private static boolean isValidKodeNuklir(String str, String str2) {
        return str.equals(str2);
    }

    private static String fetchKodeNuklirFromServer() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create("http://147.79.68.192:5000/get_kode_nuklir").toURL().openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString().replaceAll("[^0-9]", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
