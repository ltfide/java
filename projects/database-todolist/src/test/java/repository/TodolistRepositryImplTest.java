package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodolistRepositryImplTest {

    private HikariDataSource dataSource;
    private TodolistRepositoryImpl todolistRepository;

    @BeforeEach
    void setup() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Dendiansyah");

        todolistRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(136));
    }

    @Test
    void testGetAll() {
        Todolist[] todolists = todolistRepository.getAll();
        for (var todo : todolists) {
            System.out.println("ID: " + todo.getId());
            System.out.println("Todo: " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }


}
