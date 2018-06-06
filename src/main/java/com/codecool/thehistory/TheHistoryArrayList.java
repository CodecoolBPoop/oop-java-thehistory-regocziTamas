package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<String>();

    @Override
    public void add(String text) {
        List<String> addText = new ArrayList<String>(Arrays.asList(text.split("\\s+")));
        wordsArrayList = addText;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        for(int i = 0; i < wordsArrayList.size(); i++){
            if(Objects.equals(wordsArrayList.get(i), wordToBeRemoved)){
                wordsArrayList.remove(i);
            }
        }

    }

    @Override
    public int size() {
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        wordsArrayList = null;
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for(int i = 0; i < wordsArrayList.size(); i++){
            if(Objects.equals(wordsArrayList.get(i),from)){
                wordsArrayList.set(i,to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        //System.out.println(Arrays.toString(toWords));
        boolean matchFound = true;

        for(int i = 0; i < wordsArrayList.size() - fromWords.length+1;i++){
            if(Objects.equals(wordsArrayList.get(i), fromWords[0])){
                for(int k = 1; k<fromWords.length;k++){
                    if(!Objects.equals(wordsArrayList.get(i+k), fromWords[k])){
                        matchFound = false;
                        break;
                    }
                }

                if(matchFound){
                    for(int j = 0; j < fromWords.length;j++){
                        wordsArrayList.remove(i);
                    }
                    for(int l = toWords.length-1; l > -1 ; l--){
                        wordsArrayList.add(i,toWords[l]);
                    }
                    i+=toWords.length-1;
                }
                matchFound = true;

            }
        }
        //System.out.println(wordsArrayList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
