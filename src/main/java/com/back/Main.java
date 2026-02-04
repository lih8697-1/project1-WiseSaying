package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cmd;
        String wiseSaying;
        String author;
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.printf("명령) ");
            cmd = sc.next();

            if (cmd.equals("등록")) {
                System.out.printf("명언 : ");
                wiseSaying = sc.next();
                System.out.printf("작가 : ");
                author = sc.next();
                System.out.println("1번 명령이 등록되었습니다.");
            }
        }
    }
}
