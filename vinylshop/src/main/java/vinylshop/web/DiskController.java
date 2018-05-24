package vinylshop.web;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vinylshop.domain.CategoryRepository;
import vinylshop.domain.DiskRepository;
import vinylshop.domain.Disk;

@Controller
public class DiskController {
	
	@Autowired
	private DiskRepository diskrepository;

	@Autowired
	private CategoryRepository catrepository; 
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    
	@RequestMapping ("/diskpage")
	public String diskPage(Model model) {
		model.addAttribute ("disks", diskrepository.findAll());
		return "diskpage";
	}
	
	//excel
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	 public @ResponseBody List<Disk> excel() {	
        return (List<Disk>) diskrepository.findAll();
   }  
	
	
	//list all
   @RequestMapping(value="/disks", method = RequestMethod.GET)
    public @ResponseBody List<Disk> diskpageRest() {	
        return (List<Disk>) diskrepository.findAll();
    }    

   //find by id
    @RequestMapping(value="/disk/{id}", method = RequestMethod.GET)
    public @ResponseBody Disk findDiskRest(@PathVariable("id") long id) {	
    	return diskrepository.findOne(id);
    }       

    //delete disk
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDisk(@PathVariable("id") long id, Model model) {
    	diskrepository.delete(id);
        return "redirect:../diskpage";
    } 
    
    //edit disk
    @RequestMapping(value = "/edit/{id}")
	public String editDisk(@PathVariable("id") long id, Model model){
    	model.addAttribute("disk", diskrepository.findOne(id));
    	model.addAttribute("categories", catrepository.findAll());
	return "editdisk";
	}
    
    // add new disk
    @RequestMapping(value = "/add")
    public String addDisk(Model model){
    	model.addAttribute("disk", new Disk());
    	model.addAttribute("categories", catrepository.findAll());
        return "adddisk";
    }     
 
    //save added disk
    @RequestMapping(value = "/saveadded", method = RequestMethod.POST)
    public String saveadded(@Valid Disk disk, BindingResult bindingResult){
    	 if (bindingResult.hasErrors()) {
             return "/adddisk";
         }
    	diskrepository.save(disk);
        return "redirect:diskpage";
    }     

    //save editted disk
    @RequestMapping(value = "/saveeditted", method = RequestMethod.POST)
    public String saveeditted(@Valid Disk disk, BindingResult bindingResult){
    	 if (bindingResult.hasErrors()) {
             return "/editdisk";
         }
    	diskrepository.save(disk);
        return "redirect:diskpage";
    }   
}


