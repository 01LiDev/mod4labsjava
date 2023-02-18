/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jldevelops.mod3lab;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Johnson
 */
public class Mod3Lab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer between 1 and 99999: ");
        int number = input.nextInt();
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter an integer between 1 and 99999: ");
            number = input.nextInt();
            if (number >= 1 && number <= 99999) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer between 1 and 99999.");
            }
        }
        displayDigits(number);
        playerGuessGame();
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static int quotient(int a, int b) {
        return a / b;
    }

    public static void displayDigits(int number) {
        int divisor = 10000;
        while (divisor >= 1) {
            int digit = quotient(number, divisor);
            System.out.print(digit + "  ");
            number = remainder(number, divisor);
            divisor = quotient(divisor, 10);
        }
        System.out.println();
    }

    public static void playerGuessGame() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(1000) + 1;
        int guess;
        int numGuesses = 0;
        boolean correct = false;

        System.out.println("I'm thinking of a number between 1 and 1000. Can you guess it?");

        while (!correct) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            numGuesses++;

            if (guess < numberToGuess) {
                System.out.println("Too low. Try again!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high. Try again!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses!");
                correct = true;
            }
        }
    }
}
