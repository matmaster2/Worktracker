package pl.novomatic;

import pl.novomatic.readers.IFileReader;
import pl.novomatic.readers.TaskReader;

public class TrackerMain {

    private IFileReader iFileReader;

    public TrackerMain(IFileReader iFileReader){
        this.iFileReader = iFileReader;
    }

    public void printObjectsInfo(){
        iFileReader.getObjectsFromFile().stream().forEach(x -> System.out.println(x.toString()));
    }

    public static void main(String[] args) {
        IFileReader bla = new TaskReader();
        TrackerMain trackerMain = new TrackerMain(bla);

        trackerMain.printObjectsInfo();
    }


}
