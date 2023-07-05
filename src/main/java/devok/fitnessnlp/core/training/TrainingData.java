package devok.fitnessnlp.core.training;

import devok.fitnessnlp.core.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainingData {

    public static void main(String[] args) {
        // Prepare your labeled training data
        List<String> trainingSentences = new ArrayList<>();

        // Add training sentences with annotations
        trainingSentences.add("I need a beginner workout plan for my biceps.");
        trainingSentences.add("What is the best chest exercise for an intermediate level?");
        trainingSentences.add("Can you suggest a three-day workout routine for an expert?");
        // Add more sentences with different conditions and entities

        // Annotate the entities in each training sentence
        List<String> annotatedSentences = annotateEntities(trainingSentences);

        // Save the annotated sentences to a file
        saveAnnotatedData(annotatedSentences, "training_data.txt");
    }

    private static List<String> annotateEntities(List<String> sentences) {
        List<String> annotatedSentences = new ArrayList<>();

        for (String sentence : sentences) {
            // Perform entity annotation for each sentence
            // You can use any custom logic or rules to identify and annotate entities
            // For simplicity, let's assume we are only interested in workout plans, levels, and body parts
            String annotatedSentence = annotateEntitiesInSentence(sentence);
            annotatedSentences.add(annotatedSentence);
        }

        return annotatedSentences;
    }

    private static String annotateEntitiesInSentence(String sentence) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        StringBuilder annotatedSentence = new StringBuilder();

        CoreDocument doc = new CoreDocument(sentence);
        // annotate
        stanfordCoreNLP.annotate(doc);

        for (CoreLabel token : doc.tokens()) {
            String word = token.word();

            // Check if the word matches any entity pattern
            // You can use regular expressions or other methods to match the patterns
            String entityLabel = identifyEntity(word);

            if (entityLabel != null) {
                // Annotate the entity with its label
                annotatedSentence.append(word).append("/").append(entityLabel).append(" ");
            } else {
                // If the word doesn't match any entity, keep it as it is
                annotatedSentence.append(word).append(" ");
            }
        }

        return annotatedSentence.toString().trim();
    }

    private static String identifyEntity(String word) {
        // Custom logic to identify and label entities based on patterns
        // For example, you can use if-else conditions or regular expressions to match patterns

        // Check if the word represents a workout plan
        if (word.equalsIgnoreCase("workout") || word.equalsIgnoreCase("routine") || word.equalsIgnoreCase("plan")) {
            return "WORKOUT";
        }

        // Check if the word represents a level
        if (word.equalsIgnoreCase("beginner") || word.equalsIgnoreCase("intermediate") || word.equalsIgnoreCase("expert")) {
            return "LEVEL";
        }

        // Check if the word represents a body part
        if (word.equalsIgnoreCase("biceps") || word.equalsIgnoreCase("chest")) {
            return "BODY_PART";
        }

        // Return null if the word doesn't match any entity
        return null;
    }

    private static void saveAnnotatedData(List<String> annotatedSentences, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String annotatedSentence : annotatedSentences) {
                writer.write(annotatedSentence);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
