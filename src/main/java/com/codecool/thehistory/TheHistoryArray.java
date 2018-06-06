package com.codecool.thehistory;

import java.util.Arrays;
import java.util.Objects;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        wordsArray = text.split("\\s+");
        //System.out.println(Arrays.toString(wordsArray));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        String[] cleanedText = new String[wordsArray.length];
        int count = 0;

        for(String word: wordsArray){
            if(!Objects.equals(word, wordToBeRemoved)){
                cleanedText[count] = word;
                count++;
            }
        }
        this.wordsArray = Arrays.copyOfRange(cleanedText,0,count);
    }

    @Override
    public int size() {
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = null;
    }

    @Override
    public void replaceOneWord(String from, String to) {
        int count = 0;
        for(String word: wordsArray){
            if(Objects.equals(word,from)){
                wordsArray[count] = to;
            }
            count++;
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        //System.out.println(Arrays.toString(toWords));
        int lenFrom = fromWords.length;
        int lenTo = toWords.length;
        boolean matchFound = true;
        int newArrayLength = 0;
        int diff = -1*lenFrom + lenTo;

        for(int i = 0; i < wordsArray.length-lenFrom+1;i++){
            if(Objects.equals(wordsArray[i], fromWords[0])){
                for(int k = 1; k < lenFrom;k++){
                    if(!Objects.equals(wordsArray[i+k], fromWords[k])){
                        matchFound = false;
                        break;
                    }
                }
                if(matchFound){
                    

                }
                matchFound = true;
            }
        }





    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
