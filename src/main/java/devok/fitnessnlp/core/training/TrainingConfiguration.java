package devok.fitnessnlp.core.training;

import java.util.Properties;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.sequences.SeqClassifierFlags;
import edu.stanford.nlp.util.StringUtils;

public class TrainingConfiguration {

    public static void main(String[] args) {
        // Create the training configuration properties
        Properties props = StringUtils.propFileToProperties("config.properties");
        props.setProperty("serializeTo", "./ner-model.ser.gz");
        //if input use that, else use from properties file.
        SeqClassifierFlags flags = new SeqClassifierFlags(props);
        // Create the CRFClassifier with the training configuration
        CRFClassifier<CoreLabel> classifier = new CRFClassifier<>(flags);

        // Train the NER model
        classifier.train();
        classifier.serializeClassifier("./ner-model.ser.gz");

        String[] tests = new String[] {"Give me a workout plan for biceps and chest please"};
        for (String item : tests) {
            doTagging(classifier, item);
        }
    }


    public static void doTagging(CRFClassifier model, String input) {
        input = input.trim();
        System.out.println(input + "=>"  +  model.classifyToString(input));
    }
}