package io.github.gabrielvelosoo.clientsapi.model.repository.specs;

import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class ProvidedServiceSpec {

    public static Specification<ProvidedService> clienteNomeLike(String nome) {
        return (root, query, cb) -> {
            Join<Object, Object> joinCliente = root.join("client", JoinType.INNER);
            return cb.like( cb.upper( joinCliente.get("nome") ), "%" + nome.toUpperCase() + "%" );
        };
    }

    public static Specification<ProvidedService> mesEqual(Integer mes) {
        return (root, query, cb) -> cb.equal( cb.function("to_char", String.class, root.get("createdAt"), cb.literal("FMMM") ),
                String.valueOf(mes) );
    }
}
