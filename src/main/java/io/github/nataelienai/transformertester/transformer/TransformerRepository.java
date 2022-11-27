package io.github.nataelienai.transformertester.transformer;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends MongoRepository<Transformer, String> {
  List<Transformer> findAllById(List<String> ids);
}
