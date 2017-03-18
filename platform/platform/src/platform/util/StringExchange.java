package platform.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 大小写转换
 * @author hjm
 *
 */
public class StringExchange {
	
	@SuppressWarnings("rawtypes")
	//遍历map，将大写转为小写
	public static Map exChangeMap(Map<Object,Object> map){
		Map<Object, Object> map2 = new HashMap<Object, Object>();
		for (Entry<Object, Object> entry : map.entrySet()) {
			entry.getKey().toString().toLowerCase();
			entry.getValue();
			map2.put(entry.getKey().toString().toLowerCase(), entry.getValue());
		}
		System.out.println(map2);
			return map2;
	}
	//把一个字符串中的小写转为大写，大写转换为小写：思路 
	public static String exChange(String str){  
	    StringBuffer sb = new StringBuffer();  
	    if(str!=null){  
	        for(int i=0;i<str.length();i++){  
	            char c = str.charAt(i);  
	            if(Character.isUpperCase(c)){  
	                sb.append(Character.toLowerCase(c));  
	            }else if(Character.isLowerCase(c)){  
	                sb.append(Character.toUpperCase(c));   
	            }  
	        }  
	    }  
	      
	    return sb.toString();  
	}  
	  
	//把一个字符串中的大写转为小写，小写转换为大写：思路2  
	public static String exChange2(String str){  
	    for(int i=0;i<str.length();i++){  
	        //如果是小写  
	        if(str.substring(i, i+1).equals(str.substring(i, i+1).toLowerCase())){  
	            str.substring(i, i+1).toUpperCase();  
	        }else{  
	            str.substring(i, i+1).toLowerCase();  
	        }  
	    }  
	    return str;  
	}  
}
