import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * title:
 *    127. Word Ladder
 *
 *  Content:
 *      Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *        1、Only one letter can be changed at a time.
 *        2、Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> closed = new HashSet<>();
        Set<String> opened = new HashSet<>(wordList);
        closed.add(beginWord);

        int ladderLen = 1;

        while (!closed.contains(endWord))
        {
            Set<String> temp = new HashSet<>();
            for(String word : closed)
            {
                for(int i = 0; i < word.length(); i++)
                {
                    char[] tmpWord = word.toCharArray();
                    for(int j = 'a'; j <= 'z'; j++)
                    {
                        tmpWord[i] = (char)j;
                        String newWord = new String(tmpWord);
                        if (opened.contains(newWord))
                        {
                            opened.remove(newWord);
                            temp.add(newWord);
                        }
                    }
                }
            }
            if (temp.size() == 0)
            {
                return 0;
            }
            ladderLen++;

            closed = temp;
        }

        return ladderLen;
    }
}
