public class WordFreq {
    private String word;
    int timesFound;

    public WordFreq(String word,int timesFound){
        this.word=word;
        this.timesFound=timesFound;
    }

    public WordFreq(){
        this.word="";
        this.timesFound=1;
    }

    public WordFreq(String word) {
        this.word=word;
        this.timesFound=1;
    }



    public String key() {
        return word;
    }

    public int getTimesFound() {
        return timesFound;
    }

    public String toString(){
        return "the word: "+word+" times found: "+timesFound;
    }

}
