package org.example.app.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);


    boolean removeCheckedItems();

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
