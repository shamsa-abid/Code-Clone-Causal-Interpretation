## Pseudocode for code labels resolution
```
// Input: Paths to JSON files containing author1 and author2 labels
// Output: Resolved labels of two authors

    // Parse JSON files
    
    author1Labels <- "path/to/author1labels.json"
    author2Labels <- "path/to/author2labels.json"    

    // Unroll the author labels lists to convert multiline label regions to single line label regions
    flatAuthor1Labels <- unroll(author1Labels)
    flatAuthor2Labels <- unroll(author2Labels)

    for each clone file
	for each line in file
		author1linelabels <- get the labels for line from flatAuthor1Labels
		author2linelabels <- get the labels for line from flatAuthor2Labels
			
                // Resolve labels
                finalresolvedLabels <- resolveLabels(author1linelabels, author2linelabels)

    // Output: Resolved labels of two authors
    return finalresolvedLabels


Algorithm: resolvelabels
// Input: Line labels of author1 and author2
// Output: Resolved labels of two authors for one line 
    resolvedLineLabels <- [] 
    //define new label ranges based on collective charstart and charend positions in author1linelabels and author2linelabels
    labelrangeset <- getUniqueCharStartEndPositions(author1linelabels, author2linelabels) 

    for each labelrange in labelrangeset
	lookupValuesFromAuthorRanges <- []
        resolvedLabel <- null 
        
        for each author1linelabel in authour1linelabels
		if labelrange within authour1linelabel 
                        setProperties(resolvedLabel <-  labelrange)
			lookupValuesFromAuthorRanges <- author1linelabel.value
	for each author2linelabel in authour2linelabels
		if labelrange within authour2linelabel
                        setProperties(resolvedLabel <-  labelrange)                        
			lookupValuesFromAuthorRanges <- author2linelabel 	
    
        resolvedLabelValue <- calculateAverage(lookupValuesFromAuthorRanges)
        resolvedLabel.value <- resolvedLabelValue    
    	add(resolvedLineLabels <- resolvedLabel)
    
    return resolvedLineLabels
```
