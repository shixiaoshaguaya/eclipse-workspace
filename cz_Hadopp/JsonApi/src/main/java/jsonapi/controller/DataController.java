package jsonapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jsonapi.common.ServerResponse;
import jsonapi.pojo.Gmv;
import jsonapi.pojo.GmvCondition;
import jsonapi.service.DataService;

@CrossOrigin
@Controller
public class DataController {
	@Autowired
	DataService dataService;

	@RequestMapping(value = "/gmv.action")
	@ResponseBody
	public ServerResponse<List<Gmv>> getGmv(GmvCondition gmvCondition) {

		List<Gmv> gmvList = dataService.getGmv(gmvCondition);
		if (gmvList.size() > 0) {
			return ServerResponse.createBySuccess("查询成功", gmvList);
		}
		return ServerResponse.createByError("查询记录为空");
	}
}
