package app.repository;

import app.entity.Feedback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class FeedbackRepository {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Feedback f) {
        entityManager.persist(f);
    }

    public List<Feedback> findAll() {
        return entityManager.createQuery("from Feedback f").getResultList();
    }

    public void likeAction(long id) {
        Feedback f = entityManager.find(Feedback.class,id);
        System.out.println(f.getLikes());
        f.setLikes(f.getLikes() +1);
        entityManager.merge(f);
    }
}
