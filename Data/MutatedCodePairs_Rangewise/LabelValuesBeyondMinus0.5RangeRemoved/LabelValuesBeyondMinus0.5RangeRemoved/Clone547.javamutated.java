public class Clone547 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:37772633
*  And Stack Overflow answer#:39319386
*/
private static boolean isAnagram (String s1, String s2) {
if (s1.length () != s2.length ()) return false;
for (int i = 0;
i < s1.length (); i ++) {
seen [s1.charAt (i)] = seen [s1.charAt (i)] + 1;
}
for (int i = 0;
i < s2.length (); i ++) {
if (seen [s2.charAt (i)] == 0) return false;
seen [s2.charAt (i)] = seen [s2.charAt (i)] - 1;
}
for (int i = 0;
i < 256; i ++) {
if (seen [i] != 0) return false;
}
return true;
}

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

}