package basic.json;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;


@WebServlet("/json/jsonDataTest.do")
public class JsonDataTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		String json = null;
		
		switch(choice) {
			case "string": String str = "안녕하세요";
				json = gson.toJson(str);
				break;
			case "array": int[] arr = { 10,20,30,40,50 };
				json = gson.toJson(arr);
				break;
			case "obj": SampleVO vo = new SampleVO(1, "유재석", "서울");
				json = gson.toJson(vo);
				break;
			case "list": List<SampleVO> list = new ArrayList<SampleVO>();
				list.add(new SampleVO(10, "유재석", "강남"));
				list.add(new SampleVO(20, "노홍철", "압구정"));
				list.add(new SampleVO(30, "정형돈", "강북"));
				list.add(new SampleVO(40, "박명수", "논현"));
				json = gson.toJson(list);
				break;
			case "map": Map<String, String> map = new HashMap<String, String>();
				map.put("name", "유재석");
				map.put("tel", "010-0000-0000");
				map.put("addr", "서울 강남");
				json = gson.toJson(map);
				break;
		}
		
		System.out.println(choice + "==>" + json);
		
		// 처리 결과를 응답으로 보낸다
		PrintWriter out = response.getWriter();
		
		out.write(json);
		response.flushBuffer();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
