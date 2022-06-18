package com.tpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;


@Controller  // @controller ile annote edilmiş sınıflar aynı zamanda component olmuş oluyor
@RequestMapping("/students")  // aşağıdaki ser metodun önünde RequestMapping annotationı eklememek
			// için buraya ekleniyor. bu sayede metaodlara sadece @GetMapping yazmamız yeterli oluyor. 
			// parametre olarak girilen "/students" ise base path dir
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// @RequestMapping("/welcome") // gelen requesti, mappliyor, welcome ile gelirse aşağıdaki methoda mapliyor
	@GetMapping("/welcome")  // --> path yolu "/students/welcome" oldu
	@ResponseBody
	public String welcome() {
		
		return "Welcome Student Controller";
		
	}
	
	
	// @RequestMapping(value ="/students", method = RequestMethod.GET)
	@GetMapping  // burası zaten base path olduğu için ekstra parametreye gerek kalmadı
	public ModelAndView getStudents() {    //   bu metod gelen "requesti" işleyip bir "modelAndView" objesi oluşturuyor ve 
										//buda "view Resolver" sayesinde render edilip "response" olarak dönüyor
		List<Student> list = studentService.getAll();
		ModelAndView mav = new ModelAndView();		
		mav.addObject("students", list );     // addObject ---> aldığı parametreler :  Döndürmek istediğim datanın ismi ve kendisi 
		mav.setViewName("students"); // jsp nin ismini bu resolve decek
		return mav; // mav değeri ( ModelAndView objesi) döndürüldükten sonra Spring viewresolvera gider ve hangi view i resolver 
			// edeceğini setViewName metoda set edilen "student" ifadesi ile biliyor. ilgili view bulunup render edilip kullanıcıya dönülüyor
			// 
				
		
	}
	
	@GetMapping("/new")  // AŞAĞIDAKİ METODDA DA PATH OLARAK "NEW" YAZILMIŞ, ÇAKIŞMAMASININ SEBEBI BİRİ GET DİĞERİ 
						//POST İÇİN KULLANILIYOR OLMASI
    public String newStudent(@ModelAttribute("student") Student student) {
        return "newStudent"; // KULLANICIYA NEWsTUDENT.JSP sayfanın dönüleceği belirtiliyor, bu dosyada webapp/WEB_INF/jsp  
        					//nin altında oluşturduk
    } 
	
	@PostMapping("/new")
	    public String createStudent(@ModelAttribute Student student) {
	        studentService.createStudent(student);
	        return "redirect:/students";
	    }
	    
	    
	    @GetMapping("/update/{id}")
	    public String getStudent(@PathVariable Long id, ModelMap modelMap) {  
	    	// @PathVariable ---> gelen path den bir değişken almak istiyorsak kullanılır : 
	    	// www.google.com/?1  --> buradaki 1 i almak istiyorsak gibi.
	        Student student= studentService.findStudent(id);
	        modelMap.put("student", student);
	        return "updateStudent";
	    } 
	    
	    
	    @PostMapping("/update/{id}")
	    public String updateStudent(@ModelAttribute Student student) {
	        studentService.updateStudent(student);
	        return "redirect:/students";
	    }
	    
	    
	    @GetMapping("/delete/{id}")
	    public String getStudentForDelete(@PathVariable Long id, ModelMap modelMap) {
	        Student student= studentService.findStudent(id);
	        modelMap.put("student", student);
	        return "deleteStudent";
	    } 
	    
	    
	    @PostMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	        return "redirect:/students";
	    }
	
	

}
