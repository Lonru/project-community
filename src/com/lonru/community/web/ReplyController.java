package com.lonru.community.web;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lonru.community.domain.CommonDto;
import com.lonru.community.domain.reply.Reply;
import com.lonru.community.domain.reply.dto.SaveReqDto;
import com.lonru.community.service.ReplyService;
import com.lonru.community.util.Script;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		ReplyService replyService = new ReplyService();
		// http://localhost:8000/blog/reply?cmd=
		HttpSession session = request.getSession();
		
		if (cmd.equals("save")){
			BufferedReader br = request.getReader();
			String reqData= br.readLine();
			Gson gson= new Gson();
			SaveReqDto dto = gson.fromJson(reqData, SaveReqDto.class);
			
			CommonDto<Reply> commonRespDto = new CommonDto<>(0);
			Reply reply = null;

			int result = replyService.댓글쓰기(dto);
			if(result != -1) {
				reply = replyService.댓글찾기(result);
				commonRespDto.setStatusCode(1); //1, -1
				commonRespDto.setData(reply);
			}else {
				commonRespDto.setStatusCode(-1); //1, -1
			}
			
			String responseData = gson.toJson(commonRespDto);
			System.out.println("responseData : "+responseData);
		//	Script.responseData(response, responseData);
		}else if(cmd.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result =replyService.댓글삭제(id);
			
			CommonDto commonDto = new CommonDto<>(result);
			//이대로 응답은 안되서 gson 사용한다.
			
			Gson gson = new Gson();
			String jsonData=gson.toJson(commonDto);
			//Script.responseData(response, jsonData);
		}
	}
}
