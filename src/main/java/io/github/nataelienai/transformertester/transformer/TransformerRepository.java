package io.github.nataelienai.transformertester.transformer;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends MongoRepository<Transformer, String> {

  @Query("{ '_id': { $in: ?0 } }")
  List<Transformer> findAllById(List<String> ids);

}
