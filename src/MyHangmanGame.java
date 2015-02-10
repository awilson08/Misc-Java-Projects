import java.util.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class MyHangmanGame
{
    private String secretWord;
    private int numGuessesRemaining, numLettersRemaining;
    private String lettersGuessed;
    private char[] wordState;
    int wordLength;
    

    public MyHangmanGame() throws Exception{
        //mySecretWord= secretWord.toUpperCase();
        
        secretWord = pickSecretWord();
        wordLength = secretWord.length();
        numGuessesRemaining = 6;
        lettersGuessed = "";
        numLettersRemaining = secretWord.length();
        wordState = new char[secretWord.length()];
        
        for (int i =0; i<wordState.length; i++){
            wordState[i] = '_';
        }
    }
    

	public String pickSecretWord() throws Exception{
    	String inputLine=null;
    	try{
    	URL randomword = new URL("http://randomword.setgetgo.com/get.php");
        URLConnection yc = randomword.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF8" ));
        inputLine = in.readLine();
        in.close();
    	}
    	catch (Exception e){
    		System.out.println("Please check your connection and try again");
    		System.exit(0);
    	}
    	
        return inputLine.substring(1, inputLine.length()).toUpperCase();
    }
   
   
    public String getSecretWord(){
        return secretWord;
    }
    
    
    public boolean makeGuess(char ch){
        int pos = secretWord.indexOf(ch);
        
        
        if (pos < 0){
        	if (lettersGuessed.indexOf(ch)<0){
                lettersGuessed+= ch;
                numGuessesRemaining--;
            }
        	
        	else{
        		if (lettersGuessed.indexOf(ch)<0){
                    lettersGuessed+= ch;
        		}
            }
            return false;
        }
        
        
        while (pos< wordState.length && pos>=0) {
            wordState[pos] = ch;
            numLettersRemaining--;
            pos = secretWord.indexOf(ch ,pos+1);
        }

        return true;
        
    }
    
    public boolean isWin(){
        return (numGuessesRemaining()>0 && numLettersRemaining()==0);
    }
    
 
    public boolean gameOver(){
        return numGuessesRemaining() == 0 || numLettersRemaining()==0;
        
    }
    
    public int numGuessesRemaining(){
        return numGuessesRemaining;
    }
    
    
    public int numLettersRemaining(){
        return numLettersRemaining;
    }
    
    
    public String displayGameState(){
        String data = "";
        for (int i = 0; i<wordState.length; i++){
            data+=wordState[i] + " ";
        }
        return data;
    }
    
    
    public String lettersGuessed(){
        return lettersGuessed;
    }

}
    
       