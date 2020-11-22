package pl.novomatic.readers;

import pl.novomatic.models.IModel;

import java.util.ArrayList;

public interface IFileReader {

    String getFilePath();

    ArrayList<IModel> getObjectsFromFile();

}
