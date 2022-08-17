import com.fileutility.util.CompareFileUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.fileutiliy.dto.Compare;
@MultipartConfig
public class CompareServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "D:\\FileUtilityData\\compare";
   protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                String name1 = new File(multiparts.get(0).getName()).getName();
                File file1 = new File(UPLOAD_DIRECTORY + File.separator + name1);
                multiparts.get(0).write(file1);
                String name2 = new File(multiparts.get(1).getName()).getName();
                File file2 = new File(UPLOAD_DIRECTORY + File.separator + name2);
                multiparts.get(1).write(file2);
                
                List<Compare> compareList = CompareFileUtil.compare(file1, file2);
                request.setAttribute("compareList", compareList);
                
                request.setAttribute("file1Name", file1.getName());
                request.setAttribute("file2Name", file2.getName());
                // File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }
        request.getRequestDispatcher("/compare.jsp").forward(request, response);
    }
}
