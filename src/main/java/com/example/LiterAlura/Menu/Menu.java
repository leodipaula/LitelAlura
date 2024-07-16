package com.example.LiterAlura.Menu;

import com.example.LiterAlura.model.Book;
import com.example.LiterAlura.model.ResultsData;
import com.example.LiterAlura.model.SearchBookAndAuthor;
import com.example.LiterAlura.repository.BookRepository;

import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private final String menu = """
            -------------------------------------------------
            Escolha o número da sua opção: 
            1 - Buscar livro pelo título.
            2 - Listar livros registrados.
            3 - Listar autores registrados.
            4 - Listar autores vivos em um determinado ano.
            5 - Listar livros em um determinado idioma.
            0 - Sair.
            -------------------------------------------------""";
    private final Scanner read = new Scanner(System.in);
    private final BookRepository repository;

    public Menu(BookRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        int option = -1;
        do {
            System.out.println(menu);
            option = read.nextInt();
            read.nextLine();
            switch (option) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 0:
                    break;
                default:
                    System.out.println("Valor inválido: " + option);
            }
        } while (option != 0);
    }

    private void searchBookByTitle() {
        System.out.println("Insira o título que deseja buscar:");
        Optional<ResultsData> result = new SearchBookAndAuthor(read.nextLine()).search();
        if (result.isEmpty()) {
            System.out.println("Não foi encontrado livro correspondente. Tente pesquisar o título + nome do autor.");
            return;
        }
        //repository.save(result.get());
        System.out.println(result.get());
    }
}
