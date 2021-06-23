package jsonapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsonapi.mapper.DataMapper;
import jsonapi.pojo.Gmv;
import jsonapi.pojo.GmvCondition;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
    DataMapper dataMapper;
    public List<Gmv> getGmv(GmvCondition gmvCondition) {
        return this.dataMapper.getGmv(gmvCondition);
    }
}
