package Etc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * 1. json파싱 라이브러리 필요, need to lib -> json.simple.jar 
 * 2. 파싱 파일 경로는 Path에 기입, need to exist file Path
 */
public class Program_auto {

	static String Path = "src/Etc/";
	static String FileNm = "test.txt";
	static Map<Long, String> validBox = new TreeMap<>();
	static Map<Long, String> dontcare = new TreeMap<>();
	
	public static void main(String[] args) {

		int error = 0;
		JSONParser parser = new JSONParser();

		try {
			String jsonStr = makeJsonFormat();
			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);

			error = 1;
			if (!checkSize((JSONObject)jsonObj.get("image"))) {
				System.out.println("### error => [ " + error +" ] ###");
				return ;
			}
			System.out.println("Pass 1 => 사진 사이즈가 1600x1200 입니다");
			
			makeBoxList((JSONArray) jsonObj.get("annotations"));

			if ((error = validBoxCheck()) != 0) {
				System.out.println("### error => [ " + error +" ] ###");
				return ;
			}
			System.out.println("Pass 2 => 유효박스의 입력에 문제가 없습니다.");
			
//			if (!checkColor()) {
//				return ;
//			}
			
			System.out.println("### Blue ( "+ validBox.size()+" ), 여기에 Green 있으면 안됨 !! ###");
			System.out.println(validBox.toString());
			System.out.println("### Green ( "+ dontcare.size()+" ), 여기에 Blue 있으면 안됨 !! ###");
			System.out.println(dontcare.toString());
			
			System.out.println("## Pass ##");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private static String makeJsonFormat() {

		StringBuilder sb = new StringBuilder("");
		String result;

		try {
			FileReader fr = new FileReader(Path + FileNm);
			BufferedReader br  = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println("### makeJsonFormat Error ###");
			e.printStackTrace();
		}
		
		int i;
		result = sb.toString();
		i = result.indexOf("image");
		result = result.substring(i, result.length());
		result = result.replaceFirst("image", "{\"image\"");
		result = result.replaceFirst("annotations", ", \"annotations\"");
		i = result.lastIndexOf("]");
		result = result.substring(0, i + 1);
		result += "}";

		// System.out.println(result);
		return result;
	}

	private static boolean checkSize(JSONObject obj) {

		long width = (Long)obj.get("width");
		long height = (Long)obj.get("height");

		if (width != 1600) {
			System.out.println("width 가 1600이 아닙니다. [ " + width +" ]" );
			return false;
		}
		if (height != 1200) {
			System.out.println("height 가 1200이 아닙니다. [ " + width +" ]" );
			return false;
		}
		return true ;
	}

	private static int validBoxCheck() {

		// 공백허용, 단일 자,모음 허용
		String regExp = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣\\s]*$";

		if (validBox.size() == 0) {
			System.out.println("유효박스가 존재하지 않습니다.");
			return 15;
		} else if(validBox.size() > 3) {
			System.out.println("유효박스는 최대3개 까지만 존재할 수 있습니다.");
			System.out.println(validBox.toString());
			return 8;
		} else {
			
			Iterator itr = validBox.keySet().iterator();

			while (itr.hasNext()) {
				long key = (Long)itr.next();
				String value = validBox.get(key);
				
				int wordCnt = value.replaceAll(" ", "").trim().length();
				if (wordCnt > 10) {
					System.out.println(key +"번 박스의 한글이 10글자를 초과합니다. (공백 미포함) [ " + value +"("+wordCnt+") ]");
					return 9;
				}

				if (!value.matches(regExp)) {
					System.out.println(key +"번 박스에, 한글이 아닌 문자가 존재합니다.");
					return 3;
				}
			}
		}
		return 0;
	}

	private static void makeBoxList(JSONArray annotations) {

		for (int i = 0; i < annotations.size(); i++) {
			JSONObject box = (JSONObject)annotations.get(i);

			long id = (Long)box.get("id");
			String text = (String)box.get("text");

			if (text.equals("xxx"))
				dontcare.put(id, text);
			else
				validBox.put(id, text);
		}
	}
	
	private static String getAnsewer() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static boolean checkColor() {
		Iterator itr = validBox.keySet().iterator();

		while (itr.hasNext()) {
			long key = (Long)itr.next();
			String value = validBox.get(key);
			
			int wordCnt = value.replaceAll(" ", "").trim().length();
			
			System.out.println("Box [ " + key + " ] [ "+ value +"("+wordCnt +") ] is \"Blue\" ??? [ 맞으면 Enter , 아니면 N 입력 ]");
			if (getAnsewer().equals("N")) {
				// xxx가아닌데 그린인 경우
				System.out.println(key +"Box 의 색깔이 잘못되었습니다. => xxx가아닌데 그린인 경우 => error [12] ");
				return false;
			}
		}
		
		itr = dontcare.keySet().iterator();

		while (itr.hasNext()) {
			long key = (Long)itr.next();
			String value = dontcare.get(key);
			
			System.out.println("Box [ " + key + " ] [ "+ value +" ] is \"Green\" ??? [ 맞으면 Enter , 아니면 N 입력 ]");
			if (getAnsewer().equals("N")) {
				// xxx인데 파랑인 경우.. 
				System.out.println(key +"Box 의 색깔이 잘못되었습니다. => xxx인데 파랑인 경우 => error [3] ");
				return false;
			}
		}
		return true;
	}
}
