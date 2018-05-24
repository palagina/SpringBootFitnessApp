package excelview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vinylshop.domain.Disk;
import vinylshop.domain.DiskRepository;

@Controller

public class ExcelController {
	@Autowired
	private DiskRepository diskrepository;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(Model model) {
	    model.addAttribute("disks", diskrepository.findAll());
	    return "";
	}
	}