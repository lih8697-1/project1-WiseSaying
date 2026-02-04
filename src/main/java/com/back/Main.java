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
            cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                content = sc.nextLine();

                System.out.print("작가 : ");
                author = sc.nextLine();

                id = ++lastIndex;
                wiseSaying.add(new WiseSaying(id, content, author));

                System.out.printf("%d번 명령이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseSaying.size() - 1; i >= 0; i--) {
                    WiseSaying str = wiseSaying.get(i);

                    System.out.printf("%d / %s / %s%n", str.id, str.author, str.content);
                }
            } else if (cmd.startsWith("삭제?id=")) {
                String[] num = cmd.split("=");
                int id_num = Integer.parseInt(num[1]);
                boolean check = false;

                for (int i = 0; i < wiseSaying.size(); i++) {
                    if (wiseSaying.get(i).id == id_num) {
                        wiseSaying.remove(i);
                        System.out.printf("%d번 명언이 삭제되었습니다.\n", id_num);
                        check = true;// boolean 처리 필요
                        break;
                    }
                }

                if (!check) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id_num);
                }
            } else if (cmd.startsWith("수정?id=")) {
                String[] num = cmd.split("=");
                int id_num = Integer.parseInt(num[1]);
                boolean check = false;

                for(WiseSaying ws : wiseSaying){
                    if (ws.id == id_num){
                        System.out.println("명언(기존) " + ws.content);
                        System.out.print("명언 : ");
                        ws.content = sc.nextLine();

                        System.out.println("작가(기존) " + ws.author);
                        System.out.print("작가 : ");
                        ws.author = sc.nextLine();
                        check = true;
                        break;
                    }
                }

                if(!check) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", id_num);
                }
            }
        }
    }
}
