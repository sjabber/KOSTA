package com.day.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.day.dto.RepBoard;
import com.day.dto.RepBoardFile;

import net.coobird.thumbnailator.Thumbnailator;

@RestController
public class UploadController {
	@Autowired
	private ServletContext servletContext;

	private Logger log = Logger.getLogger(UploadController.class);

	@PostMapping("/uploadajax")
	public void ajax(@RequestPart List<MultipartFile> foodFiles, @RequestPart MultipartFile drinkFile
//			,String boardTitle
//			,String boardContent
			, RepBoard repBoard) {

		log.info("요청전달데이터 title=" + repBoard.getBoardTitle() + ", content=" + repBoard.getBoardContent());
		log.info("요청전달 데이터 =" + repBoard.getBoardC().getId());
		log.info("foodFiles.size()=" + foodFiles.size());
		log.info("drinkFile.getSize()=" + drinkFile.getSize());

		String uploadPath = servletContext.getRealPath("upload");
		log.info("업로드 실제경로:" + uploadPath);

		// 경로생성
		if (!new File(uploadPath).exists()) {
			log.info("업로드 실제경로 생성");
			new File(uploadPath).mkdirs();
		}

		if (foodFiles != null) {
			for (MultipartFile foodFile : foodFiles) {

				String foodFileName = foodFile.getOriginalFilename();

				if (!"".equals(foodFileName) && foodFile.getSize() != 0) {
					System.out.println(
							"foodfile 파일크기: " + foodFile.getSize() + ", 파일이름: " + foodFile.getOriginalFilename());

					String fileName = UUID.randomUUID() + "_" + foodFileName;
					File file = new File(uploadPath, fileName);// 파일생성
					try {
						FileCopyUtils.copy(foodFile.getBytes(), file); // foodFile 파일내용을 복사해여 file에 붙여넣기
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// getOriginalFilename => 전달된 파일의 원래 이름을 알려준다. 해당 정보가 없으면 null로 표시.
				System.out.println("파일크기 : " + foodFile.getSize() + ", 파일이름: " + foodFile.getOriginalFilename());
			}
		}

		// TODO : drinkFile 실제경로에 저장하기
		String drinkFileName = drinkFile.getOriginalFilename();
		if (!"".equals(drinkFileName) && drinkFile.getSize() != 0) {
			log.info("drinkfile 파일크기: " + drinkFile.getSize() + ", 파일이름:" + drinkFileName);
			// String fileName = "id1_" + drinkFileName;
			// Universal Unique Identifier
			String fileName = UUID.randomUUID() + "_" + drinkFileName;
			File file = new File(uploadPath, fileName); // 파일생성
			try {
				FileCopyUtils.copy(drinkFile.getBytes(), file); // foodFile 파일내용을 복사해서 file에 붙여넣기
				log.info("파일 생성");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@PostMapping("/uploaddto")
	@ResponseBody
	public Map<String, String> dto(RepBoardFile repBoardFile) {
		Map<String, String> result = new HashMap<>();
		// ServletUriComponentsBuilder.fromCurrentContextPath().path("upload");
		// log.info(repBoardFile);
		log.info(repBoardFile.getRepBoard());
		log.info(repBoardFile.getProducts());
		log.info(repBoardFile.getFoodFiles());
		log.info(repBoardFile.getDrinkFile());
		log.info(repBoardFile);

		String uploadPath = servletContext.getRealPath("upload");
		log.info("업로드 실제경로:" + uploadPath);

		// 경로 생성
		if (!new File(uploadPath).exists()) {
			log.info("업로드 실제경로생성");
			new File(uploadPath).mkdirs();
		}

		List<MultipartFile> foodFiles = repBoardFile.getFoodFiles();
		if (foodFiles != null) {
			for (MultipartFile food : foodFiles) {
				if (!"".equals(food.getOriginalFilename()) && food.getSize() != 0) {
					log.info("FOOD 파일이름:" + food.getOriginalFilename() + ", 크기:" + food.getSize());

					// Universal Unique Identifier
					String fileName = UUID.randomUUID() + "_" + food.getOriginalFilename();
					File target = new File(uploadPath, fileName);
					// 파일 생성
					try {
						FileCopyUtils.copy(food.getBytes(), target);
						log.info("파일 생성");

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}

		MultipartFile drinkFile = repBoardFile.getDrinkFile();
		if (drinkFile != null && !"".equals(drinkFile.getOriginalFilename()) && drinkFile.getSize() != 0) {
			log.info("DRINK 파일이름:" + drinkFile.getOriginalFilename() + ", 크기:" + drinkFile.getSize());

			// Universal Unique Identifier
			String fileName = UUID.randomUUID() + "_" + drinkFile.getOriginalFilename();
			File target = new File(uploadPath, fileName);
			// 파일 생성
			try {
				FileCopyUtils.copy(drinkFile.getBytes(), target);
				log.info("파일 생성");

				// 이미지파일인 경우 섬네일파일을 만듦
				String contentType = drinkFile.getContentType(); // 파일형식
				log.info("DRINK 파일형식:" + contentType);

				if (contentType.startsWith("image")) { // 이미지파일인 경우
					String thumbnailName = "s_" + fileName; // s_파일이름
					File thumbnailFile = new File(uploadPath, thumbnailName);
					FileOutputStream thumbnail = new FileOutputStream(thumbnailFile);
					InputStream drinkFileIS = drinkFile.getInputStream();
					int width = 100;
					int height = 100;

					// 섬네일파일 만들기
					Thumbnailator.createThumbnail(drinkFileIS, thumbnail, width, height);

					result.put("drinkFileName", thumbnailName);
					return result;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
