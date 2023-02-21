import java.io.PrintStream;
public interface WordCounter {

    void insert(String w);

    WordFreq search(String w);

    void remove(String w);

    void load(String filename) throws Exception;

    int getTotalWords();

    int getDistinctWords();

    int getFrequency(String w);

    WordFreq getMaximumFrequency();

    double getMeanFrequency();

    void addStopWord(String w);

    void removeStopWord(String w);

    void printΤreeAlphabetically(PrintStream stream);

    void printΤreeByFrequency(PrintStream stream);
}