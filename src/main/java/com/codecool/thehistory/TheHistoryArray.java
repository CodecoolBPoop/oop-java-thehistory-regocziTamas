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

        int lenFrom = fromWords.length;
        int lenTo = toWords.length;
        boolean matchFound = true;

        String[] newArray = new String[wordsArray.length+100];
        int currentPosition = 0;

        for(int i = 0; i < wordsArray.length;i++){
            if(currentPosition+lenTo > newArray.length){
                String[] temp = new String[newArray.length+100];
                System.arraycopy(newArray,0,temp,0,currentPosition);
                newArray = temp;
            }
            if(Objects.equals(wordsArray[i], fromWords[0])&& i+lenFrom-1 < wordsArray.length){
                for(int k = 1; k < lenFrom;k++){
                    if(!Objects.equals(wordsArray[i+k], fromWords[k])){
                        matchFound = false;
                        break;
                    }
                }
                if(matchFound){
                    for(int j = 0; j < lenTo;j++){
                        newArray[currentPosition+j] = toWords[j];
                    }
                    i+=(lenFrom-1);
                    currentPosition+=lenTo;

                }else{
                    newArray[currentPosition] = wordsArray[i];
                    currentPosition++;
                }
                matchFound = true;
            }else{
                newArray[currentPosition] = wordsArray[i];
                currentPosition++;
            }
        }

        wordsArray = Arrays.copyOfRange(newArray,0,currentPosition);











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
