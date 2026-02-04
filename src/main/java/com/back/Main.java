package com.back;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cmd;
        String content;
        String author;
        int id;
        int lastIndex = 0;

        List<WiseSaying> wiseSaying = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            cmd = sc.next();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                content = sc.next();

                System.out.print("작가 : ");
                author = sc.next();

                id = ++lastIndex;
                wiseSaying.add(new WiseSaying(id, content, author));

                System.out.printf("%d번 명령이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseSaying.size() - 1; i >= 0; i--) {
                    WiseSaying str = wiseSaying.get(i);

                    System.out.printf("%d / %s / %s%n", str.id, str.content, str.author);
                }
            } else if (cmd.contains("삭제?id=")) {
                String[] num = cmd.split("=");
                int id_num = Integer.parseInt(num[1]);

                wiseSaying.remove(id_num - 1);
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id_num);
            }
        }
    }
}
