package com.hxzy.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hxzy.aop.SystemLogAn;
import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;


import net.sf.json.JSONObject;





@RestController
public class StationBasicController {
	@Resource(name="stationBasicServiceImpl")
	private StationBasicService stationBasicService;
	
	@GetMapping("/stationbasic")

	public String getStationBasics(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		Page<StationBasic> stations = stationBasicService.fy(page-1, limit);
		JSONObject obj = JSONObject.fromObject(stations);

		return obj.toString();	
	}
	
	@SystemLogAn(value="添加站点")
	@PostMapping("/station")
	public String addStationBasic(@ModelAttribute StationBasic stationBasic,@RequestParam("upFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getSession().getServletContext().getRealPath("");
		path = path+"public\\image\\station\\";
		SimpleDateFormat newsdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = newsdf.format(new Date());
		String upname = file.getOriginalFilename();
		String newPath = path+date+upname.substring(upname.lastIndexOf("."));
		System.out.println(newPath);
		File newFile = new File(newPath);
		if(!newFile.exists()) {
			try {
				newFile.createNewFile();
				file.transferTo(newFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "{success:false,msg:'N'}";
			}
		}
		String url = date+upname.substring(upname.lastIndexOf("."));
		stationBasic.setStation_pictureurl(url);
		StationBasic save = stationBasicService.addStationBasic(stationBasic);
		if(save == null) {
		
			 return "{success:false,msg:'N'}";
		}
		
		 return "{success:true,msg:'Y'}";
	}
	
	@SystemLogAn(value="删除站点")
	@DeleteMapping("station")
	public String delStationBasic(@ModelAttribute StationBasic stationBasic,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("");
		path = path+"public\\image\\station\\"+stationBasic.getStation_pictureurl();
		try {
			stationBasicService.delStationBasic(stationBasic);
			File file = new File(path);
			if(file.delete()) {
				return "Y";
			}else {
				return "N";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
	}
	
	@SystemLogAn(value="更新站点")
	@PutMapping("/station")
	public String updateStationBasic(@ModelAttribute StationBasic stationBasic) {
		StationBasic save = stationBasicService.addStationBasic(stationBasic);
		if(save == null) {
			return "N";
		}
		return "Y";
		
	}
	
}

