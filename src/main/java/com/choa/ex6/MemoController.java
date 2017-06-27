package com.choa.ex6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	//list
	@RequestMapping(value="memoList")
	public void memoList(){}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody
	/*public List<MemoDTO> memoList(ListInfo listInfo, Model model) throws Exception {*/
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage, @PathVariable String find, @PathVariable String search) throws Exception {
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		List<MemoDTO> list = memoService.boardList(listInfo);
		//view가 아니라 data로 전송
		
		return list;
		
/*		기존의 json방식
 * 		JSONArray ar = new JSONArray();
		for(MemoDTO m:list){
			JSONObject obj = new JSONObject();
			obj.put("num", m.getNum()+"");
			obj.put("writer", m.getWriter());
			obj.put("contents", m.getContents());
			obj.put("reg_date", m.getReg_date().toString());
			ar.add(obj);
		}
		//model.addAttribute("list", list);
		model.addAttribute("list", ar.toJSONString());*/
	}
	

	@RequestMapping(value="memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num) throws Exception{
		MemoDTO memoDTO = memoService.boardView(num);
		return memoDTO;
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	/*public String memoWrite(MemoDTO memoDTO, Model model) throws Exception {*/
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model) throws Exception {
		int result = memoService.boardWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list = memoService.boardList(listInfo);

		return list;
		/*		model.addAttribute("list", list);
		
		return "memo/getMemoList";*/
/*		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		
		//model.addAttribute("message", message);
		//2번 방법
		model.addAttribute("message", memoDTO);
		
		return "commons/ajaxResult";*/
	}
}
