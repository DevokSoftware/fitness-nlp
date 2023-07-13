package devok.fitnessnlp.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exercice {
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private List<String> primaryMuscles;
    private List<String> secondaryMuscles;
    private List<String> instructions;
    private String category;
}
