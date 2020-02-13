/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Hotel;

import Business.Enterprise.Item;
import Business.Enterprise.Model;
import Business.Organization.ManagerOrganization;
import Business.Organization.StaffOrganization;
import Business.Role.Role;
import Business.WorkQueue.WorkRequest;
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
public class Hotel extends Model{
    private roomtype type;
    private int photoId;
    private String id;
    private static int counter=0;
    private String photoPath;
    
        public enum roomtype{
        DoubleRoom("double room"),kingRoom("king room"),
        FamilyRoom("family room"),
        QueenRoom("queen room");
        
        private String value;

        private roomtype(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    public Hotel(String name, String address, String phonenumber) {
        super(name, address, phonenumber);
        this.photoId=counter;
        counter++;
        this.id="hotel"+counter;
        this.setType(EnterpriseType.Hotel);

        String path = "Images/Hotel/default.png";
        String fileName = "default.png";

        File f = new File("Images/Hotel");
        if (f.isDirectory()) {
            File[] F1 = f.listFiles();
            for (File f2 : F1) {
                if (f2.getName().equalsIgnoreCase(this.photoId + ".png")) {
                    fileName = this.photoId + ".png";
                    path = "Images/Hotel/" + fileName;
                }
            }
        }
        this.photoPath = path;
    }

    public int getPhotoid() {
        return photoId;
    }
    public roomtype getRoomtype(){
        return this.type;  
    }

    


    public void setPhotoId(int photoId) {
        this.photoId = photoId;
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
            newPath = "Images/Hotel/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {

        }
        this.photoPath = newPath;
    }

    public String getPhotopath() {
        return photoPath;
    }
    public void addRoom(Room room){
        this.getItemlist().add(room);
    }
    public ArrayList<Room> getRoomList(){
        ArrayList<Room> ans=new ArrayList<>();
        for(Item r:this.getItemlist()){
            Room t=(Room)r;
            ans.add(t);
        }
        return ans;
    }

    @Override
    public EnterpriseType getType() {
        return EnterpriseType.Hotel;
    }


    public roomtype getCategory() {
        return this.type;
    }

    public void setCategory(roomtype type) {
        this.type = type;
    }
    @Override
    public String getCategoryString() {
        if(this.type!=null){
            return this.type.name();
        }
        return "";
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
//        this.getOrganizationDirectory().getOrganizationList().add(new StaffOrganization());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
