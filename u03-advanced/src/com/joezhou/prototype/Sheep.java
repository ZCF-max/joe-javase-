package com.joezhou.prototype;

import java.io.*;
import java.util.Date;

/**
 * @author JoeZhou
 */
class Sheep implements Cloneable, Serializable {
    String name;
    Date birth;

    Sheep shallowClone(Sheep sheep) {
        Sheep result = null;
        try {
            result = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    Sheep multipleShallowClone(Sheep sheep) {
        Sheep result = null;
        try {
            result = (Sheep) super.clone();
            result.birth = (Date) result.birth.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    Sheep deepClone(Sheep sheep) {
        Sheep result = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(sheep);
            oos.flush();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            result = (Sheep) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}