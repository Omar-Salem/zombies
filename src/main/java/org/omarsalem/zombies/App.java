package org.omarsalem.zombies;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("no arguments supplied");
        }
        File file = new File(args[0]);
        String json = FileUtils.readFileToString(file, Charset.defaultCharset());
        final SimulationInput simulationInput = new ObjectMapper()
                .readValue(json, SimulationInput.class);
        Simulator simulator = new Simulator();
        final SimulationResult simulationResult = simulator.run(simulationInput);
        System.out.println(simulationResult);
    }
}
