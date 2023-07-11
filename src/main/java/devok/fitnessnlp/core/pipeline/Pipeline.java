package devok.fitnessnlp.core.pipeline;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@Service
public class Pipeline {
    private static final Properties properties;
    private StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {
    }

    static {
        properties = new Properties();
        String propertiesName = "tokenize, ssplit, pos, lemma, ner";
        properties.setProperty("annotators", propertiesName);
        properties.setProperty("tokenize.language", "en");
        properties.setProperty("tokenize.whitespace", "true");
        properties.setProperty("ner.combinationMode", "HIGH_RECALL");
        properties.setProperty("ner.model", "./ner-model.ser.gz");
    }

    @Bean(name = "stanfordCoreNLP")
    public StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
