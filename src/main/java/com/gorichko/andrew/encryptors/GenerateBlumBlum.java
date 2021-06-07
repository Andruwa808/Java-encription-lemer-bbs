package com.gorichko.andrew.encryptors;

import com.gorichko.andrew.Main;

import java.util.Scanner;

public class GenerateBlumBlum {
    static int modp;
    static int modq;
    static int p;
    static int q;
    static long n;
    static long seme;
    static long x;
    static long seq[];

    public static void init(int num) {
        modp = 4;
        modq = 4;
        seme = 0;
        seq = new long[num];
    }


    public void generate(int num) {
        init(num);

        while (modp != 3 || modq != 3) {
            p = (int) Math.round(Math.random() * 100000000);
            q = (int) Math.round(Math.random() * 100000000);
            modp = p % 4;
            modq = q % 4;
        }
        n = Math.abs(q * p);

        while (seme < 1 || seme > (n - 1) || !(coprimi(seme, n))) {
            seme = Math.round(Math.random() * 100000000);
        }
        x = (long) Math.pow(seme, 2) % n;

        seq[0] = x;
        for (int i = 1; i < num; i++) {
            seq[i] = (long) Math.pow(seq[i - 1], 2) % n;
            long z = seq[i] % 100;
            System.out.println(z);
        }
    }

    private static boolean coprimi(long a, long b) {
        boolean result = false;
        long resto;

        if (b == 0) {
            if (a == 1) {
                result = true;
            }
        } else {
            resto = a % b;
            if (resto == 0) {
                if (b == 1) {
                    result = true;
                }
            } else {
                return (coprimi(b, resto));
            }
        }
        return result;
    }

    public void GeneratorBlum() {
        System.out.println("");
        System.out.println("Генератор псевдовипадкових послідовностей Блюм-Блюм-Шуба.");
        System.out.println("");

        System.out.println("Введіть наступні дані:");
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Перше просте число: ");
        p = scanner.nextInt();
        System.out.print(" Друге просте число: ");
        q = scanner.nextInt();
        System.out.print(" Породжуюче ціле число: ");
        int num = scanner.nextInt();

        generate(num);

        System.out.println("");
        System.out.println("");
        System.out.println("Запустити тестування?");
        System.out.println(" 1. Так");
        System.out.println(" 2. Ні");

        int test = scanner.nextInt();

        if (test == 1){
            System.out.println("Запуск тестування....");
            for (int i = 0; i < num; i++) {
                for (int k = 7; k >= 0; --k){
                    long a = (seq[i] >> k) & 1;
                    System.out.print(a);
                }
            }

            int ones = 0, nulls = 0, cc = 0, c1 = 0;

            for (int i = 0; i < num; i++){
                cc += seq[i]&0x01;
                c1 = 8 - cc;
                ones = ones + cc;
                nulls = nulls + c1;
            }

            System.out.println("");
            System.out.println("Кількість одиниць: " + ones);
            System.out.println("Кількість нулів: "+ nulls);
            System.out.println("Тест успішно пройдений!");

            System.out.println("");
            System.out.println("Тестування за періодичністю");
            float testing;
            testing = (num/num+1)*100;
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

