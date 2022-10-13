package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Score;
import com.AlquilerOrtesis.Ortesis3.Repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int idScore){
        return scoreRepository.getScore(idScore);
    }

    public Score createScore(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else
            return score;
    }

    public Score updateScore(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> temp = scoreRepository.getScore(score.getIdScore());
            if (temp.isPresent()){
                if(score.getScore()!=null)
                    temp.get().setScore(score.getScore());
                if(score.getMessageText()!=null)
                    temp.get().setMessageText(score.getMessageText());
                if (score.getReservation()!=null)
                    temp.get().setReservation(score.getReservation());
                return scoreRepository.save(temp.get());
            } else
                return score;
        }else
            return score;
    }

    public boolean deleteScore(int idScore){
        Boolean success = getScore(idScore).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return true;
    }
}
