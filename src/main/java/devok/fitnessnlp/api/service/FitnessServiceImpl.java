package devok.fitnessnlp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import devok.fitnessnlp.api.processor.Processor;
import devok.fitnessnlp.core.pipeline.Pipeline;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.CoreSentence;

@Service
public class FitnessServiceImpl implements FitnessService {
    Logger logger = LoggerFactory.getLogger(FitnessServiceImpl.class);
    private final Pipeline pipeline;

    public FitnessServiceImpl(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public String processRequest(String request) {
        CoreDocument document = new CoreDocument(request);
        pipeline.getPipeline().annotate(document);
        CoreSentence sentence = document.sentences().get(0);
        logger.info("## Entities found ##");
        List<CoreEntityMention> entitiesToProcess = new ArrayList<>();
        for (CoreEntityMention em : sentence.entityMentions()) {
            logger.info("[Detected entity]: {} \t {}", em.text(), em.entityType());
            if(!em.entityType().equals("0")){
                entitiesToProcess.add(em);
            }
        }
        logger.info("## Tokens and ner tags ##");
        String tokensAndNERTags = sentence.tokens().stream().map(token -> "(" + token.word() + "," + token.ner() + ")").collect(
                Collectors.joining(" "));
        logger.info(tokensAndNERTags);

        Processor.processEntities(entitiesToProcess);
        //TODO generate response
        return "";
    }
}
