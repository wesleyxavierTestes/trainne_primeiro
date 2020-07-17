package com.traineeprimeiro.infra.querys.produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.traineeprimeiro.domain.entities.Produto;
import com.traineeprimeiro.infra.data.DataConfigure;

public class ProdutoQuery {

    public static void CreateTable() {
        try {
            Connection con = DataConfigure.getConnection();
            Statement sq_stmt = (Statement) con.createStatement();
            StringBuilder query = new StringBuilder();
            query.append("CREATE TABLE Produto(" +
                    "id serial PRIMARY KEY," +
                    "nome VARCHAR (255) UNIQUE NOT NULL," +
                    "valor DECIMAL NOT NULL" +
                    ")");

            sq_stmt.executeUpdate(query.toString());
            sq_stmt.close();
        } catch (Exception e) {
            return;
        }
    }

    public static List<Produto> SelectList() {
        try {
            List<Produto> lista = new ArrayList<Produto>();
            Connection con = DataConfigure.getConnection();
            Statement sq_stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM Produto";
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next()){
                Produto cli = new Produto();
                cli.setId(rs.getLong("id"));
                cli.setNome(rs.getString("nome"));
                cli.setValor(rs.getBigDecimal("valor"));

                lista.add(cli);
            }
            rs.close();
            sq_stmt.close();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}