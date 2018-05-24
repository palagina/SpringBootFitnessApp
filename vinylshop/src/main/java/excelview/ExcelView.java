package excelview;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import vinylshop.domain.Disk;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


	public class ExcelView extends AbstractXlsView {

	    @Override
	    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
	                                      HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	    	

	        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");
	    	
	    	@SuppressWarnings("unchecked")
	        List<Disk> disks = (List<Disk>) model.get("disks");
	        Sheet sheet = workbook.createSheet("Disks");
	        sheet.setFitToPage(true);

	        int rowCount = 0;
	        Row header = sheet.createRow(rowCount++);
	        header.createCell(0).setCellValue("Name");
	        header.createCell(1).setCellValue("Author");
	        header.createCell(2).setCellValue("Year");
	        header.createCell(3).setCellValue("Code");
	        header.createCell(4).setCellValue("Price");

	        for (Disk disk : disks) {
	            Row diskRow = sheet.createRow(rowCount++);
	            diskRow.createCell(0).setCellValue(disk.getName());
	            diskRow.createCell(1).setCellValue(disk.getAuthor());
	            diskRow.createCell(2).setCellValue(disk.getYear());
	            diskRow.createCell(3).setCellValue(disk.getCode());
	            diskRow.createCell(4).setCellValue(disk.getPrice());
	        }
	        
	    }
	}