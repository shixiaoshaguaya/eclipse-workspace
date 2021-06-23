package jsonapi.mapper;

import java.util.List;

import jsonapi.pojo.Gmv;
import jsonapi.pojo.GmvCondition;

public interface DataMapper {
	List<Gmv> getGmv(GmvCondition gmvCondition);
}
