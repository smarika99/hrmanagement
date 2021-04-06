package com.nagarro.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.training.dto.EmployeeDto;

import com.nagarro.training.service.EmployeeManagementService;


@Controller
@SessionAttributes({ "employeeDtos", "employeeDto" })
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView resultGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<EmployeeDto> employeeDtos = employeeManagementService.getAllEmployees();
		mv.addObject("employeeDtos", employeeDtos);
		mv.setViewName("homepage");
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView uploadEmployeeGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		EmployeeDto employeeDto = new EmployeeDto(name, location, email, dob);
		employeeManagementService.addEmployee(employeeDto);
		List<EmployeeDto> employeeDtos = employeeManagementService.getAllEmployees();
		mv.addObject("employeeDtos", employeeDtos);
		mv.setViewName("homepage");
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployeeGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		long id = Long.parseLong(request.getParameter("id"));
		EmployeeDto employeeDto = employeeManagementService.getEmployee(id);
		mv.addObject("employeeDto", employeeDto);
		mv.setViewName("edit");
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		EmployeeDto employeeDto = new EmployeeDto(id, name, location, email, dob);
		employeeManagementService.updateEmployee(employeeDto);
		List<EmployeeDto> employeeDtos = employeeManagementService.getAllEmployees();
		mv.addObject("employeeDtos", employeeDtos);
		mv.setViewName("homepage");
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployeeGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		long id = Long.parseLong(request.getParameter("id"));
		employeeManagementService.deleteEmployee(id);
		List<EmployeeDto> employeeDtos = employeeManagementService.getAllEmployees();
		mv.addObject("employeeDtos", employeeDtos);
		mv.setViewName("homepage");
		return mv;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView downloadEmployees(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<EmployeeDto> employeeDtos = employeeManagementService.getAllEmployees();
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", "Employees.csv");
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter;

		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			String[] headers = { "Id", "Name", "Location", "Email", "Dob" };
			csvWriter.writeHeader(headers);
			for (EmployeeDto employeeDto : employeeDtos) {
				csvWriter.write(employeeDto, headers);
			}
			csvWriter.close();
		} catch (Exception e) {
		}
		mv.addObject("employeeDtos", employeeDtos);
		mv.setViewName("homepage");
		return mv;
	}
}
