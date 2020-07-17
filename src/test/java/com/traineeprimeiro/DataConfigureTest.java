package com.traineeprimeiro;

import static org.junit.jupiter.api.Assertions.*;
import com.traineeprimeiro.infra.querys.produto.ProdutoQuery;

import org.junit.jupiter.api.Test;

public class DataConfigureTest {
    
    @Test
    void ConnectionValid() {

        ProdutoQuery.CreateTable();
        assertTrue(true);
    }
}