import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CodeLabelsResolverCmd {

    public static AuthorLabel authonelabel;
    public static AuthorLabel authtwoLabel;
    public static AuthorLabel resolvedLabel;
    public static ArrayList<AuthorLabel> authoneLabelsList= new ArrayList<>();
    public static ArrayList<AuthorLabel> authtwoLabelsList= new ArrayList<>();
    public static ArrayList<AuthorLabel> flatauthoneLabelsList= new ArrayList<>();
    public static ArrayList<AuthorLabel> flatauthtwoLabelsList= new ArrayList<>();
    public static ArrayList<AuthorLabel> resolvedLabelsList= new ArrayList<>();
    public static String pathofCodeSamples = "";
    public static String resolve_by_averages = "";



    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        //populate an arraylist of author1 labels and another list of author2 labels from two files

        pathofCodeSamples = args[0];
        String author1_json_path = args[1];
        String author2_json_path = args[2];
        resolve_by_averages = args[3];
        String outputCSVFile = args[4];


        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(author1_json_path);
        Object obj = jsonParser.parse(reader);
        JSONArray cloneCodeLabelsList = (JSONArray) obj;
        cloneCodeLabelsList.forEach( label -> parseCodeLabelObject( (JSONObject) label) );
        reader.close();

        
        reader = new FileReader(author2_json_path);
        obj = jsonParser.parse(reader);
        JSONArray othercloneCodeLabelsList = (JSONArray) obj;
        othercloneCodeLabelsList.forEach( label -> parseotherCodeLabelObject( (JSONObject) label) );

        System.out.println("Done populating the Author Label lists");

        //resolve by flattening chunks to lines for author1labels
        flatauthtwoLabelsList = unroll(authtwoLabelsList);
        flatauthoneLabelsList = unroll(authoneLabelsList);
        ArrayList<AuthorLabel> resolvedLabels = new ArrayList<>();

        //now resolve line labels
        //a line could have 0 more labels on either side
        //get all labels of a certain filename and certain linenumber of a certain author1
        //get all labels of a certain filename and certain linenumber of a certain author2
        String currentFileName = "";
        HashMap<String, HashSet<AuthorLabel>> author2filewiselabels = getFileWiseLabels(flatauthtwoLabelsList);
        HashMap<String, HashSet<AuthorLabel>> author1filewiselabels = getFileWiseLabels(flatauthoneLabelsList);

        for (Map.Entry<String, HashSet<AuthorLabel>> entry : author1filewiselabels.entrySet()) {
            String key = entry.getKey();
            //System.out.println("Key: " + key );
        }

        // Print the size of the HashMap outside the loop
        int hashMapSize = author1filewiselabels.size();
        System.out.println("Author 1 HashMap Size: " + hashMapSize);

        for (Map.Entry<String, HashSet<AuthorLabel>> entry : author2filewiselabels.entrySet()) {
            String key = entry.getKey();
            //System.out.println("Key: " + key );
        }

        // Print the size of the HashMap outside the loop
        int hashMapSize2 = author2filewiselabels.size();
        System.out.println("Author 2 HashMap Size: " + hashMapSize2);


        List<AuthorLabel> finalResolvedLabels = new ArrayList<>();
        //iterate over files
        for (String file : author1filewiselabels.keySet()) {
            HashSet<AuthorLabel> author1labelsforfile = author1filewiselabels.get(file);
            HashSet<AuthorLabel> author2labelsforfile = author2filewiselabels.get(file);
            if(author2labelsforfile==null)
                continue;
            //iterate over lines
            HashSet<Integer> LineNums = new HashSet<>();
            for(AuthorLabel label: author1labelsforfile)
            {
                LineNums.add(label.lineStart);
            }
            for(AuthorLabel label: author2labelsforfile)
            {
                LineNums.add(label.lineStart);
            }
            for(Integer i: LineNums)
            {
                HashSet<AuthorLabel> author1labelsforline = new HashSet<>();
                HashSet<AuthorLabel> author2labelsforline = new HashSet<>();
                for(AuthorLabel label: author1labelsforfile)
                {
                    if(label.lineStart==i)
                    {
                        author1labelsforline.add(label);
                    }
                }
                for(AuthorLabel label: author2labelsforfile)
                {
                    if(label.lineStart==i)
                    {
                        author2labelsforline.add(label);
                    }
                }
                if(author1labelsforline.size()==0 && author2labelsforline.size()>0)
                {
                    finalResolvedLabels.addAll(author2labelsforline);
                }
                else if (author2labelsforline.size()==0 && author1labelsforline.size()>0)
                {
                    finalResolvedLabels.addAll(author1labelsforline);
                }
                else {
                    List<AuthorLabel> resolved = resolveLabels(author1labelsforline, author2labelsforline);
                    finalResolvedLabels.addAll(resolved);
                }

            }


        }

        System.out.println("Resolved labels of two authors");
        
        String csvFilePath = outputCSVFile;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {

            // Writing header
            String[] header = {"FileName", "LineStart","LineEnd", "Code","CharStart","CharEnd","LabelValue"};
            csvWriter.writeNext(header);

            for(AuthorLabel label: finalResolvedLabels) {
                // Writing data rows
                csvWriter.writeNext(new String[]{label.fileName,
                        (String.valueOf(label.lineStart)),
                        String.valueOf(label.lineEnd),
                        label.codeSnippet,
                        String.valueOf(label.charStart),
                        String.valueOf(label.charEnd),
                        String.valueOf(label.statusNumber)
                });


            }
            System.out.println("Data has been written to CSV file.");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static HashMap<String, HashSet<AuthorLabel>> getFileWiseLabels(ArrayList<AuthorLabel> flatauthorLabelsList) {
        HashMap<String, HashSet<AuthorLabel>> author1filewiselabels = new HashMap<>();
        String currentFileName;
        for(AuthorLabel label_a: flatauthorLabelsList)
        {
            HashSet<AuthorLabel> author1filelabels = new HashSet<>();
            currentFileName = label_a.fileName;
            //check if filename exists or not
            if(!author1filewiselabels.containsKey(currentFileName))
            {
                author1filelabels.add(label_a);
                author1filewiselabels.put(currentFileName,author1filelabels);
            }
            else
            {
                HashSet<AuthorLabel> existinglabels = author1filewiselabels.get(currentFileName);
                existinglabels.add(label_a);

            }
        }
        return author1filewiselabels;
    }

    private static ArrayList<AuthorLabel> unroll(ArrayList<AuthorLabel> authorLabelsList) {
        ArrayList<AuthorLabel> result = new ArrayList<>();
        for(AuthorLabel label: authorLabelsList)
        {

            //iterate over each label and split a label with line start and line end
            if(label.lineStart != label.lineEnd)
            {
                String oldlabel = label.labeltext;
                String[] lines = label.codeSnippet.split("\n");
                int count = 0;
                if(label.lineEnd- label.lineStart == lines.length-1)
                {
                    //all good else realign labels, issue with extra missing code is simple brace on some line
                }
                else
                {
                    int newlinenum = getLineNumStringFromFile(pathofCodeSamples+"\\"+label.fileName, label.lineStart, lines[0]);
                    label.lineStart = newlinenum;
                    int diff = newlinenum - label.lineStart;
                    label.lineEnd = label.lineEnd + diff;


                }
                for(int i = label.lineStart; i <= label.lineEnd; i++)
                {
                    AuthorLabel labelcopy = new AuthorLabel(label.fileName, label.labeltext, label.codeSnippet, label.lineStart, label.lineEnd, label.charStart, label.charEnd, label.status);
                    labelcopy.setLineStart(i);
                    labelcopy.setLineEnd(i);
                    labelcopy.setCharStart(1);
                    try {
                        labelcopy.setCharEnd(lines[count].length());
                        labelcopy.setCodeSnippet(lines[count]);
                    }catch (Exception e)
                    {
                        System.out.println(e + "this is the problem" + label.fileName);


                    }
                    result.add(labelcopy);
                    count= count + 1;
                }
            }
            else
                result.add(label);
        }
        return result;
    }

    public static int getLineNumStringFromFile(String filePath, int referenceLineNumber, String targetstring) {
        //filePath = "path_to_your_java_file.java"; // Replace with the actual file path
        //int referenceLineNumber = 10; // Replace with your reference line number

        int lineNumber = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (lineNumber >= referenceLineNumber - 1 && lineNumber <= referenceLineNumber + 1) {
                    if (line.contains(targetstring)) { // Replace with your target string
                        //System.out.println("String found on line " + lineNumber + ": " + line);
                        return lineNumber;

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineNumber;
    }
    private static void parseCodeLabelObject(JSONObject label)
    {
        String fileName = (String) label.get("fileName");
        String labeltext = (String) label.get("labeltext");
        String code = (String) label.get("codeSnippet");
        Long temp = (Long) label.get("LineStart");
        int lineStart = temp.intValue();
        temp = (Long) label.get("LineEnd");
        int lineEnd = temp.intValue();
        temp = (Long) label.get("CharStart");
        int charStart = temp.intValue();
        temp = (Long) label.get("CharEnd");
        int charEnd =temp.intValue();
        String status = (String) label.get("status");

        //System.out.println(fileName);
        authonelabel = new AuthorLabel(fileName,labeltext,code,lineStart,lineEnd,charStart,charEnd,status);
        authoneLabelsList.add(authonelabel);
    }

    private static void parseotherCodeLabelObject(JSONObject label)
    {
        String fileName = (String) label.get("fileName");
        String labeltext = (String) label.get("labeltext");
        String code = (String) label.get("codeSnippet");
        Long temp = (Long) label.get("LineStart");
        int lineStart = temp.intValue();
        temp = (Long) label.get("LineEnd");
        int lineEnd = temp.intValue();
        temp = (Long) label.get("CharStart");
        int charStart = temp.intValue();
        temp = (Long) label.get("CharEnd");
        int charEnd =temp.intValue();
        String status = (String) label.get("status");

        //System.out.println(fileName);
        authtwoLabel = new AuthorLabel(fileName,labeltext,code,lineStart,lineEnd,charStart,charEnd,status);
        authtwoLabelsList.add(authtwoLabel);
    }

    public static List<AuthorLabel> resolveLabels(HashSet<AuthorLabel> labels1, HashSet<AuthorLabel> labels2) {
        ArrayList<Integer> rangeSet = new ArrayList<>();
        for (AuthorLabel label : labels1) {

            if(!rangeSet.contains(label.charStart))
                rangeSet.add(label.charStart);
            if(!rangeSet.contains(label.charEnd))
                rangeSet.add(label.charEnd);

        }
        for (AuthorLabel label : labels2) {
            if(!rangeSet.contains(label.charStart))
                rangeSet.add(label.charStart);
            if(!rangeSet.contains(label.charEnd))
                rangeSet.add(label.charEnd);
        }

        //make new sets from rangeSet

        List<AuthorLabel> resolvedLabels = new ArrayList<>();

        rangeSet.sort(Integer::compareTo);
        Object[] rangesArray = rangeSet.toArray();
        for (int i = 0; i < rangesArray.length-1; i++) {
            //System.out.println(i + ": " + namesArray[i]);
            resolvedLabels.add(new AuthorLabel("","","",0,0, (int)rangesArray[i], (int) rangesArray[i+1], ""));
        }

        //for each resolvedlabel range find value from superset range
        for(AuthorLabel resolvedlabel: resolvedLabels)
        {
            double resolvedvalue = 0;
            ArrayList<Integer> lookupValuesFromAuthorRanges = new ArrayList<>();
            //lookup new range in superset range
            for(AuthorLabel a1label: labels1)
            {
                if(resolvedlabel.charStart >= a1label.charStart && resolvedlabel.charEnd <= a1label.charEnd)
                {
                    resolvedlabel.fileName = a1label.fileName;
                    resolvedlabel.codeSnippet = a1label.codeSnippet;
                    resolvedlabel.lineStart = a1label.lineStart;
                    resolvedlabel.lineEnd = a1label.lineEnd;
                    lookupValuesFromAuthorRanges.add((int) a1label.statusNumber);
                }
            }
            for(AuthorLabel a2label: labels2)
            {
                if(resolvedlabel.charStart >= a2label.charStart && resolvedlabel.charEnd <= a2label.charEnd)
                {
                    resolvedlabel.fileName = a2label.fileName;
                    resolvedlabel.codeSnippet = a2label.codeSnippet;
                    resolvedlabel.lineStart = a2label.lineStart;
                    resolvedlabel.lineEnd = a2label.lineEnd;
                    lookupValuesFromAuthorRanges.add((int) a2label.statusNumber);
                }
            }
            if(lookupValuesFromAuthorRanges.size()==0)
            {
                //System.out.println("Found a null here");
                resolvedlabel.status = "remove";
                continue;
            }
            if(resolve_by_averages.contentEquals("True") || resolve_by_averages.contentEquals("true"))
                resolvedvalue = calculateAverage(lookupValuesFromAuthorRanges);
            //resolvedvalue = calculateAverage(lookupValuesFromAuthorRanges);
            //resolvedvalue = calculateConflictIndicator(lookupValuesFromAuthorRanges);
            else
                resolvedvalue = calculateLXStyleResolution(lookupValuesFromAuthorRanges);

            resolvedlabel.setStatusNumber(resolvedvalue);
        }
        List<AuthorLabel> preocessedresolvedLabels = new ArrayList<>();

        for(AuthorLabel resolvedlabel: resolvedLabels)
            if(!resolvedlabel.status.contentEquals("remove"))
                preocessedresolvedLabels.add(resolvedlabel);
        return preocessedresolvedLabels;
    }

    public static double calculateAverage(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty or null");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.size();
    }

    /**
     * output values for each conflict type whose counts are later grouped and analyzed in excel
     * ++ conflicts +100
     * -- conflicts -100
     * +- conflicts 555
     * >2 label values in numbers 999
     * @param numbers
     * @return
     */
    public static double calculateConflictIndicator(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty or null");
        }

        if(areAllValuesSimilar(numbers))
        {
            return 111;
        }

        else if(numbers.size() == 2)
        {
            if((numbers.get(0) > 0 && numbers.get(1) < 0) || (numbers.get(0) < 0 && numbers.get(1) > 0))
            {
                return 555;
            }
            else if (numbers.get(0) > 0 && numbers.get(1) > 0)
            {
                return 100;
            }
            else if (numbers.get(0) < 0 && numbers.get(1) < 0)
            {
                return -100;
            }

        }
        else
        {
            if(numbers.size() > 2)
            {
                return 999;
            }
        }
        return 0;


    }


    /**
     * This resolution places all conflicting similarities(one +2 and other can be +1 or -1 or -2 or 0) and noncore sims (+1) together into +1
     * and places all conflicting differences(one -2 and other can be +1 or -1 or -2 or 0) and noncore diffs (-1) together into -1
     * @param numbers
     * @return
     */
    public static double calculateLXStyleResolution(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty or null");
        }

        if(areAllValuesSimilar(numbers))
        {
            return numbers.get(0);
        }

        else
        {
            if(hasSim(numbers))
            {
                return 1.0;
            }
            else if (hasDiff(numbers))
            {
                return -1.0;
            }


        }

        return 0;


    }

    public static boolean areAllValuesSimilar(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            // Handle empty or null list as needed
            return false;
        }

        // Get the first element as the reference value
        double referenceValue = list.get(0);

        // Compare all elements with the reference value
        for (double value : list) {
            if (value != referenceValue) {
                return false; // If any value is different, return false
            }
        }

        return true; // All values are similar
    }

    public static boolean hasSim(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            // Handle empty or null list as needed
            return false;
        }

        // set reference value
        double referenceValue1 = 2.0;
        double referenceValue2 = 1.0;

        // Compare all elements with the reference value
        for (double value : list) {
            if (value == referenceValue1 || value == referenceValue2) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasDiff(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            // Handle empty or null list as needed
            return false;
        }

        // set reference value
        double referenceValue1 = -2.0;
        double referenceValue2 = -1.0;

        // Compare all elements with the reference value
        for (double value : list) {
            if (value == referenceValue1 || value == referenceValue2) {
                return true;
            }
        }

        return false;
    }
}
