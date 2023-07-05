package devok.fitnessnlp.core.pipeline;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Pipeline {
    private static final Properties properties;
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {
    }

    static {
        properties = new Properties();
        String propertiesName = "tokenize, ssplit, pos, lemma, ner";
        properties.setProperty("annotators", propertiesName);
        properties.setProperty("tokenize.language", "en");
        properties.setProperty("tokenize.whitespace", "true");
        properties.setProperty("ner.combinationMode", "HIGH_RECALL");
    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
