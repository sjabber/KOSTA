package com.day.control;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
/*
 * 뭐가 뭔지 모르겠습니다. 너무 많아서. 네. 전부 json형태로 응답하도록 되어있다. 다양하게 요청방식을 사용할 수 있다.
 * 
 * @Controller
 * 
 * @ResponseBody
 * 
 * Restful용 요청방식 종류 GET - 데이터를 검색하는 용도, 검색 POST - 데이터를 추가하는 용도, 추가 PUT - 데이터를
 * 수정하는 용도, 수정 DELETE - 데이터를 삭제하는 용도, 삭제
 */

@RequestMapping("/board/*")
public class RestController {
	private Logger log = Logger.getLogger(RestController.class);

	//@PostMapping("/board")
	@PostMapping("/write")
	public Map<String, Object> write(@RequestBody // 요청전달 데이터가 application/json 타입으로 전달됨.
	Map<String, String> map) {
		log.error("/board 추가시작");
		log.error("map:" + map);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", 1);
		result.put("msg", "게시글 추가 성공");
		return result;
	}
	
//	@PostMapping(value="/board/reply/{no}",
//			produces = {org.springframework.http.MediaType.TEXT_PLAIN_VALUE}) //응답형식
//	public ResponseEntity reply(@PathVariable int no, @RequestBody Map<String, String> map) {
//		
//		// service ~> dao
//		ResponseEntity<String> responseEntity =
//				//new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
//				new ResponseEntity<>("답글쓰기 실패", HttpStatus.BAD_GATEWAY); // 실패
//		log.error(responseEntity.getBody());
//		return responseEntity;
//	}
	
	//@PostMapping(value = "/board/reply/{no}") // 응답형식
	@PostMapping(value = "/reply/{no}")
	public ResponseEntity<Map<String, Object>> reply(@PathVariable int no, @RequestBody Map<String, String> map) {
		Map<String, Object> result = new HashMap<>();
		result.put("msg", "답글쓰기 실패");

		ResponseEntity<Map<String, Object>> responseEntity =
				new ResponseEntity<>(result, HttpStatus.OK);
		log.error(responseEntity.getBody());
		return responseEntity;
	}

	// @GetMapping("/board/list")
	// public List<Map<String, Object>> list() {

//	@GetMapping(value = { "/board/list", "/board/list/{word}" })
	@GetMapping(value = { "/list", "/list/{word}" })
	// public List<Map<String, Object>> list(@PathVariable(required = false) String
	// word) {
	public List<Map<String, Object>> list(@PathVariable(name = "word") Optional<String> optWord) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		String word = null;
		if (optWord.isPresent()) { // if(word != null){} (x)
			Map<String, Object> result = new HashMap();
			word = optWord.get();
			log.error("/board 단어검색 시작: word=" + word);
			result.put("no", 1);
			result.put("title", "제목1");
			result.put("content", "내용1");
			resultList.add(result);

			result = new HashMap();
			result.put("no", 2);
			result.put("title", "제목2");
			result.put("content", "내용2");
			resultList.add(result);

		} else {
			Map<String, Object> result = new HashMap();
			log.error("/board 전체검색 시작");
			result.put("no", 1);
			result.put("title", "제목1");
			result.put("content", "내용1");
			resultList.add(result);

			result = new HashMap();
			result.put("no", 2);
			result.put("title", "제목2");
			result.put("content", "내용2");
			resultList.add(result);

			result = new HashMap();
			result.put("no", 3);
			result.put("title", "제목3");
			result.put("content", "내용3");
			resultList.add(result);
		}

		log.error("/board 검색 시작: word=" + word);

		return resultList;
	}
	// http://localhost:8888/restspring/board?board_no=123
	// public void info(@RequestParam(name="no", required=false,
	// defaultValue="0")int board no){ }

	//@GetMapping("/board/{no}") // http://localhost:8888/restspring/board/123
								// http://localhost:8888/restspring/board/1
	@GetMapping("/{no}")
	public Map<String, Object> info(@PathVariable int no) {
		// service~>dao
		Map<String, Object> result = new HashMap();
		result.put("no", no);
		result.put("title", "제목1");
		result.put("content", "내용1");
		return result;
	}

	//@PutMapping("/board/{no}")
	/*
	 * public void modify(@PathVariable int no,
	 * 
	 * @RequestBody Map<String, String>map) { log.error(map); }
	 */
	@PutMapping("/{no}")
	public ResponseEntity<String> modify(@PathVariable int no, @RequestBody Map<String, String> map) {
		log.error(map);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		// HttpStatus.INTERNAL_SERVER_ERROR => 500에러
		return responseEntity;
	}

	//@DeleteMapping("/board/{no}")
	@DeleteMapping("/{no}")
	public ResponseEntity<String> remove(@PathVariable int no) {
		// service~>dao
		ResponseEntity<String> responseEntity =
				// new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //실패
				new ResponseEntity<>("답글쓰기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		log.error(responseEntity.getBody());
		return responseEntity;
	}

}
