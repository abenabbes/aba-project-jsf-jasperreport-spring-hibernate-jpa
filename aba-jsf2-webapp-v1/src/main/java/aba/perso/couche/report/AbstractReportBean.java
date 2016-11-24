/**
 * 
 */
package aba.perso.couche.report;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;

/**
 * <p>AbstractReportBean is an abstract java class,
 * containing the prepareReport() method and abstract methods.</p>
 * 
 * @author ali
 *
 */
public abstract class AbstractReportBean {

	/**
	 * Enumertion de type de rapport a generer.
	 * @author ali
	 *
	 */
	public enum ExportOption {
        PDF, HTML, EXCEL, RTF
    }
	
	/** Instance de l'enum*/
	private ExportOption exportOption;
	/** Resource*/
    private final String COMPILE_DIR = "/report/design/";
    //private String compileFileName = "productlist";//name of your compiled report file
    private String message;
 
    /**
     * Constructor.
     */
    public AbstractReportBean() {
        super();
        setExportOption(ExportOption.PDF);
    }

    //________METHODES
    
    /**
     * 
     * @throws JRException
     * @throws IOException
     */
    protected void prepareReport() throws JRException, IOException {
       
    	// externalContext
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
 
    	//context
        ServletContext context = (ServletContext) externalContext.getContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
 
        //Compilation du rapport
        ReportConfigUtil.compileReport(context, getCompileDir(), getCompileFileName());
 
        //Recuperation de fichier .jrxml
        File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), getCompileFileName() + ".jasper"));
 
        ///////////////////
        Connection conn = null;
        try {
//            conn = Database.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        /////////////////////
 
        // Generation de fichier .jasper
        JasperPrint jasperPrint = ReportConfigUtil.fillReport(reportFile, getReportParameters(), conn);
 
        // Rapport HTML
        if (getExportOption().equals(ExportOption.HTML)) {
            ReportConfigUtil.exportReportAsHtml(jasperPrint, response.getWriter());
        
        // Rapport EXCEL
        } else if (getExportOption().equals(ExportOption.EXCEL)) {
            ReportConfigUtil.exportReportAsExcel(jasperPrint, response.getWriter());
        
        // Rapport RTF
        } else {
            request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
            response.sendRedirect(request.getContextPath() + "/servlets/report/" + getExportOption());
        }
 
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    //____GETTER && SETTER
    public ExportOption getExportOption() {
        return exportOption;
    }
 
    public void setExportOption(ExportOption exportOption) {
        this.exportOption = exportOption;
    }
 
    protected Map<String, Object> getReportParameters() {
        return new HashMap<String, Object>();
    }
 
    protected String getCompileDir() {
        return COMPILE_DIR;
    }
 
    protected abstract String getCompileFileName();
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}
