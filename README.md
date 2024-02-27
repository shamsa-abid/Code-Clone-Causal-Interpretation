# Measuring Model Alignment for Code Clone Detection Using Causal Interpretation
## AI vs Human Reasoning in Semantic Code Clones

Companion website for research paper with all scripts, code, data, and results available for reproducibility.

![Methodology for Comparing Human Intuition with Model Intuition for Semantic Code Clone Detection](https://github.com/shamsa-abid/Code-Clone-Causal-Interpretation/blob/main/Figures/MethodologyFigure2.jpg?raw=true)

**Data** folder contains the original code pairs, mutated code pairs for each mutation type, and author code and clone labels json files

**Code** folder contains code for resoving code labels (IntellijIDEA Java project), and creating mutated code (Jupyter notebook)

**[CodeAndCloneAnnotationTool](CodeAndCloneAnnotationTool)** folder contains the VisualStudioCode plugin to label code as *clones* and *non-clones* and code segments as "core similarities", "non-core similarities", "core differences", and "non-core differences". Please refer to detailed RADME file inside the folder for setup and usage instructions.

**Results** folder contains the Excel files containing the causal analysis measurements 

For resolving code labels, we need the to provide the following five arguments to the CodeLabelsResolverCmd file:

- <path to code pairs>  The path to original 280 code pairs
- <path to author1labels> The path to author 1's code label annotations json file
- <path to author2labels> The path to author 2's code label annotations json file
- <True/False> The value is True if performing range-based mutations and False if performing the value-based mutations
- <output csv file> The name of the csv file containing the values of the resolved labels

```
data/code-samples data/author1labels/codelabels.json data/author2labels/codelabels.json True resolvedlabels.csv
```

## Supplementary results from second mutation strategy
https://github.com/shamsa-abid/Code-Clone-Causal-Interpretation/blob/main/Results/Value-Based%20Mutation%20Results/SupplementaryResults.pdf






