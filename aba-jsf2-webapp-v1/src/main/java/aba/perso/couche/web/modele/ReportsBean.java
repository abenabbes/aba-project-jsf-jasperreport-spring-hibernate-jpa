/**
 * 
 */
package aba.perso.couche.web.modele;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import aba.perso.couche.report.AbstractReportBean;

/**
 * @author ali
 *
 */
@ManagedBean(name = "reportsBean")
@SessionScoped
public class ReportsBean extends AbstractReportBean {

	private final String COMPILE_FILE_NAME = "productlist";
	
	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}
	
	@Override
    protected Map<String, Object> getReportParameters() {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
        reportParameters.put("rtitle", "Hello JasperReports");
        return reportParameters;
    }
	
	public String execute() {
        try {
            super.prepareReport();
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }
 
        return null;
    }

}
