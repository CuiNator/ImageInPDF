import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.IOException;

public class InsertImagePDF {
    public static void main(String args[]) throws Exception {

        //Loading an existing document
        File file = new File("F:/IntelliJProjects/New.pdf");
        PDDocument doc = PDDocument.load(file);

        //Retrieving the page
        PDPage page = doc.getPage(0);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("F:/IntelliJProjects/Smiley.png", doc);
        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page, true, true);

        //Drawing the image in the PDF document (Image, X, Y, Width, Height)
        contents.drawImage(pdImage, 55, 370, 300, 300);
        System.out.println("Image inserted");

        //Closing the PDPageContentStream object
        contents.close();

        //Saving the document
        doc.save("F:/IntelliJProjects/NEW2.pdf");

        //Closing the document
        doc.close();
    }
}