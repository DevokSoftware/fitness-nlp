package devok.fitnessnlp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devok.fitnessnlp.core.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@SpringBootApplication
public class FitnessNlpApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FitnessNlpApplication.class, args);
//        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
//        String text = "Please give me a workout plan for 3 days of gym per week, where I can exercise back, chest and biceps.";
//        CoreDocument coreDocument = new CoreDocument(text);
//        stanfordCoreNLP.annotate(coreDocument);
//
//        List<CoreLabel> tokens = coreDocument.tokens();
//
//        for (CoreLabel coreLabel : tokens) {
//            String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//            System.out.println(coreLabel.originalText() + " | " + ner);
//        }
    }
}
