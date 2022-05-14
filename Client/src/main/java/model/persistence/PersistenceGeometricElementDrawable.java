package model.persistence;

import model.geometryutils.Drawing;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class PersistenceGeometricElementDrawable {


    public PersistenceGeometricElementDrawable() {
    }

    public void saveElementToXML(Drawing drawing, String filePath) {
        try {
            File file = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream);
            XMLEncoder encoder = new XMLEncoder(buffer);
            encoder.writeObject(drawing);
            encoder.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Could not create file");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Could not close file");
        }

    }

    public Drawing loadElementFromXML(String filePah) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePah);
        BufferedInputStream buffer = new BufferedInputStream(fileInputStream);
        XMLDecoder decoder = new XMLDecoder(buffer);
        Drawing drawing = (Drawing) decoder.readObject();
        decoder.close();
        fileInputStream.close();
        return drawing;

    }

}
