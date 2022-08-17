import com.fileutility.util.MergeFileUtil;
import com.mysql.cj.util.StringUtils;
//import com.mysql.jdbc.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@MultipartConfig
public class MergeServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "D:\\FileUtilityData\\merge";

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getAttribute("comment");
        // process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                List<FileItem> sortedFileItems
                        = multiparts.stream()
                                .sorted(Comparator.comparing(FileItem::isFormField, Comparator.reverseOrder()))
                                .collect(Collectors.toList());
                Map<String, String> inputs = new HashMap();
                for (FileItem item : sortedFileItems) {

                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    if (item.isFormField()) {
                        inputs.put(item.getFieldName(), item.getString());
                    }

                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        File file = new File(UPLOAD_DIRECTORY + File.separator + name);
                        item.write(file);
                        String jfsFilePath = file.getAbsolutePath().replace(".zip", ".jfs");
                        MergeFileUtil.unzip(file.getAbsolutePath(), UPLOAD_DIRECTORY);

                        if (!StringUtils.isNullOrEmpty(inputs.get("comment"))) {
                            String cmtFile = file.getAbsolutePath().replace(".zip", ".cmt");
                            if (new File(cmtFile).exists()) {
                                Stream<String> stream = Files.lines(Paths.get(cmtFile));
                                StringBuffer commentTxt = new StringBuffer();

                                stream.forEach(line -> commentTxt.append(line));

                                request.setAttribute("commentTxt", commentTxt.toString());
                            } else {
                                request.setAttribute("commentTxtMessage", "Comment file dose not exist");
                                request.getRequestDispatcher("/merge.jsp").forward(request, response);
                            }
                            request.getRequestDispatcher("/merge.jsp").forward(request, response);
                        }
                        if (!StringUtils.isNullOrEmpty(inputs.get("details"))) {
                            File cmtFile = new File(file.getAbsolutePath().replace(".zip", ".cmt"));
                            File batFile = new File(file.getAbsolutePath().replace(".zip", ".bat"));
                            File jfsFile = new File(jfsFilePath);
                            Map<String, String> fileDetails = MergeFileUtil.getFileDetails(jfsFile, cmtFile.exists(), batFile.exists());
                            fileDetails.entrySet().forEach(entry -> {
                                request.setAttribute(entry.getKey(), entry.getValue());
                            });
                            request.getRequestDispatcher("/merge.jsp").forward(request, response);
                        }
                        File mergedFile = MergeFileUtil.merge(jfsFilePath, UPLOAD_DIRECTORY);

                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();

                        response.setContentType("APPLICATION/OCTET-STREAM");
                        response.setHeader("Content-Disposition", "attachment; filename=\"" + mergedFile.getName() + "\"");

                        FileInputStream fileInputStream = new FileInputStream(mergedFile);

                        int i;
                        while ((i = fileInputStream.read()) != -1) {
                            out.write(i);
                        }
                        fileInputStream.close();
                        out.close();
                    }
                }

                // File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/merge.jsp").forward(request, response);

    }

}
