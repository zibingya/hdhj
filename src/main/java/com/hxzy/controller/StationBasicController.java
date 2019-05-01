package com.hxzy.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hxzy.entity.StationBasic;
import com.hxzy.service.StationBasicService;

import net.sf.json.JSONObject;



@RestController
public class StationBasicController {
	private StationBasicService stationBasicService;

	@Resource(name="stationBasicServiceImpl")
	public void setStationBasicService(StationBasicService stationBasicService) {
		this.stationBasicService = stationBasicService;
	}
	
	@GetMapping("/stationbasic")
	public String getStationBasics(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		Page<StationBasic> stations = stationBasicService.fy(page-1, limit);
		JSONObject obj = JSONObject.fromObject(stations);
		System.out.println(obj.toString());
		return obj.toString();	
	}
	
	@PostMapping("/addstation")
	public String addStationBasic(@ModelAttribute StationBasic stationBasic,@RequestParam("upFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		String path = request.getSession().getServletContext().getRealPath("");
		path = path+"public\\image\\station\\";
		System.out.println(path);
		File localFile = new File(path);
		System.out.println(localFile);
		SimpleDateFormat newsdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = newsdf.format(new Date());
		String newPath = path+date+file.getOriginalFilename();
		File newFile = new File(newPath);
		System.out.println(newPath);
		if(!newFile.exists()) {
			try {
				newFile.createNewFile();
				file.transferTo(newFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "N";
			}
		}
		String url = date+file.getOriginalFilename();
		
		stationBasic.setStation_pictureurl(url);
		
		System.out.println(path);
		System.out.println("add提交了");
		System.out.println(stationBasic.getStation_name());
		StationBasic save = stationBasicService.addStationBasic(stationBasic);
		if(save == null) {
		
			 return "N";
		}
		
		 return "{success:true,msg:'ok'}";
	}
	
	@PostMapping("/delstation")//@RequestParam("station_name") String station_name
	public String delStationBasic(@ModelAttribute StationBasic stationBasic) {
		System.out.println("del提交了");
		System.out.println(stationBasic.getStation_name());
		stationBasicService.delStationBasic(stationBasic);
		return "Y";
	}
	
	@PostMapping("/updatestation")
	public String updateStationBasic(@ModelAttribute StationBasic stationBasic) {
		System.out.println("度"+stationBasic.getStation_latitude());
		StationBasic save = stationBasicService.addStationBasic(stationBasic);
		if(save == null) {
			return "N";
		}
		return "Y";
		
	}
}
