public class Clone550 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:39319386
*  And Stack Overflow answer#:21447112
*/
public static Boolean isAnagram (String word, String anagram_word) {
if (word.length () != anagram_word.length ()) {
return false;
}
for (int i = 0;
i < words_char.length; i ++) {
words_char_num *= wordPrimeMap.get (words_char [i]);
}
for (int i = 0;
i < anagram_word_char.length; i ++) {
anagram_word_num *= wordPrimeMap.get (anagram_word_char [i]);
}
return anagram_word_num == words_char_num;
}

public static boolean isAnagram (String first, String second) {
if (positive.length () != negative.length ()) {
return false;
}
for (int i = 0;
i < positive.length (); i ++) {
int pos = (int) positive.charAt (i) - 97;
if (counts [pos] >= 0) {
diff ++;
} else {
diff --;
}
counts [pos] ++;
int neg = (int) negative.charAt (i) - 97;
if (counts [neg] <= 0) {
diff ++;
} else {
diff --;
}
counts [neg] --;
}
return diff == 0;
}

}