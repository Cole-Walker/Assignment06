import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashSet;

public class MainClass
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File happy = new File("C:\\Users\\Colew\\Downloads\\happy.txt");
        HashSet<String> uniqueWords = new HashSet<String>();
        boolean flag = true;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter word to search in given file");
        String word = myObj.nextLine();


        StringBuilder fileContent = new StringBuilder();

        BufferedReader bReader = new BufferedReader(new FileReader(happy));
        String line = null;
        while((line = bReader.readLine())!= null)
        {
            fileContent.append(line);
            fileContent.append(" ");
        }
        bReader.close();
        
        String fC = fileContent.toString();

        String replace = fC.toString().replace(",", "");
        String replace1 = replace.replace(") ", " ");
        String replace2 = replace1.replace(" (", " ");
        String replace3 = replace2.replace("(", " ");
        String replace4 = replace3.replace(")", " ");

        String[] words = replace4.toString().split("\\s+");
        
        for (int i = 0; i < words.length; i++) 
        {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        
        uniqueWords.addAll(Arrays.asList(words));
        System.out.println("Number of Unique words in the lyrics is : "+ uniqueWords.size());
        if(!word.isEmpty())
        {
            int count = 0;
            StringTokenizer tokenizer = new StringTokenizer(replace4, " ");
            while(tokenizer.hasMoreTokens())
            {
                //System.out.println(tokenizer.nextToken());
                if(word.equals(tokenizer.nextToken()))
                    count++;
            }
            System.out.println(word + " word is repeated " + count + " times in given file!");
        }
    }
}
