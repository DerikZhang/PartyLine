package cn.bnuz.party.util;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import org.junit.Test;
import cn.bnuz.party.vo.Result;

public class JsonUtil {
	
	public static String ResultToJson(Result result){
		
		return JSONObject.fromObject(result).toString();
		
	}
	
	@Test
	public void test(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", "value");
//		Result result =  new Result(0,"Test",param);
//		System.out.println(JSONUtils.valueToString(result));
//		System.out.println(ResultToJson(result));
//		System.out.println(JSONObject.fromObject(param));
		
	}
}
