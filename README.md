# Code-Clone-Causal-Interpretation
Companion website for research paper with all scripts, code, data, and results available for reproducibility.

Data folder contains the original code pairs and mutated code pairs for each mutation type
Code folder contains code for resoving code labels (IntellijIDEA Java project), and creating mutated code (Python notebook)


For resolving code labels, we need the to provide the following five arguments to the CodeLabelsResolverCmd file:

- <path to code pairs>  The path to original 280 code pairs
- <path to author1labels> The path to author 1's code label annotations json file
- <path to author2labels> The path to author 2's code label annotations json file
- <True/False> The value is True if performing range-based mutations and False if performing the value-based mutations
- <output csv file> The name of the csv file containing the values of the resolved labels

data/code-samples data/author1labels/codelabels.json data/author2labels/codelabels.json True resolvedlabels.csv
