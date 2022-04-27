package br.com.rafaelsplima.repository;

import br.com.rafaelsplima.model.Venda;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class VendasReopository {

    @Inject
    private MongoClient mongoClient;

    // Cria conexão banco de dados
    public MongoCollection<Venda> getConnection() {
         return this.mongoClient
                 .getDatabase("vendas") // Nome database
                 .getCollection("venda", Venda.class); // Nome Collection
    }

    public InsertOneResult create (Venda venda) {
        return getConnection().insertOne(venda);
    }

    public List<Venda> getAll() {
       List<Venda>listaReturno = new ArrayList<>();

       getConnection().find().forEach(listaReturno::add);

       return listaReturno;
    }

}
