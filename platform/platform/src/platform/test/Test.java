package platform.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("NAME", "name");
		map1.put("AGE", "45");
		map1.put("sex", "MAN");
		Map<Object, Object> map2 = new HashMap<Object, Object>();
		for (Entry<Object, Object> entry : map1.entrySet()) {
			entry.getKey().toString().toLowerCase();
			entry.getValue();
			map2.put(entry.getKey().toString().toLowerCase(), entry.getValue());
		}
		System.out.println(map2);

	}

	public String test2(HttpServletResponse response) {
		response.setHeader("Content-Type", "text/event-stream");
		String str = "1111";

		/*
		 * while (true){ echo "data:".str."\n\n";
		 * 
		 * @ob_flush();
		 * 
		 * @flush(); sleep(1); }
		 */

		return str;

	}
}
