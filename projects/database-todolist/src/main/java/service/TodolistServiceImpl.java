package service;

import entity.Todolist;
import repository.TodolistRepositoryImpl;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepositoryImpl todolistRepository;

    public TodolistServiceImpl(TodolistRepositoryImpl todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll();

        System.out.println("TODOLIST");
        for (var todolist : model) {
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODOLIST " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS NO: " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS NO: " + number);
        }
    }
}
