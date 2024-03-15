import java.util.HashMap;
import java.util.Map;

public class StringManipulationAssignment {
  public static void main(String[] args) {
    String input = "Racecar and radar are both examples of palindromes. This is why programming is fun!";



    // Task 1: Reverse String
    String reversedString = reverseString(input);
    System.out.println("\nOriginal String: "+ input);
    System.out.println("Reversed String: " + reversedString);

    // Task 2: Count Vowels
    int vowelCount = countVowels(input);
    System.out.println("\nNumber of Vowels: " + vowelCount);

    // Task 3: Palindrome Check
    int isPalindrome = palindromeCount(input);
    if (isPalindrome >0){
System.out.println("Input has: "+isPalindrome+" palindrome(s).");
    }
    else{
System.out.println("No Palindromes in this phrase");
}

    // Task 4: Word Count
    int wordCount = countWords(input);
    System.out.println("Number of Words: " + wordCount);

    // Task 5: Find Maximum Occurring Character
    char maxOccurringChar = findMaxOccurringChar(input);
    System.out.println("Maximum Occurring Character: " + maxOccurringChar);
  }

  private static String reverseString(String input) {
    String reversedString="";
    char ch;

    for (int i = 0; i < input.length(); i++) {
      ch = input.charAt(i); // extracts each character
      reversedString = ch + reversedString; // adds each character in front of the existing string
    }
  return reversedString;
  }

  //method to count vowels
private static int countVowels(String input){
int vowelCount=0;
for(int i = 0; i < input.length();i++){
  if(
  input.charAt(i) == 'a'||
  input.charAt(i) == 'e'||
  input.charAt(i) == 'i'||
  input.charAt(i) == 'o'||
  input.charAt(i) == 'u'||
  input.charAt(i) == 'A'||
  input.charAt(i) == 'E'||
  input.charAt(i) == 'I'||
  input.charAt(i) == 'O'||
  input.charAt(i) == 'U'){
    vowelCount++;
  }
}
return vowelCount;
}

//determin if a palindrome(same backwords or forwords)
//use the spaces to determine the end of a word, make each word a new string variable, individully reverse each string and determin if it is the same as the orgignal
private static int palindromeCount(String input){
  
  // Split the sentence into individual words
    String[] words = input.split("\\s+");
    //initiate the count for plaidroms
    int palCount=0;
    // Check each word individually
    for (String word : words) {
        
      // Remove non-alphabetic characters from the word
        String cleanWord = word.replaceAll("[^a-zA-Z.]", "").toLowerCase();
      //System.out.println(cleanWord);
        
        // Reverse the word
        String reversedWord = new StringBuilder(cleanWord).reverse().toString();
        
        //System.out.println(reversedWord+ " : "+ cleanWord);
        // Check if the reversed word is the same as the original word
        if (cleanWord.equals(reversedWord)) {
            
            palCount++;
        
        }
    }

    // If all words are palindromes, the sentence is a palindrome
    return palCount;
}

//Determin the most frequent character
private static char findMaxOccurringChar(String input){
  Map<Character, Integer> charFrequencyMap = new HashMap<>();

  // Count the frequency of each character and determin the one
  for (char c : input.toCharArray()) {
    //System.out.println("Char: "+c);
    if (c != ' ') {//to ignore the spaces
    charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
}
  }
char maxChar = ' ';
int maxCount = 0;

// Find the character with the maximum occurrence
for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
    
  if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        maxChar = entry.getKey();
    }
}
return maxChar;
}

//Method to count the words, by counting spaces, + 1 to account for first word
private static int countWords(String input){
  int spaceCount=1;
  for (int i = 0; i<input.length();i++){
    if(input.charAt(i)==' '){
      spaceCount++;
    }
  }
  return spaceCount;
}
}



