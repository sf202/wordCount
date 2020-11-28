/*Santiago Fleiderman
 * CSC 3410
 * Spring 2016
 * Assignment 2
 */
/**
1. The purpose of this program is to take a text file and analyze the contents within it. It will count the amount of words, lines
 Alphanumeric characters, number of sentences, vowels and punctuation of the program, and it will  terminate  if the conditions are not met or upon
 completion of the program. 

 2. The first problem I had with this program is counting the amount of words in the file. I used a while loop that returned true, I also counted how many white 
 spaces there are between the words. The Second problem I encountered was counting the number of lines in the file. In order to do this I used a buffered reader that would convert the text file
 into a String of characters.  I then incremented to show the number of lines. The third problem I had was how to get the alphanumeric character in the text file. For this problem I also used
 the Buffered reader that would read the lines in the text file and convert them to characters. This will continue until there is no more characters. Then it was converted to an array
 The counter will then increment to show the changes and will print an output. The next problem I encountered in this program was counting the number of sentences in the file. I used
 a while loop to accomplish this. The while loop would determine the length of each sentence after each punctuation, like . or !. Then it will display the number of sentences  to the user.
 This is because the string is split and the characters inputted are the ones counted. The next problem was counting the number of vowels in the sentence. The first step is to use
 the Bufford reader to convert the text file into characters in a string. I then use a character array, which is then examined by another method. What happens next is that a for loop compares
 the text file with its input and if it matches the number of vowels it will increment if it does not it will add 1 increment to the consonant variable. The next problem was to count the
 number of punctuation in the text file. To do this one must first use a Bufford reader to convert the text file into a string of characters. Then convert to a char array. Then you use
 a for loop to compare what was stored in the char array to match the punctuation that I have created, after it is examined it will increment the punct variable by 1.

 3. The data structures used in this program include an char Array, a scanner, and a Buffered reader object.

 4. When the program starts up it will ask the user to enter a text file. In order for this program
  to function correctly the user  must correctly enter the exact location of the text file and its directories.  For Example  C:\Users\Username\Documents\fileName.txt
The output will either display the total number of words, the total number of lines the file contains, the number of alphanumeric
characters in the file, the number of sentences, consonants, vowels and punctuation else it will say the file is empty and the program
will terminate. Once the program has displayed the user the information he or she wants the program will then terminate.

5. The only class used in this program is the main class wordcount. Which analyzes the text file and gives you the output of vowels, lines, sentences etcetera. This
class is also responsible for all the loops and methods used.

 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class wordcount
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		// instance variables
		Scanner userInput;
		String textFile;
		int Totalnum =0;  //count number of lines
		String result;
		int alpha=0;
		String roundAbout;
		int vowel=0;
		int add=0; //the number of consonant in the file
		char detect;
		String mercedes;
		int punct=0; //the Amount of punctuation
		String detecting;
		String sum;
		int sentenceTotalnum=0;



		userInput = new Scanner(System.in);
		System.out.println("Please enter your text file:");
		// example ; C:\Users\Santiago\Documents\comuter.txt
		//C:\Users\Lion\Documents\comuter.txt
		textFile=userInput.nextLine();
		// Used to see if their is an exception
		try
		{			
			File document = new File(textFile);
			Scanner enter = new Scanner(document);

			int wordTotalnum=0;
			while(enter.hasNext())
			{
				sum =enter.next();
				if(sum.indexOf("\\") == -1)
				{
					wordTotalnum++;
				}
			}
			// This will determine the total amount of words inputed
			System.out.println("The total  amount of words is : " + wordTotalnum); //the number of words in the file
			enter.close();
			BufferedReader amountWordsInputed= new BufferedReader(new FileReader(textFile)); //read the number of lines in the file

			while(amountWordsInputed.readLine() != null)
			{
				Totalnum=Totalnum+1;
			}
			System.out.println("The total amount of lines this file contains is : " + Totalnum);
			amountWordsInputed.close();



			//Total number of alphanumeric characters 

			BufferedReader proccess = new BufferedReader(new FileReader(textFile));

			while(proccess.ready())
			{
				result=proccess.readLine();
				char[] characters;
				characters= result.toCharArray();

				for(int i=0; i<characters.length;i++)
				{
					if(Character.isLetterOrDigit(characters[i]) ==true)
					{
						alpha++;

					}
				}
			}
			System.out.println("The amount of alphanumeric characters in the text file: " + alpha);
			proccess.close();
			// Determines the number of sentences in the bufford reader
			BufferedReader numberSentences = new BufferedReader(new FileReader(textFile));

			while(numberSentences.ready())
			{
				detecting=numberSentences.readLine();
				sentenceTotalnum=sentenceTotalnum + detecting.split("[!?.:]+").length;
			}
			System.out.println("The Amount of sentences is: " + sentenceTotalnum);
			numberSentences.close();


			//This will count the number of vowels of the buffer
			BufferedReader anotherCount = new BufferedReader(new FileReader(textFile));


			while(anotherCount.ready())
			{
				roundAbout=anotherCount.readLine();
				char[] right;
				right = roundAbout.toCharArray();

				for(int i=0;i<right.length;i++)
				{
					detect=right[i];
					if(Character.isLetter(detect) == true)
					{
						if( detect =='a' || detect == 'e' || detect == 'i' || detect == 'o' || detect == 'u' || detect == 'A' || detect == 'E'  || detect == 'I' || detect == 'O' || detect == 'U')
						{
							vowel++;

						}
						else
						{
							add=add+1;
						}


					}
				}
				//print the number of vowels
			}	
			System.out.println("The total amount of consonants  in the file : " + add);
			System.out.println("The total amount  of vowels in the File text is : " + vowel);
			anotherCount.close(); 

			//The number of punctions Buffer
			BufferedReader outcome = new BufferedReader(new FileReader(textFile));

			while(outcome.ready())
			{
				mercedes=outcome.readLine();
				char[] detectPun;
				detectPun= mercedes.toCharArray();

				for(int i=0;i<detectPun.length;i++)
				{
					char detect2=detectPun[i];
					if(detect2 == '.' || detect2 == '!' || detect2 == '?' || detect2 == '(' || detect2 == ')' || detect2 == ';'  || detect2 == ',' || detect2 == '-' || detect2 == '"'  || detect2 == '['  || detect2 == ']'  || detect2 == ':' ) 
					{
						punct++;
					}
				}
			}
			System.out.println("The total amount of punctuation is :" + punct);
			outcome.close();



			PrintWriter output = new PrintWriter(" C:/d/output.txt");
			output.println("The amount  of words is " + wordTotalnum);
			output.println("the amount of lines is " + Totalnum);
			System.out.println("The number of aphanumeric character in this text file is : " + alpha);
			proccess.close();
			output.println("the amount of sentence is " + sentenceTotalnum);
			output.println("the amount of vowels in the file is : " + vowel);
			output.println("the amount of punctuation is " + punct);
			output.println("the amount of consonants  is :" + add);
			output.close();


		}
		// catches when the user does not enter the correct input or when the program terminates upon completion
		catch(FileNotFoundException read)
		{
			System.out.println(" The input file is now empty" + " .The program will now terminate.");

		}				

	}
}