package com.day.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.RepBoardService;

@RestController
@RequestMapping("/board/*")
public class RepBoardController {
	private Logger log = Logger.getLogger(RestController.class);

	@Autowired
	private RepBoardService service;

	@PostMapping("/write")
	public Map<String, Object> write(@RequestBody RepBoard repBoard) {
		log.info("repBoard ==============> " + repBoard);
		Map<String, Object> result = new HashMap<>();
		//result.put("status", 1);
		try {
			service.write(repBoard);
			result.put("status", 1);
		} catch (AddException e) {
			e.printStackTrace();
			result.put("status", 0); // 실패
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@PostMapping("/reply/{no}")
	public Map<String, Object> reply(@PathVariable int no, // 부모글번호
			@RequestBody RepBoard repBoard) {
		Map<String, Object> result = new HashMap<>();
		try {
			log.error("no:" + no);
			repBoard.setParentNo(no);
			service.reply(repBoard);
			result.put("status", 1);
		} catch (AddException e) {
			e.printStackTrace();
			result.put("status", 0); // 실패
			result.put("msg", e.getMessage());
		}
		return result;
	}

//	@GetMapping(value = { "/list", "/list/{word}" })
//	public Map<String, Object> list(@PathVariable(name = "word") Optional<String> optWord) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		List<RepBoard> list = new ArrayList<RepBoard>();
//		try {
//			if (optWord.isPresent()) {
//				log.info("word : " + optWord.get());
//				list = service.list(optWord.get());
//			} else {
//				list = service.list();
//			}
//			result.put("status", 1);
//			result.put("list", list);
//		} catch (FindException e) {
//			result.put("status", 0);
//			result.put("msg", e.getMessage());
//		}
//		return result;
//	}
	
	@GetMapping(value = { "/list", "/list/{word}" })
	public Map<String, Object> list(@PathVariable(name = "word") Optional<String> optWord) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<RepBoard> list = new ArrayList<RepBoard>();
		try {
			if (optWord.isPresent()) {
				log.info("word : " + optWord.get());
				list = service.list(optWord.get());
			} else {
				list = service.list();
			}
			result.put("status", 1);
			result.put("list", list);
		} catch (FindException e) {
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	@GetMapping("/{no}")
	public Map<String, Object> find(@PathVariable int no) {
		Map<String, Object> resultMap = new HashMap();
		RepBoard repBoard;
		try {
			log.info("no : " + no);
			repBoard = service.findByNo(no);
			resultMap.put("status", 1);
			resultMap.put("repo", repBoard);
		} catch (FindException e) {
			resultMap.put("status", 0);
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
	@PutMapping("/{no}")
	public Map<String, Object> modify(@PathVariable int no, @RequestBody RepBoard repBoard) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			log.info("이거 수정인 경우임. no : " + no);
			repBoard.setBoardNo(no);
			service.Modify(repBoard);
			resultMap.put("status", 1);
		} catch (Exception e) {
			resultMap.put("status", 0);
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
	@DeleteMapping("/{no}")
	public Map<String, Object> delete(@PathVariable int no, @RequestBody(required = false) RepBoard repBoard) {
		Map<String, Object> resultMap = new HashMap();
		log.info("no : " + no);
		log.info("repBoard : " + repBoard);
		repBoard.setBoardNo(no);
		try {
			service.Delete(repBoard);
			resultMap.put("status", 1);
		} catch (Exception e) {
			resultMap.put("status", 0);
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
}
