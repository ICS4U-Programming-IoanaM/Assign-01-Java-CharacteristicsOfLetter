import java.util.Scanner;
class CharacteristicsOfLetter {
  // constructor
  CharacteristicsOfLetter() {
    // 
  }

  public static String vowelOrConsonant(char letter) {
    char vowels[] = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

    if (letter == 'y' || letter == 'Y') {
      return "both a vowel and a consonant";
    }

    for (char character : vowels) {
      if (character == letter) {
        return "a vowel";
      }
    }

    return "a consonant";
  }

  public static String lowerOrUpper(char letter) {
    // checks if uppercase or lowercase
    if (letter <= 122 && letter >= 97) {
      return "lowercase.";

    } else if (letter <= 90 && letter >= 65) {
      return "uppercase.";
    }

    return " ";
  }
  
  public static boolean isValid(String input) {
    if (input.length() > 1) {
      return false;
    }
    return true;
  }
  
  // function that displays a message letting the user know everything they need to use the program
  public static void introMessage() {
    System.out.println();
    System.out.println("Welcome to the letter checking program!");
    System.out.println();
    System.out.print("To use this program, you must enter one letter.");
    System.out.println("the program will tell you if it is a capital,");
    System.out.print("or lowercase letter, and if it is a vowel or a");
    System.out.println("capital. To end the program, enter an asterisk");
    System.out.println("instead of a letter when prompted.");
    System.out.println();
  }

  public static void main(String[] args) {
    // variable declaration
    Scanner scanner = new Scanner(System.in);
    String letterStr;
    String letterCase;
    String letterType;
    char letter;

    // introductory message (what this program is and how to use it)
    introMessage();

    // loops until user enters * to quit
    /*
     * Ask ms raffin if a for loop can be used because a while loop 
     * would need a condition inside in order to break out which makes the condition
     * of the while loop redundant.
     */

    // getting use input
    System.out.print("Enter a letter: ");
    letterStr = scanner.nextLine();
    scanner.close();

    // user has imputed one character
    if (isValid(letterStr)) {
      // convert string to character
      letter = letterStr.charAt(0);

      // call functions
      letterCase = lowerOrUpper(letter);
      letterType = vowelOrConsonant(letter);
      
      // user did not enter a letter
      if (letterCase == " ") {
        System.out.println("Please enter a letter. No other characters accepted.");
      } else {
        // display function outputs to console
        System.out.println("Your letter is " + letterType + " that is " + letterCase);
      }

    } else { // user imputed more than one character
      System.out.println("Too many characters. Enter only one character.");
    }
  }
}
