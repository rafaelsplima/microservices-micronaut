package br.com.rafaelsplima.http.fallback;

import br.com.rafaelsplima.dto.output.Veiculo;
import br.com.rafaelsplima.http.VeiculoHttp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.retry.annotation.Fallback;
import jakarta.inject.Inject;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Fallback
public class VeiculoHttpFallback implements VeiculoHttp {

    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Veiculo getById(Long id) throws JsonProcessingException {
        var jedPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        var jedis = jedPool.getResource();
        // Recupera no REDIS
        var veiculoJSON = jedis.get(id.toString());
        var veiculo = objectMapper.readValue(veiculoJSON, Veiculo.class);

        return veiculo;
    }
}
