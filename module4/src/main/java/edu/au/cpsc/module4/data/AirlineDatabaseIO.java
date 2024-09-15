package edu.au.cpsc.module4.data;

import java.io.*;

public class AirlineDatabaseIO {

    public static void save(AirlineDatabase ad, OutputStream strm) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(ad);
    }

    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (AirlineDatabase) ois.readObject();

    }


}
