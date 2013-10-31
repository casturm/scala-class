package forcomp

import Anagrams._

object anagram {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  var sentence = List("Yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(76); 
  //var sentence = List("To", "be")
  var o = sentenceOccurrences(sentence);System.out.println("""o  : forcomp.Anagrams.Occurrences = """ + $show(o ));$skip(26); 
  var c = combinations(o);System.out.println("""c  : List[forcomp.Anagrams.Occurrences] = """ + $show(c ));$skip(789); 
  
  //subtract(c, List(('a',1),('e',1),('n',1)))
  
//  for (c <- combinations(o))
//    println(dictionaryByOccurrences get (c))
//    println(anagramsHelp(c))
  //(for (o1 <- combinations(occurrences)) yield ).flatten
  
  def anagramsHelp(occurrences: Occurrences): List[Sentence] = {
    print("o "); println(occurrences)
    if (occurrences.isEmpty) List(List())
    else {
      (
      for {
        c <- combinations(occurrences)
        word <- dictionaryByOccurrences(c)
      //} yield { print("ws "); println(words)
      //  for {
        rest <- anagramsHelp(subtract(occurrences, c))
        } yield {
            print("w "); println(word);
            print("r "); println(rest);
            word :: rest
            //List()
          }
      //}
      ).toList
	  }
	};System.out.println("""anagramsHelp: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Sentence]""");$skip(62); 
	
	var anagrams = anagramsHelp(sentenceOccurrences(sentence));System.out.println("""anagrams  : List[forcomp.Anagrams.Sentence] = """ + $show(anagrams ));$skip(11); val res$0 = 
  anagrams;System.out.println("""res0: List[forcomp.Anagrams.Sentence] = """ + $show(res$0))}
//  build(sentenceOccurrences(sentence))
}
