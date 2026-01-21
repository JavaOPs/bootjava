package ru.javaops.bootjava.user.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import ru.javaops.bootjava.user.model.User;
import ru.javaops.bootjava.user.repository.UserRepository;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractUserController {
    protected final Logger log = getLogger(getClass());

    @Autowired
    protected UserCache userCache;

    @Autowired
    protected UserRepository repository;

    @Autowired
    private UniqueMailValidator emailValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(emailValidator);
    }

    public User get(int id) {
        log.info("get {}", id);
        return repository.getExisted(id);
    }

    public void delete(int id, String invalidateEmail) {
        log.info("delete {}", id);
        repository.deleteExisted(id);
        userCache.removeUserFromCache(invalidateEmail);
    }

    public void update(User user, String invalidateEmail) {
        repository.prepareAndSave(user);
        userCache.removeUserFromCache(invalidateEmail);
    }
}