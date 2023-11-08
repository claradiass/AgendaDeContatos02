package main.java.br.edu.ifpb.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import main.java.br.edu.ifpb.domain.Contato;

public class FileDataService extends InMemoryDataService{
    public FileDataService() {
        File data = new File("data.bin");
        if (data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
                contatos = (List<Contato>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Contato c) {
        super.add(c);
        write();
    }

    @Override
    public void update(Contato c) {
        super.update(c);
        write();
    }

    @Override
    public void remove(Contato c) {
        super.remove(c);
        write();
    }

    private void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(getAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
