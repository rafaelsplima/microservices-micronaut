package br.com.rafaelsplima.service;

import br.com.rafaelsplima.dto.output.Veiculo;
import br.com.rafaelsplima.http.VeiculoHttp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Singleton
public class VeiculoService {

    @Inject
    private VeiculoHttp veiculoHttp;

    @Inject
    private ObjectMapper objectMapper;

    public Veiculo getVeiculo (Long id) throws JsonProcessingException {
        Veiculo veiculo = veiculoHttp.getById(id);
        gravarCache(veiculo);
        return veiculo;
    }

    public void gravarCache(Veiculo veiculo) throws JsonProcessingException {
        var jedPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        var jedis = jedPool.getResource();
        var veiculoJSON = objectMapper.writeValueAsString(veiculo);

        // Gravar no Redis
        jedis.set(veiculo.getId().toString(),veiculoJSON);
    }

}
