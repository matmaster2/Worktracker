package pl.novomatic.readers;

import pl.novomatic.models.IModel;

import java.util.List;

public interface IFileReader {

    List<IModel> dataFromFile();
}
