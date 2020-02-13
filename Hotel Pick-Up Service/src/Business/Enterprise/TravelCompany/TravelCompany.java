/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.TravelCompany;

import Business.Enterprise.Model;
import Business.Organization.ManagerOrganization;
import Business.Organization.StaffOrganization;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author quanhaonan
 */
public class TravelCompany extends Model{

    
    private String phonenumber;
    private static int counter=0;
    private int photoId;
    private String photoPath;
    private String id;
    private String description;
    //private WorkQueue wq;
    public TravelCompany(String name, String phonenumber,String address) {
        super(name,address, phonenumber);
        this.phonenumber=phonenumber;
        this.id=counter+"";
        counter++;
       // this.wq=new WorkQueue();
        String path = "Images/Payment/avis.png";
        String fileName = "avis.png";

        File f = new File("Images/TravelCompany");
        if (f.isDirectory()) {
            File[] F1 = f.listFiles();
            for (File f2 : F1) {
                if (f2.getName().equalsIgnoreCase(this.photoId + ".png")) {
                    fileName = this.photoId + ".png";
                    path = "Images/TravelCompany/" + fileName;
                }
            }
        }
        this.photoPath = path;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public static int getCount() {
        return counter;
    }

    public static void setCount(int counter) {
        TravelCompany.counter = counter;
    }

    public void setPhotoPath(String photoPath) {
                String newPath = "";
        try {
            BufferedImage image = ImageIO.read(new File(photoPath));

            int radio = 0;
            if (image.getWidth() / 250 < image.getHeight() / 180) {
                radio = image.getWidth() / 250;
            } else {
                radio = image.getHeight() / 180;
            }
            int x = 0, y = 0, cutW = 250 * radio, cutH = 180 * radio;

            Rectangle rect = new Rectangle(x, y, cutW, cutH);
            BufferedImage areaImage = image.getSubimage(rect.x, rect.y, rect.width, rect.height);

            BufferedImage buffImg = new BufferedImage(cutW, cutH, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(areaImage.getScaledInstance(cutW, cutH, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            String fileName = this.photoId + ".png";
            newPath = "Images/TravelCompany/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {
            
        }
        this.photoPath = newPath;
    }

    @Override
    public EnterpriseType getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCategoryString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public String getId() {
        return this.id;
        
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    @Override
    public void creatOrganization() {
         this.getOrganizationDirectory().getOrganizationList().add(new ManagerOrganization());
        this.getOrganizationDirectory().getOrganizationList().add(new StaffOrganization());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
