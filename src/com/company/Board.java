package com.company;

import java.util.Scanner;

/**   X0  1  2
 * Y +---------+
 * 0 | 0  1  2 |
 * 1 | 3  4  5 |
 * 2 | 6  7  8 |
 *   +---------+
 */
public class Board {

    private final Item[] data;
    private final int size;

    public Board(int size) {
        this.size = size;
        data = new Item[size * size];

        for (int index = 0; index < data.length; index++) {
            data[index] = Item.EMPTY;
        }
    }

    private void setValue(int x, int y, Item value) {
        int index = (y * size) + x;
        data[index] = value;
    }

    private Item getValue(int x, int y) {
        int index = (y * size) + x;
        return data[index];
    }

    private Item checkVictory() {
        label:
        for (int x = 0; x < size; x++) {
            Item first = getValue(x, 0);
            for (int y = 0; y < size; y++) {
                Item value = getValue(x, y);
                if (value != first) {
                    continue label;
                }
            }
            return first;
        }

        label:
        for (int y = 0; y < size; y++) {
            Item first = getValue(0, y);
            for (int x = 0; x < size; x++) {
                Item value = getValue(x, y);
                if (value != first) {
                    continue label;
                }
            }
            return first;
        }

        Item first = getValue(0, 0);
        label:
        for (int xy = 1; xy < size; xy++) {
            Item value = getValue(xy, xy);
            if (value != first) {
                continue label;
            }
            return first;
        }

        first = getValue(size -1, 0);
        label:
        for (int x = size-2; x >= 0; x--) {
            Item value = getValue(x, size-1-x);
            if (value != first) {
                continue label;
            }
            return first;
        }

        return Item.EMPTY;
    }

    private void printBoard() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Item item = getValue(x, y);
                System.out.print(item.toString());
            }
            System.out.println();
        }
    }

    public void startGame() {
        Board board = new Board(3);
        board.setValue(0, 0, Item.O);
        board.setValue(1, 1, Item.X);
        board.setValue(2, 2, Item.O);
        Item res = board.checkVictory();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Играет Игрок 1, введите куда поставить O");
            int x = scanner.nextInt();
            scanner.nextLine();
            int y = scanner.nextInt();
            scanner.nextLine();
            setValue(x, y, Item.O);
            printBoard();
            Item winner = checkVictory();
            if (winner != Item.EMPTY) {
                System.out.println("Победил игрок 1");
                return;
            }
            System.out.println("Играет Игрок 2, введите куда поставить X");
            x = scanner.nextInt();
            scanner.nextLine();
            y = scanner.nextInt();
            scanner.nextLine();
            setValue(x, y, Item.X);
            printBoard();
            winner = checkVictory();
            if (winner != Item.EMPTY) {
                System.out.println("Победил игрок 2");
                return;
            }
        }

                // Записать Item.O в позицию которую указал игрок
                //Проверить побелил ли кто-то
                // Вывести на экран: Играет Игрок 2, введите куда поставить X
                // Записать Item.X в позицию которую указал игрок
                //Проверить побелил ли кто-то




    }
}
