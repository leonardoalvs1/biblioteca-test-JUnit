package com.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    private Biblioteca sut;

    @BeforeEach
    void setUp() { sut = new Biblioteca(); }

    @Test
    void deveAdicionarLivros() {
        sut.adicionarLivro("Clean Code");
        sut.adicionarLivro("Refactoring");
        assertEquals(List.of("Clean Code", "Refactoring"), sut.listarLivros());
    }

    @Test
    void deveRemoverLivroExistente() {
        sut.adicionarLivro("DDD");
        assertTrue(sut.removerLivro("DDD"));
        assertFalse(sut.listarLivros().contains("DDD"));
    }

    @Test
    void listaNaoPodeSerModificadaExternamente() {
        sut.adicionarLivro("The Pragmatic Programmer");
        var livros = sut.listarLivros();
        assertThrows(UnsupportedOperationException.class, () -> livros.add("Novo"));
    }
}