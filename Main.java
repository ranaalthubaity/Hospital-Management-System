/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HospitalManagementSystem;

// ============================================================
//  STUDENT INFORMATION  --  replace the values below
// ============================================================
//  Do NOT change the variable names — only change the values.
// ============================================================

import java.io.*;
import java.util.Scanner;

/**
 * Main class for the Hospital Management System.
 * Reads commands from input.txt and writes output to output.txt.
 *
 * DO NOT MODIFY THIS FILE (except for your Student ID and Name above).
 */
public class Main {

    static final String STUDENT_ID = "2507330";
    static final String STUDENT_NAME = "Rana";

    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();

        try {
            File        inputFile    = new File("input.txt");
            Scanner     scanner      = new Scanner(inputFile);
            FileWriter  outputWriter = new FileWriter("output.txt");
            PrintWriter writer       = new PrintWriter(outputWriter);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String result = processCommand(system, line);
                writer.println(result);
            }

            scanner.close();
            writer.close();
            System.out.println("Processing complete. Check output.txt for results.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error writing to output.txt");
            e.printStackTrace();
        }
    }

    /**
     * Processes a single command from the input file.
     */
    private static String processCommand(HospitalSystem system, String command) {
        String[] parts  = command.split(",");
        String   action = parts[0].trim();

        try {
            switch (action) {

                case "addDoctor":
                    return system.addDoctor(
                            parts[1].trim(),
                            parts[2].trim(),
                            Double.parseDouble(parts[3].trim()),
                            parts[4].trim(),
                            Integer.parseInt(parts[5].trim()));

                case "addNurse":
                    return system.addNurse(
                            parts[1].trim(),
                            parts[2].trim(),
                            Double.parseDouble(parts[3].trim()),
                            parts[4].trim(),
                            parts[5].trim());

                case "addSurgeon":
                    return system.addSurgeon(
                            parts[1].trim(),
                            parts[2].trim(),
                            Double.parseDouble(parts[3].trim()),
                            parts[4].trim(),
                            Integer.parseInt(parts[5].trim()));

                case "addPatient":
                    return system.addPatient(
                            parts[1].trim(),
                            parts[2].trim(),
                            Integer.parseInt(parts[3].trim()),
                            parts[4].trim());

                case "assignStaff":
                    return system.assignStaff(
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim());

                case "prescribe":
                    return system.prescribe(
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim());

                case "scheduleOperation":
                    return system.scheduleOperation(
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim());

                case "completeOperation":
                    return system.completeOperation(
                            parts[1].trim(),
                            parts[2].trim());

                case "printAllStaff":
                    return system.printAllStaff();

                case "printAllPatients":
                    return system.printAllPatients();

                case "printPatientRecords":
                    return system.printPatientRecords(parts[1].trim());

                default:
                    return "Error: Unknown command '" + action + "'";
            }
        } catch (Exception e) {
            return "Error processing command: " + command + " - " + e.getMessage();
        }
    }

        
        
        
    }
    

