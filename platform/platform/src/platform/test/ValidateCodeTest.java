package platform.test;

import java.io.IOException;
import java.util.Date;

import platform.util.ValidateCode;

public class ValidateCodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateCode vCode = new ValidateCode(60,20,5,100);
		try {
			String path="D:/"+new Date().getTime()+".png";
			System.out.println(vCode.getCode()+" >"+path);
			vCode.write(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
