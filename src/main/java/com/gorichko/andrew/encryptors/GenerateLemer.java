package com.gorichko.andrew.encryptors;

import com.gorichko.andrew.Main;

import java.util.Scanner;

public class GenerateLemer {
    public void GeneratorL() {
        System.out.println("");
        System.out.println("Генератор псевдовипадкових послідовностей Лемера.");
        System.out.println("");

        System.out.println("Введіть наступні дані:");
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Модуль порівняння: ");
        int m = scanner.nextInt();
        System.out.print(" Породжуюче ціле число: ");
        int x0 = scanner.nextInt();
        System.out.print(" Множник: ");
        int a = scanner.nextInt();
        System.out.print(" Приріст: ");
        int c = scanner.nextInt();

        System.out.println("Псевдовипадкова послідовність: ");
        int[] nextNumber = new int[m];
        int r = 0;
        for (int i = 0; i < m; i++){
            nextNumber[0] = (a*x0+c)%m;
            nextNumber[i+1] = (a*nextNumber[i]+c)%m;
            System.out.println(nextNumber[i]);

            if(nextNumber[0] == nextNumber[i+1]){
                break;
            }
            r=i;
        }

        System.out.print("Період псевдовипадковості: " + (r+1));
        System.out.println("");
        System.out.println("");
        System.out.println("Запустити тестування?");
        System.out.println(" 1. Так");
        System.out.println(" 2. Ні");

        int test = scanner.nextInt();

        if (test == 1){
            System.out.println("Запуск тестування....");
            for (int i = 1; i < r + 3; i++){
                nextNumber[1] = x0;
                nextNumber[i+1] = (a*nextNumber[i]+c)%m;
                for (int k = 7; k >= 0; --k){
                    System.out.print((nextNumber[i] >> k) & 1);
                }
            }

            int ones = 0, nulls = 0, cc = 0, c1 = 0;

            for (int i = 1; i < r+2; i++){
                nextNumber[1] = x0;
                nextNumber[i+1] = (a*nextNumber[i]+c)%m;
                cc += nextNumber[i]&0x01;
                nextNumber[i]/=2;
                c1 = 8 - cc;
                ones = ones + cc;
                nulls = nulls + c1;
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Кількість одиниць: " + ones);
            System.out.println("Кількість нулів: "+ nulls);
            System.out.println("Тест не пройдений!");

            System.out.println("");
            System.out.println("Тестування за періодичністю");
            float testing;
            testing = (m/r+1)*100;
            if (testing > 100){
                testing/=10;
            } else if(testing > 1000) {
                testing/=100;
            }
            System.out.println("Періодичність: " + testing + "%");
        } else {
            Main main = new Main();
            main.init();
            System.out.println("");
        }
    }
}

