import java.util.Scanner;

/**
 * This program tells the user the characteristics of a letter they enter.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-03-20
 */
final class CharacteristicsOfLetter {
  /** Private constructor for CharacteristicsOfLetter class. */
  private CharacteristicsOfLetter() {
    // so linter doesn't get mad
  }

  /**
   * Determines whether a given letter is a vowel or a consonant.
   *
   * @param letter The character to be checked.
   * @return A string indicating whether the letter is a vowel, a consonant, or both.
   */
  public static final String vowelOrConsonant(char letter) {
    // vowels array declaration
    final char[] vowels = {
      'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U',
    };
    // return variable
    String type = " ";

    // checks if letter is y
    if (letter == 'y' || letter == 'Y') {
      type = "both a vowel and a consonant";

      // checks if letter is a vowel
    } else if (" ".equals(type)) {
      for (char character : vowels) {
        if (character == letter) {
          type = "a vowel";
        }
      }
      // letter is a consonant
    } else {
      type = "a consonant";
    }

    // returns if letter is a consonant, vowel, or both
    return type;
  }

  /**
   * Determines whether a given letter is uppercase or lowercase.
   *
   * @param letter The character to be checked.
   * @return A string indicating whether the letter is uppercase or lowercase.
   */
  public static final String lowerOrUpper(char letter) {
    // return variable
    final String charCase;
    // checks if uppercase or lowercase
    if (letter <= 122 && letter >= 97) {
      charCase = "lowercase.";
    } else if (letter <= 90 && letter >= 65) {
      charCase = "uppercase.";
    } else {
      charCase = " ";
    }

    // returns string uppercase, lowercase or empty
    return charCase;
  }

  /** Displays an introductory message to the user explaining how to use the program. */
  public static void introMessage() {
    System.out.println();
    System.out.println("Welcome to The Letter Checking Program!");
    System.out.println();
    System.out.println("To use this program, you must first enter how many");
    System.out.print("letters you want to check. If you input erroneous ");
    System.out.println("data, it will count as a letter so be careful!");
    System.out.print("Then, you must enter one letter (only one at a time). ");
    System.out.println("The program will tell you if it is a capital,");
    System.out.print("or lowercase letter, and if it is a vowel or a ");
    System.out.println("consonant. To end the program, enter an asterisk ");
    System.out.println("instead of a letter when prompted.");
    System.out.println();
  }

  /**
   * Main method to run the program.
   *
   * @param args Command-line arguments (not used in this program).
   */
  public static void main(final String[] args) {
    // variable declaration
    final Scanner scanner = new Scanner(System.in);
    final String numLettersStr;
    String letterStr;
    String letterCase;
    String letterType;
    final int numLetters;
    char letter;

    // introductory message (what this program is and how to use it)
    introMessage();

    // asks user how many letters they want to check
    System.out.print("Enter amount of letters: ");
    numLettersStr = scanner.nextLine();

    // try catch to check if user imputed a valid int
    try {
      // string to int conversion
      numLetters = Integer.parseInt(numLettersStr);

      // loops program
      for (int counter = 0; counter < numLetters; counter++) {
        // getting user input
        System.out.print("Enter a letter: ");
        letterStr = scanner.nextLine();

        // user has imputed one character
        if (letterStr.length() > 1) {
          // convert string to character
          letter = letterStr.charAt(0);

          // call functions
          letterCase = lowerOrUpper(letter);
          letterType = vowelOrConsonant(letter);

          // user did not enter a letter
          if (" ".equals(letterCase)) {
            System.out.print("Please enter a letter");
            System.out.println("No other characters accepted.");
          } else {
            // display function outputs to console
            System.out.print("Your letter is " + letterType);
            System.out.println(" that is " + letterCase);
          }

          // user imputed more than one character
        } else {
          System.out.println("Too many characters. Enter only one character.");
        }
      }

      // close scanner
      scanner.close();

      // exit message
      System.out.println("Thank you for using The Letter Checking Program!");

      // user entered invalid input for how many letters to enter
    } catch (NumberFormatException error) {
      System.out.println("");
    }
  }
}
