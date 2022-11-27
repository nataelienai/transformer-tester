package io.github.nataelienai.transformertester.transformer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends MongoRepository<Transformer, String> {
}
