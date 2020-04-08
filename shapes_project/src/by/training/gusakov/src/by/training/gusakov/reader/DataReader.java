package by.training.gusakov.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import by.training.gusakov.exception.DataReaderException;

public class DataReader {

    public List<String> readDataPoint(String filePath) throws DataReaderException {
        List<String> lines;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new DataReaderException("Error: cannot read file.", e);
        }
        return lines;
    }

}
