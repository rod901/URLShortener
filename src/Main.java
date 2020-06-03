import main.URLShortener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter URL to be shortened: ");
            Scanner scanner = new Scanner(System.in);
            String uri = scanner.nextLine();
            System.out.println(URLShortener.getShort(uri));
        }
    }
}
