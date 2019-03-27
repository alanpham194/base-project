package commons.dao;

import commons.entity.BaseEntity;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDao<T extends BaseEntity> {
}
