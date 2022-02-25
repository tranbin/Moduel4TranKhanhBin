package music.repository.impl;

import music.model.Music;
import music.repository.MusicRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class MusicRepositoryImpl implements MusicRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = em.createQuery("select c from Music c", Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(int id) {
        TypedQuery<Music> query = em.createQuery("select c from Music c where  c.id=:id", Music.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Music model) {
        if(model.getId()!=0){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(int id) {
        Music music = findById(id);
        if(music != null){
            em.remove(music);
        }
    }
}
