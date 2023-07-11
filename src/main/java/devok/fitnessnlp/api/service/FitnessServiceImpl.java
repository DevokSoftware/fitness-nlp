package devok.fitnessnlp.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import devok.fitnessnlp.core.pipeline.Pipeline;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;

@Service
public class FitnessServiceImpl implements FitnessService {

    private final Pipeline pipeline;

    public FitnessServiceImpl(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public String getRequestWithTags(String request) {
        CoreDocument document = new CoreDocument(request);
        pipeline.getPipeline().annotate(document);
        CoreSentence sentence = document.sentences().get(0);
        List<String> nerTags = sentence.nerTags();
        return nerTags.toString();
    }
}
