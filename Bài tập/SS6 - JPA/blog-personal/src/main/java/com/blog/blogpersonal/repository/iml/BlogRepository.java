package com.blog.blogpersonal.repository.iml;

import com.blog.blogpersonal.model.Blog;
import com.blog.blogpersonal.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.id = :id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != 0 ) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }

    @Override
    public List<Blog> findByName(String search) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.title like :title", Blog.class);
        query.setParameter("title", "%"+search+"%");
        return query.getResultList();
    }
}
