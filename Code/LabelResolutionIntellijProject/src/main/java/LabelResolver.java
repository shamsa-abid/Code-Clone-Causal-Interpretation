import java.util.*;



public class LabelResolver {
    public static List<Label> resolveLabels(List<Label> labels1, List<Label> labels2) {
        Set<Integer> rangeSet = new HashSet<>();
        for (Label label : labels1) {

                rangeSet.add(label.start);
                rangeSet.add(label.end);

        }
        for (Label label : labels2) {
            rangeSet.add(label.start);
            rangeSet.add(label.end);
        }

        //make new sets from rangeSet

        List<Label> resolvedLabels = new ArrayList<>();
        Object[] rangesArray = rangeSet.toArray();
        for (int i = 0; i < rangesArray.length-1; i++) {
            //System.out.println(i + ": " + namesArray[i]);
            resolvedLabels.add(new Label((int)rangesArray[i], (int) rangesArray[i+1], 0));
        }

        //for each resolvedlabel range find value from superset range
        for(Label resolvedlabel: resolvedLabels)
        {
            double resolvedvalue = 0;
            ArrayList<Integer> lookupValuesFromAuthorRanges = new ArrayList<>();
            //lookup new range in superset range
               for(Label a1label: labels1)
               {
                   if(resolvedlabel.start >= a1label.start && resolvedlabel.end <= a1label.end)
                   {
                           lookupValuesFromAuthorRanges.add((int) a1label.value);
                   }
               }
            for(Label a2label: labels2)
            {
                if(resolvedlabel.start >= a2label.start && resolvedlabel.end <= a2label.end)
                {
                    lookupValuesFromAuthorRanges.add((int) a2label.value);
                }
            }
            resolvedvalue = calculateAverage(lookupValuesFromAuthorRanges);
            resolvedlabel.value = resolvedvalue;
        }

        return resolvedLabels;
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
    public static void main(String[] args) {
        // Example input labels
        List<Label> labels1 = new ArrayList<>(Arrays.asList(
                new Label(1, 8, 2.0),
                new Label(9, 10, 1.0)
        ));

        List<Label> labels2 = new ArrayList<>(Arrays.asList(
                new Label(1, 4, 2.0),
                new Label(5, 6, 1.0),
                new Label(7, 10, 1.0)
        ));

        List<Label> resolvedLabels = resolveLabels(labels1, labels2);

        // Print resolved labels
        for (Label label : resolvedLabels) {
            System.out.println("Start: " + label.start + " | End: " + label.end + " | Value: " + label.value);
        }
    }
}
