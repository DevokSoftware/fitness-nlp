package devok.fitnessnlp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devok.fitnessnlp.config.StanfordCoreNLPConfig;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@SpringBootApplication
public class FitnessNlpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessNlpApplication.class, args);
        StanfordCoreNLP stanfordCoreNLP = StanfordCoreNLPConfig.getConfig();
        String text = "Please give me a workout plan for 3 days of gym per week, where I can exercise back, chest and biceps.";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> tokens = coreDocument.sentences();

        for (CoreSentence coreLabel : tokens) {
            System.out.println(coreLabel);
        }
    }
}
