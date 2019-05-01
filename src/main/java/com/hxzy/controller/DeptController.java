package com.hxzy.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxzy.entity.Dept;
import com.hxzy.service.DeptService;

import net.sf.json.JSONObject;

@RestController
public class DeptController {

	private DeptService deptService;

	@Resource(name = "deptServiceImpl")
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@GetMapping("/dept")
	public String getDepts(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		// page是一个对象，不是一个数组，所以返回使用JSONAobject，不能使用JSONArray
		Page<Dept> depts = deptService.fy(page - 1, limit);
		JSONObject obj = JSONObject.fromObject(depts);
		System.out.println(obj.toString());
		return obj.toString();
	}

	@PostMapping("/adddept")
	public String addDept(@ModelAttribute Dept dept) {
		Dept temp = null;
		try {
			temp = deptService.addDept(dept);
			if (temp != null) {
				return "Y";
			} else {
				return "N";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
	}

	@PostMapping("/updatedept")
	public String updateDept(@ModelAttribute Dept dept) {
		try {
			deptService.updateDept(dept);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}

	@PostMapping("/deldept")
	public String deleteDept(@ModelAttribute Dept dept) {
		try {
			deptService.delDept(dept);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "N";
		}
		return "Y";
	}

	@GetMapping("/deptexcel")
	public void Excel(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		List<Dept> depts = deptService.getDeptList();
		// 创建一个工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建一个工作区
		HSSFSheet sheet = wb.createSheet("部门表");
		// 创建第一行
		HSSFRow rootRow = sheet.createRow(0);
		// 创建列
		rootRow.createCell(0).setCellValue("部门名称");
		rootRow.createCell(1).setCellValue("部门编号");
		rootRow.createCell(2).setCellValue("部门描述");
		rootRow.createCell(3).setCellValue("部门状态");
		rootRow.createCell(4).setCellValue("创建时间");
		rootRow.createCell(5).setCellValue("创建者");
		rootRow.createCell(6).setCellValue("修改时间");
		rootRow.createCell(7).setCellValue("修改者");
		for (int i = 0; i < depts.size(); i++) {
			Dept d = depts.get(i);
			HSSFRow dataRow = sheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(d.getDname());
			dataRow.createCell(1).setCellValue(d.getDeptno());
			dataRow.createCell(2).setCellValue(d.getDdescription());
			dataRow.createCell(3).setCellValue(d.getDstate());
			dataRow.createCell(4).setCellValue(d.getDtime());
			dataRow.createCell(5).setCellValue(d.getDceater());
			dataRow.createCell(6).setCellValue(d.getDchangetime());
			dataRow.createCell(7).setCellValue(d.getDchanger());
		}
		SimpleDateFormat newsdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String date = newsdf.format(new Date());
		response.reset();
		response.setContentType("application/msexcel;charset=UTF-8");

		OutputStream out = null;
		try {
			String filename = "部门表"+date+".xls";
			String userAgent = request.getHeader("USER-AGENT");//获取浏览器版本
			if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器  
				filename = URLEncoder.encode(filename,"UTF8");  
	         }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器  
	        	 filename = new String(filename.getBytes(), "ISO8859-1");  
	         }else{  
	        	 filename = URLEncoder.encode(filename,"UTF8");//其他浏览器  
	         } 
			System.out.println(date);
			System.out.println(filename);
			response.reset();//清空输出流 
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+filename);
    		out = response.getOutputStream();
			wb.write(out);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
