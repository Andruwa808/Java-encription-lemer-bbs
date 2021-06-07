package com.gorichko.andrew;

import com.gorichko.andrew.encryptors.GenerateBlumBlum;
import com.gorichko.andrew.encryptors.GenerateLemer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Лабораторна робота №3");
        init();
    }

    public static void init(){
        System.out.println("");
        System.out.println("Меню:");
        System.out.println(" 1. Генерація псевдовипадкових послідовностей Лемера + тестування.");
        System.out.println(" 2. Генерація псевдовипадкових послідовностей Блюм-Блюм-Шуба + тестування.");
        System.out.println(" 3. Завершити роботу програми.");
        System.out.println("");
        System.out.print("Введіть цифру: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        switch (number){
            case 1:
                GenerateLemer generateLemer = new GenerateLemer();
                generateLemer.GeneratorL();
                break;
            case 2:
                GenerateBlumBlum generateBlumBlum = new GenerateBlumBlum();
                generateBlumBlum.GeneratorBlum();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Цифра не вірна, попробуйте щераз...");
                Main rest = new Main();
                rest.init();
        }
    }
}
