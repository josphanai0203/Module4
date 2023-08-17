package app.service;

import app.entity.Feedback;
import app.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;
    public void save(Feedback f){
        feedbackRepository.save(f);
    }
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }
    public void likeAction(long id){
        feedbackRepository.likeAction(id);
    }
}
