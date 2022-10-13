package com.AlquilerOrtesis.Ortesis3.Controllers;

import com.AlquilerOrtesis.Ortesis3.Model.Score;
import com.AlquilerOrtesis.Ortesis3.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{idScore}")
    public Optional<Score> getScore(@PathVariable("idScore") int idScore){
        return scoreService.getScore(idScore);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score createScore(@RequestBody Score score){
        return scoreService.createScore(score);
    }

    @PutMapping("/update")
    public Score updateScore(@RequestBody Score score){
        return scoreService.updateScore(score);
    }

    @DeleteMapping("/{idScore}")
    public boolean deleteScore(@PathVariable("idSCore") int idSCore){
        return scoreService.deleteScore(idSCore);
    }
}
