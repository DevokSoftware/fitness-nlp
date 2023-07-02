package devok.fitnessnlp.config;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class StanfordCoreNLPConfig {
    private static final Properties properties;
    private static StanfordCoreNLP stanfordCoreNLP;

    private StanfordCoreNLPConfig() {
    }

    static {
        properties = new Properties();
        String propertiesName = "tokenize";
        properties.setProperty("annotators", propertiesName);
        properties.setProperty("tokenize.language", "en");
        properties.setProperty("tokenize.whitespace", "true");
    }

    public static StanfordCoreNLP getConfig() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
