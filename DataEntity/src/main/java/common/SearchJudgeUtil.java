package common;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class SearchJudgeUtil {
    public static boolean isContain(String searchField,String matchText) {
        List<Term> terms = ToAnalysis.parse(searchField).getTerms();
        System.out.println(terms);
        for (Term term : terms) {
            String name = term.getName();
            if (matchText.contains(name))
                return true;
        }
        return false;
    }

}
