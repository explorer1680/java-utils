package roulette.resultsequence;

import org.springframework.core.io.ClassPathResource;
import personal.stacktrace.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceReader {

    private String sequenceFile;

    public SequenceReader(String sequenceFile){
        this.sequenceFile = sequenceFile;
    }

    public Stream<RedBlack> readSequenceFile() throws IOException {
        InputStream in = getClass().getResourceAsStream("/roulette/" + this.sequenceFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String result = bufferedReader.lines().collect(Collectors.joining("\n"));
        String[] array = result.split("[\\s,]+");
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        System.out.println("total number of bets: " + list.size());
        return list.stream().map(s -> RedBlackMapper.map(s));
    }

    public static void main(String[] args) throws IOException {
        SequenceReader sequenceReader = new SequenceReader("2024-01-20.txt");
        sequenceReader.readSequenceFile();
    }
}
