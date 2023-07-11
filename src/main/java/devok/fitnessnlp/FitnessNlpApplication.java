package devok.fitnessnlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devok.fitnessnlp.core.pipeline.Pipeline;


@SpringBootApplication
public class FitnessNlpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessNlpApplication.class, args);
    }
}
