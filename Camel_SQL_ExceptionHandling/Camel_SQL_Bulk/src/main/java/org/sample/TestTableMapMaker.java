package org.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTableMapMaker {
	
	private static int NUM_MESSAGES = 10;
	
    public Map<String, Object> makeMap(int num) {
        Map<String, Object> answer = new HashMap<String, Object>();
        answer.put("id", num);
        answer.put("msg", "Message " + num);
        return answer;
    }
    
    public List<Map<String, Object>> makeList(){
    	List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
    	for (int idx=0; idx < NUM_MESSAGES; idx++) {
    		Map<String, Object> theMap = makeMap(idx);
    		ret.add(theMap);
    	}
    	// special code to add a bad entry
        Map<String, Object> badmap = new HashMap<String, Object>();
        badmap.put("id", "NotAnInteger!");
        badmap.put("msg", "Doomed Message ");
        ret.add(badmap);
    	
    	
    	return ret;
    }

}
