package jsonapi.service;

import java.util.List;

import jsonapi.pojo.Gmv;
import jsonapi.pojo.GmvCondition;

public interface DataService {
	List<Gmv> getGmv(GmvCondition gmvCondition);
}
