package view;

import service.TodolistService;
import util.DatabaseUtil;
import util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist() {
        while (true) {
            todolistService.showTodolist();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")){
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }
    }

    public void addTodolist() {
        System.out.println("MENAMBAH TODOLIST");

        var input = InputUtil.input("Todo (x jika batal)");

        if (input.equals("x")) {
            // batal
        } else {
            todolistService.addTodolist(input);
        }
    }

    public void removeTodolist() {
        System.out.println("MENGHAPUS TODOLIST");

        var input = InputUtil.input("Nomor yang di hapus (x jika batal)");

        if (input.equals("x")) {
            // batal
        } else {
            todolistService.removeTodolist(Integer.valueOf(input));
        }
    }
}


