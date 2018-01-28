package hang.man.gracie.davenport;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangManGracieDavenport
{

    public static void main(String[] args)
    {
        String secretWord = secretWordGenerator();
        char[] explodedWord = explode(secretWord);
        char[] hiddenWord = hideSecretWord(explodedWord);
        char[] alphabet = populateAlphabetMethod();
        char guess;
        int badGuessCount = 0;
        int correctGuessCount = 0;
        

        System.out.println();

        while (badGuessCount < 6)//|| correctGuessCount == hiddenWord.length
        {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("lives: " + (6 - badGuessCount));
            System.out.print("letters: ");
            System.out.println(alphabet);
            // print gallows and number of lives
            gallows(badGuessCount);

            // print secret word
            System.out.println("\nGuess the word: \n");
            System.out.println(hiddenWord);

            // prompt user to guess a letter
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter a letter: ");
            guess = input.next().charAt(0);
            System.out.println("");
            boolean correctGuess = unhideSecretWord(guess, hiddenWord, explodedWord);
            if (!correctGuess)
            {
                badGuessCount++;
            }

            // print new alphabet based on input
            hideAlphabet(guess, alphabet);

            if (Arrays.equals(explodedWord, hiddenWord))
            {
                //todo display a success message
                System.out.println("You win!");
                return;//this would exit the current method
            }

        }
        gallows(badGuessCount);
        System.out.println("You lose!");
    }

    // This method prints the alphabet
    private static char[] populateAlphabetMethod()
    {
        char[] alphabet = new char[26];

        for (char ch = 'a'; ch <= 'z'; ++ch)
        {
            alphabet[ch - 'a'] = ch;
        }

        return alphabet;
    }

    // This method hides the letters that have been guessed in the alphabet array
    private static void hideAlphabet(char guess, char[] alphabet)
    {
        for (int i = 0; i < alphabet.length; i++)
        {
            if (guess == alphabet[i])
            {
                alphabet[i] = '-';
            }
        }

    }

    // This method selects a random word from the word bank
    private static String secretWordGenerator()
    {
        String secretWord;
        Random rand = new Random();

        String[] wordBank =
        {
            "mississippi", "ostentatious", "austere", "happy", "sycophant"
        };
        secretWord = wordBank[rand.nextInt(wordBank.length)];

        return secretWord;
    }

    // This method explodes the random word chosen from the word bank 
    private static char[] explode(String secretWord)
    {
        char explodedWord[] = secretWord.toCharArray();

        return explodedWord;
    }

    // This method replaces letters of the secret word with underscores 
    private static char[] hideSecretWord(char[] explodedWord)
    {
        char[] hiddenWord = new char[explodedWord.length];
        for (int i = 0; i < explodedWord.length; i++)
        {
            hiddenWord[i] = '-';
        }

        return hiddenWord;
    }

    // this method replaces underscore in the secret word with letters
    private static boolean unhideSecretWord(char guess, char[] hiddenWord, char[] exploadedWord)
    {
        boolean correctGuess = false;
        for (int i = 0; i < hiddenWord.length; i++)
        {
            if (exploadedWord[i] == guess)
            {
                hiddenWord[i] = guess;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    //This method prints the gallows
    private static void gallows(int badGuessCount)
    {
        if (badGuessCount == 0)
        {
            System.out.println("\n--------");
            System.out.println("|      |");
            System.out.println("|       ");
            System.out.println("|       ");
            System.out.println("|       ");
            System.out.println("|       ");
            System.out.println("|       ");
        }

        if (badGuessCount == 1)
        {
            System.out.println("\n--------");
            System.out.println("|      |");
            System.out.println("|      O");
            System.out.println("|       ");
            System.out.println("|       ");
            System.out.println("|       ");
            System.out.println("|       ");
        }

        if (badGuessCount == 2)
        {
            System.out.println("\n--------");
            System.out.println("|      |");
            System.out.println("|      O");
            System.out.println("|      |");
            System.out.println("|      |");
            System.out.println("|       ");
            System.out.println("|       ");
        }

        if (badGuessCount == 3)
        {
            System.out.println("\n--------");
            System.out.println("|      |  ");
            System.out.println("|      O  ");
            System.out.println("|      |\\");
            System.out.println("|      |  ");
            System.out.println("|         ");
            System.out.println("|         ");
        }

        if (badGuessCount == 4)
        {
            System.out.println("\n--------");
            System.out.println("|      |  ");
            System.out.println("|      O  ");
            System.out.println("|     /|\\");
            System.out.println("|      |  ");
            System.out.println("|         ");
            System.out.println("|         ");
        }

        if (badGuessCount == 5)
        {
            System.out.println("\n--------");
            System.out.println("|      |  ");
            System.out.println("|      O  ");
            System.out.println("|     /|\\");
            System.out.println("|      |  ");
            System.out.println("|       \\");
            System.out.println("|         ");
        }

        if (badGuessCount == 6)
        {
            System.out.println("\n--------");
            System.out.println("|      |  ");
            System.out.println("|      O  ");
            System.out.println("|     /|\\");
            System.out.println("|      |  ");
            System.out.println("|     / \\");
            System.out.println("|         ");
        }

    }

}
