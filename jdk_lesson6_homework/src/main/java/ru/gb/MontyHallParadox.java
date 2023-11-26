package ru.gb;

import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class MontyHallParadox {

    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();

        int switchWins = 0;
        int countSwitchDoor = 0;
        int stayWins = 0;
        int countStay = 0;

        for (int i = 1; i <= 1000; i++) {
            int carDoor = RandomUtils.nextInt(1, 4);
            int chosenDoor = RandomUtils.nextInt(1, 4);

            int hostDoor = openHostDoor(carDoor, chosenDoor);

            boolean switchDoor = RandomUtils.nextBoolean();
            if (switchDoor) {
                chosenDoor = changeDoorSelection(chosenDoor, hostDoor);
            }

            boolean win = (chosenDoor == carDoor);
            results.put(i, win);

            if (switchDoor) {
                countSwitchDoor++; //увеличиваем общее число случаев смены выбора двери игроком для статистика
                if (win) {
                    switchWins++;
                }
            } else {
                countStay++; // увеличиваем общее число случаев без смены выбора двери игроком для статистика
                if (win) {
                    stayWins++;
                }
            }
        }

        System.out.println("Победы при смене выбора: " + switchWins + " ; число шагов смены выбора: " + countSwitchDoor);
        System.out.println("Победы при сохранении выбора: " + stayWins + " ; число шагов сохранения выбора: " + countStay);
        System.out.println();
        System.out.println("Процент побед при смене выбора относительно общего числа шагов 1000: "
                + ((double) switchWins / 1000) * 100 + "%");
        System.out.println("Процент побед при сохранении выбора относительно общего числа шагов 1000: "
                + ((double) stayWins / 1000) * 100 + "%");
        System.out.println();
        System.out.println("Процент побед при смене выбора относительно числа шагов смены выбора: "
                + ((double) switchWins / countSwitchDoor) * 100 + "%");
        System.out.println("Процент побед при сохранении выбора относительно числа шагов сохранения выбора: "
                + ((double) stayWins / countStay) * 100 + "%");
        System.out.println();
        System.out.println("Общая статистика: " + results);
    }

    //Метод для рандомного выбора двери, которую будет открывать
    //ведущий, исключая выбранную игроком и содержащую авто
    private static int openHostDoor(int carDoor, int chosenDoor) {
        int hostDoor;
        do {
            hostDoor = RandomUtils.nextInt(1, 4);
        } while (hostDoor == carDoor || hostDoor == chosenDoor);
        return hostDoor;
    }

    //Метод для смены выбора двери игроком после открытия двери ведущим
    private static int changeDoorSelection(int chosenDoor, int hostDoor) {
        return 6 - chosenDoor - hostDoor;
    }

}
