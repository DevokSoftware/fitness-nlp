package devok.fitnessnlp.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devok.fitnessnlp.api.service.FitnessService;

@RestController
public class FitnessController {

    private final FitnessService fitnessService;

    public FitnessController(FitnessService fitnessService) {
        this.fitnessService = fitnessService;
    }

    @GetMapping("/tags")
    public ResponseEntity<String> getRequestWithTags(@RequestParam("request") String request) {
        if (StringUtils.isEmpty(request)) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(fitnessService.getRequestWithTags(request), HttpStatus.OK);
    }
}
